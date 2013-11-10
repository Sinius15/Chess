package sinius.chess.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

import sinius.chess.common.SynchroniezedList;
import sinius.chess.common.SynchroniezedList.editAction;

public class Main {

	public static ServerFrame gui;
	public static SynchroniezedList<Client> clients = new SynchroniezedList<>();
	public static SynchroniezedList<Match> matches = new SynchroniezedList<>();
	public static ServerSocket serverSocket;
	
	public static void main(String[] args) throws IOException {
		gui = new ServerFrame();
		gui.setVisible(true);
		
		
		
		serverSocket = new ServerSocket(258);
        Thread clientListener = new Thread(new Runnable() {@Override public void run() {
        	Client temp;
        	while(true){
				try {
					temp = new Client(serverSocket.accept(), clients.size()+1);
					clients.add(temp);
					gui.IOMessage("client connected. Ip: " + temp.socket.getInetAddress() + ":" + temp.socket.getPort() + " , ID: " + temp.id);
				
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
        	
		}}, "clientListener");
        clientListener.start();
        InetAddress ip = InetAddress.getLocalHost();
        gui.gameMessage("Starting the server on ip " + ip.getHostAddress() + ":" + serverSocket.getLocalPort());
	}
	
	public static void Disconnected(final int id){
		clients.doForAll(new editAction<Client>() { @Override public void action(Client o) {
			if(o.id == id){
				o.stop();
				gui.IOMessage("client disconnected. ID: " + o.id);
				clients.removeLater(o);
			}
		}});
	}
	
	static String out;
	public static String getPlayerList(){
		out = "";
		clients.doForAll(new editAction<Client>() { @Override public void action(Client o) {
			out = out + o.name + ";";
		}});
		return out;
	}
	
	public static Client returner = null;
	
	public static Client getClient(final String n){
		clients.doForAll(new editAction<Client>() { @Override public void action(Client o) {
			if(o.name.equals(n))
				returner = o;
		}});
		return returner;
	}
	
	public static Client getClient(final int n){
		clients.doForAll(new editAction<Client>() { @Override public void action(Client o) {
			if(o.id == n)
				returner = o;
		}});
		return returner;
	}
	
	public static void createMatch(Client a, Client b){
		matches.add(new Match(a, b));
	}
	
}
