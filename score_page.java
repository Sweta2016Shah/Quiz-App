
package quiz.time;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    
    Score(String username, int score){
        setBounds(400, 150, 750, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz\\time\\icon\\score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(10,200,300,250);
        add(l1);
        
        JLabel l2 = new JLabel("Thankyou  " + username + "  for playing Quiz Time");
        l2.setBounds(45,30,700,30);
        l2.setFont(new Font("RALEWAY",Font.PLAIN,26));
        add(l2);
        
        JLabel l3 = new JLabel("Your Score Is " + score);
        l3.setBounds(355,200,300,30);
        l3.setFont(new Font("Jokerman",Font.PLAIN,26));
        l3.setForeground(new Color(199,21,133));
        add(l3);
        
        JButton b1 = new JButton("Play Again");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setBounds(400,270,120,30);
        add(b1);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new QuizTime().setVisible(true);
    }
    
 public static void main(String[]args){
     new Score("" , 0).setVisible(true);
 }   
}
