package banksimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {

    Container c;
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin, accno;

    FastCash(String pin, String accno) {
        this.accno = accno;
        this.pin = pin;
        ImageIcon icon = new ImageIcon("src/img/atm.jpg");
        
        l1 = new JLabel(icon);
        l2 = new JLabel("SELECT WITHDRAWL AMOUNT");
        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");
        c = this.getContentPane();
        c.setLayout(null);

        Font font = new Font("Segoe UI Semibold", Font.BOLD, 15);
        Font font1 = new Font("Segoe UI Semibold", Font.BOLD, 12);

        l1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(l1);

        l2.setBounds(170, 100, 220, 20);
        l2.setFont(font);
        l2.setForeground(Color.white);
        l1.add(l2);

        b1.setBounds(95, 242, 150, 28);
        b1.setFont(font1);
        l1.add(b1);

        b2.setBounds(310, 242, 150, 28);
        b2.setFont(font1);
        l1.add(b2);

        b3.setBounds(95, 283, 150, 28);
        b3.setFont(font1);
        l1.add(b3);

        b4.setBounds(310, 283, 150, 28);
        b4.setFont(font1);
        l1.add(b4);

        b5.setBounds(95, 324, 150, 28);
        b5.setFont(font1);
        l1.add(b5);

        b6.setBounds(310, 324, 150, 28);
        b6.setFont(font1);
        l1.add(b6);

        b7.setBounds(310, 364, 150, 28);
        b7.setFont(font1);
        l1.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(806, 725);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = ((JButton) e.getSource()).getText().substring(3);
            Connection con = ConnectionProvider.getConnection();
            Statement s = con.createStatement();
            Date date = new Date();

            if (e.getSource() == b7) {
                setVisible(false);
                new Transactions(pin, accno).setVisible(true);
            } else {
                ResultSet set = s.executeQuery("select * from transaction where PIN_No='" + pin + "' ");

                double balance = 0;
                while (set.next()) {
                    if (set.getString("Mode").equals("Deposit")) {
                        balance += Double.parseDouble(set.getString("Amount"));
                    } else if (set.getString("Mode").equals("Withdrawl")) {
                        balance -= Double.parseDouble(set.getString("Amount"));
                    }

                }
                if (Double.parseDouble(amount) < balance) {
                    s.executeUpdate("insert into transaction values('" + accno + "','" + pin + "','" + date + "','Withdrawl','" + amount + "')");
                    JOptionPane.showMessageDialog(c, amount + "Rs withdrawl Successfully");
                } else {
                    JOptionPane.showMessageDialog(c, "Insufficient Balance");
                }
            }
        } catch (HeadlessException | NumberFormatException | SQLException ea) {
        }

    }

    public static void main(String[] args) {
        FastCash f = new FastCash("", "");
    }
}
