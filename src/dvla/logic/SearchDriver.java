package dvla.logic;

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
        private JButton btnSearch,btnRemove,btnIssueTicket, btnExit;
        private JPanel driverViewPanel;
        private JFrame driverViewFrame;


        protected  int driverId = 1;

        private TicketDataBase writingToFile;

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
            lblDriverID.setBounds(10, 250, 100, 20);
            driverViewPanel.add(lblDriverID);

            txtDriverID = new JTextField(null);
            txtDriverID.setBounds(160, 250, 100, 20);
            driverViewPanel.add(txtDriverID);
        }

        public void addDriverViewButtons(){
            btnSearch = new JButton("Search Driver");
            btnSearch.setBounds(20, 295, 140, 30);
            btnSearch.addActionListener(new DriverSearchHandler());
            driverViewPanel.add(btnSearch);

            btnRemove = new JButton("Remove Driver");
            btnRemove.setBounds(20, 335, 140, 30);
            btnRemove.addActionListener(new DriverRemoveHandler());
            driverViewPanel.add(btnRemove);

            btnSearch = new JButton("Issue CheckDriverSpeed");
            btnSearch.setBounds(180, 295, 140, 30);
            btnSearch.addActionListener(new IssueTicketHandler());
            driverViewPanel.add(btnSearch);

            btnRemove = new JButton("Issue New License");
            btnRemove.setBounds(180, 335, 140, 30);
            btnRemove.addActionListener(new IssueNewLicenseHandler());
            driverViewPanel.add(btnRemove);

            btnRemove = new JButton("Remove Fine ");
            btnRemove.setBounds(350, 295, 140, 30);
            btnRemove.addActionListener(new RemoveFineHandler());
            driverViewPanel.add(btnRemove);

            btnExit = new JButton("Back");
            btnExit.setBounds(350, 335, 140, 30);
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
    class IssueTicketHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverViewFrame.setVisible(false);
        }
    }
    class IssueNewLicenseHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverViewFrame.setVisible(false);
        }
    }
    class RemoveFineHandler implements ActionListener {
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
