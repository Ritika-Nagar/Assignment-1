package Assignment1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Array list for classes
        ArrayList<String> vaccineList = new ArrayList<String>();
        ArrayList<slot> slotList = new ArrayList<slot>();
        //ArrayList<citizen> citizenList = new ArrayList<citizen>();


        // Maps
        Map<Integer, ArrayList<hospital>> hospitalMap = new HashMap<Integer, ArrayList<hospital>>();
        Map<Integer, ArrayList<slot>> slotMap = new HashMap<Integer, ArrayList<slot>>();
        Map<Integer, ArrayList<citizen>> citizenMap = new HashMap<Integer, ArrayList<citizen>>();
        Map<String, ArrayList<vaccine>> vaccineMap = new HashMap<String, ArrayList<vaccine>>();


        Scanner sc = new Scanner(System.in);
        System.out.println("CoWin Portal initialized....\n" +
                "---------------------------------\n" +
                "1. Add Vaccine\n" +
                "2. Register Hospital\n" +
                "3. Register Citizen\n" +
                "4. Add Slot for Vaccination\n" +
                "5. Book Slot for Vaccination\n" +
                "6. List all slots for a hospital\n" +
                "7. Check Vaccination Status\n" +
                "8. Exit\n" +
                "---------------------------------\n");


        System.out.println("Your Programme is ready to Run ---->");
        int noOfOP = sc.nextInt();


        for (int i = 0; i < noOfOP; i++) {
            int inp = sc.nextInt();


            // Add vaccine
            if (inp == 1) {
                String vacName;
                System.out.print("Vaccine Name: ");
                vacName = sc.next();
                System.out.print("Number of Doses: ");
                int nofDose = sc.nextInt();
                System.out.print("Gap between Doses: ");
                int gap = sc.nextInt();
                vaccineMap.put(vacName, new ArrayList<vaccine>());
                vaccineMap.get(vacName).add(new vaccine(vacName,nofDose,gap));

                vaccineList.add(vacName);
                System.out.println("---------------------------------");


            }

            // Register hospital
            if (inp == 2) {
                String hospName;
                System.out.print("Hospital Name: ");
                hospName = sc.next();
                System.out.print("PinCode: ");
                int PCode = sc.nextInt();
                System.out.println("---------------------------------");

                if (hospitalMap.containsKey(PCode)) {
                    ArrayList<hospital> hList = hospitalMap.get(PCode);
                    hList.add(new hospital(hospName, PCode));
                } else {
                    hospitalMap.put(PCode, new ArrayList<hospital>());

                    hospitalMap.get(PCode).add(new hospital(hospName, PCode));
                }
            }


            // Register citizens
            if (inp == 3) {
                String citName;
                System.out.print("Citizen Name: ");
                citName = sc.next();
                System.out.print("Age: ");
                int Age = sc.nextInt();
                System.out.print("Unique ID: ");
                int uID = sc.nextInt();

                citizenMap.put(uID, new ArrayList<citizen>());
                citizenMap.get(uID).add(new citizen(citName,Age,uID));
                if (Age < 18) {
                    System.out.println("Only above 18 are allowed");
                }
                System.out.println("REGISTERED");
                System.out.println("---------------------------------");


            }


            // Add slots for vaccinations
            if (inp == 4) {

                int hospID; // ID entered by hospital
                System.out.print("Enter Hospital ID: ");
                hospID = sc.nextInt(); //Hospital ID
                System.out.print("Enter the number of slots to be added: ");
                int slots = sc.nextInt(); //Number of slots
                for (int j = 0; j < slots; j++) {
                    System.out.print("Enter Day Number: ");
                    int dayNum = sc.nextInt();// Day Number
                    System.out.print("Enter Quantity: ");
                    int quant = sc.nextInt();
                    System.out.println("Select Vaccine :");

                    Iterator<String> it = vaccineList.iterator();
                    while(it.hasNext()) {
                        System.out.println(it.next());
                    }

                    int a = sc.nextInt();
                    String str = vaccineList.get(a);
                    if(slotMap.containsKey(hospID)){
                       ArrayList<slot> sList= slotMap.get(hospID);
                       sList.add(new slot(hospID,slots,dayNum,quant,str));
                    }
                    else{
                        slotMap.put(hospID,new ArrayList<slot>());
                        slotMap.get(hospID).add(new slot(hospID,slots,dayNum,quant,str));
                    }
                    System.out.println("---------------------------------");

                }
            }


            // Book slots for vaccination

            if (inp == 5) {
                System.out.print("Enter patient Unique ID:");
                int ID = sc.nextInt();
                ArrayList<citizen> citList = citizenMap.get(ID);
                Iterator<citizen> citiz = citList.iterator();
                while (citiz.hasNext()) {
                    citizen citizen = citiz.next();

                    if (ID == citizen.getUniqueID()) {
                        System.out.println("1. Search by area");
                        System.out.println("2. Search by Vaccine");
                        System.out.println("3. Exit");
                        System.out.print("Enter option: ");
                        int var = sc.nextInt();
                        System.out.print("Enter PinCode: "); //Enter the pinCode to check for the available hospital
                        int pCode = sc.nextInt();

                        ArrayList<hospital> hosp = hospitalMap.get(pCode);

                        Iterator<hospital> it = hosp.iterator();
                        while(it.hasNext()) {
                            hospital h = it.next();
                            System.out.print(h.getUniqueID() + " ");
                            System.out.println(h.getHospName());
                        }
                        System.out.println("Enter Hospital ID: ");
                        int hoID = sc.nextInt();
                        ArrayList<slot> slo = slotMap.get(hoID);
                        Iterator<slot> s = slo.iterator();
                        while (s.hasNext()) {
                            slot sl = s.next();
                            int n = sl.getNumOfSlots();
                            System.out.print("->" + " Day ");
                            System.out.print(sl.getDayNum() + " ");
                            System.out.print("Available Qty: " + sl.getQuant());
                            System.out.println(" Vaccine: " + sl.getVacName());
                        }
                        System.out.print("Choose Slot: ");
                        int cho = sc.nextInt();
                        ArrayList<citizen> citi = citizenMap.get(ID);
                        Iterator<citizen> cit = citi.iterator();
                        while (cit.hasNext()) {
                            citizen c = cit.next();
                            System.out.print(c.getName() + "  vaccinated with "+ slotMap.get(hoID).get(cho).getVacName());
                            System.out.println();
                        }


                        System.out.println("---------------------------------");

                    }
                }
            }

            // List all hospital for Vaccination
            if(inp==6){
            System.out.print("Enter Hospital ID: ");
                int hoID = sc.nextInt();
                ArrayList<slot> slo = slotMap.get(hoID);
                Iterator<slot> s = slo.iterator();
                while (s.hasNext()) {
                    slot sl = s.next();
                    int n = sl.getNumOfSlots();
                    System.out.print("->" + " Day ");
                    System.out.print(sl.getDayNum() + " ");
                    System.out.print("Available Qty: " + sl.getQuant());
                    System.out.println(" Vaccine: " + sl.getVacName());
                }


            }

            // Check vaccination status

            if(inp==7){
                System.out.print("Enter patient Unique ID: ");
                int pID= sc.nextInt();


            }






        }
    }
}












