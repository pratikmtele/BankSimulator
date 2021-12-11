package banksimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    Container c;
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7,b8;
    String pin, accno;

    Transactions(String pin, String accno) {
        this.accno = accno;
        this.pin = pin;
        ImageIcon icon = new ImageIcon("src/img/atm.jpg");
        l1 = new JLabel(icon);
        l2 = new JLabel("Please Select Your Transaction");
        b1 = new JButton("DEPOSITE");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");
        b8 = new JButton("LOGOUT");
        c = this.getContentPane();
        c.setLayout(null);
        
        ImageIcon icon1 = new ImageIcon("src/img/bankicon.png");

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
        
        b8.setBounds(95,364,150,28);
        b8.setFont(font1);
        l1.add(b8);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        setSize(806, 725);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            setVisible(false);
            new Deposit(pin, accno).setVisible(true);
        } else if (e.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin, accno).setVisible(true);
        } else if (e.getSource() == b3) {
            setVisible(false);
            new FastCash(pin, accno).setVisible(true);
        } else if (e.getSource() == b4) {
            setVisible(false);
            new MiniStatement(pin,accno).setVisible(true);
        } else if (e.getSource() == b5) {
            setVisible(false);
            new ChangePin(pin,accno).setVisible(true);

        } else if (e.getSource() == b6) {
            setVisible(false);
            new BalanceEnquiry(pin,accno).setVisible(true);
        } else if (e.getSource() == b7) {
            System.exit(0);
        }else if(e.getSource() == b8){
             setVisible(false);
             new LoginForm().setVisible(true);
        }
    }

    public static void main(String[] args) {
        Transactions t = new Transactions("", "");

    }
}
