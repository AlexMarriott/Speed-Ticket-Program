package dvla.gui;

import dvla.logic.DatabaseWriter;
import dvla.logic.Driver;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 24/03/2017.
 */
public class AddDriverGUI {
    private JLabel lblDriversSpeed, lblRoadType, lblPicture, lblFirstName, lblLastName, lblDateOBirth, lblDrivingLicenceNum, lblFirstAddressLine, lblSecondAddressLine, lblPostCode, lblDriverInformation, lblVehicleModel, lblVehicleMake, lblVehicleNumPlate, lblVehicleYear, lblDateReported;
    private JTextField txtDriverSpeed, txtFirstName, txtLastName, txtDateOBirth, txtDrivingLicenceNum, txtFirstAddressLine, txtSecondAddressLine, txtPostCode, txtVehicleModel, txtVehicleMake, txtVehicleNumPlate, txtVehicleYear, txtDateReported;
    private JButton btnSubmit, btnBack;
    private JPanel pnlDriverGUI;
    private Border driverInfoBorder;
    private JFrame frmDriverGUI;
    private JComboBox<String> roadList;
    private String[] roadTypeList;
    private int driverSpeed;

    private  int roadSpeed;
    private int speedDifference;

    private String driverName;
    private  String roadType;
    private DatabaseWriter saveDriverData = new DatabaseWriter();

    private Driver driverData;

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

    private void frmAddDriver() {
        frmDriverGUI = new JFrame();

        frmDriverGUI.setTitle("Add A Driver");
        frmDriverGUI.setSize(500, 425);
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

    private void addDriverImage() {
        ImageIcon smallDVLAImage = new ImageIcon("dvlasmall.jpg");
        lblPicture = new JLabel(smallDVLAImage);
        lblPicture.setBounds(260, 160, 210, 135);
        pnlDriverGUI.add(lblPicture);
    }

    private void addDriverJCombobox() {
        roadTypeList = new String[]{"", "School Zone", "Residential Road", "Main Road", "Single Carriageway", "Dual Carriageway"};
        roadList = new JComboBox<>(roadTypeList);
        roadList.setSelectedIndex(0);
        roadList.setBounds(140, 300, 120, 20);
        roadList.addActionListener(new RoadTypeHandler());
        pnlDriverGUI.add(roadList);
    }

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


    private class RoadTypeHandler implements ActionListener {
        private JComboBox comboBox;
        private int[] roadSpeedList = new int[]{0, 20, 20, 30, 60, 70};

        public void actionPerformed(ActionEvent event) {
            comboBox = (JComboBox) event.getSource();
            roadType = String.valueOf(comboBox.getSelectedItem());
            roadSpeed = roadSpeedList[Integer.parseInt(String.valueOf(comboBox.getSelectedIndex()))];
        }
    }

    public class CheckDriverData implements ActionListener {
        private Driver driverData;


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

                driverData.speedCheck(driverSpeed ,roadType);
                driverData.getTicketResult();
                driverData.setDriversFine();
                driverData.setDriverInfo();
                driverData.getDriverInfo();

                JOptionPane.showMessageDialog(frmDriverGUI, driverData.getTicketResult());

            }
        }
    }


    private class DriverAddExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmDriverGUI.setVisible(false);
        }
    }
}

