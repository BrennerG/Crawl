package framework;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage( String path ){
		try {			
			return ImageIO.read(ImageLoader.class.getResource(path) );
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
	
	public static BufferedImage getSprite( String path, int slot ) throws IllegalArgumentException {
	
		if( (slot < 0) || (slot > 15))
			throw new IllegalArgumentException();
		
		BufferedImage sheet = loadImage( path );
			if( sheet == null )
				throw new IllegalArgumentException();
		
		switch( slot ){
			case 0: return sheet.getSubimage(0, 0, 32, 32);
			case 1: return sheet.getSubimage(33, 0, 32, 32);
			case 2: return sheet.getSubimage(66, 0, 32, 32);
			case 3: return sheet.getSubimage(98, 0, 32, 32);
			case 4: return sheet.getSubimage(0, 33, 32, 32);
			case 5: return sheet.getSubimage(33, 33, 32, 32);
			case 6: return sheet.getSubimage(66, 33, 32, 32);
			case 7: return sheet.getSubimage(98, 33, 32, 32);
			case 8: return sheet.getSubimage(0, 66, 32, 32);
			case 9: return sheet.getSubimage(33, 66, 32, 32);
			case 10: return sheet.getSubimage(66, 66, 32, 32);
			case 11: return sheet.getSubimage(98, 66, 32, 32);
			case 12: return sheet.getSubimage(0, 98, 32, 32);
			case 13: return sheet.getSubimage(33, 98, 32, 32);
			case 14: return sheet.getSubimage(66, 98, 32, 32);
			case 15: return sheet.getSubimage(98, 98, 32, 32);
			default: return null;
		}
	}
}