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


    /** Constructor runs the methods to create the GUI and Table then auto fills the data in the JTable*/
    public SearchVehicleGUI() {
        pnlAddSearchvehicle();
        addVehicleViewFields();
        addVehicleViewButtons();
        try {
            getVehicle();
            getTableRows();
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
        btnExit.setBounds(820, 335, 140, 30);
        btnExit.addActionListener(new VehicleSearchExitHandler());
        pnlSearchVehicle.add(btnExit);
    }

    /** Sets the amount of columns headers there are and divides it by the size of countRowsAndColumns.
     * countRowsAndColumns is an Arraylist type String which reads in all the lines from the drivers.txt and then is divided by the amount of column Headers
     * to work out how many rows there should be.
     **/
    private double getTableRows() {
        columnHeaderAmount = 10;
        return tableRowAmount = countRowsAndColumns.size() / columnHeaderAmount;
    }

    /**Sets countRowsAndColumns as an Arraylist and reads in all the String data from the Drivers.txt file.*/
    private void getVehicle() {
        countRowsAndColumns = new ArrayList<>();

        File file = new File("Vehicle.txt");
        try {
            Scanner readIn = new Scanner(file);
            while (readIn.hasNext()) {
                countRowsAndColumns.add(readIn.nextLine());
            }
        } catch (IOException exception ) {
            exception.printStackTrace();;

        }
    }

    /** This method counts the rows and columns from the Jtable and writes each line back into the text file.
     * writeToFile has two for loops which iterate through the Jtable and write each cell from the Jtable back into the text file when changes are made in the table.
     * such as the removal of a Driver.*/
    private void writeToFile() {
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
    /**Creates the Driver Jtable which display all the driver information, allowing the user to search the table and remove the driver is they wish.
     *createDriverTable creates a two dimensional array om tableRowAmount and the column length.
     *With this, it goes into a for loops to set all the data to each cell going via column an starting a new row once the column headers had been filled. */
    private void createVehicleTable() {
        try {
            // ColumnName Default size is 9 but 10 to allow us to increment the column by one , if anymore headers are added, change the columnHeaderAmount in the getTableRows method.
            String[] columnNames = {" Vehicle ID", "Vehicle Model", "Vehicle Make", "Vehicle Number Plate", "Vehicle Year", "Owner", "Driving Licence Number", "First Line of Address", "Second Line of Address", "Post Code"};
            rowData = new String[tableRowAmount][columnNames.length];
            int row = 0;
            int column = 0;
            int count = 1;
            //For loops goes through the countRowsAndColumns ArrayList and when it completes the first line will increment to the next line.
            for (int i = 0; i < countRowsAndColumns.size(); i++) {
                if (i == (count * columnHeaderAmount)) {
                    column = 0;
                    row++;
                    count++;
                }
                // The 0 postition in the array is the Driver ID, this if statement makes sure the int is put into a String.
                if (column == 0){
                    String stringToInt = countRowsAndColumns.get(i);
                    rowData[row][column] = String.valueOf(Integer.parseInt(stringToInt));
                    column++;
                } else {
                    rowData[row][column] = countRowsAndColumns.get(i);
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
            writeToFile();
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