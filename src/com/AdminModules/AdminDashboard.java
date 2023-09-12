package com.AdminModules;

import com.Helper.ConnectionProvider;
import com.Designs.DashboardDesign;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AdminDashboard extends DashboardDesign implements MouseListener{
    
    String fname, lname, CustID, password, username, trans_ID, printname,q1;
    Connection con = ConnectionProvider.getConnection();
    Statement stmt;
    int aaccount = 0;
    ResultSet set;
    double todaycr = 0, todaydt = 0;

    public AdminDashboard(String printname) {
        this.printname = printname;
        l3.setText(printname);

        setTitle("Admin Dashboard - Bank Management System");

        l16.setText("Active Accounts");

        //Today's cr and dr
        long millis = System.currentTimeMillis();
        Date d = new Date(millis);
        String curdate = "" + d;
        try {
            stmt = con.createStatement();
            q1 = "select * from transactions";
            set = stmt.executeQuery(q1);
            while (set.next()) {
                String date = set.getString(3);
                String substring = date.substring(0, 10);
                if (curdate.equals(substring)) {
                    double amount = Double.parseDouble(set.getString(5));
                    String particulars = set.getString(4);
                    if (particulars.equals("Deposit")) {
                        todaycr += amount;
                    } else if (particulars.equals("Withdraw")) {
                        todaydt += amount;
                    }
                }
            }
        } catch (SQLException ex) {
        }
        l13.setText("₹ " + todaycr);
        l15.setText("₹ " + todaydt);
        // for Active Accounts
        try {
            q1 = "select * from customer";
            set = stmt.executeQuery(q1);
            while (set.next()) {
                aaccount++;
            }
        } catch (SQLException ex) {
        }
        l17.setText("" + aaccount);

        l5.addMouseListener(this);
        l6.addMouseListener(this);
        l8.addMouseListener(this);
        l9.addMouseListener(this);
        l10.addMouseListener(this);
        l11.addMouseListener(this);
        addadmin.addMouseListener(this);
        
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new AdminDashboard("").setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(addadmin)) {
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
