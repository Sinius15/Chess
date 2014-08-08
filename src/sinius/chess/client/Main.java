package sinius.chess.client;

import java.io.File;
import java.io.IOException;

public class Main {
	
	public static int id;
	
	public static void main(String[] args) throws IOException {
		ArgumentsReader read = new ArgumentsReader(args);
		Game.mainFolder = new File(read.getValue("dataFolder"));
		Game.init();
		
	}
	


}
