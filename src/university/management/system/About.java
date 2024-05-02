package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    
    About(){
        
        setLocation(250, 50);
        setSize(1000, 700);
        setLayout(null);
        
        
        JLabel heading=new JLabel("<html>Project <br/> Management System</html>");
        heading.setBounds(200,20,350,130);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons/about.jpg"));
        Image i2=i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);  //Used to set the size of the image inside the screen that will be visible after executing the program
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);  //JLabel class is used if you want to write something on the frame
        image.setBounds(600,50,300,200);
        add(image);
        
        JLabel developed=new JLabel("<html>Developed By: <br/> SIUUUUUUUU</html>");
        developed.setBounds(200,120,350,130);
        developed.setFont(new Font("Tahoma",Font.BOLD,20));
        add(developed);
        
        
        setVisible(true);
    }
    
    public static void main(String args[]){
        new About();
    }
}
