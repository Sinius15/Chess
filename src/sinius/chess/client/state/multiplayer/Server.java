package sinius.chess.client.state.multiplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import sinius.chess.common.shah.Message;

public class Server {

	int id;
	public boolean connected = true;
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	
	String ip, myName;
	int port;
	
	public Server(String host, int port, String myName) throws UnknownHostException, IOException{
		this.ip = host;
		this.port = port;
		this.myName = myName;
		
		socket = new Socket(host, port);
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		Thread input = new Thread(new Runnable() {@Override public void run() {
			while (connected){
				try {
					handleIn(Message.decode(in.readLine()));
				} catch (IOException e) {
					connected = false;
				}
			}

		}}, "reader");
		input.start();
		sendMessage(new Message("client" + id, "name", myName));
	}
	
	public void sendMessage(Message m){
		out.println(m.encode());
	}
	
	private void handleIn(final Message msg){
		if(msg.type.equals("id")){
			id = Integer.parseInt(msg.message);
			return;
		}
		if(msg.type.equals("alive")){
			sendMessage(new Message("client" + id, "alive", "true"));
			return;
		}
		if(msg.type.equals("playerList")){
			onlinePlayerIn = msg.message;
		}
		if(msg.type.startsWith("match_")){
			if(msg.type.equals("match_request")){
				Thread t = new Thread(new Runnable() {@Override public void run() {
					int yesno = JOptionPane.showConfirmDialog(OpponentFrame.thiss, "Player " + msg.message + " wants to fight you." + System.lineSeparator() + 
							"Do you accept this challange?", "fight request", JOptionPane.YES_NO_OPTION);
					if(yesno != JOptionPane.YES_OPTION){
						sendMessage(new Message("client" + id, "match_request_answer", "no_" + msg.message));
						return;
					}
					sendMessage(new Message("client" + id, "match_request_answer", "yes_" + msg.message));
				}});
				t.start();
			}
		}
	}
	
	private String onlinePlayerIn = null;
	public String[] getOnlinePlayers(){
		sendMessage(new Message("client" + id, "request", "playerList"));
		while(onlinePlayerIn == null)
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		String[] out = onlinePlayerIn.split(";");
		onlinePlayerIn = null;
		return out;
	}
	
}


