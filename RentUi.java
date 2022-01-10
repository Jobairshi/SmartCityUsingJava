import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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
import javax.swing.*;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
public class RentUi extends JFrame implements ActionListener {
    JComboBox Areas;
    JLabel back = new JLabel();
    JLabel slect = new JLabel("Select Your Area :");
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
    JLabel warn = new JLabel("* Marked House Are Not Fit According to National Building Code");
    JButton add = new JButton("Add House For Rent");

    JButton Back = new JButton("Back");
    RentUi()
    {
        warn.setVisible(true);
        warn.setOpaque(false);
        warn.setBounds(0,100,1000,70);        
        warn.setFont(new Font("DialogInput",Font.BOLD,25));
        warn.setForeground(Color.RED);

        GridLayout layout = new GridLayout(20,1);
        layout.setHgap(5);
        layout.setVgap(5);
        name = new JLabel("Name of Buildings");
        name.setVisible(true);
        name.setOpaque(false);
        name.setBounds(0,200,460,50);        
        name.setFont(new Font("DialogInput",Font.BOLD,25));
        namePanel.setBounds(0,250,460,830);
        namePanel.setVisible(true);
        namePanel.setBackground(Color.black);
        namePanel.setLayout(layout);

        phone = new JLabel("Phone No of Building Manager");
        phone.setVisible(true);
        phone.setOpaque(false);
        phone.setBounds(460+ 10,200,460-10,50);        
        phone.setFont(new Font("DialogInput",Font.BOLD,25));
        phonePanel.setBounds(460 + 10,250,460-10,830);
        phonePanel.setVisible(true);
        phonePanel.setBackground(Color.black);

        phonePanel.setLayout(layout);

        location = new JLabel("Get Location of Buildings");
        location.setVisible(true);
        location.setOpaque(false);
        location.setBounds(2*460+ 10,200,460,50);        
        location.setFont(new Font("DialogInput",Font.BOLD,25));

        butPanel.setBounds(2* 460 + 10,250,460,830);
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
        String[] Name ={"Agrabad","Chandgaon","New market","Bahaddarhut","Kalorghat","AndarKilla","Sholoshahar","Khulshi"}; 
        Areas = new JComboBox<>(Name); 
        Areas.setBounds(200 + 30,5,200,40);
        Areas.setFont(new Font("DialogInput",Font.PLAIN,20));
        // areLabel.add(Areas);
        submit.setBounds(230 + 30 + 200,5 ,100, 40);
        submit.addActionListener(this);
        submit.setFocusable(false);
        submit.setFont(new Font("DialogInput",Font.PLAIN,15));

        add.setBounds(430 +150,5,150,40);
        add.addActionListener(this);
        add.setFocusable(false);
        add.setFont(new Font("DialogInput",Font.PLAIN,10));

        Back.setBounds(430 +320,5,100,40);
        Back.addActionListener(this);
        Back.setFocusable(false);
        Back.setFont(new Font("DialogInput",Font.BOLD,15));

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
        back.add(warn);
        back.add(add);
        back.add(submit);
        back.add(location);
        back.add(phone);
        back.add(name);
        back.add(Areas);
        back.add(slect);
        back.add(phonePanel);
        back.add(butPanel);
        back.add(namePanel);
        this.add(back);
        this.setLayout(null);
        this.setVisible(true);
    }
    Vector<String> BuildName = new Vector<String>();
    Vector< String > Phone = new Vector<String>();
    Vector< String > loc = new Vector<String>();
    public void getItem(String Area)throws SQLException
    {
        con = Mycnx.getConnection();
        Statement stmn = con.createStatement();
        String query = "select * from building";
        //  con = Mycnx.getConnection();
        //PreparedStatement stmn = con.prepareStatement(query);
        ResultSet rs = stmn.executeQuery(query);
        while (rs.next()) 
        {
            
            String area = rs.getString("area");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            String loca = rs.getString("location");
            if(Area.equals(area))
            {
                BuildName.add(name);
                    Phone.add(phone);
                    loc.add(loca);
                System.out.println(area);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == submit)
        {
            BuildName.clear();
            Phone.clear();;
            loc.clear();
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
               Names[i].setText(BuildName.get(i));
               buttons[i].setVisible(true);
               Phones[i].setText(Phone.get(i));
           }
            // eikan e  data base  er kaaj krobo
        }
        if(e.getSource() == add)
        {
            this.setVisible(false);
            AddhouseUi frame = new AddhouseUi();
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
            Ui frame = new Ui();
            this.setVisible(false);
        }
    }
    
}
