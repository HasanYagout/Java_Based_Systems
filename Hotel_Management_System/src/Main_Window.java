import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;


public class Main_Window extends JFrame implements ActionListener {
    JButton check_in, check_out, manage_rooms, log_out, exit,cusInformation;
    ImageIcon imageIcon;
    JLabel label;
    JPanel main_panel,button_panel;
        Statement st;
        Connection con;

    public Main_Window() {

        setLayout(null);
        setSize(1920,1080);
        setTitle("Main Window");
        button_panel= new JPanel(null);
        button_panel.setBounds(0,0,1920,150);

        main_panel= new JPanel(null);
        main_panel.setBounds(0,0,1920,1080);
        add(main_panel);
        button_panel.setBackground(new Color(213, 134, 145, 0));
        main_panel.add(button_panel);
        label= new JLabel();
        label.setBounds(0,0,1920,1080);
        main_panel.add(label);
        createImage("background4.jpg");





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
        log_out.setBounds(1500, 10, 200, 100);
        log_out.setBackground(Color.white);
        button_panel.add(log_out);
        log_out.addActionListener(this);

        Icon exit_Icon = new ImageIcon("exit.png");
        exit = new JButton(exit_Icon);
        exit.setBounds(1750, 10, 95, 100);
        exit.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        button_panel.add(exit);
        exit.addActionListener(this);
        
         cusInformation = new JButton("custumer infor"/*, cusInformation_Icon*/);
        cusInformation.setBackground(Color.white);
        cusInformation.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        cusInformation.setBounds(760, 10, 250, 100);
        button_panel.add(cusInformation);
        cusInformation.addActionListener(this);
        setUndecorated(true);
        DBconnection();
        createTablemanagerooms();
        tableCreatecheckIn();
        tableCreatecheckout1();
        tableCreatecustumers1();



    }
    public void DBconnection(){
        try
        {
            con= DriverManager.getConnection("jdbc:ucanaccess://c://Users//Hasan Yagout//Desktop//Hotel_Management_System.accdb");
            JOptionPane.showMessageDialog(null,"you are cannected");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void createTablemanagerooms()
    {
        try
        {
            String str="create table Rooms(room_number int, room_type text, bed_type text, price int, status text )";
            st=con.createStatement();
            st.execute(str);
            JOptionPane.showMessageDialog(null,"table created");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void tableCreatecheckIn(){
        try
        {
            String sql="Create table check_in1( Id int ,Name text,Address text, Id_proof text, Phone_number int, Nationality text, Gender text, room_type text, bed_type text, Price number, check_in_date text , Email text ,Activaton text,Room_number text )";
            st=con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null,"table created");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //
    public void tableCreatecustumers1(){
        try
        {
            String sql="Create table customer1( Id int ,Name text,Address text, Id_proof text, Phone_number int, Nationality text, Gender text, room_type text, bed_type text, Price number, check_in_date text ,check_out_date text , Email text ,Activaton text,Room_number text )";
            st=con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null,"table created");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //
    public void tableCreatecheckout1(){
        try
        {
            String sql="Create table checkOut1( Name text,Phone_Number int,Email text,chickindate text,chickoutdate text,Price number )";
            st=con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null,"table created checkOut1");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check_in) {

            setVisible(false);
            Check_In check_in = new Check_In();
            check_in.setVisible(true);

        } else if (e.getSource() == check_out) {
            setVisible(false);
            Check_Out check_out = new Check_Out();
            check_out.setVisible(true);
        }
               
            else if (e.getSource() == manage_rooms) {
            setVisible(false);
            Manage_Rooms manage_rooms= new Manage_Rooms();
           // manage_rooms.setVisible(true);
        }
            if (e.getSource()==exit)
            {
                int choice=JOptionPane.showConfirmDialog(null,"do you want to close the program","confirm",JOptionPane.YES_NO_OPTION);
                if (choice==JOptionPane.YES_OPTION)
                {
                    setVisible(false);
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
        
          else if (e.getSource() == cusInformation) {
            setVisible(false);
             TablesPanal tablesPanal =new TablesPanal();
            tablesPanal.setVisible(true);
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
