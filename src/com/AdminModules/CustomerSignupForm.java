package com.AdminModules;

import com.Designs.DashboardDesign;
import com.Helper.ConnectionProvider;
import com.Helper.Helper;
import static com.Helper.Helper.*;
import java.awt.Color;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class CustomerSignupForm extends DashboardDesign implements ActionListener, MouseListener {

    JPanel signPanel;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    JRadioButton r1, r2, r3, r4, r5;
    ButtonGroup grpbtn, grpbtn1;
    JTextField tf1, tf2, tf3, tf4, tf5;
    JPasswordField pf;
    JButton add;
    String customer_ID, accno, printname;
    JDateChooser datechooser;

    CustomerSignupForm(String printname) {
        this.printname = printname;
        l3.setText(printname);
        setTitle("Add Customer - Bank Management System");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
        setTitle("Add Admin - Bank Management System");
        setSize(1080, 650);

        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);

        ImageIcon icon1 = new ImageIcon("src/Images/bankicon.png");

        Font textfieldfont = new Font("Arial", Font.PLAIN, 14);

        signPanel = new JPanel();
        label1 = new JLabel("Create Customer Account");
        label2 = new JLabel("Enter First Name :");
        label3 = new JLabel("Enter Last Name :");
        label4 = new JLabel("Address :");
        label5 = new JLabel("Mobile No. :");
        label6 = new JLabel("Enter DOB :");
        label7 = new JLabel("Enter Email-ID :");
        label8 = new JLabel("select Gender :");
        label9 = new JLabel("Select Type of account :");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        pf = new JPasswordField();
        add = new JButton("Add");
        datechooser = new JDateChooser();
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        r3 = new JRadioButton("Saving Account");
        r4 = new JRadioButton("Current Account");
        r5 = new JRadioButton("Fixed Deposit Account");
        grpbtn = new ButtonGroup();
        grpbtn1 = new ButtonGroup();

        signPanel.setBounds(350, 70, 600, 530);
        signPanel.setBackground(Color.WHITE);
        signPanel.setLayout(null);
        signPanel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        add(signPanel);

        label1.setBounds(160, 20, 600, 30);
        label1.setFont(font);
        label1.setForeground(color);
        signPanel.add(label1);

        label2.setBounds(70, 70, 200, 25);
        label2.setFont(font1);
        signPanel.add(label2);

        tf1.setBounds(210, 74, 300, 25);
        tf1.setFont(textfieldfont);
        signPanel.add(tf1);

        label3.setBounds(70, 120, 150, 25);
        label3.setFont(font1);
        signPanel.add(label3);

        tf2.setBounds(210, 124, 300, 25);
        tf2.setFont(textfieldfont);
        signPanel.add(tf2);

        label4.setBounds(70, 170, 150, 25);
        label4.setFont(font1);
        signPanel.add(label4);

        tf3.setBounds(210, 174, 300, 25);
        tf3.setFont(textfieldfont);
        signPanel.add(tf3);

        label5.setBounds(70, 220, 150, 25);
        label5.setFont(font1);
        signPanel.add(label5);

        tf4.setBounds(210, 224, 300, 25);
        tf4.setFont(textfieldfont);
        signPanel.add(tf4);

        label6.setBounds(70, 270, 150, 25);
        label6.setFont(font1);
        signPanel.add(label6);

        datechooser.setBounds(210, 274, 300, 25);
        signPanel.add(datechooser);

        label7.setBounds(70, 320, 150, 25);
        label7.setFont(font1);
        signPanel.add(label7);

        tf5.setBounds(210, 324, 300, 25);
        tf5.setFont(textfieldfont);
        signPanel.add(tf5);

        label8.setBounds(70, 370, 150, 25);
        label8.setFont(font1);
        signPanel.add(label8);

        r1.setBounds(210, 374, 80, 25);
        r1.setBackground(Color.WHITE);
        r1.setSelected(true);
        r1.setFont(textfieldfont);
        signPanel.add(r1);

        r2.setBounds(300, 374, 80, 25);
        r2.setBackground(Color.WHITE);
        r2.setFont(textfieldfont);
        signPanel.add(r2);

        grpbtn.add(r1);
        grpbtn.add(r2);

        label9.setBounds(70, 420, 170, 25);
        label9.setFont(font1);
        signPanel.add(label9);

        r3.setBounds(100, 455, 135, 30);
        r3.setBackground(Color.WHITE);
        r3.setSelected(true);
        r3.setFont(textfieldfont);
        signPanel.add(r3);

        r4.setBounds(240, 455, 135, 30);
        r4.setBackground(Color.WHITE);
        r4.setFont(textfieldfont);
        signPanel.add(r4);

        r5.setBounds(380, 455, 170, 30);
        r5.setBackground(Color.WHITE);
        r5.setFont(textfieldfont);
        signPanel.add(r5);

        grpbtn1.add(r3);
        grpbtn1.add(r4);
        grpbtn1.add(r5);

        add.setBounds(250, 492, 100, 25);
        add.setFont(font2);
        add.setForeground(Color.white);
        add.setBackground(color);
        signPanel.add(add);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(icon1.getImage());

        //Customer_ID Generate 
        Random ran = new Random();
        long first4 = (ran.nextInt() % 9000) + 1000;
        customer_ID = "customer" + Math.abs(first4);

        add.addActionListener(this);

        l4.addMouseListener(this);
        l6.addMouseListener(this);
        l7.addMouseListener(this);
        l8.addMouseListener(this);
        l9.addMouseListener(this);
        l10.addMouseListener(this);
        l11.addMouseListener(this);
        addadmin.addMouseListener(this);
    }

    public static void main(String[] args) {
        new CustomerSignupForm("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add)) {
            String fname = tf1.getText();
            String lname = tf2.getText();
            String address = tf3.getText();
            String mobileno = tf4.getText();
            String dob = "" + ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
            String email_ID = tf5.getText();
            String gender="Male";
            if (r1.isSelected()) {
                gender = "Male";
            }
            if(r2.isSelected()){
                gender = "Female";
            }
            String tacc;
            if (r3.isSelected()) {
                tacc = "Saving Account";
            } else if (r4.isSelected()) {
                tacc = "Current Account";
            } else {
                tacc = "Fixed Deposit Account";
            }
            //Input Validation

            if (fname.equals("") || lname.equals("") || address.equals("") || mobileno.equals("") || dob.equals("") || email_ID.equals("")) {
                JOptionPane.showMessageDialog(c, "Enter all required Fields.");
                //First name and Last name Validation
            } else if (firstName(fname) && lastName(lname)) {
                //Mobile Number Validation
                if (!Helper.isvalidmobileno(mobileno)) {
                    JOptionPane.showMessageDialog(c, "Invalid Mobile Number.Try Again.");
                } else if(isValidEmail(email_ID)){
                    //database--->
                    try {
                        String amount = JOptionPane.showInputDialog(c, "Enter Amount :");
                        if (Double.parseDouble(amount) != 0 || !amount.equals("")) {
                            Connection con = ConnectionProvider.getConnection();
                            String q = "insert into customer values('" + customer_ID + "','" + fname + "','" + lname + "','" + address + "','" + mobileno + "','" + dob + "','" + email_ID + "','" + gender + "')";
                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(q);

                            //Account Number
                            Random ran = new Random();
                            long ranno = (ran.nextLong() % 900L) + 1000300L;
                            String accno = "" + Math.abs(ranno);
                            //Transaction Id 
                            long id = (ran.nextLong() % 9000) + 1000;
                            String TransID = "trans" + Math.abs(id);

                            q = "insert into account values('" + accno + "','" + customer_ID + "','" + tacc + "','" + amount + "')";
                            stmt.executeUpdate(q);

                            //for transactions table
                            long time = System.currentTimeMillis();
                            Timestamp timestamp = new Timestamp(time);
                            String d = "" + timestamp;
                            String date = d.substring(0, 19);
                            q = "insert into transactions values('" + TransID + "','" + accno + "','" + date + "','" + "Deposit" + "','" + amount + "')";
                            stmt.executeUpdate(q);
                            JOptionPane.showMessageDialog(c, "Account Created Successfully.");
                            tf1.setText("");
                            tf2.setText("");
                            tf3.setText("");
                            tf4.setText("");
                            datechooser.setCalendar(null);
                            tf5.setText("");
                            r1.setSelected(true);
                            r3.setSelected(true);
                        } else {
                            JOptionPane.showMessageDialog(c, "Invalid Amount...");
                        }

                    } catch (SQLException ex) {
                    }
                }else{
                    JOptionPane.showMessageDialog(c, "Invalid Email Address...");
                }
            } else {
                JOptionPane.showMessageDialog(c, "Invalid First Name or last Name.\nFirst Character Must be Upper Case.");
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(addadmin)) {
            new AddAdmin(printname).setVisible(true);
            setVisible(false);
        } else if (e.getSource().equals(l4)) {
            new AdminDashboard(printname).setVisible(true);
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
  
}
