package dvla.gui;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1> SearchVehicleGUI</h1>
 * The SearchVehicleGUI creates the SearchVehicleGUI Window, which allows users to see all the Vehicles records which have been logged into the system.
 * SearchVehicleGUI allows the users to search for specific drivers.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class SearchVehicleGUI {
    /**Declares a Jlabel named lblVehicleID.*/
    private JLabel lblVehicleID;
    
    /**Declares a JTextbox named txtVehicleID.*/
    private JTextField txtVehicleID;
   
    /**Declares a JButton named btnSearch and btnExit.*/
    private JButton btnSearch, btnExit;
   
    /**Declares a JPanel named pnlSearchVehicle.*/
    private JPanel pnlSearchVehicle;
   
    /**Declares a JFrame named frmSearchVehicle.*/
    private JFrame frmSearchVehicle;
    
    /**Declares a JTable named vehicleTable.*/
    private JTable vehicleTable;
   
    /**Declares a JScrollPane named vehicleScrollPane.*/
    private JScrollPane vehicleScrollPane;
   
    /**Declares a ArrayList<String> named lblDriverID.*/
    private ArrayList<String> countRowsAndColumns;

    /**Declares an int named tableRowAmount.*/
    private int tableRowAmount;

    /**Declares an String[][] named rowData.*/
    private String[][] rowData;

    /**Declares a TableRowSorterr<TableModel> named sorter.*/
    TableRowSorter<TableModel> sorter = new TableRowSorter<>();

    /**Declares an DefaultTableModel named defaultTableModel.*/
    private DefaultTableModel defaultTableModel;

    /** Declares a int named columnHeaderAmount*/
    private int columnHeaderAmount;


    /**Declares a Jlabel named lblDriverID.*/
    public SearchVehicleGUI() {
        pnlAddSearchvehicle();
        addVehicleViewFields();
        addVehicleViewButtons();
        try {
            getVehicle();
            getTableRows();
            createVehicleTable();
            vehicleTable.getModel().addTableModelListener(new tableEdit());
            vehicleTable.putClientProperty("terminateEditOnFocusLost", true);
            setScrollPane();
        } catch (Exception e) {
            e.printStackTrace();
        }
        frmAddSearchVehicle();
    }

    public void frmAddSearchVehicle() {
        frmSearchVehicle = new JFrame();
        frmSearchVehicle.setTitle("View Driver");
        frmSearchVehicle.setSize(1250, 400);
        frmSearchVehicle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearchVehicle.setLocationRelativeTo(null);
        frmSearchVehicle.setResizable(false);
        frmSearchVehicle.add(pnlSearchVehicle);
        frmSearchVehicle.setVisible(true);

        //This is to stop the user from closing the window. If they close the window then information in the Jtable cannot be saved correctly.
        frmSearchVehicle.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

    public void pnlAddSearchvehicle() {
        pnlSearchVehicle = new JPanel();
        pnlSearchVehicle.setLayout(null);
    }

    public void addVehicleViewFields() {

        lblVehicleID = new JLabel("Driver ID");
        lblVehicleID.setBounds(10, 250, 100, 20);
        pnlSearchVehicle.add(lblVehicleID);

        txtVehicleID = new JTextField(null);
        txtVehicleID.setBounds(100, 250, 100, 20);
        pnlSearchVehicle.add(txtVehicleID);

    }

    public void addVehicleViewButtons() {
        btnSearch = new JButton("Search Vehicle");
        btnSearch.setBounds(20, 335, 140, 30);
        btnSearch.addActionListener(new VehicleSearchHandler());
        pnlSearchVehicle.add(btnSearch);

        btnExit = new JButton("Back");
        btnExit.setBounds(820, 335, 140, 30);
        btnExit.addActionListener(new VehicleSearchExitHandler());
        pnlSearchVehicle.add(btnExit);
    }

    public double getTableRows() {
        return tableRowAmount = countRowsAndColumns.size() / 10;
    }

    public void getVehicle() {
        countRowsAndColumns = new ArrayList<>();

        File file = new File("Vehicle.txt");
        try {
            Scanner readIn = new Scanner(file);
            while (readIn.hasNext()) {
                countRowsAndColumns.add(readIn.nextLine());
            }
        } catch (IOException e) {

        }
    }

    public void writeToFile() {
        try {
            FileWriter writeToDataStore = new FileWriter("Vehicle.txt");
            for (int i = 0; i < vehicleTable.getRowCount(); i++) {
                for (int j = 0; j < vehicleTable.getColumnCount(); j++) {
                    writeToDataStore.write(rowData[i][j].toString().toUpperCase() + "\n");
                }
            }
            writeToDataStore.flush();
            writeToDataStore.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createVehicleTable() {
        try {

            String[] columnNames = {" Vehicle ID", "Vehicle Model", "Vehicle Make", "Vehicle Number Plate", "Vehicle Year", "Owner", "Driving Licence Number", "First Line of Address", "Second Line of Address", "Post Code"};
            rowData = new String[tableRowAmount][columnNames.length];
            int row = 0;
            int column = 0;
            int count = 1;
            for (int i = 0; i < countRowsAndColumns.size(); i++) {
                if (i == (count * 10)) {
                    column = 0;
                    row++;
                    count++;
                }
                if (column == 0){
                    String stringToInt = countRowsAndColumns.get(i);
                    rowData[row][column] = String.valueOf(Integer.parseInt(stringToInt));
                    column++;
                } else {
                    rowData[row][column] = countRowsAndColumns.get(i);
                    column++;
                }
            }
            defaultTableModel = new DefaultTableModel(rowData, columnNames);
            vehicleTable = new JTable(defaultTableModel);
            vehicleTable.setEnabled(false);
            vehicleTable.getTableHeader().setReorderingAllowed(false);
            vehicleTable.getTableHeader().setResizingAllowed(false);
            vehicleTable.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(vehicleTable.getModel());
            vehicleTable.setRowSorter(sorter);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frmSearchVehicle, "Something went wrong, Please check the datastore");
        }
    }

    class tableEdit implements TableModelListener {
        public void tableChanged(TableModelEvent e) {
            writeToFile();
        }
    }

    public void setScrollPane() {
        vehicleScrollPane = new JScrollPane(vehicleTable);
        vehicleScrollPane.setBounds(0, 0, 1250, 200);
        pnlSearchVehicle.add(vehicleScrollPane);
    }

    class VehicleSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            sorter.setRowFilter(RowFilter.regexFilter(txtVehicleID.getText(), 0));
        }
    }

    class VehicleSearchExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchVehicle.dispose();
        }
    }

    public static void main(String[] args) {
        new SearchVehicleGUI();
    }
}