package sinius.chess.client;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static PImage baseImage;
	
	public static void init(){
		try {
			baseImage = new PImage(ImageIO.read(new File("rec/pieces.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
