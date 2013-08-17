package sinius.chess.pieces;

import java.io.File;
import sinius.chess.Main;
import sinius.chess.Piece;

public class WhitePawn implements Piece{

	@Override
	public File getImg() {
		return new File("rec/Pawn_white.png");
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
			if(Main.board.getColor(x-1, y-1) == 2){			
				Main.color(x-1, y-1);
			}
		}
		if(x < 7){								//slaan rechtsboven
			if(Main.board.getColor(x+1, y-1) == 2){ 
				Main.color(x+1, y-1);
			}
		}
		boolean b = false;
		if(Main.board.pieces[x][y-1].nr() == 0){ //1 omhoog
			b = true;
			Main.color(x, y-1);
		}
		if(b){
			if(Main.board.pieces[x][y-2].nr() == 0 && y==6){ //twee omhoog bij startpositie
				Main.color(x, y-2);
			}
		}
		
	}

}
