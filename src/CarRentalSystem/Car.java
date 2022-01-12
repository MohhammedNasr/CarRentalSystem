
package CarRentalSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Car
{
    public String Car_make, Car_model, Model_year, Car_color, Platenum,Milage,Transmition,Price,Ava;
    public ArrayList<String> cararray = new ArrayList<>();
    static public HashMap<String,ArrayList> carmap = new HashMap<>();

    public Car(String platenum,String car_make, String car_model, String model_year,String car_color,String milage,String transmition,String price,String ava)
    {
        Car_make = car_make;
        Car_model = car_model;
        Model_year = model_year;
        Car_color = car_color;
        Platenum = platenum;
        Milage = milage;
        Transmition = transmition;
        Price = price;
        Ava = ava;
        cararray.add(car_make);
        cararray.add(car_model);
        cararray.add(model_year);
        cararray.add(car_color);
        cararray.add(milage);
        cararray.add(transmition);
        cararray.add(price);
        cararray.add(ava);
        carmap.put(platenum,cararray);
        Carfile();




    }
    Car()
    {

    }


    public void Carfile()
    {
        try
        {
            File data = new File("C:\\Users\\ggrna\\Desktop\\datacar.dat");
            FileOutputStream fos=new FileOutputStream(data);
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(carmap);
            oos.flush();
            oos.close();
            fos.close();

        }
        catch(Exception e)
        {

        }

    }



    public String getCar_make() {
        return Car_make;
    }

    public void setCar_make(String car_make) {
        Car_make = car_make;
    }

    public String getCar_model() {
        return Car_model;
    }

    public void setCar_model(String car_model) {
        Car_model = car_model;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getModel_year() {
        return Model_year;
    }

    public void setModel_year(String model_year) {
        Model_year = model_year;
    }

    public String getCar_color() {
        return Car_color;
    }

    public void setCar_color(String car_color) {
        Car_color = car_color;
    }

    public String getPlatenum() {
        return Platenum;
    }

    public void setPlatenum(String platenum) {
        Platenum = platenum;
    }
}

