import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame {

    //mainframe creation
    public MainFrame(){
    JFrame frame1 = new JFrame();
    frame1.setSize(1000, 500);
    frame1.setBackground(Color.WHITE);
    frame1.setLocationRelativeTo(null);
    frame1.setResizable(false);
    frame1.setLayout(null);
    frame1.setTitle("Number game");

    //setting image icon
    ImageIcon img = new ImageIcon(MainFrame.class.getResource("/gamelogoicon.png"));
    frame1.setIconImage(img.getImage());

    //setting label
    ImageIcon img1 = new ImageIcon(MainFrame.class.getResource("/gamelogo.png"));
    JLabel lbl1 = new JLabel(img1);
    lbl1.setBounds(0, 0, 500, 500);

    //font
    Font f1 = new Font("Times New Roman", Font.BOLD, 35);
    Font f2 = new Font("Times New Roman", Font.BOLD, 25);

    JLabel lbl2 = new JLabel("Number Game");
    lbl2.setBounds(600, 20, 490, 35);
    lbl2.setFont(f1);

    JLabel lbl3  = new JLabel("(4 chances)");
    lbl3.setBounds(650, 100, 200, 25);
    lbl3.setFont(f2);

    JLabel lbl4 = new JLabel("Human v/s Ai");
    lbl4.setBounds(635, 70, 200, 25);
    lbl4.setFont(f2);

    //Button add
    JButton btn1 = new JButton("Play Now");
    btn1.setBounds(590, 200, 250, 100);
    btn1.setFont(f1);
    btn1.setBackground(Color.BLACK);
    btn1.setFocusPainted(false);
    btn1.setForeground(Color.WHITE);

    JButton btn2 = new JButton("Rules and gameplay");
    btn2.setBounds(840, 420, 150, 15);
    Color btn2col = new Color(237,237,237);
    btn2.setBackground(btn2col);
    btn2.setForeground(Color.BLACK);
    btn2.setFocusPainted(false);
    btn2.setBorderPainted(false);
    btn2.setContentAreaFilled(false);

    //Action listner
    btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            new GameLogic();
        }   
    });

    btn2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            new Rules();
        }
    });

    //window add
    frame1.add(lbl1);
    frame1.add(lbl2);
    frame1.add(lbl3);
    frame1.add(btn1);
    frame1.add(btn2);
    frame1.add(lbl4);

    frame1.setVisible(true);
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}