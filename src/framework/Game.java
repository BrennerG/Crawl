package framework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
//import java.awt.image.BufferedImage;
//import java.awt.Graphics;
//import java.awt.image.BufferStrategy;

import model.Assets;
import abstractEntities.EntityManager;
import abstractEntities.Player;
import entities.*;


public class Game implements Runnable {

	public String title;
	public int width, height;
	private boolean running = false;
	private int fps = 30;
	
	private Display display;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	KeyManager keys;
	
	private Player player = new Player( this, 300f, 200f );
	private EntityManager entMan = new EntityManager(this);
	
	public Game( String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keys = new KeyManager();
	}

	private void init(){
		display = new Display( title, width, height );
		display.getFrame().addKeyListener(keys);
		Assets.init();	
		//entMan.adds NOCH here
			entMan.add(new StaticDummy(this, 600f, 250f));
	}
	
	private void update(){
		keys.update();
		entMan.update();
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

			entMan.render(g);
		
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

///GETTERS / SETTERS
	
	public KeyManager getKeyManager() {
		return keys;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public EntityManager getEntityManager(){
		return this.entMan;
	}
}