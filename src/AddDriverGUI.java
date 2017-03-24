import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Alex on 24/03/2017.
 */
public class AddDriverGUI {
    private JLabel lblSpeed, lblRoadType, lblPicture ,lblFirstName, lblLastName, lblDateOBirth, lblDrivingLicenceNum, lblFirstAddressLine, lblSecondAddressLine, lblPostCode, lblDriverInformation, lblVehicleModel, lblVehicleMake, lblVehicleNumPlate, lblVehicleYear;
    private JTextField txtSpeed, txtFirstName, txtLastName, txtDateOBirth, txtDrivingLicenceNum, txtFirstAddressLine, txtSecondAddressLine, txtPostCode, txtVehicleModel, txtVehicleMake, txtVehicleNumPlate, txtVehicleYear;
    private JButton btnSubmit, btnBack;
    private JPanel driverAddPanel;
    private Border driverInfoBorder;
    private JFrame driverAddFrame;
    private String[] roadTypeList;
    private JComboBox roadList;


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
        AddDriver driverLogic = new AddDriver();
        roadTypeList = new String[]{"School Zone", "Residential Road", "Main Road", "Single Carriageway", "Dual Carriageway"};
        roadList = new JComboBox(roadTypeList);
        roadList.setSelectedIndex(0);
        roadList.setBounds(140, 470, 120, 20);
        roadList.addActionListener(new AddDriver.RoadTypeHandler());
        driverAddPanel.add(roadList);
    }

    public void addDriverButtons() {

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(22, 520, 100, 20);
        btnSubmit.addActionListener(new AddDriver.DriverAddSubmitHandler());
        driverAddPanel.add(btnSubmit);

        btnBack = new JButton("Back");
        btnBack.setBounds(650, 520, 100, 20);
        btnBack.addActionListener(new driverLogic.DriverAddExitHandler());
        driverAddPanel.add(btnBack);
    }
}
