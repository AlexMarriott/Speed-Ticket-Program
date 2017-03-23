import java.util.Arrays;

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
    private String[] driverData;

    Driver(String firstName, String lastName, String dateOBirth, String firstAddress, String secondAddress, String postCode, String drivingLicenceNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOBirth = dateOBirth;
        this.drivingLicence = drivingLicenceNum;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.postCode = postCode;
    }

    public Driver()
    {
        driverData = new String[]{firstName, lastName, dateOBirth, firstAddress, secondAddress, postCode, drivingLicence};
        System.out.println(Arrays.asList(driverData));

    };

    public String[] getDriverObject()
    {
        return driverData;
    }
}







