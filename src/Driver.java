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
    private String[] driverData = new String[7];

    Driver() {
    }

    public void setDriver(String[] driverArray)
    {
        driverData = driverArray;

    }

    public String[] getDriver()
    {
        return driverData;
    }
}







