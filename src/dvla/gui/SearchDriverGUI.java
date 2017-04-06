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
 * <h1> SearchDriverGUI</h1>
 * The SearchDriverGUI creates the SearchDriverGUI Window, which allows users to see all the Drivers records which have been
 * logged into the system. SearchDriverGUI also allows the user to remove drivers and search for specific drivers.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class SearchDriverGUI {

    /**Declares a Jlabel named lblDriverID, which labels the search DriverId textbox*/
    private JLabel lblDriverID;

    /**Declares a JTextField named txtDriverID, which provides a JTextboxes*/
    private JTextField txtDriverID;

    /**Declares JButton named btnSearch,btnRemove,btnExit.
     *These are used for searching/ removing drivers and exiting the window.*/
    private JButton btnSearch, btnRemove, btnExit;

    /**Declares JPanel named pnlSearchDriver, for use with the SearchDriverGUI. */
    private JPanel pnlSearchDriver;

    /**Declares a JFrame named frmSearchDriver, for use with the SearchDriverGUI.*/
    private JFrame frmSearchDriver;

    /**Declares a JTable named driverTable, which displays all the drivers information.*/
    private JTable driverTable;

    /**Declares a JScrollPane named driverScrollPane, which allows the user to scoll down the JTable.*/
    private JScrollPane driverScrollPane;

    /**Declares an ArrayList named rowAndColumnData.
     * This reads in all the drivers information to add to the JTable.*/
    private ArrayList<String> rowAndColumnData;

    /**Declares an int named tableRowAmount, this is used to calculate the amount of rows needed.*/
    private int tableRowAmount;

    /**Declares an String[][] named rowData, this takes in the tableRowAmount variable and the colum.length to help set the correct
     * amount of rows and columns. */
    private String[][] rowData;

    /**Declares a TableRowSorter named sorter.
     * This allows users to sort the table how they like and lets the search driver filter the table when searching for an ID.*/
    private TableRowSorter<TableModel> sorter = new TableRowSorter<>();

    /**Declares an DefaultTableModel named defaultTableModel.
     * Once we pass the default model to the drivertable, we are able to interface with it better.
     * This means I am able to get the headers and row selection etc.*/
    private DefaultTableModel defaultTableModel;

    /** Declares a int named columnHeaderAmount
     * If any changes are made to the columnHeader String array (new fields or remove fields)
     * The number assigned to columnHeaderAmount should changes also as, the columnHeaderAmount is used to divide the amount of columns in
     * one row.*/
    private int columnHeaderAmount;

    /** Declares an int named driverTableRowCount, this driverTableRowCount is assigned the Rowcount from the drivertable and then passed
     * through to the DatabaseWriter class. */
    private int driverTableRowCount;

    /** Declares an int named driverTableColumnCount, this driverTableColumnCount is assigned the columnCount from the drivertable and then passed
     * through to the DatabaseWriter class. */
    private int driverTableColumnCount;

    /** Declares an object of DatabaseWriter and names it driverTableWriteToFile  */
    private DatabaseWriter driverTableWriteToFile;


    /** Constructor runs the methods to create the GUI and Table then auto fills the data in the JTable*/
    public SearchDriverGUI() {
        pnlAddSearchDriver();
        addDriverViewFields();
        addDriverViewButtons();
        try {
            getDriver();
            setTableRows();
            createDriverTable();

            //Adding a Table Listener and passing it through to tableEdit(), this listener is used to write any new data to the driver.txt
            driverTable.getModel().addTableModelListener(new tableEdit());
            //.putClientProperty ("terminateEditOnFocusLost" ends the editing of the cells and clears any selected rows
            driverTable.putClientProperty("terminateEditOnFocusLost", true);
            setScrollPane();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        frmAddSearchDriver();

    }

    /** Creates the frame and stops the user from closing the frame from the top right exit button.
     *  This is to allow the data to be saved when changes are made.
     */
    private void frmAddSearchDriver() {
        frmSearchDriver = new JFrame();
        frmSearchDriver.setTitle("View Driver");
        frmSearchDriver.setSize(1250, 400);
        frmSearchDriver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearchDriver.setLocationRelativeTo(null);
        frmSearchDriver.setResizable(false);
        frmSearchDriver.add(pnlSearchDriver);
        frmSearchDriver.setVisible(true);

        //This is to stop the user from closing the window. If they close the window then information in the Jtable cannot be saved correctly.
        frmSearchDriver.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

    /** Creates the panel for the SearchDriverGUI*/
    private void pnlAddSearchDriver() {
        pnlSearchDriver = new JPanel();
        pnlSearchDriver.setLayout(null);
    }

    /** Create the Jlabel and Jtextfields for the user input in the SearchDriverGUI.*/
    private void addDriverViewFields() {

        lblDriverID = new JLabel("Driver ID");
        lblDriverID.setBounds(10, 250, 100, 20);
        pnlSearchDriver.add(lblDriverID);

        txtDriverID = new JTextField(null);
        txtDriverID.setBounds(100, 250, 100, 20);
        pnlSearchDriver.add(txtDriverID);

    }

    /** Adds Jbuttons to the SearchDriverGUI*/
    private void addDriverViewButtons() {
        btnSearch = new JButton("Search Driver");
        btnSearch.setBounds(20, 335, 140, 30);
        btnSearch.addActionListener(new DriverSearchHandler());
        pnlSearchDriver.add(btnSearch);

        btnRemove = new JButton("Remove Driver");
        btnRemove.setBounds(180, 335, 140, 30);
        btnRemove.addActionListener(new DriverRemoveHandler());
        pnlSearchDriver.add(btnRemove);

        btnExit = new JButton("Back");
        btnExit.setBounds(1100, 335, 140, 30);
        btnExit.addActionListener(new DriverSearchExitHandler());
        pnlSearchDriver.add(btnExit);
    }

    /** Sets the amount of columns headers there are and divides it by the size of rowAndColumnData.
     * rowAndColumnData is an Arraylist type String which reads in all the lines from the drivers.txt and then is divided by the amount of column Headers
     * to work out how many rows there should be. 
     **/
    private void setTableRows() {
        columnHeaderAmount = 14;
        tableRowAmount = rowAndColumnData.size() / columnHeaderAmount;
    }

    /**Sets rowAndColumnData as an Arraylist and reads in all the String data from the Drivers.txt file.*/
    private void getDriver() {
        rowAndColumnData = new ArrayList<>();

        File file = new File("Drivers.txt");
        try {
            Scanner readIn = new Scanner(file);
            while (readIn.hasNext()) {
                rowAndColumnData.add(readIn.nextLine());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    

    /**Creates the Driver Jtable which display all the driver information, allowing the user to search the table and remove the driver is they wish.
     *createDriverTable creates a two dimensional array om tableRowAmount and the column length.
     *With this, it goes into a for loops to set all the data to each cell going via column an starting a new row once the column headers had been filled. */
    private void createDriverTable() {
        try {
            // ColumnName Default size is 13, if anymore headers are added, change the columnHeaderAmount in the setTableRows method.
            String[] columnNames = {"Driver ID", "First Name", "Last Name", "Date of Birth", "Driving Licence", "First Address", "Second Address", "Post Code", "Road Type", "Speed of Zone MPH", "Driver Speed MPH", "Difference MPH", "Fine Amount £", "Action Taken"};
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
                //If the Column Name is of one of the int value columns then  it will get passed to a String.valueOf, this is so in future we can maybe use those columnms in reports.
                if (column == 0 | column == 9 | column == 10 | column == 11 | column == 12) {
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
            driverTable = new JTable(defaultTableModel);

            //Stops users from ordering the Jtable.
            driverTable.setEnabled(true);
            driverTable.getTableHeader().setReorderingAllowed(false);
            driverTable.getTableHeader().setResizingAllowed(true);
            driverTable.setAutoCreateRowSorter(true);

            //At this point, I have no idea how to get it to size correctly.
            driverTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);


            //Set a table sorter to organise the Jtable data.
            sorter = new TableRowSorter<>(driverTable.getModel());
            driverTable.setRowSorter(sorter);

        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(frmSearchDriver, "Something went wrong, Please check the datastore");
        }
    }
    /** This TableModelListener get any changes which happens to the Jtable and writes them to the Drivers.txt
     * This method has a TableModelListener which, if the user removes a driver, the writeTOFile method will be ran which rewrites the data to the drivers.txt*/
    private class tableEdit implements TableModelListener {
        public void tableChanged(TableModelEvent tableEvent) {
            driverTableWriteToFile = new DatabaseWriter();
            if(driverTable.isEditing()){
                JOptionPane.showMessageDialog(frmSearchDriver, "Please do not edit the cells, remove and recreate the Driver." +"\n" +" Any changes won't be saved.");
            }
            driverTableRowCount = driverTable.getRowCount() ;
           driverTableColumnCount = driverTable.getColumnCount();
            driverTableWriteToFile.writeToFile(driverTableRowCount,driverTableColumnCount,rowData );
        }
    }

    /** Set driverTable(Jtable) to a scrollPane so user can scroll up and down.*/
    private void setScrollPane() {
        driverScrollPane = new JScrollPane(driverTable);
        driverScrollPane.setBounds(0, 0, 1250, 200);
        pnlSearchDriver.add(driverScrollPane);
    }

    /** DriverSearchHandler Filters the rows using regexfilter to find the DriverID and returns it on the Jtable*/
    private class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            sorter.setRowFilter(RowFilter.regexFilter(txtDriverID.getText(), 0));
        }
    }
    /** DriverRemoveHandler using the defaultTableModel to remove the row which is selected in the driverTable.
     * If a row is not selected then a prompt will appear telling the user to select a row. */
    private class DriverRemoveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(driverTable.getSelectedRow() <= -1){
                JOptionPane.showMessageDialog(frmSearchDriver, "Please select a row to remove.");
            }else
            defaultTableModel.removeRow(driverTable.getSelectedRow());
        }
    }

    /** DriverSearchExitHandler disposes of the SearchDriver frame once the use clicks the Exit button.*/
    private class DriverSearchExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchDriver.dispose();
        }
    }



}