package sinius.chess.common.pieces;

import java.awt.Image;

import sinius.chess.client.ImageLoader;
import sinius.chess.client.Main;

public class BlackPawn implements Piece{

	@Override
	public Image getImg() {
		return ImageLoader.baseImage.getImageById(7);
	}


	@Override
	public int nr() {
		return 2;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		if(y==7){
			return;
		}
		if(x > 0){								//slaan linksonder
			if(Main.board.getColor(x-1, y+1) == 1){			
				Main.color(x-1, y+1);
			}
		}
		if(x < 7){								//slaan rechtsonder
			if(Main.board.getColor(x+1, y+1) == 1){ 
				Main.color(x+1, y+1);
			}
		}
		boolean b = false;
		if(Main.board.pieces[x][y+1].nr() == 0){ //1 beneden
			b= true;
			Main.color(x, y+1);
		}
		if(b){
			if(y==1){							 //twee omlaag bij startpositie
				if(canGo(x, y+2)) Main.color(x, y+2);
			}
		}
		
	}
	
	private boolean canGo(int x,  int y){
		if(x<0 || x>7 || y<0 || y>7){
			return false;
		}
		if(Main.board.pieces[x][y].nr() == 0){
			return true;
		}else{
			return false;
		}
		
	}
}
