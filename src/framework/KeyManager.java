package framework;
import java.awt.event.*;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean w, a, s, d;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void update(){
		w = keys[KeyEvent.VK_W];
		a = keys[KeyEvent.VK_A];
		s = keys[KeyEvent.VK_S];
		d = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("Key Pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
