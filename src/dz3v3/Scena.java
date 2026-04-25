package dz3v3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Scena extends Canvas {

	private ArrayList<Figura> figure = new ArrayList<Figura>();
	private int count;
	private boolean t;
	
	public void addListeners() {
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					
					Loptica l = new Loptica(Scena.this, getIgrac().getX(), getIgrac().getY() - getIgrac().getHeight()/2-5 , 10, 10);					
					l.enable();
					repaint(); 

				}
			}
		});		

		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_LEFT){
					if(getIgrac()!=null) {
						getIgrac().setPom(-10);
						getIgrac().move();
						repaint();
					}	
				}
					
				if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
					if(getIgrac()!=null) {
						getIgrac().setPom(10);
						getIgrac().move();
						repaint();
					}	
				}
			}
			
		});
	}
	
	public boolean term() {return t;}
	private synchronized Igrac getIgrac() {
		for(int i = 0; i< figure.size(); i++) {
			if(getFigura(i)instanceof Igrac) {
				return (Igrac) getFigura(i);
			}
		}
		return null;
	}

	public Scena(){
		
		addListeners();
		setPreferredSize(new Dimension(406,500));	
		repaint();
				
	}

	public synchronized void  addFigure(Figura figura) {
		figure.add(figura);
		count++;
		repaint();
	}


	@Override
	public synchronized void paint(Graphics g) {
		for(Figura f: figure)	
			f.draw(g);
	}
	
	public synchronized Figura getFigura(int i) {
		if(i<figure.size()) {
			if(figure.get(i) != null)
				return figure.get(i);
		}		
		return null;
	}

	public synchronized void removeFigure(Figura figura) {
		figure.remove(figura);
		//System.out.println(figure.size() + " uklonjeno: " + figura.getOznaka());
		repaint();
	}

	public synchronized void startScene() {
		for(int i = 0; i< figure.size(); i++) {
			if(getFigura(i) instanceof AktivnaFigura) {
				if(getFigura(i).getOznaka() != 'L')
					((AktivnaFigura) getFigura(i)).enable();
			}				
		}
	}

	public synchronized void terminate() {
		t = true;
		System.out.println("usao u terminate");
		for(Figura f: new ArrayList<>(figure)) {
			
			if (f instanceof AktivnaFigura) {
				((AktivnaFigura)f).interrupt();;
			}		
		}			
	}

	public synchronized int getCount() {
		return count;
	}


}
