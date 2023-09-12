package com.SplashScreen;

import com.AdminModules.AdminLogin;
import java.awt.*;
import javax.swing.*;

public class WelcomeScreen extends JFrame{
    JLabel l1,l2,l3;
    Container c;
    WelcomeScreen(){
        c = this.getContentPane();
        c.setLayout(null);
        setTitle("Bank Management System");
        JProgressBar progressbar = new JProgressBar();
        ImageIcon bgimg = new ImageIcon("src/Images/Background.png");
        ImageIcon icon1 = new ImageIcon("src/Images/bankicon.png");
        l1 = new JLabel(bgimg);
        l2 = new JLabel();
        l3 = new JLabel();
        
        //Label bounds
        l1.setSize(880,550);
        add(l1);
        
        l2.setBounds(10,460,300,50);
        l1.add(l2);
        
        l3.setBounds(830,460,100,50);
        l3.setForeground(Color.white);
        l1.add(l3);
        
        progressbar.setBounds(0,499,880,15);
        progressbar.setBorderPainted(true);
        progressbar.setBackground(Color.white);
        progressbar.setForeground(new Color(0,168,204));
        l1.add(progressbar);
        
        setSize(880,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(icon1.getImage());
        setVisible(true);
        try
        {
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(100);
                progressbar.setValue(i);//Setting value of Progress Bar
                l3.setText(""+i+"%");
                if(i==15)
                    l2.setText("Turning On Modules...");
                 if(i==25)
                    l2.setText("Loading Modules...");
                  if(i==60)
                    l2.setText("Connecting to Database...");
                   if(i==70)
                    l2.setText("Connection Successful !");
                    if(i==90)
                    l2.setText("Launching Application...");
                if(i==100)
                {
                    new AdminLogin().setVisible(true);
                    setVisible(false);
                }
            }
        }catch(InterruptedException e){}
    }
    public static void main(String []args){
        new WelcomeScreen();
    }
}
