package entities;
import java.awt.Graphics;
import abstractEntities.LifeForm;
import model.Assets;

public class StaticDummy extends LifeForm {
	
	public StaticDummy( float x, float y ){
		super( x, y, DEFAULT_SIZE, DEFAULT_SIZE );
		speed = 0.5f;
	}

	public void update() {
		move();
	}

	public void render(Graphics g) {
		g.drawImage( Assets.blob, (int)x, (int)y, DEFAULT_SIZE, DEFAULT_SIZE, null);
	}
}
