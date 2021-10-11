package Assignment1;

public class slot {
    private int hospID;
    private int numOfSlots;
    private int dayNum;
    private int quant;
    private String vacName;

    public String getVacName() {
        return vacName;
    }

    public void setVacName(String vacName) {
        this.vacName = vacName;
    }

    public slot(){}

    public int getNumOfSlots() {
        return numOfSlots;
    }



    public void setNumOfSlots(int numOfSlots) {
        this.numOfSlots = numOfSlots;
    }

    public int getHospID() {
        return hospID;
    }

    public void setHospID(int hospID) {
        this.hospID = hospID;
    }

    public void setDayNum(int d){
        this.dayNum=d;

    }
    public int getDayNum(){
        return dayNum;
    }
    public void setQuant(int q){
        this.quant=q;

    }
    public int getQuant(){
        return quant;
    }


    public slot(int Hosp, int slots, int day, int quanti, String str){
        this.hospID=Hosp;
        this.numOfSlots=slots;
        this.dayNum=day;
        this.quant=quanti;
        this.vacName=str;
        //this.option= op;

        this.createSlots();





    }

    public void createSlots(){


            System.out.print("Slot added by hospital " + hospID);
            System.out.print(" for Day:" + dayNum + ", ");
            System.out.print("Available quantity: " + quant);
            System.out.println(" of Vaccine " + vacName);


        }





    public static void main(String[] args) {

        
    }
}
