package dz3v3;

import java.awt.*;


public class Loptica extends AktivnaFigura {

	private int r;
	private double brzina;
	private int periodCount;
	private double pomerajX;
	private double pomerajY;
	
	Loptica(Scena scena, double d, double e, int radius, int ms) {	
		
		super(scena, d, e, Color.GREEN, ms);
		this.setR(radius);
		brzina = Math.random();
		
		pomerajX = brzina*2-1;
		pomerajY = -brzina;
		
	}
	
	private void ovarlapCigla() {
		for(int i = 0; i<scena.getCount();i++) {
			Figura f = scena.getFigura(i);
			if(f instanceof Cigla) {
				Cigla c = ((Cigla) f);
				if(!c.isHit()) {
					if( getY() < c.getY()+c.getHeight()/2 ) {
						if(getX()> c.getX()-c.getWidth()/2 && getX() < c.getX()+ c.getWidth()/2 ) {
							c.pogodi();
							pomerajY = -pomerajY;
						}
					}	
				}
								
			}			
		}		
	}
	@Override
	public void draw(Graphics g) {

		g.setColor(color);
		g.fillOval(((int)getX())-r/2, ((int)getY())-r/2, r, r);
	
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public char getOznaka() {
		return 'L';
	}

	@Override
	public void move() {		
			
		if(periodCount%100 == 0) { // ovo nije ispravno --> menja ugao
			brzina*=1.1;
		}		
		if(periodCount%100 == 0) {
			pomerajX*=1.1;
			pomerajY*=1.1;
		}
		
		ovarlapCigla();
		hitEdge();
		hitIgrac();
		
		setY((getY() + pomerajY));
		setX((getX() + pomerajX));
		periodCount++;
		if(scena.term()) {
			interrupt();
		}
		
	}

	private void hitEdge() {

		if(getX()-r/2 <= 0 || getX()+r/2 >= scena.getPreferredSize().width) {
			pomerajX = -pomerajX;
		}			
		if(getY()-r/2 <= 0) {
			pomerajY = -pomerajY;
		}			
		if(getY() >= scena.getPreferredSize().height) {
			destroy();
		}
	}


	private void hitIgrac() {

		for(int i = 0; i<scena.getCount();i++) {
			if(scena.getFigura(i) instanceof Igrac) {
				Igrac ig = ((Igrac) scena.getFigura(i));
				if( getY() > ig.getY() - r/2 - ig.getHeight()/2 && getX() <= ig.getX()+ig.getWidth()/2 && getX() >= ig.getX()-ig.getWidth()/2) {
					pomerajY = -pomerajY;
					System.out.println("udarila igraca");
				}
			}
		}
	}


	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

}
