
package quiz.time;
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    JButton b1,b2;
    String username;
    
    Rules(String username){
        this.username = username;
        setBounds(400,200,600,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1= new JLabel("Welcome " + username + " to Quiz Time");
        l1.setForeground(new Color(30,144,255));
        l1.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        l1.setBounds(135, 20, 700,30);
        add(l1);
        
        JLabel l2= new JLabel("");
        l2.setFont(new Font("tahona", Font.PLAIN,16));
        l2.setBounds(135,90,600,30);
        l2.setText("write your own rule here ");
        add(l2);
        
        b1= new JButton("Back");
        b1.setBounds(150,200,100,25);
        b1.setBackground(new Color(30,144,255));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2= new JButton("Start");
        b2.setBounds(300,200,100,25);
        b2.setBackground(new Color(30,144,255));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== b1){
             this.setVisible(false); 
             new QuizTime().setVisible(true);
        }else if(ae.getSource()== b2){
            this.setVisible(false);
            new Quiz(username).setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        new Rules("");
        
    }

   
}
