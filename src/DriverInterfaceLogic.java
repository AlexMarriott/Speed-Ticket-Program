import java.io.IOException;

/**
 * Created by Alex on 23/02/2017.
 */
public class DriverInterfaceLogic {


    private TicketDataBase saveDriverData;


    public void setDriverData(String[] driverData) {
        Ticket checkingSpeed = new Ticket();
         try {
                saveDriverData = new TicketDataBase();
                saveDriverData.saveDrivers(driverData, checkingSpeed.getDriverJudgment());

            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
            checkingSpeed.setDriverInfo();
        }
}