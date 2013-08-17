package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Piece;

public class BlackQueen  implements Piece{

	@Override
	public File getImg() {
		return new File("rec/Queen_black.png");
	}


	@Override
	public int nr() {
		return 10;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		
		return;
	}


}
