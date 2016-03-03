package abstractEntities;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import framework.Game;
import model.Assets;

public class Player extends LifeForm {

	public static final int DEFAULT_HEALTH = 50;
	public static final float DEFAULT_SPEED = 4.0f;
	public static final int DEFAULT_SIZE = 40;
	
	private Game game;
	
	public Player( Game game, float x, float y ){
		super( x, y, DEFAULT_SIZE, DEFAULT_SIZE );
		this.game = game;
	}

	@Override
	public void update() {
		getInput();
		move();
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage( Assets.stranger, (int)x, (int)y, DEFAULT_SIZE, DEFAULT_SIZE, null);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if( game.getKeyManager().w )
			yMove -= speed;
		if( game.getKeyManager().a )
			xMove -= speed;
		if( game.getKeyManager().s )
			yMove += speed;
		if( game.getKeyManager().d )
			xMove += speed;
	}
}