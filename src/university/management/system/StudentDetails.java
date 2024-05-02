package university.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*; 
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener{
    
    Choice crollno;
    JTable table;
    JButton search, update, print, add, cancel;
    
        StudentDetails(){
            
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel heading=new JLabel("Search By Roll Number:");
        heading.setBounds(20,20,150,30);
        add(heading);
        
        crollno=new Choice();
        crollno.setBounds(175,20,150,30);
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
        
        table=new JTable();
        
        //This try and catch block is used to show the contents of the student table that is present inside the sql database
        try{
            Conn c=new Conn();  //Used to create a connection between java and sql
            ResultSet rs=c.s.executeQuery("select * from student");  //This is used to get all the info from the student table present inside the sql database
            table.setModel(DbUtils.resultSetToTableModel(rs));  //This is used to stroe all the contents of the sql student's table inside the table made in java
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(50,150,900,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(70,100,80,20);
        search.addActionListener(this);
        add(search);
        
        update=new JButton("Update");
        update.setBounds(160,100,80,20);
        update.addActionListener(this);
        add(update);
        
        print=new JButton("Print");
        print.setBounds(250,100,80,20);
        print.addActionListener(this);
        add(print);
        
        add=new JButton("Add");
        add.setBounds(340,100,80,20);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(430,100,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setLocation(250,50);
        setSize(1000,700);
        setVisible(true);
    }
      
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==search){
               String query="Select * from student where rollno= '"+crollno.getSelectedItem()+"'";
               
               try{
                   Conn c=new Conn();
                   ResultSet rs=c.s.executeQuery(query);
                   table.setModel(DbUtils.resultSetToTableModel(rs));
               }
               catch (Exception e){
                   System.out.println(e);
               }
            }
            else if(ae.getSource()==update){
                setVisible(false);
                //new UpdateStudent();
            }
            else if(ae.getSource()==print){
                
                try{
                    table.print();
                }
                catch (Exception e){
                 System.out.println(e);
                }
            }
            else if(ae.getSource()==add){
                setVisible(false);
                new AddStudent();
            }
            else if(ae.getSource()==cancel){
                setVisible(false);
            }
            
        }
    public static void main(String args[]){
        new StudentDetails();
    }
}
