import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 12/02/2017.
 */
public class TicketDataBase {

    private Ticket driverWriteInfo;
    private Driver getDriverInfo;
    private Scanner driverfile;
    private  int intDriverID;
    ArrayList<String> driverDetails;

    TicketDataBase() throws IOException {
        driverWriteInfo = new Ticket();

    }
    public void saveDrivers() throws IOException {
        PrintWriter driverFile = new PrintWriter(new BufferedWriter(new FileWriter("Drivers.txt", true)));
        getDriverID();
        setDriverID();
        driverFile.println("Driver ID: " + intDriverID + "\n" + driverWriteInfo.getDriverInfo() + "\n[NEXT DRIVER] \n");
        driverFile.flush();
        driverFile.close();
    }
    public int getDriverID() throws FileNotFoundException {
        driverDetails = new ArrayList<>();
        boolean line;
        File file = new File("DriversID.txt");
        Scanner readIn = new Scanner(file);
        if (intDriverID < 0){
            intDriverID++;
        }
            while (readIn.hasNextLine() && (line = readIn.nextLine() != null)) {
                intDriverID++;
                System.out.println(intDriverID);
            }
        return intDriverID;
    }
    public void setDriverID() throws IOException {
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("DriversID.txt", true)));
        outfile.println("ID " + intDriverID );
        outfile.flush();
        outfile.close();
    }

}
