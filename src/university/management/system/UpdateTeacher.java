package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener{
    
    JTextField tfaddress,tfphone,tfemail,tfcourse,tfbranch;
    JLabel labelempId;
    JButton submit,cancel;
    Choice cempId;
    
            
    UpdateTeacher(){
        
        setLocation(250,50);
        setSize(1000,700);
        
        setLayout(null);
        
        JLabel heading=new JLabel("Update Teacher Details");
        heading.setBounds(370,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        
        JLabel lblrollnumber=new JLabel("Select Emp Id:");
        lblrollnumber.setBounds(50,100,175,30);
        lblrollnumber.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblrollnumber);
        
        cempId=new Choice();
        cempId.setBounds(250,105,150,30);
        add(cempId);
        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher"); 
            while(rs.next()){
                cempId.add(rs.getString("empId"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
  
        //Label for Student's Name
        JLabel lblname=new JLabel("Name:");
        lblname.setBounds(50,130,100,50);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        //Input field for Student's Name
        JLabel labelname=new JLabel();
        labelname.setBounds(120,147,130,20);
        add(labelname);
        
        
        
        
        
        
        //Label for Father's Name
        JLabel lblfname=new JLabel("Father's Name:");
        lblfname.setBounds(500,130,200,50);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        //Input field for Father's Name
        JLabel labelfname=new JLabel();
        labelfname.setBounds(640,147,130,20);
        add(labelfname);
               
        
        
        
        
        
        //Label for Roll No.
        JLabel lblrollno=new JLabel("Employee Id:");
        lblrollno.setBounds(50,180,200,50);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        //Label for Roll No.
        labelempId=new JLabel();
        labelempId.setBounds(175,180,200,50);
        labelempId.setFont(new Font("serif",Font.BOLD,20));
        add(labelempId);
        
        
        
        
        
        //Label for DOB.
        JLabel lbldob=new JLabel("Date Of Birth:");
        lbldob.setBounds(500,180,200,50);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        // Putting a calender Field for DOB:
        JLabel labeldob=new JLabel();
        labeldob.setBounds(640,200,130,20);
        add(labeldob);
        
        
        
        
        
        
        
        //Label for Address
        JLabel lbladdress=new JLabel("Address:");
        lbladdress.setBounds(50,230,100,50);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        //Input field for Student's Name
        tfaddress=new JTextField();
        tfaddress.setBounds(155,245,130,20);
        add(tfaddress);
        
        
        
        
        
        
        
        //Label for Phone No.
        JLabel lblphoneno=new JLabel("Phone No.:");
        lblphoneno.setBounds(500,230,100,50);
        lblphoneno.setFont(new Font("serif",Font.BOLD,20));
        add(lblphoneno);
        //Input field for Phone No.
        tfphone=new JTextField();
        tfphone.setBounds(640,245,130,20);
        add(tfphone);
        
        
        
        
        
        
        
        //Label for Email
        JLabel lblemail=new JLabel("Email id:");
        lblemail.setBounds(50,280,100,50);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        //Input field for Email
        tfemail=new JTextField();
        tfemail.setBounds(155,295,130,20);
        add(tfemail);
      
        
        
        
        
        
        
        
        //Label for Class X %
        JLabel lblx=new JLabel("Class X %:");
        lblx.setBounds(500,280,100,50);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        //Input field for Class X %
        JLabel labelx=new JLabel();
        labelx.setBounds(640,295,130,20);
        add(labelx);
        
        
        
        
        
        
        
        //Label for Class XII %
        JLabel lblxii=new JLabel("Class XII %:");
        lblxii.setBounds(50,330,100,50);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        //Input field for Class XII %
        JLabel labelxii=new JLabel();
        labelxii.setBounds(155,345,130,20);
        add(labelxii);
        
        
        
        
        
        
        
        //Label for Aadhar No.
        JLabel lblaadhar=new JLabel("Aadhar No.:");
        lblaadhar.setBounds(500,330,200,50);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        //Input field for Aadhar No.
        JLabel labelaadhar=new JLabel();
        labelaadhar.setBounds(640,345,130,20);
        add(labelaadhar);
               
        
        
        
        
        
        
        //Label for Course
        JLabel lblcourse=new JLabel("Education:");
        lblcourse.setBounds(50,380,100,50);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        //Input(DropDown) field for Course
        tfcourse=new JTextField();
        tfcourse.setBounds(155,395,100,25);
        add(tfcourse);
        
        
        
        
        
        
        
        //Label for Branch
        JLabel lblbranch=new JLabel("Department:");
        lblbranch.setBounds(500,380,100,50);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        //Input(DropDown) field for Branch
        tfbranch=new JTextField();
        tfbranch.setBounds(640,395,200,25);
        add(tfbranch);
        
        
        
        try{
            Conn c=new Conn();
            String query="Select * from teacher where empId= '"+cempId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelempId.setText(rs.getString("empId"));
                tfcourse.setText(rs.getString("education"));
                tfbranch.setText(rs.getString("department"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        //Adding onClick to the scroll menu
        cempId.addItemListener(new ItemListener(){
        
            public void itemStateChanged(ItemEvent ie){
                try{
            Conn c=new Conn();
            String query="Select * from teacher where empId= '"+cempId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelempId.setText(rs.getString("empId"));
                tfcourse.setText(rs.getString("education"));
                tfbranch.setText(rs.getString("department"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
            }
        });
        
        
        //Putting submit button
        submit=new JButton("Update");  //JButton is used to create a button. 
        submit.setBounds(250,540,150,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);  //This acts as an 'OnClickListener'
        add(submit);  //It is used to add that specific field to the screen
        
        
        
        
        
        
        
        //Putting cancel button
        cancel=new JButton("Cancel");  //JButton is used to create a button. 
        cancel.setBounds(550,540,150,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);  //This acts as an 'OnClickListener'
        add(cancel);  //It is used to add that specific field to the screen
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
            String empId=labelempId.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=tfcourse.getText();
            String department=tfbranch.getText();
            
            
            try{
                String query="update teacher set address='"+address+"' ,phone='"+phone+"' ,email='"+email+"' "
                        + ",education='"+education+"' ,department='"+department+"' where empId='"+empId+"'";
                
                Conn con=new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully");
                setVisible(false);
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
        
        new UpdateTeacher();
    }
}