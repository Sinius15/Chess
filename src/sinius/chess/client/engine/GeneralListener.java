package sinius.chess.client.engine;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import sinius.chess.client.state.StatsOverlay;
import sinius.chess.common.SynchroniezedList;

public class GeneralListener implements ComponentListener, KeyListener, MouseListener, MouseMotionListener{

	public SynchroniezedList<Integer> pressedKeys = new SynchroniezedList<Integer>();
	public SynchroniezedList<Integer> pressedMouse = new SynchroniezedList<Integer>();
	
	public int latestMouseX, latestMouseY, mouseX, mouseY;

	@Override
	public void mouseDragged(MouseEvent event) {
		
		int mouseX = event.getX();
		int mouseY = event.getY();
		
		if(mouseX ==this.mouseX && mouseY == this.mouseY){
			return;
		}
		
		if(mouseX <800 && mouseX>=0 && mouseY <800 && mouseY>=0){
			latestMouseX = this.mouseX;
			latestMouseY = this.mouseY;
			this.mouseX = mouseX;
			this.mouseY = mouseY;
		}else{
			latestMouseX = -1;
			mouseX = -1;
			mouseY = -1;
		}
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		
		int mouseX = event.getX();
		int mouseY = event.getY();
		
		if(mouseX == this.mouseX && mouseY == this.mouseY){
			return;
		}
		
		if(mouseX <800 && mouseX>=0 && mouseY <800 && mouseY>=0){
			this.latestMouseX = this.mouseX;
			this.latestMouseY = this.mouseY;
			this.mouseX = mouseX;
			this.mouseY = mouseY;
		}else{
			this.latestMouseX = -1;
			this.mouseX = -1;
			this.mouseY = -1;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.mouseX = -1;
		this.mouseY = -1;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!pressedMouse.contains((Integer)e.getButton())){
			pressedMouse.add((Integer)e.getButton());
		}
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(pressedMouse.contains((Integer)e.getButton())){
			pressedMouse.remove((Integer)e.getButton());
		}
			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!pressedKeys.contains((Integer)e.getKeyCode()))
			pressedKeys.add((Integer)e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(pressedKeys.contains((Integer)e.getKeyCode()))
			pressedKeys.remove((Integer)e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_F3)
			StatsOverlay.show();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
	}


}
