package dvla.logic;

import java.io.*;
import java.util.Scanner;

/**
 * Created by alex on 12/02/2017.
 */
public class DatabaseWriter {

    private int DriverID;
    private BufferedWriter driverFile;
    public void saveDrivers(String[] driverInfo) throws IOException {
        driverFile = new BufferedWriter(new FileWriter("Drivers.txt", true));
        getNextDriverID();
        setDriverID();
        driverFile.write(Integer.toString(DriverID));

        for(int i = 0; i <driverInfo.length; i++){
            driverFile.write("\n" +driverInfo[i]);
        }
        driverFile.write("\n");

        driverFile.flush();
        driverFile.close();
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
