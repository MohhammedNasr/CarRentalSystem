package CarRentalSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Admin_Cars extends JFrame
{
    JButton Return=new JButton("Return");
    JButton AddCar=new JButton("Add Car");
    JButton Edit=new JButton("Edit Car");
    JButton Delete=new JButton("Delete Car");
    JScrollPane CTScroll=new JScrollPane();
    JTable CarList=new JTable();
    JPanel TablePanel=new JPanel();
    String CarsList[][]=new String[Car.carmap.size()][9];
    String Headers[]={ "Platenum","Car_make","Car_model","Model_year","Car_color","Milage","Transmition","Price","Ava"};
    static int sel_row;

    public int getSel_row() {
        return sel_row;
    }
    public Admin_Cars()
    {
        setVisible(true);
        Home.carFile();
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


                CarsList[i][0]= mm.getKey();
                CarsList[i][1]= String.valueOf(mm.getValue().get(0));
                CarsList[i][2]= String.valueOf(mm.getValue().get(1));
                CarsList[i][3]= String.valueOf(mm.getValue().get(2));
                CarsList[i][4]= String.valueOf(mm.getValue().get(3));
                CarsList[i][5]= String.valueOf(mm.getValue().get(4));
                CarsList[i][6]= String.valueOf(mm.getValue().get(5));
                CarsList[i][7]= String.valueOf(mm.getValue().get(6));
                CarsList[i][8]= String.valueOf(mm.getValue().get(7));
                i++;
            }

        } catch (Exception ed) {

        }

        Return.addActionListener(new Buttonsaver());
        AddCar.addActionListener(new Buttonsaver());
        Edit.addActionListener(new Buttonsaver());
        Delete.addActionListener(new Buttonsaver());

        setSize(500,500);
        setTitle("Admin");
        TablePanel.setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarList.setModel(new javax.swing.table.DefaultTableModel(
                CarsList,
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
        AddCar.setSize(100, 50);
        Edit.setSize(100, 50);
        Delete.setSize(100, 50);
        TablePanel.add(Return);
        TablePanel.add(AddCar);
        TablePanel.add(Edit);
        TablePanel.add(Delete);
        add(TablePanel);
    }

    public Admin_Cars(int x)
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
            for (Map.Entry<String, ArrayList> mm : mapInnFile.entrySet())
            {


                CarsList[i][0]= mm.getKey();
                CarsList[i][1]= String.valueOf(mm.getValue().get(0));
                CarsList[i][2]= String.valueOf(mm.getValue().get(1));
                CarsList[i][3]= String.valueOf(mm.getValue().get(2));
                CarsList[i][4]= String.valueOf(mm.getValue().get(3));
                CarsList[i][5]= String.valueOf(mm.getValue().get(4));
                CarsList[i][6]= String.valueOf(mm.getValue().get(5));
                CarsList[i][7]= String.valueOf(mm.getValue().get(6));
                CarsList[i][8]= String.valueOf(mm.getValue().get(7));
                i++;
            }

        } catch (Exception ed) {

        }

        Return.addActionListener(new Buttonsaver());
        AddCar.addActionListener(new Buttonsaver());
        Edit.addActionListener(new Buttonsaver());
        Delete.addActionListener(new Buttonsaver());

        setSize(500,500);
        setTitle("Admin");
        TablePanel.setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarList.setModel(new javax.swing.table.DefaultTableModel(
                CarsList,
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
        AddCar.setSize(100, 50);
        Edit.setSize(100, 50);
        Delete.setSize(100, 50);
        TablePanel.add(Return);
        TablePanel.add(AddCar);
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

            if (e.getSource().equals(AddCar))
            {
                    Car_Add Car_Add = new Car_Add();
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
                    Car_Add AC =new Car_Add(CarsList[sel_row][0]);
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
                    Car.carmap.remove(CarsList[sel_row][0]);
                    try
                    {
                        File data = new File("C:\\Users\\ggrna\\Desktop\\datacar.dat");
                        FileOutputStream fos=new FileOutputStream(data);
                        ObjectOutputStream oos=new ObjectOutputStream(fos);

                        oos.writeObject(Car.carmap);
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