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
 * Created by Alex on 23/02/2017.
 */
public class SearchDriverGUI {
    private JLabel lblDriverID;
    private JTextField txtDriverID;
    private JButton btnSearch, btnRemove, btnExit;
    private JPanel pnlSearchDriver;
    private JFrame frmSearchDriver;
    private JTable driverTable;
    private JScrollPane driverScrollPane;

    private ArrayList<String> arrList;

    private int tableRowAmount;

    private String[][] rowData;

    TableRowSorter<TableModel> sorter = new TableRowSorter<>();
    private DefaultTableModel defaultTableModel;


    public SearchDriverGUI() {
        pnlAddSearchDrive();
        addDriverViewFields();
        addDriverViewButtons();
        try {
            getDriver();
            getTableRows();
            createDriverTable();
            driverTable.getModel().addTableModelListener(new tableEdit());
            driverTable.putClientProperty("terminateEditOnFocusLost", true);
            setScrollPane();
        } catch (Exception e) {
            e.printStackTrace();
        }
        frmAddSearchDriver();
    }

    public void frmAddSearchDriver() {
        frmSearchDriver = new JFrame();
        frmSearchDriver.setTitle("View Driver");
        frmSearchDriver.setSize(1250, 400);
        frmSearchDriver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearchDriver.setVisible(false);
        frmSearchDriver.setLocationRelativeTo(null);
        frmSearchDriver.setResizable(false);
        frmSearchDriver.add(pnlSearchDriver);
        frmSearchDriver.setVisible(true);

        //This is to stop the user from closing the window. If they close the window then information in the Jtable cannot be saved correctly.
        frmSearchDriver.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

    public void pnlAddSearchDrive() {
        pnlSearchDriver = new JPanel();
        pnlSearchDriver.setLayout(null);
    }

    public void addDriverViewFields() {

        lblDriverID = new JLabel("Driver ID");
        lblDriverID.setBounds(10, 250, 100, 20);
        pnlSearchDriver.add(lblDriverID);

        txtDriverID = new JTextField(null);
        txtDriverID.setBounds(100, 250, 100, 20);
        pnlSearchDriver.add(txtDriverID);

    }

    public void addDriverViewButtons() {
        btnSearch = new JButton("Search Driver");
        btnSearch.setBounds(20, 335, 140, 30);
        btnSearch.addActionListener(new DriverSearchHandler());
        pnlSearchDriver.add(btnSearch);

        btnRemove = new JButton("Remove Driver");
        btnRemove.setBounds(180, 335, 140, 30);
        btnRemove.addActionListener(new DriverRemoveHandler());
        pnlSearchDriver.add(btnRemove);

        btnExit = new JButton("Back");
        btnExit.setBounds(820, 335, 140, 30);
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

    public void writeToFile() {
        try {
            FileWriter writeToDataStore = new FileWriter("Drivers.txt");
            for (int i = 0; i < driverTable.getRowCount(); i++) {
                for (int j = 0; j < driverTable.getColumnCount(); j++) {
                    writeToDataStore.write(rowData[i][j].toString().toUpperCase() + "\n");
                }
            }
            writeToDataStore.flush();
            writeToDataStore.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createDriverTable() {
        try {
            String[] columnNames = {"Driver ID", "First Name", "Last Name", "Date of Birth", "Driving Licence", "First Address", "Second Address", "Post Code", "Road Type", "Speed of Zone MPH", "Driver Speed MPH", "Difference MPH", "Fine Amount £", "Action Taken"};
            rowData = new String[tableRowAmount][columnNames.length];
            int row = 0;
            int column = 0;
            int count = 1;
            for (int i = 0; i < arrList.size(); i++) {
                if (i == (count * 14)) {
                    column = 0;
                    row++;
                    count++;
                }
                if (column == 0 | column == 9 | column == 10 | column == 11 | column == 12) {
                    String stringToInt = arrList.get(i);
                    rowData[row][column] = String.valueOf(Integer.parseInt(stringToInt));
                    column++;
                } else {
                    rowData[row][column] = arrList.get(i);
                    column++;
                }
            }
            defaultTableModel = new DefaultTableModel(rowData, columnNames);
            driverTable = new JTable(defaultTableModel);
            driverTable.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(driverTable.getModel());
            driverTable.setRowSorter(sorter);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frmSearchDriver, "Something went wrong, Please check the datastore");
        }
    }

    class tableEdit implements TableModelListener {
        public void tableChanged(TableModelEvent e) {
            writeToFile();
        }
    }

    public void setScrollPane() {
        driverScrollPane = new JScrollPane(driverTable);
        driverScrollPane.setBounds(0, 0, 1250, 200);
        pnlSearchDriver.add(driverScrollPane);
    }

    class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            sorter.setRowFilter(RowFilter.regexFilter(txtDriverID.getText(), 0));
        }
    }

    class DriverRemoveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            defaultTableModel.removeRow(driverTable.getSelectedRow());
        }
    }

    class DriverSearchExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchDriver.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchVehicleGUI();
    }
}