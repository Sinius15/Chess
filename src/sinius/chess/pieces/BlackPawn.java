package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Main;
import sinius.chess.Piece;

public class BlackPawn implements Piece{

	@Override
	public File getImg() {
		return new File("rec/Pawn_black.png");
	}


	@Override
	public int nr() {
		return 2;
	}

	@Override
	public boolean canGoHere(int isX, int isY, int toX, int toY) {
//dit stuk is voor slaan linksboven
		int x = isX-1;										
		int y = isY+1;
		if(toX == x && toY == y){
			if(Main.board.getColor(x, y) == 1){
				return true;
			}
		}
//dit stuk is voor slaan rechtsboven
		x = isX+1;											
		y = isY+1;
		if(toX == x && toY == y){
			if(Main.board.getColor(x, y) == 1){
				return true;
			}
		}
//dit stuk is voor 1 benede
		if(Main.board.pieces[isX][isY+1].nr() != 0){		
			return false;
		}
		if(isX==toX && isY+1==toY){
			return true;
		}
//dit stuk is voor twee beneden
		if(Main.board.pieces[isX][isY+2].nr() != 0){		
			return false;
		}
		if(isX==toX && isY==1 && isY+2==toY){
			return true;
		}
		
		return false;
	}
}
