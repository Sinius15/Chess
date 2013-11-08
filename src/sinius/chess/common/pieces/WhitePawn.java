package sinius.chess.common.pieces;

import java.awt.Image;

import sinius.chess.client.Game;

public class WhitePawn implements Piece{

	@Override
	public Image getImg() {
		return Game.baseImage.getImageById(8);
	}


	@Override
	public int nr() {
		return 1;
	}


	@Override
	public void ColorPlacesCan(int x, int y) {
		if(y==0){
			return;
		}
		if(x > 0){								//slaan linksbovne
			if(Game.board.getColor(x-1, y-1) == 2){			
				Game.color(x-1, y-1);
			}
		}
		if(x < 7){								//slaan rechtsboven
			if(Game.board.getColor(x+1, y-1) == 2){ 
				Game.color(x+1, y-1);
			}
		}
		boolean b = false;
		if(Game.board.pieces[x][y-1].nr() == 0){ //1 omhoog
			b = true;
			Game.color(x, y-1);
		}
		if(b){
			if(y==6){							 //twee omhoog bij startpositie
				if(canGo(x, y-2)) Game.color(x, y-2);
			}
		}
		
	}
	
	private boolean canGo(int x,  int y){
		if(x<0 || x>7 || y<0 || y>7){
			return false;
		}
		if(Game.board.pieces[x][y].nr() == 0){
			return true;
		}else{
			return false;
		}
		
	}

}
