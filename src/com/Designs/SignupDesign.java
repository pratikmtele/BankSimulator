package com.Designs;

import java.awt.*;
import javax.swing.*;

public class SignupDesign extends JFrame{
    public Container c;
    public JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    public JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    public JPasswordField pf;
    public JButton cancel,submit;
    public SignupDesign(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
        setSize(600,600);
        
        ImageIcon icon1 = new ImageIcon("src/Images/bankicon.png");
        //Fonts
        Font font = new Font("Segoe UI",Font.BOLD,22);
        Font font1 = new Font("Segoe UI",Font.PLAIN,16);
        Font font2 = new Font("Segoe UI",Font.BOLD,16);
        Font textfieldfont = new Font("Arial",Font.PLAIN,14);
        
        //Colors
        Color color = new Color(0,168,204);
        
        l1 = new JLabel("Create your Account");
        l2 = new JLabel("Enter First Name :");
        l3 = new JLabel("Enter Last Name :");
        l4 = new JLabel("Address :");
        l5 = new JLabel("Mobile No. :");
        l6 = new JLabel("Enter Username :");
        l7 = new JLabel("Enter Password :");
        l8 = new JLabel("Confirm Password :");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        pf = new JPasswordField();
        cancel = new JButton("Cancel");
        submit = new JButton("Submit");
        
        l1.setBounds(180,20,300,30);
        l1.setFont(font);
        l1.setForeground(color);
        add(l1);
        
        l2.setBounds(60,100,150,25);
        l2.setFont(font1);
        add(l2);
        
        tf1.setBounds(200,102,300,25);
        tf1.setFont(textfieldfont);
        add(tf1);
        
        l3.setBounds(60,150,150,25);
        l3.setFont(font1);
        add(l3);
        
        tf2.setBounds(200,152,300,25);
        tf2.setFont(textfieldfont);
        add(tf2);
        
        l4.setBounds(60,200,150,25);
        l4.setFont(font1);
        add(l4);
        
        tf3.setBounds(200,202,300,25);
        tf3.setFont(textfieldfont);
        add(tf3);
        
        l5.setBounds(60,250,150,25);
        l5.setFont(font1);
        add(l5);
        
        tf4.setBounds(200,252,300,25);
        tf4.setFont(textfieldfont);
        add(tf4);
        
        l6.setBounds(60,300,150,25);
        l6.setFont(font1);
        add(l6);
        
        tf5.setBounds(200,302,300,25);
        tf5.setFont(textfieldfont);
        add(tf5);
        
        l7.setBounds(60,350,150,25);
        l7.setFont(font1);
        add(l7);
        
        tf6.setBounds(200,352,300,25);
        tf6.setFont(textfieldfont);
        add(tf6);
        
        l8.setBounds(60,400,150,25);
        l8.setFont(font1);
        add(l8);
        
        pf.setBounds(200,402,300,25);
        pf.setFont(textfieldfont);
        pf.setEchoChar('\u25cf');
        add(pf);
        
        cancel.setBounds(100,472,150,25);
        cancel.setFont(font2);
        cancel.setForeground(Color.white);
        cancel.setBackground(color);
        add(cancel);
        
        submit.setBounds(320,472,150,25);
        submit.setFont(font2);
        submit.setForeground(Color.white);
        submit.setBackground(color);
        add(submit);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(icon1.getImage());
    }
}
