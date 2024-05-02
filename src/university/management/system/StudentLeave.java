package university.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*; 
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentLeave extends JFrame implements ActionListener{
    
    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    
    StudentLeave(){
        
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        
        //Heading        
        JLabel heading=new JLabel("Apply Student Leave");
        heading.setBounds(140,5,250,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        //Label for roll-no
        JLabel lblrollno=new JLabel("Search By Rollno:");
        lblrollno.setBounds(20,50,120,50);
        add(lblrollno);
        
        //Drop down for seeing all the rollnos and selecting one of them
        crollno=new Choice();
        crollno.setBounds(170,65,100,50);
        add(crollno);
        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        //Label for date
        JLabel lbldate=new JLabel("Select Date:");
        lbldate.setBounds(20,100,100,50);
        add(lbldate);
        //Selecting the date
        dcdate=new JDateChooser();
        dcdate.setBounds(170,115,100,20);
        add(dcdate);
        
        
        
        
        //Label for half/fullday
        JLabel day=new JLabel("Time duration of date:");
        day.setBounds(20,160,150,50);
        add(day);
        //Choices for half and full day
        ctime=new Choice();
        ctime.setBounds(170,175,100,50);
        ctime.add("Half Day");
        ctime.add("Full Day");
        add(ctime);
        
        
        //Submit Button
        submit=new JButton("Submit");
        submit.setBounds(20,260,100,50);
        submit.addActionListener(this);
        add(submit);
        //Cancel Button
        cancel=new JButton("Cancel");
        cancel.setBounds(150,260,100,50);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String rollno=crollno.getSelectedItem();
            String date=( (JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();
            
            String query="insert into studentleave values ('"+rollno+"' , '"+date+"' ,'"+duration+"')";
            
            Conn c=new Conn();
            try {
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new StudentLeave();
    }
}
