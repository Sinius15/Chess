package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Piece;

public class BlackBishop implements Piece {

	@Override
	public File getImg() {
		return new File("rec/Bishop_black.png");
	}
	
	@Override
	public int nr() {
		return 6;
	}

	@Override
	public boolean canGoHere(int isX, int isY, int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
