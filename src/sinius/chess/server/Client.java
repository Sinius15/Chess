package sinius.chess.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import sinius.chess.common.shah.Message;

public class Client {

	public Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
	public boolean connected = true;
	public boolean inMatch = false;
	public String name;
	private Match match = null;
	int id;
	
	
	public Client(Socket socket, int id){
		this.id = id;
		this.socket = socket;
		try {
			out = new PrintWriter(this.socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e){
			e.printStackTrace();
			Main.gui.errorMessage("error while creating in and output");
			return;
		}
		sendMessage(new Message("Server", "id", Integer.toString(id)));
		
		input.start();
		living.start();
	}
	
	public void setMatch(Match m){
		this.match = m;
	}
	
	public void stop(){
		connected = false;
		try {
			socket.close();
			out.close();
			in.close();
		} catch (IOException e) {}
		
	}
	
	public void sendMessage(Message m){
		out.println(Message.encode(m));
	}

	private void handleIn(Message msg){
		if(msg.type.equals("alive")){
			allive = true;
			return;
		}
		if(msg.type.equals("name")){
			name = msg.message;
			return;
		}
		if(msg.type.equals("request")){
			if(msg.message.equals("playerList")){
				sendMessage(new Message("Server", "playerList", Main.getPlayerList()));
				return;
			}
		}
		if(msg.type.startsWith("match_")){
			if(match != null)
				match.handleIn(msg, this);
			if(msg.type.equals("match_request"))
				Main.getClient(msg.message).sendMessage(msg);
			if(msg.type.equals("match_request_answer")){
				if(msg.message.startsWith("yes_")){
					Main.createMatch(this, Main.getClient(Integer.parseInt(msg.message.replace("yes_client", ""))));
				}
				if(msg.message.startsWith("no_")){
					Main.getClient(Integer.parseInt(msg.message.replace("no_client", ""))).sendMessage(msg);
				}
				
			}
		}
	}
	
	private Thread input = new Thread(new Runnable() {@Override public void run() {
		while(connected){
			try{ 
				handleIn(Message.decode(in.readLine()));
			}catch(Exception e){}
		}
	}});
	
	private boolean allive;
	private Thread living = new Thread(new Runnable() {@Override public void run() {
		while(connected){
			allive = false;
			sendMessage(new Message("Server", "alive", "Are you alive?"));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				Main.gui.errorMessage("error while trying to sleep");
			}
			if(!allive)
				Main.Disconnected(id);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				Main.gui.errorMessage("error while trying to sleep");
			}
		}
	}});

	
}
