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


public class Car_List extends JFrame
{
    JButton Return=new JButton("Return");
    JButton Book=new JButton("Book");
    JButton Details=new JButton("Details");
    JScrollPane CTScroll=new JScrollPane();
    JTable CarList=new JTable();
    JPanel TablePanel=new JPanel();
    String CarsList[][]=new String[Car.carmap.size()][7];
    String Headers[]={ "PlateNumber","Make", "Model", "Year", "Color", "Price","Status"};
    static int sel_row;

    public int getSel_row() {
        return sel_row;
    }
Car_List(int x)
{

}

    public Car_List()
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
                CarsList[i][5]= String.valueOf(mm.getValue().get(6));
                CarsList[i][6]= String.valueOf(mm.getValue().get(7));
                i++;
            }

        } catch (Exception ed) {

        }

        Return.addActionListener(new Buttonsaver());
        Book.addActionListener(new Buttonsaver());
        setSize(500,500);
        setTitle("User");
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
        Book.setSize(100, 50);
        TablePanel.add(Return);
        TablePanel.add(Book);
        add(TablePanel);
    }

    private class Buttonsaver implements ActionListener {

        public Buttonsaver() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(Return)) {
                CarRentalSystem.userchoice.setVisible(true);
                setVisible(false);
                dispose();

            }

            if (e.getSource().equals(Book))
            {
                sel_row = CarList.getSelectedRow();
                if(sel_row == -1)
                {
                    JOptionPane.showMessageDialog(Book,"Pick Car First! ","Book",2);
                }
                else
                {

                    sel_row = CarList.getSelectedRow();
                    Payment details = new Payment(CarsList[sel_row][0]);
                    setVisible(false);
                    dispose();
                }


            }


        }
    }
}