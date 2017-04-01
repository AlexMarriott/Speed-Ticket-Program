package dvla.logic;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alex on 12/02/2017.
 */
public class TicketDataBase {

    private int DriverID;
    private  String formattedDriverData;
    private PrintWriter driverFile;


    void saveDrivers(String[] driverData, String driverJudge, String driverFine) throws IOException {
        driverFile = new PrintWriter(new BufferedWriter(new FileWriter("Drivers.txt", true)));
        getNextDriverID();
        setDriverID();
        formattedDriverData = Arrays.toString(driverData).replace("[", "").replace("]","").replace("{", "").replace("}","");
        driverFile.println(DriverID);
        for(String data :driverData){
            driverFile.println(driverData);
        }
        driverFile.println(driverFine);

        driverFile.close();
        driverFile.flush();
    }

    private int getNextDriverID() throws FileNotFoundException {
        boolean line;
        File file = new File("DriversID.txt");
        Scanner readIn = new Scanner(file);
        if (DriverID <= 0) {
            DriverID++;
        }
        while (readIn.hasNextLine() && (line = readIn.nextLine() != null)) {
            DriverID++;
        }
        return DriverID;
    }

    private void setDriverID() throws IOException {
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("DriversID.txt", true)));
        outfile.println("ID " + DriverID);
        outfile.flush();
        outfile.close();
    }

}
