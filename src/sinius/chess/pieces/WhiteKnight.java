package sinius.chess.pieces;

import java.awt.Image;

import sinius.chess.Main;
import sinius.chess.Piece;
import sinius.chess.io.ImageLoader;

public class WhiteKnight implements Piece{

	@Override
	public Image getImg() {
		return ImageLoader.baseImage.getImageById(12);
	}


	@Override
	public int nr() {
		return 3;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		doall(x+2, y-1);
		doall(x+2, y+1);
		doall(x-2, y-1);
		doall(x-2, y+1);
		doall(x-1, y+2);
		doall(x+1, y+2);
		doall(x-1, y-2);
		doall(x+1, y-2);
		return;
	}

	private void doall(int x, int y){
		if(canGo(x,y)) Main.color(x, y);
	}
	
	private boolean canGo(int x,  int y){
		if(x<0 || x>7 || y<0 || y>7){
			return false;
		}
		if(Main.board.pieces[x][y].nr() == 0){
			return true;
		}else{
			if(Main.board.getColor(x, y) == 2){
				return true;
			}
		}
		
		return false;
	}


}
