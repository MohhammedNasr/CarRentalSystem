package CarRentalSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Person_Login extends  JFrame
{
    JLabel Lusername,Lpassword;
    JPasswordField Tpassword;
    JButton Return,Login,chat;
    JTextField Tusername;

    Person_Login()
    {
        setTitle("Login");
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(500,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Return= new JButton("Return");
        Return.setBounds(100, 300, 120, 50);
        Return.addActionListener(new Buttonsaver());

        Login = new JButton("Login");
        Login.setBounds(250, 300, 120, 50);
        Login.addActionListener(new Buttonsaver());

        chat = new JButton("Chat");
        chat.setBounds(300, 400, 120, 50);
        chat.addActionListener(new Buttonsaver());

        Lusername= new JLabel("Username");
        Lusername.setBounds(25, 50, 100, 50);
        Lusername.setForeground(Color.CYAN);

        Lpassword= new JLabel("Password");
        Lpassword.setBounds(25, 150, 100, 50);
        Lpassword.setForeground(Color.CYAN);

        Tusername = new JTextField();
        Tusername.setBounds(25, 100, 325, 35);

        Tpassword = new JPasswordField();
        Tpassword.setBounds(25, 200, 325, 35);

        add(Return);
        add(Login);
        add(chat);
        add(Tusername);
        add(Tpassword);
        add(Lusername);
        add(Lpassword);
    }



    private class Buttonsaver implements ActionListener
    {

        public Buttonsaver()
        {

        }

        @Override
        public void actionPerformed(ActionEvent e)
        {


            if(e.getSource().equals(Login))
            {



            if(Person.personmap.containsKey(Tusername.getText()) && Person.personmap.get(Tusername.getText()).get(0).equals(Tpassword.getText()))
            {
                if(Person.personmap.get(Tusername.getText()).get(6).equals("admin"))
                {
                    Admin_GUI admin = new Admin_GUI();
                    CarRentalSystem.Login.setVisible(false);
                    Tusername.setText("");
                    Tpassword.setText("");
                    dispose();
                }
                else
                {

                    CarRentalSystem.userchoice.setVisible(true);
                    CarRentalSystem.Login.setVisible(false);
                    Tusername.setText("");
                    Tpassword.setText("");
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(Login,"Invalid Username or Password","Login",2);

            }


            }

            if(e.getSource().equals(Return))
            {
                CarRentalSystem.Frame.setVisible(true);
                CarRentalSystem.Login.setVisible(false);
                Tusername.setText("");
                Tpassword.setText("");
                dispose();



            }
            if(e.getSource().equals(chat))
            {
                Server s = new Server();
                Client c = new Client();
                CarRentalSystem.Frame.setVisible(true);
                CarRentalSystem.Login.setVisible(false);
                Tusername.setText("");
                Tpassword.setText("");
                dispose();



            }
        }
    }
}






