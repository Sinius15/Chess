package sinius.chess.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import sinius.chess.common.shah.Message;

public class Client {

	public Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	public boolean connected = true;
	public ArrayList<Message> received = new ArrayList<>();
	
	int id;
	
	public Client(Socket socket, int id){
		this.id = id;
		this.socket = socket;
		try {
			out = new PrintWriter(this.socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e){
			e.printStackTrace();
			return;
		}
		input.start();
		living.start();
		out.println(new Message("Server", "id", Integer.toString(id)).encode());
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

	
	private Thread input = new Thread(new Runnable() {@Override public void run() {
		String inputLine;
		while(connected){
			try{
				inputLine = in.readLine();
				Message msg = Message.decode(inputLine);
				if(msg.type.equals("alive")){
					allive = true;
					continue;
				}
				received.add(msg);
			}catch(Exception e){}
		}
	}});
	
	private boolean allive;
	private Thread living = new Thread(new Runnable() {@Override public void run() {
		while(connected){
			allive = false;
			sendMessage(new Message("Server", "alive", "Are you alive?"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!allive)
				Main.Disconnected(id);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}});

	
}
