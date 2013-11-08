package sinius.chess.server;

public class InputHandler {

	public static void handleInput(String in){
		if(in.equals("")) 
			return;
		Main.gui.userMessage(in);
		
	}
	
}
