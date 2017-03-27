import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Alex on 23/02/2017.
 */
public class AddDriver {


    private TicketDataBase saveDriverData;
    private String[] driverData;
    private AddDriverGUI driverAddFrame;

//Add ticketr logic here

    //Does Driver Adding to database logic.


    //Rename to Driverinterfacelogic.


    //swaggingff


    public void setDriverData(String[] driverData) {
        Ticket checkingSpeed = new Ticket();

        driverName = driverData[0];
        //driverData = new String[]{txtFirstName.getText(), txtLastName.getText(), txtDateOBirth.getText(), txtDrivingLicenceNum.getText(), txtFirstAddressLine.getText(), txtSecondAddressLine.getText(), txtPostCode.getText()};

        driversSpeed = Integer.parseInt(driverData[6]);

            try {
                saveDriverData = new TicketDataBase();
                saveDriverData.saveDrivers(driverData, checkingSpeed.getDriverJudgment());

            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
            checkingSpeed.setDriverInfo();



        }

    }

    public String[] getDriverData() {
        return driverData;
    }
}