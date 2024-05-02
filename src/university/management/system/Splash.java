package university.management.system;

import javax.swing.*;  //To use JFrame class
import java.awt.*;

public class Splash extends JFrame implements Runnable{  //Runnable is used is used to change the threads (pages/images (kind off)). Over here we used it so that the the logo is visible and after that the login page comes automatically after sometimes so in order to do that we have used Runnable here
    
    Thread t;
    Splash(){
        
        
        //Used to add an image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons/first.png"));
        Image i2=i1.getImage().getScaledInstance(950, 500, Image.SCALE_DEFAULT);  //Used to set the size of the image inside the screen that will be visible after executing the program
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);  //JLabel class is used if you want to write something on the frame
        add(image);
        
        setVisible(true);  //This is used to show the frame since the default setting does not show the frame       
        setLocation(250,50);
        setSize(1000,700);
        
        t=new Thread(this);
        t.start();
        
//        setVisible(true);  //This is used to show the frame since the default setting does not show the frame
//       
//        setLocation(250,50);
//        setSize(1000,700);
    }
    
    public void run()  //Method used for Multi-Threading
    {
        try{
            Thread.sleep(7000);
            setVisible(false);
            
            //Call the "Login" class non-parametarized contructor
            new Login();
        }
        catch(Exception e){
            
        }
    }
    
    public static void main(String args[]){
        
       new Splash();
    }
}
