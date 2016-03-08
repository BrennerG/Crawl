package abstractEntities;

import java.awt.Graphics;
import java.util.ArrayList;
import framework.Game;

public class EntityManager extends ArrayList<Entity> {

	private static final long serialVersionUID = 1L;
	private Game game;
	private Player player;
	
	public EntityManager( Game game ){
		this.game = game;
		this.player = game.getPlayer();
		add( player );
	}
	
	public void update(){
		for( Entity ent : this )
			ent.update();
	}
	
	public void render( Graphics g ){
		for( Entity ent : this )
			ent.render(g);
	}
}