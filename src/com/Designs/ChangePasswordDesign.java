package com.Designs;

import java.awt.*;
import javax.swing.*;

public class ChangePasswordDesign extends JFrame{
    public Container c;
    public JLabel label1,label2,label3;
    public JTextField tf1,tf2;
    public JButton chngpass;
    public ChangePasswordDesign(){
        setSize(700,500);
        
        c = this.getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);
        
        //Fonts
        Font font = new Font("Segoe UI", Font.BOLD, 22);
        Font font1 = new Font("Segoe UI", Font.PLAIN, 16);
        Font font2 = new Font("Segoe UI", Font.BOLD, 16);
        
         //Image
        ImageIcon icon1 = new ImageIcon("src/Images/bankicon.png");
        
        label1 = new JLabel("Change Password",JLabel.CENTER);
        label2 = new JLabel("Enter Password");
        label3 = new JLabel("Confirm Password");
        tf1 = new JTextField();
        tf2 = new JTextField();
        chngpass = new JButton("Change Password");
 
        label1.setBounds(0,50,700,50);
        label1.setFont(font);
        add(label1);
        
        label2.setBounds(180,140,150,25);
        label2.setFont(font1);
        add(label2);
        
        tf1.setBounds(180,173,350,30);
        tf1.setFont(font1);
        add(tf1);
        
        label3.setBounds(180,240,150,25);
        label3.setFont(font1);
        add(label3);
        
        tf2.setBounds(180,273,350,30);
        tf2.setFont(font1);
        add(tf2);
        
        chngpass.setBounds(180,350,350, 30);
        chngpass.setFont(font2);
        chngpass.setBackground(new Color(0,168,204));
        chngpass.setForeground(Color.white);
        add(chngpass);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon1.getImage());
        setVisible(true);
    }
}

