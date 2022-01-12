package CarRentalSystem;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;

public class Payment_Cash extends JFrame implements ActionListener {
    JLabel Lprice;
    JButton pay;
    Payment_Cash(int x)
    {
        setSize(325,350);
        setTitle("Cash");
        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pay= new JButton("PAY NOW");
        pay.setBounds(125, 250, 120, 50);
        pay.addActionListener(new Payment_Cash.Buttonsaver());

        Lprice=new JLabel("Total price: "+ x);
        Lprice.setBounds(20, 100, 100, 50);
        Lprice.setForeground(Color.CYAN);

        add(pay);
        add(Lprice);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
    private static class Buttonsaver implements ActionListener {

        public Buttonsaver() {
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
        }
    }
}
