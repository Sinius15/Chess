package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Main;
import sinius.chess.Piece;

public class WhiteBishop implements Piece {

	@Override
	public File getImg() {
		return new File("rec/Bishop_white.png");
	}


	@Override
	public int nr() {
		return 5;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		for(int i = 1; i<8; i++){
			if(!doall(x+i,y+i))
				break;
		}
		for(int i = 1; i<8; i++){
			if(!doall(x-i,y-i))
				break;
		}
		for(int i = 1; i<8; i++){
			if(!doall(x-i,y+i))
				break;
		}
		for(int i = 1; i<8; i++){
			if(!doall(x+i,y-i))
				break;
		}
		return;
	}
	
	private boolean doall(int x, int y){
		if(x<0 || x>7 || y<0 || y>7){
			return false;
		}
		if(Main.board.pieces[x][y].nr() == 0){
			Main.color(x, y);
			return true;
		}else{
			if(Main.board.getColor(x, y) == 2){
				Main.color(x, y);
				return false;
			}
		}
	    return false;
	}


}
