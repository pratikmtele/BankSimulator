package com.AdminModules;

import com.Helper.ConnectionProvider;
import com.Designs.DashboardDesign;
import static com.Helper.Helper.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AccountDetails extends DashboardDesign implements MouseListener, ActionListener {

    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12,label13,label14;
    JButton search, upinfo, save, closeacc;
    JTextField tf1, tf2, tf3, tf4, tf5,tf6,tf7;
    Connection con = ConnectionProvider.getConnection();
    ResultSet set;
    Statement stmt;
    String printname;
    JDateChooser datechooser;

    public AccountDetails(String printname) {
        this.printname = printname;
        setSize(1080, 690);
        setTitle("Account Details - Bank Management System");
        l3.setText(printname);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);

        label1 = new JLabel("Account Details");
        label2 = new JLabel("Enter Account Number:");
        label3 = new JLabel("Account Number:");
        label4 = new JLabel();
        label5 = new JLabel("Account Type:");
        label6 = new JLabel();
        label7 = new JLabel("Balance Available:");
        label8 = new JLabel();
        label9 = new JLabel("First Name:");
        label10 = new JLabel("Last Name:");
        label11 = new JLabel("Address:");
        label12 = new JLabel("Mobile No.:");
        label13 = new JLabel("DOB :");
        label14 = new JLabel("Email ID :");
        search = new JButton("Search");
        upinfo = new JButton("Update Information");
        save = new JButton("Save");
        closeacc = new JButton("Close Account");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        datechooser = new JDateChooser();
        Font textfieldfont = new Font("Arial", Font.PLAIN, 15);

        label1.setBounds(550, 60, 170, 25);
        label1.setFont(font);
        add(label1);

        label2.setBounds(350, 120, 170, 25);
        label2.setFont(font1);
        add(label2);

        tf1.setBounds(520, 120, 310, 25);
        tf1.setFont(textfieldfont);
        add(tf1);

        search.setBounds(840, 120, 100, 25);
        search.setBackground(color);
        search.setForeground(Color.WHITE);
        search.setFont(font4);
        add(search);

        label3.setBounds(350, 190, 150, 25);
        label3.setFont(font4);
        add(label3);

        label4.setBounds(500, 190, 150, 25);
        label4.setFont(font1);
        add(label4);

        label5.setBounds(661, 190, 150, 25);
        label5.setFont(font4);
        add(label5);

        label6.setBounds(785, 190, 180, 25);
        label6.setFont(font1);
        add(label6);

        label7.setBounds(500, 240, 180, 25);
        label7.setFont(font4);
        add(label7);

        label8.setBounds(655, 240, 180, 25);
        label8.setFont(font1);
        add(label8);

        label9.setBounds(350, 300, 150, 25);
        label9.setFont(font1);
        add(label9);

        tf2.setBounds(460, 300, 350, 25);
        tf2.setFont(textfieldfont);
        add(tf2);

        label10.setBounds(350, 350, 150, 25);
        label10.setFont(font1);
        add(label10);

        textfieldEditable(false);

        tf3.setBounds(460, 350, 350, 25);
        tf3.setFont(textfieldfont);
        add(tf3);

        label11.setBounds(350, 400, 150, 25);
        label11.setFont(font1);
        add(label11);

        tf4.setBounds(460, 400, 350, 25);
        tf4.setFont(textfieldfont);
        add(tf4);

        label12.setBounds(350, 450, 150, 25);
        label12.setFont(font1);
        add(label12);

        tf5.setBounds(460, 450, 350, 25);
        tf5.setFont(textfieldfont);
        add(tf5);
        
        label13.setBounds(350, 500, 150, 25);
        label13.setFont(font1);
        add(label13);
        
        tf6.setBounds(460, 500, 350, 25);
        tf6.setFont(textfieldfont);
        add(tf6);

        datechooser.setBounds(460, 500, 350, 25);
        datechooser.setEnabled(false);
        add(datechooser);
        datechooser.setVisible(false);
        
        label14.setBounds(350, 550, 150, 25);
        label14.setFont(font1);
        add(label14);

        tf7.setBounds(460, 550, 350, 25);
        tf7.setFont(textfieldfont);
        add(tf7);

        closeacc.setBounds(450, 600, 150, 25);
        closeacc.setBackground(color);
        closeacc.setForeground(Color.white);
        closeacc.setFont(font4);
        add(closeacc);

        upinfo.setBounds(650, 600, 190, 25);
        upinfo.setBackground(color);
        upinfo.setForeground(Color.WHITE);
        upinfo.setFont(font4);
        add(upinfo);

        save.setBounds(840, 600, 100, 25);
        save.setBackground(color);
        save.setForeground(Color.WHITE);
        save.setFont(font4);
        save.setVisible(false);
        add(save);

        l4.addMouseListener(this);
        l5.addMouseListener(this);
        l6.addMouseListener(this);
        l7.addMouseListener(this);
        l8.addMouseListener(this);
        l9.addMouseListener(this);
        l11.addMouseListener(this);
        addadmin.addMouseListener(this);

        search.addActionListener(this);
        closeacc.addActionListener(this);
        upinfo.addActionListener(this);
        save.addActionListener(this);
    }

    public static void main(String[] args) {
        new AccountDetails("").setVisible(true);
    }

    public void textfieldEditable(boolean str) {
        tf2.setEditable(str);
        tf3.setEditable(str);
        tf4.setEditable(str);
        tf5.setEditable(str);
        tf6.setEditable(str);
        tf7.setEditable(str);
        datechooser.setEnabled(str);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fname = null, lname;
        lname = null;
        String address = null, mobileno = null,DOB=null,email=null;
        String username = null,acctype = null, balance = null, validaccno = null, CustID = null;
        String dob = "" + ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String email_ID = tf7.getText();
        String accno = tf1.getText();
        String efname = tf2.getText();
        String elname = tf3.getText();
        String eaddress = tf4.getText();
        String emobileno = tf5.getText();
        if (e.getSource().equals(search)) {
            if (AdminDashboard.isNumeric(accno)) {
                tf1.setBorder(BorderFactory.createLineBorder(Color.black));
                //Database--->
                try {
                    stmt = con.createStatement();
                    String q = "select * from account";
                    set = stmt.executeQuery(q);
                    while (set.next()) {
                        validaccno = set.getString(1);
                        if (validaccno.equals(accno)) {
                            CustID = set.getString(2);
                            acctype = set.getString(3);
                            balance = set.getString(4);
                            break;
                        }
                    }
                    if (validaccno.equals(accno)) {
                        q = "select * from customer where cust_ID='" + CustID + "'";
                        set = stmt.executeQuery(q);
                        while (set.next()) {
                            fname = set.getString(2);
                            lname = set.getString(3);
                            address = set.getString(4);
                            mobileno = set.getString(5);
                            DOB = set.getString(6);
                            email = set.getString(7);
                            
                            label4.setText(accno);
                            label6.setText(acctype);
                            label8.setText("₹ " + balance);
                            tf2.setText(fname);
                            tf3.setText(lname);
                            tf4.setText(address);
                            tf5.setText(mobileno);
                            tf6.setText(DOB);
                            tf7.setText(email);
                        }
                    } else {
                        JOptionPane.showMessageDialog(c, "Invalid Account Number. Try Again.");
                    }
                } catch (HeadlessException | SQLException ex) {
                }
            } else {
                tf1.setBorder(BorderFactory.createLineBorder(Color.red));
            }
        } else if (e.getSource().equals(upinfo)) {
            if (AdminDashboard.isNumeric(accno)) {
                tf1.setBorder(BorderFactory.createLineBorder(Color.black));
                try {
                    String q = "select * from account";
                    set = stmt.executeQuery(q);
                    while (set.next()) {
                        validaccno = set.getString(1);
                        if (validaccno.equals(accno)) {
                            break;
                        }
                    }
                    if (validaccno.equals(accno)) {
                        upinfo.setVisible(false);
                        closeacc.setVisible(false);
                        save.setVisible(true);
                        datechooser.setVisible(true);
                        tf6.setVisible(false);
                        textfieldEditable(true);
                    } else {
                        JOptionPane.showMessageDialog(c, "Invalid Account Number. Try Again.");
                    }
                } catch (HeadlessException | SQLException ex) {
                }

            } else {
                tf1.setBorder(BorderFactory.createLineBorder(Color.red));
            }
        } else if (e.getSource().equals(save)) {
            if (efname.equals("") || elname.equals("") || eaddress.equals("") || emobileno.equals("")) {
                JOptionPane.showMessageDialog(c, "Enter all required Fields.");
            } else {
                //First name and Last name Validation
                if (firstName(efname) && lastName(elname)) {
                    //mobile number Validation
                    if (!isvalidmobileno(emobileno)) {
                        JOptionPane.showMessageDialog(c, "Invalid Mobile Number.Try Again.");
                    } else {
                        //database--->
                        try {
                            String q = "select * from account";
                            stmt = con.createStatement();
                            set = stmt.executeQuery(q);
                            while (set.next()) {
                                validaccno = set.getString(1);
                                if (validaccno.equals(accno)) {
                                    CustID = set.getString(2);
                                    break;
                                }
                            }
                            if (validaccno.equals(accno)) {
                                q = "update customer set fname='" + efname + "',lname='" + elname + "',address='" + eaddress + "',contact_add='" + emobileno + "', "
                                        + "DOB='"+dob+"', EmailID='"+email_ID+"' where cust_ID='" + CustID + "'";
                                stmt.executeUpdate(q);
                                JOptionPane.showMessageDialog(c, "Account Updated successfully.");
                                textfieldEditable(false);
                                upinfo.setVisible(true);
                                closeacc.setVisible(true);
                                save.setVisible(false);
                                datechooser.setVisible(false);
                                tf6.setVisible(true);
                                tf1.setText("");
                                tf2.setText("");
                                tf3.setText("");
                                tf4.setText("");
                                tf5.setText("");
                                tf6.setText("");
                                tf7.setText("");
                            } else {
                                JOptionPane.showMessageDialog(c, "Invalid Account Number. Try Again.");
                            }
                        } catch (SQLException ex) {
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(c, "Invalid First Name or last Name.\nFirst Character Must be Upper Case.");
                }
            }
        } else if (e.getSource().equals(closeacc)) {
            if (AdminDashboard.isNumeric(accno)) {
                tf1.setBorder(BorderFactory.createLineBorder(Color.black));
                //database--->
                try {
                    String q1 = "select * from account";
                    stmt = con.createStatement();
                    set = stmt.executeQuery(q1);
                    while (set.next()) {
                        validaccno = set.getString(1);
                        if (validaccno.equals(accno)) {
                            CustID = set.getString(2);
                            break;
                        }
                    }
                    if (validaccno.equals(accno)) {
                        q1 = "select * from customer where cust_ID='" + CustID + "'";
                        set = stmt.executeQuery(q1);
                        while (set.next()) {
                            username = set.getString(6);
                        }
                      
                        q1 = "delete from account where acc_No='" + validaccno + "'";
                        stmt.executeUpdate(q1);
                        q1 = "delete from transactions where Acc_no='" + validaccno + "'";
                        stmt.executeUpdate(q1);
                        q1 = "delete from customer where cust_ID='" + CustID + "'";
                        stmt.executeUpdate(q1);
                        JOptionPane.showMessageDialog(c, "Account Closed.");
                        label4.setText("");
                        label6.setText("");
                        label8.setText("");
                        tf1.setText("");
                        tf2.setText("");
                        tf3.setText("");
                        tf4.setText("");
                        tf5.setText("");
                    } else {
                        JOptionPane.showMessageDialog(c, "Invalid Account Number. Try Again.");
                    }
                } catch (SQLException ex) {
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
        } else if (e.getSource().equals(l7)) {
            new Withdraw(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l8)) {
            new AdminTransactionHistory(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l9)) {
            new AccountList(printname).setVisible(true);
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
