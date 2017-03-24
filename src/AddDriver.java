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

    private static int roadSpeed;
    private int driversSpeed;
    private static String roadType;
    private String driverName;
    private TicketDataBase saveDriverData;
    private String[] driverData;


    static class RoadTypeHandler implements ActionListener {
        private JComboBox comboBox;
        private int[] roadSpeedList = new int[]{20, 20, 30, 60, 70};

        public void actionPerformed(ActionEvent event) {
            comboBox = (JComboBox) event.getSource();
            roadType = String.valueOf(comboBox.getSelectedItem());
            roadSpeed = roadSpeedList[Integer.parseInt(String.valueOf(comboBox.getSelectedIndex()))];
        }
    }

    class DriverAddSubmitHandler implements ActionListener {
        private Ticket checkingSpeed = new Ticket();

        @Override
        public void actionPerformed(ActionEvent event) {
            AddDriverGUI driverGUI = new AddDriverGUI();
            driverName = txtFirstName.getText();
            driversSpeed = Integer.parseInt(txtSpeed.getText());

            if (txtFirstName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(driverAddFrame, "Please Enter the Drivers Name", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (txtSpeed.getText().isEmpty()) {
                JOptionPane.showMessageDialog(driverAddFrame, "Please Enter the Drivers Speed", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (roadSpeed == 0) {
                JOptionPane.showMessageDialog(driverAddFrame, "Please Enter select the road type", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                driverData = new String[]{txtFirstName.getText(), txtLastName.getText(), txtDateOBirth.getText(), txtDrivingLicenceNum.getText(), txtFirstAddressLine.getText(), txtSecondAddressLine.getText(), txtPostCode.getText()};
                checkingSpeed.speedCheck(driversSpeed, roadSpeed, driverName, roadType);


                try {
                    saveDriverData = new TicketDataBase();
                    saveDriverData.saveDrivers(driverData, checkingSpeed.getDriverJudgment());

                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }
                checkingSpeed.setDriverInfo();

                JOptionPane.showMessageDialog(driverAddFrame, checkingSpeed.getDriverInfo());
            }
        }
    }

    public String[] getDriverData() {
        return driverData;
    }

    class DriverAddExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverAddFrame.setVisible(false);
        }
    }
}
