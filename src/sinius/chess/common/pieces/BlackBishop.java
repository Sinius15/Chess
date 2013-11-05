package sinius.chess.common.pieces;

import java.awt.Image;

import sinius.chess.client.ImageLoader;
import sinius.chess.client.Main;

public class BlackBishop implements Piece {

	@Override
	public Image getImg() {
		return ImageLoader.baseImage.getImageById(9);
	}
	
	@Override
	public int nr() {
		return 6;
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
		return;
	}
	
	private boolean doall(int x, int y){
		if(x<0 || x>7 || y<0 || y>7){
			return false;
		}
		if(Main.board.pieces[x][y].nr() == 0){
			Main.color(x, y);
			return true;
		}else{
			if(Main.board.getColor(x, y) == 1){
				Main.color(x, y);
				return false;
			}
		}
	    return false;
	}

}
