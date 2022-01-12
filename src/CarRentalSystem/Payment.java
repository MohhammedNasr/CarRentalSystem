
package CarRentalSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Payment extends JFrame implements ActionListener {
    JLabel make,model,year,color,milage,price,Availability,platenum,trans,date1;
    JButton visa,cash,Return;
    JComboBox date;
    Integer[] weeks=new Integer[100];
    String PNum;
    Payment(String x)
    {
        PNum=x;
        Home.carFile();
        setVisible(true);
        setSize(500,500);
        setTitle("Book");
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Return= new JButton("RETURN");
        Return.setBounds(185, 360, 120, 50);
        Return.addActionListener(new Buttonsaver());
        
        cash= new JButton("CASH");
        cash.setBounds(120, 300, 120, 50);
        cash.addActionListener(new Buttonsaver());
        
        visa= new JButton("VISA");
        visa.setBounds(260, 300, 120, 50);
        visa.addActionListener(new Buttonsaver());
        
        platenum=new JLabel("Plate Number:  " + x);
        platenum.setBounds(20,140 ,200,50);
        platenum.setForeground(Color.CYAN);
        
        make=new JLabel("Make:  " + Car.carmap.get(x).get(0));
        make.setBounds(20,20,200,50);
        make.setForeground(Color.CYAN);

        year=new JLabel("Year:  " + Car.carmap.get(x).get(2));
        year.setBounds(20,60 ,200,50);
        year.setForeground(Color.CYAN);

        Availability=new JLabel("Availability:  " + Car.carmap.get(x).get(7));
        Availability.setBounds(20,120,200,50);
        Availability.setForeground(Color.CYAN);

        color=new JLabel("Color:  " + Car.carmap.get(x).get(3));
        color.setBounds(20, 80, 200, 50);
        color.setForeground(Color.CYAN);

        model=new JLabel("Model:  " + Car.carmap.get(x).get(1));
        model.setBounds(20,40,200,50);
        model.setForeground(Color.CYAN);

        milage=new JLabel("Milage:  " + Car.carmap.get(x).get(4));
        milage.setBounds(20, 100,200,50);
        milage.setForeground(Color.CYAN);

        price=new JLabel("Price per day:  " + Car.carmap.get(x).get(6));
        price.setBounds(20, 160, 200, 50);
        price.setForeground(Color.CYAN);

        trans=new JLabel("Transmition:  " + Car.carmap.get(x).get(5));
        trans.setBounds(20, 180, 200, 50);
        trans.setForeground(Color.CYAN);

        date1=new JLabel("Number of days ");
        date1.setBounds(20,200,200,50);
        date1.setForeground(Color.CYAN);
        for(int i=0;i<100;i++)
        {
            weeks[i]=i+1;
        }
        date = new JComboBox(weeks);
        date.setBounds(135, 218 , 100, 20);


        add(make);
        add(milage);
        add(platenum);
        add(color);
        add(price);
        add(year);
        add(Availability);
        add(model);
        add(Return);
        add(cash);
        add(visa);
        add(date);
        add(trans);
        add(date1);
    }

   @Override
    public void actionPerformed(ActionEvent arg0) {
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
                Car_List c = new Car_List();
                setVisible(false);
                dispose();

            }
            if(e.getSource().equals(visa))
            {

                Payment_Visa s = new Payment_Visa( (int) date.getSelectedItem(),PNum);



            }
            if(e.getSource().equals(cash))
            {
                Payment_Cash cash = new Payment_Cash( (int) date.getSelectedItem());

            }
             

            
        }
    }
}


