package sinius.chess.client.state.play;

import java.awt.event.MouseEvent;

import sinius.chess.client.Game;
import sinius.chess.client.checkSpecial;
import sinius.chess.client.engine.GObject;
import sinius.chess.client.engine.GeneralListener;
import sinius.chess.client.state.GameState;
import sinius.chess.client.state.GrapicsLayer;
import sinius.chess.common.SynchroniezedList;

public class PlayState implements GameState{

	SynchroniezedList<GrapicsLayer> layers = new SynchroniezedList<>();
	
	boolean isWhite = true;
	
	public PlayState(){
		layers.add(new Layer_Board());
		layers.add(new Layer_Selected());
		layers.add(new Layer_Pieces());
	}
	
	@Override
	public String getName() {
		return "Play";
	}

	@Override
	public void tick() {
		
	}

	@Override
	public SynchroniezedList<GObject> getGObjects() {
		return null;
	}

	@Override
	public SynchroniezedList<GrapicsLayer> getGraphicsLayers() {
		return layers;
	}

	@Override
	public void mouseEvent(int button) {
		if(!checkSpecial.canPlay){
			return;
		}
		
		if(button == MouseEvent.BUTTON1){  //linker muis knop
			
			int x = (GeneralListener.mouseX/50);
			int y = (GeneralListener.mouseY/50);
			
			if(Game.board.selected[y][x]){
				Game.board.pieces[x][y] = Game.board.pieces[Game.board.selectedPieceX][Game.board.selectedPieceY];
				Game.board.pieces[Game.board.selectedPieceX][Game.board.selectedPieceY] = Game.board.getPieceByNumber(0);
				Game.board.selectedPieceX = -1;
				Game.board.selectedPieceY = -1;
				isWhite = !isWhite;
				return;
			}
			
			if(Game.board.pieces[x][y].nr() == 0){
				Game.board.selectedPieceX = -1;
				Game.board.selectedPieceY = -1;
			}else{
				if(Game.board.getColor(x, y) == 1 && isWhite){
					Game.board.selectedPieceX = x;
					Game.board.selectedPieceY = y;
				}else if(Game.board.getColor(x, y) == 2 && !isWhite){
					Game.board.selectedPieceX = x;
					Game.board.selectedPieceY = y;
				}
				
			}
			
		}
		
		if(button == MouseEvent.BUTTON3){	//rechter muis
			Game.board.selectedPieceX = -1;
			Game.board.selectedPieceY = -1;
		}
	}

	@Override
	public void keyEvent(int button) {
		
	}

}
