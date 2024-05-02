package university.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*; 
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame implements ActionListener{
    
    Choice crollno;
    JTable table;
    JButton search,update,add,cancel,print;
    
    StudentLeaveDetails(){
        
        setSize(800,650);
        setLocation(550,100);
        setLayout(null);
        
        
        JLabel heading=new JLabel("Search By Roll Number:");
        heading.setBounds(50,50,250,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,15));
        add(heading);
        
        crollno=new Choice();
        crollno.setBounds(300,55,150,30);
        add(crollno);
        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from studentleave"); 
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        table=new JTable();
        
        
        try{
            Conn c=new Conn();  
            ResultSet rs=c.s.executeQuery("select * from studentleave");  
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            System.out.println(e);
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(50,150,700,450);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(50,100,100,20);
        search.addActionListener(this);
        add(search);
        
        update=new JButton("Update");
        update.setBounds(160,100,100,20);
        update.addActionListener(this);
        add(update);
        
        add=new JButton("Add");
        add.setBounds(270,100,100,20);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(380,100,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        print=new JButton("Print");
        print.setBounds(490,100,100,20);
        print.addActionListener(this);
        add(print);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="Select * from studentleave where rollno= '"+crollno.getSelectedItem()+"'";
               
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
        }
        else if(ae.getSource()==add){
            new StudentLeave();
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
        else if(ae.getSource()==print){
            
             try{
                    table.print();
                }
                catch (Exception e){
                 System.out.println(e);
                }
        }
    }
    public static void main(String args[]){
        new StudentLeaveDetails();
    }
}
