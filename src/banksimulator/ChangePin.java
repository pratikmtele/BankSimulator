package banksimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ChangePin extends JFrame implements ActionListener {
    Container c;
    JLabel l1, l2, l3, l4;
    JButton b1, b2;
    JPasswordField pf1, pf2;
    String pin, accno;
    ChangePin(String pin, String accno) {
        this.accno = accno;
        this.pin = pin;
        ImageIcon icon = new ImageIcon("src/img/atm.jpg");
       
        l1 = new JLabel(icon);
        l2 = new JLabel("YOUR CHANGE PIN");
        l3 = new JLabel("New Pin :");
        l4 = new JLabel("Re-Enter Pin :");
        b1 = new JButton("CHANGE PIN");
        b2 = new JButton("BACK");
        pf1 = new JPasswordField();
        pf2 = new JPasswordField();

        c = this.getContentPane();
        c.setLayout(null);

        Font font = new Font("Segoe UI Semibold", Font.BOLD, 13);
        Font font1 = new Font("Segoe UI Semibold", Font.BOLD, 12);

        l1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(l1);

        l2.setBounds(220, 120, 290, 20);
        l2.setFont(font);
        l2.setForeground(Color.white);
        l1.add(l2);

        l3.setBounds(120, 165, 100, 20);
        l3.setFont(font);
        l3.setForeground(Color.white);
        l1.add(l3);

        l4.setBounds(120, 225, 100, 20);
        l4.setFont(font);
        l4.setForeground(Color.white);
        l1.add(l4);

          
        pf1.setBounds(210, 168, 200, 21);
        pf1.setFont(font);
        c.add(pf1);

        pf2.setBounds(210, 225, 200, 21);
        pf2.setFont(font);
        c.add(pf2);

        b1.setBounds(310, 324, 150, 28);
        b1.setFont(font1);
        l1.add(b1);

        b2.setBounds(310, 364, 150, 28);
        b2.setFont(font1);
        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(806, 725);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String npin = pf2.getText();
        if (e.getSource() == b1) {
            if (pf1.getText().equals("") || pf2.getText().equals("")) {
                JOptionPane.showMessageDialog(c, "Please Enter New password.");
            } else {
                if (pf1.getText().equals(pf2.getText())) {
                    try {
                        Connection con = ConnectionProvider.getConnection();
                        Statement s = con.createStatement();
                        s.executeLargeUpdate("update signup3 set PIN_No='" + npin + "' where Account_Number='" + accno + "'");
                        s.executeLargeUpdate("update login set Pin='" + npin + "' where Account_Number='" + accno + "'");
                        s.executeLargeUpdate("update transaction set PIN_No='" + npin + "' where Account_No='" + accno + "'");
                        JOptionPane.showMessageDialog(c, "Pin Changed Successfully.");
                        
                        ResultSet set =s.executeQuery("select * from login where Account_Number='"+accno+"' ");
                        while(set.next())
                        {
                            pin = set.getString("Pin");
                        }
                    } catch (SQLException ex) {
                    }
                }else
                    JOptionPane.showMessageDialog(c, "Pin not matched. Please Try Again.");
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
            new Transactions(pin, accno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        ChangePin p = new ChangePin("", "");
    }
}