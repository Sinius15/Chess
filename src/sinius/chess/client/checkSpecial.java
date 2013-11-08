package sinius.chess.client;


public class checkSpecial {

	public static boolean canPlay = true;
	
	public static void Start(){
		canPlay = false;
		for(int i = 0; i<8; i++){
			if(Game.board.pieces[i][0].equals(Game.board.getPieceByNumber(1))){
				Gui.showPionChoseSceen("white", i, 0);
				return;
			}
			if(Game.board.pieces[i][7].equals(Game.board.getPieceByNumber(2))){
				Gui.showPionChoseSceen("black", i, 7);
				return;
			}
		}
		canPlay = true;
	}
	
}
