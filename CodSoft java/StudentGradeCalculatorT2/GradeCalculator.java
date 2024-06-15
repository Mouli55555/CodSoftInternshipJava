import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GradeCalculator {
    static double total = 0;
    static double avg = 0;
    static String Grade ="";
    public GradeCalculator(){
        JFrame frame1 = new JFrame();
        frame1.setSize(800,500);
        frame1.setLayout(null);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
        //Image sources
        ImageIcon grade = new ImageIcon(GradeCalculator.class.getResource("/ReportCard.png"));
        ImageIcon fail = new ImageIcon(GradeCalculator.class.getResource("/fail.png"));
        ImageIcon pass = new ImageIcon(GradeCalculator.class.getResource("/medal.png"));
        frame1.setIconImage(grade.getImage());


        //Fonts
        Font f1 = new Font("Times new Roman",Font.BOLD,30);
        Font f2 = new Font("Times new Roman",Font.BOLD,30);

        //label
        JLabel lbl1 = new JLabel();
        lbl1.setIcon(grade);
        lbl1.setBounds(500, 0, 300, 300);

        JLabel lbl2 = new JLabel();
        lbl2.setText("Total marks               :0.0");
        lbl2.setBounds(10, 10, 400, 50);
        lbl2.setFont(f2);

        JLabel lbl3 = new JLabel();
        lbl3.setText("Average Percentage :0.0");
        lbl3.setBounds(10, 80, 400, 50);
        lbl3.setFont(f2);


        JLabel lbl4 = new JLabel();
        lbl4.setText("Grade                         :N/A");
        lbl4.setBounds(10, 160, 400, 50);
        lbl4.setFont(f2);


        //Button
        JButton btn1 = new JButton();
        btn1.setText("Grade Calculate");
        btn1.setBounds(290, 320, 250, 70);
        btn1.setFocusPainted(false);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(f1);

        //Action listener
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Calculate();
                lbl2.setText("Total marks               :"+total);
                lbl3.setText("Average Percentage :"+avg);
                lbl4.setText("Grade                         :"+Grade);
                if(avg>=40){
                    lbl1.setIcon(pass);
                }else{
                    lbl1.setIcon(fail);
                }
            }
        });


        //add frame
        frame1.add(lbl1);
        frame1.add(btn1);
        frame1.add(lbl2);
        frame1.add(lbl3);
        frame1.add(lbl4);

        

        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new GradeCalculator();
    }
}
