package banksimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class RForm3 extends JFrame implements ActionListener {

    String formno, pinno, accno;
    Container c;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JRadioButton r1, r2, r3, r4;
    JButton submit, cancel;
    JCheckBox cbox1, cbox2, cbox3, cbox4, cbox5, cbox6, cbox7;
    ButtonGroup gbutton1;
    String ifscno;

    RForm3(String formno) {
        this.formno = formno;
        setTitle("New Application Form");
        setSize(490, 568);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);

        l1 = new JLabel("3. Account Details");
        l2 = new JLabel("Form No :");
        l3 = new JLabel(formno);
        l4 = new JLabel("Type of Account :");
        l5 = new JLabel("Card Number :");
        l6 = new JLabel("(your 16-digit card number)");
        l7 = new JLabel("XXXX-XXXX-XXXX-1234");
        l8 = new JLabel("It would be appear in ATM Card and Cheque Book");
        l9 = new JLabel("PIN Number :");
        l10 = new JLabel("(4-digit password)");
        l11 = new JLabel("XXXX");
        l12 = new JLabel("Services Required :");
        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        cbox1 = new JCheckBox("ATM CARD");
        cbox2 = new JCheckBox("Internet Banking");
        cbox3 = new JCheckBox("Mobile Banking");
        cbox4 = new JCheckBox("E-Statement");
        cbox5 = new JCheckBox("Check Book");
        cbox6 = new JCheckBox("Email Alert");
        cbox7 = new JCheckBox("I hereby declares that above entered details correct to the best of my knowlegde");
        gbutton1 = new ButtonGroup();

        ImageIcon icon1 = new ImageIcon("src/img/bankicon.png");

        Font font = new Font("Segeo UI Semibold", Font.BOLD, 17);
        Font font1 = new Font("Segeo UI Semibold", Font.BOLD, 11);
        Font font2 = new Font("Segeo UI Semibold", Font.BOLD, 14);
        Font font3 = new Font("Roboto", Font.PLAIN, 13);
        Font font4 = new Font("Segeo UI Semibold", Font.PLAIN, 11);

        //atm pin, account number and IFSC Number generator.
        Random ran = new Random();
        long first4 = (ran.nextInt() % 9000) + 1000;
        pinno = "" + Math.abs(first4);

        long ranno = (ran.nextLong() % 90000000L) + 2236005000000000L;
        accno = "" + Math.abs(ranno);

        //IFSC Number Generator.
        long no = (ran.nextLong() % 9000000L) + 10000000L;
        String ifc = "" + Math.abs(no);
        ifscno = "UCBA".concat(ifc);

        l1.setBounds(170, 6, 200, 17);
        l1.setFont(font);
        c.add(l1);

        l2.setBounds(20, 10, 53, 15);
        l2.setFont(font1);
        c.add(l2);

        l3.setBounds(76, 10, 40, 15);
        l3.setFont(font1);
        c.add(l3);

        l4.setBounds(30, 55, 120, 20);
        l4.setFont(font2);
        c.add(l4);

        l5.setBounds(30, 160, 120, 20);
        l5.setFont(font2);
        c.add(l5);

        l6.setBounds(30, 178, 150, 20);
        l6.setFont(font4);
        c.add(l6);

        l7.setBounds(195, 160, 165, 20);
        l7.setFont(font2);
        c.add(l7);

        l8.setBounds(195, 178, 310, 20);
        l8.setFont(font4);
        c.add(l8);

        l9.setBounds(30, 220, 100, 20);
        l9.setFont(font2);
        c.add(l9);

        l10.setBounds(30, 238, 100, 20);
        l10.setFont(font4);
        c.add(l10);

        l11.setBounds(195, 220, 100, 20);
        l11.setFont(font2);
        c.add(l11);

        l12.setBounds(30, 280, 145, 20);
        l12.setFont(font2);
        c.add(l12);

        r1.setBounds(57, 85, 135, 20);
        r1.setBackground(Color.white);
        c.add(r1);

        r2.setBounds(200, 85, 160, 20);
        r2.setBackground(Color.white);
        c.add(r2);

        r3.setBounds(57, 119, 125, 20);
        r3.setBackground(Color.white);
        c.add(r3);

        r4.setBounds(200, 119, 185, 20);
        r4.setBackground(Color.white);
        c.add(r4);

        gbutton1.add(r1);
        gbutton1.add(r2);
        gbutton1.add(r3);
        gbutton1.add(r4);

        cbox1.setBounds(57, 320, 130, 20);
        cbox1.setBackground(Color.white);
        c.add(cbox1);

        cbox2.setBounds(200, 320, 130, 20);
        cbox2.setBackground(Color.white);
        c.add(cbox2);

        cbox3.setBounds(57, 357, 130, 20);
        cbox3.setBackground(Color.white);
        c.add(cbox3);

        cbox4.setBounds(200, 357, 130, 20);
        cbox4.setBackground(Color.white);
        c.add(cbox4);

        cbox5.setBounds(57, 394, 130, 20);
        cbox5.setBackground(Color.white);
        c.add(cbox5);

        cbox6.setBounds(200, 394, 130, 20);
        cbox6.setBackground(Color.white);
        c.add(cbox6);

        cbox7.setBounds(30, 440, 450, 20);
        cbox7.setBackground(Color.white);
        cbox7.setFont(font4);
        c.add(cbox7);

        submit.setBounds(120, 480, 75, 20);
        submit.setBackground(new Color(0, 168, 204));
        submit.setForeground(Color.black);
        submit.setFont(font3);
        c.add(submit);

        cancel.setBounds(250, 480, 75, 20);
        cancel.setBackground(new Color(0, 168, 204));
        cancel.setForeground(Color.black);
        cancel.setFont(font3);
        c.add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);

        setLocationRelativeTo(null);
        setIconImage(icon1.getImage());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String taccount = null;
        if (r1.isSelected()) {
            taccount = "Saving Account";
        } else if (r2.isSelected()) {
            taccount = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            taccount = "Current Account";
        } else if (r4.isSelected()) {
            taccount = "Recurring Deposit Account";
        }

        String services = "";
        if (cbox1.isSelected()) {
            services += "ATM CARD";
        }
        if (cbox2.isSelected()) {
            services += ",Internet Banking";
        }
        if (cbox3.isSelected()) {
            services += ",Mobile Banking";
        }
        if (cbox4.isSelected()) {
            services += ",E-Statement";
        }
        if (cbox5.isSelected()) {
            services += ",Check Book";
        }
        if (cbox6.isSelected()) {
            services += ",Email Alert";
        }
        if (e.getSource() == submit) {
            if (cbox7.isSelected()) {
                try {

                    Connection con;
                    con = ConnectionProvider.getConnection();
                    {
                        String q = "insert into signup3 values('" + formno + "','" + taccount + "','" + accno + "','" + pinno + "','" + ifscno + "','" + services + "')";
                        String p = "insert into login values('" + accno + "','" + pinno + "','" + ifscno + "')";
                        Statement s = con.createStatement();
                        s.executeUpdate(q);
                        s.executeUpdate(p);
                    }
                } catch (SQLException ae) {
                }
                JOptionPane.showMessageDialog(c, "Account No :" + accno + "\nPIN No" + pinno);
                setVisible(false);
                new LoginForm().setVisible(true);
            }else
                JOptionPane.showMessageDialog(c,"Please select declaration Checkbox.");

        } else if (e.getSource() == cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        RForm3 form = new RForm3("");
    }
}
