
package Assignment1;
import java.lang.Math;


public class hospital {
    private String hospName;
    private int uniqueID;
    private int pinCode;

    hospital(){}
    hospital(String Hosp, int Pin){
        this.hospName=Hosp;
        this.pinCode=Pin;
        this.uniqueID=(int)(Math.random()*10000);
        this.registerHospital();
    }


    public void registerHospital(){
        System.out.print("Hospital Name: "+ hospName+ ", ");
        System.out.print("PinCode: "+ pinCode+ ", ");
        System.out.println("Unique ID: "+ uniqueID);

    }


    public void setPinCode(int p){
        this.pinCode=p;
    }
    public int getPinCode(){
        return pinCode;
    }public void setHospName(String h){
        this.hospName=h;
    }
    public String getHospName(){
        return hospName;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public void displayHosp(){

        System.out.print(pinCode+" ");
        System.out.println(hospName);
    }


    public static void main(String[] args) {

    }
}
