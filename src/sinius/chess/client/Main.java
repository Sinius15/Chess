package sinius.chess.client;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import sinius.chess.common.shah.Message;

public class Main {

	public static Gui gui;
	public static Board board;
	
	public static Color black = new Color(209, 139, 71);
	public static Color white = new Color(255, 206, 158);
	public static Color black_selected = Color.red;
	public static Color white_selected = Color.red;
	
	public static boolean canPlay;
	
	public static int id;
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
		ImageLoader.init();
		
		board = new Board(new File("rec/startGame.chess"));
		gui = new Gui();
		updateAll();
		updateAll();
		
		//internet 
        String hostName = "37.251.48.220";
        int portNumber = 4444;

        Socket socket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	
    	Thread t = new Thread(new Runnable() {@Override public void run() {
			String fromServer;
			try {
				while ((fromServer = in.readLine()) != null) {
					Message msg = Message.decode(fromServer);
					if(msg.type.equals("id")){
						id = Integer.parseInt(msg.message);
						return;
					}
						
				}
			}catch (IOException e) { }
		}}, "reader");
		t.start();
		
		
		
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
