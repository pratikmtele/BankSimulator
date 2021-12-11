package banksimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
    Container c;
    JLabel l1,l2;
    JButton b1,b2;
    JTextField tf;
    String pin,accno;
    Deposit(String pin,String accno)
    {
        this.accno=accno;
        this.pin=pin;
        ImageIcon icon = new ImageIcon("src/img/atm.jpg");
       
        l1 = new JLabel(icon);
        l2 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        tf = new JTextField();
        c = this.getContentPane();
        c.setLayout(null);
        
        Font font = new Font("Segoe UI Semibold",Font.BOLD,13);
        Font font1 = new Font("Segoe UI Semibold",Font.BOLD,12);
        
        l1.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        c.add(l1);
        
        l2.setBounds(140,120,260,20);
        l2.setFont(font);
        l2.setForeground(Color.white);
        l1.add(l2);
        
        tf.setBounds(140,160,260,21);
        l1.add(tf);
        
        b1.setBounds(310,324,150,28);
        b1.setFont(font1);
        l1.add(b1);
        
        b2.setBounds(310,364,150,28);
        b2.setFont(font1);
        l1.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(806,725);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String amount =""+tf.getText();
        Date date = new Date();

        String mode ="Deposit";
        if(e.getSource()==b1)
        {
            Connection con = ConnectionProvider.getConnection();
            String q ="insert into transaction values('"+accno+"','"+pin+"','"+date+"','"+mode+"','"+amount+"')";
            try {
                Statement s = con.createStatement();
                s.executeUpdate(q);
                JOptionPane.showMessageDialog(c,"Rs. "+amount+" Deposited Successfully");
            } catch (SQLException ex) {
            }
        }else if(e.getSource()==b2)
        {
            setVisible(false);
            new Transactions(pin,accno).setVisible(true);
        }
    }
    
    public static void main(String []args)
    {
        Deposit deposit = new Deposit("","");
    }
}