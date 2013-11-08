package sinius.chess.common.pieces;

import java.awt.Image;

import sinius.chess.client.Game;

public class WhiteRook implements Piece{

	@Override
	public Image getImg() {
		return Game.baseImage.getImageById(8);
	}


	@Override
	public int nr() {
		return 7;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		for(int i = 1; i<8; i++){
			if(!doall(x+i,y))
				break;
		}
		for(int i = 1; i<8; i++){
			if(!doall(x-i,y))
				break;
		}
		for(int i = 1; i<8; i++){
			if(!doall(x,y+i))
				break;
		}
		for(int i = 1; i<8; i++){
			if(!doall(x,y-i))
				break;
		}

	}
	
	private boolean doall(int x, int y){
		if(x<0 || x>7 || y<0 || y>7){
			return false;
		}
		if(Game.board.pieces[x][y].nr() == 0){
			Game.color(x, y);
			return true;
		}else{
			if(Game.board.getColor(x, y) == 2){
				Game.color(x, y);
				return false;
			}
		}
	    return false;
	}


}
