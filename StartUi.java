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
import javax.swing.*;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
public class StartUi extends JFrame implements ActionListener{
    JLabel back;
    JButton letsGo = new JButton("Lets Go >>");
    JLabel title = new JLabel("Smart City");
    Color cl = new Color(125, 249, 255);
    StartUi()
    {
        back = new JLabel();
        ImageIcon image = new ImageIcon("C:/Users/USER/Desktop/Finalproject/City1.jpeg");
        back.setIcon(image);
        back.setOpaque(true);
        back.setVisible(true);
        title.setBounds(0,0,1400,400);
       // title.setOpaque(true);
        title.setFont(new Font("Dialoginput",Font.BOLD,80));
        title.setForeground(cl);
        back.setBounds(0,0, 1400, 1080);
        letsGo.setBounds(550,750,400,150);
        letsGo.setOpaque(false);
        title.setVisible(true);
        letsGo.setContentAreaFilled(false);
        letsGo.setBorderPainted(false);
        letsGo.setForeground(cl);
        letsGo.setFont(new Font("Dialoginput",Font.BOLD,50));
        letsGo.addActionListener(this);
        back.add(letsGo);
        back.add(title);
        this.setVisible(true);
        this.setSize(1400,1080);
        this.add(back);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == letsGo)
        {
           Ui frame = new Ui();
           this.setVisible(false);
        }
    }
}
