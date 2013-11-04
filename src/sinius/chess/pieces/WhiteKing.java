package sinius.chess.pieces;

import java.awt.Image;

import sinius.chess.Main;
import sinius.chess.Piece;
import sinius.chess.io.ImageLoader;

public class WhiteKing  implements Piece{

	@Override
	public Image getImg() {
		return ImageLoader.baseImage.getImageById(2);
	}


	@Override
	public int nr() {
		return 11;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		if(canGo(x+1, y)) Main.color(x+1, y);
		if(canGo(x-1, y)) Main.color(x-1, y);
		if(canGo(x, y+1)) Main.color(x, y+1);
		if(canGo(x, y-1)) Main.color(x, y-1);
		if(canGo(x+1, y+1)) Main.color(x+1, y+1);
		if(canGo(x+1, y-1)) Main.color(x+1, y-1);
		if(canGo(x-1, y+1)) Main.color(x-1, y+1);
		if(canGo(x-1, y-1)) Main.color(x-1, y-1);
		return;
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
