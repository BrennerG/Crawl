package framework;
import model.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {

	private Display display;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	private BufferedImage testImage;
	
	public String title;
	public int width, height;
	private boolean running = false;
	private int fps = 30;
	
	int x = 5;
	
	public Game( String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void init(){
		display = new Display( title, width, height );
		Assets.init();
	}
	
	private void update(){
		
		x++;
	}
	
	private void render(){
	
		bs = display.getCanvas().getBufferStrategy();
			if( bs == null ){	
				display.getCanvas().createBufferStrategy(1);
				return;
			}
			
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		g.setColor( Color.white );
		g.fillRect(0, 0, width, height);
		//DRAW HERE!
			
			g.drawImage(Assets.blob, x, 10, 50, 50, null);
		
		//END
		bs.show();
		g.dispose();
	}
	
	public void run(){
		init();
		double timepertick = 1000000000 / fps;
		long now;
		double delta = 0;
		long last = System.nanoTime();
		
		while( running ){
					
			now = System.nanoTime();
			delta += ( now - last ) / timepertick;
			last = now;
			
			if( delta >= 1  ){
				update();
				render();
				delta--;
			}
		}
	}
	
	public synchronized void start(){
		if( running == true )
			return; 
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if( running == false )
			return; 
		running = false;
		try{
			thread.join();
		} catch( InterruptedException e ){
			e.printStackTrace();
		}
	}
}