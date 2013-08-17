package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Main;
import sinius.chess.Piece;

public class WhiteKnight implements Piece{

	@Override
	public File getImg() {
		
		return new File("rec/Knight_white.png");
	}


	@Override
	public int nr() {
		return 3;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		doall(x+2, y-1);
		doall(x+2, y+1);
		doall(x-2, y-1);
		doall(x-2, y+1);
		doall(x-1, y+2);
		doall(x+1, y+2);
		doall(x-1, y-2);
		doall(x+1, y-2);
		return;
	}

	private void doall(int x, int y){
		if(canGo(x,y)) Main.color(x, y);
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
