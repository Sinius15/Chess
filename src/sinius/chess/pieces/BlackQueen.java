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
	public boolean canGoHere(int isX, int isY, int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
