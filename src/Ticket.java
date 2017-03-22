/**
 * Created by Alex on 08/02/2017.
 */
public class Ticket {
    public Ticket() {
    }
    private String message;
    private String driverFileWrite;
    private static String driverInfo;

    public void setDriverInfo() {
        this.driverInfo = driverFileWrite;
    }
    public String getDriverInfo() {
        return driverInfo ;
    }


    public void speedCheck(int driversSpeed, int roadSpeed, String driverName, String roadType) {
        int ticketThershold = roadSpeed + (roadSpeed * 10 / 100 + 2);
        int countDateThershold = ticketThershold + (ticketThershold  *46 / 100);
        if (driversSpeed > roadSpeed && driversSpeed < ticketThershold){
            message = "Driver was over the speed limit but within reason, issue a warning." + driversSpeed;
            }else if(driversSpeed >= ticketThershold && driversSpeed < countDateThershold){
            message = "Issuing Ticket for the speed of:  " + driversSpeed ;
        }else if (driversSpeed >= countDateThershold ) {
            message = "Driver exceeded the Speed limit by: " + (driversSpeed - roadSpeed) + " \nDriver will be issued a ticket and count date";
        }else{
            message = "Driver is under the Speed limit. \nNo action will be taken";
        }
        driverFileWrite = "Name: "+ driverName + "\nSpeed logged: " + driversSpeed + "\nType of Road: " + roadType + "\nAction Required: " + message;
    }
}


