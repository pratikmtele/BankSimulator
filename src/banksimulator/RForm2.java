package banksimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class RForm2 extends JFrame implements ActionListener{
    String formno;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton next;
    JComboBox cbox1,cbox2,cbox3,cbox4,cbox5;
    JTextField tf1,tf2;
    JRadioButton r1,r2,r3,r4;
    Container c;
    ButtonGroup gbutton1,gbutton2;
    RForm2(String formno)
    {
        this.formno=formno;
        
        String religion[]={"Hindu","Muslim","Chritian","Other"};
        String Category[]={"OBC","ST","NT","SC","Other"};
        String Income[]={"Null","<100000","<500000",">1000000"};
        String EQualification[]={"Non-Graduated","Graduated","Post-Graduated"};
        String Occupation[]={"Self-Employer","Selarized","Student","Business","Other"};
        
        setTitle("New Application Form");
        setSize(470,568);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1= new JLabel("2. Additional Details");
        l2= new JLabel("Form No :");
        l3= new JLabel(formno);
        l4= new JLabel("Religion :");
        l5= new JLabel("Category :");
        l6= new JLabel("Income :");
        l7= new JLabel("Educational");
        l8= new JLabel("Qualification :");
        l9= new JLabel("Occupation :");
        l10= new JLabel("PAN Number :");
        l11= new JLabel("Aadhar Number :");
        l12= new JLabel("Senior Citizen :");
        l13= new JLabel("Existing Account :");
        next = new JButton("Next");
        cbox1 = new JComboBox(religion);
        cbox2 = new JComboBox(Category);
        cbox3 = new JComboBox(Income);
        cbox4 = new JComboBox(EQualification);
        cbox5 = new JComboBox(Occupation);
        tf1 = new JTextField();
        tf2 = new JTextField();
        r1 = new JRadioButton("Yes");
        r2 = new JRadioButton("No");
        r3 = new JRadioButton("Yes");
        r4 = new JRadioButton("No");
        gbutton1 = new ButtonGroup();
        gbutton2 = new ButtonGroup();
        
        ImageIcon icon1 = new ImageIcon("src/img/bankicon.png");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
        
        Font font = new Font("Segeo UI Semibold",Font.BOLD,17);
        Font font1 = new Font("Segeo UI Semibold",Font.BOLD,11);
        Font font2 = new Font("Segeo UI Semibold",Font.BOLD,13);
        Font font3 = new Font("Roboto",Font.PLAIN,13);
        
        //Lbels Bounds
        l1.setBounds(150,6,200,17);
        l1.setFont(font);
        c.add(l1);
        
        l2.setBounds(10,10,53,15);
        l2.setFont(font1);
        c.add(l2);
        
        l3.setBounds(66,10,40,15);
        l3.setFont(font1);
        c.add(l3);
        
        l4.setBounds(40,80,100,20);
        l4.setFont(font2);
        c.add(l4);
        l5.setBounds(40,120,100,20);
        l5.setFont(font2);
        c.add(l5);
        
        l6.setBounds(40,160,100,20);
        l6.setFont(font2);
        c.add(l6);
        
        l7.setBounds(40,203,100,20);
        l7.setFont(font2);
        c.add(l7);
        
        l8.setBounds(40,217,100,20);
        l8.setFont(font2);
        c.add(l8);
        
        l9.setBounds(40,262,100,20);
        l9.setFont(font2);
        c.add(l9);
        
        l10.setBounds(40,307,110,20);
        l10.setFont(font2);
        c.add(l10);
        
        l11.setBounds(40,352,110,20);
        l11.setFont(font2);
        c.add(l11);
        
        l12.setBounds(40,395,115,20);
        l12.setFont(font2);
        c.add(l12);
        
        l13.setBounds(40,438,115,20);
        l13.setFont(font2);
        c.add(l13);
        
        //ComboBox Bounds
        cbox1.setBounds(170,80,200,21);
        c.add(cbox1);  
        
        cbox2.setBounds(170,120,200,21);
        c.add(cbox2);
        
        cbox3.setBounds(170,170,200,21);
        c.add(cbox3);
        
        cbox4.setBounds(170,215,200,21);
        c.add(cbox4);
        
        cbox5.setBounds(170,259,200,21);
        c.add(cbox5);
        
        //TextFields Bounds
        tf1.setBounds(170,308,200,21);
        tf1.setBackground(Color.white);
        c.add(tf1);
        
        tf2.setBounds(170,354,200,20);
        tf2.setBackground(Color.white);
        c.add(tf2);
        
        r1.setBounds(170,395,60,20);
        r1.setBackground(Color.white);
        c.add(r1);
        
        r2.setBounds(250,395,60,20);
        r2.setBackground(Color.white);
        c.add(r2);
        
        gbutton1.add(r1);
        gbutton1.add(r2);
        
        r3.setBounds(170,440,60,20);
        r3.setBackground(Color.white);
        c.add(r3);
        
        r4.setBounds(250,440,60,20);
        r4.setBackground(Color.white);
        c.add(r4);
        
        gbutton2.add(r3);
        gbutton2.add(r4);
        
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
    public void actionPerformed(ActionEvent ae) {
          String religion =""+ cbox1.getItemAt(cbox1.getSelectedIndex());
          String category =""+ cbox2.getItemAt(cbox2.getSelectedIndex());
          String income =""+ cbox3.getItemAt(cbox3.getSelectedIndex());
          String EQualification =""+ cbox4.getItemAt(cbox4.getSelectedIndex());
          String occupation =""+ cbox5.getItemAt(cbox5.getSelectedIndex());
          String Panno =tf1.getText();
          String aadharno = tf2.getText();
          String Scitizen=null;
          if(r1.isSelected())
              Scitizen = "Yes";
          else if(r2.isSelected())
              Scitizen = "No";
          String Eaccount=null;
          if(r3.isSelected())
              Eaccount = "Yes";
          else if(r4.isSelected())
              Eaccount = "No";
          
        if(tf1.getText().equals("")|| tf2.getText().equals(""))
            JOptionPane.showMessageDialog(c, "Fill All Required Fields");
        else
        {
            try
            {
                Connection con = ConnectionProvider.getConnection();
                String q = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+EQualification+"','"+occupation+"','"+Panno+"','"+aadharno+"','"+Scitizen+"','"+Eaccount+"')";
                Statement s = con.createStatement();
                s.executeUpdate(q);
            }catch(SQLException e)
            {
            }
            setVisible(false);
            new RForm3(formno).setVisible(true);
        }
       
    }
    public static void main(String []args)
    {
        RForm2 form = new RForm2("");
    }

   
}
