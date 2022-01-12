package CarRentalSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Admin_Booking_List extends JFrame
{
    JButton Return=new JButton("Return");
    JButton Edit=new JButton("Edit Booking");
    JButton Delete=new JButton("Delete Booking");
    JScrollPane CTScroll=new JScrollPane();
    JTable BookingList=new JTable();
    JPanel TablePanel=new JPanel();
    String BookingsList[][]=new String[Booking.bookingmap.size()][4];
    String Headers[]={ "Platenum","period","payment","amount"};
    static int sel_row;

    public int getSel_row() {
        return sel_row;
    }
    public Admin_Booking_List()
    {
        setVisible(true);
        Home.carFile();
        try
        {
            File toReadd = new File("C:\\Users\\ggrna\\Desktop\\bookingdata.dat");
            FileInputStream fiss = new FileInputStream(toReadd);
            ObjectInputStream oiss = new ObjectInputStream(fiss);

            HashMap<String, ArrayList> mapInnFile = (HashMap<String, ArrayList>) oiss.readObject();


            oiss.close();
            fiss.close();
            int i=0;
            for (Map.Entry<String, ArrayList> mm : mapInnFile.entrySet()) {


                BookingsList[i][0]= mm.getKey();
                BookingsList[i][1]= String.valueOf(mm.getValue().get(0));
                BookingsList[i][2]= String.valueOf(mm.getValue().get(1));
                BookingsList[i][3]= String.valueOf(mm.getValue().get(2));
                i++;
            }

        } catch (Exception ed) {

        }

        Return.addActionListener(new Buttonsaver());
        Edit.addActionListener(new Buttonsaver());
        Delete.addActionListener(new Buttonsaver());

        setSize(500,500);
        setTitle("Admin Booking");
        TablePanel.setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BookingList.setModel(new javax.swing.table.DefaultTableModel(
                BookingsList,
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
        CTScroll.setViewportView(BookingList);
        TablePanel.add(CTScroll);
        Return.setSize(100, 50);
        Edit.setSize(100, 50);
        Delete.setSize(100, 50);
        TablePanel.add(Return);
        TablePanel.add(Edit);
        TablePanel.add(Delete);
        add(TablePanel);
    }

    public Admin_Booking_List(int x)
    {
        setVisible(true);
        try
        {
            File toReadd = new File("C:\\Users\\ggrna\\Desktop\\datacar.dat");
            FileInputStream fiss = new FileInputStream(toReadd);
            ObjectInputStream oiss = new ObjectInputStream(fiss);

            HashMap<String, ArrayList> mapInnFile = (HashMap<String, ArrayList>) oiss.readObject();


            oiss.close();
            fiss.close();
            int i=0;
            for (Map.Entry<String, ArrayList> mm : mapInnFile.entrySet()) {


                BookingsList[i][0]= mm.getKey();
                BookingsList[i][1]= String.valueOf(mm.getValue().get(0));
                BookingsList[i][2]= String.valueOf(mm.getValue().get(1));
                BookingsList[i][3]= String.valueOf(mm.getValue().get(2));
                i++;
            }

        } catch (Exception ed) {

        }

        Return.addActionListener(new Buttonsaver());
        Edit.addActionListener(new Buttonsaver());
        Delete.addActionListener(new Buttonsaver());

        setSize(500,500);
        setTitle("Admin Booking");
        TablePanel.setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BookingList.setModel(new javax.swing.table.DefaultTableModel(
                BookingsList,
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
        CTScroll.setViewportView(BookingList);
        TablePanel.add(CTScroll);
        Return.setSize(100, 50);
        Edit.setSize(100, 50);
        Delete.setSize(100, 50);
        TablePanel.add(Return);
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


            if (e.getSource().equals(Edit))
            {
                sel_row = BookingList.getSelectedRow();
                if(sel_row == -1)
                {
                    JOptionPane.showMessageDialog(Edit,"Pick Booking First! ","Edit",2);
                }
                else
                {
                    sel_row = BookingList.getSelectedRow();
                    Admin_Edit_Booking AC =new Admin_Edit_Booking(BookingsList[sel_row][0]);
                    setVisible(false);
                    dispose();
                }
            }
            if (e.getSource().equals(Delete))
            {
                sel_row = BookingList.getSelectedRow();
                if(sel_row == -1)
                {
                    JOptionPane.showMessageDialog(Delete,"Pick Booking First! ","Delete",2);
                }
                else
                {
                    Car c=new Car();
                    ArrayList<String> avb =Car.carmap.get(BookingsList[sel_row][0]);
                    avb.remove(7);
                    avb.add(7,"available");
                    c.Carfile();
                    sel_row = BookingList.getSelectedRow();
                    Booking.bookingmap.remove(BookingsList[sel_row][0]);
                    try
                    {
                        File data = new File("C:\\Users\\ggrna\\Desktop\\bookingdata.dat");
                        FileOutputStream fos=new FileOutputStream(data);
                        ObjectOutputStream oos=new ObjectOutputStream(fos);

                        oos.writeObject(Booking.bookingmap);
                        oos.flush();
                        oos.close();
                        fos.close();

                    }
                    catch(Exception ed)
                    {

                    }
                }
            }
            }
        }
    }