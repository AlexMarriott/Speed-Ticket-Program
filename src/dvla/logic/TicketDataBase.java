package dvla.logic;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alex on 12/02/2017.
 */
public class TicketDataBase {
    private int intDriverID;

    public void saveDrivers(String[] driverData, String driverJudge) throws IOException {
        PrintWriter driverFile = new PrintWriter(new BufferedWriter(new FileWriter("Drivers.txt", true)));
        getDriverID();
        setDriverID();
        System.out.println(driverJudge);
        driverFile.println("Driver ID: " + intDriverID + "\n" + Arrays.asList(driverData) + "\n" + driverJudge +  " \n");
        driverFile.close();
        driverFile.flush();
    }

    public int getDriverID() throws FileNotFoundException {
        boolean line;
        File file = new File("DriversID.txt");
        Scanner readIn = new Scanner(file);
        if (intDriverID <= 0) {
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
        outfile.println("ID " + intDriverID);
        outfile.flush();
        outfile.close();
    }

}
