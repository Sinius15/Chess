package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Main;
import sinius.chess.Piece;

public class WhiteKing  implements Piece{

	@Override
	public File getImg() {
		return new File("rec/King_white.png");
	}


	@Override
	public int nr() {
		return 11;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		if(canGo(x+1, y)) Main.color(x+1, y);
		if(canGo(x-1, y)) Main.color(x-1, y);
		if(canGo(x, y+1)) Main.color(x, y+1);
		if(canGo(x, y-1)) Main.color(x, y-1);
		if(canGo(x+1, y+1)) Main.color(x+1, y+1);
		if(canGo(x+1, y-1)) Main.color(x+1, y-1);
		if(canGo(x-1, y+1)) Main.color(x-1, y+1);
		if(canGo(x-1, y-1)) Main.color(x-1, y-1);
		return;
	}

	private boolean canGo(int x,  int y){
		if(x<0 || x>7 || y<0 || y>7){
			return false;
		}
		
		
		if(Main.board.pieces[x][y].nr() == 0){
			return true;
		}else{
			if(Main.board.getColor(x, y) == 2){
				return true;
			}
		}
		
		return false;
	}
	
}
