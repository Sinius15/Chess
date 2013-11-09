package sinius.chess.client.state.multiplayer;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.IOException;

import sinius.chess.client.Game;
import sinius.chess.client.checkSpecial;
import sinius.chess.client.engine.GObject;
import sinius.chess.client.engine.GText;
import sinius.chess.client.engine.GeneralListener;
import sinius.chess.client.state.GameState;
import sinius.chess.client.state.GrapicsLayer;
import sinius.chess.client.state.play.Layer_Board;
import sinius.chess.client.state.play.Layer_Pieces;
import sinius.chess.client.state.play.Layer_Selected;
import sinius.chess.common.SynchroniezedList;

public class MultiPlayerState implements GameState {

	SynchroniezedList<GrapicsLayer> layers = new SynchroniezedList<>();
	SynchroniezedList<GObject> gObjcs = new SynchroniezedList<>();
	
	boolean youAreWhite, myTurn;
	GText status;
	Server server;
	
	
	public MultiPlayerState(){
		layers.add(new Layer_Board());
		layers.add(new Layer_Selected());
		layers.add(new Layer_Pieces());
		
		status = new GText("waiting for opponent...", 10, 420);
		status.setColor(Color.black);
		gObjcs.add(status);
		
		Thread connector = new Thread(new Runnable() {@Override public void run() {
			try {
				server = new Server("37.251.48.220", 4444);
				status.setText("Connected!");
			} catch (IOException e) {
				e.printStackTrace();
				status.setColor(Color.red);
				status.setText("Could not connect to the server.");
			}
		}});
		connector.start();
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
		return gObjcs;
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
			if(x>7 || y> 7)
				return;
			System.out.println("x: " + x + " y: " + y);
			if(Game.board.selected[y][x]){
				Game.board.pieces[x][y] = Game.board.pieces[Game.board.selectedPieceX][Game.board.selectedPieceY];
				Game.board.pieces[Game.board.selectedPieceX][Game.board.selectedPieceY] = Game.board.getPieceByNumber(0);
				Game.board.selectedPieceX = -1;
				Game.board.selectedPieceY = -1;
				myTurn = !myTurn;
				
				if(myTurn)
					status.setText("Turn: you" );
				else
					status.setText("Turn: opponent" );
				return;
			}
			if(Game.board.pieces[x][y].nr() == 0){
				Game.board.selectedPieceX = -1;
				Game.board.selectedPieceY = -1;
			}else{
				if(Game.board.getColor(x, y) == 1 && youAreWhite && myTurn){
					Game.board.selectedPieceX = x;
					Game.board.selectedPieceY = y;
				}else if(Game.board.getColor(x, y) == 2 && !youAreWhite && myTurn){
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
