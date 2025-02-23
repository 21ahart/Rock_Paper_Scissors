import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;

public class RockPaperScissorsFrame extends JFrame {
    private static int[] scores = {0, 0, 0};
    private static int[] playerChoicesCount = {0, 0, 0};
    private static int lastPlayerChoice = -1;

    private JTextField playerWinsField;
    private JTextField computerWinsField;
    private JTextField tiesField;
    private JTextArea resultArea;

    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        ImageIcon rockIcon = new ImageIcon(new ImageIcon(getClass().getResource("rock.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon paperIcon = new ImageIcon(new ImageIcon(getClass().getResource("paper.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon scissorsIcon = new ImageIcon(new ImageIcon(getClass().getResource("scissors.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon quitIcon = new ImageIcon(new ImageIcon(getClass().getResource("quit-icon.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        JButton rockButton = new JButton(rockIcon);
        rockButton.addActionListener(e -> rockButtonClicked());
        JButton paperButton = new JButton(paperIcon);
        paperButton.addActionListener(e -> paperButtonClicked());
        JButton scissorsButton = new JButton(scissorsIcon);
        scissorsButton.addActionListener(e -> scissorsButtonClicked());
        JButton quitButton = new JButton(quitIcon);
        quitButton.addActionListener(e -> quitButtonClicked());

        panel.add(rockButton);
        panel.add(paperButton);
        panel.add(scissorsButton);
        panel.add(quitButton);

        add(panel, BorderLayout.NORTH);

        JPanel statsPanel = new JPanel();

        JLabel playerWinsLabel = new JLabel("Player Wins: ");
        JLabel computerWinsLabel = new JLabel("Computer Wins: ");
        JLabel tiesLabel = new JLabel("Ties: ");

        playerWinsField = new JTextField(5);
        computerWinsField = new JTextField(5);
        tiesField = new JTextField(5);

        playerWinsField.setEditable(false);
        computerWinsField.setEditable(false);
        tiesField.setEditable(false);

        statsPanel.add(playerWinsLabel);
        statsPanel.add(playerWinsField);
        statsPanel.add(computerWinsLabel);
        statsPanel.add(computerWinsField);
        statsPanel.add(tiesLabel);
        statsPanel.add(tiesField);

        add(statsPanel, BorderLayout.SOUTH);

        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void rockButtonClicked() {
        playGame(0);
    }

    private void paperButtonClicked() {
        playGame(1);
    }

    private void scissorsButtonClicked() {
        playGame(2);
    }

    private void quitButtonClicked() {
        System.exit(0);
    }

    private void playGame(int playerChoice) {
        int computerChoice = RockPaperScissorsCPU.getComputerChoice(playerChoicesCount, playerChoice, lastPlayerChoice);
        playerChoicesCount[playerChoice]++;

        if (playerChoice == computerChoice) {
            resultArea.append("Its a Tie\n");
            scores[2]++;
        } else if ((playerChoice + 1) % 3 == computerChoice) {
            scores[0]++;
            switch (playerChoice){
                case 0:
                    resultArea.append("Rock breaks scissors. (Player wins)\n");
                    break;
                case 1:
                    resultArea.append("Paper covers rock. (Player wins)\n");
                    break;
                case 2:
                    resultArea.append("Scissors cut paper. (Player wins)\n");
                    break;
            }
        } else {
            scores[1]++;
            switch (playerChoice){
                case 0:
                    resultArea.append("Paper covers Rock. (Computer wins)\n");
                    break;
                case 1:
                    resultArea.append("Scissors cuts Paper. (Computer wins)\n");
                    break;
                case 2:
                    resultArea.append("Rock bresks Scissors. (Computer wins)\n");
                    break;
            }
        }
        playerWinsField.setText(Integer.toString(scores[0]));
        computerWinsField.setText(Integer.toString(scores[1]));
        tiesField.setText(Integer.toString(scores[2]));
        lastPlayerChoice = playerChoice;
    }
}