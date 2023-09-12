package com.AdminModules;

import com.Helper.ConnectionProvider;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener, MouseListener {

    public Container c;
    public JPanel panel;
    public JLabel l1, l2, l3, l4, l5, l6;
    public JButton login;
    public JTextField tf;
    public JPasswordField pf;
    String username, password, fname;
    Connection con;
    Statement stmt;
    ResultSet set;

    public AdminLogin() {
        setTitle("Admin Login - Bank Management System");
        setSize(900, 500);
        c = this.getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);
        
        //Images
        ImageIcon icon = new ImageIcon("src/Images/banklogin.png");
        ImageIcon icon1 = new ImageIcon("src/Images/bankicon.png");
       
        //Fonts
        Font font = new Font("Segoe UI",Font.BOLD,22);
        Font font1 = new Font("Segoe UI",Font.PLAIN,16);
        Font font2 = new Font("Segoe UI",Font.BOLD,16);
        
        //Cursor
        Cursor handcursor = new Cursor(Cursor.HAND_CURSOR);
        
        //Color
        Color color = new Color(0,168,204);
        
        panel = new JPanel();
        l1 = new JLabel("Bank Management System");
        l2 = new JLabel(icon);
        l3 = new JLabel("WELCOME BACK");
        l4 = new JLabel("Enter Username:");
        l5 = new JLabel("Enter Password:");
        l6 = new JLabel("Forgot Password?");
        login = new JButton("Login");
        tf = new JTextField();
        pf = new JPasswordField();

        panel.setBounds(0, 0, 362, 500);
        panel.setBackground(color);
        panel.setLayout(null);
        add(panel);
        
        l1.setBounds(50,30,300,30);
        l1.setForeground(Color.white);
        l1.setFont(font);
        panel.add(l1);
        
        l2.setBounds(110, 220, icon.getIconWidth(), icon.getIconHeight());
        panel.add(l2);
        
        l3.setBounds(529,40,200,30);
        l3.setFont(font);
        add(l3);
        
        l4.setBounds(469,100,200,25);
        l4.setFont(font1);
        add(l4);
        
        tf.setBounds(469,127,300,25);
        tf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        tf.setFont(font1);
        add(tf);
        
        l5.setBounds(469,175,200,25);
        l5.setFont(font1);
        add(l5);

        pf.setBounds(469,200,300,25);
        pf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        pf.setFont(font1);
        pf.setEchoChar('\u25cf');
        add(pf);
        
        l6.setBounds(646,243,150,25);
        l6.setFont(font1);
        l6.setCursor(handcursor);
        add(l6);
        
        login.setBounds(469,305,300,25);
        login.setBackground(color);
        login.setForeground(Color.white);
        login.setFont(font2);
        add(login);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon1.getImage());
        setResizable(false);
        setLocationRelativeTo(null);

        //Adding mouseListener
        l6.addMouseListener(this);

        //Adding ActionListener
        login.addActionListener(this);
    }

    public static void main(String[] args) {
        new AdminLogin().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tf.getText().equals("") && pf.getText().equals("")) {
            JOptionPane.showMessageDialog(c, "Enter Username and Password");
        } else if (tf.getText().equals("")) {
            JOptionPane.showMessageDialog(c, "Enter Username.");
        } else if (pf.getText().equals("")) {
            JOptionPane.showMessageDialog(c, "Enter Password.");
        } else {
            try {
                con = ConnectionProvider.getConnection();
                stmt = con.createStatement();
                String q = "select * from admin";
                set = stmt.executeQuery(q);
                while (set.next()) {
                    username = set.getString(6);
                    password = set.getString(7);
                    if (tf.getText().equals(username) || pf.getText().equals(password)) {
                        fname = set.getString(2);
                        break;
                    }
                }
                if ((tf.getText().equals(username)) && pf.getText().equals(password)) {
                    new AdminDashboard(fname).setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(c, "Incorrect Username or Password.");
                }
            } catch (HeadlessException | SQLException ae) {
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(l6)) {
            try {
                String user = JOptionPane.showInputDialog(c, "Enter Username");
                if (user.equals("")) {
                    JOptionPane.showMessageDialog(c, "Please Enter Username.");
                } else {
                    con = ConnectionProvider.getConnection();
                    String q = "select * from admin";
                    stmt = con.createStatement();
                    set = stmt.executeQuery(q);
                    while (set.next()) {
                        username = set.getString(6);
                        if (username.equals(user)) {
                            break;
                        }
                    }
                    if (username.equals(user)) {
                        new AdminPasswordChange(username).setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(c, "Invalid Username. Try Again.");
                    }
                }
            } catch (HeadlessException | SQLException eh) {
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
}
