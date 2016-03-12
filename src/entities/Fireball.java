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
	
	public Fireball( Game game, LifeForm entity ){
		super( game, entity.getX(), entity.getY(), Projectile.DEFAULT_SIZE, Projectile.DEFAULT_SIZE );
		//Feuerball in die richtige Richtung ausrichten
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
		
		//Feuerball am richtigen ort spawnen
		switch( entity.getDirection() ){
		case 1: 
				x = entity.getX();
				y = entity.getY() - Projectile.DEFAULT_SIZE - entity.DEFAULT_SPEED;
			break;
		case 2: 
				x = entity.getX() - Projectile.DEFAULT_SIZE + entity.DEFAULT_SPEED;
				y = entity.getY();
			break;
		case 3:
				x = entity.getX();
				y = entity.getY() + this.DEFAULT_SIZE + this.DEFAULT_SPEED;
			break;
		case 4:
				x = entity.getX() + this.DEFAULT_SIZE;
				y = entity.getY();
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
