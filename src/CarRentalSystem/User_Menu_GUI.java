package CarRentalSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Menu_GUI extends  JFrame {
    JButton Return, post, rent;

    User_Menu_GUI() {

        setSize(500, 500);
        setTitle("User");
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Return = new JButton("Return");
        Return.setBounds(180, 330, 120, 50);
        Return.addActionListener(new Buttonsaver());
        add(Return);

        post = new JButton("post car");
        post.setBounds(100, 50, 120, 50);
        post.addActionListener(new Buttonsaver());
        add(post);

        rent = new JButton("rent");
        rent.setBounds(250, 50, 120, 50);
        rent.addActionListener(new Buttonsaver());
        add(rent);




    }

    private class Buttonsaver implements ActionListener {

        public Buttonsaver() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(Return)) {
                CarRentalSystem.Frame.setVisible(true);
                CarRentalSystem.userchoice.setVisible(false);
                dispose();

            }

            if (e.getSource().equals(rent)) {
                Home.carFile();
                Car_List renting_gui = new Car_List();
                CarRentalSystem.userchoice.setVisible(false);
                dispose();

            }

            if (e.getSource().equals(post)) {
                CarRentalSystem.posting_gui.setVisible(true);
                CarRentalSystem.userchoice.setVisible(false);
                dispose();

            }


        }
    }

}

