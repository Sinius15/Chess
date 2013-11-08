package sinius.chess.client.state;

import java.awt.Graphics2D;

public class StatsOverlay implements GrapicsLayer{

	private static boolean show = false;
	
	@Override
	public String getName() {
		return "stats";
	}

	@Override
	public void Draw(Graphics2D g) {
		if(!show)
			return;
		
		
	}

	@Override
	public int priority() {
		return 10;
	}

	@Override
	public boolean drawAfter() {
		return true;
	}

	public static void show() {
		show = !show;
	}
	
	public static boolean isShow(){
		return show;
	}

}
