/**
 * Created by Alex on 10/02/2017.
 */
public class SpeedingTicketMain {
    public static void main(String[] args) {
        SpeedingTicket speedCheck = new SpeedingTicket();
        speedCheck.setCapturedSpeed();
        speedCheck.getCapturedSpeed();
        speedCheck.setRoad();
        speedCheck.getRoad();
        speedCheck.CheckSpeedMainroad();
    }
}
