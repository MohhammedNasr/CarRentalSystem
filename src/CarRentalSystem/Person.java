
package CarRentalSystem;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Person
{
    public String  User_name,Password,Fname,Lname,Address,Phonenum,Email,Admin;
    public ArrayList<String> personarray = new ArrayList<>();
    static public HashMap<String,ArrayList> personmap = new HashMap<>();
public Person(){


}
    public Person(String user_name, String password, String fname, String lname, String email, String address, String phonenum,String admin) throws IOException {
        User_name = user_name;
        Password = password;
        Fname = fname;
        Lname = lname;
        Address = address;
        Phonenum = phonenum;
        Email = email;
        personarray.add(password);
        personarray.add(fname);
        personarray.add(lname);
        personarray.add(email);
        personarray.add(address);
        personarray.add(phonenum);
        personarray.add(admin);
        personmap.put(user_name,personarray);


        try
        {
            File data = new File("C:\\Users\\ggrna\\Desktop\\data.dat");
            FileOutputStream fos=new FileOutputStream(data);
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(personmap);
            oos.flush();
            oos.close();
            fos.close();

        }
        catch(Exception e)
        {

        }

    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhonenum() {
        return Phonenum;
    }

    public void setPhonenum(String phonenum) {
        Phonenum = phonenum;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

}
