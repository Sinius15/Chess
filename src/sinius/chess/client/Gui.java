package sinius.chess.client;

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

public class Gui {
	
	public static class ChoseFrame extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JFrame thiss;

		public ChoseFrame(final String color, final int xx, final int yy) {
			ActionListener a = null;
			a = new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
				checkSpecial.canPlay = true;
				if(color.equals("black")){
					switch (((JButton) e.getSource()).getX()) {
						case 5: Game.board.pieces[xx][yy] = Game.board.getPieceByNumber(10); break;	//queen
						case 93: Game.board.pieces[xx][yy] = Game.board.getPieceByNumber(8); break;	//rook
						case 181: Game.board.pieces[xx][yy] = Game.board.getPieceByNumber(6); break;	//bishop
						case 269: Game.board.pieces[xx][yy] = Game.board.getPieceByNumber(4); break;	//knight
					default:
						break;
					}
				}
				if(color.equals("white")){
					switch (((JButton) e.getSource()).getX()) {
						case 5: Game.board.pieces[xx][yy] = Game.board.getPieceByNumber(9); break;
						case 93: Game.board.pieces[xx][yy] = Game.board.getPieceByNumber(7); break;
						case 181: Game.board.pieces[xx][yy] = Game.board.getPieceByNumber(5); break;
						case 269: Game.board.pieces[xx][yy] = Game.board.getPieceByNumber(3); break;
					default:
						break;
					}
				}
				checkSpecial.canPlay = true;
				thiss.dispose();
			}};
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
			
			JButton queen = new JButton();
			queen.addActionListener(a);
			queen.setLocation(0, 0);
			GridBagConstraints gbc_queen = new GridBagConstraints();
			gbc_queen.fill = GridBagConstraints.BOTH;
			gbc_queen.insets = new Insets(0, 0, 0, 5);
			gbc_queen.gridx = 0;
			gbc_queen.gridy = 0;
			contentPane.add(queen, gbc_queen);
			
			JButton rook = new JButton();
			rook.addActionListener(a);
			rook.setLocation(1, 0);
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.BOTH;
			gbc_button.insets = new Insets(0, 0, 0, 5);
			gbc_button.gridx = 1;
			gbc_button.gridy = 0;
			contentPane.add(rook, gbc_button);
			
			JButton bishop = new JButton();
			bishop.addActionListener(a);
			bishop.setLocation(2, 0);
			GridBagConstraints gbc_button_1 = new GridBagConstraints();
			gbc_button_1.fill = GridBagConstraints.BOTH;
			gbc_button_1.insets = new Insets(0, 0, 0, 5);
			gbc_button_1.gridx = 2;
			gbc_button_1.gridy = 0;
			contentPane.add(bishop, gbc_button_1);
			
			JButton knight = new JButton();
			knight.addActionListener(a);
			knight.setLocation(3, 0);
			GridBagConstraints gbc_button_2 = new GridBagConstraints();
			gbc_button_2.fill = GridBagConstraints.BOTH;
			gbc_button_2.gridx = 3;
			gbc_button_2.gridy = 0;
			contentPane.add(knight, gbc_button_2);
			
			if(color.equalsIgnoreCase("black")){
				queen.setIcon(new ImageIcon(Game.baseImage.getImageById(3)));
				rook.setIcon(new ImageIcon(Game.baseImage.getImageById(7)));
				bishop.setIcon(new ImageIcon(Game.baseImage.getImageById(9)));
				knight.setIcon(new ImageIcon(Game.baseImage.getImageById(11)));
			}else{
				queen.setIcon(new ImageIcon(Game.baseImage.getImageById(4)));
				rook.setIcon(new ImageIcon(Game.baseImage.getImageById(8)));
				bishop.setIcon(new ImageIcon(Game.baseImage.getImageById(10)));
				knight.setIcon(new ImageIcon(Game.baseImage.getImageById(12)));
			}
			
			
			
			
			pack();
		}
	}

	public static void showPionChoseSceen(String color, int x, int y) {
		ChoseFrame f = new ChoseFrame(color, x, y);
		f.setVisible(true);
		
	}
}
