import java.util.*;
import javax.swing.*;

public class Calculate {
    public Calculate() {
        // Image sources
        ImageIcon questionMark = new ImageIcon(Calculate.class.getResource("/QuestionMark.png"));
        ImageIcon student = new ImageIcon(Calculate.class.getResource("/student.png"));
        ImageIcon cross = new ImageIcon(Calculate.class.getResource("/Cross.png"));

        // Logic
        String sub;
        double sub1 = 0;
        while (true) {
            sub = (String) JOptionPane.showInputDialog(null,
                    "Enter number of subjects\n",
                    "Subjects?",
                    JOptionPane.INFORMATION_MESSAGE,
                    questionMark, null,
                    "");
                    if(sub==null)return;
            if (sub != null) {
                try {
                    sub1 = Double.parseDouble(sub);
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, 
                                                "Please Enter a Valid input",
                                                 "Error", JOptionPane.ERROR_MESSAGE, cross);
            
                }
            }
        }

        ArrayList<Double> marks = new ArrayList<>();
        String temp;
        double temp1;
        for (int i = 1; i <= sub1; i++) {
            while (true) {
                temp = (String) JOptionPane.showInputDialog(null,
                        "Enter marks for subject " + i+"\n",
                        "Subject " + i,
                        JOptionPane.DEFAULT_OPTION, student,
                        null, "");
                        if(temp==null)return;
                if (temp != null) {
                    try {
                        temp1 = Double.parseDouble(temp);
                        marks.add(temp1);
                        break;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Please Enter a Valid input", "Error", JOptionPane.ERROR_MESSAGE, cross);
                    }
                }
            }
        }
        GradeCalculator.total=0;
        for(double i : marks){
            GradeCalculator.total+=i;
        }
        GradeCalculator.avg=(GradeCalculator.total)/(marks.size());
        if(GradeCalculator.avg<40){
            GradeCalculator.Grade="F";
        }else if(GradeCalculator.avg>=40 && GradeCalculator.avg<50){
            GradeCalculator.Grade="E";
        }else if(GradeCalculator.avg>=50 && GradeCalculator.avg<60){
            GradeCalculator.Grade="D";
        }else if(GradeCalculator.avg>=60 && GradeCalculator.avg<70){
            GradeCalculator.Grade="C";
        }else if(GradeCalculator.avg>=70 && GradeCalculator.avg<80){
            GradeCalculator.Grade="B";
        }else if(GradeCalculator.avg>=80 && GradeCalculator.avg<90){
            GradeCalculator.Grade="A";
        }else if(GradeCalculator.avg>=90 && GradeCalculator.avg<=100){
            GradeCalculator.Grade="A+";
        }

    }

    public static void main(String[] args) {
        new Calculate();
    }
}
