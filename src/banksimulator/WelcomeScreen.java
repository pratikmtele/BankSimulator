
package banksimulator;

import java.awt.*;
import javax.swing.*;

public class WelcomeScreen extends JFrame{
    Container c;
    JLabel l1,l2,l3;
    WelcomeScreen()
    {
        JProgressBar progressBar=new JProgressBar();
        ImageIcon icon = new ImageIcon("src/img/bank (2).png");
        ImageIcon icon1 = new ImageIcon("src/img/bankicon.png");
        l1 = new JLabel(icon);
        l2 = new JLabel("Bank Simulator");
        l3 = new JLabel();
        
        Font font = new Font("Segeo UI Semibold",Font.BOLD,17);
         Font font1 = new Font("Segeo UI Semibold",Font.BOLD,12);
        
        c= this.getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);
        
        l1.setBounds(230,10,icon.getIconWidth(),icon.getIconHeight());
        c.add(l1);
        
        l2.setBounds(200,100,200,20);
        l2.setFont(font);
        l2.setForeground(new Color(0,168,204));
        c.add(l2);
        
        l3.setBounds(205,230,250,21);
        l3.setFont(font1);
        c.add(l3);
        
        progressBar.setBounds(110,200,300,14);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLACK);
        c.add(progressBar);
        
       setSize(568, 368);
       setIconImage(icon1.getImage());
       setLocationRelativeTo(c);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       try
        {
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(100);
                progressBar.setValue(i);//Setting value of Progress Bar
                if(i==15)
                    l3.setText("Turning On Modules...");
                 if(i==25)
                    l3.setText("Loading Modules...");
                  if(i==60)
                    l3.setText("Connecting to Database...");
                   if(i==70)
                    l3.setText("Connection Successful !");
                    if(i==90)
                    l3.setText("Launching Application...");
                if(i==100)
                {
                    setVisible(false);
                    new LoginForm().setVisible(true);
                }
            }
        }catch(InterruptedException e){}
        
    }
    public static void main(String []args)
    {
        WelcomeScreen w = new WelcomeScreen();
    }
}
