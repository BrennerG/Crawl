package abstractEntities;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entities.Fireball;
import framework.Game;
import model.Assets;

public class Player extends LifeForm {

	public static final int DEFAULT_HEALTH = 50;
	public static final float DEFAULT_SPEED = 4.0f;
	public static final int DEFAULT_SIZE = 40;
	
	public Player( Game game, float x, float y ){
		super( game,x, y, DEFAULT_SIZE, DEFAULT_SIZE );
		this.hitbox.x = 0;
		this.hitbox.y = 0;
		this.hitbox.width = DEFAULT_SIZE;
		this.hitbox.height = DEFAULT_SIZE;
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
		
		if( game.getKeyManager().w ){
			yMove -= speed;
			direction = 1;
		}
		if( game.getKeyManager().a ){
			xMove -= speed;
			direction = 2;
		}
		if( game.getKeyManager().s ){
			yMove += speed;
			direction = 3;
		}
		if( game.getKeyManager().d ){
			xMove += speed;
			direction = 4;
		}
		if( game.getKeyManager().space ){
			shootFireball();
		}
	}
	
	private void shootFireball(){
			game.getEntityManager().add( new Fireball( game, this ) );
	}

///GETTERS SETTERS


}