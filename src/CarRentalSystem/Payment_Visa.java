package CarRentalSystem;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Payment_Visa extends JFrame implements ActionListener {
    JLabel Lprice, Lexp, Lcardnum, Lcvv, Lname;
    JTextField Texp, Tcardnum, Tcvv, Tname;
    JButton pay;
    int y;
    int totalweeks;
    String PlNum;
    Payment_Visa(int x, String PNum)
    {
        totalweeks = x;
        PlNum=PNum;
        setSize(325, 350);
        setTitle("Visa");
        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pay = new JButton("PAY NOW");
        pay.setBounds(125, 250, 120, 50);
        pay.addActionListener(new Buttonsaver());

        Lcardnum = new JLabel("Card Number");
        Lcardnum.setBounds(20, 20, 100, 50);
        Lcardnum.setForeground(Color.CYAN);

        Lexp = new JLabel("Expiration Date");
        Lexp.setBounds(20, 60, 100, 50);
        Lexp.setForeground(Color.CYAN);

        Lcvv = new JLabel("CVV");
        Lcvv.setBounds(20, 100, 100, 50);
        Lcvv.setForeground(Color.CYAN);

        Lname = new JLabel("Holder Name");
        Lname.setBounds(20, 140, 100, 50);
        Lname.setForeground(Color.CYAN);

        Tcardnum = new JTextField("");
        Tcardnum.setBounds(120, 35, 120, 20);

        Texp = new JTextField("");
        Texp.setBounds(120, 75, 50, 20);

        Tcvv = new JTextField("");
        Tcvv.setBounds(120, 115, 50, 20);

        Tname = new JTextField("");
        Tname.setBounds(120, 155, 120, 20);
        String totalweeks = String.valueOf(Car.carmap.get(PNum).get(6));
        y= Integer.parseInt(totalweeks)* x;
        Lprice = new JLabel("Total price: "+y );
        Lprice.setBounds(20, 180, 400, 50);
        Lprice.setForeground(Color.white);


        add(Lexp);
        add(Lcvv);
        add(Lcardnum);
        add(Lname);
        add(Lprice);
        add(Texp);
        add(Tcvv);
        add(Tcardnum);
        add(Tname);
        add(pay);

    }

    public void actionPerformed(ActionEvent arg0) {
    }

    private class Buttonsaver implements ActionListener {

        public Buttonsaver() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(pay))
            {
                String amount = String.valueOf(y);
                String period = String.valueOf(totalweeks);
                Home.bookingFile();
                Booking b = new Booking(PlNum,amount,"Visa", period);
                setVisible(false);
                dispose();

            }

        }
    }
}
