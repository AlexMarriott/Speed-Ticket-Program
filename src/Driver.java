import java.util.Scanner;

/**
 * Created by alex on 11/02/2017.
 */
public class Driver {
    private final String dateOBirth;
    private String fullName;
    private String firstName;
    private String lastName;
    private String firstAddress;
    private String secondAddress;
    private String postCode;
    private String fullAddressAndPostcode;
    private String jobTitle;
    private String drivingLicence;
    private Scanner driverDetails = new Scanner(System.in);
    private double yearlyIncome;
    Driver(String firstName, String lastName, String dateOBirth, String firstAddress, String secondAddress, String postCode, String jobTitle, String drivingLicenceNum, double yearlyIncome){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOBirth = dateOBirth;
        this.jobTitle = jobTitle;
        this.drivingLicence = drivingLicenceNum;
        this.yearlyIncome = yearlyIncome;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.postCode = postCode;
    }
    Driver(String firstName, String lastName, String dateOBirth, String firstAddress, String secondAddress, String postCode, String drivingLicenceNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOBirth = dateOBirth;
        this.drivingLicence = drivingLicenceNum;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.postCode = postCode;
    }

}







