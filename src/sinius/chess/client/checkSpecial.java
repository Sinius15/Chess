package sinius.chess.client;


public class checkSpecial {

	public static void Start(){
		Main.canPlay = false;
		for(int i = 0; i<8; i++){
			if(Main.board.pieces[i][0].equals(Main.board.getPieceByNumber(1))){
				Gui.showPionChoseSceen("white", i, 0);
				return;
			}
			if(Main.board.pieces[i][7].equals(Main.board.getPieceByNumber(2))){
				Gui.showPionChoseSceen("black", i, 7);
				return;
			}
		}
		Main.canPlay = true;
	}
	
}
