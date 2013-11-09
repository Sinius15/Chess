package sinius.chess.client.state.menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinius.chess.client.Game;
import sinius.chess.client.engine.GButton;
import sinius.chess.client.engine.GObject;
import sinius.chess.client.state.GameState;
import sinius.chess.client.state.GrapicsLayer;
import sinius.chess.client.state.play.PlayState;
import sinius.chess.common.SynchroniezedList;

public class MenuState implements GameState{

	SynchroniezedList<GrapicsLayer> layers = new SynchroniezedList<>();
	SynchroniezedList<GObject> gObjcs = new SynchroniezedList<>();
	
	public MenuState(){
		GButton sp = new GButton(100, 100, 200, 50);
		sp.setText("Single Player");
		sp.setButtonColor(Color.blue);
		sp.setTextColor(Color.white);
		sp.setAction(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
			Game.display.setGameState(new PlayState());
		}});
		gObjcs.add(sp);
		
	}
	
	@Override
	public String getName() {
		return "menu";
	}

	@Override
	public void tick() {
	}

	@Override
	public SynchroniezedList<GObject> getGObjects() {
		return gObjcs;
	}

	@Override
	public SynchroniezedList<GrapicsLayer> getGraphicsLayers() {
		return layers;
	}

	@Override
	public void mouseEvent(int button) {
	}

	@Override
	public void keyEvent(int button) {
	}

	
	
}
