package sinius.chess;

import gui.LBufferedImage;
import gui.LFrame;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


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
        for(int row = 0; row<8;row++){
        	for(int colom = 0; colom < 8; colom++){
        		if(Main.board.selected[row][colom]){
        			if(canvas.get().getRGB(row, colom) == Main.white.getRGB()){
        				graphics.setColor(Main.white_selected);
        				graphics.fillRect(colom*50, row*50, 50, 50);
        			}else{
        				graphics.setColor(Main.black_selected);
        				graphics.fillRect(colom*50, row*50, 50, 50);
        			}
        		}
        		
        	}
        }
	}
	
	
	
	public void drawPieces() throws IOException{
		for(int x = 0; x<8; x++){
			for(int y = 0;y<8;y++){
				Piece p = Main.board.pieces[x][y];
				if(p.nr() == 0){
					continue;
				}
				BufferedImage in = ImageIO.read(p.getImg());
				graphics.drawImage(in, x*50, y*50, null);				
				canvas.updateUI();
			}
		}
		
	}
	
	
}
