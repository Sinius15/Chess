package sinius.chess.client.state.play;

import sinius.chess.client.engine.GObject;
import sinius.chess.client.state.GameState;
import sinius.chess.client.state.GrapicsLayer;
import sinius.chess.common.SynchroniezedList;

public class PlayState implements GameState{

	@Override
	public String getName() {
		return "Play";
	}

	@Override
	public void tick() {
		
	}

	@Override
	public SynchroniezedList<GObject> getGObjects() {
		return null;
	}

	@Override
	public SynchroniezedList<GrapicsLayer> getGraphicsLayers() {
		return null;
	}

	@Override
	public void mouseEvent(int button) {
		
	}

	@Override
	public void keyEvent(int button) {
		
	}

}
