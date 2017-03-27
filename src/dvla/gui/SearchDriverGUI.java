package dvla.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 23/02/2017.
 */
public class SearchDriverGUI {
    private JLabel lblDriverID;
    private JTextField txtDriverID;
    private JButton btnSearch,btnRemove, btnExit;
    private JPanel pnlSearchDriver;
    private JFrame frmSearchDriver;
    private JTable table;
    private JScrollPane scrollPane;

    public SearchDriverGUI(){

        pnlAddSearchDrive();
        addDriverViewFields();
        addDriverViewButtons();
        createDriverTable();
        frmAddSearchDriver();
    }

    public void frmAddSearchDriver(){
        frmSearchDriver = new JFrame();
        frmSearchDriver.setTitle("View Driver");
        frmSearchDriver.setSize(700,400);
        frmSearchDriver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearchDriver.setVisible(false);
        frmSearchDriver.setLocationRelativeTo(null);
        frmSearchDriver.setResizable(false);

        frmSearchDriver.add(pnlSearchDriver);
        frmSearchDriver.setVisible(true);
    }

    public void pnlAddSearchDrive(){
        pnlSearchDriver = new JPanel();
        pnlSearchDriver.setLayout(null);
    }

    public void addDriverViewFields(){

        lblDriverID = new JLabel("Driver ID");
        lblDriverID.setBounds(10, 250, 100, 20);
        pnlSearchDriver.add(lblDriverID);

        txtDriverID = new JTextField(null);
        txtDriverID.setBounds(160, 250, 100, 20);
        pnlSearchDriver.add(txtDriverID);
    }

    public void addDriverViewButtons(){
        btnSearch = new JButton("Search Driver");
        btnSearch.setBounds(20, 295, 140, 30);
        btnSearch.addActionListener(new DriverSearchHandler());
        pnlSearchDriver.add(btnSearch);

        btnRemove = new JButton("Remove Driver");
        btnRemove.setBounds(20, 335, 140, 30);
        btnRemove.addActionListener(new DriverRemoveHandler());
        pnlSearchDriver.add(btnRemove);

        btnSearch = new JButton("Edit Driver");
        btnSearch.setBounds(180, 295, 140, 30);
        btnSearch.addActionListener(new IssueTicketHandler());
        pnlSearchDriver.add(btnSearch);

        btnRemove = new JButton("Issue New License");
        btnRemove.setBounds(180, 335, 140, 30);
        btnRemove.addActionListener(new IssueNewLicenseHandler());
        pnlSearchDriver.add(btnRemove);

        btnExit = new JButton("Back");
        btnExit.setBounds(350, 335, 140, 30);
        btnExit.addActionListener(new DriverSearchExitHandler());
        pnlSearchDriver.add(btnExit);
    }

    public void createDriverTable(){
        String[] columnNames = {"Driver ID", "First Name",  "Last Name",  "Date Of Birth",  "Driving Licence",  "First Address",  "Second Address",  "Post Code",};
        Object[][] data = {{"1", "Kathy", "Smith", "May 1992", "fdsfdsfds", "fdsfdsf", "fdsdsfds", "fdsfds",}
        };
        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 695,200);
        pnlSearchDriver.add(scrollPane);
    }

    class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchDriver.setVisible(false);
        }
    }
    class DriverRemoveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchDriver.setVisible(false);
        }
    }
    class IssueTicketHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchDriver.setVisible(false);
        }
    }
    class IssueNewLicenseHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchDriver.setVisible(false);
        }
    }
    class RemoveFineHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchDriver.setVisible(false);
        }
    }

    class DriverSearchExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchDriver.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchDriverGUI();
    }
}

