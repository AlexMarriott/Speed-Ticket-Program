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
    private JLabel lblSpeed, lblRoadType, lblPicture;
    private JLabel lblFirstName, lblLastName, lblDateOBirth, lblDrivingLicenceNum, lblFirstAddressLine, lblSecondAddressLine, lblPostCode, lblDriverInformation;
    private JLabel lblVehicleModel, lblVehicleMake, lblVehicleNumPlate, lblVehicleYear;
    private JTextField txtSpeed, txtFirstName, txtLastName, txtDateOBirth, txtDrivingLicenceNum, txtFirstAddressLine, txtSecondAddressLine, txtPostCode;
    private JTextField txtVehicleModel, txtVehicleMake, txtVehicleNumPlate, txtVehicleYear;
    private JButton btnSubmit, btnBack;
    private JPanel driverAddPanel;
    private Border driverInfoBorder;
    private JFrame driverAddFrame;
    private int roadSpeed;
    private int driversSpeed;
    private String roadType;
    private String driverName;
    private String[] roadTypeList;
    private TicketDataBase saveDriverData;
    private String[] driverData;
    private JComboBox roadList;

    public AddDriver() {
        pnlAddDriver();
        lblDriverButtons();
        txtDriverButtons();
        addDriverJCombobox();
        addDriverImage();
        addDriverButtons();
        frmAddDriver();
    }

    private void pnlAddDriver() {
        driverAddPanel = new JPanel();
        driverAddPanel.setLayout(null);
    }

    public void frmAddDriver() {
        driverAddFrame = new JFrame();
        driverAddFrame.setTitle("Add A Driver");
        driverAddFrame.setSize(800, 600);
        driverAddFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        driverAddFrame.setVisible(false);
        driverAddFrame.setLocationRelativeTo(null);

        driverAddFrame.add(driverAddPanel);
        driverAddFrame.setVisible(true);
    }

    private void lblDriverButtons() {
        Font arial = new Font("Arial", Font.BOLD + Font.ITALIC, 10);
        driverInfoBorder = BorderFactory.createLoweredBevelBorder();
        lblDriverInformation = new JLabel("Driver Information");
        lblDriverInformation.setBounds(10, 10, 120, 20);
        lblDriverInformation.setFont(arial);
        driverAddPanel.add(lblDriverInformation);
        lblDriverInformation.setBorder(driverInfoBorder);

        lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(20, 40, 100, 20);
        driverAddPanel.add(lblFirstName);

        lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(20, 70, 100, 20);
        driverAddPanel.add(lblLastName);

        lblDateOBirth = new JLabel("Date of Birth");
        lblDateOBirth.setBounds(20, 100, 100, 20);
        driverAddPanel.add(lblDateOBirth);

        lblDrivingLicenceNum = new JLabel("Driving Licence Number");
        lblDrivingLicenceNum.setBounds(20, 130, 120, 20);
        driverAddPanel.add(lblDrivingLicenceNum);

        lblFirstAddressLine = new JLabel("First Line Of Address");
        lblFirstAddressLine.setBounds(20, 160, 100, 20);
        driverAddPanel.add(lblFirstAddressLine);

        lblSecondAddressLine = new JLabel("Second Line Of Address");
        lblSecondAddressLine.setBounds(20, 190, 120, 20);
        driverAddPanel.add(lblSecondAddressLine);

        lblPostCode = new JLabel("Post Code");
        lblPostCode.setBounds(20, 220, 100, 20);
        driverAddPanel.add(lblPostCode);

        driverInfoBorder = BorderFactory.createLoweredBevelBorder();
        lblDriverInformation = new JLabel("Vehicle Information");
        lblDriverInformation.setBounds(10, 260, 120, 20);
        lblDriverInformation.setFont(arial);
        driverAddPanel.add(lblDriverInformation);
        lblDriverInformation.setBorder(driverInfoBorder);

        lblVehicleModel = new JLabel("Vehicle Model");
        lblVehicleModel.setBounds(20, 290, 100, 20);
        driverAddPanel.add(lblVehicleModel);

        lblVehicleMake = new JLabel("Vehicle Make");
        lblVehicleMake.setBounds(20, 320, 100, 20);
        driverAddPanel.add(lblVehicleMake);

        lblVehicleNumPlate = new JLabel("Vehicle number Plate");
        lblVehicleNumPlate.setBounds(20, 350, 120, 20);
        driverAddPanel.add(lblVehicleNumPlate);

        lblVehicleYear = new JLabel("Year Vehicle Was Made");
        lblVehicleYear.setBounds(20, 380, 120, 20);
        driverAddPanel.add(lblVehicleYear);

        lblRoadType = new JLabel("Road Type");
        lblRoadType.setBounds(20, 470, 100, 20);
        driverAddPanel.add(lblRoadType);

        lblSpeed = new JLabel("Drivers Speed");
        lblSpeed.setBounds(20, 430, 100, 20);
        driverAddPanel.add(lblSpeed);
    }

    private void txtDriverButtons() {
        txtFirstName = new JTextField(null);
        txtFirstName.setBounds(140, 40, 100, 20);
        driverAddPanel.add(txtFirstName);

        txtLastName = new JTextField(null);
        txtLastName.setBounds(140, 70, 100, 20);
        driverAddPanel.add(txtLastName);

        txtDateOBirth = new JTextField("DD/MM/YYYY");
        txtDateOBirth.setBounds(140, 100, 100, 20);
        driverAddPanel.add(txtDateOBirth);

        txtDrivingLicenceNum = new JTextField(null);
        txtDrivingLicenceNum.setBounds(140, 130, 100, 20);
        driverAddPanel.add(txtDrivingLicenceNum);

        txtFirstAddressLine = new JTextField(null);
        txtFirstAddressLine.setBounds(140, 160, 100, 20);
        driverAddPanel.add(txtFirstAddressLine);

        txtSecondAddressLine = new JTextField(null);
        txtSecondAddressLine.setBounds(140, 190, 100, 20);
        driverAddPanel.add(txtSecondAddressLine);

        txtPostCode = new JTextField(null);
        txtPostCode.setBounds(140, 220, 100, 20);
        driverAddPanel.add(txtPostCode);

        txtVehicleModel = new JTextField(null);
        txtVehicleModel.setBounds(140, 290, 100, 20);
        driverAddPanel.add(txtVehicleModel);

        txtVehicleMake = new JTextField(null);
        txtVehicleMake.setBounds(140, 320, 100, 20);
        driverAddPanel.add(txtVehicleMake);

        txtVehicleNumPlate = new JTextField(null);
        txtVehicleNumPlate.setBounds(140, 350, 100, 20);
        driverAddPanel.add(txtVehicleNumPlate);

        txtVehicleYear = new JTextField("DD/MM/YYYY");
        txtVehicleYear.setBounds(140, 380, 100, 20);
        driverAddPanel.add(txtVehicleYear);

        txtSpeed = new JTextField(null);
        txtSpeed.setBounds(140, 430, 100, 20);
        driverAddPanel.add(txtSpeed);
    }

    private void addDriverImage() {
        ImageIcon smallDVLAImage = new ImageIcon("dvla.jpg");
        lblPicture = new JLabel(smallDVLAImage);
        lblPicture.setBounds(580, 5, 200, 100);
        driverAddPanel.add(lblPicture);
    }

    private void addDriverJCombobox() {
        roadTypeList = new String[]{"School Zone", "Residential Road", "Main Road", "Single Carriageway", "Dual Carriageway"};
        roadList = new JComboBox(roadTypeList);
        roadList.setSelectedIndex(0);
        roadList.setBounds(140, 470, 120, 20);
        roadList.addActionListener(new RoadTypeHandler());
        driverAddPanel.add(roadList);
    }

    public void addDriverButtons() {

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(22, 520, 100, 20);
        btnSubmit.addActionListener(new DriverAddSubmitHandler());
        driverAddPanel.add(btnSubmit);

        btnBack = new JButton("Back");
        btnBack.setBounds(650, 520, 100, 20);
        btnBack.addActionListener(new DriverAddExitHandler());
        driverAddPanel.add(btnBack);
    }

    class RoadTypeHandler implements ActionListener {
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
