package dvla.gui;

import dvla.logic.TicketDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alex on 23/02/2017.
 */
public class SearchDriverGUI {
    private JLabel lblDriverID;
    private JTextField txtDriverID;
    private JButton btnSearch,btnRemove, btnExit;
    private JPanel pnlSearchDriver;
    private JFrame frmSearchDriver;
    private JTable driverTable;
    private JScrollPane driverScrollPane;
    private ArrayList driverData;

    public SearchDriverGUI() {
        pnlAddSearchDrive();
        addDriverViewFields();
        addDriverViewButtons();
        try
        {
            setTableData();
            //createDriverTable();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        frmAddSearchDriver();
    }

    public void frmAddSearchDriver(){
        frmSearchDriver = new JFrame();
        frmSearchDriver.setTitle("View Driver");
        frmSearchDriver.setSize(800,400);
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

    public void createDriverTable() {
        TicketDataBase getRowData = new TicketDataBase();
        try {
            //setTableData();
            String[] columnNames = {"Driver ID", "First Name", "Last Name", "Date of Birth", "Driving Licence", "First Address", "Second Address", "Post Code", "desc"};
            //we have 9 columns
            for (int i = 0; i < driverData.size(); i++) {
                String[][] rowData = {{driverData.get(0).toString(), driverData.get(1).toString()
                , driverData.get(0).toString(), driverData.get(0).toString(), driverData.get(0).toString(), driverData.get(0).toString()
                , driverData.get(0).toString(), driverData.get(0).toString(), driverData.get(0).toString()}};
                JTable driverTable = new JTable(rowData, columnNames);
                driverScrollPane = new JScrollPane(driverTable);
                driverScrollPane.setBounds(0, 0, 795, 200);
                pnlSearchDriver.add(driverScrollPane);
                //http://stackoverflow.com/questions/16010776/read-text-file-and-display-it-in-jtable
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTableData() throws FileNotFoundException {
        driverData = new ArrayList();
        String[] aryDriverData = new String[18];
        String[] aryDriverDataSplit = new String[18];

        File file = new File("Drivers.txt");
        Scanner readIn = new Scanner(file);
        String data = "";
        int count = 0;
        while (readIn.hasNext()) {
            aryDriverData[count] = readIn.nextLine();//.split(",|\\r?\\n");
            count++;
        }
        aryDriverDataSplit = aryDriverData[0].split(", ");
        System.out.println(aryDriverDataSplit);
    }

    class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                setTableData();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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

