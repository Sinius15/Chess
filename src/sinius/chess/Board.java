package sinius.chess;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sinius.chess.pieces.*;
import fileHandling.LFile;

public class Board {

	public Piece[][] pieces = new Piece[8][8];
	public boolean[][] selected = new boolean[8][8];
	
	public List<Piece> avalablePieces = new ArrayList<>();
	public static LFile file;
	
	public int selectedPieceX, selectedPieceY;
	
	public Board(File f){
		fillPieceList();
		file = new LFile(f);
		String[] in;
		try {
			in = file.open(false);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		for(int x = 0; x<8;x++){
			String[] dat = in[x].split(",");
			for(int y = 0; y<8;y++){
				pieces[y][x] = getPieceByNumber(Integer.parseInt(dat[y]));
				selected[y][x] = false;
			}
		}
	}

	private void fillPieceList() {
		avalablePieces.add(new Empty());
		avalablePieces.add(new WhitePawn());
		avalablePieces.add(new BlackPawn());
		avalablePieces.add(new BlackKnight());
		avalablePieces.add(new WhiteKnight());
		avalablePieces.add(new WhiteRook());
		avalablePieces.add(new BlackRook());
		avalablePieces.add(new WhiteQueen());
		avalablePieces.add(new BlackQueen());
		avalablePieces.add(new WhiteKing());
		avalablePieces.add(new BlackKing());
		avalablePieces.add(new WhiteBishop());
		avalablePieces.add(new BlackBishop());
	}
	
	public Piece getPieceByNumber(int nr){
		for(Piece p: avalablePieces){
			if(p.nr() == nr){
				return p;
			}
		}
		return null;
	}
	
	public void cleanSelected(){
		for(int x = 0 ; x<8; x++){
			for(int y = 0; y<8 ; y++){
				selected[x][y] = false;
			}
		}
	}
	
	public void setSelected(){
		if(selectedPieceX == -1 || selectedPieceY == -1){
			return;
		}
		pieces[selectedPieceX][selectedPieceY].ColorPlacesCan(selectedPieceX, selectedPieceY);
	}
	
	public int getColor(int x, int y){
		int nr = pieces[x][y].nr();
		if(nr == 0){
			return 0;
		}
		if(nr % 2 == 0){
			return 2;	//black
		}
		return 1;		//white
	}
}
