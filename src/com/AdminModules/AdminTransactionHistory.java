package com.AdminModules;

import com.Helper.ConnectionProvider;
import com.Designs.DashboardDesign;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class AdminTransactionHistory extends DashboardDesign implements ActionListener, MouseListener {

    JLabel heading, Eacc, label1, label2, label3, label4;
    JTextField tf1;
    JButton search;
    JTable table;
    JScrollPane spane;
    JPanel tablepanel;
    String accno;
    String[] columnNames;
    Connection con = ConnectionProvider.getConnection();
    Statement stmt;
    ResultSet set;
    String printname;
    public static DefaultTableModel model;

    public AdminTransactionHistory(String printname) {
        this.printname = printname;
        l3.setText(printname);
        setSize(1100, 640);
        navpanel.setBounds(0, 0, 1190, 45);
        l1.setBounds(410, 10, 300, 25);
        l2.setBounds(900, 10, 70, 25);
        l3.setBounds(975, 10, 200, 25);

        sidepanel.setBounds(0, 45, 250, 640);

        setTitle("Transaction History - Bank Management System");
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);

        columnNames = new String[]{"Date", "Cr/dr", "Amount"};

        heading = new JLabel("Transaction History");
        Eacc = new JLabel("Enter Account Number:");
        label1 = new JLabel("Customer Name:");
        label2 = new JLabel();
        label3 = new JLabel("Available Balance:");
        label4 = new JLabel();
        tf1 = new JTextField();
        search = new JButton("Search");
        tablepanel = new JPanel(new BorderLayout());
        table = new JTable() {
            @Override
            public boolean isCellEditable(int data, int column) {
                return false;
            }
        };

        Font tablefont = new Font("Arial", Font.PLAIN, 15);

        table.setFont(tablefont);

        spane = new JScrollPane(table);
        model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.setBackground(Color.white);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setRowHeight(23);
        table.getTableHeader().setBackground(color);
        table.getTableHeader().setForeground(Color.WHITE);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setPreferredSize(new Dimension(10, 23));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));

        heading.setBounds(550, 70, 250, 25);
        heading.setFont(font);
        add(heading);

        Eacc.setBounds(340, 120, 200, 25);
        Eacc.setFont(font1);
        add(Eacc);

        tf1.setBounds(515, 120, 350, 25);
        tf1.setFont(font1);
        add(tf1);

        search.setBounds(880, 120, 100, 25);
        search.setBackground(color);
        search.setForeground(Color.white);
        search.setFont(font4);
        add(search);

        label1.setBounds(370, 190, 150, 25);
        label1.setFont(font4);
        add(label1);

        label2.setBounds(520, 190, 190, 25);
        label2.setFont(font1);
        add(label2);

        label3.setBounds(740, 190, 150, 25);
        label3.setFont(font4);
        add(label3);

        label4.setBounds(890, 190, 150, 25);
        label4.setFont(font1);
        add(label4);

        tablepanel.setBounds(280, 250, 770, 320);
        tablepanel.setBackground(Color.white);
        c.add(tablepanel);
        tablepanel.add(spane);

        l4.addMouseListener(this);
        l5.addMouseListener(this);
        l6.addMouseListener(this);
        l7.addMouseListener(this);
        l9.addMouseListener(this);
        l10.addMouseListener(this);
        l11.addMouseListener(this);
        addadmin.addMouseListener(this);

        search.addActionListener(this);
    }

    public static void main(String[] args) {
        new AdminTransactionHistory("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String daccno = null;
        label2.setText("");
        label4.setText("");
        accno = tf1.getText();
        String date = null, particulars = null, amount = null, balance = null, CustID = null, fname = null, lname = null;
        if (AdminDashboard.isNumeric(accno)) {
            tf1.setBorder(BorderFactory.createLineBorder(Color.black));
            //database--->
            ((DefaultTableModel) table.getModel()).setNumRows(0);
            try {
                String q = "select * from account";
                stmt = con.createStatement();
                set = stmt.executeQuery(q);
                while (set.next()) {
                    daccno = set.getString(1);
                    if (daccno.equals(accno)) {
                        CustID = set.getString(2);
                        balance = set.getString(4);
                        break;
                    }
                }
                if (daccno.equals(accno)) {
                    q = "select * from account where acc_No='" + accno + "'";
                    set = stmt.executeQuery(q);
                    while (set.next()) {
                        CustID = set.getString(2);
                        balance = set.getString(4);
                    }
                    q = "select * from customer where cust_ID='" + CustID + "'";
                    set = stmt.executeQuery(q);
                    while (set.next()) {
                        fname = set.getString(2);
                        lname = set.getString(3);
                    }
                    label2.setText(fname + " " + lname);
                    label4.setText("₹ " + balance);
                    q = "select * from transactions where Acc_no='" + accno + "' order by date DESC";
                    set = stmt.executeQuery(q);
                    while (set.next()) {
                        date = set.getString(3);
                        particulars = set.getString(4);
                        amount = "₹ "+set.getString(5);
                        model.insertRow(model.getRowCount(), new String[]{
                            date,
                            particulars,
                            amount,});
                    }
                } else {
                    JOptionPane.showMessageDialog(c, "Invalid Account Number. Try Again.");
                }

            } catch (SQLException ex) {
            }
        } else {
            tf1.setBorder(BorderFactory.createLineBorder(Color.red));
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
