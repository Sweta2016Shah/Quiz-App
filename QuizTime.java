package quiz.time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizTime extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JTextField t1;
    QuizTime(){
        setBounds(400, 200, 1000, 500); //dleft,//dup,//length,//height///////
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("quiz\\time\\icon\\front.jpg"));
         Image i2 = i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 550, 500);
        add(l1);
        
        JLabel l2=new JLabel("Quiz Time");
        l2.setFont(new Font("Mongolian Baiti",Font.BOLD, 40));
        l2.setForeground(Color.blue);
        l2.setBounds(620, 40 , 300, 45);
        add(l2);
        
        JLabel l3=new JLabel("Enter Your Name");
        l3.setFont(new Font("Mongolian Baiti",Font.BOLD, 18));
        l3.setForeground(Color.blue);
        l3.setBounds(650, 160 , 300, 20);
        add(l3);
                
        t1= new JTextField();
        t1.setBounds(580, 200 ,300 , 25);
        t1.setFont(new Font("Times New Roman",Font.BOLD, 20));
        add(t1); 
        
        b1= new JButton("Rules");
        b1.setBounds(580, 270, 100, 25);
        b1.setBackground(new Color(30, 144, 254));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2= new JButton("Exit");
        b2.setBounds(780, 270, 100, 25);
        b2.setBackground(new Color(30, 144, 254));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        setVisible(true);
     }

   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== b1)
        {
            String name = t1.getText();
            this.setVisible(false);
            new Rules(name);
        }else {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        
        new QuizTime();
     
        
    }
    
}
