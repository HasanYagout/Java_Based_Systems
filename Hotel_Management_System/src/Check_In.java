
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.SERIF;
import java.sql.Date;
import java.awt.image.BufferedImage;
import java.lang.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class Check_In extends JFrame implements ActionListener  {


    String strDate;
    JDatePickerImpl datePciker;
    SqlDateModel model;
    Properties ppp;
    JLabel chickD_label,Price_Label,name_Label,Phone_Number_Label,Address_Label,room_label,Nationality_Label,ID_Proof_Label,Bed_Label,Room_Type_Label,Gender_Label,label;
    JTextField checkIntext,Price_textfield, name,Phone_Number,Address,email_textfield;
    JComboBox Nationality,ID_Proof,Gandercombobox,Room_typecombobox,Bed_typecombobox,room_combobox;

    JButton Save,Reset,exit,check_in,check_out,manage_rooms,log_out,cusInformation;
    JPanel background_panel,main_panel,button_panel;
    JLabel email;
    String ID_Proof_Type[]={"","Passport","Personal ID","Driving License"};
    String Gander[]={"","Male","Female"};
    String room[]={"","AC","No Ac"};
    String bed[]={"","Single","Double"};
    int pricee;
    Date date;
    String Countries[]={"","Afghan", "Albanian",
            "Algerian",
            "Andorran",
            "Angolan",
            "Argentinian",
            "Armenian",
            "Australian",
            "Austrian",
            "Azerbaijani",
            "Bahamian",
            "Bahraini",
            "Bangladeshi",
            "Barbadian",
            "Belarusian",
            "Belgian",  "Belizean",
            "Beninese",
            "Bhutanese",
            "Bolivian",
            "Bosnian",
            "Botswanan",
            "Brazilian",
            "British",
            "Bruneian",
            "Bulgarian",
            "Burkinese",
            "Burmese",
            "Burundian",
            "Cambodian",
            "Cameroonian",
            "Canadian",
            "Cape Verdean",
            "Chadian",
            "Chilean",
            "Chinese",
            "Colombian",
            "Congolese",
            "Costa Rican",
            "Croatian",
            "Cuban",
            "Cypriot",
            "Czech",
            "Danish",
            "Djiboutian",
            "Dominican",
            "Dutch",
            "Ecuadorean",
            "Egyptian",
            "Emirati",
            "English",
            "Eritrean",
            "Estonian",
            "Ethiopian",
            "Fijian",
            "Finnish",
            "French",
            "Gabonese",
            "Gambian",
            "Georgian",
            "German",
            "Ghanaian",
            "Greek",
            "Grenadian",
            "Guatemalan",
            "Guinean",
            "Guyanese",
            "Haitian",
            "Honduran",
            "Hungarian",
            "Icelandic",
            "Indian",
            "Indonesian",
            "Iranian",
            "Iraqi",
            "Irish",
            "Italian",
            "Jamaican",
            "Japanese",
            "Jordanian",
            "Kazakh",
            "Kenyan",
            "Kuwaiti",
            "Laotian",
            "Latvian",
            "Lebanese",
            "Liberian",
            "Libyan",
            "Lithuanian",
            "Malagasy",
            "Malawian",
            "Malaysian",
            "Maldivian",
            "Malian",
            "Maltese",
            "Mauritanian",
            "Mauritian",
            "Mexican",
            "Moldovan",
            "MonÃ©gasque",
            "Mongolian",
            "Montenegrin",
            "Moroccan",
            "Mozambican",
            "Namibian",
            "Nepalese",
            "New Zealand",
            "Nicaraguan",
            "Nigerian",
            "Nigerien",
            "North Korean",
            "Norwegian",
            "Omani",
            "Pakistani",
            "Panamanian",
            "Guinean",
            "Paraguayan",
            "Peruvian",
            "Filipino",
            "Polish",
            "Portuguese",
            "Qatari",
            "Romanian",
            "Russian",
            "Rwandan",
            "Salvadorean",
            "Saudi",
            "Scottish",
            "Senegalese",
            "Serbian",
            "Seychellois",
            "Sierra Leonian",
            "Singaporean",
            "Slovak",
            "Slovenian",
            "Somali",
            "South African",
            "South Korean",
            "Spanish",
            "Sri Lankan",
            "Sudanese",
            "Surinamese",
            "Swazi",
            "Swedish",
            "Swiss",
            "Syrian",
            "Taiwanese",
            "Tajik",
            "Tanzanian",
            "Thai",
            "Togolese",
            "Trinidadian",
            "Tobagan",
            "Tobagonian",
            "Tunisian",
            "Turkish",
            "Turkmen",
            "Tuvaluan",
            "Ugandan",
            "Ukrainian",
            "Uruguayan",
            "US",
            "Uzbek",
            "Vanuatuan",
            "Venezuelan",
            "Vietnamese",
            "Welsh",
            "Western Samoan",
            "Yemeni",
            "Yugoslav",
            "ZaÃ¯rean",
            "Zambian",
            "Zimbabwean"
    };



    Connection con;
    Statement st;
    ResultSet result;
    PreparedStatement ps;
    public Check_In() {
        setVisible(true);
        setLayout(null);
        setTitle("Check In");
        setSize(1920, 1080);
        setTitle("Check In");

        background_panel = new JPanel(null);
        background_panel.setBounds(0, 0, 1920, 1080);
        add(background_panel);

        button_panel = new JPanel(null);
        button_panel.setBounds(0, 0, 1920, 150);
        background_panel.add(button_panel);

        main_panel = new JPanel(null);
        main_panel.setBounds(0, 0, 1920, 1080);

        background_panel.add(main_panel);

//        setUndecorated(true);

        label = new JLabel();
        label.setBounds(0, 0, 1920, 1080);
        background_panel.add(label);
        main_panel.setBackground(new Color(213, 134, 145, 0));
        button_panel.setBackground(new Color(213, 134, 145, 0));
        createImage("background10.jpg");

        Icon checkin_Icon = new ImageIcon("checkIn.png");
        check_in = new JButton("Check in", checkin_Icon);
        check_in.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        check_in.setBackground(Color.white);
        check_in.setBounds(20, 10, 200, 100);
        button_panel.add(check_in);
        check_in.addActionListener(this);


        Icon checkout_Icon = new ImageIcon("checkout.png");
        check_out = new JButton("checkout", checkout_Icon);
        check_out.setBounds(250, 10, 200, 100);
        check_out.setBackground(Color.white);
        check_out.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        button_panel.add(check_out);
        check_out.addActionListener(this);

        Icon managerooms_Icon = new ImageIcon("managerooms.png");
        manage_rooms = new JButton("manage rooms", managerooms_Icon);
        manage_rooms.setBackground(Color.white);
        manage_rooms.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        manage_rooms.setBounds(480, 10, 250, 100);
        button_panel.add(manage_rooms);
        manage_rooms.addActionListener(this);


        Icon logout_Icon = new ImageIcon("logout.png");
        log_out = new JButton("logout", logout_Icon);
        log_out.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        log_out.setBounds(1500, 10, 200, 95);
        log_out.setBackground(Color.white);
        button_panel.add(log_out);
        log_out.addActionListener(this);


        Icon exit_Icon = new ImageIcon("exit.png");
        exit = new JButton(exit_Icon);
        exit.setBounds(1750, 10, 95, 95);
        exit.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        button_panel.add(exit);
        exit.addActionListener(this);

        cusInformation = new JButton("custumer infor"/*, cusInformation_Icon*/);
        cusInformation.setBackground(Color.white);
        cusInformation.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        cusInformation.setBounds(760, 10, 250, 100);
        button_panel.add(cusInformation);
        cusInformation.addActionListener(this);


        name_Label = new JLabel("Name");
        name_Label.setBounds(200, 300, 100, 40);
        name_Label.setForeground(Color.white);
        main_panel.add(name_Label);
        name_Label.setFont(new Font(SERIF, Font.BOLD, 30));


        name = new JTextField();
        name.setBounds(350, 300, 200, 40);
        main_panel.add(name);

        email = new JLabel("Email");
        email.setForeground(Color.white);
        email.setBounds(200, 450, 150, 40);
        email.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(email);

        email_textfield = new JTextField(40);
        email_textfield.setBounds(350, 450, 200, 40);
        email_textfield.setFont(new Font(SERIF, Font.BOLD, 20));
        main_panel.add(email_textfield);


        checkIntext = new JTextField();
        checkIntext.setBounds(650, 200, 200, 40);
        main_panel.add(checkIntext);
        SimpleDateFormat myformat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        checkIntext.setText(myformat.format(cal.getTime()));
        checkIntext.setEditable(false);


//

        chickD_label = new JLabel("chick in date");
        chickD_label.setForeground(Color.white);
        chickD_label.setBounds(650, 200, 200, 40);
        chickD_label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(chickD_label);


        Phone_Number_Label = new JLabel("Phone Number");
        Phone_Number_Label.setForeground(Color.white);
        Phone_Number_Label.setBounds(650, 300, 200, 40);
        Phone_Number_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Phone_Number_Label);


        Phone_Number = new JTextField();
        Phone_Number.setBounds(900, 300, 200, 40);
        main_panel.add(Phone_Number);

        Address_Label = new JLabel("Address");
        Address_Label.setForeground(Color.white);
        Address_Label.setBounds(1250, 300, 150, 40);
        Address_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Address_Label);


        Address = new JTextField();
        Address.setBounds(1400, 300, 200, 40);
        main_panel.add(Address);


        Nationality_Label = new JLabel("Nationality");
        Nationality_Label.setForeground(Color.white);
        Nationality_Label.setBounds(650, 450, 200, 40);
        Nationality_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Nationality_Label);


        Nationality = new JComboBox<>(Countries);
        Nationality.setBounds(900, 450, 200, 40);
        Nationality.setFont(new Font(SERIF, Font.BOLD, 20));
        main_panel.add(Nationality);


        Gender_Label = new JLabel("Gender");
        Gender_Label.setForeground(Color.white);
        Gender_Label.setBounds(1250, 450, 100, 40);
        Gender_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Gender_Label);

        Gandercombobox = new JComboBox<>(Gander);
        Gandercombobox.setBounds(1400, 450, 200, 40);
        Gandercombobox.setFont(new Font(SERIF, Font.BOLD, 20));
        main_panel.add(Gandercombobox);

        Room_Type_Label = new JLabel("Room Type");
        Room_Type_Label.setForeground(Color.white);
        Room_Type_Label.setBounds(200, 600, 150, 40);
        Room_Type_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Room_Type_Label);

        Room_typecombobox = new JComboBox<>(room);
        Room_typecombobox.setBounds(350, 600, 200, 40);
        Room_typecombobox.setFont(new Font(SERIF, Font.BOLD, 20));
        main_panel.add(Room_typecombobox);
        Room_typecombobox.addActionListener(this);


        Bed_Label = new JLabel("Bed Type");
        Bed_Label.setForeground(Color.white);
        Bed_Label.setBounds(650, 600, 150, 40);
        Bed_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Bed_Label);

        Bed_typecombobox = new JComboBox<>(bed);
        Bed_typecombobox.setBounds(900, 600, 200, 40);
        Bed_typecombobox.setFont(new Font(SERIF, Font.BOLD, 20));
        main_panel.add(Bed_typecombobox);
        Bed_typecombobox.addActionListener(this);

        ID_Proof_Label = new JLabel("ID Proof");
        ID_Proof_Label.setForeground(Color.white);
        ID_Proof_Label.setBounds(1250, 600, 200, 40);
        ID_Proof_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(ID_Proof_Label);

        ID_Proof = new JComboBox<>(ID_Proof_Type);
        ID_Proof.setBounds(1400, 600, 200, 40);
        ID_Proof.setFont(new Font(SERIF, Font.BOLD, 20));
        main_panel.add(ID_Proof);


        Price_Label = new JLabel("Price");
        Price_Label.setForeground(Color.white);
        Price_Label.setBounds(1250, 800, 100, 40);
        Price_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Price_Label);

        Price_textfield = new JTextField();
        Price_textfield.setBounds(1400, 800, 200, 40);
        main_panel.add(Price_textfield);

        room_label = new JLabel("room");
        room_label.setForeground(Color.white);
        room_label.setBounds(800, 800, 100, 40);
        room_label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(room_label);

        room_combobox = new JComboBox();
        room_combobox.setBounds(950, 800, 200, 40);
        main_panel.add(room_combobox);
        room_combobox.addActionListener(this);

        Save = new JButton("Save");
        Save.setBounds(200, 800, 200, 60);
        Save.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Save);
        Save.addActionListener(this);

        Reset = new JButton("Reset");
        Reset.setBounds(500, 800, 200, 60);
        Reset.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Reset);
        Reset.addActionListener(this);

        button_panel.repaint();
        main_panel.repaint();
        DBconnection();

    }


    public void DBconnection(){
        try
        {
  con=DriverManager.getConnection("jdbc:ucanaccess://c://Users//Hasan Yagout//Desktop//Hotel_Management_System.accdb");
  JOptionPane.showMessageDialog(null,"you are cannected");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    

     //
   
    //
     public void deleteRecord()
    {
        try
        {
            String sql = "DELETE * FROM Rooms ";
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"One Row Deleted");

            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void showrooms()
    {
        try
        {
            String room_type=Room_typecombobox.getSelectedItem().toString();
            String bed_type=Bed_typecombobox.getSelectedItem().toString();
            String rooms[]=new String[100];
            String sql="select room_number from Rooms where room_type='"+room_type+"'and bed_type= '"+bed_type+"' and status='unbooked' ";
            st = con.createStatement();
            ResultSet result = st.executeQuery(sql);



            while (result.next())
            {
                room_combobox.addItem(result.getString(1));
             
            }


        }
            catch (Exception e)
            {
               e.printStackTrace();
             }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit)
        {
            setVisible(false);
            Main_Window main_window= new Main_Window();
            main_window.setVisible(true);


        }

        if (e.getSource() == check_in) {

            setVisible(false);
            Check_In check_in = new Check_In();
            check_in.setVisible(true);

        }
        if (e.getSource() == check_out) {
            setVisible(false);
            Check_Out check_out = new Check_Out();
            check_out.setVisible(true);
        }
        if (e.getSource()==manage_rooms)
        {
            setVisible(false);
            Manage_Rooms manage_rooms= new Manage_Rooms();
            manage_rooms.setVisible(true);
        }
             if (e.getSource() == cusInformation) {
            setVisible(false);
             TablesPanal tablesPanal =new TablesPanal();
            tablesPanal.setVisible(true);
        }
        
        if (e.getSource()==Bed_typecombobox )
        {
            showrooms();
        }
        if (e.getSource()==Room_typecombobox)
        {
            showrooms();
        } 
        
        if (e.getSource()==room_combobox)
        {
            String roomnum= (String) room_combobox.getSelectedItem();
            try
            {
                String sql  = "SELECT * FROM Rooms WHERE room_number = '"+roomnum+"';";
                st = con.createStatement();
                ResultSet result = st.executeQuery(sql);
                while (result.next())
                {
                    Price_textfield.setText(result.getString(4));
                }
            }
            catch (Exception ee)
            {
                ee.printStackTrace();
            }
        }

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
        if (e.getSource()==Save)
        {
//
            

             String Activation="Actived";   
             try
           
            {
                
               
           String sql="INSERT into customer1  (Name ,Address , Id_proof , Phone_number , Nationality , Gender , room_type , bed_type , Price , check_in_date ,check_out_date , Email  ,Activaton ,Room_number ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           ps=con.prepareStatement( sql);
           ps.setString(1, name.getText());
           ps.setString(2, Address.getText());
           ps.setString(3, (String) ID_Proof.getSelectedItem());
           ps.setString(4, Phone_Number.getText());
           ps.setString(5, (String) Nationality.getSelectedItem());
           ps.setString(6, (String) Gandercombobox.getSelectedItem());
           ps.setString(7, (String) Room_typecombobox.getSelectedItem());
           ps.setString(8, (String) Bed_typecombobox.getSelectedItem());
           ps.setString(9,Price_textfield.getText());
           ps.setString(10,checkIntext.getText());
           ps.setString(11," ");
           ps.setString(12, email_textfield.getText());
           ps.setString(13, Activation);
           ps.setString(14, (String) room_combobox.getSelectedItem());
                 
           ps.execute();
            
   
              JOptionPane.showMessageDialog(null,"values add into custumers11");

            }
            catch(Exception ee){
                ee.printStackTrace();
            }

            //
            
            
         
          
           try
         
            {
                
               
           String sql="INSERT into check_in1 (Name ,Address , Id_proof , Phone_number , Nationality , Gender , room_type , bed_type , Price , check_in_date  , Email  ,Activaton ,Room_number ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
           ps=con.prepareStatement( sql);
           ps.setString(1, name.getText());
           ps.setString(2, Address.getText());
           ps.setString(3, (String) ID_Proof.getSelectedItem());
           ps.setString(4, Phone_Number.getText());
           ps.setString(5, (String) Nationality.getSelectedItem());
           ps.setString(6, (String) Gandercombobox.getSelectedItem());
           ps.setString(7, (String) Room_typecombobox.getSelectedItem());
           ps.setString(8, (String) Bed_typecombobox.getSelectedItem());
           ps.setString(9,Price_textfield.getText());
           ps.setString(10,checkIntext.getText());   
           ps.setString(11, email_textfield.getText());
           ps.setString(12, Activation);
           ps.setString(13, (String) room_combobox.getSelectedItem());
           
           String roomnumber=(String) room_combobox.getSelectedItem();
           String s="update Rooms set status ='booked' where room_number='"+roomnumber+"'";
           st=con.createStatement();
           st.executeUpdate(s);
           JOptionPane.showMessageDialog(null,"room updated");
           ps.execute();
            
           JOptionPane.showMessageDialog(null,"values add into checkin1");
             
            }
            catch(Exception ee){
                ee.printStackTrace();
            }
//
          
        }
       // 
         if (e.getSource()==Reset){
           
            setVisible(false);
            Check_In cc= new Check_In();
            
        }

    }
    
    //
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
