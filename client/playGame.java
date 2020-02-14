import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.List;
import java.awt.event.*;
import java.net.*;
import java.io.*;

//Perform game processing: print question, scoring,....
public class playGame {
    private JPanel contentPane;
    private JTextArea questionField;
    private JTextField answerField;
    private JLabel guideLabel;
    private JTextArea scoreField;
    List<quizQuestion> gameQuestions;
    int random;
    int index = 1;
    int score = 0;
    Socket socket;
    DataOutputStream dos;

    String loadUserName;
    JFrame frame2 = new JFrame();

    public void start(String userName, List<quizQuestion> questions, Socket socket) throws IOException{
        this.gameQuestions = questions;
        this.loadUserName = userName;
        this.socket = socket;
        dos = new DataOutputStream(socket.getOutputStream());

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setBounds(100, 100, 496, 444);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame2.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel gameLabel = new JLabel("Online Quiz Home");
        gameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        gameLabel.setBounds(162, 10, 146, 28);
        contentPane.add(gameLabel);

        questionField = new JTextArea();
        questionField.setBounds(28, 50, 292, 226);
        contentPane.add(questionField);
        questionField.setColumns(10);

        scoreField = new JTextArea();
        scoreField.setBounds(332, 51, 146, 226);
        contentPane.add(scoreField);
        scoreField.setColumns(10);

        JButton answerButton = new JButton("Answer");
        answerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        answerButton.setBounds(162, 366, 117, 38);
        contentPane.add(answerButton);
        answerButton.addActionListener(new answerButtonListener());

        guideLabel = new JLabel("Type your answer A, B, C or D and then click answer button\n");
        guideLabel.setBounds(26, 288, 377, 28);
        contentPane.add(guideLabel);

        answerField = new JTextField();
        answerField.setBounds(162, 328, 117, 26);
        contentPane.add(answerField);
        answerField.setColumns(10);
        frame2.setVisible(true);

        random = (int) (gameQuestions.size() * Math.random());
        questionField.setLineWrap(true);
        questionField.setWrapStyleWord(true);
        questionField.setText("Q" + index + ": " + gameQuestions.get(random).showPromt());
        
        // Display score in scoreArea
        scoreField.setText("User:\n" + loadUserName + "\n");
        scoreField.append("Your score: " + score + "/" + (index - 1));

    }

    // Inner class "Answer" button Listener
    class answerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String answer = answerField.getText().toUpperCase();

            if ((answer.contentEquals("A")) || (answer.contentEquals("B")) || (answer.contentEquals("C"))
                    || (answer.contentEquals("D"))) {
                if (answer.contentEquals(gameQuestions.get(random).showAnswer())) {
                    score++;
                }
                questionField.setText("");
                answerField.setText("");
                gameQuestions.remove(random);

                // Display score in scoreArea
                scoreField.setText("User:\n" + loadUserName + "\n");
                scoreField.append("Your score: " + score + "/" + index);
                // If user completed question 10, show pop up which print the score and quit game.
                if (index == 10) {
                    JOptionPane.showMessageDialog(frame2,
                            "Game finished!" + "\n" + "Name:" + loadUserName + "\n" + "Your score: " + score+"/10");
                    try{
                        dos.writeUTF(String.valueOf(score));
                        socket.close();
                        System.exit(0);
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    

                }

                index++;
                random = (int) (gameQuestions.size() * Math.random());
                questionField.setText("Q" + index + ": " + gameQuestions.get(random).showPromt());
            } else {
                JOptionPane.showMessageDialog(frame2,
                        "Illegal character!" + "\n" + "Please retype your answer as A, B, C or D.", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }

}
