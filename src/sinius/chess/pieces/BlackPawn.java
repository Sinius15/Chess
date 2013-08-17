package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Main;
import sinius.chess.Piece;

public class BlackPawn implements Piece{

	@Override
	public File getImg() {
		return new File("rec/Pawn_black.png");
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
			if(Main.board.pieces[x][y+2].nr() == 0 && y==1){ //twee omhoog bij startpositie
				Main.color(x, y+2);
			}
		}
		
	}
}
