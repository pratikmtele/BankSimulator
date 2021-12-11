package banksimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.*;

public class LoginForm extends JFrame implements ActionListener, MouseListener {

    Container c;
    JFrame frame = new JFrame();
    JLabel l1, l2, l3;
    JTextField tf;
    JPasswordField pf;
    JButton signup, login;
    JPanel panel;
    String accno, pinno;

    Connection con = ConnectionProvider.getConnection();
    String q = "select * from login";
    Statement s;

    LoginForm() {
        try {
            this.s = con.createStatement();
        } catch (SQLException ex) {

        }
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(568, 368);
        setResizable(false);

        ImageIcon icon = new ImageIcon("src/img/programmer.png");
        ImageIcon icon1 = new ImageIcon("src/img/bankicon.png");

        l1 = new JLabel();
        l2 = new JLabel(icon);
        l3 = new JLabel("Forgot Pin?");
        tf = new JTextField();
        pf = new JPasswordField();
        signup = new JButton("SignUp");
        login = new JButton("Login");
        panel = new JPanel();

        Font font = new Font("Arial", Font.BOLD, 17);
        Font font1 = new Font("Roboto", Font.PLAIN, 13);
        Font font2 = new Font("Tahoma", Font.BOLD, 11);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        panel.setSize(200, 330);
        panel.setBackground(new Color(0, 168, 204));
        panel.setLayout(null);
        c.add(panel);

        l1.setText("Login Form");
        l1.setBounds(270, 20, 100, 25);
        l1.setFont(font);
        l1.setForeground(new Color(0, 168, 204));
        c.add(l1);

        l2.setBounds(36, 130, icon.getIconWidth(), icon.getIconHeight());
        panel.add(l2);

        l3.setBounds(405, 170, 100, 23);
        l3.setFont(font1);
        l3.setCursor(cursor);
        c.add(l3);

        tf.setBounds(270, 80, 200, 23);
        tf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        c.add(tf);

        pf.setBounds(270, 140, 200, 23);
        pf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        c.add(pf);

        login.setBounds(284, 220, 80, 22);
        login.setBackground(new Color(0, 168, 204));
        login.setForeground(Color.black);
        login.setFont(font1);
        c.add(login);

        signup.setBounds(380, 220, 80, 22);
        signup.setBackground(new Color(0, 168, 204));
        signup.setForeground(Color.black);
        signup.setFont(font1);
        c.add(signup);

        login.addActionListener(this);
        signup.addActionListener(this);

        l3.addMouseListener(this);

        setLocationRelativeTo(null);
        setIconImage(icon1.getImage());
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            if (tf.getText().equals("") || pf.getText().equals("")) {
                JOptionPane.showMessageDialog(c, "Please enter username or passoword.");
            } else {
                try {
                    ResultSet set = s.executeQuery(q);
                    while (set.next()) {
                        accno = set.getString(1);
                        pinno = set.getString(2);
                        if ((tf.getText().equals(accno)) || pf.getText().equals(pinno)) {
                            break;
                        }
                    }
                    if ((tf.getText().equals(accno)) && pf.getText().equals(pinno)) {
                        JOptionPane.showMessageDialog(c, "Login Successfully.");
                        setVisible(false);
                        new Transactions(pinno, accno).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(c, "Incorrect Username or Password.");
                    }
                } catch (SQLException ae) {
                }
            }
        } else if (e.getSource() == signup) {
            setVisible(false);
            new RForm1().setVisible(true);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       
        String eaccno = JOptionPane.showInputDialog(c, "Enter Account Number :");
         if(eaccno.equals(""))
         {
             JOptionPane.showMessageDialog(c, "Please Enter Account Number.");
         }else
         {
              ResultSet set;
        try {
            set = s.executeQuery("select * from login where Account_Number='"+eaccno+"'");
             while(set.next())
             {
                accno = set.getString(1);
                setVisible(false);
                new ChangePin(pinno,accno).setVisible(true);
             }
             if(!eaccno.equals(accno))
             JOptionPane.showMessageDialog(c, "We didn't find an account with that account number. Please try again.");

        } catch (SQLException ex) {
        }
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
    public static void main(String []args)
    {
       new LoginForm().setVisible(true);
    }
}
