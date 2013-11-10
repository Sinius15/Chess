package sinius.chess.server;

import sinius.chess.common.shah.Message;

public class Match {

	private Client white, black;
	private boolean whiteTurn = true;
	private static String startBoard =  "8,4,6,10,12,6,4,8;"+
										"2,2,2,2,2,2,2,2;"  +
										"0,0,0,0,0,0,0,0;"  +
										"0,0,0,0,0,0,0,0;"  +
										"0,0,0,0,0,0,0,0;"  +
										"0,0,0,0,0,0,0,0;"  +
										"1,1,1,1,1,1,1,1;"  +
										"7,3,5,9,11,5,3,7"  ;
	private String latestBoard = startBoard;
	
	public Match(Client a, Client b){
		white = a;
		black = b;
		
		white.inMatch = true;
		black.inMatch = true;
		white.setMatch(this);
		black.setMatch(this);
		
		//vertellen dat er een match komt	(message: [opponent name];[color]) 
		white.sendMessage(new Message("Server", "match_start", b.name + ";white"));
		black.sendMessage(new Message("Server", "match_start", a.name + ";black"));
		
		//send start board
		white.sendMessage(new Message("Server", "match_board", startBoard));
		black.sendMessage(new Message("Server", "match_board", startBoard));
		
		//send who's turn it is
		white.sendMessage(new Message("Server", "match_turn", String.valueOf(whiteTurn)));
		black.sendMessage(new Message("Server", "match_turn", String.valueOf(!whiteTurn)));
	}
	
	public void handleIn(Message in, Client who){
		if(in.type.equals("match_move")){
			if(who.equals(black)){
				if(!whiteTurn){   				//er is een move gedaan door de gene die aan zet is
					whiteTurn = ! whiteTurn;	//zet omdraaien
					latestBoard = in.message;	//latest board zetten
					
					//send board
					white.sendMessage(new Message("Server", "match_board", latestBoard));
					black.sendMessage(new Message("Server", "match_board", latestBoard));
					
					//send who's turn it is
					white.sendMessage(new Message("Server", "match_turn", String.valueOf(whiteTurn)));
					black.sendMessage(new Message("Server", "match_turn", String.valueOf(!whiteTurn)));
					
				}
			}
			if(who.equals(white)){
				if(whiteTurn){					//er is een move gedaan door de gene die aan zet is
					whiteTurn = ! whiteTurn;	//zet omdraaien
					latestBoard = in.message;	//latest board zetten
					
					//send board
					white.sendMessage(new Message("Server", "match_board", latestBoard));
					black.sendMessage(new Message("Server", "match_board", latestBoard));
					
					//send who's turn it is
					white.sendMessage(new Message("Server", "match_turn", String.valueOf(whiteTurn)));
					black.sendMessage(new Message("Server", "match_turn", String.valueOf(!whiteTurn)));
				}
			}
		}
		
		
	}
	
}
