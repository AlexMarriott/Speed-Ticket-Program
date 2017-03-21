import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 12/02/2017.
 */
public class TicketDataBase {

    private Ticket driverWriteInfo;
    private Driver getDriverInfo;
    private int driverID;
    private Scanner driverfile;
    public static int intDriverID;
    ArrayList<String> driverDetails;
    private static int incermentDriverID;

    TicketDataBase() throws IOException {
        driverWriteInfo = new Ticket();

    }

    public void saveDrivers() throws IOException {
        driverID = intDriverID;
        PrintWriter driverFile = new PrintWriter(new BufferedWriter(new FileWriter("Drivers.txt", true)));
        getDriverID();
        setDriverID();
        driverFile.println("Driver ID: " + driverID + "\n" + driverWriteInfo.getDriverInfo() + "\n[NEXT DRIVER] \n");
        driverFile.flush();
        driverFile.close();
    }

    public int getDriverID() throws FileNotFoundException {
        driverDetails = new ArrayList<>();
        boolean line;
        File file = new File("DriversID.txt");
        Scanner readIn = new Scanner(file);
        System.out.println("incermentDriverID" + incermentDriverID);
            while (readIn.hasNextLine() && (line = readIn.nextLine() != null)) {
                intDriverID++;
                System.out.println("out");
            }
        return intDriverID;

    }
    public void setDriverID() throws IOException {
        incermentDriverID = intDriverID;
        //incermentDriverID++;
        System.out.println("after adding one" + incermentDriverID);
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("DriversID.txt", true)));
        outfile.println("ID " + incermentDriverID );
        outfile.flush();
        outfile.close();
    }



    /*public void readFile() throws FileNotFoundException {
        File empFile = new File("Employee.txt");
        Scanner fileScan = new Scanner(empFile);
        while (fileScan.hasNext()) {
            String readFile = fileScan.nextLine();
            System.out.println(readFile);
        }

    }
    public ArrayList setArray() throws FileNotFoundException {
        File empFile = new File("Employee.txt");
        Scanner fileScan = new Scanner(empFile);
        int i = 0;/
        while (fileScan.hasNext()) {
            empArray.add(fileScan.nextLine());
        }
        return empArray;
    }
    public ArrayList getArray() {
        return this.empArray;
    }
    public void arrayRead(){
        int i = 0;
        while(i < getArray().size()){
            System.out.println(getArray().get(i));
            i++;
        }

    }*/

}
