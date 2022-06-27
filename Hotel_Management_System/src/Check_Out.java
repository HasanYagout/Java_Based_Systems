/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MAMON ALMASWRI
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static java.awt.Font.SERIF;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Check_Out extends JFrame implements ActionListener {
    JLabel Price_Label,name_Label,Phone_Number_Label,checkin_date_Label,checkout_date_Label,label,search_Label,days_Label;
    JTextField Price_textfield, name,Phone_Number,checkin_date_text_Field,email_textfield,checkout_date_Text_Field,days_Text_Field,search_Text_Field;
    JPanel background_panel,main_panel,button_panel;
    JLabel email;
    JButton exit,check_in,check_out,manage_rooms,log_out,search,check_out_button,cancel,cusInformation;
    String  Activation;
    Connection con;
    Statement st;
    
    ResultSet result;
    PreparedStatement ps;
     int rn;
     String rt;
     String bt;
      int pr;
    public Check_Out()
    {
        setLayout(null);
        setTitle("Check Out");
        setSize(1920,1080);
        //setVisible(true);


        background_panel= new JPanel(null);
        background_panel.setBounds(0,0,1920,1080);
        add(background_panel);

        button_panel= new JPanel(null);
        button_panel.setBounds(0,0,1920,150);
        background_panel.add(button_panel);

        main_panel= new JPanel(null);
        main_panel.setBounds(0,0,1920,1080);

        background_panel.add(main_panel);



        label= new JLabel();
        label.setBounds(0,0,1920,1080);
        background_panel.add(label);
        main_panel.setBackground(new Color(213, 134, 145, 0));
        button_panel.setBackground(new Color(213, 134, 145, 0));
        createImage("background6.jpg");

        Icon checkin_Icon= new ImageIcon("img/checkIn.png");
        check_in=new JButton("Check in",checkin_Icon);
        check_in.setFont(new Font(Font.SERIF, Font.BOLD,20));
        check_in.setBackground(Color.white);
        check_in.setBounds(20,10,200,100);
        button_panel.add(check_in);
        check_in.addActionListener(this);


        Icon checkout_Icon= new ImageIcon("img/checkout.png");
        check_out= new JButton("checkout",checkout_Icon);
        check_out.setBounds(250,10,200,100);
        check_out.setBackground(Color.white);
        check_out.setFont(new Font(Font.SERIF,Font.BOLD,20));
        button_panel.add(check_out);
        check_out.addActionListener(this);

        Icon managerooms_Icon= new ImageIcon("img/managerooms.png");
        manage_rooms=new JButton("manage rooms",managerooms_Icon);
        manage_rooms.setBackground(Color.white);
        manage_rooms.setFont(new Font(Font.SERIF,Font.BOLD,20));
        manage_rooms.setBounds(480,10,250,100);
        button_panel.add(manage_rooms);
        manage_rooms.addActionListener(this);
        
        

        cusInformation = new JButton("customer info"/*, cusInformation_Icon*/);
        cusInformation.setBackground(Color.white);
        cusInformation.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        cusInformation.setBounds(760, 10, 250, 100);
        button_panel.add(cusInformation);
        cusInformation.addActionListener(this);


        Icon logout_Icon= new ImageIcon("img/logout.png");
        log_out=new JButton("logout",logout_Icon);
        log_out.setFont(new Font(Font.SERIF,Font.BOLD,20));
        log_out.setBounds(1500,10,200,95);
        log_out.setBackground(Color.white);
        button_panel.add(log_out);
        log_out.addActionListener(this);


        Icon exit_Icon= new ImageIcon("img/exit.png");
        exit= new JButton(exit_Icon);
        exit.setBounds(1750,10,95,95);
        exit.setFont(new Font(Font.SERIF,Font.BOLD,30));
        button_panel.add(exit);
        exit.addActionListener(this);

        search_Label= new JLabel("Room Number");
        search_Label.setBounds(500,250,200,40);
        search_Label.setFont(new Font(SERIF,Font.BOLD,30));
        search_Label.setForeground(Color.white);
        main_panel.add(search_Label);

        search_Text_Field= new JTextField();
        search_Text_Field.setBounds(750,250,100,40);
        search_Text_Field.setFont(new Font(SERIF,Font.BOLD,30));
        main_panel.add(search_Text_Field);

        search= new JButton("Search");
        search.setBounds(860,250,100,40);
        main_panel.add(search);
        search.addActionListener(this);

        name_Label= new JLabel("Name");
        name_Label.setBounds(200,400,100,40);
        name_Label.setForeground(Color.white);
        main_panel.add(name_Label);
        name_Label.setFont(new Font(SERIF,Font.BOLD,30));


        name=new JTextField();
        name.setBounds(200,470,300,40);
        main_panel.add(name);




        Phone_Number_Label= new JLabel("Phone Number");
        Phone_Number_Label.setForeground(Color.white);
        Phone_Number_Label.setBounds(650,400,200,40);
        Phone_Number_Label.setFont(new Font(SERIF,Font.BOLD,30));
        main_panel.add(Phone_Number_Label);


        Phone_Number=new JTextField();
        Phone_Number.setBounds(650,470,300,40);
        main_panel.add(Phone_Number);




        checkin_date_Label= new JLabel("Check in date");
        checkin_date_Label.setForeground(Color.white);
        checkin_date_Label.setBounds(1100,400,200,40);
        checkin_date_Label.setFont( new Font(SERIF,Font.BOLD,30));
        main_panel.add(checkin_date_Label);


        checkin_date_text_Field= new JTextField();
        checkin_date_text_Field.setBounds(1100,470,300,40);
        main_panel.add(checkin_date_text_Field);
        checkin_date_text_Field.setEditable(false);

        email= new JLabel("Email");
        email.setForeground(Color.white);
        email.setBounds(200,550,150,40);
        email.setFont(new Font(SERIF,Font.BOLD,30));
        main_panel.add(email);

        email_textfield= new JTextField();
        email_textfield.setBounds(200,620,300,40);
        email_textfield.setFont(new Font(SERIF,Font.BOLD,20));
        main_panel.add(email_textfield);


        checkout_date_Label= new JLabel("Check out date (Today)");
        checkout_date_Label.setForeground(Color.white);
        checkout_date_Label.setBounds(650,550,300,40);
        checkout_date_Label.setFont(new Font(SERIF,Font.BOLD,30));
        main_panel.add(checkout_date_Label);

        
        checkout_date_Text_Field=new  JTextField();
        checkout_date_Text_Field.setBounds(650,620,300,40);
        main_panel.add( checkout_date_Text_Field);
        SimpleDateFormat myf=new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal=Calendar.getInstance();
        checkout_date_Text_Field.setText(myf.format(cal.getTime()));
        checkout_date_Text_Field.setEditable(false);


        days_Label=new JLabel("Number of days stay");
        days_Label.setForeground(Color.white);
        days_Label.setBounds(1100,550,300,40);
        days_Label.setFont(new Font(SERIF,Font.BOLD,30));
        main_panel.add(days_Label);

        days_Text_Field= new JTextField();
        days_Text_Field.setBounds(1100,620,300,40);
        days_Text_Field.setFont(new Font(SERIF,Font.BOLD,20));
        main_panel.add( days_Text_Field);
        days_Text_Field.setEditable(false);


        Price_Label=new JLabel("Total Price");
        Price_Label.setForeground(Color.white);
        Price_Label.setBounds(1250,800,200,40);
        Price_Label.setFont(new Font(SERIF,Font.BOLD,30));
        main_panel.add(Price_Label);


        Price_textfield=new JTextField();
        Price_textfield.setBounds(1400,800,200,40);
        main_panel.add(Price_textfield);
        Price_textfield.setEditable(false);

        check_out_button= new JButton("Check Out");
        check_out_button.setBounds(500,800,100,40);
        main_panel.add(check_out_button);
        check_out_button.addActionListener(this);


        cancel= new JButton("Cancel");
        cancel.setBounds(650,800,100,40);
        main_panel.add(cancel);
        cancel.addActionListener(this);


        button_panel.repaint();
        main_panel.repaint();
        DBconnection();
    }



    public void DBconnection()
    {
        try{
            con=DriverManager.getConnection("jdbc:ucanaccess://c://Users//Hasan Yagout//Desktop//Hotel_Management_System.accdb");

            JOptionPane.showMessageDialog(null,"You Are Connected");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
     public static void main(String[] args) {
        Check_Out check_out= new Check_Out();
      //  check_out.DBconnection();
       // check_out.createTable();
       check_out.setVisible(true);
       // check_out.tableCreateCheckOut();
           //  check_out.createTableAllcus();
       
    }




 public void showData()
      {
          try
          {
              
              String name11=search_Text_Field.getText();
              String sql  = "SELECT * FROM Check_in WHERE name = '"+name11+"';";
              st = con.createStatement();
              ResultSet result = st.executeQuery(sql);
              while(result.next())
              {
                  name.setText(result.getString(1));
                  Phone_Number.setText(result.getString("Phone_Number"));
                  checkin_date_text_Field.setText(result.getString("check_in_date"));
                  
                  
                    JOptionPane.showMessageDialog(null,result.getString("name")+" "+result.getString("address"));
              }
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }}
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if (e.getSource()==check_in)
                {
                    
                    setVisible(false);
                     Check_In check_in= new Check_In();
                     check_in.setVisible(true);
                     

                }
                 
            else if (e.getSource() == manage_rooms) {
            setVisible(false);
            Manage_Rooms manage_rooms= new Manage_Rooms();
           // manage_rooms.setVisible(true);
        }
        
               else if (e.getSource() == cusInformation) {
            setVisible(false);
             TablesPanal tablesPanal =new TablesPanal();
            tablesPanal.setVisible(true);
        }
            
         if (e.getSource()==exit)
        {
              
             setVisible(false);
            Main_Window main_window= new Main_Window();
            main_window.setVisible(true);
          

        }
                if (e.getSource()==search)
                {
                    
          try{
              
              String roomnum =search_Text_Field.getText();
              String sql  = "SELECT * FROM check_in1 WHERE Room_number = '"+roomnum+"';";
              st = con.createStatement();
              ResultSet result = st.executeQuery(sql);
              while(result.next())
              {
                  name.setText(result.getString("Name"));
                  Phone_Number.setText(result.getString("Phone_number"));
                  checkin_date_text_Field.setText(result.getString("check_in_date"));
                  email_textfield.setText(result.getString(11));
                 //
                  SimpleDateFormat myformat=new SimpleDateFormat("yyyy/MM/dd");
                  Calendar cal =Calendar.getInstance();

                  checkout_date_Text_Field.setText(myformat.format(cal.getTime()));

                    String datebeforestring=result.getString(10);

                  Date datebefore=myformat.parse(datebeforestring);

                  String dateafterstring=myformat.format(cal.getTime());
                  Date dateafter=myformat.parse(dateafterstring);
                  long difference=dateafter.getTime() - datebefore.getTime() ;
                  int nodays=(int) (difference/(1000*60*60*24));
                  if (nodays==0)
                  {
                      nodays=1;
                  }
                      days_Text_Field.setText(String.valueOf(nodays));
                      float price=Float.parseFloat(result.getString(9));
                      Price_textfield.setText(String.valueOf(nodays*price));

                  //}
                 //
                  
              }
          }
          catch(Exception ee)
          {
              ee.printStackTrace();
          }}



        if (e.getSource()==log_out)
        {
            int choice=JOptionPane.showConfirmDialog(null,"do you want to log out","confirm",JOptionPane.YES_NO_OPTION);
            if (choice==JOptionPane.YES_OPTION)
            {
                setVisible(false);
                Login login= new Login();
                login.setVisible(true);

            }
        }
                
                
                if (e.getSource()==check_out_button)
                {

                    try
        {
         
           String sql="INSERT into checkOut1 values(?,?,?,?,?,?)";
           ps=con.prepareStatement( sql);
           ps.setString(1, name.getText());
           ps.setString(2, Phone_Number.getText());
           ps.setString(3, email_textfield.getText());
           ps.setString(4,checkin_date_text_Field.getText() );
           ps.setString(5, checkout_date_Text_Field.getText());
           ps.setString(6,Price_textfield.getText() );
                
            ps.execute();
            
   
            JOptionPane.showMessageDialog(null,"values add to checkOut1");
            
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
                  
            try
        {
             String roomnum=search_Text_Field.getText();
              String name11=name.getText();
               String checkoutdate=checkout_date_Text_Field.getText();
               String priceUPD=Price_textfield.getText();
            String sql = "UPDATE customer1 SET Activaton = 'Not active' ,check_out_date = '"+checkoutdate+"' , Price='"+priceUPD+"'  WHERE Name ='"+name11+"' and Room_number =  '"+roomnum+"';";
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"One Row has  Updated in customer1");
            
            String s="update Rooms set status ='unbooked' where room_number='"+roomnum+"'";        
            st.executeUpdate(s);
            JOptionPane.showMessageDialog(null,"One Row Updated in rooms");
      
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
                       

            try
        {
            String roomnum=search_Text_Field.getText();
            String sql = "DELETE * from  check_in1   WHERE Room_number =  '"+roomnum+"';";
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"One Row Deleted in check_1n1" );

            
        }
        catch(Exception eee)
        {
           eee.printStackTrace();
        }

                }
                    
                    
                    
                

                
                if (e.getSource()==cancel)
                {
                    search_Text_Field.setText("");
                    name.setText("");
                    Phone_Number.setText("");
                    email_textfield.setText("");
                    days_Text_Field.setText("");
                    checkout_date_Text_Field.setText("");
                    checkin_date_text_Field.setText("");
                    Price_textfield.setText("");
                    email_textfield.setText("");
                }

    }


   
    
        public void createImage(String str) {
        URL url = getClass().getResource(str);
        try {
            BufferedImage image = ImageIO.read(url);
            label.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            e.printStackTrace();


        }

    }
}
