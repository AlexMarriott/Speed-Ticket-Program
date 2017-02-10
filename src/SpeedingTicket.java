import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alex on 08/02/2017.
 */
public class SpeedingTicket {
    public SpeedingTicket(){};

    private Scanner scanSpeed = new Scanner(System.in);
    private int driversSpeed;
    private String roadCheck;
    private int Road;
    private int[] speedCheck = {10,20,30,40,50,60,70,80};
    private String[] roadType = {"ResidentialRoad", "MainRoad","SchoolZone","SingleCarriageway", "DualCarriageway"};
    private String fullName;
    private int Age;
    private String fullAddressAndPostcode;
    private String jobTitle;
    private double yearlyIncome;
    private String NI;

    public void setCapturedSpeed(){
        System.out.println("What was the Drivers Speed");
        driversSpeed = scanSpeed.nextInt();
    }

    public int getCapturedSpeed(){
        return this.driversSpeed;
    }

    public void setRoad(){
        System.out.println("What type of road was it?");
        System.out.println("0.Residential Road \n 1.Main road \n 2.School Zone \n 3.Single Carriageway \n 4.Dual Carriageway");
        Road = scanSpeed.nextInt();
        switch (Road){
            case 0:
                    System.out.println("Residential Road");
                    roadCheck = roadType[Road];
                    break;
            case 1:
                    System.out.println("Main road");
                    roadCheck = roadType[Road];
                    break;
            case 2:
                    System.out.println("School Zone");
                    roadCheck = roadType[Road];
                    break;
            case 3:
                    System.out.println("Single Carriageway");
                    roadCheck = roadType[Road];
                    break;
            case 4:
                    System.out.println("Dual Carriageway");
                    roadCheck = roadType[Road];
                    break;
        }

    }

    public String getRoad(){
        System.out.println(this.roadCheck);
        return this.roadCheck;
    }
    public void CheckDriversSpeed(){
        if(getCapturedSpeed() < speedCheck[0]){
            System.out.println("this worked?");
        }
        //else if(getCapturedSpeed() < speedCheck[])
    }
























    /*public void readFile() throws FileNotFoundException {
        File empFile = new File("Employee.txt");
        Scanner fileScan = new Scanner(empFile);
        while (fileScan.hasNext()) {
            String readFile = fileScan.nextLine();
            System.out.println(readFile);
        }

    }*/
  /*  public ArrayList setArray() throws FileNotFoundException {
        File empFile = new File("Employee.txt");
        Scanner fileScan = new Scanner(empFile);
        int i = 0;
        while (fileScan.hasNext()) {
            empArray.add(fileScan.nextLine());
        }
        return empArray;
    }*/

}
