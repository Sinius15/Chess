package sinius.chess.client;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.UIManager;

import sinius.chess.client.engine.Display;
import sinius.chess.client.engine.Engine;
import sinius.chess.client.state.menu.MenuState;

public class Game {

	public static Board board;
	
	public static Display display;
	
	public static Color black = new Color(209, 139, 71);
	public static Color white = new Color(255, 206, 158);
	public static Color black_selected = Color.red;
	public static Color white_selected = Color.red;
	public static File mainFolder;;
	
	public static PImage baseImage;
	
	public static Engine engine;
	
	public static void init(){
		try {
			System.out.println(new File(mainFolder.getAbsolutePath() + "//rec//pieces.png").getAbsolutePath());
			baseImage = new PImage(ImageIO.read(new File(mainFolder.getAbsolutePath() + "//rec//pieces.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		board = new Board(new File(mainFolder.getAbsolutePath() + "//rec//startGame.chess"));
		display = new Display(400, 450, "Sinis Chess", new MenuState(), UIManager.getColor("Panel.background"));
		engine = new Engine();
	}
	
	public static void onTick(){
		board.cleanSelected();
		board.setSelected();
		checkSpecial.Start();
		display.onTick();
	}
	
	public static void color(int x, int y){
		board.selected[y][x] = true;
	}

	
}
