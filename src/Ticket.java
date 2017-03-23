/**
 * Created by Alex on 08/02/2017.
 */
public class Ticket {
    private String message;
    private String ticketReturnMessage;
    private static String driveInfoPrompt;
    private String driversJudgment;
    private int ticketThershold;
    private int countDateThershold;

    public void setDriverInfo() {
        driveInfoPrompt = ticketReturnMessage;
    }
    public String getDriverInfo() {
        return driveInfoPrompt;
    }
    public void setDriverJudgment(){
        String driversJudgment = message;
    }
    public String  getDriverJudgment(){
        return driversJudgment;
    }

    public void speedCheck(int driversSpeed, int roadSpeed, String driverName, String roadType) {
      ticketThershold = roadSpeed + (roadSpeed * 10 / 100 + 2);
      countDateThershold = ticketThershold + (ticketThershold  *46 / 100);

        if (driversSpeed > roadSpeed && driversSpeed < ticketThershold){
            message = "Driver was over the speed limit but within reason, issue a warning. " + driversSpeed;
            } else if(driversSpeed >= ticketThershold && driversSpeed < countDateThershold){
            message = "Issuing Ticket for the speed of:  " + driversSpeed ;
        }else if (driversSpeed >= countDateThershold ) {
            message = "Driver exceeded the Speed limit by: " + (driversSpeed - roadSpeed) + " \nDriver will be issued a ticket and count date";
        }else{
            message = "Driver is under the Speed limit. \nNo action will be taken";
        }

        ticketReturnMessage = "Name: "+ driverName + "\nSpeed logged: " + driversSpeed + "\nType of Road: " + roadType + "\nAction Required: " + message;
        driversJudgment = message;
    }
}



