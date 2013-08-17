package sinius.chess.pieces;

import java.io.File;

import sinius.chess.Main;
import sinius.chess.Piece;

public class WhiteRook implements Piece{

	@Override
	public File getImg() {
		return new File("rec/Rook_white.png");
	}


	@Override
	public int nr() {
		return 7;
	}

	@Override
	public void ColorPlacesCan(int x, int y) {
		int x1;
		if(x<7){
			x1 = x+1;
			while(x1<8){
				if(Main.board.pieces[x1][y].nr() == 0){
					Main.color(x1, y);
				}else{
					if(Main.board.getColor(x1, y) == 2){
						Main.color(x1, y);
					}
					break;
				}
				x1++;
			}
		}
		if(x>0){
			x1 = x-1;
			while(x1>=0){
				if(Main.board.pieces[x1][y].nr() == 0){
					Main.color(x1, y);
				}else{
					if(Main.board.getColor(x1, y) == 2){
						Main.color(x1, y);
					}
					break;
				}
				x1--;
			}
		}
		
		
		int y1;
		if(y<7){
			y1 = y+1;
			while(y1<8){
				if(Main.board.pieces[x][y1].nr() == 0){
					Main.color(x, y1);
				}else{
					if(Main.board.getColor(x, y1) == 2){
						Main.color(x, y1);
					}
					break;
				}
				y1++;
			}
		}
		
		
		if(y>0){
			y1 = y-1;
			while(y1>=0){
				if(Main.board.pieces[x][y1].nr() == 0){
					Main.color(x, y1);
				}else{
					if(Main.board.getColor(x, y1) == 2){
						Main.color(x, y1);
					}
					break;
				}
				y1--;
			}
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
