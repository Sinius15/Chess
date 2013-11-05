package sinius.chess.client;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChessFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel status;
	public Canvas canvas;
	
	public ChessFrame() {
		setResizable(false);
		setTitle("Sinius's Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(0, 0, 400, 400);
		canvas.setPreferredSize(new Dimension(400, 400));
		contentPane.add(canvas);
		
		JLabel status = new JLabel("Turn: ");
		status.setBounds(4, 406, 63, 14);
		contentPane.add(status);
		setLocationRelativeTo(null);
	}
}
