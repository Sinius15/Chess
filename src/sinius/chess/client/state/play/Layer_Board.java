package sinius.chess.client.state.play;

import java.awt.Graphics2D;

import sinius.chess.client.Game;
import sinius.chess.client.state.GrapicsLayer;

public class Layer_Board implements GrapicsLayer{

	@Override
	public String getName() {
		return "Board Layer";
	}

	@Override
	public void Draw(Graphics2D graphics) {
		graphics.setColor(Game.white);
        for(int row = 0; row<=8;row++){
        	for(int colom = 0; colom <= 8; colom++){
        		graphics.fillRect(colom*50, row*50, 50, 50);
        		if(graphics.getColor().equals(Game.white)){
        			graphics.setColor(Game.black);
	        	}else{
	        		graphics.setColor(Game.white);
	        	}
        	}
        }
	}

	@Override
	public int priority() {
		return 0;
	}

	@Override
	public boolean drawAfter() {
		return false;
	}
	
	public static boolean isFieldWhite(){
		
		
		
		
		
		return true;
	}

}
