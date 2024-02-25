package quiz.time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Clock;
public class Quiz extends JFrame implements ActionListener {
    
    JButton next,submit,lifeline;
    public static int count=0;
    public static int timer=15;
    public static int ans_given = 0;
    public static int score = 0;
    JLabel qno, question;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup options;
    
    String q[][] = new String[5][5];
    String pa[][] = new String[5][1];
    String qa[][] = new String[5][2];
    
    String username;
    Quiz(String username){
        this.username = username;
        
        setBounds(250,50,1000,950);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("quiz\\time\\icon\\quiz.jpg"));
        JLabel l1= new JLabel(i1);
        l1.setBounds(0, 0, 1000,250);
        add(l1);
        
        qno= new JLabel("");
        qno.setFont(new Font("tahoma",Font.PLAIN,20));
        qno.setBounds(100,300,40, 40);
        add(qno);
        
        question= new JLabel("");
        question.setFont(new Font("tahoma",Font.PLAIN,20));
        question.setBounds(150,300,1000, 40);
        add(question);
        
        q[0][0] = "Which of the following option leads to the portability and security of Java?";
        q[0][1]="Bytecode is executed by JVM";
        q[0][2]="The applet makes the Java code secure and portable";
        q[0][3]="Use of exception handling";
        q[0][4]="Dynamic binding between objects";

        q[1][0] = "The \u0021 article referred to as a";
        q[1][1]="Unicode escape sequence";
        q[1][2]="Octal escape";
        q[1][3]="Hexadecimal";
        q[1][4]="Line feed";

        q[2][0] = "_____ is used to find and fix bugs in the Java programs.";
        q[2][1]="JVM";
        q[2][2]="JRE";
        q[2][3]="JDK";
        q[2][4]="JDB";

        q[3][0] = "In which process, a local variable has the same name as one of the instance variables?";
        q[3][1]="Serialization";
        q[3][2]="Variable Shadowing";
        q[3][3]="Abstraction";
        q[3][4]="Multi-threading";

        q[4][0] = "What is the return type of the hashCode() method in the Object class?";
        q[4][1]="Object";
        q[4][2]="int";
        q[4][3]="long";
        q[4][4]="void";

        
      qa[0][1]="Bytecode is executed by JVM";
      qa[1][1]="Unicode escape sequence";
      qa[2][1]="JDB";
      qa[3][1]="Variable Shadowing";
      qa[4][1]="int";
        
        opt1 = new JRadioButton("");
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        opt1.setBackground(Color.white);
        opt1.setBounds(150,380,500,30);
        add(opt1);
        
        opt2 = new JRadioButton("");
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        opt2.setBackground(Color.white);
        opt2.setBounds(150,420,500,30);
        add(opt2);
        
        opt3 = new JRadioButton("");
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        opt3.setBackground(Color.white);
        opt3.setBounds(150,460,500,30);
        add(opt3);
        
        opt4 = new JRadioButton("");
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        opt4.setBackground(Color.white);
        opt4.setBounds(150,500,500,30);
        add(opt4);
        
        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        
        next = new JButton("Next");
        next.setFont(new Font("Tahoma",Font.PLAIN,20));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.white);
        next.addActionListener(this);
        next.setBounds(650,450,200,30);
        add(next);
        
        lifeline = new JButton("50-50 lifeline");
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,20));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.white);
        lifeline.setBounds(650,520,200,30);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Tahoma",Font.PLAIN,20));
        submit.setEnabled(false);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.white);
        submit.setBounds(650,590,200,30);
        submit.addActionListener(this);
        add(submit);
        
        start(0);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            
             repaint();
             opt1.setEnabled(true);
             opt2.setEnabled(true);
             opt3.setEnabled(true);
             opt4.setEnabled(true);
             
             ans_given = 1;
             if(options.getSelection()== null){
                 pa[count][0] = "";
             }else{
                 pa[count][0] = options.getSelection().getActionCommand();
             }
              if(count == 3){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
              
             count++;
             start(count);
        }else if(ae.getSource() == submit){
             ans_given = 1;
             if(options.getSelection()== null){
                 pa[count][0] = "";
             }else{
                 pa[count][0] = options.getSelection().getActionCommand();
             }
               
               for(int i =0; i < pa.length; i++){
                   if(pa[i][0].equals(qa[i][1])){
                       score+=10;
                   }else{
                       score+=0;
                   }
                       
               }
               
               this.setVisible(false);
               new Score(username, score).setVisible(true);
        }else if(ae.getSource() == lifeline){
            if(count == 0 || count ==1 ){
                opt2.setEnabled(false);
                opt4.setEnabled(false);
            }else{
                opt1.setEnabled(false);
                opt3.setEnabled(false);
            }
              lifeline.setEnabled(false); 
        }
    }
    
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time Left - " + timer + " seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma",Font.BOLD,25));
       
        
        if(timer>0){
             g.drawString(time, 700, 420);
        }else{
            g.drawString("Times up!!", 700, 420);
        }
        
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){System.out.println(e);}
        
        if(ans_given == 1){
            ans_given = 0;
             timer = 15;
        }else if(timer < 0){
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count == 3){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 4){
               if(options.getSelection()== null){
                 pa[count][0] = "";
             }else{
                 pa[count][0] = options.getSelection().getActionCommand();
             }
               
               for(int i =0; i < pa.length; i++){
                   if(pa[i][0].equals(qa[i][1])){
                       score+=10;
                   }else{
                       score+=0;
                   }
                       
               }
               
               this.setVisible(false);
               new Score(username, score).setVisible(true);
            }else{
                 if(options.getSelection()== null){
                 pa[count][0] = "";
             }else{
                 pa[count][0] = options.getSelection().getActionCommand();
             }
                 count++;
                 start(count);
            }
        }
        
       
    }
    
    public void start(int count){
        qno.setText("" + (count + 1) + ". ");
        question.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();
    }
    
    public static void main(String[] args){
        new Quiz("").setVisible(true);
    }
    
}
