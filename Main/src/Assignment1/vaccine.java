package Assignment1;



public class vaccine {
    private String nameOfVaccine;
    private int noOfDoses;
    private int gap;




    public vaccine(String name, int doses, int dGap) {

        nameOfVaccine = name;
        noOfDoses = doses;
        gap = dGap;
        this.AddVaccine();

    }


    public void setNameOfVaccine(String v) {
        this.nameOfVaccine = v;

    }

    public String getNameofVaccine() {

        return nameOfVaccine;
    }

    public void AddVaccine() {


        System.out.print("Vaccine Name: "+nameOfVaccine+", ");
        System.out.print("Number of Doses: "+noOfDoses+", ");
        System.out.println("Gap between Doses: "+gap);


}







    public static void main(String[] args) {


    }
}

