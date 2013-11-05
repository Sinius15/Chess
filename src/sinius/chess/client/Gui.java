package sinius.chess.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sinius.chess.common.pieces.Piece;

public class Gui {

	ChessFrame frame;
	Dimension dim = new Dimension(400,400);
	Graphics2D graphics ;

	public Gui(){
		frame = new ChessFrame();
		frame.setVisible(true);
		frame.canvas.addMouseListener(new KeyHandler());
		graphics = (Graphics2D) frame.canvas.getGraphics();
		drawBoard();
	}


	public void drawBoard(){
		graphics.setColor(Main.white);
        for(int row = 0; row<=8;row++){
        	for(int colom = 0; colom <= 8; colom++){
        		graphics.fillRect(colom*50, row*50, 50, 50);
        		if(graphics.getColor().equals(Main.white)){
        			graphics.setColor(Main.black);
	        	}else{
	        		graphics.setColor(Main.white);
	        	}
        	}
        }
	}

	public void drawSelected(){
        for(int x = 0; x<8;x++){
        	for(int y = 0; y < 8; y++){
        		if(Main.board.selected[y][x]){
        			graphics.setColor(Color.pink);
        			graphics.fillRect(x*50, y*50, 50, 50);
        			
        		}
        		
        	}
        }
	}



	public void drawPieces(){
		for(int x = 0; x<8; x++){
			for(int y = 0;y<8;y++){
				Piece p = Main.board.pieces[x][y];
				if(p.nr() == 0){
					continue;
				}
				graphics.drawImage(p.getImg(), x*50, y*50, null);				
				
			}
		}

	}
	
	public static class ChoseFrame extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JFrame thiss;

		public ChoseFrame(final String color, final int xx, final int yy) {
			ActionListener a = null;
			thiss = this;
			setTitle("Chose your pease");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 288, 104);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[]{60, 60, 60, 60, 0};
			gbl_contentPane.rowHeights = new int[]{60, 0};
			gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			contentPane.setLayout(gbl_contentPane);
			
			JButton queen = new JButton("queen");
			queen.addActionListener(a);
			GridBagConstraints gbc_queen = new GridBagConstraints();
			gbc_queen.fill = GridBagConstraints.BOTH;
			gbc_queen.insets = new Insets(0, 0, 0, 5);
			gbc_queen.gridx = 0;
			gbc_queen.gridy = 0;
			contentPane.add(queen, gbc_queen);
			
			JButton rook = new JButton("rook");
			rook.addActionListener(a);
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.BOTH;
			gbc_button.insets = new Insets(0, 0, 0, 5);
			gbc_button.gridx = 1;
			gbc_button.gridy = 0;
			contentPane.add(rook, gbc_button);
			
			JButton bishop = new JButton("queen");
			bishop.addActionListener(a);
			GridBagConstraints gbc_button_1 = new GridBagConstraints();
			gbc_button_1.fill = GridBagConstraints.BOTH;
			gbc_button_1.insets = new Insets(0, 0, 0, 5);
			gbc_button_1.gridx = 2;
			gbc_button_1.gridy = 0;
			contentPane.add(bishop, gbc_button_1);
			
			JButton knight = new JButton("queen");
			queen.addActionListener(a);
			GridBagConstraints gbc_button_2 = new GridBagConstraints();
			gbc_button_2.fill = GridBagConstraints.BOTH;
			gbc_button_2.gridx = 3;
			gbc_button_2.gridy = 0;
			contentPane.add(knight, gbc_button_2);
			if(color.equalsIgnoreCase("black")){
				queen.setIcon(new ImageIcon(ImageLoader.baseImage.getImageById(3)));
				rook.setIcon(new ImageIcon(ImageLoader.baseImage.getImageById(7)));
				bishop.setIcon(new ImageIcon(ImageLoader.baseImage.getImageById(9)));
				knight.setIcon(new ImageIcon(ImageLoader.baseImage.getImageById(11)));
			}else{
				queen.setIcon(new ImageIcon(ImageLoader.baseImage.getImageById(4)));
				rook.setIcon(new ImageIcon(ImageLoader.baseImage.getImageById(8)));
				bishop.setIcon(new ImageIcon(ImageLoader.baseImage.getImageById(10)));
				knight.setIcon(new ImageIcon(ImageLoader.baseImage.getImageById(12)));
			}
			
			a = new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
				Main.canPlay = true;
				if(color.equals("black")){
					switch (((JButton) e.getSource()).getX()) {
						case 1: Main.board.pieces[xx][yy] = Main.board.getPieceByNumber(10); break;
						case 83: Main.board.pieces[xx][yy] = Main.board.getPieceByNumber(8); break;
						case 165: Main.board.pieces[xx][yy] = Main.board.getPieceByNumber(6); break;
						case 247: Main.board.pieces[xx][yy] = Main.board.getPieceByNumber(4); break;
					default:
						break;
					}
				}
				if(color.equals("white")){
					switch (((JButton) e.getSource()).getX()) {
						case 1: Main.board.pieces[xx][yy] = Main.board.getPieceByNumber(9); break;
						case 83: Main.board.pieces[xx][yy] = Main.board.getPieceByNumber(7); break;
						case 165: Main.board.pieces[xx][yy] = Main.board.getPieceByNumber(5); break;
						case 247: Main.board.pieces[xx][yy] = Main.board.getPieceByNumber(3); break;
					default:
						break;
					}
				}
				thiss.dispose();
				Main.updateAll();
			}};
		}
	}

	public static void showPionChoseSceen(String color, int x, int y) {
		ChoseFrame f = new ChoseFrame(color, x, y);
		f.setVisible(true);
		
	}
}
