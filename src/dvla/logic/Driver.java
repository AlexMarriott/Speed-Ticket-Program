package dvla.logic;

import java.io.IOException;

/**
 * Created by alex on 02/04/2017.
 */
public class Driver {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String drivingLicenceNum;
    private String firstAddressLine;
    private String secondAddressLine;
    private String postCode;
    private String roadType;
    private int roadSpeed;
    private int driverSpeed;
    private int speedDifference;
    private String message;
    private String ticketReturnMessage;
    private int ticketThershold;
    private int countDateThershold;
    private int drivingFine;
    private int penaltyPoints;
    private String driverFine;
    private DatabaseWriter writingDataToDatabase;



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

    public void speedCheck(int driverSpeed, String roadType) {
        ticketThershold = roadSpeed + (roadSpeed * 10 / 100 + 2);
        countDateThershold = ticketThershold + (ticketThershold * 46 / 100);
        ticketReturnMessage = "Name:" + firstName + "\nSpeed logged: " + driverSpeed+ "MPH" + "\nType of Road: " + roadType + "\nAction Required: ";

        if (driverSpeed > roadSpeed && driverSpeed < ticketThershold) {
            message = "Driver was over the speed limit but within reason, issue a warning. " + driverSpeed + "MPH";
            ticketReturnMessage = ticketReturnMessage + message;

        } else if (driverSpeed >= ticketThershold && driverSpeed < countDateThershold) {
            message = "Issuing speeding fine for the speed of: " + driverSpeed + "MPH";
            drivingFine = 50;
            ticketReturnMessage = ticketReturnMessage + message + "\nDriver Must pay: "+ "£"+drivingFine;

        } else if (driverSpeed >= countDateThershold) {
            message = "Driver exceeded the Speed limit by: " + (driverSpeed - roadSpeed)+ "MPH" + " \nDriver will be issued a ticket and count date.";
            drivingFine = 100;
            penaltyPoints = 3;
            ticketReturnMessage = ticketReturnMessage + message + "\nDriver Must pay: " + "£"+drivingFine + "\nDriver Will receive " + penaltyPoints + " points on their license.";

        } else {
            message = "Driver is under the Speed limit. \nNo action will be taken.";
            ticketReturnMessage = ticketReturnMessage + message;
        }
    }

    public String getTicketResult() {
        return ticketReturnMessage;
    }

    public void setDriversFine() {
        driverFine = String.valueOf(drivingFine);
    }
    public  String getDriversFine() {
        return driverFine;
    }


    public  String[] setDriverInfo(){
        System.out.println(driverSpeed);
        String[] driverInfo = {firstName,lastName,
                dateOfBirth,drivingLicenceNum,
                firstAddressLine,secondAddressLine,
                postCode,roadType, String.valueOf(roadSpeed),
                String.valueOf(driverSpeed), String.valueOf(speedDifference),
                driverFine,message};

        return driverInfo;
    }
    public void getDriverInfo(){
        writingDataToDatabase = new DatabaseWriter();
        try {
            writingDataToDatabase.saveDrivers(setDriverInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
