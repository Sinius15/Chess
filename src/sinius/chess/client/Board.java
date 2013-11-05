package sinius.chess.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sinius.chess.common.pieces.BlackBishop;
import sinius.chess.common.pieces.BlackKing;
import sinius.chess.common.pieces.BlackKnight;
import sinius.chess.common.pieces.BlackPawn;
import sinius.chess.common.pieces.BlackQueen;
import sinius.chess.common.pieces.BlackRook;
import sinius.chess.common.pieces.Empty;
import sinius.chess.common.pieces.Piece;
import sinius.chess.common.pieces.WhiteBishop;
import sinius.chess.common.pieces.WhiteKing;
import sinius.chess.common.pieces.WhiteKnight;
import sinius.chess.common.pieces.WhitePawn;
import sinius.chess.common.pieces.WhiteQueen;
import sinius.chess.common.pieces.WhiteRook;

public class Board {

	public Piece[][] pieces = new Piece[8][8];
	public boolean[][] selected = new boolean[8][8];
	
	public List<Piece> avalablePieces = new ArrayList<>();
	
	public int selectedPieceX, selectedPieceY;
	
	@SuppressWarnings("resource")
	public Board(File file){
		fillPieceList();

		String[] in = new String[8];
		try {
			//InputStream stream = getClass().getResourceAsStream("rec/startGame.chess");
			//BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			for(int i = 0; i<8;i++)
				in[i] = reader.readLine();
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
