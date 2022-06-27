
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
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAMON ALMASWRI
 */
public class TablesPanal extends JFrame implements ActionListener {
    
    JButton exit, check_in, check_out, manage_rooms, log_out, cancel, add_button,cusInformation;
    JPanel contentPane,contentPane2,contentPane3 ;
   JTable table ,table2;
   JLabel label;
   Connection con;
    PreparedStatement pe;
    Statement st;
    public  TablesPanal()
    {
         setSize(1920,1080);
        setVisible(true);
        setLayout(null);
        
      /*  
        background_panel= new JPanel(null);
        background_panel.setBounds(0,0,1920,1080);
        add(background_panel);

        button_panel= new JPanel(null);
        button_panel.setBounds(0,0,1920,150);
        background_panel.add(button_panel);

        main_panel= new JPanel(null);
        main_panel.setBounds(0,0,1920,1080);

        background_panel.add(main_panel);

//        setUndecorated(true);

        label= new JLabel();
        label.setBounds(0,0,1920,1080);
        background_panel.add(label);
        main_panel.setBackground(new Color(213, 134, 145, 0));
        button_panel.setBackground(new Color(213, 134, 145, 0));
        createImage("background10.jpg");

        Icon checkin_Icon= new ImageIcon("img/checkIn.png");
        check_in=new JButton("Check in",checkin_Icon);
        check_in.setFont(new Font(Font.SERIF,Font.BOLD,20));
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


        Icon logout_Icon= new ImageIcon("img/logout.png");
        log_out=new JButton("logout",logout_Icon);
        log_out.setFont(new Font(Font.SERIF,Font.BOLD,20));
        log_out.setBounds(1500,10,200,95);
        log_out.setBackground(Color.white);
        button_panel.add(log_out);

        Icon exit_Icon= new ImageIcon("img/exit.png");
        exit= new JButton(exit_Icon);
        exit.setBounds(1750,10,95,95);
        exit.setFont(new Font(Font.SERIF,Font.BOLD,30));
        button_panel.add(exit);
        exit.addActionListener(this);
*/
      
        
        
        
        
        //setSize(1500,1500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setBounds(100,100,1500,1500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
       
        //
       
        
        
        
        //
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        tabbedPane.setBounds(600, 250, 1100, 600);
        contentPane.add(tabbedPane);
        //add(contentPane);
        JPanel panel = new JPanel();
        panel.setLayout(null);
       //panel.setSize(1100, 800);
        tabbedPane.addTab(" custumer detales", null,panel,null);
        
        
            
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("Name");
         model.addColumn("Address");
          model.addColumn("Id_Proof");
           model.addColumn("Phone_number");
            model.addColumn("Nationality");
             model.addColumn("Gander");
              model.addColumn("Room_type");
               model.addColumn("Bed_type");
                model.addColumn("Price");
                 model.addColumn("Check in date");
            model.addColumn("Check out date");
            model.addColumn("Email");
            model.addColumn("Activation");
            model.addColumn("Room Number");
        
        
            for(Allcustumers list: DBdata.getAllcustumers()){
           
                model.addRow(new Object[]{
                list.getName(),
                list.getAddress(),
                list.getId_Proof(),
                list.getPhone_number(),
                list.getNationality(),
                list.getGander(),
                list.getRoom_type(),
                list.getBed_type(),
                list.getPrice(),
                list.getCheck_in_date(),
                list.getCheck_out_date(),
                list.getEmail(),
                list.getActivation(),
                list.getRoom_number()
                
               
                
                });
                
                
                
                
    }
            
               
                
           
            
            
            
            
       JTable table=new JTable();
        table.setFillsViewportHeight(true);
       
        //table.setCellSelectionEnabled(true);
        table.setBounds(0, 0, 1100 , 600);
         panel.add(table);
     
          //table.setEnabled(false);
       //table.setBackground(Color.LIGHT_GRAY);
        table.setSurrendersFocusOnKeystroke(true);
     
        table.setColumnSelectionAllowed(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
         
      
        table.setRowHeight(30);
       
        
        table.setModel(model);
         
        JScrollPane scrollPane =new  JScrollPane(table);
        
        scrollPane.setBounds(0, 0, 1100, 600);
       
         panel.add(scrollPane);
       
        int rowIndex=40;
          int columnIndex=40;
        boolean includeSpacing=true;
        Rectangle cellRect= table.getCellRect(rowIndex, columnIndex, includeSpacing);
        table.scrollRectToVisible(cellRect);

      
        
        
       
        
        
        
        
        
        
        
        
       
      
       ///////////////////////////////////////
        
       
        JPanel panel2 = new JPanel();
        tabbedPane.addTab("check_in", null,panel2,null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        contentPane2 = new JPanel();
        contentPane2.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane2);
        contentPane2.setLayout(null);
        
        contentPane2.add(tabbedPane);
        
      
        panel2.setLayout(null);
      
      
        
        
            
        DefaultTableModel model2= new DefaultTableModel();
        // model2.addColumn("id");
        model2.addColumn("nNme");
         model2.addColumn("addresss");
          model2.addColumn("id_proof");
           model2.addColumn("Phone_number");
            model2.addColumn("Nationality");
             model2.addColumn("Gander");
              model2.addColumn("Room_type");
               model2.addColumn("Bed_type");
               model2.addColumn("Price");
                 model2.addColumn("check in date");
        
            model2.addColumn("Email");
             model2.addColumn("Activity");
          model2.addColumn("Room_number");
        
            for( Allcheckin list2:DBdata.getAllcheckin()){
           
                model2.addRow(new Object[]{
                
                  list2.getName(),
                    list2.getAddress(),
                    
                list2.getId_Proof(),
                list2.getPhone_number(),
                list2.getNationality(),
                list2.getGander(),
                list2.getRoom_type(),
                list2.getBed_type(),
                 list2.getPrice(),
                list2.getCheck_in_date(),
                
                list2.getEmail(),
                list2.getActivation(),
                list2.getRoom_number()
                
               
                
                });
                
                
                
                
    }
            
               
                
           
            
            
            
            
       JTable table2=new JTable();
        table2.setFillsViewportHeight(true);
       
        //table.setCellSelectionEnabled(true);
        table2.setBounds(0, 0, 1100 , 600);
         panel2.add(table2);
          //table.setEnabled(false);
       // table.setBackground(Color.LIGHT_GRAY);
        table2.setSurrendersFocusOnKeystroke(true);
      // table.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);
        table2.setColumnSelectionAllowed(true);
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
       // table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table2.setRowHeight(30);
        table2.setModel(model2);
        JScrollPane scrollPane2 =new  JScrollPane(table2);
        scrollPane2.setBounds(0, 0, 1100, 600);
         panel2.add(scrollPane2);
    
        int rowIndex2=40;
          int columnIndex2=40;
        boolean includeSpacing2=true;
        Rectangle cellRect2= table2.getCellRect(rowIndex2, columnIndex2, includeSpacing2);
        table2.scrollRectToVisible(cellRect2);
        
        
        
       ///////////////////////////////////////
        
       
        JPanel panel3 = new JPanel();
        tabbedPane.addTab("check_Out", null,panel3,null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        contentPane3 = new JPanel();
        contentPane3.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane3);
        contentPane3.setLayout(null);
        
        contentPane3.add(tabbedPane);
        
      
        panel3.setLayout(null);
      
      
        
        
            
        DefaultTableModel model3= new DefaultTableModel();
        // model2.addColumn("id");
        model3.addColumn("Name");
         model3.addColumn("Phone_number");
          model3.addColumn("Email");
           model3.addColumn("check_in_date");
            model3.addColumn("check_out_date");
             model3.addColumn("Price");
            
        
        
            for( AllcheckOut list3:DBdata.getAllcheckOut()){
           
                model3.addRow(new Object[]{
                
                  list3.getName(),
                    list3.getPhone_number(),
                    
                list3.getEmail(),
                list3.getCheckindate(),
                list3.getCheckoutdate(),
                list3.getPrice(),
               
               
                
                });
                
                
                
                
    }
            
               
                
           
            
            
            
            
       JTable table3=new JTable();
        table3.setFillsViewportHeight(true);
       
        //table.setCellSelectionEnabled(true);
        table3.setBounds(0, 0, 1100 , 600);
         panel3.add(table3);
          //table.setEnabled(false);
       // table.setBackground(Color.LIGHT_GRAY);
        table3.setSurrendersFocusOnKeystroke(true);
      // table.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);
        table3.setColumnSelectionAllowed(true);
        table3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
       // table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table3.setRowHeight(30);
        table3.setModel(model3);
        JScrollPane scrollPane3 =new  JScrollPane(table3);
        scrollPane3.setBounds(0, 0, 1100, 600);
         panel3.add(scrollPane3);
    
        int rowIndex3=40;
          int columnIndex3=40;
        boolean includeSpacing3=true;
        Rectangle cellRect3= table3.getCellRect(rowIndex3, columnIndex3, includeSpacing3);
        table3.scrollRectToVisible(cellRect3);
        
        
        
        ////////////////////////////////////////////
           Icon checkin_Icon= new ImageIcon("img/checkIn.png");
        check_in=new JButton("Check in",checkin_Icon);
        check_in.setFont(new Font(Font.SERIF,Font.BOLD,20));
        check_in.setBackground(Color.white);
        check_in.setBounds(20,10,200,100);
        add(check_in);
        check_in.addActionListener(this);


        Icon checkout_Icon= new ImageIcon("img/checkout.png");
        check_out= new JButton("checkout",checkout_Icon);
        check_out.setBounds(250,10,200,100);
        check_out.setBackground(Color.white);
        check_out.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(check_out);
    
        check_out.addActionListener(this);

        Icon managerooms_Icon= new ImageIcon("img/managerooms.png");
        manage_rooms=new JButton("manage rooms",managerooms_Icon);
        manage_rooms.setBackground(Color.white);
        manage_rooms.setFont(new Font(Font.SERIF,Font.BOLD,20));
        manage_rooms.setBounds(480,10,250,100);
        add(manage_rooms);
        manage_rooms.addActionListener(this);


        Icon logout_Icon= new ImageIcon("img/logout.png");
        log_out=new JButton("logout",logout_Icon);
        log_out.setFont(new Font(Font.SERIF,Font.BOLD,20));
        log_out.setBounds(1500,10,200,95);
        log_out.setBackground(Color.white);
        add(log_out);
        log_out.addActionListener(this);

        Icon exit_Icon= new ImageIcon("img/exit.png");
        exit= new JButton(exit_Icon);
        exit.setBounds(1750,10,95,95);
        exit.setFont(new Font(Font.SERIF,Font.BOLD,30));
        add(exit);
        exit.addActionListener(this);
         
        
        
        validate();
          repaint();
          
         DBconnection();
}
    
    public void DBconnection() {
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://c://Users//Hasan Yagout//Desktop//Hotel_Management_System.accdb");

            JOptionPane.showMessageDialog(null, "You Are Connected ");
        } catch (Exception e) {
            e.printStackTrace();
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
    public static void main(String[] args) {
        TablesPanal tablesPanal =new TablesPanal();
        
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
           // manage_rooms.setVisible(true);
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
           
        




    }
    
   
}

    