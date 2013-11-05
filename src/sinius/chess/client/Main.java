package sinius.chess.client;

import java.awt.Color;
import java.io.File;

public class Main {

	public static Gui gui;
	public static Board board;
	
	public static Color black = new Color(209, 139, 71);
	public static Color white = new Color(255, 206, 158);
	public static Color black_selected = Color.red;
	public static Color white_selected = Color.red;
	
	public static boolean canPlay;
	
	public static void main(String[] args) {
		ImageLoader.init();
		gui = new Gui();
		board = new Board(new File("rec/startGame.chess"));
		updateAll();
	}
	
	public static void updateAll(){
		gui.drawBoard();
		board.cleanSelected();
		board.setSelected();
		gui.drawSelected();
		gui.drawPieces();
		checkSpecial.Start();
		gui.frame.canvas.repaint();
		gui.frame.canvas.paint(gui.graphics);
	}
	
	public static void color(int x, int y){
		board.selected[y][x] = true;
	}

}
