package com.AdminModules;

import com.Helper.ConnectionProvider;
import com.Designs.DashboardDesign;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class AccountList extends DashboardDesign implements MouseListener{
    JLabel heading;
    JTable table;
    JScrollPane spane;
    JPanel tablepanel;
    String accno;
    String[] columnNames;
    static DefaultTableModel model;
    String fname,lname,CustID,address,mobileno,accnno,name,printname;
    Connection con;
    public AccountList(String printname){
        this.printname = printname;
        l3.setText(printname);
        setSize(1190,600);
        navpanel.setBounds(0, 0, 1190, 45);
        l1.setBounds(470, 10, 300, 25);
        l2.setBounds(980, 10, 70, 25);
        l3.setBounds(1055, 10, 200, 25);
        setTitle("Account Lists - Bank Management System");
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        
        columnNames = new String[]{"Customer_ID", "Customer Name", "Account No.", "Address", "Phone No."};
        
        heading = new JLabel("Account List");
        tablepanel = new JPanel(new BorderLayout());
        table = new JTable(){
            @Override
            public boolean isCellEditable(int data, int column) {
                return false;
            }
        };
        Font tablefont = new Font("Arial",Font.PLAIN,14);
        
        spane = new JScrollPane(table);
        model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(190);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.setBackground(Color.white);
        table.setFont(tablefont);
        table.setRowHeight(23); 
        table.getTableHeader().setReorderingAllowed(false); //disabled column ordering
        table.getTableHeader().setResizingAllowed(false);  // disabled column resizing
        table.getTableHeader().setBackground(color);  // header bg color
        table.getTableHeader().setForeground(Color.WHITE); // header text color
        table.setFillsViewportHeight(true);
        table.getTableHeader().setPreferredSize(new Dimension(10,23)); 
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        
        
        heading.setBounds(650, 80, 150, 25);
        heading.setFont(font);
        add(heading);
        
        tablepanel.setBounds(280,140,860,390);
        tablepanel.setBackground(Color.white);
        c.add(tablepanel);
        tablepanel.add(spane);
        
        try{
            con = ConnectionProvider.getConnection();
            Statement stmt = con.createStatement();
            String q = "select * from  customer order by fname";
            ResultSet set = stmt.executeQuery(q);
            ResultSet set1;
            while(set.next()){
                CustID = set.getString(1);
                fname = set.getString(2);
                lname = set.getString(3);
                address = set.getString(4);
                mobileno = set.getString(5);
                name = fname+" "+lname;
                accnno = accnnoNumber(CustID);
                model.insertRow(model.getRowCount(), new String []{
                    CustID,
                    name,
                    accnno,
                    address,
                    mobileno
                });
            }
        }catch(SQLException ex){}

	//Add mouseListerner
        
        l4.addMouseListener(this);
        l5.addMouseListener(this);
        l6.addMouseListener(this);
        l7.addMouseListener(this);
        l8.addMouseListener(this);
        l10.addMouseListener(this);
        l11.addMouseListener(this);
        addadmin.addMouseListener(this);
    }
    public static void main(String []args){
        new AccountList("").setVisible(true);
    }
    
    public  String accnnoNumber(String Cust_ID){
        String aaccno=null;
        String q1 = "select * from account where Cust_ID='"+Cust_ID+"'";
        try{
            Statement stmt = con.createStatement();
        ResultSet set1 = stmt.executeQuery(q1);
        while(set1.next()){
            aaccno = set1.getString(1);
        }
        }catch(SQLException ex){}
        if(aaccno==null)
            return "INACTIVE";
        else
        return aaccno;
    }
        
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(l4)){
            new AdminDashboard(printname).setVisible(true);
            setVisible(false);
        } else if(e.getSource().equals(addadmin)){
            new AddAdmin(printname).setVisible(true);
            setVisible(false);
        } else if(e.getSource().equals(l5)){
            new CustomerSignupForm(printname).setVisible(true);
            setVisible(false);
        } else if(e.getSource().equals(l6)){
            new Deposit(printname).setVisible(true);
            setVisible(false);
        } else if(e.getSource().equals(l7)){
            new Withdraw(printname).setVisible(true);
            setVisible(false);
        } else if(e.getSource().equals(l8)){
            new AdminTransactionHistory(printname).setVisible(true);
            setVisible(false);
        } else if(e.getSource().equals(l10)){
            new AccountDetails(printname).setVisible(true);
            setVisible(false);
        } else if(e.getSource().equals(l11)){
            new AdminLogin().setVisible(true);
            setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
