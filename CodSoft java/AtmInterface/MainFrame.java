import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame {

    // Static variables
    static long balance = 0;

    boolean isBalanceDisplayed = false;

    public MainFrame() {

        // Frame setup
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);

        // Fonts
        Font f1 = new Font("Times New Roman", Font.BOLD, 25);

        // Buttons
        JButton btn1 = new JButton("CHECK BALANCE");
        btn1.setBounds(200, 100, 400, 100);
        btn1.setFont(f1);
        btn1.setFocusPainted(false);
        btn1.setBackground(new Color(153, 255, 255));
        btn1.setForeground(Color.BLACK);

        JButton btn2 = new JButton("DEPOSIT");
        JButton btn3 = new JButton("WITHDRAW");
        btn2.setBounds(100, 250, 200, 100);
        btn3.setBounds(500, 250, 200, 100);
        btn3.setFocusPainted(false);
        btn2.setFocusPainted(false);
        btn2.setFont(f1);
        btn3.setFont(f1);
        btn2.setBackground(new Color(153, 255, 255));
        btn3.setBackground(new Color(153, 255, 255));

        // Action Listeners
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isBalanceDisplayed) {
                    btn1.setText("CHECK BALANCE");
                } else {
                    btn1.setText("Balance: " + balance);
                }
                isBalanceDisplayed = !isBalanceDisplayed;
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deposit(0); 
            }
        });

        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdraw(0); 
            }
        });

        // Adding components to frame
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void deposit(long amount) {
        String input = JOptionPane.showInputDialog(null, "Enter amount to deposit:");
        if (input != null && !input.isEmpty()) {
            try {
                long depositAmount = Long.parseLong(input);
                if (depositAmount > 0) {
                    balance += depositAmount;
                    JOptionPane.showMessageDialog(null, "Deposited: " + depositAmount);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
            }
        }
    }

    public void withdraw(long amount) {
        String input = JOptionPane.showInputDialog(null, "Enter amount to withdraw:");
        if (input != null && !input.isEmpty()) {
            try {
                long withdrawAmount = Long.parseLong(input);
                if (withdrawAmount > 0) {
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        JOptionPane.showMessageDialog(null, "Withdrew: " + withdrawAmount);
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient balance.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
            }
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
