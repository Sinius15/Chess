package sinius.chess;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Main {

	public static Gui gui;
	public static Board board;
	
	public static Color black = new Color(209, 139, 71);
	public static Color white = new Color(255, 206, 158);
	public static Color black_selected = new Color(159, 139, 71);
	public static Color white_selected = new Color(205, 206, 158);
	
	public static void main(String[] args) {
		gui = new Gui();
		board = new Board(new File("rec/startGame.chess"));
		updateAll();
	}
	
	public static void updateAll(){
		gui.drawBoard();
		board.cleanSelected();
		board.setSelected();
		gui.drawSelected();
		try {
			gui.drawPieces();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void color(int x, int y){
		board.selected[y][x] = true;
	}

}
