
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import static java.awt.Font.SERIF;

public class Manage_Rooms extends JFrame implements ActionListener {

    JLabel Price_Label, room_type_label, bed_type_Label, label, room_Label;
    JTextField Price_textfield, room_Text_Field;
    JPanel background_panel, main_panel, button_panel, table_panel;

    JButton exit, check_in, check_out, manage_rooms, log_out, cancel, add_button,cusInformation;
    Connection con;
    PreparedStatement pe;
    Statement st;
    JTable table;
    JComboBox room_type_combo, bed_type_combo;
    String room[] = {"", "AC", "No Ac"};
    String bed[] = {"", "Single", "Double"};
    JScrollPane scrollPane;

    public Manage_Rooms() {
        
        setLayout(null);
        setVisible(true);
        setSize(1920, 1080);
        background_panel = new JPanel(null);
        background_panel.setBounds(0, 0, 1920, 1080);
        add(background_panel);

        button_panel = new JPanel(null);
        button_panel.setBounds(0, 0, 1920, 150);
        background_panel.add(button_panel);

        main_panel = new JPanel(null);
        main_panel.setBounds(0, 0, 1920, 1080);

        background_panel.add(main_panel);

        label = new JLabel();
        label.setBounds(0, 0, 1920, 1080);
        background_panel.add(label);
        main_panel.setBackground(new Color(213, 134, 145, 0));
        button_panel.setBackground(new Color(213, 134, 145, 0));
        createImage("background10.jpg");

        Icon checkin_Icon = new ImageIcon("img/checkIn.png");
        check_in = new JButton("Check in", checkin_Icon);
        check_in.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        check_in.setBackground(Color.white);
        check_in.setBounds(20, 10, 200, 100);
        button_panel.add(check_in);
        check_in.addActionListener(this);

        Icon checkout_Icon = new ImageIcon("img/checkout.png");
        check_out = new JButton("checkout", checkout_Icon);
        check_out.setBounds(250, 10, 200, 100);
        check_out.setBackground(Color.white);
        check_out.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        button_panel.add(check_out);
        check_out.addActionListener(this);

        Icon managerooms_Icon = new ImageIcon("img/managerooms.png");
        manage_rooms = new JButton("manage rooms", managerooms_Icon);
        manage_rooms.setBackground(Color.white);
        manage_rooms.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        manage_rooms.setBounds(480, 10, 250, 100);
        button_panel.add(manage_rooms);
        manage_rooms.addActionListener(this);

        Icon logout_Icon = new ImageIcon("img/logout.png");
        log_out = new JButton("logout", logout_Icon);
        log_out.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        log_out.setBounds(1500, 10, 200, 95);
        log_out.setBackground(Color.white);
        button_panel.add(log_out);
        log_out.addActionListener(this);

        Icon exit_Icon = new ImageIcon("img/exit.png");
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



        room_Label = new JLabel("Room Number");
        room_Label.setBounds(200, 250, 200, 40);
        room_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        room_Label.setForeground(Color.white);
        main_panel.add(room_Label);

        room_Text_Field = new JTextField();
        room_Text_Field.setBounds(420, 250, 100, 40);
        room_Text_Field.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(room_Text_Field);

        room_type_label = new JLabel("room type");
        room_type_label.setBounds(200, 400, 200, 40);
        room_type_label.setForeground(Color.white);
        room_type_label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(room_type_label);

        room_type_combo = new JComboBox<>(room);
        room_type_combo.setBounds(200, 470, 300, 40);
        main_panel.add(room_type_combo);

        bed_type_Label = new JLabel("bed type");
        bed_type_Label.setForeground(Color.white);
        bed_type_Label.setBounds(200, 550, 200, 40);
        bed_type_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(bed_type_Label);

        bed_type_combo = new JComboBox<>(bed);
        bed_type_combo.setBounds(200, 620, 300, 40);
        main_panel.add(bed_type_combo);

        Price_Label = new JLabel(" Price");
        Price_Label.setForeground(Color.white);
        Price_Label.setBounds(200, 700, 200, 40);
        Price_Label.setFont(new Font(SERIF, Font.BOLD, 30));
        main_panel.add(Price_Label);

        Price_textfield = new JTextField();
        Price_textfield.setBounds(200, 770, 200, 40);
        main_panel.add(Price_textfield);

        table_panel = new JPanel();
        table_panel.setBounds(700, 300, 800, 400);
        table_panel.add(new JScrollPane(table));
        main_panel.add(table_panel);

        //validate();
        add_button = new JButton("add");
        add_button.setBounds(200, 900, 100, 40);
        main_panel.add(add_button);
        add_button.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBounds(350, 900, 100, 40);
        main_panel.add(cancel);
        cancel.addActionListener(this);

        button_panel.repaint();
        main_panel.repaint();
        // validate();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("room number");
        model.addColumn("room type");
        model.addColumn("bed type");
        model.addColumn("price");
        model.addColumn("status");

        for (Rooms_con list : rooms_info.getrooms()) {

            model.addRow(new Object[]{
                list.getRoom_number(),
                list.getRoom_type(),
                list.getBed_type(),
                list.getPrice(),
                list.getStatus()

            });

        }

       JTable table = new JTable();
        
       table.setCellSelectionEnabled(true);
        table.setBounds(0, 0, 800, 400);
     
        table.setEnabled(false);
        table.setSurrendersFocusOnKeystroke(true);
        table.setColumnSelectionAllowed(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowHeight(30);
        table.setModel(model);
         table_panel.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 800, 400);

        int rowIndex = 40;
        int columnIndex = 40;
        boolean includeSpacing = true;
        Rectangle cellRect = table.getCellRect(rowIndex, columnIndex, includeSpacing);
        table.scrollRectToVisible(cellRect);
        table_panel.add(scrollPane);
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
        Manage_Rooms rooms_data = new Manage_Rooms();
//        rooms_data.createTable();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check_in) {

            setVisible(false);
            Check_In check_in = new Check_In();
            check_in.setVisible(true);

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
        if (e.getSource() == check_out) {
            setVisible(false);
            Check_Out check_out = new Check_Out();
            check_out.setVisible(true);
        }
        if (e.getSource() == manage_rooms) {
            setVisible(false);
            Manage_Rooms rooms_data = new Manage_Rooms();
          //  rooms_data.setVisible(true);
         
        }
        if (e.getSource()==exit)
        {
            setVisible(false);
            Main_Window main_window= new Main_Window();
            main_window.setVisible(true);
        }
     if (e.getSource() == cusInformation) {
            setVisible(false);
             TablesPanal tablesPanal =new TablesPanal();
            tablesPanal.setVisible(true);
        }
        if (e.getSource() == add_button) {

            try {

                String sql = "insert into Rooms values(?,?,?,?,?)";
                pe = con.prepareStatement(sql);
                pe.setString(1, room_Text_Field.getText());
                pe.setString(2, room_type_combo.getSelectedItem().toString());
                pe.setString(3, bed_type_combo.getSelectedItem().toString());
                pe.setString(4, Price_textfield.getText());
                pe.setString(5, "unbooked");
                pe.execute();
                setVisible(false);
                // setVisible(true);
               Manage_Rooms mm = new Manage_Rooms();
                JOptionPane.showMessageDialog(null, "added");

            } catch (Exception w) {
                w.printStackTrace();
            }

            // validate();
            // table.validate();
            // scrollPane.validate();
        }
        if (e.getSource() == cancel) {

        }
    }

}
