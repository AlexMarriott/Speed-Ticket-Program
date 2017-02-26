import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 23/02/2017.
 */
public class SearchDriver {
        private JLabel lblDriverID, lblFirstName, lblDrivingLicenceNum;
        private JTextField txtDriverID, txtFirstName, txtDrivingLicenceNum;
        private JButton btnSearch,btnRemove, btnExit;
        private JPanel driverViewPanel;
        private JFrame driverViewFrame;


        protected  int driverId = 1;

        private TicketDataBase writingToFile;
        private Driver DriverInfo;
        public SearchDriver(){

            createDriverViewForm();
            addDriverViewFields();
            addDriverViewButtons();

            driverViewFrame.add(driverViewPanel);
            driverViewFrame.setVisible(true);
        }

        public void createDriverViewForm(){
            driverViewFrame = new JFrame();
            driverViewFrame.setTitle("View Driver");
            driverViewFrame.setSize(500,400);
            driverViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            driverViewFrame.setVisible(false);
            driverViewFrame.setLocationRelativeTo(null);
            driverViewFrame.setResizable(false);


            driverViewPanel = new JPanel();
            driverViewPanel.setLayout(null);
        }

        public void addDriverViewFields(){

            lblDriverID = new JLabel("Driver ID");
            lblDriverID.setBounds(10, 210, 100, 20);
            driverViewPanel.add(lblDriverID);

            txtDriverID = new JTextField(null);
            txtDriverID.setBounds(160, 210, 100, 20);
            driverViewPanel.add(txtDriverID);

            lblFirstName = new JLabel("First Name");
            lblFirstName.setBounds(10, 230, 100, 20);
            driverViewPanel.add(lblFirstName);

            txtFirstName = new JTextField(null);
            txtFirstName.setBounds(160, 230, 100, 20);
            driverViewPanel.add(txtFirstName);

            lblDrivingLicenceNum = new JLabel("Driving Licence Number");
            lblDrivingLicenceNum.setBounds(10, 250, 140, 20);
            driverViewPanel.add(lblDrivingLicenceNum);

            txtDrivingLicenceNum = new JTextField(null);
            txtDrivingLicenceNum.setBounds(160, 250, 100, 20);
            driverViewPanel.add(txtDrivingLicenceNum);
        }

        public void addDriverViewButtons(){
            btnSearch = new JButton("Search ");
            btnSearch.setBounds(10, 295, 100, 30);
            btnSearch.addActionListener(new DriverSearchHandler());
            driverViewPanel.add(btnSearch);

            btnRemove = new JButton("Remove");
            btnRemove.setBounds(10, 335, 100, 30);
            btnRemove.addActionListener(new DriverRemoveHandler());
            driverViewPanel.add(btnRemove);

            btnExit = new JButton("Back");
            btnExit.setBounds(180, 340, 100, 20);
            btnExit.addActionListener(new DriverSearchExitHandler());
            driverViewPanel.add(btnExit);
        }

    public void driverInformationTable(){
        String[] columnNames = {"Driver ID",
                "First Name",
                "Last Name",
                "Date Of Birth",
                "Driving Licence",
                "First Address",
                "Second Address",
                "Post Code",};
        Object[][] data = {
                {"Kathy", "Smith",
                        "May 1992",
                        "fdsfdsfds",
                        "fdsfdsf",
                        "fdsdsfds",
                        "fdsfds"},
                {"Kathy", "Smith",
                        "May 1992",
                        "fdsfdsfds",
                        "fdsfdsf",
                        "fdsdsfds",
                        "fdsfds"},
                {"Kathy", "Smith",
                        "May 1992",
                        "fdsfdsfds",
                        "fdsfdsf",
                        "fdsdsfds",
                        "fdsfds"},
                {"Kathy", "Smith",
                        "May 1992",
                        "fdsfdsfds",
                        "fdsfdsf",
                        "fdsdsfds",
                        "fdsfds"},
        };
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(50, 70));
        table.setFillsViewportHeight(true);
    }

    class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverViewFrame.setVisible(false);
        }
    }
    class DriverRemoveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverViewFrame.setVisible(false);
        }
    }

    class DriverSearchExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
                driverViewFrame.setVisible(false);
            }
        }

    public static void main(String[] args) {
            new SearchDriver();
    }
    }

