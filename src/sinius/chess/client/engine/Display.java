package sinius.chess.client.engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sinius.chess.client.state.GameState;
import sinius.chess.client.state.GrapicsLayer;
import sinius.chess.client.state.StatsOverlay;
import sinius.chess.common.SynchroniezedList.editAction;

public class Display{

	private JFrame frame;
	private DrawPane pane;
	private GeneralListener listner = new GeneralListener();
	public GameState gameState;
	private BufferedImage img;
	private BufferedImage output;
	private Color bgColor;
	public Dimension contentSize ;
	
	private int i;
	
	private StatsOverlay stats = new StatsOverlay();
	
	
	public Display(int width, int height, String title, GameState state, Color backGround){
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		contentSize = new Dimension(width, height);
		bgColor = backGround;
		
		gameState = state;
		frame = new JFrame();
		pane = new DrawPane();
		frame.setResizable(true);
		pane.setPreferredSize(new Dimension(width, height));
		frame.setContentPane(pane);
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		pane.addMouseListener(listner);
		pane.addMouseMotionListener(listner);
		frame.addKeyListener(listner);
		frame.addComponentListener(listner);
		
		pane.addMouseListener(getMouseListener());
	}
	
	public void onTick(){
		listner.pressedKeys.doForAll(new editAction<Integer>() { @Override public void action(Integer o) {
			gameState.keyEvent(o);
		}});
		
		listner.pressedMouse.doForAll(new editAction<Integer>() { @Override public void action(Integer o) {
				gameState.mouseEvent(o);
		}});
	}
	
	public class DrawPane extends JPanel{
		private static final long serialVersionUID = -6825107813851526680L;
		public void paintComponent(Graphics gg){
			final Graphics graphics = output.getGraphics();
			
			graphics.drawImage(img, 0, 0, null);
			
			if(gameState.getGraphicsLayers() != null)
			gameState.getGraphicsLayers().doForAll(new editAction<GrapicsLayer>() { @Override public void action(GrapicsLayer l) {
				if(l.drawAfter())
					l.Draw((Graphics2D) graphics);
			}});
			if(gameState.getGObjects() != null)	
				gameState.getGObjects().doForAll(new editAction<GObject>() { @Override public void action(GObject g) {
					g.Draw((Graphics2D) graphics);
			}});
			stats.Draw((Graphics2D) graphics);
			gg.drawImage(output, 0, 0, frame.getWidth()-frame.getInsets().left-frame.getInsets().right, frame.getHeight()-frame.getInsets().top-frame.getInsets().bottom, null);
		}
	}
	
	public void reDraw(){
		output.getGraphics().setColor(bgColor);
		output.getGraphics().fillRect(0, 0, contentSize.width, contentSize.height);
		
		if(gameState.getGraphicsLayers() != null)
			for(i = 0 ; i<11 ; i++){
				gameState.getGraphicsLayers().doForAll(new editAction<GrapicsLayer>() { @Override public void action(GrapicsLayer l) {
					if(!l.drawAfter())
						if(l.priority() == i)
							l.Draw(img.createGraphics());
				}});
			}
		frame.repaint();
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public DrawPane getPanel(){
		return pane;
	}
	
	public void resetSize(){
		frame.setSize(new Dimension(contentSize.width+frame.getInsets().left+frame.getInsets().right, contentSize.height+frame.getInsets().top+frame.getInsets().bottom));
		frame.revalidate();
	}
	
	public float getZoomX(){
		return ((float)(frame.getWidth()-frame.getInsets().left-frame.getInsets().right))/contentSize.width;
	}
	public float getZoomY(){
		return ((float)(frame.getHeight()-frame.getInsets().top-frame.getInsets().bottom))/contentSize.height;
	}
	
	private MouseListener getMouseListener(){
		return new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			
			@Override
			public void mouseClicked(final MouseEvent ar) {
				final MouseEvent e = new MouseEvent(ar.getComponent(), ar.getID(), ar.getWhen(), ar.getModifiers(), (int)(ar.getX()/getZoomX()), (int)(ar.getY()/getZoomY()), ar.getXOnScreen(), ar.getYOnScreen(), ar.getClickCount(), false, ar.getButton());
				if(gameState.getGObjects() != null)
					gameState.getGObjects().doForAll(new editAction<GObject>() { @Override public void action(GObject o) {
						o.MouseClick(e);
					}});
			}
		};
	}
	
	public void setGameState(GameState t){
		gameState = t;
	}
}
