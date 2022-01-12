package CarRentalSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Admin_Users extends JFrame
{
    JButton Return=new JButton("Return");
    JButton AddUser=new JButton("Add User");
    JButton Edit=new JButton("Edit User");
    JButton Delete=new JButton("Delete User");
    JScrollPane CTScroll=new JScrollPane();
    JTable CarList=new JTable();
    JPanel TablePanel=new JPanel();
    String personList[][]=new String[Person.personmap.size()][8];
    String Headers[]={ "User Name","Password","First Name","Last Name","Address","Phone Number","Email","Status"};
    static int sel_row;

    public int getSel_row() {
        return sel_row;
    }
    public Admin_Users()
    {
        setVisible(true);
        Home.personFile();
        try
        {
            File toReadd = new File("C:\\Users\\ggrna\\Desktop\\data.dat");
            FileInputStream fiss = new FileInputStream(toReadd);
            ObjectInputStream oiss = new ObjectInputStream(fiss);

            HashMap<String, ArrayList> mapInnFile = (HashMap<String, ArrayList>) oiss.readObject();


            oiss.close();
            fiss.close();
            int i=0;
            for (Map.Entry<String, ArrayList> mm : mapInnFile.entrySet()) {


                personList[i][0]= mm.getKey();
                personList[i][1]= String.valueOf(mm.getValue().get(0));
                personList[i][2]= String.valueOf(mm.getValue().get(1));
                personList[i][3]= String.valueOf(mm.getValue().get(2));
                personList[i][4]= String.valueOf(mm.getValue().get(4));
                personList[i][5]= String.valueOf(mm.getValue().get(5));
                personList[i][6]= String.valueOf(mm.getValue().get(3));
                personList[i][7]= String.valueOf(mm.getValue().get(6));
                i++;
            }

        } catch (Exception ed) {

        }

        Return.addActionListener(new Buttonsaver());
        AddUser.addActionListener(new Buttonsaver());
        Edit.addActionListener(new Buttonsaver());
        Delete.addActionListener(new Buttonsaver());

        setSize(500,500);
        setTitle("Admin");
        TablePanel.setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarList.setModel(new javax.swing.table.DefaultTableModel(
                personList,
                Headers
        ) {
            public Class getColumnClass(int columnIndex) {
                return String.class;
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        CTScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        CTScroll.setViewportView(CarList);
        TablePanel.add(CTScroll);
        Return.setSize(100, 50);
        AddUser.setSize(100, 50);
        Edit.setSize(100, 50);
        Delete.setSize(100, 50);
        TablePanel.add(Return);
        TablePanel.add(AddUser);
        TablePanel.add(Edit);
        TablePanel.add(Delete);
        add(TablePanel);
    }

    private class Buttonsaver implements ActionListener {

        public Buttonsaver() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(Return)) {
                Admin_GUI admin = new Admin_GUI();
                setVisible(false);
                dispose();

            }

            if (e.getSource().equals(AddUser))
            {
                Person_Register r=new Person_Register();
                setVisible(false);
                dispose();
            }

            if (e.getSource().equals(Edit))
            {
                sel_row = CarList.getSelectedRow();
                if(sel_row == -1)
                {
                    JOptionPane.showMessageDialog(Edit,"Pick Car First! ","Edit",2);
                }
                else
                {
                    sel_row = CarList.getSelectedRow();
                    Payment details = new Payment(personList[sel_row][0]);
                    setVisible(false);
                    dispose();
                }
            }
            if (e.getSource().equals(Delete))
            {
                sel_row = CarList.getSelectedRow();
                if(sel_row == -1)
                {
                    JOptionPane.showMessageDialog(Delete,"Pick Car First! ","Delete",2);
                }
                else
                {
                    sel_row = CarList.getSelectedRow();
                    Car.carmap.remove(personList[sel_row][0]);
                }
            }
        }


    }
}