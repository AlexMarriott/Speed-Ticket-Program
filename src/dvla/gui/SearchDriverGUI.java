package dvla.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
    private ArrayList<String> arrList;
    private int tableRowAmount;
    private String[] columnNames;
    private String[][] rowData;
    private String searchDriverID;
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);



    public SearchDriverGUI() {
        pnlAddSearchDrive();
        addDriverViewFields();
        addDriverViewButtons();
        try {
            getDriver();
            getTableRows();
            createDriverTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        frmAddSearchDriver();
    }

    public void frmAddSearchDriver(){
        frmSearchDriver = new JFrame();
        frmSearchDriver.setTitle("View Driver");
        frmSearchDriver.setSize(1010,400);
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
        btnSearch.addActionListener(new IssueNewLicenseHandler());
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


    public double getTableRows() {
        return tableRowAmount = arrList.size() / 12;
    }

    public void getDriver() {
        arrList = new ArrayList<>();

        File file = new File("Drivers.txt");
        try {
            Scanner readIn = new Scanner(file);
            while (readIn.hasNext()) {
                arrList.add(readIn.nextLine());
            }
        } catch (IOException e) {
        }
    }






    public void createDriverTable() {
        try {
            columnNames = new String[]{"Driver ID", "First Name", "Last Name", "Date of Birth", "Driving Licence", "First Address", "Second Address", "Post Code", "Speed of Zone MPH", "Driver Speed MPH", "Difference MPH", "Fine Amount £"};
            rowData = new String[tableRowAmount][12];
            int row = 0;
            int column = 0;
            int count = 1;
            for (int i = 0; i < arrList.size(); i++) {
                if (i == (count * 12)) {
                    column = 0;
                    row++;
                    count++;
                }
                rowData[row][column] = arrList.get(i);
                column++;
            }
            JTable driverTable = new JTable(rowData, columnNames);
            driverScrollPane = new JScrollPane(driverTable);
            driverScrollPane.setBounds(0, 0, 1005, 200);

            pnlSearchDriver.add(driverScrollPane);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frmSearchDriver, "Something went wrong, Please check the datastore");
        }
    }





    class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String text = txtDriverID.getText();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter(text, 0));
            }
        }


        }


    class DriverRemoveHandler implements ActionListener {
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

