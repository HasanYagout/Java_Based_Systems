
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class cusData extends JFrame {

    JTable table;
    public cusData(){
        setLayout(null);
        setVisible(true);
        setSize(1500,900);
        // DBconnection();

        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("name");
        model.addColumn("addresss");
        model.addColumn("id_proof");
        model.addColumn("Phone_number");
        model.addColumn("Nationality");
        model.addColumn("Gander");
        model.addColumn("Room_type");
        model.addColumn("Bed_type");
        model.addColumn("Price");
        model.addColumn("checkindate");
        model.addColumn("checkoutdate");
        model.addColumn("Email");


        for(custumers list: DBinfo.getcustumers()){

            model.addRow(new Object[]{
                    list.getFname(),
                    list.getFaddresss(),
                    list.getId_Proof(),
                    list.getPhone_number(),
                    list.getNationality(),
                    list.getGander(),
                    list.getRoom_type(),
                    list.getBed_type(),
                    list.Price,
                    list.getCheckindate(),
                    list.getCheckoutdate(),
                    list.getEmail()



            });




        }








        table=new JTable();
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);
        table.setBounds(300, 50, 900 , 500);
        add(table);
        table.setEnabled(false);
        // table.setBackground(Color.LIGHT_GRAY);
        table.setSurrendersFocusOnKeystroke(true);
        //table.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);
        table.setColumnSelectionAllowed(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(30);
        // table.setRowHeight(50);

        //TableModel Model ;
        table.setModel(model);

        JScrollPane scrollPane =new  JScrollPane(table);
        scrollPane.setLocation(300, 50);
        scrollPane.setSize(900,500);

        int rowIndex=0;
        int columnIndex=0;
        boolean includeSpacing=true;
        Rectangle cellRect= table.getCellRect(rowIndex, columnIndex, includeSpacing);
        table.scrollRectToVisible(cellRect);
        add(scrollPane);

    }


    public static void main(String[] args) {
        cusData det= new cusData();
    }

}
