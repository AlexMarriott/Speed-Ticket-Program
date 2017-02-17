import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 * Created by alex on 11/02/2017.
 */
public class GUI {
    private JLabel lblSpeed, lblRoadType, lblDriversName,lblDriversLastName, lblPicture;
    private JTextField txtSpeed, txtDriverName,txtsearchDriver;
    private JButton btnAddDriver, btnSearchDriver, btnRemoveDriver, btnResidentialRoad, btnMainRoad, btnSchoolZone, btnSingleCarriageway, btnDualCarriageway, btnSubmit, btnExit;
    private JPanel driverAddPanel,splashPagePanel;
    private JFrame driverAddFrame,splashPageFrame;
    private int roadSpeed;
    private String driverName;
    private String driversSpeed;
    private String roadType;

    IssueTicket CheckingSpeed = new  IssueTicket();
    TicketDataBase writingToFile = new  TicketDataBase();

    public GUI(){

        createSplashPage();
        addSplashPageFields();
        addSplashPageButtons();

        splashPageFrame.add(splashPagePanel);
        splashPageFrame.setVisible(true);

        createDriverForm();
        addDriverFields();
        addDriverButtons();

        driverAddFrame.add(driverAddPanel);
        driverAddFrame.setVisible(false);

    }
    public void createSplashPage() {
        splashPageFrame = new JFrame();
        splashPageFrame.setTitle("DVLA Ticket Program");
        splashPageFrame.setSize(420, 350);
        splashPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashPageFrame.setVisible(true);
        splashPageFrame.setLocationRelativeTo(null);

        splashPagePanel = new JPanel();
        splashPagePanel.setLayout(null);
    }
    public void createDriverForm(){
        driverAddFrame = new JFrame();
        driverAddFrame.setTitle("DVLA Ticket Program");
        driverAddFrame.setSize(800,600);
        driverAddFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        driverAddFrame.setVisible(false);
        driverAddFrame.setLocationRelativeTo(null);

        driverAddPanel = new JPanel();
        driverAddPanel.setLayout(null);
    }
    public void addSplashPageFields() {

        ImageIcon image = new ImageIcon("DVLA.jpg");
        lblPicture = new JLabel(image);
        lblPicture.setBounds(0, 0, 400, 200);
        splashPagePanel.add(lblPicture);
    }
    public void addDriverFields(){
        lblDriversName = new JLabel("Drivers First Name");
        lblDriversName.setBounds(20, 380, 100, 20);
        driverAddPanel.add(lblDriversName);

        txtDriverName = new JTextField(null);
        txtDriverName.setBounds(120, 380, 150, 20);
        driverAddPanel.add(txtDriverName);

        lblDriversLastName = new JLabel("Drivers Last Name");
        lblDriversLastName.setBounds(20, 380, 100, 20);

        driverAddPanel.add(lblDriversLastName);

        txtDriverName = new JTextField(null);
        txtDriverName.setBounds(120, 380, 150, 20);
        driverAddPanel.add(txtDriverName);

        lblRoadType = new JLabel("Road Type");
        lblRoadType.setBounds(20, 430, 100, 20);
        driverAddPanel.add(lblRoadType);

        lblSpeed = new JLabel("Drivers Speed");
        lblSpeed.setBounds(20, 405, 100, 20);
        driverAddPanel.add(lblSpeed);

        txtSpeed = new JTextField(null);
        txtSpeed.setBounds(120, 405, 150, 20);
        driverAddPanel.add(txtSpeed);

        ImageIcon image = new ImageIcon("DVLA.jpg");
        lblPicture = new JLabel(image);
        lblPicture.setBounds(200, 100, 400, 200);
        driverAddPanel.add(lblPicture);
        }
    public void addSplashPageButtons() {
        btnAddDriver = new JButton("Add Driver");
        btnAddDriver.setBounds(10, 240, 100, 40);
        btnAddDriver.addActionListener(new AddDriverHandler());
        splashPagePanel.add(btnAddDriver);

        btnSearchDriver = new JButton("Search For Driver");
        btnSearchDriver.setBounds(120, 240, 140, 40);
        btnSearchDriver.addActionListener(new AddDriverHandler());
        splashPagePanel.add(btnSearchDriver);

        btnRemoveDriver = new JButton("Remove Driver");
        btnRemoveDriver.setBounds(270, 240, 120, 40);
        btnRemoveDriver.addActionListener(new AddDriverHandler());
        splashPagePanel.add(btnRemoveDriver);

        btnExit = new JButton("Exit");
        btnExit.setBounds(140, 290, 100, 20);
        btnExit.addActionListener(new ExitHandler());
        splashPagePanel.add(btnExit);
    }
    public void addDriverButtons(){
        btnSchoolZone = new JButton("SchoolZone");
        btnSchoolZone.setBounds(120, 430, 120, 20);
        btnSchoolZone.addActionListener(new DriverAddSchoolZoneHandler());
        driverAddPanel.add(btnSchoolZone);

        btnResidentialRoad = new JButton("Residential");
        btnResidentialRoad.setBounds(240, 430, 100, 20);
        btnResidentialRoad.addActionListener(new DriverAddResidentialRoadHandler());
        driverAddPanel.add(btnResidentialRoad);

        btnMainRoad = new JButton("MainRoad");
        btnMainRoad.setBounds(340, 430, 100, 20);
        btnMainRoad.addActionListener(new DriverAddMainRoadHandler());
        driverAddPanel.add(btnMainRoad);

        btnSingleCarriageway = new JButton("SingleCarriageway");
        btnSingleCarriageway.setBounds(440, 430, 160, 20);
        btnSingleCarriageway.addActionListener(new DriverAddSingleCarriagewayHandler());
        driverAddPanel.add(btnSingleCarriageway);

        btnDualCarriageway = new JButton("DualCarriageway");
        btnDualCarriageway.setBounds(600, 430, 160, 20);
        btnDualCarriageway.addActionListener(new DriverAddDualCarriagewayHandler());
        driverAddPanel.add(btnDualCarriageway);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(22, 525, 100, 20);
        btnSubmit.addActionListener(new DriverAddSubmitHandler());
        driverAddPanel.add(btnSubmit);

        btnExit = new JButton("Exit");
        btnExit.setBounds(650, 525, 100, 20);
        btnExit.addActionListener(new DriverAddExitHandler());
        driverAddPanel.add(btnExit);
    }
    class AddDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverAddFrame.setVisible(true);
        }
    }

    class SearchAddDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            txtsearchDriver = new JTextField(null);
            txtsearchDriver.setBounds(120, 380, 150, 20);
            splashPagePanel.add(txtsearchDriver);
        }
    }
    class ExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int n = JOptionPane.showConfirmDialog(splashPageFrame, "Are You Sure You Want To Exit?", "Are You Sure", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                System.exit(0);
            }
        }
    }

    class DriverAddSchoolZoneHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event ) {
            roadSpeed = 20;
            roadType = "School Zone";
        }
    }

    class DriverAddResidentialRoadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 20;
            roadType = "Residential Road";
        }
    }
    class DriverAddMainRoadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 30;
            roadType = "Main Road";
        }
    }
    class DriverAddSingleCarriagewayHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 60;
            roadType = "Single Carriageway";
        }
    }
    class DriverAddDualCarriagewayHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 70;
            roadType = "Dual Carriageway";

        }
    }
    class DriverAddSubmitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverName = txtDriverName.getText();
            driversSpeed = txtSpeed.getText();
            int driversSpeedInt = 0;
            if (driverName.isEmpty()){
                JOptionPane.showMessageDialog(driverAddFrame, "Please Enter the Drivers Name", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else if (driversSpeed.isEmpty()){
                JOptionPane.showMessageDialog(driverAddFrame, "Please Enter the Drivers Speed", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else if (roadSpeed == 0){
                JOptionPane.showMessageDialog(driverAddFrame, "Please Enter select the road type", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else
                driversSpeedInt = Integer.parseInt(driversSpeed);
                CheckingSpeed.speedCheck(driversSpeedInt,roadSpeed,driverName,roadType );
            CheckingSpeed.setDriverInfo();
            JOptionPane.showMessageDialog(driverAddFrame, CheckingSpeed.getDriverInfo());
            try {
                writingToFile.saveDrivers();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    class DriverAddExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverAddFrame.setVisible(false);
        }
    }
    public static void main(String[] args){
        new GUI();
    }
}

//http://stackoverflow.com/questions/3480102/java-jframe-setlocationrelativetonull-not-centering-the-window-on-ubuntu-10-0 - Help with setting the Container to open in the middle of the screen (1).