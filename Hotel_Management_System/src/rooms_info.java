import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

import java.awt.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class rooms_info {






        // JList List;
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
                JOptionPane.showMessageDialog(null,"you are cannected to info");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return con;
        }


        //custumers cr = new custumers();
        public static ArrayList<Rooms_con> getrooms(){

            ArrayList<Rooms_con>list = new ArrayList<Rooms_con>();
            try{
                String sql="select * from Rooms ";
                Connection  con = DBinfo.DBconnection();
                PreparedStatement prs=(PreparedStatement)con.prepareStatement(sql);

                ResultSet rs=prs.executeQuery();
                while(rs.next()){
                    list.add(new Rooms_con(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5) ));



                }
                con.close();
            }
            catch(SQLException ee){
                ee.printStackTrace();
            }
            return list;
        }

    }


