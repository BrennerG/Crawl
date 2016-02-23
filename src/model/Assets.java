package model;
import framework.*;
import java.awt.image.BufferedImage;


public class Assets {

	public static BufferedImage stranger, blob;
	public static final String testSpriteSheet = "/Sprites1.png";
	
	public static void init(){
	
		blob = ImageLoader.getSprite(testSpriteSheet, 0);
		stranger = ImageLoader.getSprite(testSpriteSheet, 1);
	}
}
