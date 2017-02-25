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
    private int driverID;

    Driver(int driverID, String firstName, String lastName, String dateOBirth, String firstAddress, String secondAddress, String postCode, String drivingLicenceNum){
        this.driverID = driverID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOBirth = dateOBirth;
        this.drivingLicence = drivingLicenceNum;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.postCode = postCode;
    }


}







