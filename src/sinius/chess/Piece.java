package sinius.chess;

import java.io.File;

public interface Piece {

	public File getImg();
	public boolean canGoHere(int isX, int isY, int toX, int toY);
	public int nr();
}
