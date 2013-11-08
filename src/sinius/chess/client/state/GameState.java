package sinius.chess.client.state;

import sinius.chess.client.engine.GObject;
import sinius.chess.common.SynchroniezedList;

public interface GameState {

	public String getName();
	public void tick();
	public SynchroniezedList<GObject> getGObjects();
	public SynchroniezedList<GrapicsLayer> getGraphicsLayers();
	public void mouseEvent(int button);
	public void keyEvent(int button);
	
}
