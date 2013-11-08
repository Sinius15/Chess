package sinius.chess.client;

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
		if(!checkSpecial.canPlay){
			return;
		}
		
		
		if(event.getButton() == MouseEvent.BUTTON1){  //linker muis knop
			int x = (event.getX()/50);
			int y = (event.getY()/50);
			
			if(Game.board.selected[y][x]){
				Game.board.pieces[x][y] = Game.board.pieces[Game.board.selectedPieceX][Game.board.selectedPieceY];
				Game.board.pieces[Game.board.selectedPieceX][Game.board.selectedPieceY] = Game.board.getPieceByNumber(0);
				Game.board.selectedPieceX = -1;
				Game.board.selectedPieceY = -1;
				Game.updateAll();
				return;
			}
			
			if(Game.board.pieces[x][y].nr() == 0){
				Game.board.selectedPieceX = -1;
				Game.board.selectedPieceY = -1;
				Game.updateAll();
			}else{
				Game.board.selectedPieceX = x;
				Game.board.selectedPieceY = y;
				Game.updateAll();
			}
			
		}
		
		if(event.getButton() == MouseEvent.BUTTON3){	//rechter muis
			Game.board.selectedPieceX = -1;
			Game.board.selectedPieceY = -1;
			Game.updateAll();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}


}
