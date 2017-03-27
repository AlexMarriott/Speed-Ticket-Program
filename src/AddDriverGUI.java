import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 24/03/2017.
 */
public class AddDriverGUI {
    private JLabel lblSpeed, lblRoadType, lblPicture, lblFirstName, lblLastName, lblDateOBirth, lblDrivingLicenceNum, lblFirstAddressLine, lblSecondAddressLine, lblPostCode, lblDriverInformation, lblVehicleModel, lblVehicleMake, lblVehicleNumPlate, lblVehicleYear;
    private JTextField txtSpeed, txtFirstName, txtLastName, txtDateOBirth, txtDrivingLicenceNum, txtFirstAddressLine, txtSecondAddressLine, txtPostCode, txtVehicleModel, txtVehicleMake, txtVehicleNumPlate, txtVehicleYear;
    private JButton btnSubmit, btnBack;
    private JPanel pnlDriverGUI;
    private Border driverInfoBorder;
    private JFrame frmDriverGUI;
    private String[] roadTypeList;
    private String[] driverData;
    private JComboBox roadList;


    private static String roadType;
    private static int roadSpeed;

    private int driversSpeed;
    private String driverName;


    public AddDriverGUI() {
        pnlAddDriver();
        lblDriverButtons();
        txtDriverButtons();
        addDriverJCombobox();
        addDriverImage();
        addDriverButtons();
        frmAddDriver();
    }


    private void pnlAddDriver() {
        pnlDriverGUI = new JPanel();
        pnlDriverGUI.setLayout(null);
    }

    public void frmAddDriver() {
        frmDriverGUI = new JFrame();
        frmDriverGUI.setTitle("Add A Driver");
        frmDriverGUI.setSize(800, 600);
        frmDriverGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmDriverGUI.setVisible(false);
        frmDriverGUI.setLocationRelativeTo(null);

        frmDriverGUI.add(pnlDriverGUI);
        frmDriverGUI.setVisible(true);
    }

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
        lblDriverInformation.setBounds(10, 260, 120, 20);
        lblDriverInformation.setFont(arial);
        pnlDriverGUI.add(lblDriverInformation);
        lblDriverInformation.setBorder(driverInfoBorder);

        lblVehicleModel = new JLabel("Vehicle Model");
        lblVehicleModel.setBounds(20, 290, 100, 20);
        pnlDriverGUI.add(lblVehicleModel);

        lblVehicleMake = new JLabel("Vehicle Make");
        lblVehicleMake.setBounds(20, 320, 100, 20);
        pnlDriverGUI.add(lblVehicleMake);

        lblVehicleNumPlate = new JLabel("Vehicle number Plate");
        lblVehicleNumPlate.setBounds(20, 350, 120, 20);
        pnlDriverGUI.add(lblVehicleNumPlate);

        lblVehicleYear = new JLabel("Year Vehicle Was Made");
        lblVehicleYear.setBounds(20, 380, 120, 20);
        pnlDriverGUI.add(lblVehicleYear);

        lblRoadType = new JLabel("Road Type");
        lblRoadType.setBounds(20, 470, 100, 20);
        pnlDriverGUI.add(lblRoadType);

        lblSpeed = new JLabel("Drivers Speed");
        lblSpeed.setBounds(20, 430, 100, 20);
        pnlDriverGUI.add(lblSpeed);
    }

    private void txtDriverButtons() {
        txtFirstName = new JTextField(null);
        txtFirstName.setBounds(140, 40, 100, 20);
        pnlDriverGUI.add(txtFirstName);

        txtLastName = new JTextField(null);
        txtLastName.setBounds(140, 70, 100, 20);
        pnlDriverGUI.add(txtLastName);

        txtDateOBirth = new JTextField("DD/MM/YYYY");
        txtDateOBirth.setBounds(140, 100, 100, 20);
        pnlDriverGUI.add(txtDateOBirth);

        txtDrivingLicenceNum = new JTextField(null);
        txtDrivingLicenceNum.setBounds(140, 130, 100, 20);
        pnlDriverGUI.add(txtDrivingLicenceNum);

        txtFirstAddressLine = new JTextField(null);
        txtFirstAddressLine.setBounds(140, 160, 100, 20);
        pnlDriverGUI.add(txtFirstAddressLine);

        txtSecondAddressLine = new JTextField(null);
        txtSecondAddressLine.setBounds(140, 190, 100, 20);
        pnlDriverGUI.add(txtSecondAddressLine);

        txtPostCode = new JTextField(null);
        txtPostCode.setBounds(140, 220, 100, 20);
        pnlDriverGUI.add(txtPostCode);

        txtVehicleModel = new JTextField(null);
        txtVehicleModel.setBounds(140, 290, 100, 20);
        pnlDriverGUI.add(txtVehicleModel);

        txtVehicleMake = new JTextField(null);
        txtVehicleMake.setBounds(140, 320, 100, 20);
        pnlDriverGUI.add(txtVehicleMake);

        txtVehicleNumPlate = new JTextField(null);
        txtVehicleNumPlate.setBounds(140, 350, 100, 20);
        pnlDriverGUI.add(txtVehicleNumPlate);

        txtVehicleYear = new JTextField("DD/MM/YYYY");
        txtVehicleYear.setBounds(140, 380, 100, 20);
        pnlDriverGUI.add(txtVehicleYear);

        txtSpeed = new JTextField(null);
        txtSpeed.setBounds(140, 430, 100, 20);
        pnlDriverGUI.add(txtSpeed);
    }

    private void addDriverImage() {
        ImageIcon smallDVLAImage = new ImageIcon("dvla.jpg");
        lblPicture = new JLabel(smallDVLAImage);
        lblPicture.setBounds(580, 5, 200, 100);
        pnlDriverGUI.add(lblPicture);
    }

    private void addDriverJCombobox() {
        DriverInterfaceLogic driverLogic = new DriverInterfaceLogic();
        roadTypeList = new String[]{"School Zone", "Residential Road", "Main Road", "Single Carriageway", "Dual Carriageway"};
        roadList = new JComboBox(roadTypeList);
        roadList.setSelectedIndex(0);
        roadList.setBounds(140, 470, 120, 20);
        roadList.addActionListener(new RoadTypeHandler());
        pnlDriverGUI.add(roadList);
    }

    public void addDriverButtons() {

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(22, 520, 100, 20);
        btnSubmit.addActionListener(new CheckDriverData());
        pnlDriverGUI.add(btnSubmit);

        btnBack = new JButton("Back");
        btnBack.setBounds(650, 520, 100, 20);
        btnBack.addActionListener(new DriverAddExitHandler());
        pnlDriverGUI.add(btnBack);
    }

    static class RoadTypeHandler implements ActionListener {
        private JComboBox comboBox;
        private int[] roadSpeedList = new int[]{20, 20, 30, 60, 70};

        public void actionPerformed(ActionEvent event) {
            comboBox = (JComboBox) event.getSource();
            roadType = String.valueOf(comboBox.getSelectedItem());
            roadSpeed = roadSpeedList[Integer.parseInt(String.valueOf(comboBox.getSelectedIndex()))];
        }
    }


    class CheckDriverData implements ActionListener {
        private Ticket checkingSpeed = new Ticket();
        private DriverInterfaceLogic addDriver = new DriverInterfaceLogic();

        @Override
        public void actionPerformed(ActionEvent event) {
            AddDriverGUI driverGUI = new AddDriverGUI();
            driverData = new String[]{txtFirstName.getText(), txtLastName.getText(), txtDateOBirth.getText(), txtDrivingLicenceNum.getText(), txtFirstAddressLine.getText(), txtSecondAddressLine.getText(), txtPostCode.getText()};
            driverName = driverData[0];
            driversSpeed = Integer.parseInt(driverData[6]);


            if (driverData[0].isEmpty()) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please Enter the Drivers Name", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (txtSpeed.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please Enter the Drivers Speed", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (roadSpeed == 0) {
                JOptionPane.showMessageDialog(frmDriverGUI, "Please Enter select the road type", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                checkingSpeed.speedCheck(driversSpeed, roadSpeed, driverName, roadType);
                addDriver.setDriverData(driverData);
                JOptionPane.showMessageDialog(frmDriverGUI, checkingSpeed.getDriverInfo());
            }
        }


    }
    class DriverAddExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmDriverGUI.setVisible(false);
        }

    }
}
