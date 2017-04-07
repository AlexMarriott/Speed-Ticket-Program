package dvla.gui;

import dvla.logic.DatabaseWriter;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1> SearchVehicleGUI</h1>
 * The SearchVehicleGUI creates the SearchDriverGUI Window, which allows users to see all the Drivers records which have been
 * logged into the system. SearchDriverGUI also allows the user to search for specific vehicle.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class SearchVehicleGUI {
    /**Declares a Jlabel named lblVehicleID, which labels the search VehicleID textbox*/
    private JLabel lblVehicleID;

    /**Declares a JTextField named txtVehicleID, which provides a JTextboxes*/
    private JTextField txtVehicleID;
   
    /**Declares a JButton named btnSearch and btnExit.
     * These are used for searching/ removing Vehicles and exiting the window.*/
    private JButton btnSearch, btnExit;
   
    /**Declares a JPanel named pnlSearchVehicle for use with the SearchVehicleGUI.*/
    private JPanel pnlSearchVehicle;

    /**Declares a JFrame named frmSearchVehicle, for use with the SearchVehicleGUI.*/
    private JFrame frmSearchVehicle;

    /**Declares a JTable named vehicleTable, which displays all the vehicles information.*/
    private JTable vehicleTable;
   
    /**Declares a JScrollPane named vehicleScrollPane, which allows the user to scoll down the JTable.*/
    private JScrollPane vehicleScrollPane;
   
    /**Declares a ArrayList named lblDriverID.
     * This reads in all the vehicles information to add to the JTable.*/
    private ArrayList<String> rowAndColumnData;

    /**Declares an int named tableRowAmount, this is used to calculate the amount of rows needed..*/
    private int tableRowAmount;

    /**Declares an String[][] named rowData, this takes in the tableRowAmount variable and the colum.length to help set the correct
     * amount of rows and columns.*/
    private String[][] rowData;

    /**Declares a TableRowSorter named sorter.
     * This allows users to sort the table how they like and lets the search vehicles filter the table when searching for an ID.*/
    TableRowSorter<TableModel> sorter = new TableRowSorter<>();

    /**Declares an DefaultTableModel named defaultTableModel.
     * Once we pass the default model to the vehicleTable, we are able to interface with it better.
     * This means I am able to get the headers and row selection etc.*/
    private DefaultTableModel defaultTableModel;

    /** Declares a int named columnHeaderAmount
     * If any changes are made to the columnHeader String array (new fields or remove fields)
     * The number assigned to columnHeaderAmount should changes also as, the columnHeaderAmount is used to divide the amount of columns in
     * one row.*/
    private int columnHeaderAmount;

    /** Declares an int named vehicleTableRowCount, this vehicleTableRowCount is assigned the Rowcount from the vehicletable and then passed
     * through to the DatabaseWriter class. */
    private int vehicleTableRowCount;
    /** Declares an int named vehicleTableColumnCount, this vehicleTableColumnCount is assigned the ColumnCount from the vehicletable and then passed
     * through to the DatabaseWriter class. */
    private int vehicleTableColumnCount;

    /** Declares an object of DatabaseWriter and names it vehicleTableWriteToFile  */
    private DatabaseWriter vehicleTableWriteToFile;

    /** Constructor runs the methods to create the GUI and Table then auto fills the data in the JTable*/
    public SearchVehicleGUI() {
        pnlAddSearchvehicle();
        addVehicleViewFields();
        addVehicleViewButtons();
        try {
            getVehicle();
            setTableRows();
            createVehicleTable();
            //Adding a Table Listener and passing it through to tableEdit(), this listener is used to write any new data to the driver.txt
            vehicleTable.getModel().addTableModelListener(new tableEdit());
            //.putClientProperty ("terminateEditOnFocusLost" ends the editing of the cells and clears any selected rows
            vehicleTable.putClientProperty("terminateEditOnFocusLost", true);
            setScrollPane();
        } catch (Exception e) {
            e.printStackTrace();
        }
        frmAddSearchVehicle();
    }
    /** Creates the frame and stops the user from closing the frame from the top right exit button.
     *  This is to allow the data to be saved when changes are made.
     */
    private void frmAddSearchVehicle() {
        frmSearchVehicle = new JFrame();
        frmSearchVehicle.setTitle("View Vehicle");
        frmSearchVehicle.setSize(1250, 400);
        frmSearchVehicle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearchVehicle.setLocationRelativeTo(null);
        frmSearchVehicle.setResizable(false);
        frmSearchVehicle.getRootPane().setDefaultButton(btnSearch);
        frmSearchVehicle.add(pnlSearchVehicle);
        frmSearchVehicle.setVisible(true);

        //This is to stop the user from closing the window. If they close the window then information in the Jtable cannot be saved correctly.
        frmSearchVehicle.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

    /** Creates the panel for the SearchVehicleGUI*/
    private void pnlAddSearchvehicle() {
        pnlSearchVehicle = new JPanel();
        pnlSearchVehicle.setLayout(null);
    }

    /** Create the Jlabel and Jtextfields for the user input in the SearchVehicleGUI.*/
    private void addVehicleViewFields() {

        lblVehicleID = new JLabel("Vehicle ID");
        lblVehicleID.setBounds(10, 250, 100, 20);
        pnlSearchVehicle.add(lblVehicleID);

        txtVehicleID = new JTextField(null);
        txtVehicleID.setBounds(100, 250, 100, 20);
        pnlSearchVehicle.add(txtVehicleID);

    }
    /** Adds Jbuttons to the SearchVehicleGUI*/
    private void addVehicleViewButtons() {
        btnSearch = new JButton("Search Vehicle");
        btnSearch.setBounds(20, 335, 140, 30);
        btnSearch.addActionListener(new VehicleSearchHandler());
        pnlSearchVehicle.add(btnSearch);

        btnExit = new JButton("Back");
        btnExit.setBounds(1100, 335, 140, 30);
        btnExit.addActionListener(new VehicleSearchExitHandler());
        pnlSearchVehicle.add(btnExit);
    }

    /** Sets the amount of columns headers there are and divides it by the size of rowAndColumnData.
     * rowAndColumnData is an Arraylist type String which reads in all the lines from the drivers.txt and then is divided by the amount of column Headers
     * to work out how many rows there should be.
     **/
    private void setTableRows() {
        columnHeaderAmount = 10;
        tableRowAmount = rowAndColumnData.size() / columnHeaderAmount;
    }

    /**Sets rowAndColumnData as an Arraylist and reads in all the String data from the Drivers.txt file.*/
    private void getVehicle() {
        rowAndColumnData = new ArrayList<>();

        File file = new File("Vehicle.txt");
        try {
            Scanner readIn = new Scanner(file);
            while (readIn.hasNext()) {
                rowAndColumnData.add(readIn.nextLine());
            }
        } catch (IOException exception ) {
            exception.printStackTrace();;

        }
    }




    /**Creates the Driver Jtable which display all the driver information, allowing the user to search the table and remove the driver is they wish.
     *createDriverTable creates a two dimensional array om tableRowAmount and the column length.
     *With this, it goes into a for loops to set all the data to each cell going via column an starting a new row once the column headers had been filled. */
    private void createVehicleTable() {
        try {
            // ColumnName Default size is 9 but 10 to allow us to increment the column by one , if anymore headers are added, change the columnHeaderAmount in the setTableRows method.
            String[] columnNames = {" Vehicle ID", "Vehicle Model", "Vehicle Make", "Vehicle Number Plate", "Vehicle Year", "Owner", "Driving Licence Number", "First Line of Address", "Second Line of Address", "Post Code"};
            rowData = new String[tableRowAmount][columnNames.length];
            int row = 0;
            int column = 0;
            int count = 1;
            //For loops goes through the rowAndColumnData ArrayList and when it completes the first line will increment to the next line.
            for (int i = 0; i < rowAndColumnData.size(); i++) {
                if (i == (count * columnHeaderAmount)) {
                    column = 0;
                    row++;
                    count++;
                }
                // The 0 postition in the array is the Driver ID, this if statement makes sure the int is put into a String.
                if (column == 0){
                    String stringToInt = rowAndColumnData.get(i);
                    rowData[row][column] = String.valueOf(Integer.parseInt(stringToInt));
                    column++;
                } else {
                    rowData[row][column] = rowAndColumnData.get(i);
                    column++;
                }
            }
            //Creates a new DefaultTableModel and then sets it in the Jtable
            defaultTableModel = new DefaultTableModel(rowData, columnNames);
            vehicleTable = new JTable(defaultTableModel);

            //Stops users from ordering the Jtable.
            vehicleTable.setEnabled(false);
            vehicleTable.getTableHeader().setReorderingAllowed(false);
            vehicleTable.getTableHeader().setResizingAllowed(false);
            vehicleTable.setAutoCreateRowSorter(true);

            //Set a table sorter to organise the Jtable data.
            sorter = new TableRowSorter<>(vehicleTable.getModel());
            vehicleTable.setRowSorter(sorter);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frmSearchVehicle, "Something went wrong, Please check the datastore");
        }
    }
    /** This TableModelListener get any changes which happens to the Jtable and writes them to the Drivers.txt
     * This method has a TableModelListener which, if the user removes a driver, the writeTOFile method will be ran which rewrites the data to the drivers.txt*/
    private class tableEdit implements TableModelListener {
        public void tableChanged(TableModelEvent event) {
            vehicleTableWriteToFile = new DatabaseWriter();
            vehicleTableRowCount = vehicleTable.getRowCount() ;
            vehicleTableColumnCount = vehicleTable.getColumnCount();
            vehicleTableWriteToFile.writeToVehicleFile(vehicleTableRowCount,vehicleTableColumnCount, rowData );
        }
    }

    /** Set driverTable(Jtable) to a scrollPane so user can scroll up and down.*/
    private void setScrollPane() {
        vehicleScrollPane = new JScrollPane(vehicleTable);
        vehicleScrollPane.setBounds(0, 0, 1250, 200);
        pnlSearchVehicle.add(vehicleScrollPane);
    }

    /** DriverSearchHandler Filters the rows using regexfilter to find the DriverID and returns it on the Jtable*/
    private class VehicleSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            sorter.setRowFilter(RowFilter.regexFilter(txtVehicleID.getText(), 0));
        }
    }

    /** DriverSearchExitHandler disposes of the SearchDriver frame once the use clicks the Exit button.*/
    private class VehicleSearchExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchVehicle.dispose();
        }
    }

}