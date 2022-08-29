
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Connection {
    public void connect()
    {
     try
     {   
         java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
            
         
     
     }
     
     catch(Exception e)
     {
         e.printStackTrace();
     }
       
    }
    
}
