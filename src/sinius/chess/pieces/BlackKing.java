package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Piece;

public class BlackKing  implements Piece{

	@Override
	public File getImg() {
		return new File("rec/King_black.png");
	}


	@Override
	public int nr() {
		return 12;
	}

	@Override
	public boolean canGoHere(int isX, int isY, int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
