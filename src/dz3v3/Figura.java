package dz3v3;

import java.awt.*;

public abstract class Figura {

	private double x;
	private double y;  // koordinate CENTRA
	Color color;
	Scena scena;
	
	Figura(Scena sc,double x2, double y2, Color boja){	
		this.color = boja;
		this.x = x2;
		this.y = y2;
		this.scena = sc;
		scena.addFigure(this);		
	}
	
	public abstract void draw(Graphics g);
	
	public void destroy() {
		scena.removeFigure(this);
	}
	
	public abstract char getOznaka();
	
	public abstract void move() ;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
