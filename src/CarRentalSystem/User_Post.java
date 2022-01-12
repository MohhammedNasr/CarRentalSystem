package CarRentalSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class User_Post extends JFrame
{
    JButton Return=new JButton("Return");
    JButton post=new JButton("Post a Car");
    public User_Post()
    {
        Return.addActionListener(new Buttonsaver());
        post.addActionListener(new Buttonsaver());
        setSize(500,500);
        setTitle("User Post");
        setLayout(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Return.setBounds(100, 300, 120, 50);
        post.setBounds(250, 300, 120, 50);
        add(Return);
        add(post);

    }

    private class Buttonsaver implements ActionListener {

        public Buttonsaver() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(Return)) {
                CarRentalSystem.userchoice.setVisible(true);
                CarRentalSystem.posting_gui.setVisible(false);
                dispose();

            }
            if (e.getSource().equals(post)) {
                User_Post_GUI obj = new User_Post_GUI();
                setVisible(false);
                dispose();

            }


            }




        }
    }

