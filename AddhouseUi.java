import java.awt.*;
import javax.swing.*;
///import java.awt.geom.Line2D;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddhouseUi implements ActionListener {
     JLabel label2 = new JLabel();
     JLabel label3,label4,label5,label6,label7,label8;
     JTextField tex1,tex2,tex3,tex4;
     JButton b1,b2,b3,b4,b5,b6;
     Icon i1 = new ImageIcon("C:/Users/User/Desktop/Finalproject/Cityaddbuilding.jpg");
     JFrame frame=new JFrame();
     
     JButton submit = new JButton("Submit");
     JButton Back= new JButton("Back");
    AddhouseUi(){
   
    JLabel label8 = new JLabel("ADD YOUR LOCATION!!!");
    label8.setBounds(400,50,600,80);
    label8.setForeground(Color.WHITE);
    label8.setFont(new Font("DialogInput",Font.BOLD,50));
    label8.setOpaque(false);

    JLabel label9 = new JLabel("Area Name: ");
    label9.setBounds(150,250,150,100);
    label9.setForeground(Color.WHITE);
    label9.setFont(new Font("DialogInput",Font.BOLD,20));
    label9.setOpaque(false);
    ////JTextField tex1 = new JTextField();
    tex1 = new JTextField();
    tex1.setBounds(500,270,300,50);
    tex1.setForeground(Color.WHITE);
    tex1.setBackground(Color.BLACK);
    tex1.setFont(new Font("Arial",Font.BOLD,15));

    JLabel label3 = new JLabel("Building name & Road no: ");
    label3.setBounds(150,400-50-15,300,100);
    label3.setForeground(Color.WHITE);
    label3.setFont(new Font("DialogInput",Font.BOLD,20));
    label3.setOpaque(false);
    tex2 = new JTextField();
    tex2.setBounds(500,400-50,300,50);
    tex2.setForeground(Color.WHITE);
    tex2.setBackground(Color.BLACK);
    tex2.setFont(new Font("Arial",Font.BOLD,15));


    JLabel label5 = new JLabel("Phone: ");
    label5.setBounds(150,400,100,100);
    label5.setForeground(Color.WHITE);
    label5.setFont(new Font("DialogInput",Font.BOLD,20));
    label5.setOpaque(false);
    tex3 = new JTextField();
    tex3.setBounds(500,430,300,50);
    tex3.setForeground(Color.WHITE);
    tex3.setBackground(Color.BLACK);
    tex3.setFont(new Font("Arial",Font.BOLD,15));


    JLabel label6 = new JLabel("Location Link: ");
    label6.setBounds(150,400+65,200,100);
    label6.setForeground(Color.WHITE);
    label6.setFont(new Font("DialogInput",Font.BOLD,20));
    label6.setOpaque(false);
    tex4 = new JTextField();
    tex4.setBounds(500,500,300,50);
    tex4.setForeground(Color.WHITE);
    tex4.setBackground(Color.BLACK);
    tex4.setFont(new Font("Arial",Font.BOLD,15));



    submit.setBounds(700-20,600,120,40);
    submit.addActionListener(this);
    submit.setFont(new Font("DialogInput",Font.BOLD,20));
    submit.setFocusable(false);

    Back.setBounds(550,600,100,40);
    Back.addActionListener(this);
    Back.setFocusable(false);
    Back.setFont(new Font("DialogInput",Font.BOLD,15));


    label2.setIcon(i1);
    label2.setBounds(0,0,1400,1000);
    label2.setOpaque(true);
     label2.add(Back);
    label2.add(submit);
    label2.add(label3);
    label2.add(label5);
    label2.add(label6);
    label2.add(tex1);
    label2.add(tex2);
    label2.add(tex3);
    label2.add(tex4);
    label2.add(label8);
    label2.add(label9);
    

    

    
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1400,1000);   
    frame.setVisible(true);
    frame.add(label2);
    
}
    public void insert(String area,String name,String Phone,String loc)throws SQLException
    {
        Connection con = Mycnx.getConnection();
        Statement stmn = con.createStatement();
        String query = "select * from building";
        //PreparedStatement stmn = con.prepareStatement(query);
        ResultSet rs = stmn.executeQuery(query);

        String insrt = "INSERT INTO `building`(`area`,`name`,`phone`,`location`) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = (PreparedStatement)Mycnx.getConnection().prepareStatement(insrt);
            pst.setString(1, area);
            pst.setString(2, name);
            pst.setString(3, Phone);
            pst.setString(4, loc);
            pst.execute();
        }
         catch (SQLException es) 
        {
           System.out.println("Not connected");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submit)
        {
            String area = tex1.getText();
            String name = tex2.getText();
            String Phone = tex3.getText();
            String loc  = tex4.getText();
           // System.out.println(area + " " + name + " " + Phone + " " + loc);
           try 
           {
            insert(area, name, Phone, loc);
           } 
         catch (SQLException e1)
          {
            // TODO Auto-generated catch block
            e1.printStackTrace();
           }
        }   
        if(e.getSource() == Back)
        {
            RentUi fra = new RentUi();
            frame.setVisible(false);
        }    
    }

   
}