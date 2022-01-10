import java.awt.*;
import javax.swing.*;
///import java.awt.geom.Line2D;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class TransportationUi implements ActionListener {
     JLabel label2 = new JLabel();
     JLabel label3,label4,label5,label6,label7,label8;
     JButton b1,b2,b3,b4,b5,b6;
     Icon i1 = new ImageIcon("C:/Users/User/Desktop/Finalproject/City.png");
     JFrame frame=new JFrame();
     JFrame frame2 = new JFrame();
     JButton Back = new JButton("Back");
     JButton patao = new JButton("");
     JLabel pataoPanel = new JLabel("Pathao");
     Color cl = new Color(51,0,102);
     Color c = new Color(76,241,242);
     //for frame to
     JLabel back = new JLabel();
     JLabel[] Names = new JLabel[100];
    JLabel[] Phones = new JLabel[100];
    JLabel[] bad = new JLabel[100];
    JButton[] buttons = new JButton[100];
    JPanel namePanel = new JPanel();
    JPanel phonePanel = new JPanel();
    JPanel badPanel = new JPanel();
    JPanel butPanel = new JPanel();
    JButton submit = new JButton("Submit");
    JLabel name,phone,location;
    Connection con;
    JButton BACK = new JButton("Back");
  //-------------------------------
    TransportationUi()
    {
        //for frame 2
        BACK.setBounds(1300-20,915,100,40);
        BACK.addActionListener(this);
        BACK.setFocusable(false);
        BACK.setFont(new Font("DialogInput",Font.BOLD,20));
    
        GridLayout layout = new GridLayout(20,1);
        layout.setHgap(5);
        layout.setVgap(5);
        name = new JLabel("Name of Transports");
        name.setVisible(true);
        name.setOpaque(false);
        name.setBounds(0,10,460,50);        
        name.setFont(new Font("DialogInput",Font.BOLD,25));
        namePanel.setBounds(0,80,460,830);
        namePanel.setVisible(true);
        namePanel.setBackground(Color.black);
        namePanel.setLayout(layout);

        phone = new JLabel("Phone Numbers");
        phone.setVisible(true);
        phone.setOpaque(false);
        phone.setBounds(460+ 10,10,460-10,50);        
        phone.setFont(new Font("DialogInput",Font.BOLD,25));
        phonePanel.setBounds(460 + 10,80,460-10,830);
        phonePanel.setVisible(true);
        phonePanel.setBackground(Color.black);
        phonePanel.setLayout(layout);

        location = new JLabel("Press to Book ticket");
        location.setVisible(true);
        location.setOpaque(false);
        location.setBounds(2*460+ 10,10,460,50);        
        location.setFont(new Font("DialogInput",Font.BOLD,25));

        butPanel.setBounds(2* 460 + 10,80,460,830);
        butPanel.setVisible(true);
        butPanel.setBackground(Color.black);
        butPanel.setLayout(layout);
    
        ImageIcon image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/City6.jpg");
        back.setBounds(0,0,1400,1000);
        back.setVisible(true);
        frame2.setSize(1400,1000);
        back.setIcon(image);
        for(int i = 0;i<20;i++)
        {
           // System.out.println(BuildName.get(i));
            Names[i] = new JLabel();
            Names[i].setFont(new Font("DialogInput",Font.BOLD,20));
            Names[i].setOpaque(true);
            Names[i].setBackground(Color.white);
            Names[i].setForeground(Color.black);
            //Names[i].setText(BuildName.get(i));
            namePanel.add(Names[i]);
        }
        for(int i = 0;i<20;i++)
        {
           // System.out.println(BuildName.get(i));
            Phones[i] = new JLabel();
            Phones[i].setFont(new Font("DialogInput",Font.BOLD,20));
            Phones[i].setOpaque(true);
            Phones[i].setBackground(Color.white);
            Phones[i].setForeground(Color.black);
            //Names[i].setText(BuildName.get(i));
            phonePanel.add(Phones[i]);
        }
        for(int i = 0;i<20;i++)
        {
            buttons[i] = new JButton("Link");
            buttons[i].setSize(100,50);
            buttons[i].setBackground(Color.white);
            buttons[i].setVisible(false);
            buttons[i].setFont(new Font("DialogInput",Font.BOLD,25));
        //    buttons[i].setOpaque(false);
            buttons[i].addActionListener(this);
            // buttons[i].setContentAreaFilled(false);
            // buttons[i].setBorderPainted(false);
            butPanel.add(buttons[i]);
        }
        back.add(BACK);
        back.add(submit);
        back.add(location);
        back.add(phone);
        back.add(name);
        back.add(phonePanel);
        back.add(butPanel);
        back.add(namePanel);
        frame2.add(back);
        frame2.setLayout(null);
       // -----------------------
     frame2.setSize(1400,1000);
     image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/patao.png");
     patao.setBounds(500 +700,400-30-20-15,80,60);
     patao.addActionListener(this);
     patao.setFocusable(false);
     patao.setIcon(image);
     patao.setFont(new Font("DialogInput",Font.BOLD,15));
     patao.setBackground(cl);
     pataoPanel.setBounds(1200,400+60+15-30-30-10,100,60);
     pataoPanel.setForeground(c);
     pataoPanel.setFont(new Font("DialogInput",Font.BOLD,26));
     pataoPanel.setOpaque(false);


    JLabel label8 = new JLabel("MAKE YOUR WAY !!!");
    label8.setBounds(300,50,600,80);
    label8.setForeground(Color.BLACK);
    label8.setFont(new Font("DialogInput",Font.BOLD,50));
    label8.setOpaque(false);

   // JLabel label9 = new JLabel("E-Ticket...");
    // label9.setBounds(100,250-30-10,300,100);
    // label9.setForeground(Color.BLACK);
    // label9.setFont(new Font("DialogInput",Font.BOLD,30));
    // label9.setOpaque(false);

     image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/train.png");

    b1 = new JButton("");
    b1.setBackground(cl);
    b1.setFont(new Font("DialogInput",Font.BOLD,15));
    b1.setForeground(java.awt.Color.GREEN);
    b1.setBounds(100,400-30-20-15,80,60);
    b1.setFocusable(false);
    b1.addActionListener(this);
    b1.setIcon(image);
    JLabel label3 = new JLabel("Train");
    label3.setBounds(100,400+60+15-30-30-10,80,60);
    label3.setForeground(c);
    label3.setFont(new Font("DialogInput",Font.BOLD,26));
    label3.setOpaque(false);

    image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/bus.png");
    b2 = new JButton("");
    b2.setBackground(cl);
    b2.setIcon(image);
    b2.setFont(new Font("DialogInput",Font.BOLD,15));
    b2.setForeground(java.awt.Color.GREEN);
    b2.setBounds(450,400-30-20-15,80,60);
    b2.setFocusable(false);
    b2.addActionListener(this);
    JLabel label4 = new JLabel("Bus");
    label4.setBounds(450,400+60+15-30-30-10,110,60);
    label4.setForeground(c);
    label4.setFont(new Font("DialogInput",Font.BOLD,26));
    label4.setOpaque(false);

    image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/uber.png");
    b3 = new JButton("");
    b3.setBackground(cl);
    b3.setIcon(image);
    b3.setFont(new Font("DialogInput",Font.BOLD,20));
    b3.setForeground(java.awt.Color.GREEN);
    b3.setBounds(800,400-30-20-15,80,60);
    b3.setFocusable(false);
    b3.addActionListener(this);
    JLabel label5 = new JLabel("Uber");
    label5.setBounds(800,400+60+15-30-30-10,200,60);
    label5.setForeground(c);
    label5.setFont(new Font("DialogInput",Font.BOLD,26));
    label5.setOpaque(false);
   
    Back.setBounds(1000,900,100,40);
    Back.addActionListener(this);
    Back.setFocusable(false);
    Back.setFont(new Font("DialogInput",Font.BOLD,20));

    label2.setIcon(i1);
    label2.setBounds(0,0,1400,1000);
    label2.setOpaque(true);
    label2.add(pataoPanel);
    label2.add(patao);
    label2.add(b1);
    label2.add(b2);
    label2.add(b3);
    label2.add(Back);
    //label2.add(b4);
   // label2.add(b5);
   // label2.add(b6);
    label2.add(label3);
    label2.add(label4);
    label2.add(label4);
    label2.add(label5);
   // label2.add(label6);
   // label2.add(label7);
    //label2.add(label8);
    label2.add(label8);
  //  label2.add(label9);


    

    
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1400,1000);   
    frame.setVisible(true);
    frame.add(label2);
    
}

Vector<String> Name = new Vector<String>();
Vector< String > Phone = new Vector<String>();
Vector< String > link = new Vector<String>();
public void getItem(String transport)throws SQLException
{
    con = Mycnx.getConnection();
    Statement stmn = con.createStatement();
    String query = "select * from transport";
    //  con = Mycnx.getConnection();
    //PreparedStatement stmn = con.prepareStatement(query);
    ResultSet rs = stmn.executeQuery(query);
    while (rs.next()) 
    {
        
        String trans = rs.getString("transName");
        String name = rs.getString("name");
        String phone = rs.getString("phone");
        String loca = rs.getString("link");
        if(transport.equals(trans))
        {
            Name.add(name);
            Phone.add(phone);
            link.add(loca);
            System.out.println(trans);
        }
    }
}
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == b1) // train
        {
            Name.clear();;
            Phone.clear();;
            link.clear();
            String transport = "Train";
            frame.setVisible(false);
            frame2.setVisible(true);
            try {
                getItem(transport);
            } catch (Exception es) {
                //TODO: handle exception
            }
            for(int i = 0;i<Name.size();i++)
            {
                Names[i].setText(Name.get(i));
                Phones[i].setText(Phone.get(i));
                buttons[i].setVisible(true);
            }
        }     
        if(e.getSource() == b2)
        {
            Name.clear();;
            Phone.clear();;
            link.clear();
            String transport = "Bus";
            frame.setVisible(false);
            frame2.setVisible(true);
            try {
                getItem(transport);
            } catch (Exception es) {
                //TODO: handle exception
            }
            for(int i = 0;i<Name.size();i++)
            {
                Names[i].setText(Name.get(i));
                Phones[i].setText(Phone.get(i));
                buttons[i].setVisible(true);
            }
        }  
        if(e.getSource() == b3)
        {
            try
            {
                String filename ="https://www.uber.com/bd/en/";
             //   System.out.println(link.get(i));
                Desktop d =   Desktop.getDesktop();
                d.browse(new URI(filename));
            } 
            catch (Exception es)
            {
                //TODO: handle exception
            }
        }
        for(int i = 0;i<Name.size();i++)
        {          
            if(e.getSource() == buttons[i])
            {
                try {
                String filename =link.get(i);
                System.out.println(link.get(i));
                Desktop d =   Desktop.getDesktop();
                d.browse(new URI(filename));
            } catch (Exception es) {
                //TODO: handle exception
            }
            }
        }
        if(e.getSource() == patao)
        {
            try
            {
                String filename ="https://pathao.com/bn/";
             //   System.out.println(link.get(i));
                Desktop d =   Desktop.getDesktop();
                d.browse(new URI(filename));
            } 
            catch (Exception es)
            {
                //TODO: handle exception
            }
        }
        if(e.getSource() == Back)
        {
           // frame.setVisible(false);
            Ui frme = new Ui();
        }
        if(e.getSource() == BACK)
        {
            frame.setVisible(true);
          //  frame2.setVisible(false);
        }
    }

   
}