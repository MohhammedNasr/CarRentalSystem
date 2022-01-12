package CarRentalSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Car_Add extends JFrame implements ActionListener {
    Integer[] years = new Integer[43];
    JButton Return, Add, Edit;
    JTextField TCar_make, TCar_model, TCar_color, TPlatenum, TMilage, TCar_price;
    JLabel LCar_make, LCar_model, LCar_color, LPlatenum, LMilage, LCar_price;
    JRadioButton Auto, Manual;
    JComboBox Car_year;
    String platenumberr;

    Car_Add(String PN) {
        platenumberr = PN;
        setVisible(true);
        setSize(500, 500);
        setTitle("Edit Car");
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


        LPlatenum = new JLabel("Plate Number");
        LPlatenum.setBounds(40, 20, 100, 25);
        LPlatenum.setForeground(Color.CYAN);
        TPlatenum = new JTextField(PN);
        TPlatenum.setBounds(40, 40, 120, 25);

        LCar_make = new JLabel("Car Make");
        LCar_make.setBounds(250, 20, 100, 25);
        LCar_make.setForeground(Color.CYAN);
        TCar_make = new JTextField((String) Car.carmap.get(PN).get(0));
        TCar_make.setBounds(250, 40, 120, 25);

        LCar_model = new JLabel("Car Model");
        LCar_model.setBounds(40, 70, 100, 25);
        LCar_model.setForeground(Color.CYAN);
        TCar_model = new JTextField((String) Car.carmap.get(PN).get(1));
        TCar_model.setBounds(40, 90, 120, 25);


        for (int i = 0; i < 43; i++) {
            years[i] = 2022 - i;
        }

        Car_year = new JComboBox(years);
        Car_year.setBounds(250, 190, 100, 25);

        LCar_color = new JLabel("Car Color");
        LCar_color.setBounds(40, 120, 100, 25);
        LCar_color.setForeground(Color.CYAN);
        TCar_color = new JTextField((String) Car.carmap.get(PN).get(3));
        TCar_color.setBounds(40, 140, 120, 25);

        Auto = new JRadioButton("Automatic");
        Auto.setBounds(250, 90, 100, 25);
        Auto.setBackground(Color.DARK_GRAY);
        Auto.setForeground(Color.CYAN);

        Manual = new JRadioButton("Manual");
        Manual.setBounds(250, 140, 100, 25);
        Manual.setBackground(Color.DARK_GRAY);
        Manual.setForeground(Color.CYAN);
        ButtonGroup trans = new ButtonGroup();
        trans.add(Auto);
        trans.add(Manual);

        LMilage = new JLabel("Mileage");
        LMilage.setBounds(40, 170, 100, 25);
        LMilage.setForeground(Color.CYAN);
        TMilage = new JTextField((String) Car.carmap.get(PN).get(4));
        TMilage.setBounds(40, 190, 120, 25);

        LCar_price = new JLabel("Car Price Per Day");
        LCar_price.setBounds(40, 220, 100, 25);
        LCar_price.setForeground(Color.CYAN);
        TCar_price = new JTextField((String) Car.carmap.get(PN).get(6));
        TCar_price.setBounds(40, 240, 120, 25);


        add(Return);
        add(Edit);
        add(Auto);
        add(Manual);
        setLayout(null);
        add(LCar_make);
        add(TPlatenum);
        add(TCar_make);
        add(LCar_model);
        add(TCar_model);
        add(Car_year);
        add(LCar_color);
        add(TCar_color);
        add(LPlatenum);
        add(LMilage);
        add(TMilage);
        add(TCar_price);
        add(LCar_price);
    }

    Car_Add() {
        setVisible(true);
        setSize(500, 500);
        setTitle("Add Car");
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Return = new JButton("Return");
        Return.setBounds(100, 300, 120, 50);
        Return.addActionListener(new Buttonsaver());

        Add = new JButton("Add");
        Add.setBounds(250, 300, 120, 50);
        Add.addActionListener(new Buttonsaver());


        LPlatenum = new JLabel("Plate Number");
        LPlatenum.setBounds(40, 20, 100, 25);
        LPlatenum.setForeground(Color.CYAN);
        TPlatenum = new JTextField();
        TPlatenum.setBounds(40, 40, 120, 25);

        LCar_make = new JLabel("Car Make");
        LCar_make.setBounds(250, 20, 100, 25);
        LCar_make.setForeground(Color.CYAN);
        TCar_make = new JTextField();
        TCar_make.setBounds(250, 40, 120, 25);

        LCar_model = new JLabel("Car Model");
        LCar_model.setBounds(40, 70, 100, 25);
        LCar_model.setForeground(Color.CYAN);
        TCar_model = new JTextField();
        TCar_model.setBounds(40, 90, 120, 25);


        for (int i = 0; i < 43; i++) {
            years[i] = 2022 - i;
        }

        Car_year = new JComboBox(years);
        Car_year.setBounds(250, 190, 100, 25);

        LCar_color = new JLabel("Car Color");
        LCar_color.setBounds(40, 120, 100, 25);
        LCar_color.setForeground(Color.CYAN);
        TCar_color = new JTextField();
        TCar_color.setBounds(40, 140, 120, 25);

        Auto = new JRadioButton("Automatic");
        Auto.setBounds(250, 90, 100, 25);
        Auto.setBackground(Color.DARK_GRAY);
        Auto.setForeground(Color.CYAN);

        Manual = new JRadioButton("Manual");
        Manual.setBounds(250, 140, 100, 25);
        Manual.setBackground(Color.DARK_GRAY);
        Manual.setForeground(Color.CYAN);
        ButtonGroup trans = new ButtonGroup();
        trans.add(Auto);
        trans.add(Manual);

        LMilage = new JLabel("Mileage ");
        LMilage.setBounds(40, 170, 100, 25);
        LMilage.setForeground(Color.CYAN);
        TMilage = new JTextField();
        TMilage.setBounds(40, 190, 120, 25);

        LCar_price = new JLabel("Car Price Per Day");
        LCar_price.setBounds(40, 220, 100, 25);
        LCar_price.setForeground(Color.CYAN);
        TCar_price = new JTextField();
        TCar_price.setBounds(40, 240, 120, 25);


        add(Return);
        add(Add);
        add(Auto);
        add(Manual);
        setLayout(null);
        add(LCar_make);
        add(TPlatenum);
        add(TCar_make);
        add(LCar_model);
        add(TCar_model);
        add(Car_year);
        add(LCar_color);
        add(TCar_color);
        add(LPlatenum);
        add(LMilage);
        add(TMilage);
        add(TCar_price);
        add(LCar_price);
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
                Admin_Cars AC = new Admin_Cars();
                setVisible(false);
                TPlatenum.setText("");
                TCar_make.setText("");
                TCar_model.setText("");
                TCar_color.setText("");
                TMilage.setText("");
                TCar_price.setText("");
                dispose();

            }
            if (e.getSource().equals(Add)) {
                String Model_year = Car_year.getSelectedItem().toString();
                if (Car.carmap.containsKey(TPlatenum.getText())) {
                    JOptionPane.showMessageDialog(Add, "Car Already Added", "Add Car", 2);
                } else if (TPlatenum.getText().isBlank() || TCar_make.getText().isBlank() || TCar_model.getText().isBlank() || TCar_color.getText().isBlank() || TMilage.getText().isBlank()) {
                    JOptionPane.showMessageDialog(Add, "Fill all", "Register", 2);
                } else {
                    String milage = TMilage.getText();
                    String price = TCar_price.getText();
                    String color = TCar_color.getText();
                    if (milage.matches("^[0-9]\\d+$") && price.matches("^[0-9]\\d+$") && color.matches("^[a-zA-Z]*$")) {
                        Home.carFile();
                        String auto = "Auto";
                        if (Manual.isSelected()) {
                            auto = "Manual";
                        }
                        String ava = "Available";
                        Car objcar = new Car(TPlatenum.getText(), TCar_make.getText(), TCar_model.getText(), Model_year, TCar_color.getText(), TMilage.getText(), auto, TCar_price.getText(), ava);
                        JOptionPane.showMessageDialog(Add, "Car Added!", "Add Car", 1);
                        TPlatenum.setText("");
                        TCar_make.setText("");
                        TCar_model.setText("");
                        TCar_color.setText("");
                        TMilage.setText("");
                        TCar_price.setText("");

                    } else {
                        JOptionPane.showMessageDialog(Add, "Invalid Input", "Add Car", 2);

                    }


                }
            }

                if (e.getSource().equals(Edit))
                {
                    Car.carmap.remove(platenumberr);
                    String Model_yearr = Car_year.getSelectedItem().toString();
                    if (Car.carmap.containsKey(TPlatenum.getText())) {
                        JOptionPane.showMessageDialog(Edit, "Already exists", "Edit Car", 2);
                    }
                    else if (TPlatenum.getText().isBlank() || TCar_make.getText().isBlank() || TCar_model.getText().isBlank() || TCar_color.getText().isBlank() || TMilage.getText().isBlank()) {
                        JOptionPane.showMessageDialog(Edit, "Fill all", "Edit Car", 2);
                    } else {
                        String milage = TMilage.getText();
                        String price = TCar_price.getText();
                        String color = TCar_color.getText();
                        if (milage.matches("^[0-9]\\d+$") && price.matches("^[0-9]\\d+$") && color.matches("^[a-zA-Z]*$")) {

                            String auto = "Auto";
                            if (Manual.isSelected()) {
                                auto = "Manual";
                            }
                            String ava = "Available";
                            Car objcar = new Car(TPlatenum.getText(), TCar_make.getText(), TCar_model.getText(), Model_yearr, TCar_color.getText(), TMilage.getText(), auto, TCar_price.getText(), ava);
                            JOptionPane.showMessageDialog(Edit, "Car Edited", "Edit Car", 1);
                            TPlatenum.setText("");
                            TCar_make.setText("");
                            TCar_model.setText("");
                            TCar_color.setText("");
                            TMilage.setText("");
                            TCar_price.setText("");

                        } else {
                            JOptionPane.showMessageDialog(Edit, "Invalid Input!", "Edit Car", 2);

                        }


                    }
                }
            }
        }
}




