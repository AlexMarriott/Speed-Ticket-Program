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
    private JLabel lblSpeed, lblRoadType,lblPicture;
    private JLabel lblFirstName, lblLastName,lblDateOBirth,lblDrivingLicenceNum, lblFirstAddressLine, lblSecondAddressLine,lblPostCode,lblDriverInformation;
    private JLabel lblvehicleModel, lblvehicleMake, lblvehicleNumPlate, lblvehicleYear;
    private JTextField txtSpeed, txtFirstName, txtLastName,txtDateOBirth,txtDrivingLicenceNum, txtFirstAddressLine, txtSecondAddressLine,txtPostCode;
    private JTextField txtvehicleModel, txtvehicleMake, txtvehicleNumPlate, txtvehicleYear;
    private JButton  btnResidentialRoad, btnMainRoad, btnSchoolZone, btnSingleCarriageway, btnDualCarriageway,btnSubmit, btnBack;
    private JPanel driverAddPanel;
    private Border driverInfoBorder,vehicleInfoBorder;
    private JFrame driverAddFrame;

    protected int roadSpeed;
    protected int driversSpeed;
    protected String roadType;
    protected String driverName;
    protected String[] roadTypeList = {"School Zone", "Residential Road","Main Road","Single Carriageway","Dual Carriageway"};
    protected int[] roadSpeedList = {20,20,30,60,70};
    private TicketDataBase writingToFile;
    private Driver DriverInfo;
    private Ticket CheckingSpeed = new Ticket();


    public AddDriver(){

        createDriverForm();
        addDriverFields();
        addDriverButtons();

        driverAddFrame.add(driverAddPanel);
        driverAddFrame.setVisible(true);
    }
    public void createDriverForm(){
        driverAddFrame = new JFrame();
        driverAddFrame.setTitle("Add A Driver");
        driverAddFrame.setSize(800,600);
        driverAddFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        driverAddFrame.setVisible(false);
        driverAddFrame.setLocationRelativeTo(null);

        driverAddPanel = new JPanel();
        driverAddPanel.setLayout(null);
    }
    public void addDriverFields(){
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

        txtFirstName = new JTextField(null);
        txtFirstName.setBounds(140, 40, 100, 20);
        driverAddPanel.add(txtFirstName);

        lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(20, 70, 100, 20);
        driverAddPanel.add(lblLastName);

        txtLastName = new JTextField(null);
        txtLastName.setBounds(140, 70, 100, 20);
        driverAddPanel.add(txtLastName);

        lblDateOBirth = new JLabel("Date of Birth");
        lblDateOBirth.setBounds(20, 100, 100, 20);
        driverAddPanel.add(lblDateOBirth);

        txtDateOBirth = new JTextField("DD/MM/YYYY");
        txtDateOBirth.setBounds(140, 100, 100, 20);
        driverAddPanel.add(txtDateOBirth);

        lblDrivingLicenceNum = new JLabel("Driving Licence Number");
        lblDrivingLicenceNum.setBounds(20, 130, 120, 20);
        driverAddPanel.add(lblDrivingLicenceNum);

        txtDrivingLicenceNum = new JTextField(null);
        txtDrivingLicenceNum.setBounds(140, 130, 100, 20);
        driverAddPanel.add(txtDrivingLicenceNum);

        lblFirstAddressLine = new JLabel("First Line Of Address");
        lblFirstAddressLine.setBounds(20, 160, 100, 20);
        driverAddPanel.add(lblFirstAddressLine);

        txtFirstAddressLine = new JTextField(null);
        txtFirstAddressLine.setBounds(140, 160, 100, 20);
        driverAddPanel.add(txtFirstAddressLine);

        lblSecondAddressLine = new JLabel("Second Line Of Address");
        lblSecondAddressLine.setBounds(20, 190, 120, 20);
        driverAddPanel.add(lblSecondAddressLine);

        txtSecondAddressLine = new JTextField(null);
        txtSecondAddressLine.setBounds(140, 190, 100, 20);
        driverAddPanel.add(txtSecondAddressLine);

        lblPostCode = new JLabel("Post Code");
        lblPostCode.setBounds(20, 220, 100, 20);
        driverAddPanel.add(lblPostCode);

        txtPostCode = new JTextField(null);
        txtPostCode.setBounds(140, 220, 100, 20);
        driverAddPanel.add(txtPostCode);

        lblRoadType = new JLabel("Road Type");
        lblRoadType.setBounds(20, 430, 100, 20);
        driverAddPanel.add(lblRoadType);

        lblSpeed = new JLabel("Drivers Speed");
        lblSpeed.setBounds(20, 450, 100, 20);
        driverAddPanel.add(lblSpeed);

        txtSpeed = new JTextField(null);
        txtSpeed.setBounds(120, 450, 150, 20);
        driverAddPanel.add(txtSpeed);

        vehicleInfoBorder = BorderFactory.createLoweredBevelBorder();
        lblDriverInformation = new JLabel("Vehicle Information");
        lblDriverInformation.setBounds(10, 260, 120, 20);
        lblDriverInformation.setFont(arial);
        driverAddPanel.add(lblDriverInformation);
        lblDriverInformation.setBorder(driverInfoBorder);


        lblvehicleModel = new JLabel("Vehicle Model");
        lblvehicleModel.setBounds(20, 290, 100, 20);
        driverAddPanel.add(lblvehicleModel);

        txtvehicleModel = new JTextField(null);
        txtvehicleModel.setBounds(140, 290, 100, 20);
        driverAddPanel.add(txtvehicleModel);

        lblvehicleMake = new JLabel("Vehicle Make");
        lblvehicleMake.setBounds(20, 320, 100, 20);
        driverAddPanel.add(lblvehicleMake);

        txtvehicleMake = new JTextField(null);
        txtvehicleMake.setBounds(140, 320, 100, 20);
        driverAddPanel.add(txtvehicleMake);

        lblvehicleNumPlate = new JLabel("Vehicle number Plate");
        lblvehicleNumPlate.setBounds(20, 350, 120, 20);
        driverAddPanel.add(lblvehicleNumPlate);

        txtvehicleNumPlate = new JTextField(null);
        txtvehicleNumPlate.setBounds(140, 350, 100, 20);
        driverAddPanel.add(txtvehicleNumPlate);

        lblvehicleYear = new JLabel("Year Vehicle Was Made");
        lblvehicleYear.setBounds(20, 380, 120, 20);
        driverAddPanel.add(lblvehicleYear);

        txtvehicleYear = new JTextField("DD/MM/YYYY");
        txtvehicleYear.setBounds(140, 380, 100, 20);
        driverAddPanel.add(txtvehicleYear);

        ImageIcon smallDVLAImage = new ImageIcon("dvla.jpg");
        lblPicture = new JLabel(smallDVLAImage);
        lblPicture.setBounds(580, 5, 200, 100);
        driverAddPanel.add(lblPicture);
    }
    public void addDriverButtons(){

        JComboBox roadList = new JComboBox(roadTypeList);
        roadList.setSelectedIndex(0);
        roadList.setBounds(120, 450, 120, 20);
        roadList.addActionListener(new  RoadTypeHandler());
        driverAddPanel.add(roadList);

       /* btnSchoolZone = new JButton("SchoolZone");
        btnSchoolZone.setBounds(120, 480, 120, 20);
        btnSchoolZone.addActionListener(new SchoolZoneHandler());
        driverAddPanel.add(btnSchoolZone);

        btnResidentialRoad = new JButton("Residential");
        btnResidentialRoad.setBounds(240, 480, 100, 20);
        btnResidentialRoad.addActionListener(new ResidentialRoadHandler());
        driverAddPanel.add(btnResidentialRoad);

        btnMainRoad = new JButton("MainRoad");
        btnMainRoad.setBounds(340, 480, 100, 20);
        btnMainRoad.addActionListener(new MainRoadHandler());
        driverAddPanel.add(btnMainRoad);

        btnSingleCarriageway = new JButton("SingleCarriageway");
        btnSingleCarriageway.setBounds(440, 480, 160, 20);
        btnSingleCarriageway.addActionListener(new SingleCarriagewayHandler());
        driverAddPanel.add(btnSingleCarriageway);

        btnDualCarriageway = new JButton("DualCarriageway");
        btnDualCarriageway.setBounds(600, 480, 160, 20);
        btnDualCarriageway.addActionListener(new DualCarriagewayHandler());
        driverAddPanel.add(btnDualCarriageway);*/

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
        @Override
        public void actionPerformed(ActionEvent event ) {
            JComboBox cb = (JComboBox)event.getSource();
            roadType = (String)cb.getSelectedItem();


        }
    }
    /*class SchoolZoneHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event ) {
            roadSpeed = 20;
            roadType = "School Zone";
        }
    }

    class ResidentialRoadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 20;
            roadType = "Residential Road";
        }
    }
    class MainRoadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 30;
            roadType = "Main Road";
        }
    }
    class SingleCarriagewayHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 60;
            roadType = "Single Carriageway";
        }
    }
    class DualCarriagewayHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 70;
            roadType = "Dual Carriageway";

        }
    }*/

    class DriverAddSubmitHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            driverName = txtFirstName.getText();
            driversSpeed = Integer.parseInt(txtSpeed.getText());
            if ( txtFirstName.getText().isEmpty()){
                JOptionPane.showMessageDialog(driverAddFrame, "Please Enter the Drivers Name", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else if (txtSpeed.getText().isEmpty()){
                JOptionPane.showMessageDialog(driverAddFrame, "Please Enter the Drivers Speed", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else if (roadSpeed == 0){
                JOptionPane.showMessageDialog(driverAddFrame, "Please Enter select the road type", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else

            DriverInfo = new Driver(txtFirstName.getText(),txtLastName.getText(),txtDateOBirth.getText(), txtDrivingLicenceNum.getText(), txtFirstAddressLine.getText(), txtSecondAddressLine.getText(),txtPostCode.getText());

            CheckingSpeed.speedCheck(driversSpeed,roadSpeed,driverName,roadType);

            CheckingSpeed.setDriverInfo();
            try  {
                writingToFile = new TicketDataBase();

                writingToFile.saveDrivers();
            }
            catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(driverAddFrame, CheckingSpeed.getDriverInfo());
        }
    }
    class DriverAddExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverAddFrame.setVisible(false);
        }
    }
}
