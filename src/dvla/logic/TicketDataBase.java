package dvla.logic;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alex on 12/02/2017.
 */
public class TicketDataBase {
    private int intDriverID;
    public String formattedDriverData;
    private PrintWriter driverFile;


    public void saveDrivers(String[] driverData, String driverJudge, String driverFine) throws IOException {
        driverFile = new PrintWriter(new BufferedWriter(new FileWriter("Drivers.txt", true)));
        getDriverID();
        setDriverID();
        System.out.println(driverJudge);
        formattedDriverData = Arrays.toString(driverData).replace("[", "").replace("]","").replace("{", "").replace("}","");
        driverFile.println(intDriverID);
        int i;
        for (i=0; i<driverData.length; i++){
            driverFile.println(driverData[i]);
        }
        driverFile.println(driverFine);

        //Driver Judge may or may not be included within this.
        //driverFile.println(intDriverID + ", " + formattedDriverData + ", " + driverJudge);
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
