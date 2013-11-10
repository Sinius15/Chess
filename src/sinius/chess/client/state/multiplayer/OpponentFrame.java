package sinius.chess.client.state.multiplayer;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import sinius.chess.common.shah.Message;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpponentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer update;
	private JList<String> list;
	private Server server;
	public static JFrame thiss;

	public OpponentFrame(final Server ss) {
		thiss = this;
		this.server = ss;
		update = new Timer();
		setResizable(false);
		setTitle("player list -  Sinius Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 249, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList<String>();
		list.setValueIsAdjusting(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		update.schedule(new TimerTask() { @Override public void run() {
			list.setListData(server.getOnlinePlayers());
		}}, 1, 3000);
		list.setBounds(10, 62, 221, 189);
		contentPane.add(list);
		
		JLabel lblConnectedTo = new JLabel("Connected to " + server.ip + ":" + server.port);
		lblConnectedTo.setBounds(10, 12, 221, 14);
		contentPane.add(lblConnectedTo);
		
		JLabel lblOnlinePlayers = new JLabel("online players:");
		lblOnlinePlayers.setBounds(10, 37, 96, 14);
		contentPane.add(lblOnlinePlayers);
		
		JButton btnChalange = new JButton("Chalange Player");
		btnChalange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue() == null){
					JOptionPane.showMessageDialog(thiss, "Select an opponent", "No opponent selected", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(list.getSelectedValue().equals(ss.myName)){
					JOptionPane.showMessageDialog(thiss, "Cannot play against yourself", "chose an other opponent", JOptionPane.ERROR_MESSAGE);
					return;
				}
				server.sendMessage(new Message("client" + server.id, "match_request", list.getSelectedValue()));
			}
		});
		btnChalange.setBounds(10, 263, 221, 23);
		contentPane.add(btnChalange);
	}
}
