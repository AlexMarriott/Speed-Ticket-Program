package dvla.logic;

import java.io.IOException;

/**
 * <h1> Driver</h1>
 * The Driver Objects lets AddDriver class to pass through the drivers information along with their speed and the road type. The Driver object is able to compare the speed of the driver and determine if
 * they broke the law and should be fined. This is passed back to the AddDriverGUI and all driver information is passed to the Database Writer class to be written to the Drivers.txt file, along with the
 * Action required messages and fine info.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class Driver {

    /**Declares a String named firstName, this is the drivers First Name.*/
    private String firstName;

    /**Declares a String named lastName, This is the drivers LastName.*/
    private String lastName;

    /**Declares a String named dateOfBirth, this is the Drivers date of birth.*/
    private String dateOfBirth;

    /**Declares a String named drivingLicenceNum, this is the drivers Driving Licence number.*/
    private String drivingLicenceNum;

    /**Declares a String named firstAddressLine, this is the Drivers First Line of Address.*/
    private String firstAddressLine;

    /**Declares a String named secondAddressList, this is the Drivers second Line of Address.*/
    private String secondAddressLine;

    /**Declares a String named postCode, this is the drivers PostCode*/
    private String postCode;

    /**Declares a Jlabel named roadType, this is used to define the roadtype.*/
    private String roadType;

    /**Declares a String named message, this is passed through to the Database writer.*/
    private String message;

    /**Declares a String named ticketReturnMessage, this is show to the user via a prompt once they add the new driver.*/
    private String ticketReturnMessage;

    /**Declares a String named driverFine, this is passed through to the Database writer.*/
    private String driverFine;

    /**Declares a int named roadSpeed, this is passed through to the Database writer and used to check if the driver is issued a ticket.*/
    private int roadSpeed;

    /**Declares a int named driverSpeed, this is passed through to the Database writer and used to check if the driver is issued a ticket.*/
    private int driverSpeed;

    /**Declares a int named speedDifference, this is used to check what the difference in speed was.*/
    private int speedDifference;

    /**Declares a int named ticketThreshold, This is used when checking the users speed.*/
    private int ticketThreshold;

    /**Declares a int named countDateThreshold. This is used to check if the driver is issued a ticket.*/
    private int countDateThreshold;

    /**Declares a int named drivingFine, This is the fine which will be issued to the driver if nthey have gone over the speed limit.*/
    private int drivingFine;

    /**Declares a int named penaltyPoints, these are the points which will be issued to the driver if they have gone over the speed limit.*/
    private int penaltyPoints;

    /**Declaring a new DatabaseWriter Object called writingDataToDatabase*/
    private DatabaseWriter writingDataToDatabase;



    /**The DriverMethod allows basic information about the driver be passed to it, so its can set all the above variables with the most current drivers information.
     * @param firstName         First name of the Driver
     * @param lastName          Last Name of the Driver
     * @param dateOfBirth       Date of brith of the Driver
     * @param drivingLicenceNum Driving Licence Number of the Driver
     * @param firstAddressLine  First line of Address of the Driver
     * @param secondAddressLine Second line of Address for the Driver
     * @param postCode          Postcode of the Driver
     * @param roadSpeed         RoadSpeed of the Road the driver was caught on
     * @param roadType          Type of Road the ddriver was caught on
     * @param driverSpeed       DriverSpeed of the road they were caught on
     * @param speedDifference   The speed difference between drivers Speed and the Road Speed
     * */
    public Driver(String firstName, String lastName, String dateOfBirth, String drivingLicenceNum, String firstAddressLine, String secondAddressLine, String postCode, int roadSpeed,String roadType, int driverSpeed, int speedDifference){
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.drivingLicenceNum = drivingLicenceNum;
            this.firstAddressLine = firstAddressLine;
            this.secondAddressLine = secondAddressLine;
            this.postCode = postCode;
            this.roadSpeed = roadSpeed;
            this.roadType = roadType;
            this.driverSpeed = driverSpeed;
            this.speedDifference = speedDifference;
    }

    /**The SpeedCheck method takes the driversSpeed and Roadtype parameters and checks if the drivers speed was greater then the speed limit via a series of if statements.
     * if the speed was greater than a action required is issues along with a fine or points on there license.
     * @param driverSpeed The Drivers Speed
     * @param roadType The Road Type
     * */
    public void speedCheck(int driverSpeed, String roadType) {
        ticketThreshold = roadSpeed + (roadSpeed * 10 / 100 + 2);
        countDateThreshold = ticketThreshold + (ticketThreshold * 46 / 100);
        // Trying to reduce the amount of repeating going on in the if statements.
        ticketReturnMessage = "Name:" + firstName + "\nSpeed logged: " + driverSpeed+ "MPH" + "\nType of Road: " + roadType + "\nAction Required: ";

        if (driverSpeed > roadSpeed && driverSpeed < ticketThreshold) {
            message = "Driver was over the speed limit but within reason, issue a warning. ";
            ticketReturnMessage = ticketReturnMessage + message;

        } else if (driverSpeed >= ticketThreshold && driverSpeed < countDateThreshold) {
            message = "Issuing speeding fine for the speed of: " + driverSpeed + "MPH";
            drivingFine = 50;
            ticketReturnMessage = ticketReturnMessage + message + "\nDriver Must pay: "+ "£"+drivingFine;

        } else if (driverSpeed >= countDateThreshold) {
            message = "Driver exceeded the Speed limit by: " + (driverSpeed - roadSpeed)+ "MPH" + " Driver will be issued a ticket and count date.";
            drivingFine = 100;
            penaltyPoints = 3;
            ticketReturnMessage = ticketReturnMessage + message + "\nDriver Must pay: " + "£"+drivingFine + "\nDriver Will receive " + penaltyPoints + " points on their license.";

        } else {
            message = "Driver is under the Speed limit. No action will be taken.";
            ticketReturnMessage = ticketReturnMessage + message;
        }
    }

    /**This method gets the ticketReturnMessage which will be displayed to the user via a prompt on the AddDriverGUI.
     * @return ticketReturnMessage */
    public String getTicketResult() {
        return ticketReturnMessage;
    }

    /**This method sets the drivers fine which will used in the driverInfo array. */
    public void setDriversFine() {
        driverFine = String.valueOf(drivingFine);
    }

    /**This method sets the driverInfo array with all the drivers information and returns it ready to be passed through to Database writer.
     * @return driverInfo*/
    private  String[] setDriverInfo(){
        String[] driverInfo = {firstName,lastName,
                dateOfBirth,drivingLicenceNum,
                firstAddressLine,secondAddressLine,
                postCode,roadType, String.valueOf(roadSpeed),
                String.valueOf(driverSpeed), String.valueOf(speedDifference),
                driverFine,message};

        return driverInfo;
    }
    /**This method initialises the writingDataToDatabase object and passes through the driverInfo array to the saveDrives method in DatabaseWriter.   */
    public void getDriverInfo(){
        writingDataToDatabase = new DatabaseWriter();
        try {
            writingDataToDatabase.saveDrivers(setDriverInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
