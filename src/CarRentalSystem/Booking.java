
package CarRentalSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class Booking {
    private String payment,amount,period;
    public ArrayList<String> bookingarray = new ArrayList<>();
    static public HashMap<String,ArrayList> bookingmap = new HashMap<>();


    public Booking(String PNum, String amount, String payment, String Period)
    {

Car c=new Car();
        ArrayList<String> avb =Car.carmap.get(PNum);
        avb.remove(7);
        avb.add(7,"Unavailable");
        Car.carmap.replace(PNum,avb);
        this.amount = amount;
        this.period = Period;
        this.payment = payment;
        bookingarray.add(String.valueOf(period));
        bookingarray.add(payment);
        bookingarray.add(String.valueOf(amount));
        bookingmap.put(PNum,bookingarray);

        try
        {
            File bookingdata = new File("C:\\Users\\ggrna\\Desktop\\bookingdata.dat");
            FileOutputStream foss=new FileOutputStream(bookingdata);
            ObjectOutputStream ooss=new ObjectOutputStream(foss);

            ooss.writeObject(bookingmap);
            ooss.flush();
            ooss.close();
            foss.close();

        }
        catch(Exception e)
        {

        }
        c.Carfile();
    }


    
}
