import java.awt.*;
import javax.swing.*;

public class Rules {
    public Rules(){
        JFrame frame2 = new JFrame();
        frame2.setSize(1000, 500);
        frame2.setLayout(null);
        frame2.setTitle("Rules and Gameplay");
        frame2.setResizable(false);
        frame2.getContentPane().setBackground(Color.WHITE);
        frame2.setLocationRelativeTo(null);

        ImageIcon img = new ImageIcon(MainFrame.class.getResource("/gamelogoicon.png"));
        frame2.setIconImage(img.getImage());

        JTextArea txt = new JTextArea();
        txt.setVisible(true);
        txt.setEditable(false);
        txt.setBackground(Color.BLACK);
        txt.setForeground(Color.WHITE);
        txt.setText("1. Random Number Generation: A random number between 1 and 100 is generated.\n" +
                    "2. User Guess: The user is prompted to guess the generated number.\n" +
                    "3. Feedback on Guess:\n" +
                    "   - If the guess is correct, the user is informed and the game ends.\n" +
                    "   - If the guess is incorrect, the user is told whether the guess is too high or too low.\n" +
                    "4. Hints:\n" +
                    "   - The user has 4 chances to guess the number.\n" +
                    "   - After the third attempt, the user is given a hint indicating whether the number is even or odd.\n" +
                    "5. Limited Attempts:\n" +
                    "   - The user has a maximum of 4 attempts to guess the number correctly.\n" +
                    "6. Multiple Rounds:\n" +
                    "   - The user can choose to play multiple rounds.\n" +
                    "   - The user's score is displayed, which is based on the number of attempts taken or rounds won.\n" +
                    "7. Score Display:\n" +
                    "   - The score is tracked and displayed after each round.");
        Font font = new Font("Arial", Font.BOLD, 20);
        txt.setFont(font);
        JScrollPane pane = new JScrollPane(txt);
        pane.setBounds(10, 10, 965, 445);

        frame2.add(pane);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Rules();
    }
}
