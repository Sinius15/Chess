package sinius.chess.client.state.multiplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import sinius.chess.common.shah.Message;

public class Server {

	int id;
	public boolean connected = true;
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	
	public Server(String host, int port) throws UnknownHostException, IOException{
		
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
		
	}
	
	private void handleIn(Message msg){
		if(msg.type.equals("id")){
			id = Integer.parseInt(msg.message);
			return;
		}
		if(msg.type.equals("alive")){
			out.println(new Message("client" + id, "alive", "true").encode());
			return;
		}
		
		
		
		
	}
	
}


