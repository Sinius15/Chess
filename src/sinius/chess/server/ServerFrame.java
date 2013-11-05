package sinius.chess.server;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class ServerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input;
	private JTextPane console;
	private HTMLEditorKit kit;
	private HTMLDocument doc;
	
	public ServerFrame() {
		setTitle("Sinius Chess - Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		console = new JTextPane();
	    kit = new HTMLEditorKit();
	    doc = new HTMLDocument();
	    console.setEditorKit(kit);
	    console.setDocument(doc);
	    scrollPane.setViewportView(console);
	    
		input = new JTextField();
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					InputHandler.handleInput(input.getText());
					input.setText("");
				}
			}
		});
		contentPane.add(input, BorderLayout.SOUTH);
		input.setColumns(10);
	}
	
	public void gameMessage(String s){
		try {
			kit.insertHTML(doc, doc.getLength(), "<font color=\"blue\">[chess]</font> " + s, 0, 0, null);
		} catch (BadLocationException | IOException e) {}
	}
	
	public void IOMessage(String s){
		try {
			kit.insertHTML(doc, doc.getLength(), "<font color=\"green\">[io]</font> " + s, 0, 0, null);
		} catch (BadLocationException | IOException e) {}
	}
	
	public void errorMessage(String s){
		try {
			kit.insertHTML(doc, doc.getLength(), "<font color=\"red\">[error]</font> " + s, 0, 0, null);
		} catch (BadLocationException | IOException e) {}
	}

}
