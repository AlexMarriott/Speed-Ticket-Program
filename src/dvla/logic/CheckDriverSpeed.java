package dvla.logic;

import java.io.IOException;

/**
 * Created by Alex on 08/02/2017.
 */
public class CheckDriverSpeed {
    private String message;
    private String ticketReturnMessage;
    private String driveInfoPrompt;
    private int ticketThershold;
    private int countDateThershold;
    private int drivingFine;
    private int penaltyPoints;
    private String driverFine;
    private TicketDataBase saveDriverData;

    public void setDriverInfo() {
        driveInfoPrompt = ticketReturnMessage;
    }

    public String getDriverInfo() {
        return driveInfoPrompt;
    }

    public void setDriversFine(){
        driverFine = String.valueOf(drivingFine);
    }

    public void speedCheck(int driversSpeed, int roadSpeed, String driverName, String roadType) {
        ticketThershold = roadSpeed + (roadSpeed * 10 / 100 + 2);
        countDateThershold = ticketThershold + (ticketThershold * 46 / 100);

        if (driversSpeed > roadSpeed && driversSpeed < ticketThershold) {
            message = "Driver was over the speed limit but within reason, issue a warning. " + driversSpeed + "MPH";
            ticketReturnMessage = "Name: " + driverName + "\nSpeed logged: " + driversSpeed+ "MPH" + "\nType of Road: " + roadType + "\nAction Required: " + message;

        } else if (driversSpeed >= ticketThershold && driversSpeed < countDateThershold) {
            message = "Issuing speeding fine for the speed of: " + driversSpeed + "MPH";
            drivingFine = 50;
            ticketReturnMessage = "Name: " + driverName + "\nSpeed logged: " + driversSpeed+ "MPH" + "\nType of Road: " + roadType + "\nAction Required: " + message + "\nDriver Must pay: "+ "£"+drivingFine;

        } else if (driversSpeed >= countDateThershold) {
            message = "Driver exceeded the Speed limit by: " + (driversSpeed - roadSpeed)+ "MPH" + " \nDriver will be issued a ticket and count date.";
            drivingFine = 100;
            penaltyPoints = 3;
            ticketReturnMessage = "Name: " + driverName + "\nSpeed logged: " + driversSpeed+ "MPH" + "\nType of Road: " + roadType + "\nAction Required: " + message + "\nDriver Must pay: " + "£"+drivingFine + "\nDriver Will receive " + penaltyPoints + " points on their license.";

        } else {
            message = "Driver is under the Speed limit. \nNo action will be taken.";
            ticketReturnMessage = "Name: " + driverName + "\nSpeed logged: " + driversSpeed+ "MPH" + "\nType of Road: " + roadType + "\nAction Required: " + message;
        }
    }

    public void setDriverData(String[] driverData) {
        try {
            saveDriverData = new TicketDataBase();

            saveDriverData.saveDrivers(driverData, message, driverFine);

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}



