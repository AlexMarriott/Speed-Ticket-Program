import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 11/02/2017.
 */
public class Driver {
    private String dateOBirth;
    private String firstName;
    private String lastName;
    private String firstAddress;
    private String secondAddress;
    private String postCode;
    private String drivingLicence;
    private Scanner driverfile;
    public static int intDriverID;
    ArrayList<String> driverDetails;
    private static int incermentDriverID;
    Driver(String firstName, String lastName, String dateOBirth, String firstAddress, String secondAddress, String postCode, String drivingLicenceNum) {
        try {
            getDriverID();
            setDriverID();
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOBirth = dateOBirth;
            this.drivingLicence = drivingLicenceNum;
            this.firstAddress = firstAddress;
            this.secondAddress = secondAddress;
            this.postCode = postCode;
            intDriverID++;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getDriverID() throws FileNotFoundException {
        driverDetails = new ArrayList<>();
        intDriverID = 0;
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
        incermentDriverID++;
        System.out.println("after adding one" + incermentDriverID);
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("DriversID.txt", true)));
        outfile.println("ID " + incermentDriverID );
        outfile.flush();
        outfile.close();
    }


    }







