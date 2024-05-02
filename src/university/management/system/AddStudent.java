package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener{
    
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
      
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong() %9000L) +1000L);
            
    AddStudent(){
        
        setLocation(250,50);
        setSize(1000,700);
        
        setLayout(null);
        
        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(370,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
  
        //Label for Student's Name
        JLabel lblname=new JLabel("Name:");
        lblname.setBounds(50,130,100,50);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        //Input field for Student's Name
        tfname=new JTextField();
        tfname.setBounds(120,147,130,20);
        add(tfname);
        
        
        
        
        
        
        //Label for Father's Name
        JLabel lblfname=new JLabel("Father's Name:");
        lblfname.setBounds(500,130,200,50);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        //Input field for Father's Name
        tffname=new JTextField();
        tffname.setBounds(640,147,130,20);
        add(tffname);
               
        
        
        
        
        
        //Label for Roll No.
        JLabel lblrollno=new JLabel("Roll Number:");
        lblrollno.setBounds(50,180,200,50);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        //Label for Roll No.
        labelrollno=new JLabel("1533"+first4);
        labelrollno.setBounds(175,180,200,50);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);
        
        
        
        
        
        //Label for DOB.
        JLabel lbldob=new JLabel("Date Of Birth:");
        lbldob.setBounds(500,180,200,50);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        // Putting a calender Field for DOB:
        dcdob=new JDateChooser();
        dcdob.setBounds(640,200,130,20);
        add(dcdob);
        
        
        
        
        
        
        
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
        tfx=new JTextField();
        tfx.setBounds(640,295,130,20);
        add(tfx);
        
        
        
        
        
        
        
        //Label for Class XII %
        JLabel lblxii=new JLabel("Class XII %:");
        lblxii.setBounds(50,330,100,50);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        //Input field for Class XII %
        tfxii=new JTextField();
        tfxii.setBounds(155,345,130,20);
        add(tfxii);
        
        
        
        
        
        
        
        //Label for Aadhar No.
        JLabel lblaadhar=new JLabel("Aadhar No.:");
        lblaadhar.setBounds(500,330,200,50);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        //Input field for Aadhar No.
        tfaadhar=new JTextField();
        tfaadhar.setBounds(640,345,130,20);
        add(tfaadhar);
               
        
        
        
        
        
        
        //Label for Course
        JLabel lblcourse=new JLabel("Course:");
        lblcourse.setBounds(50,380,100,50);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        //Input(DropDown) field for Course
        String course[]={"B.Tech","BBA","BCA","Bsc","Msc","MBA","MCA","MCom","BA","MA"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(155,395,100,25);
        add(cbcourse);
        
        
        
        
        
        
        
        //Label for Branch
        JLabel lblbranch=new JLabel("Course:");
        lblbranch.setBounds(500,380,100,50);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        //Input(DropDown) field for Branch
        String branch[]={"Computer Science","Electronics","Mechanical","Civil","IT"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(640,395,200,25);
        add(cbbranch);
        
        
        
        //Putting submit button
        submit=new JButton("Submit");  //JButton is used to create a button. 
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
            String name=tfname.getText();
            String fname=tffname.getText();
            String rollno=labelrollno.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String x=tfx.getText();
            String xii=tfxii.getText();
            String aadhar=tfaadhar.getText();
            String course=(String)cbcourse.getSelectedItem();
            String branch=(String)cbbranch.getSelectedItem();
            
            
            try{
                String query="insert into student values('"+name+"', '"+fname+"', "
                        + "'"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"',"
                        + " '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"',"
                        + "'"+branch+"') ";
                
                Conn con=new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Student Details inserted Successfully");
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
        
        new AddStudent();
    }
}
