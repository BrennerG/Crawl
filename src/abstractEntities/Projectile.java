package abstractEntities;
import framework.Game;
public abstract class Projectile extends Entity  {

	public static int DEFAULT_SIZE = 10;
	public static float DEFAULT_SPEED = 6.0f;
	
	protected float xMove, yMove;
	protected float speed;
	
	public Projectile( Game game, float x, float y, int width, int height ){
		super( game, x, y, width, height );
		this.xMove = 0;
		this.yMove = 0;
		speed = DEFAULT_SPEED;	
	}
	
	public abstract void collisionAction();
	
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
}
