package dz3v3;

import java.awt.*;

public abstract class AktivnaFigura extends Figura implements Runnable {

	
	protected Thread thread = new Thread(this);
	protected int period;

	AktivnaFigura(Scena scena, double x, double y, Color boja, int ms) {
		super(scena, x, y, boja);
		this.period = ms;
		//thread.start();  ---> probaj u konstruktoru cigle i loptice
	}

	@Override
	public void run() {

		
		while(!Thread.interrupted()) {
//			if(scena.term()) {
//				//thread.interrupt();
//				destroy();
//			}
			try {		
				Thread.sleep(period);
				move();
				scena.repaint();				
			} catch (InterruptedException e) {}
			
		}
		System.out.println("Run prekinut - kraj " + getOznaka());
	}
	
	@Override
	public void destroy() {
		interrupt();
		//scena.removeFigure(this);
		super.destroy();
	}

	public void enable() {
		thread.start();
	}
	
	public synchronized void interrupt() {
		if(thread!=null) {
			this.thread.interrupt();	
		}
				
	}

}
