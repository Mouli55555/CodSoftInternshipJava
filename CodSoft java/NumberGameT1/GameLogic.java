import java.util.*;
import javax.swing.*;
import java.awt.*;

public class GameLogic {
    public GameLogic() {
        ImageIcon crt = new ImageIcon(GameLogic.class.getResource("/check.png"));
        ImageIcon input = new ImageIcon(GameLogic.class.getResource("/ask.png"));
        ImageIcon error = new ImageIcon(GameLogic.class.getResource("/error.png"));
        ImageIcon tryagain = new ImageIcon(GameLogic.class.getResource("/tryagain.png"));
        ImageIcon playagain = new ImageIcon(GameLogic.class.getResource("/playagain.png"));

        int generatedNumber;
        int userGuess=-1;
        int count;
        String guess;
        int rematch;
        boolean rematch1 = true;
        int scoreVal=0;
        int rounds=0;

        Random rn = new Random();

        while (rematch1) {
            generatedNumber = rn.nextInt(100) + 1;
            // System.out.println(generatedNumber);
            count = 0;
            rematch1 = false;
            rounds++;

            while (count < 4) {
                guess = null;
                do {
                    try {
                        guess = (String) JOptionPane.showInputDialog(
                                null,
                                "Enter a guess value(1-100):",
                                "Enter guess Number",
                                JOptionPane.PLAIN_MESSAGE,
                                input,
                                null,
                                " ");
                        if (guess == null) {
                            return;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage());
                    }
                } while (guess == null);

                try {
                    userGuess = Integer.parseInt(guess.trim());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE, error);
                    continue;
                }

                if (userGuess == generatedNumber) {
                    scoreVal++;
                    JOptionPane optionPane2 = new JOptionPane(
                            "        Congratulations!\nYou guessed the correct number\n     Generated number: " + generatedNumber,
                            JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.DEFAULT_OPTION,
                            crt);
                    JDialog dialog = optionPane2.createDialog("Success");
                    dialog.setIconImage(crt.getImage());
                    dialog.setVisible(true);
                    break;
                } else if (userGuess > generatedNumber && count<3) {
                    String message = "Your guess is too high.\n        Try again\n   chance count :" + (count + 1);
                    if (count == 2) {
                        if(generatedNumber % 2==0){
                        message += "\n  'Hint' :Even number";
                        }else{
                            message += "\n  'Hint' :Odd number";
                        }
                    } 
                    // else if (count == 2) {
                    //     message += "\n'Hint2' last digit:" + (generatedNumber % 10);
                    // }
                    JOptionPane optionPane3 = new JOptionPane(
                            message,
                            JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.DEFAULT_OPTION,
                            tryagain);
                    JDialog dialog = optionPane3.createDialog("try again");
                    dialog.setIconImage(tryagain.getImage());
                    dialog.setVisible(true);
                } else if(userGuess<generatedNumber && count<3) {
                    String message = "Your guess is too low.\n        Try again\n   chance count :" + (count + 1);
                    if (count == 2) {
                        if(generatedNumber % 2==0){
                            message += "\n  'Hint' :Even number";
                            }else{
                                message += "\n  'Hint' :Odd number";
                            }
                        }
                    // else if (count == 2) {
                    //     message += "\n  'Hint' isEven:" + (generatedNumber % 2 == 0);
                    // }
                    JOptionPane optionPane3 = new JOptionPane(
                            message,
                            JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.DEFAULT_OPTION,
                            tryagain);
                    JDialog dialog = optionPane3.createDialog("try again");
                    dialog.setIconImage(tryagain.getImage());
                    dialog.setVisible(true);
                }

                count++;
            }

            if (count == 4 && userGuess != generatedNumber) {
                JOptionPane optionPane3 = new JOptionPane(
                        "   Sorry you lost\nGenerate Number:"+generatedNumber,
                        JOptionPane.INFORMATION_MESSAGE,
                        JOptionPane.DEFAULT_OPTION,
                        error);
                JDialog dialog = optionPane3.createDialog("lost");
                dialog.setIconImage(error.getImage());
                dialog.setVisible(true);
            }

            rematch = JOptionPane.showConfirmDialog(null,
                    "Do you want to play again?",
                    "play again?",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, playagain);
            if (rematch == JOptionPane.YES_OPTION) {
                rematch1 = true;
            } else if (rematch == JOptionPane.NO_OPTION || rematch == JOptionPane.CANCEL_OPTION) {
                rematch1 = false;
                JFrame score = new JFrame();
                score.setTitle("Score");
                score.setSize(300,300);
                score.setResizable(false);
                ImageIcon imgx = new ImageIcon(MainFrame.class.getResource("/gamelogoicon.png"));
                score.setIconImage(imgx.getImage());
                score.setLayout(null);
                Font f1 = new Font("Times New Roman", Font.BOLD, 35);
                JLabel lbl = new JLabel();
                lbl.setBounds(20, 60, 300, 100);
                lbl.setText("Rounds won :"+scoreVal+"/"+rounds);
                lbl.setFont(f1);
                score.add(lbl);
                score.setVisible(true);
                score.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        }
    }

    public static void main(String[] args) {
        new GameLogic();
    }
}
