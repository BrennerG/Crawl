package abstractEntities;

public abstract class LifeForm extends Entity{

	public static final int DEFAULT_HP = 20;
	public static final float DEFAULT_SPEED = 3.0f;
	protected static final int DEFAULT_SIZE = 32;
	
	protected int hp;
	protected float xMove, yMove;
	protected float speed;
	
	public LifeForm( float x, float y, int width, int height ) {
		super(x, y, width, height);
		this.speed = DEFAULT_SPEED;
		this.hp = DEFAULT_HP;
		this.xMove = 0;
		this.yMove = 0;
	}
	
	public void move(){
		x += xMove;
		y += yMove;
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
	
	
}