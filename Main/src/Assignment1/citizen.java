package Assignment1;

public class citizen {
    private String name;
    private int age;
    private int uniqueID;
    public citizen(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public citizen(String Name, int Age, int UniqueID){
        this.name=Name;
        this.age=Age;
        this.uniqueID=UniqueID;
        this.registerCitizen();
    }

    public void setName(String s){
        this.name=s;
    }
    public String getName(){
        return name;
    }



    public void registerCitizen() {

        System.out.print("Citizen Name: "+name+", ");
        System.out.print("Age: "+age+", ");
        System.out.println("UniqueID : "+uniqueID);





    }





    public static void main(String[] args) {




    }
}
