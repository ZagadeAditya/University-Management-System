package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ExaminationDetails extends JFrame implements ActionListener{
    
    
    JTextField semInput;
    JButton getResult,cancel;
    JLabel sub1,sub2,sub3,sub4,sub5,marks1,marks2,marks3,marks4,marks5;
    Choice crollno;
    
    ExaminationDetails(){
        
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);
        
        JLabel lblmarks=new JLabel("Check Result:");
        lblmarks.setBounds(50,50,250,40);
        lblmarks.setFont(new Font("Tahoma",Font.BOLD,24));
        add(lblmarks);

        
        //Scroll Bar for roll nos
        crollno=new Choice();
        crollno.setBounds(200,155,200,20);
        add(crollno);
        
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from subject");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }
        catch (Exception e){
            System.out.println(e) ;
        }
        
        //Label for Roll No.
        JLabel lblrollno=new JLabel("Enter the roll number:");
        lblrollno.setBounds(50,150,200,30);
        add(lblrollno);
        
        
        //Label and Input text for Semester No.
        JLabel lblsemester=new JLabel("Enter the semester:");
        lblsemester.setBounds(50,200,200,30);
        add(lblsemester);
        semInput=new JTextField();
        semInput.setBounds(200,205,200,20);
        add(semInput);
        
        
        //Button to get the result
        getResult=new JButton("Get Result");
        getResult.setBounds(350,300,100,20);
        getResult.addActionListener(this);
        add(getResult);
        
        
        //Button to exit the frame
        cancel=new JButton("Cancel");
        cancel.setBounds(550,300,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        sub1=new JLabel("Subject 1");
        sub1.setBounds(350,350,100,20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(sub1);
        
        sub2=new JLabel("Subject 2");
        sub2.setBounds(350,400,100,20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(sub2);
        
        sub3=new JLabel("Subject 3");
        sub3.setBounds(350,450,100,20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(sub3);
        
        sub4=new JLabel("Subject 4");
        sub4.setBounds(350,500,100,20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(sub4);
        
        sub5=new JLabel("Subject 5");
        sub5.setBounds(350,550,100,20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(sub5);
        
        
        
        
        marks1= new JLabel("Marks for Subject 1");
        marks1.setBounds(550,348,200,20);
        marks1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(marks1);
        
        marks2= new JLabel("Marks for Subject 2");
        marks2.setBounds(550,398,200,20);
        marks2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(marks2);
        
        marks3= new JLabel("Marks for Subject 3");
        marks3.setBounds(550,448,200,20);
        marks3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(marks3);
        
        marks4= new JLabel("Marks for Subject 4");
        marks4.setBounds(550,498,200,20);
        marks4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(marks4);
        
        marks5= new JLabel("Marks for Subject 5");
        marks5.setBounds(550,548,200,20);
        marks5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(marks5);
        
        setVisible(true);
    }
    
       
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==getResult){
            
        String query1="select * from subject where rollno='"+crollno.getSelectedItem()+"' and semester='"+semInput.getText()+"'";
        String query2="select * from marks where rollno='"+crollno.getSelectedItem()+"' and semester='"+semInput.getText()+"'";
        try{
        Conn c=new Conn();
        
        ResultSet rs1=c.s.executeQuery(query1);
        while(rs1.next()){
            sub1.setText(rs1.getString("subject1"));
            sub2.setText(rs1.getString("subject2"));
            sub3.setText(rs1.getString("subject3"));
            sub4.setText(rs1.getString("subject4"));
            sub5.setText(rs1.getString("subject5"));
        }
        
        ResultSet rs2=c.s.executeQuery(query2);
        while(rs2.next()){
            marks1.setText(rs2.getString("marks1"));
            marks2.setText(rs2.getString("marks2"));
            marks3.setText(rs2.getString("marks3"));
            marks4.setText(rs2.getString("marks4"));
            marks5.setText(rs2.getString("marks5"));
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
      }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new ExaminationDetails();
    }
}
