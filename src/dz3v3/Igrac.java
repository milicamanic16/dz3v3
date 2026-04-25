package dz3v3;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {

	private int height;
	private int width;
	private int pomeraj;
	
	Igrac(Scena scena,int w, int h) {
		
		super(scena, scena.getPreferredSize().width/2,scena.getPreferredSize().height - 20, Color.BLUE);
		this.height = h;
		this.width = w;
		
	}
	
	@Override
	public void draw(Graphics g) {

		g.setColor(color);
		g.fillRect(((int)getX())-getWidth()/2, ((int)getY())-getHeight()/2, getWidth(), getHeight());
	}

	@Override
	public char getOznaka() {
		return 'I';
	}

	@Override
	public void move() {

		if(pomeraj<0) {
			if(getX() > width/2)
				setX(getX()+pomeraj);
		}
		else {
			if(getX() < scena.getPreferredSize().width-width/2)
				setX(getX()+pomeraj);
		}
	}

	public void setPom(int p) {
		pomeraj = p;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

}
