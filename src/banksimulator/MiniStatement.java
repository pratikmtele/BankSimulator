package banksimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MiniStatement extends JFrame implements ActionListener {

    Container c;
    JLabel l1, l2, l3, l4, l5;
    JButton b1;
    String pin, accno;
    JTable table;
    JPanel panel;
    JScrollPane spane;
    double balance = 0;
    String mode, date, amount, bal,ifscno;
    String[] data;
    String[] columnNames;
    static DefaultTableModel model;

    MiniStatement(String pin, String accno) {
        this.accno = accno;
        this.pin = pin;
        columnNames = new String[]{"Date", "Dr/Cr", "Amount", "Balance"};

        setSize(500, 570);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        setUndecorated(true);

        b1 = new JButton("BACK");
        l1 = new JLabel("MINI-STATEMENT");
        l2 = new JLabel("Account Number :");
        l3 = new JLabel(accno);
        l4 = new JLabel("IFSC Number :");
        l5 = new JLabel();
        panel = new JPanel();
        table = new JTable() {
            @Override
            public boolean isCellEditable(int data, int column) {
                return false;
            }
        };
        model = new DefaultTableModel();
        spane = new JScrollPane(table);

        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.setBackground(Color.white);

        Font font = new Font("Segeo UI Semibold", Font.BOLD, 14);
        Font font1 = new Font("System", Font.PLAIN, 12);
        Font font2 = new Font("Times New Roman", Font.BOLD, 13);
        Font font3 = new Font("System", Font.BOLD, 12);

        l1.setBounds(170, 10, 140, 20);
        l1.setFont(font);
        c.add(l1);

        l2.setBounds(18, 40, 140, 20);
        l2.setFont(font3);
        c.add(l2);

        l3.setBounds(125, 40, 140, 20);
        l3.setFont(font1);
        c.add(l3);

        l4.setBounds(270, 40, 100, 20);
        l4.setFont(font3);
        c.add(l4);

        l5.setBounds(355, 40, 200, 20);
        l5.setFont(font1);
        c.add(l5);

        panel.setBounds(10, 80, 468, 440);
        panel.setBackground(Color.white);
        c.add(panel);
        panel.add(spane);

        b1.setBounds(190, 525, 100, 20);
        b1.setBackground(new Color(0, 168, 204));
        b1.setForeground(Color.black);
        b1.setFont(font2);
        c.add(b1);

        b1.addActionListener(this);

        try {
            Connection con = ConnectionProvider.getConnection();
            Statement s = con.createStatement();
            ResultSet set = s.executeQuery("select * from transaction where PIN_No= '" + pin + "' ");
            while (set.next()) {
                if (set.getString("Mode").equals("Deposit")) {
                    balance += Double.parseDouble(set.getString("Amount"));
                } else if (set.getString("Mode").equals("Withdrawl")) {
                    balance -= Double.parseDouble(set.getString("Amount"));
                }
                bal = "" + balance;
                model.insertRow(model.getRowCount(), new String[]{
                    set.getString("Date"),
                    set.getString("Mode"),
                    set.getString("Amount"),
                    bal
                });
            }
            ResultSet set1 = s.executeQuery("select * from login where Pin='" + pin + "' ");
            while (set1.next()) {
                ifscno = set1.getString("IFSC_No");
            }
            l5.setText(ifscno);
        } catch (SQLException ex) {

        }
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pin, accno).setVisible(true);
    }

    public static void main(String[] args) {
        MiniStatement m = new MiniStatement("", "");
    }
}
