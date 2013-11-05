package sinius.chess.common.pieces;

import java.awt.Image;

public class Empty implements Piece{

	@Override
	public Image getImg() {
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
