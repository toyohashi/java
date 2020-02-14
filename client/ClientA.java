import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.sound.midi.*;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

//interface
interface Client {
	public void go();

	public void setUpNetworking(String ip, int port, String userName);
}

//Super class ClientA
public class ClientA implements Client {

	private JPanel contentPane;
	private JTextField IpField;
	private JTextField PortField;
	private JTextField NameField;
	//private JLabel lblNewLabel_1;
	String userName;
	Socket socket;
	DataOutputStream out;
	JFrame frame = new JFrame("Online Quiz");

	public void go() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 496, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel infoLabel = new JLabel("Enter infomation to play the Online Quiz  ");
		infoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		infoLabel.setBounds(84, 24, 320, 48);
		contentPane.add(infoLabel);

		JLabel serverLabel = new JLabel("Server IP");
		serverLabel.setBounds(63, 104, 61, 16);
		contentPane.add(serverLabel);

		JLabel portLabel = new JLabel("Port");
		portLabel.setBounds(63, 142, 61, 16);
		contentPane.add(portLabel);

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(63, 186, 61, 16);
		contentPane.add(nameLabel);

		IpField = new JTextField();
		IpField.setBounds(136, 99, 182, 26);
		contentPane.add(IpField);
		IpField.setColumns(10);

		PortField = new JTextField();
		PortField.setBounds(136, 137, 182, 26);
		contentPane.add(PortField);
		PortField.setColumns(10);

		NameField = new JTextField();
		NameField.setBounds(138, 181, 180, 26);
		contentPane.add(NameField);
		NameField.setColumns(10);

		JButton confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		confirmButton.setBounds(109, 282, 117, 29);
		contentPane.add(confirmButton);
		confirmButton.addActionListener(new confirmButtonListener());

		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		quitButton.setBounds(262, 282, 117, 29);
		contentPane.add(quitButton);
		quitButton.addActionListener(new quitButtonListener());

		frame.setVisible(true);
	}

	//Create socket, request connect to Server;
	public void setUpNetworking(String ip, int port, String userName) {
		try {
			
			socket = new Socket(ip, port);
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(userName);
			out.flush();

			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			List<quizQuestion> questions = (List<quizQuestion>) in.readObject();

			JOptionPane.showMessageDialog(frame, "Login sucesfully. Game start!");
			playGame game = new playGame();
			game.start(userName, questions, socket);

			// Run play background music thread
			playBackgroudMusic playmusictask = new playBackgroudMusic();
			Thread thread = new Thread(playmusictask);
			thread.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// main class
	public static void main(String[] args) throws Exception {
		new ClientA().go();
	}

	// inner class quitButtonListener
	public class quitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);

		}

	}

	// inner class confirmButtonListener
	public class confirmButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String ip = IpField.getText();
			int port = Integer.parseInt(PortField.getText());
			userName = NameField.getText();
			System.out.println("Send connect request to Server......");
			setUpNetworking(ip, port, userName);
			frame.dispose();
			System.out.println("Connected to Server sucesfully!");

		}

	}

}

class playBackgroudMusic implements Runnable {
	public void run() {
		System.out.println("Start to play background music...");
		try {
            Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
            if (sequencer==null) {
                System.err.println("Sequencer device not supported");
                return;
            } 
            sequencer.open(); // Open device
            // Create sequence, the File must contain MIDI file data.
            Sequence sequence = MidiSystem.getSequence(new File("Just_Stay.midi"));
            sequencer.setSequence(sequence); // load it into sequencer
            sequencer.setLoopCount(10); //Loop 10 times
            sequencer.start();  // start the sequencer
            
        } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
        }
	}
}
