package CarRentalSystem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Admin_GUI extends JFrame
{
    JButton Return , viewcars, viewclients, viewbookings;

    Admin_GUI()
    {

        setSize(500,500);
        setTitle("Admin");
        setVisible(true);

        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Return= new JButton("Return");
        Return.setBounds(180,330, 120, 50);
        Return.addActionListener(new Buttonsaver());
        add(Return);
        viewcars= new JButton("view cars");
        viewcars.setBounds(30, 120, 120, 50);
        viewcars.addActionListener(new Buttonsaver());
        add(viewcars);
        viewclients= new JButton("view clients");
        viewclients.setBounds(190,120, 120, 50);
        viewclients.addActionListener(new Buttonsaver());
        add(viewclients);

        viewbookings= new JButton("View bookings");
        viewbookings.setBounds(340,120, 120, 50);
        viewbookings.addActionListener(new Buttonsaver());
        add(viewbookings);

    }

    private class Buttonsaver implements ActionListener {

        public Buttonsaver() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(Return)) {
                CarRentalSystem.Frame.setVisible(true);
                setVisible(false);
                dispose();

            }

            if (e.getSource().equals(viewcars)) {
                Admin_Cars AC=new Admin_Cars(1);
                setVisible(false);
                dispose();

            }
            if (e.getSource().equals(viewclients)) {
                Admin_Users AU=new Admin_Users();
                setVisible(false);
                dispose();

            }
            if (e.getSource().equals(viewbookings)) {
                Admin_Booking_List AB=new Admin_Booking_List();
                setVisible(false);
                dispose();

            }
        }


    }
}