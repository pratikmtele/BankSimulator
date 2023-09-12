package com.Designs;

import java.awt.*;
import javax.swing.*;

public class DashboardDesign extends JFrame {

    public Container c;
    public JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, addadmin;
    public JPanel navpanel, sidepanel, panel1, panel2, panel3;
    public JTextField tf;
    public String accType[] = {"---Select Type of Account---",
        "Saving Account", "Current Account", "Fixed Deposit Account"};
    //Fonts
    public Font font = new Font("Segoe UI", Font.BOLD, 22);
    public Font font1 = new Font("Segoe UI", Font.PLAIN, 16);
    public Font font2 = new Font("Segoe UI", Font.PLAIN, 18);
    public Font font3 = new Font("Segoe UI", Font.BOLD, 18);
    public Font font4 = new Font("Segoe UI", Font.BOLD, 16);

    //Color
    public Color color = new Color(0, 168, 204);

    //Cursor
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    public DashboardDesign() {
        setSize(1080, 600);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        //Image
        ImageIcon icon1 = new ImageIcon("src/Images/bankicon.png");

        navpanel = new JPanel();
        sidepanel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        l1 = new JLabel("Bank Management System");
        l2 = new JLabel("Welcome!");
        l3 = new JLabel("PratikTele");
        l4 = new JLabel("Dashboard");
        addadmin = new JLabel("Add Admin");
        l5 = new JLabel("Add Customer");
        l6 = new JLabel("Deposit");
        l7 = new JLabel("Withdraw");
        l8 = new JLabel("Transaction History");
        l9 = new JLabel("Account List");
        l10 = new JLabel("Account Details");
        l11 = new JLabel("Logout");
        l12 = new JLabel("Today's Credit");
        l13 = new JLabel("100000 ₹");
        l14 = new JLabel("Today's Debit");
        l15 = new JLabel("100000 ₹");
        l16 = new JLabel("Balance");
        l17 = new JLabel("100000 ₹");
        tf = new JTextField();

        //navPanel
        navpanel.setBounds(0, 0, 1080, 45);
        navpanel.setBackground(new Color(244, 244, 244));
        navpanel.setLayout(null);
        add(navpanel);

        l1.setBounds(400, 10, 300, 25);
        l1.setFont(font);
        navpanel.add(l1);

        l2.setBounds(880, 10, 70, 25);
        l2.setFont(font1);
        navpanel.add(l2);

        l3.setBounds(955, 10, 200, 25);
        l3.setFont(font1);
        navpanel.add(l3);

        //sidepanel
        sidepanel.setBounds(0, 45, 250, 640);
        sidepanel.setBackground(color);
        sidepanel.setLayout(null);
        add(sidepanel);

        l4.setBounds(10, 30, 150, 25);
        l4.setFont(font2);
        l4.setForeground(Color.white);
        l4.setCursor(cursor);
        sidepanel.add(l4);
        
        addadmin = new JLabel("Add Admin");
        addadmin.setBounds(10, 80, 200, 25);
        addadmin.setForeground(Color.white);
        addadmin.setFont(font2);
        addadmin.setCursor(cursor);
        sidepanel.add(addadmin);

        l5.setBounds(10, 130, 150, 25);
        l5.setForeground(Color.white);
        l5.setFont(font2);
        l5.setCursor(cursor);
        sidepanel.add(l5);

        l6.setBounds(10, 180, 200, 25);
        l6.setForeground(Color.white);
        l6.setFont(font2);
        l6.setCursor(cursor);
        sidepanel.add(l6);

        l7.setBounds(10, 230, 150, 25);
        l7.setForeground(Color.white);
        l7.setFont(font2);
        l7.setCursor(cursor);
        sidepanel.add(l7);

        l8.setBounds(10, 280, 200, 25);
        l8.setForeground(Color.white);
        l8.setFont(font2);
        l8.setCursor(cursor);
        sidepanel.add(l8);

        l9.setBounds(10, 330, 200, 25);
        l9.setForeground(Color.white);
        l9.setFont(font2);
        l9.setCursor(cursor);
        sidepanel.add(l9);

        l10.setBounds(10, 380, 200, 25);
        l10.setForeground(Color.white);
        l10.setFont(font2);
        l10.setCursor(cursor);
        sidepanel.add(l10);

        l11.setBounds(10, 430, 200, 25);
        l11.setForeground(Color.white);
        l11.setFont(font2);
        l11.setCursor(cursor);
        sidepanel.add(l11);

        //SubPanels
        panel1.setBounds(290, 80, 210, 100);
        panel1.setBackground(color);
        panel1.setLayout(null);
        add(panel1);

        l12.setBounds(20, 10, 150, 25);
        l12.setFont(font3);
        l12.setForeground(Color.white);
        panel1.add(l12);

        l13.setBounds(20, 40, 150, 25);
        l13.setFont(font2);
        l13.setForeground(Color.white);
        panel1.add(l13);

        panel2.setBounds(550, 80, 210, 100);
        panel2.setBackground(new Color(154, 47, 174));
        panel2.setLayout(null);
        add(panel2);

        l14.setBounds(20, 10, 150, 25);
        l14.setFont(font3);
        l14.setForeground(Color.white);
        panel2.add(l14);

        l15.setBounds(20, 40, 150, 25);
        l15.setFont(font2);
        l15.setForeground(Color.white);
        panel2.add(l15);

        panel3.setBounds(810, 80, 210, 100);
        panel3.setBackground(new Color(9, 94, 163));
        panel3.setLayout(null);
        add(panel3);

        l16.setBounds(20, 10, 150, 25);
        l16.setFont(font3);
        l16.setForeground(Color.white);
        panel3.add(l16);

        l17.setBounds(20, 40, 150, 25);
        l17.setFont(font2);
        l17.setForeground(Color.white);
        panel3.add(l17);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(icon1.getImage());
    }
}
