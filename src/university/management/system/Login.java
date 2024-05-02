package university.management.system;

import java.awt.Color;
import javax.swing.*;  //To use JFrame class
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{   //ActionListener is basically used an an OnClickListener


    JButton login,cancel;
    JTextField tfusername,tfpassword;
    
    Login(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);  //In order to not use the deault layout this is used
        
        //Used to put the "Username" Label on the Screen
        JLabel lblusername=new JLabel("Username");
        //Since the default setting of setting the text is off we will have to do it manually, This is done by the folowing -
        lblusername.setBounds(40,20,100,20);  //Dist from left, Dist from top, Width, Height
        add(lblusername);  //This is used to add that specific text on the screen/frame . In this case it is adding the text -"Username"
        
        //Used to put the "Username" user input section on the Screen
        tfusername=new JTextField();  //It is used to take a input from the user
        tfusername.setBounds(150,20,100,20);
        add(tfusername);  //In this case it is putting a user input block on the screen
        
        
        
        
        
        //Used to put the "Password" Label on the Screen
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);  
        
        //Used to put the "Password" user input section on the Screen
        tfpassword=new JPasswordField(); 
        tfpassword.setBounds(150,70,100,20);
        add(tfpassword);  
        
        
        
        
        //Used to put the "Login" button on the screen
        login=new JButton("Login");  //JButton is used to create a button. 
        login.setBounds(40,140,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);  //This acts as an 'OnClickListener'
        add(login);  //It is used to add that specific field to the screen
        
        
        
        //Used to put the "Cancel" button on the screen
        cancel=new JButton("Cancel");  //JButton is used to create a button. 
        cancel.setBounds(250,140,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);  // addActionListener() method has the 'actionPerformed()' method in itself 
        //so when you call the 'addActionListener()' method the 'actionPerformed()' method automatically gets called
        add(cancel); 
        
        
        
        //Used to put the an Image on the screen
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);  //Used to set the size of the image inside the screen that will be visible after executing the program
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);  //JLabel class is used if you want to write something on the frame
        image.setBounds(450,0,200,200);
        add(image);
        
        
        
        
        setLocation(250,50);
        setSize(1000,700);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==login){
            String username=tfusername.getText();
            String password=tfpassword.getText();
            
            String query="select * from login where username='"+username+"' and password='"+ password+"'";
            
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
        public static void main(String args[]){
            new Login();
        }
}
