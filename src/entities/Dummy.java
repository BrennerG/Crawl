package entities;
import java.awt.Graphics;
import abstractEntities.LifeForm;
import framework.Game;
import model.Assets;

public class Dummy extends LifeForm {

	private float startY;
	
	public Dummy( Game game, float x, float y ){
		super( game, x, y, DEFAULT_SIZE, DEFAULT_SIZE );
		speed = 0.5f;
		startY = y;
	}

	public void update() {
		walkingPattern();
		move();
	}

	public void render(Graphics g) {
		g.drawImage( Assets.blob, (int)x, (int)y, DEFAULT_SIZE, DEFAULT_SIZE, null);
	}
	
	private void walkingPattern(){
		if( y<startY-50 ){
			//yMove = 0;
			yMove += speed;
			System.out.println(y);
		}
		else{
			//yMove = 0;
			yMove -= speed;
			System.out.println(y);
		}
	}
}
