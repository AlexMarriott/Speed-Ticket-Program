import java.util.Scanner;

/**
 * Created by Alex on 08/02/2017.
 */
public class IssueTicket {
    public IssueTicket() {

    }
    private Scanner scanSpeed = new Scanner(System.in);
    private int driversSpeed;
    private String roadCheck;
    private int road;
    private int[] speedCheck = {10, 20, 30, 40, 50, 60, 70, 80};
    private String[] roadType = {"ResidentialRoad", "MainRoad", "SchoolZone", "SingleCarriageway", "DualCarriageway"};

    public void setCapturedSpeed() {
        System.out.println("What was the Drivers Speed");
        driversSpeed = scanSpeed.nextInt();
    }
//
    public int getCapturedSpeed() {
        return this.driversSpeed;
    }

    public void setRoad() {
        System.out.println("What type of road was it?");
        System.out.println("0.Residential road \n 1.Main road \n 2.School Zone \n 3.Single Carriageway \n 4.Dual Carriageway");
        road = scanSpeed.nextInt();
        switch (road) {
            case 0:
                System.out.println("Residential road");
                roadCheck = roadType[road];
                break;
            case 1:
                System.out.println("Main road");
                roadCheck = roadType[road];
                break;
            case 2:
                System.out.println("School Zone");
                roadCheck = roadType[road];
                break;
            case 3:
                System.out.println("Single Carriageway");
                roadCheck = roadType[road];
                break;
            case 4:
                System.out.println("Dual Carriageway");
                roadCheck = roadType[road];
                break;
        }
    }

    public String getRoad() {
        System.out.println(this.roadCheck);
        return this.roadCheck;
    }
    public void checkSpeedResidentialRoad() {
        if (!(roadCheck == roadType[0])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was6 " + getCapturedSpeed() + " .");
                //else if(getCapturedSpeed() < speedCheck[])
            }
        }
    }

    public void checkSpeedMainRoad() {
        if (!(roadCheck == roadType[1])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was6 " + getCapturedSpeed() + " .");
                //else if(getCapturedSpeed() < speedCheck[])
            }
        }
    }
    public void checkSpeedSchoolZone() {
        if (!(roadCheck == roadType[2])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was6 " + getCapturedSpeed() + " .");
                //else if(getCapturedSpeed() < speedCheck[])
            }
        }
    }
    public void checkSpeedSingleCarriageway() {
        if (!(roadCheck == roadType[3])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was6 " + getCapturedSpeed() + " .");
                //else if(getCapturedSpeed() < speedCheck[])
            }
        }
    }
    public void checkSpeedDualCarriageway() {
        if (!(roadCheck == roadType[4])) {
            System.out.println("The RoadType has not be chosen");
        } else {
            if (getCapturedSpeed() <= speedCheck[0] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was1 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[1] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was2 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[2] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was3 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[3] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was4 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() <= speedCheck[4] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was5 " + getCapturedSpeed() + " .");
            } else if (getCapturedSpeed() >= speedCheck[7] && roadCheck == roadType[road]) {
                System.out.println("The road Type is " + roadType[road] + " and their speed was6 " + getCapturedSpeed() + " .");
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


