package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Piece;

public class WhiteKing  implements Piece{

	@Override
	public File getImg() {
		return new File("rec/King_white.png");
	}


	@Override
	public int nr() {
		return 11;
	}

	@Override
	public boolean canGoHere(int isX, int isY, int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
