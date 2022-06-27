import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JLabel usernameLabel;
    JButton login;
    JLabel passwordLabel;
    JTextField username;
    JTextField password;
    Connection con;
    Statement st;
    PreparedStatement ps;


    public Login() {
        setVisible(true);
        setLayout(null);
        setSize(1000, 1000);
        usernameLabel = new JLabel("User Name");
        usernameLabel.setBounds(180, 400, 100, 40);
        add(usernameLabel);
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(180, 450, 100, 40);
        add(passwordLabel);
        username = new JTextField();
        username.setBounds(250, 400, 400, 40);
        add(username);
        password = new JPasswordField();
        password.setBounds(250, 450, 400, 40);
        add(password);
        login = new JButton("Login");
        login.setBounds(250, 500, 100, 40);
        add(login);
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(550, 500, 100, 40);
        add(cancel);
        login.addActionListener(this);
        repaint();
//        createdatabase();
        DBconnection();
        createtable();
        adduser();

    }

    public void createdatabase()
    {
        try
        {
            FileWriter fileWriter= new FileWriter("c:\\Users\\Hasan Yagout\\Desktop\\Hotel_Management_System.accdb");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void DBconnection() {
        try {
            con=DriverManager.getConnection("jdbc:ucanaccess://c://Users//Hasan Yagout//Desktop//Hotel_Management_System.accdb");
            JOptionPane.showMessageDialog(null, "You Are Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void createtable()
{
    try
    {
        String sql= "create table Users(username text, password text ,status text)";
        st=con.createStatement();
        st.execute(sql);
        JOptionPane.showMessageDialog(null,"connected");
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

}

  public void adduser()
  {
      try
      {
          String sql= "insert into Users values('hasan','123','true')";
          ps=con.prepareStatement( sql);
          JOptionPane.showMessageDialog(null,"added");
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }

  }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==login)
        {
            try{
                String sql  = "SELECT * FROM users";
                st = con.createStatement();
                ResultSet result = st.executeQuery(sql);
                while(result.next())
                {
                    String user=result.getString(1);
                    String pass=result.getString(2);
                    String stat=result.getString(3);
                    JOptionPane.showMessageDialog(null,"done getting from database");
                    Users_Con user1= new Users_Con(user,pass,stat);
                    if (user1.username.equals(username.getText())&&user1.password.equals(password.getText())&&user1.status.equals("true"))
                    {
                        JOptionPane.showMessageDialog(null,"you are valid");
                        Main_Window main_window= new Main_Window();
                        main_window.setVisible(true);
                    }
                }
            }
            catch (Exception ee)
            {
                ee.printStackTrace();
            }

        }
    }
}