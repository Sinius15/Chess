package sinius.chess.client.state.play;

import java.awt.Graphics2D;

import sinius.chess.client.Game;
import sinius.chess.client.state.GrapicsLayer;
import sinius.chess.common.pieces.Piece;

public class Layer_Pieces implements GrapicsLayer{

	@Override
	public String getName() {
		return "Pieces Layer";
	}

	@Override
	public void Draw(Graphics2D graphics) {
		for(int x = 0; x<8; x++){
			for(int y = 0;y<8;y++){
				Piece p = Game.board.pieces[x][y];
				if(p.nr() == 0){
					continue;
				}
				graphics.drawImage(p.getImg(), x*50, y*50, null);				
				
			}
		}
	}

	@Override
	public int priority() {
		return 2;
	}

	@Override
	public boolean drawAfter() {
		return false;
	}

}
