package dvla.gui;

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

/**
 * <h1> AddDriverGUI</h1>
 * The AddDriverGUI creates the AddDriver Window, which allows users to enter the Drivers information and have it submitted to the database.
 * The AddDriverGUI creates a driver form for the user to fill in regarding the driver who committed the offence.
 * Once the user complete the form it takes the information of the driver, there speed and the vehicle they were driving and passes it to the
 * respected objects (driver and vehicle).
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class AddDriverGUI {

    /**
     * Declares  the  Jlabels, which labels the form textboxes
     */
    private JLabel lblDriversSpeed, lblRoadType, lblPicture, lblFirstName, lblLastName, lblDateOBirth, lblDrivingLicenceNum, lblFirstAddressLine, lblSecondAddressLine, lblPostCode, lblDriverInformation, lblVehicleModel, lblVehicleMake, lblVehicleNumPlate, lblVehicleYear;

    /**
     * Declares the JTextFields, which allow the users to enter the necessary driver data.
     */
    private JTextField txtDriverSpeed, txtFirstName, txtLastName, txtDateOBirth, txtDrivingLicenceNum, txtFirstAddressLine, txtSecondAddressLine, txtPostCode, txtVehicleModel, txtVehicleMake, txtVehicleNumPlate, txtVehicleYear;

    /**
     * Declares the JButtons, allows the user to submit the data or exit the program.
     */
    private JButton btnSubmit, btnBack;

    /**
     * Declares the JBorder for the heading text in the AddDriverGUI window.
     */
    private Border driverInfoBorder;

    /**
     * Declares the Jpanel, the panel is for the AddDriverGUI.
     */
    private JPanel pnlDriverGUI;

    /**
     * Declares the JFrame, the frame is for the AddDriverGUI.
     */
    private JFrame frmDriverGUI;

    /**
     * Declares the JComboBox, The combobox lists the roadtypes
     */
    private JComboBox<String> roadList;

    /**
     * Declare a String variable of roadType which is used in the JComboBox and then will be pass through to the Driver Object.
     */
    private JComboBox<String> comboBox;

    /**
     * Declare a int variable of driverSpeed which will be pass through to the Driver Object.
     */
    private int driverSpeed;

    /**
     * Declare a int variable of roadspeed which will be pass through to the Driver Object.
     */
    private int roadSpeed;

    /**
     * Declare a int variable of speedDifference which is used to check if the user has enter a speed and then will be pass through to the Driver Object.
     */
    private int speedDifference;

    /**
     * Declare a  int[] array of roadSpeedList which is used to select the roadspeed for the different roadtypes.
     */
    private int[] roadSpeedList;

    /**
     * Declares the String array of roadTypeList, this array contains a list of the different roadTypes.
     */
    private String[] roadTypeList;

    /**
     * Declaring a new String called roadType, which  is assigned the roadType from the JComboBox.
     */
    private String roadType;

    /**
     * Declaring a new Vehicle Object
     */
    private Vehicle vehicleData;

    /**
     * Declaring a new Driver Object
     */
    private Driver driverData;

    /**
     * Constructor runs the methods to create the GUI
     */
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
     * Creates the panel for the AddDriverGUI
     */
    private void pnlAddDriver() {
        pnlDriverGUI = new JPanel();
        pnlDriverGUI.setLayout(null);
    }

    /**
     * Creates the JFrame for the AddDriverGUI
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
     * Create the  Jlabel for the user input in the AddDriverGUI.
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
     * Create the  Jtextfields for the user input in the AddDriverGUI.
     */
    private void txtDriverButtons() {
        txtFirstName = new JTextField();
        txtFirstName.setBounds(140, 40, 100, 20);
        pnlDriverGUI.add(txtFirstName);

        txtLastName = new JTextField();
        txtLastName.setBounds(140, 70, 100, 20);
        pnlDriverGUI.add(txtLastName);

        txtDateOBirth = new JTextField();
        txtDateOBirth.setBounds(140, 100, 100, 20);
        pnlDriverGUI.add(txtDateOBirth);

        txtDrivingLicenceNum = new JTextField();
        txtDrivingLicenceNum.setBounds(140, 130, 100, 20);
        pnlDriverGUI.add(txtDrivingLicenceNum);

        txtFirstAddressLine = new JTextField();
        txtFirstAddressLine.setBounds(140, 160, 100, 20);
        pnlDriverGUI.add(txtFirstAddressLine);

        txtSecondAddressLine = new JTextField();
        txtSecondAddressLine.setBounds(140, 190, 100, 20);
        pnlDriverGUI.add(txtSecondAddressLine);

        txtPostCode = new JTextField();
        txtPostCode.setBounds(140, 220, 100, 20);
        pnlDriverGUI.add(txtPostCode);

        txtVehicleModel = new JTextField();
        txtVehicleModel.setBounds(380, 40, 100, 20);
        pnlDriverGUI.add(txtVehicleModel);

        txtVehicleMake = new JTextField();
        txtVehicleMake.setBounds(380, 70, 100, 20);
        pnlDriverGUI.add(txtVehicleMake);

        txtVehicleNumPlate = new JTextField();
        txtVehicleNumPlate.setBounds(380, 100, 100, 20);
        pnlDriverGUI.add(txtVehicleNumPlate);

        txtVehicleYear = new JTextField();
        txtVehicleYear.setBounds(380, 130, 100, 20);
        pnlDriverGUI.add(txtVehicleYear);

        txtDriverSpeed = new JTextField();
        txtDriverSpeed.setBounds(140, 260, 100, 20);
        pnlDriverGUI.add(txtDriverSpeed);
    }

    /**
     * Creates a ImageIcon and assigns a smaller DVLA image to it.
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
     * creates and adds Jbuttons (radio buttons) to the AddDriverGUI panel
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
     * The RoadTypeHandler gets the users selection from the ComboBox and assigns the variable roadspeed with
     * the array location of the speed to use when getting the road Speed.
     */
    private class RoadTypeHandler implements ActionListener {
        //I didn't have a enough time to deal with this, can you please explain why I have to suppress this warning in the feedback, Thank you.
        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent event) {
            comboBox = new JComboBox<String>();
            roadSpeedList = new int[]{0, 20, 20, 30, 60, 70};
            comboBox = (JComboBox<String>) event.getSource();
            roadType = String.valueOf(comboBox.getSelectedItem());
            roadSpeed = roadSpeedList[Integer.parseInt(String.valueOf(comboBox.getSelectedIndex()))];
        }
    }

    private class CheckDriverData implements ActionListener {
        /**
         * Check that the inputs are correct and passes the data to Driver to assign and do a speed check of the driver.
         * The actionPerformed action Handler listens to the submit button and then once clicked, it checks
         * to see if the txtboxes of txtFirstname, driverspeed and the roadspeed variable are empty it then grabs all the
         * inputted data on the driver form and passes the data to the Driver and Vehicle and display a popup to the user.
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                driverSpeed = Integer.parseInt(txtDriverSpeed.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please enter a number", "ERROR", JOptionPane.ERROR_MESSAGE);
                exception.printStackTrace();
            }


            speedDifference = driverSpeed - roadSpeed;

            if (txtFirstName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please Enter the Drivers Name", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (driverSpeed == 0) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please Enter the Drivers Speed, Drivers speed cannot be 0", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (roadSpeed == 0) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please Enter select the road type", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {

                //Here we are instantiating  the Driver Object and the Vehicle Object and passing through the driver information and the vehicle data to these objects.
                driverData = new Driver(txtFirstName.getText(), txtLastName.getText(), txtDateOBirth.getText(), txtDrivingLicenceNum.getText(), txtFirstAddressLine.getText(), txtSecondAddressLine.getText(), txtPostCode.getText(), roadSpeed, roadType, driverSpeed, speedDifference);
                vehicleData = new Vehicle(txtVehicleModel.getText(), txtVehicleMake.getText(), txtVehicleNumPlate.getText(), txtVehicleYear.getText(), txtFirstName.getText() + " " + txtLastName.getText(), txtDrivingLicenceNum.getText(), txtFirstAddressLine.getText(), txtSecondAddressLine.getText(), txtPostCode.getText());

                //Passing through driverSpeed and roadtype to the driver object to check the speed of the driver.
                driverData.speedCheck(driverSpeed, roadType);

                // Pass's the vehicle information to the DatabaseWriter class to write  them to file.
                vehicleData.getVehicleInfo();

                // Sets the returnTicketMessage which will display
                driverData.getTicketResult();
                driverData.setDriversFine();
                driverData.getDriverInfo();


                //This is a popup display for the user once they have written the driver to the database.
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

