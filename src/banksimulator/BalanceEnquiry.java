package banksimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    Container c;
    JLabel l1, l2;
    JButton b1;
    JTextField tf;
    String pin, accno;
   
    
    BalanceEnquiry(String pin, String accno) {
        double balance=0;
        this.accno = accno;
        this.pin = pin;
        ImageIcon icon = new ImageIcon("src/img/atm.jpg");
      
        l1 = new JLabel(icon);
        l2 = new JLabel();
        b1 = new JButton("BACK");
        
        c = this.getContentPane();
        c.setLayout(null);
        
        Font font = new Font("Segoe UI Semibold", Font.BOLD, 13);
        Font font1 = new Font("Segoe UI Semibold", Font.BOLD, 12);
        
        l1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(l1);
        
        b1.setBounds(310, 366, 150, 28);
        b1.setFont(font1);
        l1.add(b1);
        
        l2.setBounds(140, 120, 290, 20);
        l2.setFont(font);
        l2.setForeground(Color.white);
        l1.add(l2);
        
        try {
            Connection con = ConnectionProvider.getConnection();
            Statement s = con.createStatement();
            ResultSet set = s.executeQuery("select * from transaction where PIN_No='" + pin + "' ");
            while (set.next()) {
                if (set.getString("Mode").equals("Deposit")) {
                    balance += Double.parseDouble(set.getString("Amount"));
                } else if (set.getString("Mode").equals("Withdrawl")) {
                    balance -= Double.parseDouble(set.getString("Amount"));
                }
            }
            l2.setText(" Your current account balance is Rs " + balance);
        } catch (SQLException ex) {
        }
        
        b1.addActionListener(this);
        
        setSize(806, 725);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pin, accno).setVisible(true);
    }
    
    public static void main(String[] args) {
        BalanceEnquiry e = new BalanceEnquiry("", "");
    }
}
