package abstractEntities;

import framework.Game;

public abstract class LifeForm extends Entity{

	public static final int DEFAULT_HP = 20;
	public static final float DEFAULT_SPEED = 3.0f;
	protected static final int DEFAULT_SIZE = 32;
	
	protected int hp;
	protected float xMove, yMove;
	protected float speed;
	protected int direction = 0;	//1=W, 2=A, 3=S, 4=D
	
	public LifeForm( Game game, float x, float y, int width, int height ) {
		super( game, x, y, width, height);
		this.speed = DEFAULT_SPEED;
		this.hp = DEFAULT_HP;
		this.xMove = 0;
		this.yMove = 0;
	}
	
	public void move(){
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f,yMove))
			moveY();
	}
	
	public void moveX(){
		x += xMove;
	}
	
	public void moveY(){
		y += yMove;
	}
	
	protected boolean collisionWith(){
		return false;
	}
	
/// GETTERS SETTERS
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public int getDirection(){ return this.direction; }
	public void setDirection( int a ){ this.direction = a; }

}