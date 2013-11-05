package sinius.chess.common.pieces;

import java.awt.Image;

public interface Piece {

	public Image getImg();
	public void ColorPlacesCan(int x, int y);
	public int nr();
}
