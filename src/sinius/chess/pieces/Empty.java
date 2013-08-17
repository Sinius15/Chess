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
	public void ColorPlacesCan(int x, int y) {
	
	}



}
