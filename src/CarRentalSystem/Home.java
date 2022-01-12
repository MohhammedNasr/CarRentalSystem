package CarRentalSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Home extends  JFrame
{
    JButton Register,Login;
    JLabel textName;
    Home()
    {
        personFile();
        carFile();
        bookingFile();
        textName = new JLabel("Car Rental System");
        textName.setBounds(120,25,300,120);
        textName.setFont(new Font("Serif", Font.PLAIN,30));
        textName.setForeground(Color.CYAN);
        add(textName);
        Register = new JButton("Register");
        Register.setBounds(100, 300, 120, 50);
        Register.addActionListener(new Buttonwatchter());
        Login = new JButton("Login");
        Login.setBounds(250, 300, 120, 50);
        Login.addActionListener(new Buttonwatchter());
        setTitle("Home");

        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        add(Register);
        add(Login);
        setLayout(null);
        setVisible(true);
       getContentPane().setBackground(Color.DARK_GRAY);




    }

    static void personFile()
    {
        try
        {
            File toRead = new File("C:\\Users\\ggrna\\Desktop\\data.dat");
            FileInputStream fis = new FileInputStream(toRead);
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<String, ArrayList> mapInFile = (HashMap<String, ArrayList>) ois.readObject();


            ois.close();
            fis.close();

            for (Map.Entry<String, ArrayList> m : mapInFile.entrySet()) {

                Person.personmap.put(m.getKey(), m.getValue());

            }

        } catch (Exception ed) {

        }
    }

    static void carFile()
    {
        try
        {
            File toReadd = new File("C:\\Users\\ggrna\\Desktop\\datacar.dat");
            FileInputStream fiss = new FileInputStream(toReadd);
            ObjectInputStream oiss = new ObjectInputStream(fiss);

            HashMap<String, ArrayList> mapInnFile = (HashMap<String, ArrayList>) oiss.readObject();


            oiss.close();
            fiss.close();

            for (Map.Entry<String, ArrayList> mm : mapInnFile.entrySet()) {

                Car.carmap.put(mm.getKey(), mm.getValue());

            }

        } catch (Exception ed) {

        }
    }

    static void bookingFile()
    {
        try
        {
            File toReaddd = new File("C:\\Users\\ggrna\\Desktop\\bookingdata.dat");
            FileInputStream fisss = new FileInputStream(toReaddd);
            ObjectInputStream oisss = new ObjectInputStream(fisss);

            HashMap<String, ArrayList> mapInnFile = (HashMap<String, ArrayList>) oisss.readObject();


            oisss.close();
            fisss.close();

            for (Map.Entry<String, ArrayList> mmm : mapInnFile.entrySet()) {

                Booking.bookingmap.put(mmm.getKey(), mmm.getValue());

            }

        } catch (Exception ed) {

        }
    }





    private class Buttonwatchter implements ActionListener
    {

        public Buttonwatchter()
        {

        }

        @Override
        public void actionPerformed(ActionEvent e)
        {


            if(e.getSource().equals(Register))
            {
                carFile();
                Person_Register r=new Person_Register();
                CarRentalSystem.Frame.setVisible(false);
                dispose();
            }

            if(e.getSource().equals(Login))
            {
                carFile();
                CarRentalSystem.Login.setVisible(true);
                CarRentalSystem.Frame.setVisible(false);
                dispose();
            }


        }
    }
}



