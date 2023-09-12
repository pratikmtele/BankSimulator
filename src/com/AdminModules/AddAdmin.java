package com.AdminModules;

import com.Helper.ConnectionProvider;
import com.Designs.DashboardDesign;
import com.Helper.Helper;
import static com.Helper.Helper.firstName;
import static com.Helper.Helper.lastName;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class AddAdmin extends DashboardDesign implements MouseListener, ActionListener {

    JPanel signPanel;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    JPasswordField pf;
    JButton add;
    String printname, admin_ID;

    public AddAdmin(String printname) {
        this.printname = printname;
        l3.setText(printname);
        setTitle("Add Admin - Bank Management System");
        setSize(1080, 650);

        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);

        signPanel = new JPanel();
        label1 = new JLabel("Add Admin");
        label2 = new JLabel("Enter First Name :");
        label3 = new JLabel("Enter Last Name :");
        label4 = new JLabel("Address :");
        label5 = new JLabel("Mobile No. :");
        label6 = new JLabel("Enter Username :");
        label7 = new JLabel("Enter Password :");
        label8 = new JLabel("Confirm Password :");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        pf = new JPasswordField();
        add = new JButton("Add");

        Font textfieldfont = new Font("Arial", Font.PLAIN, 14);

        signPanel.setBounds(350, 70, 600, 520);
        signPanel.setBackground(Color.WHITE);
        signPanel.setLayout(null);
        signPanel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        add(signPanel);

        label1.setBounds(250, 20, 600, 30);
        label1.setFont(font);
        label1.setForeground(color);
        signPanel.add(label1);

        label2.setBounds(70, 100, 200, 25);
        label2.setFont(font1);
        signPanel.add(label2);

        tf1.setBounds(210, 102, 300, 25);
        tf1.setFont(textfieldfont);
        signPanel.add(tf1);

        label3.setBounds(70, 150, 150, 25);
        label3.setFont(font1);
        signPanel.add(label3);

        tf2.setBounds(210, 152, 300, 25);
        tf2.setFont(textfieldfont);
        signPanel.add(tf2);

        label4.setBounds(70, 200, 150, 25);
        label4.setFont(font1);
        signPanel.add(label4);

        tf3.setBounds(210, 202, 300, 25);
        tf3.setFont(textfieldfont);
        signPanel.add(tf3);

        label5.setBounds(70, 250, 150, 25);
        label5.setFont(font1);
        signPanel.add(label5);

        tf4.setBounds(210, 252, 300, 25);
        tf4.setFont(textfieldfont);
        signPanel.add(tf4);

        label6.setBounds(70, 300, 150, 25);
        label6.setFont(font1);
        signPanel.add(label6);

        tf5.setBounds(210, 302, 300, 25);
        tf5.setFont(textfieldfont);
        signPanel.add(tf5);

        label7.setBounds(70, 350, 150, 25);
        label7.setFont(font1);
        signPanel.add(label7);

        tf6.setBounds(210, 352, 300, 25);
        tf6.setFont(textfieldfont);
        signPanel.add(tf6);

        label8.setBounds(70, 400, 150, 25);
        label8.setFont(font1);
        signPanel.add(label8);

        pf.setBounds(210, 402, 300, 25);
        pf.setFont(textfieldfont);
        pf.setEchoChar('\u25cf');
        signPanel.add(pf);

        add.setBounds(250, 472, 100, 25);
        add.setFont(font2);
        add.setForeground(Color.white);
        add.setBackground(color);
        signPanel.add(add);

        //Random number Generate
        Random ran = new Random();
        long first4 = (ran.nextInt() % 9000) + 1000;
        admin_ID = "admin" + Math.abs(first4);

        //add mouse listener
        l4.addMouseListener(this);
        l5.addMouseListener(this);
        l6.addMouseListener(this);
        l7.addMouseListener(this);
        l8.addMouseListener(this);
        l9.addMouseListener(this);
        l10.addMouseListener(this);
        l11.addMouseListener(this);

        //add actionlistener
        add.addActionListener(this);
    }

    public static void main(String[] args) {
        new AddAdmin("").setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(l4)) {
            new AdminDashboard(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l5)) {
            new CustomerSignupForm(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l6)) {
            new Deposit(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l7)) {
            new Withdraw(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l8)) {
            new AdminTransactionHistory(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l9)) {
            new AccountList(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l10)) {
            new AccountDetails(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l11)) {
            new AdminLogin().setVisible(true);
            setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fname = tf1.getText();
        String lname = tf2.getText();
        String address = tf3.getText();
        String mobileno = tf4.getText();
        String username = tf5.getText();
        String password = pf.getText();

        if (e.getSource().equals(add)) {
            //Input Validation
            if (fname.equals("") || lname.equals("") || address.equals("") || mobileno.equals("") || username.equals("") || tf6.getText().equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(c, "Enter all required Fields.");
                //First name and Last name Validation
            } else if (firstName(fname) && lastName(lname)) {
                //Password Validation
                if (tf6.getText().equals(password)) {
                    //Mobile Number Validation
                    if (!Helper.isvalidmobileno(mobileno)) {
                        JOptionPane.showMessageDialog(c, "Invalid Mobile Number.Try Again.");
                    } else {
                        //database--->
                        try {
                            Connection con = ConnectionProvider.getConnection();
                            String q = "insert into admin values('" + admin_ID + "','" + fname + "','" + lname + "','" + address + "','" + mobileno + "','" + username + "','" + password + "')";
                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(q);
                            JOptionPane.showMessageDialog(c, "Account Created Successfully.");
                            tf1.setText("");
                            tf2.setText("");
                            tf3.setText("");
                            tf4.setText("");
                            tf5.setText("");
                            tf6.setText("");
                            pf.setText("");
                        } catch (SQLException ex) {
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(c, "Passwords didn’t match. Try again.");
                }
            } else {
                JOptionPane.showMessageDialog(c, "Invalid First Name or last Name.");
            }
        }
    }
}
