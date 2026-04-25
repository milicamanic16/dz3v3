package dz3v3;

import java.awt.*;

public class Cigla extends AktivnaFigura {

	private int height;
	private int width;
	
	private boolean hit;
		
	Cigla(Scena scena, double x, double y, int width,int height, int ms) {
		super(scena, x, y, Color.RED, ms);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(color);
		if(hit) g.setColor(Color.GRAY);
		g.fillRect(((int)getX())-width/2, ((int)getY())-height/2, width, height);
				
	}
		
	@Override
	public void destroy() {		
		interrupt();
		scena.removeFigure(this);
	}

	@Override
	public void move() {
		if(hit) {
			setY(getY() + 5);
			if(getY() > scena.getPreferredSize().height)
				destroy();
		}
		if(scena.term()) {
			destroy();
		}
	}
	
	public void pogodi() {
		hit = true;
		enable();
	}
	@Override
	public char getOznaka() {
		return 'C';
	}
	public boolean isHit() {
		return hit;
	}
	public int getHeight() {
		return height;
	}	
	public int getWidth() {
		return width;
	}

}
