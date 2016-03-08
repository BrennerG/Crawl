package abstractEntities;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import framework.Game;


public abstract class Entity {
	
	protected float x,y;
	protected int width, height;
	protected Rectangle hitbox;
	protected Game game;

	public Entity( Game game, float x, float y, int width, int height ){
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hitbox = new Rectangle( 0, 0, width, height );
	}
	
	public abstract void update();
	public abstract void render( Graphics g);
	
	public boolean checkEntityCollisions( float xOffset, float yOffset ){
		for( Entity ent : game.getEntityManager() ){
			if(ent.equals(this))
				continue;
			if(ent.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
				System.out.println("collided!");
				return true;
			}
		}
		return false;
	}
	
	public Rectangle getCollisionBounds( float xOffset, float yOffset ){
		return new Rectangle( (int)(x + hitbox.x + xOffset), (int)(y + hitbox.y + yOffset), hitbox.width, hitbox.height );
	}
	
///GETTERS SETTERS
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Rectangle getHitbox(){
		return this.hitbox;
	}
}
