package sinius.chess.common.shah;

import java.util.regex.Pattern;

public class Message {
	
	public String sender;
	public String type;
	public String message;
	
	public Message(String sender, String type, String message){
		this.sender = sender;
		this.type = type;
		this.message = message;
	}
	
	public static Message decode(String input){
		String[] split = input.replaceAll(Pattern.compile("shahMSG:\\(").toString(), "").split(Pattern.compile("\\(").toString());
		Message out = new Message(
				split[0].replaceAll("\\)", "").replaceAll("\\*sender\\*", ""), 
				split[1].replaceAll("\\)", "").replaceAll("\\*type\\*", ""), 
				split[2].replaceAll("\\)", "").replaceAll("\\*message\\*", "")
		);
		return out;
	}
	
	public static String encode(Message in){
		return "shahMSG:(*sender*" + in.sender + ")(*type*" + in.type + ")(*message*" + in.message + ")";
	}
	
	public String encode(){
		return "shahMSG:(*sender*" + sender + ")(*type*" + type + ")(*message*" + message + ")";
	}
	
}
