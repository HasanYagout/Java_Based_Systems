import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Sign_Up extends JFrame implements ActionListener {
JLabel username,password;
JTextField username_text_field;
JPasswordField password_text_field;
JButton add,cancel;
Connection con;
Statement st;
PreparedStatement ps;

    public Sign_Up()
    {
        setVisible(true);
        setSize(600,700);
        setLayout(null);

        username= new JLabel("username");
        username.setBounds(30,150,150,40);
        username.setFont(new Font(Font.SERIF,Font.BOLD,30));
        add(username);
        username_text_field= new JTextField();
        username_text_field.setBounds(200,150,300,40);
        username_text_field.setFont(new Font(Font.SERIF,Font.BOLD,30));
        add(username_text_field);

        password= new JLabel("password");
        password.setBounds(30,300,200,40);
        password.setFont(new Font(Font.SERIF,Font.BOLD,30));
        add(password);

        password_text_field= new JPasswordField();
        password_text_field.setBounds(200,300,300,40);
        password_text_field.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(password_text_field);
        add= new JButton("add");
        add.setBounds(100,400,100,40);
        add(add);
        add.addActionListener(this);
        cancel= new JButton("cancel");
        cancel.setBounds(250,400,100,40);
        add(cancel);
        repaint();
    }

    public void DBconnection()
    {
        try
        {
            con=DriverManager.getConnection("jdbc:ucanaccess://c://Users//Hasan Yagout//Desktop//Hotel_Management_System.accdb");
            JOptionPane.showMessageDialog(null,"you are connected");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }






    public static void main(String[] args) {
        Sign_Up sign_up= new Sign_Up();
        sign_up.DBconnection();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add)
        {
            try{
                manage_users manage_users = new manage_users();
                String sql= "insert into users values(?,?,?)";
                ps=con.prepareStatement( sql);
                ps.setString(1,username_text_field.getText());
                ps.setString(2,password_text_field.getText());
                ps.setString(3,"false");
                ps.execute();
                manage_users.adding(username_text_field.getText(),password_text_field.getText(),"false");
                JOptionPane.showMessageDialog(null,"wait for admin approval");
            }
            catch (Exception ee)
            {
                ee.printStackTrace();
            }
        }
    }
}
