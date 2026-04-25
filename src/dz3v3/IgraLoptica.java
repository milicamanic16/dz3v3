package dz3v3;

import java.awt.*;
import java.awt.event.*;

public class IgraLoptica extends Frame {

	private Scena scena = new Scena();
	
	public IgraLoptica(){
		
		super("Loptica");
		addComponents();
		setLocation(500, 400);
		pack();
		requestFocus();
		addListeners();
		//scena.startScene();
		setResizable(false);
		setVisible(true);
		repaint();

		
	}
	
	//dodavanje igraca
	//levo desno
	//loptica
	
	private void addComponents() {	
		
		new Igrac(scena,60,20);
		
		int w = (scena.getPreferredSize().width-6)/5;
		int h = 20;
		
		new Cigla(scena, w/2+1, 11, w, h, 50);
		new Cigla(scena, w/2*3+2, 11, w, h, 50);
		new Cigla(scena, w/2*5+3, 11, w, h, 50);
		new Cigla(scena, w/2*7+4, 11, w, h, 50);
		new Cigla(scena, w/2*9+5, 11, w, h, 50);
		new Cigla(scena, w/2+1, 32, w, h, 50);
		new Cigla(scena, w/2*3+2, 32, w, h, 50);
		new Cigla(scena, w/2*5+3, 32, w, h, 50);
		new Cigla(scena, w/2*7+4, 32, w, h, 50);
		new Cigla(scena, w/2*9+5, 32, w, h, 50);
		new Cigla(scena, w/2+1, 53, w, h, 50);
		new Cigla(scena, w/2*3+2, 53, w, h, 50);
		new Cigla(scena, w/2*5+3, 53, w, h, 50);
		new Cigla(scena, w/2*7+4, 53, w, h, 50);
		new Cigla(scena, w/2*9+5, 53, w, h, 50);
		
		add(scena);
		
	}
	
	private void addListeners() {
		addWindowListener(new WindowAdapter() {		
			@Override
			public void windowClosing(WindowEvent e) {			
				scena.terminate();
				dispose();
				
			}
		});	
	}

	
	public static void main(String[] args) {
		new IgraLoptica();
	}
}
