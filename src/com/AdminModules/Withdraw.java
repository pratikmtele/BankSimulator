package com.AdminModules;

import com.Helper.ConnectionProvider;
import com.Designs.DashboardDesign;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Withdraw extends DashboardDesign implements ActionListener, MouseListener {

    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11;
    JButton search, withdraw;
    JTextField tf1, tf2;
    Connection con = ConnectionProvider.getConnection();
    Statement stmt;
    ResultSet set;
    String printname;

    public Withdraw(String printname) {
        setSize(1080, 550);
        this.printname = printname;
        l3.setText(printname);
        setTitle("Withdraw - Bank Management System");
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);

        label1 = new JLabel("Withdraw");
        label2 = new JLabel("Enter Account Number");
        label3 = new JLabel("Account Number:");
        label4 = new JLabel();
        label5 = new JLabel("Customer Name:");
        label6 = new JLabel();
        label7 = new JLabel("Account Type:");
        label8 = new JLabel();
        label9 = new JLabel("Balance Available:");
        label10 = new JLabel();
        label11 = new JLabel("Withdraw Amount");
        search = new JButton("Search");
        withdraw = new JButton("Withdraw");
        tf1 = new JTextField();
        tf2 = new JTextField();

        label1.setBounds(600, 80, 150, 25);
        label1.setFont(font);
        add(label1);

        label2.setBounds(430, 140, 200, 25);
        label2.setFont(font1);
        add(label2);

        tf1.setBounds(430, 170, 350, 25);
        tf1.setFont(font1);
        add(tf1);

        search.setBounds(790, 170, 110, 25);
        search.setFont(font4);
        search.setBackground(color);
        search.setForeground(Color.white);
        add(search);

        label3.setBounds(375, 250, 140, 25);
        label3.setFont(font4);
        add(label3);

        label4.setBounds(525, 250, 150, 25);
        label4.setFont(font1);
        add(label4);

        label5.setBounds(675, 250, 150, 25);
        label5.setFont(font4);
        add(label5);

        label6.setBounds(825, 250, 150, 25);
        label6.setFont(font1);
        add(label6);

        label7.setBounds(375, 300, 150, 25);
        label7.setFont(font4);
        add(label7);

        label8.setBounds(495, 300, 170, 25);
        label8.setFont(font1);
        add(label8);

        label9.setBounds(675, 300, 170, 25);
        label9.setFont(font4);
        add(label9);

        label10.setBounds(825, 300, 170, 25);
        label10.setFont(font1);
        add(label10);

        label11.setBounds(430, 360, 150, 25);
        label11.setFont(font1);
        add(label11);

        tf2.setBounds(430, 390, 350, 25);
        tf2.setFont(font1);
        add(tf2);

        withdraw.setBounds(790, 390, 110, 25);
        withdraw.setFont(font4);
        withdraw.setBackground(color);
        withdraw.setForeground(Color.white);
        add(withdraw);

        search.addActionListener(this);
        withdraw.addActionListener(this);

        l4.addMouseListener(this);
        l5.addMouseListener(this);
        l6.addMouseListener(this);
        l8.addMouseListener(this);
        l9.addMouseListener(this);
        l10.addMouseListener(this);
        l11.addMouseListener(this);
        addadmin.addMouseListener(this);
    }

    public static void main(String[] args) {
        new Withdraw("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accnno = tf1.getText();
        String amount = tf2.getText();
        String q, Cust_ID = null, acctype = null, fname = null, lname = null, validaccnno = null;
        double balance = 0.0;
        if (e.getSource().equals(search)) {
            if (AdminDashboard.isNumeric(accnno)) {
                tf1.setBorder(BorderFactory.createLineBorder(Color.black));
                //Database--->
                try {
                    q = "select * from account";
                    stmt = con.createStatement();
                    set = stmt.executeQuery(q);
                    while (set.next()) {
                        validaccnno = set.getString(1);
                        if (validaccnno.equals(accnno)) {
                            Cust_ID = set.getString(2);
                            acctype = set.getString(3);
                            balance = Double.parseDouble(set.getString(4));
                            break;
                        }
                    }
                    if (validaccnno.equals(accnno)) {
                        q = "select * from customer where cust_ID='" + Cust_ID + "'";
                        set = stmt.executeQuery(q);
                        while (set.next()) {
                            fname = set.getString(2);
                            lname = set.getString(3);
                        }
                        label4.setText(accnno);
                        label6.setText(fname + " " + lname);
                        label8.setText(acctype);
                        label10.setText("₹ " + balance);
                    } else {
                        JOptionPane.showMessageDialog(c, "Invalid Account Number. Try Again.");
                    }
                } catch (SQLException ex) {
                }
            } else {
                tf1.setBorder(BorderFactory.createLineBorder(Color.red));
            }
        } else if (e.getSource().equals(withdraw)) {
            if (AdminDashboard.isNumeric(accnno)) {
                tf1.setBorder(BorderFactory.createLineBorder(Color.black));
                if (AdminDashboard.isNumeric(amount)) {
                    tf2.setBorder(BorderFactory.createLineBorder(Color.black));
                    if (Double.parseDouble(amount) != 0) {
                        //Transaction Id 
                        Random ran = new Random();
                        long id = (ran.nextLong() % 9000) + 1000;
                        String TransID = "trans" + Math.abs(id);
                        //Current Date
                        long time = System.currentTimeMillis();
                        Timestamp timestamp = new Timestamp(time);
                        String d = "" + timestamp;
                        String date = d.substring(0, 19);
                        //Database Queries -->
                        try {
                            q = "select * from account where acc_No='" + accnno + "'";
                            set = stmt.executeQuery(q);
                            while (set.next()) {
                                balance = Double.parseDouble(set.getString(4));
                            }
                            if (balance > Double.parseDouble(amount)) {
                                q = "insert into transactions values('" + TransID + "','" + accnno + "','" + date + "','" + "Withdraw" + "','" + amount + "')";
                                stmt.executeUpdate(q);
                                balance -= Double.parseDouble(amount);
                                q = "update account set balance='" + balance + "' where acc_No='" + accnno + "'";
                                stmt.executeUpdate(q);
                                JOptionPane.showMessageDialog(c, "Withdrawal Successfully.");
                                tf2.setText("");
                            } else {
                                JOptionPane.showMessageDialog(c, "Insufficient Balance.");
                            }
                        } catch (NumberFormatException | SQLException ex) {
                        }

                    } else {
                        tf2.setBorder(BorderFactory.createLineBorder(Color.red));
                    }
                } else {
                    tf2.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            } else {
                tf1.setBorder(BorderFactory.createLineBorder(Color.red));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(l4)) {
            new AdminDashboard(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(addadmin)) {
            new AddAdmin(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l5)) {
            new CustomerSignupForm(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l6)) {
            new Deposit(printname).setVisible(true);
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
}
