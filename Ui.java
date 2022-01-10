import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
///import java.awt.geom.Line2D;
import java.awt.event.*;

public class Ui implements ActionListener {
     JLabel label2 = new JLabel();
     JLabel label3,label4,label5,label6,label7;
     JButton b1,b2,b3,b4,b5,b6;
     Icon i1 = new ImageIcon("C:/Users/USER/Desktop/Finalproject/City2.jpg");
     JFrame frame=new JFrame();
     Color cl  = new Color(0, 255, 255);
     Color c = new Color(204,0,102);
    Ui(){
   
    b1 = new JButton();
    b1.setBackground(cl);
    b1.setFont(new Font("DialogInput",Font.BOLD,15));
    b1.setForeground(c);
    b1.setBounds(100-20,200+50 + 100,100,60);
    b1.setFocusable(false);
    b1.addActionListener(this);
 //   b1.setBorder(new RoundBorder(30));
    JLabel label3 = new JLabel("Rent");
    ImageIcon image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/rent.png");
    b1.setIcon(image);
    label3.setBounds(100,260+15+50 + 100,80+30,60);
    label3.setForeground(c);
    label3.setFont(new Font("DialogInput",Font.BOLD,25));
    label3.setOpaque(false);

    b2 = new JButton();
    b2.setBackground(cl);
    b2.setFont(new Font("DialogInput",Font.BOLD,15));
    b2.setForeground(c);
    b2.setBounds(270+100-20,200+50+ 100,80,60);
    b2.setFocusable(false);
    b2.addActionListener(this);
    image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/hotels.png");
    b2.setIcon(image);
    JLabel label4 = new JLabel("Hotels");
    label4.setBounds(270+100-5,260+15+50+ 100,110,60);
    label4.setForeground(c);
    label4.setFont(new Font("DialogInput",Font.BOLD,25));
    label4.setOpaque(false);

    b3 = new JButton();
    b3.setBackground(cl);
    b3.setFont(new Font("DialogInput",Font.BOLD,15));
    b3.setForeground(java.awt.Color.GREEN);
    b3.setBounds(440+220-20,200+50+ 100,80,60);
    b3.setFocusable(false);
    b3.addActionListener(this);
    image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/trans.png");
    b3.setIcon(image);
    JLabel label5 = new JLabel("Transpotation");
    label5.setBounds(440+200-20,260+15+50+ 100,200,60);
    label5.setForeground(c);
    label5.setFont(new Font("DialogInput",Font.BOLD,25));
    label5.setOpaque(false);

    b4 = new JButton();
    b4.setBackground(cl);
    b4.setFont(new Font("DialogInput",Font.BOLD,15));
    b4.setForeground(java.awt.Color.GREEN);
    b4.setBounds(610+300-20,200+50+ 100,80,60);
    b4.setFocusable(false);
    b4.addActionListener(this);
    image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/emr.png");
    b4.setIcon(image);
    JLabel label6 = new JLabel("Emergency");
    label6.setBounds(610+300-15,260+15+50+ 100,150,60);
    label6.setForeground(c);
    label6.setFont(new Font("DialogInput",Font.BOLD,25));
    label6.setOpaque(false);


    b5 = new JButton();
    b5.setBackground(cl);
    b5.setFont(new Font("DialogInput",Font.BOLD,15));
    b5.setForeground(java.awt.Color.GREEN);
    b5.setBounds(780+400-30,200+50+ 100,80,60);
    b5.setFocusable(false);
    b5.addActionListener(this);
    image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/hel.png");
    b5.setIcon(image);
    JLabel label7 = new JLabel("Health");
    label7.setBounds(780+400-15,260+15+50+ 100,110,60);
    label7.setForeground(c);
    label7.setFont(new Font("DialogInput",Font.BOLD,25));
    label7.setOpaque(false);

   /* b6 = new JButton("6");
    b6.setBackground(java.awt.Color.gray);
    b6.setFont(new Font("DialogInput",Font.BOLD,15));
    b6.setForeground(java.awt.Color.GREEN);
    b6.setBounds(100,480,80,60);
    b6.setFocusable(false);
    b6.addActionListener(this);
    JLabel label8 = new JLabel("Health");
    label8.setBounds(100,480+60+15,110,60);
    label8.setForeground(Color.green);
    label8.setFont(new Font("DialogInput",Font.BOLD,18));
    label8.setOpaque(false);*/


   
    label2.setIcon(i1);
    label2.setBounds(0,0,1400,1080);
    label2.setOpaque(true);
    label2.add(b1);
    label2.add(b2);
    label2.add(b3);
    label2.add(b4);
    label2.add(b5);
   // label2.add(b6);
    label2.add(label3);
    label2.add(label4);
    label2.add(label4);
    label2.add(label5);
    label2.add(label6);
    label2.add(label7);
    //label2.add(label8);


    

    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1400,1080);   
    frame.setVisible(true);
    frame.add(label2);
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
             RentUi fs = new RentUi();
        }
        else if(e.getSource() == b2)
        {
            HotelUi a = new HotelUi();
        }
        else if(e.getSource() == b3)
        {
            TransportationUi b =new  TransportationUi();
        }
        else if(e.getSource() == b4)
        {
           // System.out.print("SDD444");
            EmergencyUi c = new EmergencyUi();
        }
        else if(e.getSource() == b5)
        {
           // HealthUi d =new HealthUi();
           HealthUi fram=new HealthUi();
        }
        
        frame.dispose();
    }

   
}