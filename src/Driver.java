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
    private String strDriverID;
    public static int intDriverID;
    ArrayList<String> driverDetails;
    String[] splitUserID;

    Driver(String firstName, String lastName, String dateOBirth, String firstAddress, String secondAddress, String postCode, String drivingLicenceNum) {
        try {
            getDriverID();
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
        strDriverID = "";
        //Can just write a file which will have numbers within the file which it reads from.

        File file = new File("Drivers.txt");
        Scanner readIn = new Scanner(file);

        while (readIn.hasNext()) {
            driverDetails.add(readIn.nextLine());
        }
        if(readIn.hasNextLine()){

            strDriverID = driverDetails.get(driverDetails.size() - 7);
            splitUserID = strDriverID.split(" ");
            intDriverID = Integer.parseInt(splitUserID[2]);
    }
        return intDriverID;

    }
}







