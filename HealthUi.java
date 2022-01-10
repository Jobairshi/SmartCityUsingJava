import javax.swing.JFrame;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Desktop;
import java.net.URI;
import java.security.PublicKey;

import javax.swing.*;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
public class HealthUi extends JFrame implements ActionListener{
    
    JButton Hospitals = new JButton();
    JButton Pharma = new JButton();
    JLabel label3,label4,label5,label6;
    Color cl = new Color(0,102,51);
    Color c2 = new Color(255,51,51);
    Icon i1 = new ImageIcon("C:/Users/User/Desktop/Finalproject/Medical.jpg");
    Icon i2 = new ImageIcon("C:/Users/User/Desktop/Finalproject/arogga.png");
    JButton Back = new JButton("Back");
    public  JButton change(JButton b1)
    {
        b1.setBackground(new Color(102,102,255));
        b1.setFont(new Font("DialogInput",Font.BOLD,15));
        b1.setForeground(java.awt.Color.WHITE);
        b1.setFocusable(false);
        b1.addActionListener(this);
        return b1;
    }
    
    HealthUi()
    {
        Back.setBounds(1200,900,100,40);
        Back = change(Back);
        JLabel label3 = new JLabel("Online Medi Care !!");
        label3.setBounds(400,50,600,80);
        label3.setForeground(Color.BLUE);
        label3.setFont(new Font("DialogInput",Font.BOLD,50));
        label3.setOpaque(false);

        JLabel label4 = new JLabel("Select Your Option: ");
        label4.setBounds(200,150,500,80);
        label4.setForeground(Color.BLUE);
        label4.setFont(new Font("DialogInput",Font.BOLD,30));
        label4.setOpaque(false);


        JLabel label5 = new JLabel("Hospital");
        label5.setBounds(100-20 + 300 + 100-50,200+50 + 100 + 100-100+70,120+10,60);
        label5.setForeground(new Color(153,0,0));
        label5.setFont(new Font("DialogInput",Font.BOLD,27));
        label5.setOpaque(false);

        JLabel label6 = new JLabel("Aragga.com");
        label6.setBounds(680 + 100-50,350 + 100-100+70,120+40,60);
        label6.setForeground(new Color(153,0,0));
        label6.setFont(new Font("DialogInput",Font.BOLD,27));
        label6.setOpaque(false);

        ImageIcon image = new ImageIcon("C:/Users/User/Desktop/Finalproject/City12.jpg");
        JLabel back = new JLabel();
        back.setBounds(0,0,1400,1080);
        back.setOpaque(true);
        back.setVisible(true);
        back.setIcon(image);
        Hospitals.setBounds(100-20 + 300 + 100-50,200+50 + 100 + 100-100,120+10,60);
        Hospitals = change(Hospitals);
        Hospitals.setIcon(i1);

        Pharma.setBounds(680 + 100-50,350 + 100-100,120+40,60);
        Pharma = change(Pharma);
        Pharma.setIcon(i2);

        this.setSize(1400,1080);
        this.setVisible(true);
        this.setLayout(null);
        this.add(back);
        back.add(Back);
        back.add(label3);
        back.add(label4);
        back.add(label5);
        back.add(label6);
        back.add(Pharma);
        back.add(Hospitals);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == Pharma)
        {
            try
            {
                String filename ="https://www.arogga.com/";
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
            this.setVisible(false);
            Ui frm = new Ui();
        }
        if(e.getSource() == Hospitals)
        {
            this.setVisible(false);
            HospitalUi frm = new HospitalUi();
        }
    }
}