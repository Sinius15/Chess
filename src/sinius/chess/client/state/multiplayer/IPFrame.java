package sinius.chess.client.state.multiplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class IPFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JSpinner spinner;
	private JFrame thiss;
	private JTextField txtName;

	public IPFrame() {
		thiss = this;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
			e2.printStackTrace();
		}

		setResizable(false);
		setTitle("Sinius Chess - Connector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 138);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(70, 42, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(258), new Integer(1), null, new Integer(1)));
		spinner.setBounds(246, 42, 63, 20);
		contentPane.add(spinner);
		
		JLabel lblIpServer = new JLabel("IP server");
		lblIpServer.setBounds(10, 45, 46, 14);
		contentPane.add(lblIpServer);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(213, 45, 46, 14);
		contentPane.add(lblPort);
		
		txtName = new JTextField();
		txtName.setBounds(70, 11, 239, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MultiPlayerState.server = new Server(textField.getText(), (int) spinner.getValue(), txtName.getText());
					OpponentFrame f = new OpponentFrame(MultiPlayerState.server);
					f.setVisible(true);
					thiss.dispose();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(thiss, "Could not connect to the server", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConnect.setBounds(10, 73, 299, 25);
		contentPane.add(btnConnect);
		
		JLabel lblYourName = new JLabel("Your Name");
		lblYourName.setBounds(10, 11, 63, 14);
		contentPane.add(lblYourName);
		
		
	}
}