import javax.swing.JFrame;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.google.protobuf.Field.Kind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Desktop;
import java.net.URI;
import java.security.PublicKey;
import java.sql.*;
import javax.swing.*;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
public class EmergencyUi extends JFrame implements ActionListener{
    JComboBox check;
    JButton Police = new JButton("Police");
    JButton ambButton = new JButton("Ambulance");
    JButton Blood = new JButton("BLood");
    public  JButton change(JButton b1)
    {
        b1.setBackground(java.awt.Color.blue);
        b1.setFont(new Font("DialogInput",Font.BOLD,15));
        b1.setForeground(java.awt.Color.GREEN);
        b1.setFocusable(false);
        b1.addActionListener(this);
        return b1;
    }
    //for frame2
    JFrame frame2 = new JFrame();
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
    String s = "";
    JButton Back = new JButton("Back");
    //-----------------------------------
    EmergencyUi()
    {
        submit.setBounds(100 + 50,200,100,40);
        submit.setFocusable(false);
        submit.addActionListener(this);
        String[] arr = {"Chandgaon","Agrabad","Khulshi","Halishahar","Chawkbazar"};
        check = new JComboBox<>(arr); 
        JLabel combo = new JLabel();
        check.setBounds(50,10,200,50);
        combo.setBounds(0,80,400,100);
        combo.setVisible(true);
        combo.setOpaque(false);
        combo.add(check);
        
        //for frame 2
        BACK.setBounds(1300-20,915,100,40);
        BACK.addActionListener(this);
        BACK.setFocusable(false);
        BACK.setFont(new Font("DialogInput",Font.BOLD,20));
    
        GridLayout layout = new GridLayout(20,1);
        layout.setHgap(5);
        layout.setVgap(5);
        name = new JLabel("");
        name.setVisible(true);
        name.setOpaque(false);
        name.setBounds(200 + 200+ 40,10,460,50);        
        name.setFont(new Font("DialogInput",Font.BOLD,25));
        namePanel.setBounds(200 + 200 + 40,80,460,830);
        namePanel.setVisible(true);
        namePanel.setBackground(Color.black);
        namePanel.setLayout(layout);

        phone = new JLabel("Phone Numbers");
        phone.setVisible(true);
        phone.setOpaque(false);
        phone.setBounds(660+ 10 + 200 + 40,10,460,50);        
        phone.setFont(new Font("DialogInput",Font.BOLD,25));
        phonePanel.setBounds(660 + 10 + 200 + 40,80,460,830);
        phonePanel.setVisible(true);
        phonePanel.setBackground(Color.black);
        phonePanel.setLayout(layout);
    
        ImageIcon image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/City6.jpg");
        back.setBounds(0,0,1400,1080);
        back.setVisible(true);

        frame2.setSize(1400,1080);
        frame2.setVisible(false);
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
          Back.setBounds(1300-20,915,100,40);
        Back.addActionListener(this);
        Back.setFocusable(false);
        Back.setFont(new Font("DialogInput",Font.BOLD,20));
     
        back.add(submit);
        back.add(combo);
        back.add(BACK);
        back.add(phone);
        back.add(name);
        back.add(phonePanel);
        back.add(namePanel);
        frame2.add(back);
        frame2.setLayout(null);
        frame2.setSize(1400,1000);
  //--------------------------------

        // ImageIcon image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/City10.png");
        JLabel back = new JLabel();
        back.setBounds(0,0,1400,1080);
        back.setOpaque(true);
        back.setVisible(true);
        back.setIcon(image);
        Police.setBounds(100-20 + 300,200+50 + 100 + 100,100,60);
        Police = change(Police);
        ambButton.setBounds(380 + 300,350 + 100,120,60);
        ambButton = change(ambButton);
        Blood.setBounds(680 + 300,350 + 100,100,60);
        Blood = change(Blood);
        this.setSize(1400,1080);
        this.setVisible(true);
        this.setLayout(null);
        back.add(Back);
        this.add(back);
        back.add(Police);
        back.add(ambButton);
        back.add(Blood);
    }

    Vector<String> Name = new Vector<String>();
    Vector< String > Phone = new Vector<String>();
    public void getItem(String kind,String Area)throws SQLException
    {
        con = Mycnx.getConnection();
        Statement stmn = con.createStatement();
        String query = "select * from emer";
        //  con = Mycnx.getConnection();
        //PreparedStatement stmn = con.prepareStatement(query);
        ResultSet rs = stmn.executeQuery(query);
        while (rs.next()) 
        {
            
            String trans = rs.getString("kind");
            String area = rs.getString("area");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            if(kind.equals(trans) && Area.equals(area))
            {
                Name.add(name);
                Phone.add(phone);
                System.out.println(trans);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for(int i = 0;i<20;i++)
        {
            Names[i].setText("");
            Phones[i].setText("");
        }
        if(e.getSource() == Police)
        {
            Name.clear();
            Phone.clear();
            s = "";
            name.setText("Name of Police Station");
            this.setVisible(false);
            frame2.setVisible(true);
           s = "Police";
        }
        if(e.getSource() == ambButton)
        {
            Name.clear();
            Phone.clear();
            s = "";
            name.setText("Name of Ambulance Station");
            this.setVisible(false);
            frame2.setVisible(true);
            s = "Ambulance";
        }
        if(e.getSource() == Blood)
        {
            s = "";
            Name.clear();
            Phone.clear();
            name.setText("Name of Blood Bank");
            this.setVisible(false);
            frame2.setVisible(true);
            s = "Blood";
        }
        if(e.getSource() == submit)
        {
            Name.clear();
            Phone.clear();
            String area = (String)check.getSelectedItem();
            
            try {
                System.out.println(s + " " + area);
                getItem(s,area);
            } catch (Exception es) {
                //TODO: handle exception
            }
            for(int i = 0;i<Name.size();i++)
            {
                Names[i].setText(Name.get(i));
                Phones[i].setText(Phone.get(i));
            }
        }
        if(e.getSource() == BACK)
        {
            frame2.setVisible(false);
            this.setVisible(true);
        }
        if(e.getSource() == Back)
        {
            Ui frm = new Ui();
            this.setVisible(false);
        }
    }
}
