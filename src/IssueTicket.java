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
    //private int[] speedCheck = {10, 20, 30, 40, 50, 60, 70, 80};
    //private String[] roadType = {"ResidentialRoad", "MainRoad", "SchoolZone", "SingleCarriageway", "DualCarriageway"};

    public void setCapturedSpeed() {
        System.out.println("What was the Drivers Speed");
        driversSpeed = scanSpeed.nextInt();
    }
//
    public int getCapturedSpeed() {
        return this.driversSpeed;
    }

    /*public void setRoad() {
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
    }*/

  /*  public String getRoad() {
        System.out.println(this.roadCheck);
        return this.roadCheck;
    }*/

    public void speedCheck(int driversSpeed, int roadSpeed ) {
        int ticketThershold = roadSpeed + (roadSpeed * 10 / 100 + 2);
        int countDateThershold = ticketThershold + (ticketThershold  *46 / 100);
        System.out.println(driversSpeed + " "+" "+ roadSpeed);
        System.out.println(ticketThershold);
        System.out.println(countDateThershold);
        if (driversSpeed > roadSpeed && driversSpeed < ticketThershold){
            System.out.println("Ayyy your going a little fast be careful " + driversSpeed);
            }else if(driversSpeed >= ticketThershold && driversSpeed < countDateThershold){
            System.out.println("Issuing Ticket for the speed of:  " + driversSpeed) ;
        }else if (driversSpeed >= countDateThershold ){
            System.out.println("Driver exceeded the Speed limt by: " + (driversSpeed - roadSpeed) + " \nDriver will be issued a ticket and count date \nDrivers speed was: " + driversSpeed) ;
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


