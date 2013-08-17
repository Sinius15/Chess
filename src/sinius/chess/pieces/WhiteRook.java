package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Piece;

public class WhiteRook implements Piece{

	@Override
	public File getImg() {
		return new File("rec/Rook_white.png");
	}


	@Override
	public int nr() {
		return 7;
	}

	@Override
	public boolean canGoHere(int isX, int isY, int toX, int toY) {
		if(isY != toY || isX!=toX){
			return false;
		}
		
		
		
		
		return false;
	}

}
