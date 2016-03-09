package entities;

import framework.Game;
import model.Assets;
import java.awt.Graphics;

import abstractEntities.LifeForm;
import abstractEntities.Projectile;


public class Fireball extends Projectile {
	
	Fireball( Game game, LifeForm entity, int directionX, int directionY ){
			super( game, entity.getX(), entity.getY(), Projectile.DEFAULT_SIZE, Projectile.DEFAULT_SIZE );
			switch( entity.getDirection() ){
			case 1: xMove = 0;
					yMove = -Projectile.DEFAULT_SPEED;
				break;
			case 2: xMove = -Projectile.DEFAULT_SPEED;
					yMove = 0; 
				break;
			case 3: xMove = 0;
					yMove = Projectile.DEFAULT_SPEED;
				break;
			case 4: xMove = Projectile.DEFAULT_SPEED;
					yMove = 0; 
				break;
			}
	}

	@Override
	public void update() {
		move();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage( Assets.blob, (int)x, (int)y, width, height, null );
	}
	
	@Override
	public void collisionAction() {
	
	}
	
}
