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
    public SpeedingTicket() {

    }
    private Scanner scanSpeed = new Scanner(System.in);
    private int driversSpeed;
    private String roadCheck;
    private int Road;
    private int[] speedCheck = {10, 20, 30, 40, 50, 60, 70, 80};
    private String[] roadType = {"ResidentialRoad", "MainRoad", "SchoolZone", "SingleCarriageway", "DualCarriageway"};


    public void setCapturedSpeed() {
        System.out.println("What was the Drivers Speed");
        driversSpeed = scanSpeed.nextInt();
    }

    public int getCapturedSpeed() {
        return this.driversSpeed;
    }

    public void setRoad() {
        System.out.println("What type of road was it?");
        System.out.println("0.Residential Road \n 1.Main road \n 2.School Zone \n 3.Single Carriageway \n 4.Dual Carriageway");
        Road = scanSpeed.nextInt();
        switch (Road) {
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

    public String getRoad() {
        System.out.println(this.roadCheck);
        return this.roadCheck;
    }
    public void CheckSpeedResidentialRoad() {
        if (!(roadCheck == roadType[0])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was6 " + getCapturedSpeed() + " .");
                //else if(getCapturedSpeed() < speedCheck[])
            }
        }
    }

    public void CheckSpeedMainRoad() {
        if (!(roadCheck == roadType[1])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was6 " + getCapturedSpeed() + " .");
                //else if(getCapturedSpeed() < speedCheck[])
            }
        }
    }
    public void CheckSpeedSchoolZone() {
        if (!(roadCheck == roadType[2])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was6 " + getCapturedSpeed() + " .");
                //else if(getCapturedSpeed() < speedCheck[])
            }
        }
    }
    public void CheckSpeedSingleCarriageway() {
        if (!(roadCheck == roadType[3])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was6 " + getCapturedSpeed() + " .");
                //else if(getCapturedSpeed() < speedCheck[])
            }
        }
    }
    public void CheckSpeedDualCarriageway() {
        if (!(roadCheck == roadType[4])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[Road]) {
                System.out.println("The Road Type is " + roadType[Road] + " and their speed was6 " + getCapturedSpeed() + " .");
                //else if(getCapturedSpeed() < speedCheck[])
            }
        }
    }



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


