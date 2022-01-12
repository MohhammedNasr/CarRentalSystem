package CarRentalSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Admin_Edit_Booking extends JFrame implements ActionListener {
    Integer[] years = new Integer[43];
    JButton Return, Edit;
    JTextField TAmount, Tperiod,TPlateNum;
    JLabel LAmount, Lperiod,LPlateNum;
    JRadioButton Visa, Cash;
    String platenumberr;

    Admin_Edit_Booking(String PN) {
        platenumberr = PN;
        setVisible(true);
        setSize(500, 500);
        setTitle("Edit Booking");
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Return = new JButton("Return");
        Return.setBounds(100, 300, 120, 50);
        Return.addActionListener(new Buttonsaver());

        Edit = new JButton("Edit");
        Edit.setBounds(250, 300, 120, 50);
        Edit.addActionListener(new Buttonsaver());


        

        LAmount = new JLabel("Amount");
        LAmount.setBounds(250, 20, 100, 25);
        LAmount.setForeground(Color.CYAN);
        TAmount = new JTextField((String) Booking.bookingmap.get(PN).get(2));
        TAmount.setBounds(250, 40, 120, 25);

        Lperiod = new JLabel("Period");
        Lperiod.setBounds(40, 70, 100, 25);
        Lperiod.setForeground(Color.CYAN);
        Tperiod = new JTextField((String) Booking.bookingmap.get(PN).get(0));
        Tperiod.setBounds(40, 90, 120, 25);

        LPlateNum = new JLabel("Plate num");
        LPlateNum.setBounds(40, 20, 100, 25);
        LPlateNum.setForeground(Color.CYAN);
        TPlateNum = new JTextField(PN);
        TPlateNum.setBounds(40, 40, 100, 25);

        for (int i = 0; i < 43; i++) {
            years[i] = 2022 - i;
        }

        

        Visa = new JRadioButton("Visa");
        Visa.setBounds(250, 90, 100, 25);
        Visa.setBackground(Color.DARK_GRAY);
        Visa.setForeground(Color.CYAN);

        Cash = new JRadioButton("Cash");
        Cash.setBounds(250, 140, 100, 25);
        Cash.setBackground(Color.DARK_GRAY);
        Cash.setForeground(Color.CYAN);
        ButtonGroup trans = new ButtonGroup();
        trans.add(Visa);
        trans.add(Cash);

       


        add(Return);
        add(Edit);
        add(Visa);
        add(Cash);
        setLayout(null);
        add(LAmount);
        add(TAmount);
        add(Lperiod);
        add(Tperiod);
        add(TPlateNum);
        add(LPlateNum);
    }

    Admin_Edit_Booking() {
        setVisible(true);
        setSize(500, 500);
        setTitle("Add Booking");
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Return = new JButton("Return");
        Return.setBounds(100, 300, 120, 50);
        Return.addActionListener(new Buttonsaver());

        LAmount = new JLabel("Car Make");
        LAmount.setBounds(250, 20, 100, 25);
        LAmount.setForeground(Color.CYAN);
        TAmount = new JTextField();
        TAmount.setBounds(250, 40, 120, 25);

        Lperiod = new JLabel("Car Model");
        Lperiod.setBounds(40, 70, 100, 25);
        Lperiod.setForeground(Color.CYAN);
        Tperiod = new JTextField();
        Tperiod.setBounds(40, 90, 120, 25);

        LPlateNum = new JLabel("Plate num");
        LPlateNum.setBounds(40, 20, 100, 25);
        LPlateNum.setForeground(Color.CYAN);
        TPlateNum = new JTextField();
        TPlateNum.setBounds(40, 40, 100, 25);

        for (int i = 0; i < 43; i++) {
            years[i] = 2022 - i;
        }
        Visa = new JRadioButton("Visa");
        Visa.setBounds(250, 90, 100, 25);
        Visa.setBackground(Color.DARK_GRAY);
        Visa.setForeground(Color.CYAN);

        Cash = new JRadioButton("Cash");
        Cash.setBounds(250, 140, 100, 25);
        Cash.setBackground(Color.DARK_GRAY);
        Cash.setForeground(Color.CYAN);
        ButtonGroup trans = new ButtonGroup();
        trans.add(Visa);
        trans.add(Cash);
        add(Return);
        add(Visa);
        add(Cash);
        setLayout(null);
        add(LAmount);   
        add(TAmount);
        add(Lperiod);
        add(Tperiod);
        add(TPlateNum);
        add(LPlateNum);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

    private class Buttonsaver implements ActionListener {

        public Buttonsaver() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(Return)) {
                Admin_Booking_List AC = new Admin_Booking_List();
                setVisible(false);
                TAmount.setText("");
                Tperiod.setText("");
                dispose();

            }

            if (e.getSource().equals(Edit))
            {


            }
            }


                    }
                }
        




