package dvla.gui;

import dvla.logic.DatabaseWriter;
import dvla.logic.Driver;
import dvla.logic.Vehicle;
import java.awt.Font;


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

;

/**
 * <h1> AddDriverGUI</h1>
 * The AddDriverGUI creates the AddDriver Window, which allows users to enter the Drivers information and have it submitted to the database.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class AddDriverGUI  {

    /**
     *Declares  the  Jlabels.
     */
    private JLabel lblDriversSpeed, lblRoadType, lblPicture, lblFirstName, lblLastName, lblDateOBirth, lblDrivingLicenceNum, lblFirstAddressLine, lblSecondAddressLine, lblPostCode, lblDriverInformation, lblVehicleModel, lblVehicleMake, lblVehicleNumPlate, lblVehicleYear, lblDateReported;
    /**
     * Declares the JTextFields.
     */
    private JTextField txtDriverSpeed, txtFirstName, txtLastName, txtDateOBirth, txtDrivingLicenceNum, txtFirstAddressLine, txtSecondAddressLine, txtPostCode, txtVehicleModel, txtVehicleMake, txtVehicleNumPlate, txtVehicleYear, txtDateReported;
    /**
     * Declares the JButtons.
     */
    private JButton btnSubmit, btnBack;
    /**
     *Declares the JBorder for the heading text in the AddDriverGUI window.
     */
    private Border driverInfoBorder;

    /**
     *Declares the Jpanel.
     */
    private JPanel pnlDriverGUI;

    /**
     *Declares the JFrame.
     */
    private JFrame frmDriverGUI;

    /**
     *Declares the JComboBox.
     */
    private JComboBox<String> roadList;

    /**
     *Declares the String array of roadTypeList, this array contains a list of the different roadTypes.
     */
    private String[] roadTypeList;

    /**
     * Declare a int variable of driverSpeed which will be pass through to the Driver Object.
     */
    private int driverSpeed;

    /**
     *Declare a int variable of roadspeed which will be pass through to the Driver Object.
     */
    private  int roadSpeed;
    /**
     *Declare a int variable of speedDifference which is used to check if the user has enter a speed and then will be pass through to the Driver Object.
     */

    private int speedDifference;
    /**
     *Declare a String variable of roadType which is used in the JComboBox and then will be pass through to the Driver Object.
     */

    private JComboBox comboBox;

    /** */
    private int[] roadSpeedList = new int[]{0, 20, 20, 30, 60, 70};


    private String roadType;
    /**Declaring a new Vehicle Object*/
    private Vehicle vehicleData;

    /**Declaring a new Driver Object*/
    private Driver driverData;

    /** Constructor runs the methods to create the GUI*/
    public AddDriverGUI() {
        pnlAddDriver();
        lblDriverButtons();
        txtDriverButtons();
        addDriverJCombobox();
        addDriverImage();
        addDriverButtons();
        frmAddDriver();
    }

    /**
     * Creates the Jpanel
     */

    private void pnlAddDriver() {
        pnlDriverGUI = new JPanel();
        pnlDriverGUI.setLayout(null);
    }

    /**
     * Creates the Jframe.
     */
    private void frmAddDriver() {
        frmDriverGUI = new JFrame();

        frmDriverGUI.setTitle("Add A Driver");
        frmDriverGUI.setSize(500, 425);
        frmDriverGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmDriverGUI.setLocationRelativeTo(null);

        frmDriverGUI.add(pnlDriverGUI);
        frmDriverGUI.setVisible(true);
    }
    /**
     * creates the Jlabels adds it to the AddDriverGUI panel
     */
    private void lblDriverButtons() {
        Font arial = new Font("Arial", Font.BOLD + Font.ITALIC, 10);
        driverInfoBorder = BorderFactory.createLoweredBevelBorder();
        lblDriverInformation = new JLabel("Driver Information");
        lblDriverInformation.setBounds(10, 10, 120, 20);
        lblDriverInformation.setFont(arial);
        pnlDriverGUI.add(lblDriverInformation);
        lblDriverInformation.setBorder(driverInfoBorder);

        lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(20, 40, 100, 20);
        pnlDriverGUI.add(lblFirstName);

        lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(20, 70, 100, 20);
        pnlDriverGUI.add(lblLastName);

        lblDateOBirth = new JLabel("Date of Birth");
        lblDateOBirth.setBounds(20, 100, 100, 20);
        pnlDriverGUI.add(lblDateOBirth);

        lblDrivingLicenceNum = new JLabel("Driving Licence Number");
        lblDrivingLicenceNum.setBounds(20, 130, 120, 20);
        pnlDriverGUI.add(lblDrivingLicenceNum);

        lblFirstAddressLine = new JLabel("First Line Of Address");
        lblFirstAddressLine.setBounds(20, 160, 100, 20);
        pnlDriverGUI.add(lblFirstAddressLine);

        lblSecondAddressLine = new JLabel("Second Line Of Address");
        lblSecondAddressLine.setBounds(20, 190, 120, 20);
        pnlDriverGUI.add(lblSecondAddressLine);

        lblPostCode = new JLabel("Post Code");
        lblPostCode.setBounds(20, 220, 100, 20);
        pnlDriverGUI.add(lblPostCode);

        driverInfoBorder = BorderFactory.createLoweredBevelBorder();
        lblDriverInformation = new JLabel("Vehicle Information");
        lblDriverInformation.setBounds(260, 10, 120, 20);
        lblDriverInformation.setFont(arial);
        pnlDriverGUI.add(lblDriverInformation);
        lblDriverInformation.setBorder(driverInfoBorder);

        lblVehicleModel = new JLabel("Vehicle Model");
        lblVehicleModel.setBounds(260, 40, 100, 20);
        pnlDriverGUI.add(lblVehicleModel);

        lblVehicleMake = new JLabel("Vehicle Make");
        lblVehicleMake.setBounds(260, 70, 100, 20);
        pnlDriverGUI.add(lblVehicleMake);

        lblVehicleNumPlate = new JLabel("Vehicle number Plate");
        lblVehicleNumPlate.setBounds(260, 100, 100, 20);
        pnlDriverGUI.add(lblVehicleNumPlate);

        lblVehicleYear = new JLabel("Year Vehicle Was Made");
        lblVehicleYear.setBounds(260, 130, 120, 20);
        pnlDriverGUI.add(lblVehicleYear);

        lblRoadType = new JLabel("Drivers Speed");
        lblRoadType.setBounds(20, 260, 100, 20);
        pnlDriverGUI.add(lblRoadType);

        lblDriversSpeed = new JLabel("Road Type");
        lblDriversSpeed.setBounds(20, 300, 100, 20);
        pnlDriverGUI.add(lblDriversSpeed);
    }

    /**
     * Creates the Jtextfields adds it to the AddDriverGUI panel
     */
    private void txtDriverButtons() {
        txtFirstName = new JTextField("ALEX");
        txtFirstName.setBounds(140, 40, 100, 20);
        pnlDriverGUI.add(txtFirstName);

        txtLastName = new JTextField("MARRIOTT");
        txtLastName.setBounds(140, 70, 100, 20);
        pnlDriverGUI.add(txtLastName);

        txtDateOBirth = new JTextField("29/05/1992");
        txtDateOBirth.setBounds(140, 100, 100, 20);
        pnlDriverGUI.add(txtDateOBirth);

        txtDrivingLicenceNum = new JTextField("IRCAR");
        txtDrivingLicenceNum.setBounds(140, 130, 100, 20);
        pnlDriverGUI.add(txtDrivingLicenceNum);

        txtFirstAddressLine = new JTextField("ROAD1");
        txtFirstAddressLine.setBounds(140, 160, 100, 20);
        pnlDriverGUI.add(txtFirstAddressLine);

        txtSecondAddressLine = new JTextField("ROAD 2");
        txtSecondAddressLine.setBounds(140, 190, 100, 20);
        pnlDriverGUI.add(txtSecondAddressLine);

        txtPostCode = new JTextField("EN2 ROAD");
        txtPostCode.setBounds(140, 220, 100, 20);
        pnlDriverGUI.add(txtPostCode);

        txtVehicleModel = new JTextField("CILO");
        txtVehicleModel.setBounds(380, 40, 100, 20);
        pnlDriverGUI.add(txtVehicleModel);

        txtVehicleMake = new JTextField("FAST");
        txtVehicleMake.setBounds(380, 70, 100, 20);
        pnlDriverGUI.add(txtVehicleMake);

        txtVehicleNumPlate = new JTextField("1234");
        txtVehicleNumPlate.setBounds(380, 100, 100, 20);
        pnlDriverGUI.add(txtVehicleNumPlate);

        txtVehicleYear = new JTextField("29/05/1992");
        txtVehicleYear.setBounds(380, 130, 100, 20);
        pnlDriverGUI.add(txtVehicleYear);

        txtDriverSpeed = new JTextField("32");
        txtDriverSpeed.setBounds(140, 260, 100, 20);
        pnlDriverGUI.add(txtDriverSpeed);
    }

    /**
     * creates the DVLA image for the AddDriverGUi and adds it to the AddDriverGUI panel
     */
    private void addDriverImage() {
        ImageIcon smallDVLAImage = new ImageIcon("dvlasmall.jpg");
        lblPicture = new JLabel(smallDVLAImage);
        lblPicture.setBounds(260, 160, 210, 135);
        pnlDriverGUI.add(lblPicture);
    }

    /**
     * creates and adds a Jcombobox with the road types to the panel.
     */
    private void addDriverJCombobox() {
        roadTypeList = new String[]{"", "School Zone", "Residential Road", "Main Road", "Single Carriageway", "Dual Carriageway"};
        roadList = new JComboBox<>(roadTypeList);
        roadList.setSelectedIndex(0);
        roadList.setBounds(140, 300, 120, 20);
        roadList.addActionListener(new RoadTypeHandler());
        pnlDriverGUI.add(roadList);
    }

    /**
     * creates and adds radio buttons to the AddDriverGUI panel
     */
    private void addDriverButtons() {

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(22, 350, 100, 20);
        btnSubmit.addActionListener(new CheckDriverData());
        pnlDriverGUI.add(btnSubmit);

        btnBack = new JButton("Back");
        btnBack.setBounds(300, 350, 100, 20);
        btnBack.addActionListener(new DriverAddExitHandler());
        pnlDriverGUI.add(btnBack);
    }

    /**
     * The RoadTypeHandler gets the users selection from the ComboBox and assigns the variable roadspeed with the array location of the speed
     * to use when getting the road Speed.
     */
    private class RoadTypeHandler implements ActionListener {


        public void actionPerformed(ActionEvent event) {
            comboBox = (JComboBox) event.getSource();
            roadType = String.valueOf(comboBox.getSelectedItem());
            roadSpeed = roadSpeedList[Integer.parseInt(String.valueOf(comboBox.getSelectedIndex()))];
        }
    }


    public class CheckDriverData implements ActionListener {

        /**
         * Check that the inputs are correct and passes the data to Driver to assign and do a speed check of the driver.
         * The actionPerformed action Handler listens to the sumbit button and then once clicked it checks
         * to see if the txtboxes of txtFirstname,driverspeed and the  roadspeed variable to see if they
         * are empty it then grabs all the inputted data on the driver form and passes the data to the
         * Driver & Vehicle and display a popup to the user.
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            driverSpeed = Integer.parseInt(txtDriverSpeed.getText());
            speedDifference = driverSpeed - roadSpeed;
            if (txtFirstName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please Enter the Drivers Name", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (driverSpeed == 0) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please Enter the Drivers Speed", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (roadSpeed == 0) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please Enter select the road type", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                driverData = new Driver(txtFirstName.getText(), txtLastName.getText(), txtDateOBirth.getText(), txtDrivingLicenceNum.getText(), txtFirstAddressLine.getText(), txtSecondAddressLine.getText(), txtPostCode.getText(), roadSpeed, roadType, driverSpeed, speedDifference);
                vehicleData = new Vehicle(txtVehicleModel.getText(), txtVehicleMake.getText(),txtVehicleNumPlate.getText(),txtVehicleYear.getText(),txtFirstName.getText(),txtDrivingLicenceNum.getText(),txtFirstAddressLine.getText(),txtSecondAddressLine.getText(),txtPostCode.getText());
                driverData.speedCheck(driverSpeed ,roadType);
                vehicleData.getVehicleInfo();
                driverData.getTicketResult();
                driverData.setDriversFine();
                driverData.getDriverInfo();
                vehicleData.getVehicleInfo();

                JOptionPane.showMessageDialog(frmDriverGUI, driverData.getTicketResult());

            }
        }
    }

    /**
     * The DriverAddExitHandler listens to the exit button and once clicked it will disposed of the AddDriverGUI
     */
    private class DriverAddExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmDriverGUI.dispose();
        }
    }
}

