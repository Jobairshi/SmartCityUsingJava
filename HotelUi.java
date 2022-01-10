import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.Desktop;
import java.net.URI;

import javax.print.DocFlavor.STRING;
import javax.swing.*;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;
import java.sql.*;
public class HotelUi extends JFrame implements ActionListener {
    JComboBox Areas;
    JLabel back = new JLabel();
    JLabel slect = new JLabel("Select Your Area :");
    JLabel[] names = new JLabel[100];
    JLabel[] phones = new JLabel[100];
    JLabel[] prices = new JLabel[100];
    JButton[] buttons = new JButton[100];
    JPanel namePanel = new JPanel();
    JPanel phonePanel = new JPanel();
    JPanel pricePanel = new JPanel();
    JPanel butPanel = new JPanel();
    JButton submit = new JButton("Submit");
    Connection con;
    JLabel name,phone,price,location;
    JButton Back = new JButton("Back");
    HotelUi()
    {
        GridLayout layout = new GridLayout(20,1);
        layout.setHgap(5);
        layout.setVgap(5);

        name = new JLabel("Name of Hotels");
        name.setVisible(true);
        name.setOpaque(false);
        name.setBounds(0,200,350,50);        
        name.setFont(new Font("DialogInput",Font.BOLD,25));
        namePanel.setBounds(0,250,340,830);
        namePanel.setVisible(true);
        namePanel.setBackground(Color.black);
        namePanel.setLayout(layout);

        phone = new JLabel("Phone No of Hotels");
        phone.setVisible(true);
        phone.setOpaque(false);
        phone.setBounds(350,200,350,50);        
        phone.setFont(new Font("DialogInput",Font.BOLD,25));
        phonePanel.setBounds(350,250,310,830);
        phonePanel.setVisible(true);
        phonePanel.setBackground(Color.black);
        phonePanel.setLayout(layout);

        price = new JLabel("Prices of Hotel");
        price.setVisible(true);
        price.setOpaque(false);
        price.setBounds(2*360+ 300 + 10-360 +50,200,360,50);        
        price.setFont(new Font("DialogInput",Font.BOLD,25));

        pricePanel.setBounds(2* 360 + 10 + 300-360,250,330,830);
        pricePanel.setVisible(true);
        pricePanel.setBackground(Color.black);
        pricePanel.setLayout(layout);


        location = new JLabel("Get Location of Hotel");
        location.setVisible(true);
        location.setOpaque(false);
        location.setBounds(2*360+ 300 + 10,200,360,50);        
        location.setFont(new Font("DialogInput",Font.BOLD,25));

        butPanel.setBounds(2* 360-10 + 300,250,380,830);
        butPanel.setVisible(true);
        butPanel.setBackground(Color.black);
        butPanel.setLayout(layout);
        
        slect.setBounds(0,0,200 + 50,50);
        slect.setVisible(true);
        slect.setOpaque(false);
        slect.setForeground(Color.black);
        slect.setFont(new Font("DialogInput",Font.BOLD,20));

        ImageIcon image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/City6.jpg");
        back.setBounds(0,0,1400,1080);
        back.setVisible(true);
        this.setSize(1400,1080);
        back.setIcon(image);
        String[] Name ={"Agrabad","Khulshi","New market","Bahaddarhut","Chawkbajar","AndarKilla","Sholoshahar","Patenga"}; 
        Areas = new JComboBox<>(Name); 
        Areas.setBounds(200 + 30,5,200,40);
        Areas.setFont(new Font("DialogInput",Font.PLAIN,20));
        // areLabel.add(Areas);
        submit.setBounds(230 + 30 + 200,5 ,100, 40);
        submit.addActionListener(this);
        submit.setFocusable(false);
        submit.setFont(new Font("DialogInput",Font.PLAIN,15));

        Back.setBounds(430 +160,5,100,40);
        Back.addActionListener(this);
        Back.setFocusable(false);
        Back.setFont(new Font("DialogInput",Font.BOLD,15));

        for(int i = 0;i<20;i++)
        {
            // System.out.println(BuildName.get(i));
            names[i] = new JLabel();
            names[i].setFont(new Font("DialogInput",Font.BOLD,20));
            names[i].setOpaque(true);
            names[i].setBackground(Color.white);
            names[i].setForeground(Color.black);
            //Names[i].setText(BuildName.get(i));
            namePanel.add(names[i]);
        }

        for(int i = 0;i<20;i++)
        {
           // System.out.println(BuildName.get(i));
            phones[i] = new JLabel();
            phones[i].setFont(new Font("DialogInput",Font.BOLD,20));
            phones[i].setOpaque(true);
            phones[i].setBackground(Color.white);
            phones[i].setForeground(Color.black);
            //Names[i].setText(BuildName.get(i));
            phonePanel.add(phones[i]);
        }

        for(int i = 0;i<20;i++)
        {
           // System.out.println(BuildName.get(i));
            prices[i] = new JLabel();
            prices[i].setFont(new Font("DialogInput",Font.BOLD,20));
            prices[i].setOpaque(true);
            prices[i].setBackground(Color.white);
            prices[i].setForeground(Color.black);
            //Names[i].setText(BuildName.get(i));
            pricePanel.add(prices[i]);
        }

        for(int i = 0;i<20;i++)
        {
            buttons[i] = new JButton("Press for Location");
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
        back.add(Back);
        back.add(submit);
        back.add(location);
        back.add(phone);
        back.add(name);
        back.add(Areas);
        back.add(slect);
        back.add(phonePanel);
        back.add(price);
        back.add(pricePanel);
        back.add(butPanel);
        back.add(namePanel);
        this.add(back);
        this.setLayout(null);
        this.setVisible(true);
    }
    Vector<String> BuildName = new Vector<String>();
    Vector< String > Phone = new Vector<String>();
    Vector < String > Price = new Vector <String >();
    Vector< String > loc = new Vector<String>();
    public void getItem(String Area)throws SQLException
    {
        con = Mycnx.getConnection();
        Statement stmn = con.createStatement();
        String query = "select * from ho";
        //  con = Mycnx.getConnection();
        //PreparedStatement stmn = con.prepareStatement(query);
        ResultSet rs = stmn.executeQuery(query);
        while (rs.next()) 
        {
            
            String area = rs.getString("area");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            String price = rs.getString("prices");
            String loca = rs.getString("loc");
            if(Area.equals(area))
            {
                BuildName.add(name);
                Phone.add(phone);
                loc.add(loca);
                Price.add(price);
                System.out.println(area);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == submit)
        {
            BuildName.clear();
            Phone.clear();
            loc.clear();
            Price.clear();
            String ar = (String)Areas.getSelectedItem();
           System.out.println(ar);
           try {
            System.out.println("Gotttt");
               getItem(ar);
           } 
           catch (Exception es)
           {
               System.out.println("Not cncccrted");
           }
           for(int i = 0;i<BuildName.size();i++)
           {          
               names[i].setText(BuildName.get(i));
               buttons[i].setVisible(true);
               phones[i].setText(Phone.get(i));
               prices[i].setText(Price.get(i));
           }
        }
        for(int i = 0;i<BuildName.size();i++)
        {          
            if(e.getSource() == buttons[i])
            {
                try {
                String filename =loc.get(i);
                System.out.println(loc.get(i));
                Desktop d =   Desktop.getDesktop();
                d.browse(new URI(filename));
            } catch (Exception es) {
                //TODO: handle exception
            }
            }
        }
        if(e.getSource() == Back)
        {
            this.setVisible(false);
            Ui frme = new Ui();
        }
    }
    
}
