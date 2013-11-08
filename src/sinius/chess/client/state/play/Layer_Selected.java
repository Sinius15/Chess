package sinius.chess.client.state.play;

import java.awt.Color;
import java.awt.Graphics2D;

import sinius.chess.client.Game;
import sinius.chess.client.state.GrapicsLayer;

public class Layer_Selected implements GrapicsLayer{

	@Override
	public String getName() {
		return "Selected Layer";
	}

	@Override
	public void Draw(Graphics2D graphics) {
		for(int x = 0; x<8;x++){
        	for(int y = 0; y < 8; y++){
        		if(Game.board.selected[y][x]){
        			graphics.setColor(Color.pink);
        			graphics.fillRect(x*50, y*50, 50, 50);
        			
        		}
        		
        	}
        }
	}

	@Override
	public int priority() {
		return 1;
	}

	@Override
	public boolean drawAfter() {
		return false;
	}

}
