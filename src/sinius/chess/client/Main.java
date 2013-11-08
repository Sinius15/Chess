package sinius.chess.client;

import java.io.IOException;

public class Main {
	
	public static int id;
	
//	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
		
		Game.init();
		
		/*//internet 
        String hostName = "37.251.48.220";
        int portNumber = 4444;

        Socket socket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	
    	Thread t = new Thread(new Runnable() {@Override public void run() {
			String fromServer;
			try {
				while ((fromServer = in.readLine()) != null) {
					Message msg = Message.decode(fromServer);
					if(msg.type.equals("id")){
						id = Integer.parseInt(msg.message);
						return;
					}
						
				}
			}catch (IOException e) { }
		}}, "reader");
		t.start();*/
		
		
		
	}
	


}
