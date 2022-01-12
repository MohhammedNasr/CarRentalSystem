package CarRentalSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Person_Register extends JFrame
{
    JButton Return,Register;
    JLabel  Luser_name,Lpassword,Lfname,Llname,Laddress,Lphonenum,Lemail;
    JRadioButton admin;
    JTextField User_name,Password,Fname,Lname,Address,Phonenum,email;

    Person_Register()
    {
        setVisible(true);
        setSize(500,500);
        setTitle("Register");
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Return= new JButton("Return");
        Return.setBounds(100, 300, 120, 50);
        Return.addActionListener(new Buttonsaver());

        Register = new JButton("Register");
        Register.setBounds(250, 300, 120, 50);
        Register.addActionListener(new Buttonsaver());


        Luser_name= new JLabel("Username");
        Luser_name.setBounds(40,10  , 100, 35);
        Luser_name.setForeground(Color.CYAN);
        User_name = new JTextField();
        User_name.setBounds(40, 40,120 , 25);

        Lpassword= new JLabel("Password");
        Lpassword.setBounds(325, 10, 100, 35);
        Lpassword.setForeground(Color.CYAN);
        Password = new JTextField();
        Password.setBounds(325, 40, 120, 25);

        Lfname= new JLabel("First name");
        Lfname.setBounds(40, 60, 100, 35);
        Lfname.setForeground(Color.CYAN);
        Fname = new JTextField();
        Fname.setBounds(40, 90, 120, 25);

        Llname= new JLabel("Last name");
        Llname.setBounds(325, 60, 100, 35);
        Llname.setForeground(Color.CYAN);
        Lname = new JTextField();
        Lname.setBounds(325, 90, 120, 25);

        Lemail= new JLabel("Email");
        Lemail.setBounds(40, 110, 100, 35);
        Lemail.setForeground(Color.CYAN);
        email = new JTextField();
        email.setBounds(40, 140, 120, 25);

        Laddress= new JLabel("Address");
        Laddress.setBounds(325, 110, 100, 35);
        Laddress.setForeground(Color.CYAN);
        Address= new JTextField();
        Address.setBounds(325, 140, 120, 25);

        Lphonenum= new JLabel("Phone Number");
        Lphonenum.setBounds(40, 160, 100, 35);
        Lphonenum.setForeground(Color.CYAN);
        Phonenum= new JTextField();
        Phonenum.setBounds(40, 190, 120, 25);

        admin = new JRadioButton("Admin");
        admin.setBounds(40,235,100,25);
        admin.setBackground(Color.DARK_GRAY);
        admin.setForeground(Color.CYAN);



        add(Register);
        add(Return);
        add(User_name);
        add(Password);
        add(Fname);
        add(Lname);
        add(Address);
        add(Phonenum);
        add(email);
        add(Luser_name);
        add(Lpassword);
        add(Lfname);
        add(Llname);
        add(Laddress);
        add(Lphonenum);
        add(Lemail);
        add(admin);
    }



    private class Buttonsaver implements ActionListener
    {

        public Buttonsaver()
        {

        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource().equals(Return))
            {
                CarRentalSystem.Frame.setVisible(true);
                setVisible(false);
                User_name.setText("");
                Password.setText("");
                Fname.setText("");
                Lname.setText("");
                email.setText("");
                Address.setText("");
                Phonenum.setText("");
                dispose();

            }



            if(e.getSource().equals(Register))
            {

                if(Person.personmap.containsKey(User_name.getText()))
                {
                    JOptionPane.showMessageDialog(Register,"User Already Taken","Register",2);
                }
                else if(User_name.getText().isBlank() ||Password.getText().isBlank() || Lname.getText().isBlank()||email.getText().isBlank() ||Address.getText().isBlank() ||Phonenum.getText().isBlank())
                {
                    JOptionPane.showMessageDialog(Register,"Fill all","Register",2);
                }
                else
                {
                    String phonenumber = Phonenum.getText();
                    if ( phonenumber.matches("^[0-9]{11}$") )
                    {
                        String adminn = "user";
                        if(admin.isSelected())
                        {
                            adminn = "admin";
                        }
                        try
                        {
                            Person objperson = new Person(User_name.getText(),Password.getText(),Fname.getText(),Lname.getText(),email.getText(),Address.getText(),Phonenum.getText(),adminn);
                        } catch (IOException ex)
                        {
                            ex.printStackTrace();
                        }

                        Home.personFile();
                        CarRentalSystem.Login.setVisible(true);
                        setVisible(false);
                        dispose();
                        User_name.setText("");
                        Password.setText("");
                        Fname.setText("");
                        Lname.setText("");
                        email.setText("");
                        Address.setText("");
                        Phonenum.setText("");
                        admin.setText("");

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(Register,"Invalid Phone Number","Register",2);

                    }
                    }


                    }



            }


            }
        }




