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
		if(event.getButton() == MouseEvent.BUTTON1){  //linker muis knop
			int x = (event.getX()/50);
			int y = (event.getY()/50);
			
			if(Main.board.selected[y][x]){
				Main.board.pieces[x][y] = Main.board.pieces[Main.board.movingX][Main.board.movingY];
				Main.board.pieces[Main.board.movingX][Main.board.movingY] = Main.board.getPieceByNumber(0);
				Main.board.movingX = -1;
				Main.board.movingY = -1;
				Main.updateAll();
				return;
			}
			
			if(Main.board.pieces[x][y].nr() == 0){
				Main.board.movingX = -1;
				Main.board.movingY = -1;
				Main.updateAll();
			}else{
				Main.board.movingX = x;
				Main.board.movingY = y;
				Main.updateAll();
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}


}
