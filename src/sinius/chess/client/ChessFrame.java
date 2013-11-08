package sinius.chess.client;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private DrawPane contentPane;
	public JLabel status;
	public BufferedImage canvas;
	
	public ChessFrame() {

		setTitle("Sinius's Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new DrawPane();
		contentPane.setPreferredSize(new Dimension(400, 400));
		setContentPane(contentPane);
		setResizable(false);
		pack();
		
		setLocationRelativeTo(null);
	}
	
	public class DrawPane extends JPanel{
		private static final long serialVersionUID = 1L;
		@Override
		public void paintComponents(Graphics g) {
			g.drawImage(Main.gui.canvas, 0, 0, null);
		}
	}
}
