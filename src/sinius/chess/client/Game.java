package sinius.chess.client;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game {

	public static Gui gui;
	public static Board board;
	
	public static Color black = new Color(209, 139, 71);
	public static Color white = new Color(255, 206, 158);
	public static Color black_selected = Color.red;
	public static Color white_selected = Color.red;
	
	public static PImage baseImage;
	
	public static void init(){
		try {
			baseImage = new PImage(ImageIO.read(new File("rec/pieces.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		board = new Board(new File("rec/startGame.chess"));
		gui = new Gui();
	}
	
	public static void updateAll(){
		gui.drawBoard();
		board.cleanSelected();
		board.setSelected();
		gui.drawSelected();
		gui.drawPieces();
		gui.frame.repaint();
		checkSpecial.Start();
	}
	
	public static void color(int x, int y){
		board.selected[y][x] = true;
	}

	
}
