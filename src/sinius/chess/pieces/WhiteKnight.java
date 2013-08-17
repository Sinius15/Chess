package sinius.chess.pieces;

import java.io.File;

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
	public boolean canGoHere(int isX, int isY, int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
