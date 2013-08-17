package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Piece;

public class WhiteQueen  implements Piece{

	@Override
	public File getImg() {
		return new File("rec/Queen_white.png");
	}


	@Override
	public int nr() {
		return 9;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		
		return;
	}


}