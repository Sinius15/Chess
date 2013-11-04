package sinius.chess;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyHandler implements  MouseListener{

	@Override
	public void mouseClicked(MouseEvent event) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if(!Main.canPlay){
			return;
		}
		
		
		if(event.getButton() == MouseEvent.BUTTON1){  //linker muis knop
			int x = (event.getX()/50);
			int y = (event.getY()/50);
			
			if(Main.board.selected[y][x]){
				Main.board.pieces[x][y] = Main.board.pieces[Main.board.selectedPieceX][Main.board.selectedPieceY];
				Main.board.pieces[Main.board.selectedPieceX][Main.board.selectedPieceY] = Main.board.getPieceByNumber(0);
				Main.board.selectedPieceX = -1;
				Main.board.selectedPieceY = -1;
				Main.updateAll();
				return;
			}
			
			if(Main.board.pieces[x][y].nr() == 0){
				Main.board.selectedPieceX = -1;
				Main.board.selectedPieceY = -1;
				Main.updateAll();
			}else{
				Main.board.selectedPieceX = x;
				Main.board.selectedPieceY = y;
				Main.updateAll();
			}
			
		}
		
		if(event.getButton() == MouseEvent.BUTTON3){	//rechter muis
			Main.board.selectedPieceX = -1;
			Main.board.selectedPieceY = -1;
			Main.updateAll();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}


}
