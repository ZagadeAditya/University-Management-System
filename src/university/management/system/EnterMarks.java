package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class EnterMarks extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,cancel;
    
    
    EnterMarks(){
        
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);
        
        JLabel lblmarks=new JLabel("Enter marks of student with roll number as:");
        lblmarks.setBounds(50,100,250,40);
        add(lblmarks);

        crollno=new Choice();
        
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
        crollno.setBounds(300,110,200,40);
        add(crollno);

        
        JLabel lblsemester=new JLabel("Enter the semester:");
        lblsemester.setBounds(50,150,250,40);
        add(lblsemester);
        
        cbsemester=new JComboBox();
        cbsemester.setBounds(300,160,200,20);
        cbsemester.addItem("Sem 1");
        cbsemester.addItem("Sem 2");
        cbsemester.addItem("Sem 3");
        cbsemester.addItem("Sem 4");
        cbsemester.addItem("Sem 5");
        cbsemester.addItem("Sem 6");
        cbsemester.addItem("Sem 7");
        cbsemester.addItem("Sem 8");
        add(cbsemester);
        
        
        JLabel lblentersubject=new JLabel("Enter the subject");
        lblentersubject.setBounds(100,300,100,20);
        add(lblentersubject);
        
        
        JLabel lblentermarks=new JLabel("Enter the marks");
        lblentermarks.setBounds(400,300,100,20);
        add(lblentermarks);
        
        
        tfsub1=new JTextField();
        tfsub1.setBounds(50,350,200,20);
        add(tfsub1);
        
        tfsub2=new JTextField();
        tfsub2.setBounds(50,375,200,20);
        add(tfsub2);
        
        tfsub3=new JTextField();
        tfsub3.setBounds(50,400,200,20);
        add(tfsub3);
        
        tfsub4=new JTextField();
        tfsub4.setBounds(50,425,200,20);
        add(tfsub4);
        
        tfsub5=new JTextField();
        tfsub5.setBounds(50,450,200,20);
        add(tfsub5);
        
        
        
        tfmarks1=new JTextField();
        tfmarks1.setBounds(350,350,200,20);
        add(tfmarks1);
        
        tfmarks2=new JTextField();
        tfmarks2.setBounds(350,375,200,20);
        add(tfmarks2);
        
        tfmarks3=new JTextField();
        tfmarks3.setBounds(350,400,200,20);
        add(tfmarks3);
        
        tfmarks4=new JTextField();
        tfmarks4.setBounds(350,425,200,20);
        add(tfmarks4);
        
        tfmarks5=new JTextField();
        tfmarks5.setBounds(350,450,200,20);
        add(tfmarks5);
        
        
        submit=new JButton("Submit");
        submit.setBounds(75,550,150,20);
        submit.addActionListener(this);
        add(submit);
        
        
        cancel=new JButton("Cancel");
        cancel.setBounds(375,550,150,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public static void main(String args[]){
        new EnterMarks();
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            
            try{
                Conn c=new Conn();
                
            String query1="insert into subject values('"+crollno.getSelectedItem()+"' , '"+cbsemester.getSelectedItem()+
                    "' , '"+tfsub1.getText()+"' ,'"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"'"
                    + ",'"+tfsub5.getText()+"')";
             
            String query2="insert into marks values('"+crollno.getSelectedItem()+"' , '"+cbsemester.getSelectedItem()+
                    "' , '"+tfmarks1.getText()+"' ,'"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"'"
                    + ",'"+tfmarks5.getText()+"')";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"Marks inserted successfully");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
}
