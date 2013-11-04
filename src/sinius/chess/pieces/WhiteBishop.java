package sinius.chess.pieces;

import java.awt.Image;

import sinius.chess.Main;
import sinius.chess.Piece;
import sinius.chess.io.ImageLoader;

public class WhiteBishop implements Piece {

	@Override
	public Image getImg() {
		return ImageLoader.baseImage.getImageById(10);
	}


	@Override
	public int nr() {
		return 5;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		for(int i = 1; i<8; i++){
			if(!doall(x+i,y+i))
				break;
		}
		for(int i = 1; i<8; i++){
			if(!doall(x-i,y-i))
				break;
		}
		for(int i = 1; i<8; i++){
			if(!doall(x-i,y+i))
				break;
		}
		for(int i = 1; i<8; i++){
			if(!doall(x+i,y-i))
				break;
		}
	}
	
	private boolean doall(int x, int y){
		if(x<0 || x>7 || y<0 || y>7){
			return false;
		}
		if(Main.board.pieces[x][y].nr() == 0){
			Main.color(x, y);
			return true;
		}else{
			if(Main.board.getColor(x, y) == 2){
				Main.color(x, y);
				return false;
			}
		}
	    return false;
	}


}
