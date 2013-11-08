package sinius.chess.client.engine;

import sinius.chess.client.Game;

public class Engine{

	boolean isRunning = true;
	Thread tickThread;
	Thread drawThread;
	
	public Engine(){
		tickThread = new Thread(tickThread(), "tickThread");
		tickThread.start();
		
		drawThread = new Thread(drawThread(), "drawThread");
		drawThread.start();
	}
	
	public Runnable tickThread() {
		return new Runnable() { @Override public void run() {
			while(isRunning){ 
				Game.onTick();
				try {
					Thread.sleep(10);   //aiming for 100tps
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}};}
	
	public Runnable drawThread() {
		return new Runnable() { @Override public void run() {
			while(isRunning){
				Game.display.reDraw();
				try {
					Thread.sleep(17);	//aiming for 60fps
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
	}};}
	
	public void stopGame(){
		isRunning = false;
	}
}
