package university.management.system;

import java.sql.*;

public class Conn {

    Connection c;   // creating an object/reference of the interface 'Connection'
    Statement s;    // creating an object/reference of the interface 'Statement'
    Conn(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  //Step 1 Of Connecting the Database - Registering the Driver Class
            c=DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "hello");  //Step 2 - Connection String
            s=c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
