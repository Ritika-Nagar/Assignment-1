package Assignment1;

import java.util.ArrayList;

public class portal {
    private hospital hosp;
    citizen cit;
    vaccine v;




    public portal(){

    }

    public void status(){

        String s= cit.getName();
        String vi =v.getNameofVaccine();
        System.out.print(s+" vaccinated with ");
        System.out.println(vi);
    }

    public void setHosp(){

    }

    public int displayHosp(){

        int pinCode= hosp.getPinCode();
        String hospName =hosp.getHospName();

        System.out.print(pinCode+" ");
        System.out.println(hospName);
        return pinCode;
    }






    public void listHosp(slot s){
        //String k = s.getVaccine();
        int l =s.getQuant();
        int d= s.getDayNum();
        System.out.print("Day: "+d);
       // System.out.println(k+" Availability Qty: "+ l);


    }


    public void displaySlot(String s){

        System.out.println("Day 1 vaccine: "+s);

    }


    public static void main(String[] args) {
        portal p=new portal();




    }
}
