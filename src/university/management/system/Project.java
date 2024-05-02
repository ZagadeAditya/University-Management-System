package university.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{


    JMenuItem ex,calc,notepad;
    
    Project(){
        

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 650, Image.SCALE_DEFAULT);  //Used to set the size of the image inside the screen that will be visible after executing the program
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);  //JLabel class is used if you want to write something on the frame
        add(image);
        
        JMenuBar mb=new JMenuBar();  //Used for generating and showing a Menu-Bar
        
        //Adding a new section to the Header - 'New Information'
        JMenu newInformation=new JMenu("New Information"); 
        newInformation.setForeground(Color.magenta);
        mb.add(newInformation);  //This is used to add stuff on the Menu-Bar
        
        //Adding sub-sections like 'faculty_info' and 'student_info 'to the main header - 'New Information'
        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        
        
        
        
        //Adding a new section to the Header - 'Details'
        JMenu details=new JMenu("View Details"); 
        details.setForeground(Color.magenta);
        mb.add(details);  //This is used to add stuff on the Menu-Bar
        
        //Adding sub-sections like 'faculty_details' and 'student_details 'to the main header - 'View details'
        JMenuItem facultyDetails=new JMenuItem("View Faculty Details");
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        JMenuItem studentDetails=new JMenuItem("View Student Details");
        studentDetails.addActionListener(this);
        details.add(studentDetails);
        
        
        
        
        
        
        //Adding a new section to the Header - 'Leave'
        JMenu leave=new JMenu("Apply Leave"); 
        leave.setForeground(Color.magenta);
        mb.add(leave);  //This is used to add stuff on the Menu-Bar
        
        //Adding sub-sections like 'faculty_leave' and 'student_leave' to the main header - 'Apply Leave'
        JMenuItem facultyleave=new JMenuItem("Faculty Leave");
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        JMenuItem studentleave=new JMenuItem("Student Leave");
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        
        
        
        
        
        
        //Adding a new section to the Header - 'Leave Details'
        JMenu leaveDetails=new JMenu("View Leave Details"); 
        leaveDetails.setForeground(Color.magenta);
        mb.add(leaveDetails);  //This is used to add stuff on the Menu-Bar
        
        //Adding sub-sections like 'faculty_leave_details' and 'student_leave_detials' to the main header - 'Apply Leave Details'
        JMenuItem facultyleavedetails=new JMenuItem("Faculty Leave Details");
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);
        JMenuItem studentleavedetails=new JMenuItem("Student Leave Details");
        studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);
        
        
        
        
        
        
        
        //Adding a new section to the Header - 'Exams'
        JMenu exam=new JMenu("Examination"); 
        exam.setForeground(Color.magenta);
        mb.add(exam);  //This is used to add stuff on the Menu-Bar
        
        //Adding sub-sections like 'examination_details' and 'enter_marks' to the main header - 'Examination'
        JMenuItem examinationdetails=new JMenuItem("Examination Results");
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        JMenuItem entermarks=new JMenuItem("Enter Marks");
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        
        
        
        
        
        //Adding a new section to the Header - 'Update Information'
        JMenu updateInfo=new JMenu("Update Details"); 
        updateInfo.setForeground(Color.magenta);
        mb.add(updateInfo);  //This is used to add stuff on the Menu-Bar
        
        //Adding sub-sections like 'update_faculty_info' and 'enter_marks' to the main header - 'update_student_info'
        JMenuItem updatefacultyInfo=new JMenuItem("Update Faculty Details");
        updatefacultyInfo.addActionListener(this);
        updateInfo.add(updatefacultyInfo);
        JMenuItem updatestudentInfo=new JMenuItem("Update Student Details");
        updatestudentInfo.addActionListener(this);
        updateInfo.add(updatestudentInfo);
        
        
        
        
        
        
        
        //Adding a new section to the Header - 'Update Information'
        JMenu fee=new JMenu("Fee Details"); 
        fee.setForeground(Color.magenta);
        mb.add(fee);  //This is used to add stuff on the Menu-Bar
        
        //Adding sub-sections like 'fee_structure' and 'fee_form' to the main header - 'update_student_info'
        JMenuItem feestructure=new JMenuItem("Fee Structure");
        feestructure.addActionListener(this);
        fee.add(feestructure);
        JMenuItem feeform=new JMenuItem("Student Fee Form");
        fee.add(feeform);
        
        
        
        
        
        //Adding a new section to the Header - 'Utility'
        JMenu utility=new JMenu("Utility"); 
        utility.setForeground(Color.magenta);
        mb.add(utility);  //This is used to add stuff on the Menu-Bar
        
        //Adding sub-sections like 'Notepad' and 'fee_form' to the main header - 'Calculator'
        notepad=new JMenuItem("Notepad");
        notepad.addActionListener(this);
        utility.add(notepad);
        calc=new JMenuItem("Calculator");
        calc.addActionListener(this);
        utility.add(calc);
        
        
        
        
        
        
        
        //Adding a new section to the Header - 'About'
        JMenu about=new JMenu("About"); 
        about.setForeground(Color.magenta);
        mb.add(about);  //This is used to add stuff on the Menu-Bar
        JMenuItem aboutSec=new JMenuItem("About Section");
        aboutSec.addActionListener(this);
        about.add(aboutSec);
        
        
        
        
        
        
        
        
        
        //Adding a new section to the Header - 'Exit'
        JMenu exit=new JMenu("Exit"); 
        exit.setForeground(Color.magenta);
        mb.add(exit);  //This is used to add stuff on the Menu-Bar
        
        //Adding sub-sections like 'Notepad' and 'fee_form' to the main header - 'Calculator'
        ex=new JMenuItem("Exit");
        ex.addActionListener(this);
        exit.add(ex);
        
        
        
        setJMenuBar(mb); 
        
        setSize(1550,750);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        
        if(msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc");
            }
            catch (Exception e){
                
            }
        }
        else if(msg.equals("Notepad")){
            
            try{
                Runtime.getRuntime().exec("notepad");
            }
            catch (Exception e){
                
            }
        }
        else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }
        else if(msg.equals("New Student Information")){
            new AddStudent();
        }
        else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        }
        else if(msg.equals("View Student Details")){
            new StudentDetails();
        }
        else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }
        else if(msg.equals("Student Leave")){
            new StudentLeave();
        }
         else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }
          else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }
        else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }
        else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }
         else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }
         else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        }
         else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
    }

    public static void main(String args[]){
        
        new Project();
    }
}