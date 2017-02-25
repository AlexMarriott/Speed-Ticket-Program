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
    private JLabel lblSpeed, lblRoadType, lblFirstName,lblDriversLastName,lblDateOBirth,lblDrivingLicenceNum,lblFirstAddress,lblSecondAddress,lblPostCode,lblDriverInformation,lblPicture;
    private JTextField txtSpeed, txtFirstName, txtLastName,txtDateOBirth,txtDrivingLicenceNum,txtFirstAddress,txtSecondAddress,txtPostCode;
    private JButton  btnResidentialRoad, btnMainRoad, btnSchoolZone, btnSingleCarriageway, btnDualCarriageway,btnSubmit, btnExit;
    private JPanel driverAddPanel;
    private Border driverInfoBorder;
    private JFrame driverAddFrame;

    protected int roadSpeed;
    protected int driversSpeed;
    protected String roadType;
    protected String driverName;
    protected  int driverId = 1;

    private TicketDataBase writingToFile;
    private Driver DriverInfo;
    private IssueTicket blah;

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

        lblDriversLastName = new JLabel("Last Name");
        lblDriversLastName.setBounds(20, 70, 100, 20);
        driverAddPanel.add(lblDriversLastName);

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

        lblFirstAddress = new JLabel("First Line Of Address");
        lblFirstAddress.setBounds(20, 160, 100, 20);
        driverAddPanel.add(lblFirstAddress);

        txtFirstAddress = new JTextField(null);
        txtFirstAddress.setBounds(140, 160, 100, 20);
        driverAddPanel.add(txtFirstAddress);

        lblSecondAddress = new JLabel("Second Line Of Address");
        lblSecondAddress.setBounds(20, 190, 120, 20);
        driverAddPanel.add(lblSecondAddress);

        txtSecondAddress = new JTextField(null);
        txtSecondAddress.setBounds(140, 190, 100, 20);
        driverAddPanel.add(txtSecondAddress);

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
        lblSpeed.setBounds(20, 405, 100, 20);
        driverAddPanel.add(lblSpeed);

        txtSpeed = new JTextField(null);
        txtSpeed.setBounds(120, 405, 150, 20);
        driverAddPanel.add(txtSpeed);

        ImageIcon image = new ImageIcon("dvlasmall.jpg");
        lblPicture = new JLabel(image);
        lblPicture.setBounds(580, 5, 200, 100);
        driverAddPanel.add(lblPicture);
    }

    public void addDriverButtons(){
        btnSchoolZone = new JButton("SchoolZone");
        btnSchoolZone.setBounds(120, 430, 120, 20);
        btnSchoolZone.addActionListener(new SchoolZoneHandler());
        driverAddPanel.add(btnSchoolZone);

        btnResidentialRoad = new JButton("Residential");
        btnResidentialRoad.setBounds(240, 430, 100, 20);
        btnResidentialRoad.addActionListener(new ResidentialRoadHandler());
        driverAddPanel.add(btnResidentialRoad);

        btnMainRoad = new JButton("MainRoad");
        btnMainRoad.setBounds(340, 430, 100, 20);
        btnMainRoad.addActionListener(new MainRoadHandler());
        driverAddPanel.add(btnMainRoad);

        btnSingleCarriageway = new JButton("SingleCarriageway");
        btnSingleCarriageway.setBounds(440, 430, 160, 20);
        btnSingleCarriageway.addActionListener(new SingleCarriagewayHandler());
        driverAddPanel.add(btnSingleCarriageway);

        btnDualCarriageway = new JButton("DualCarriageway");
        btnDualCarriageway.setBounds(600, 430, 160, 20);
        btnDualCarriageway.addActionListener(new DualCarriagewayHandler());
        driverAddPanel.add(btnDualCarriageway);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(22, 525, 100, 20);
        btnSubmit.addActionListener(new DriverAddSubmitHandler());
        driverAddPanel.add(btnSubmit);

        btnExit = new JButton("Back");
        btnExit.setBounds(650, 525, 100, 20);
        btnExit.addActionListener(new DriverAddExitHandler());
        driverAddPanel.add(btnExit);
    }
    class SchoolZoneHandler implements ActionListener {
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
    }
    class DriverAddSubmitHandler implements ActionListener {
        IssueTicket CheckingSpeed = new IssueTicket();
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
            CheckingSpeed.speedCheck(driversSpeed,roadSpeed,driverName,roadType,driverId);

            DriverInfo= new Driver(driverId,txtFirstName.getText(),txtLastName.getText(),txtDateOBirth.getText(),txtDrivingLicenceNum.getText(),txtFirstAddress.getText(),txtSecondAddress.getText(),txtPostCode.getText());

            CheckingSpeed.setDriverInfo();
            //System.out.println(CheckingSpeed.getDriverInfo());
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
