

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class manage_users extends JFrame  implements MouseListener{
    JTable table;
    ListSelectionModel selectionModel;
    Connection con;
    PreparedStatement ps;
    JPanel panel;
    public manage_users()
    {
        setVisible(true);
        setSize(700,700);
        addMouseListener(this);
        setLayout(null);
        panel= new JPanel(new GridLayout());
        panel.setBounds(30,40,200,400);
        add(panel);

    }



    public void DBconnection()
    {
        try{
            con=DriverManager.getConnection("jdbc:ucanaccess://c://Users//Hasan Yagout//Desktop//Hotel_Management_System.accdb");
            JOptionPane.showMessageDialog(null,"you are connected");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void adding(Object name,Object pass, String stat)
    {

        Object [][]data={{name,pass,stat}};
        String [] columnnames={"name","pass","status"};
        DefaultTableModel model= new DefaultTableModel(data,columnnames);
        table= new JTable(model);
        panel.add(new JScrollPane(table));

        validate();
    }


    public static void main(String[] args) {
        manage_users user= new manage_users();
        user.DBconnection();


    }



    public void mouseClicked(MouseEvent e) {

        int index=table.getSelectedRow();
        TableModel tableModel= table.getModel();
        String name=tableModel.getValueAt(index,0).toString();
        String pass=tableModel.getValueAt(index,1).toString();
        String status=tableModel.getValueAt(index,2).toString();
        JOptionPane.showConfirmDialog(null,"grant access?","title",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
