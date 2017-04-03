package dvla.logic;

import java.io.*;
import java.util.Scanner;

/**
 * Created by alex on 12/02/2017.
 */
public class DatabaseWriter {

    private int driverID;
    private int vehicleID;
    private BufferedWriter driverFile;

    public void saveDrivers(String[] driverInfo) throws IOException {
        driverFile = new BufferedWriter(new FileWriter("Drivers.txt", true));
        getNextDriverID();
        setDriverID();
        driverFile.write(Integer.toString(driverID));

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
        if (driverID <= 0) {
            driverID++;
        }
        while (readIn.hasNextLine() && (line = readIn.nextLine() != null)) {
            driverID++;
        }
        return driverID;
    }

    private void setDriverID() throws IOException {
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("DriversID.txt", true)));
        outfile.println("ID " + driverID);
        outfile.flush();
        outfile.close();
    }
}
