package sinius.chess;

import gui.LBufferedImage;
import gui.LButton;
import gui.LFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Gui {

	LFrame frame;
	Dimension dim = new Dimension(400,400);
	LBufferedImage canvas = new LBufferedImage(dim.width, dim.height);
	Graphics2D graphics = canvas.get().createGraphics();

	public Gui(){
		frame = new LFrame();
		frame.setSize(dim.width + (frame.get().getWidth()-frame.get().getContentPane().getWidth()), dim.height + (frame.get().getHeight()-frame.get().getContentPane().getHeight()));
		canvas.setSize(dim);
		frame.setTitel("Chess");
		frame.add(canvas);
		frame.get().getContentPane().addMouseListener(new KeyHandler());

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
				canvas.updateUI();
			}
		}

	}


	public static Piece showPionChoseSceen(final String color, final int x, final int y) {
		final LFrame f = new LFrame();
		ActionListener a = new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
				Main.canPlay = true;
				if(color.equals("black")){
					switch (((JButton) e.getSource()).getX()) {
						case 1: Main.board.pieces[x][y] = Main.board.getPieceByNumber(10); break;
						case 83: Main.board.pieces[x][y] = Main.board.getPieceByNumber(8); break;
						case 165: Main.board.pieces[x][y] = Main.board.getPieceByNumber(6); break;
						case 247: Main.board.pieces[x][y] = Main.board.getPieceByNumber(4); break;
					default:
						break;
					}
				}
				if(color.equals("white")){
					switch (((JButton) e.getSource()).getX()) {
						case 1: Main.board.pieces[x][y] = Main.board.getPieceByNumber(9); break;
						case 83: Main.board.pieces[x][y] = Main.board.getPieceByNumber(7); break;
						case 165: Main.board.pieces[x][y] = Main.board.getPieceByNumber(5); break;
						case 247: Main.board.pieces[x][y] = Main.board.getPieceByNumber(3); break;
					default:
						break;
					}
				}
				f.get().dispose();
				Main.updateAll();
			}
		};
		
		LButton queen = new LButton();
		LButton rook = new LButton();
		LButton bishop = new LButton();
		LButton knight = new LButton();
		queen.setSize(80, 80);  queen.setPlace(0, 0);		queen.get().addActionListener(a);
		rook.setSize(80, 80);   rook.setPlace(1, 0);		rook.get().addActionListener(a);
		bishop.setSize(80, 80); bishop.setPlace(2, 0);		bishop.get().addActionListener(a);
		knight.setSize(80, 80); knight.setPlace(3, 0);		knight.get().addActionListener(a);
		
		queen.get().setIcon(new ImageIcon("rec/Queen_" + color + ".png"));
		rook.get().setIcon(new ImageIcon("rec/rook_" + color + ".png"));
		bishop.get().setIcon(new ImageIcon("rec/bishop_" + color + ".png"));
		knight.get().setIcon(new ImageIcon("rec/knight_" + color + ".png"));
		f.get().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setTitel("Chose a piece");
		f.add(queen);	
		f.add(rook);
		f.add(bishop);
		f.add(knight);
		f.get().pack();
		
		
		
		return null;
	}
	
}
