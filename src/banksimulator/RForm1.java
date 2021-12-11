package banksimulator;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RForm1 extends JFrame implements ActionListener{
    Container c;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    JButton next;
    JRadioButton r1,r2,r3,r4,r5,r6;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    ButtonGroup gen,mstatus;
    JDateChooser datechooser;
    String formno;
    
    RForm1()
    {
        setTitle("New Application Form");
        setSize(470,568);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel("Account Opening Form");
        l2 = new JLabel("Form No :");
        l3 = new JLabel();
        l4 = new JLabel("1. Personal Details");
        l5 = new JLabel("Name :");
        l6 = new JLabel("Father's Name :");
        l7 = new JLabel("Date of Birth :");
        l8 = new JLabel("Gender :");
        l9 = new JLabel("Email Address :");
        l10 = new JLabel("marital Status :");
        l11 = new JLabel("Address :");
        l12 = new JLabel("City :");
        l13 = new JLabel("Pin Code :");
        l14 = new JLabel("State :");
        next = new JButton("Next");
        r1 = new JRadioButton("male");
        r2 = new JRadioButton("Female");
        r3 = new JRadioButton("Other");
        r4 = new JRadioButton("Single");
        r5 = new JRadioButton("Married");
        r6 = new JRadioButton("Other");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        gen = new ButtonGroup();
        mstatus = new ButtonGroup();
        datechooser = new JDateChooser();
        
        ImageIcon icon1 = new ImageIcon("src/img/bankicon.png");
        
        Font font = new Font("Segeo UI Semibold",Font.BOLD,17);
        Font font1 = new Font("Segeo UI Semibold",Font.BOLD,11);
        Font font2 = new Font("Segeo UI Semibold",Font.BOLD,13);
        Font font3 = new Font("Roboto",Font.PLAIN,13);
        
        c= this.getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);
        
        //Random form no generator.
        
        Random ran = new Random();
        long first4 =(ran.nextInt()%9000)+1000;
        formno= ""+Math.abs(first4);
        
        
        //lables Bounds 
        l1.setBounds(135,6,200,25);
        l1.setFont(font);
        l1.setForeground(new Color(0,168,204));
        c.add(l1);
        
        l2.setBounds(10,10,53,15);
        l2.setFont(font1);
        c.add(l2);
        
        l3.setBounds(66,10,40,15);
        l3.setFont(font1);
        l3.setText(formno);
        c.add(l3);
        
        l4.setBounds(163,35,150,25);
        l4.setFont(font2);
        c.add(l4);
        
        l5.setBounds(40,80,100,20);
        l5.setFont(font2);
        c.add(l5);
        
        l6.setBounds(40,120,100,20);
        l6.setFont(font2);
        c.add(l6);
        
        l7.setBounds(40,160,100,20);
        l7.setFont(font2);
        c.add(l7);
        
        l8.setBounds(40,200,100,20);
        l8.setFont(font2);
        c.add(l8);
        
        l9.setBounds(40,240,100,20);
        l9.setFont(font2);
        c.add(l9);
        
        l10.setBounds(40,280,100,20);
        l10.setFont(font2);
        c.add(l10);
        
        l11.setBounds(40,320,100,20);
        l11.setFont(font2);
        c.add(l11);
        
        l12.setBounds(40,360,100,20);
        l12.setFont(font2);
        c.add(l12);
        
        l13.setBounds(40,405,100,20);
        l13.setFont(font2);
        c.add(l13);
        
        l14.setBounds(40,445,100,20);
        l14.setFont(font2);
        c.add(l14);
        
        //textFields Bounds
        tf1.setBounds(170,80,200,21);
        c.add(tf1);
        
        tf2.setBounds(170,120,200,21);
        c.add(tf2);
        
        datechooser.setBounds(170,160,200,21);
        c.add(datechooser);
        
        tf3.setBounds(170,240,200,21);
        c.add(tf3);  
        
        tf4.setBounds(170,320,200,21);
        c.add(tf4);
        
        tf5.setBounds(170,360,200,21);
        c.add(tf5);
        
        tf6.setBounds(170,400,200,21);
        c.add(tf6);
        
        tf7.setBounds(170,440,200,21);
        c.add(tf7);
        
        //Radiobuttons Bounds
        r1.setBounds(170,200,60,20);
        r1.setBackground(Color.white);
        c.add(r1);
        
        r2.setBounds(235,200,70,20);
        r2.setBackground(Color.white);
        c.add(r2);
        
        r3.setBounds(310,200,60,20);
        r3.setBackground(Color.white);
        c.add(r3);
        
        gen.add(r1);
        gen.add(r2);
        gen.add(r3);

        r4.setBounds(170,280,60,20);
        r4.setBackground(Color.white);
        c.add(r4);
        
        r5.setBounds(235,280,70,20);
        r5.setBackground(Color.white);
        c.add(r5);
 
        r6.setBounds(310,280,70,20);
        r6.setBackground(Color.white);
        c.add(r6);
        
        mstatus.add(r4);
        mstatus.add(r5);
        mstatus.add(r6);
        
        //Button
        next.setBounds(305,480,65,20);
        next.setBackground(new Color(0,168,204));
        next.setForeground(Color.black);
        next.setFont(font3);
        c.add(next);
        
        next.addActionListener(this);
        
        setLocationRelativeTo(null);
        setIconImage(icon1.getImage());
        setVisible(true);
    }
        @Override
    public void actionPerformed(ActionEvent e) {
            String Name =tf1.getText();
            String FName = tf2.getText();
            String dob = ""+((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if(r1.isSelected())
                gender="Male";
            else if(r2.isSelected())
                gender="Female";
            else if(r3.isSelected())
                gender="Other";
            String EAddress =tf3.getText();
            String MStatus = null;
            if(r4.isSelected())
                MStatus="Single";
            else if(r5.isSelected())
                MStatus="Married";
            else if(r6.isSelected())
                MStatus="Other";
            String Address = tf4.getText();
            String City = tf5.getText();
            String PinCode = ""+ tf6.getText();
            String State =tf7.getText();
            
            
        if(tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals(""))
            JOptionPane.showMessageDialog(c, "Fill all required Fields.");
        else 
        {
            try {
                Connection con = ConnectionProvider.getConnection();
                String q = "insert into signup1 values('"+formno+"','"+Name+"','"+FName+"','"+dob+"','"+gender+"','"+EAddress+"','"+MStatus+"','"+Address+"','"+City+"','"+PinCode+"','"+State+"')";
                Statement s = con.createStatement();
                s.executeUpdate(q);
            } catch (SQLException ex) {
            }
            setVisible(false);
            new RForm2(formno).setVisible(true);
   
        } 
    }
    
    public static void main(String []args)
    {
        RForm1 form = new RForm1();  
    }
}
