package sinius.chess.common.pieces;

import java.awt.Image;

import sinius.chess.client.Game;

public class WhiteKing  implements Piece{

	@Override
	public Image getImg() {
		return Game.baseImage.getImageById(2);
	}


	@Override
	public int nr() {
		return 11;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		if(canGo(x+1, y)) Game.color(x+1, y);
		if(canGo(x-1, y)) Game.color(x-1, y);
		if(canGo(x, y+1)) Game.color(x, y+1);
		if(canGo(x, y-1)) Game.color(x, y-1);
		if(canGo(x+1, y+1)) Game.color(x+1, y+1);
		if(canGo(x+1, y-1)) Game.color(x+1, y-1);
		if(canGo(x-1, y+1)) Game.color(x-1, y+1);
		if(canGo(x-1, y-1)) Game.color(x-1, y-1);
		return;
	}

	private boolean canGo(int x,  int y){
		if(x<0 || x>7 || y<0 || y>7){
			return false;
		}
		
		
		if(Game.board.pieces[x][y].nr() == 0){
			return true;
		}else{
			if(Game.board.getColor(x, y) == 2){
				return true;
			}
		}
		
		return false;
	}
	
}
