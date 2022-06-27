
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAMON ALMASWRI
 */
public class DBdata {
    
      Connection con;
    Statement st;
    ResultSet result;
    //PreparedStatement ps;
     public static Connection DBconnection(){
         Connection con=null;
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:ucanaccess://c://Users//Hasan Yagout//Desktop//Hotel_Management_System.accdb");
            JOptionPane.showMessageDialog(null,"you are cannected");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
     public static  ArrayList<Allcustumers>getAllcustumers(){
         
             ArrayList<Allcustumers>list = new ArrayList<Allcustumers>();
             try{
                 String sql="select * from customer1 ";
               Connection  con = DBdata.DBconnection();
               PreparedStatement prs=(PreparedStatement)con.prepareStatement(sql);
               
                ResultSet rs=prs.executeQuery();
                while(rs.next()){
                    list.add(new Allcustumers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14)) );
                    
                    
                    
                }
                con.close();
             }
             catch(SQLException ee){
            ee.printStackTrace();
        }
        return list;
     }
 public static  ArrayList<Allcheckin>getAllcheckin(){
         
             ArrayList<Allcheckin>list2 = new ArrayList<Allcheckin>();
             try{
                 String sql="select * from check_in1 ";
               Connection  con = DBdata.DBconnection();
               PreparedStatement prs=(PreparedStatement)con.prepareStatement(sql);
               
                ResultSet rs=prs.executeQuery();
                while(rs.next()){
                    
                    
              list2.add(new Allcheckin(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)) );
 
                }
                con.close();
             }
             catch(SQLException ee){
            ee.printStackTrace();
        }
        return list2;
     }
 
 
 /////////////////////////////////////
 
 public static  ArrayList<AllcheckOut>getAllcheckOut(){
         
             ArrayList<AllcheckOut>list3 = new ArrayList<AllcheckOut>();
             try{
                 String sql="select * from checkOut1 ";
               Connection  con = DBdata.DBconnection();
               PreparedStatement prs=(PreparedStatement)con.prepareStatement(sql);
               
                ResultSet rs=prs.executeQuery();
                while(rs.next()){
                    
                    
              list3.add(new AllcheckOut(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)) );
 
                }
                con.close();
             }
             catch(SQLException ee){
            ee.printStackTrace();
        }
        return list3;
     }
}



