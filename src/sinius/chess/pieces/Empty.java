package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Piece;

public class Empty implements Piece{

	@Override
	public File getImg() {
		return null;
	}


	@Override
	public int nr() {
		return 0;
	}

	@Override
	public boolean canGoHere(int isX, int isY, int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
