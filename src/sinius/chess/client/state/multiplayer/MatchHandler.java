package sinius.chess.client.state.multiplayer;

import sinius.chess.client.Game;
import sinius.chess.common.shah.Message;

public class MatchHandler {

	private Server server;
	private MultiPlayerState state;
	
	public MatchHandler(Server s, MultiPlayerState state){
		this.server = s;
		this.state = state;
	}
	
	public void handleIn(Message msg){
		
		if(msg.type.equals("match_start")){
			Game.display.getFrame().setVisible(true);
			OpponentFrame.thiss.dispose();
			state.opponent.setText("You are plaing against " + msg.message.split(";")[0]);
			state.color.setText("You are playing with the color " + msg.message.split(";")[1]);
			
			if(msg.message.split(";")[1].equals("black"))
				state.youAreWhite = false;
			else
				state.youAreWhite = true;
		}
		
		if(msg.type.equals("match_board")){
			Game.board.setBoard(msg.message);
		}
		if(msg.type.equals("match_turn")){
			state.myTurn = Boolean.parseBoolean(msg.message);
			if(state.myTurn)
				state.status.setText("Turn: you" );
			else
				state.status.setText("Turn: opponent" );
		}
		
	}
	
	public void Move(){
		server.sendMessage(new Message("client" + server.id, "match_move", Game.board.getBoard()));
	}
	
	
}
