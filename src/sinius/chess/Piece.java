package sinius.chess;

import java.io.File;

public interface Piece {

	public File getImg();
	public void ColorPlacesCan(int x, int y);
	public int nr();
}
