
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
class passwordCheck {
     public int Pcheck(String a )
    {
     try
     {   
         
         java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
            PreparedStatement pst = conn.prepareStatement("select * from passwords where String = ?");
            pst.setString(1, a);
            ResultSet rs =pst.executeQuery();
         if(rs.next())
         {
         System.out.print("wrigth Password\n");
         return 1 ;
         }    
         else
         {
             System.out.print("wrong Password\n");
         }         
            
            
            
            
     
     
     }
     
     catch(Exception e)
     {
         e.printStackTrace();
     }
        return 0;
    }
}
