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
public class SearchVehicleGUI {
    private JLabel lblVehicleID;
    private JTextField txtVehicleID;
    private JButton btnSearch, btnExit;
    private JPanel pnlSearchVehicle;
    private JFrame frmSearchVehicle;
    private JTable vehicleTable;
    private JScrollPane vehicleScrollPane;

    private ArrayList<String> arrList;

    private int tableRowAmount;

    private String[][] rowData;

    TableRowSorter<TableModel> sorter = new TableRowSorter<>();
    private DefaultTableModel defaultTableModel;


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
        frmSearchVehicle.setVisible(false);
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
        btnSearch.addActionListener(new DriverSearchHandler());
        pnlSearchVehicle.add(btnSearch);

        btnExit = new JButton("Back");
        btnExit.setBounds(820, 335, 140, 30);
        btnExit.addActionListener(new DriverSearchExitHandler());
        pnlSearchVehicle.add(btnExit);
    }

    public double getTableRows() {
        return tableRowAmount = arrList.size() / 12;
    }

    public void getVehicle() {
        arrList = new ArrayList<>();

        File file = new File("Vehicle.txt");
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
            vehicleTable = new JTable(defaultTableModel);
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

    class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            sorter.setRowFilter(RowFilter.regexFilter(txtVehicleID.getText(), 0));
        }
    }

    class DriverRemoveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            defaultTableModel.removeRow(vehicleTable.getSelectedRow());
        }
    }

    class DriverSearchExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchVehicle.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchVehicleGUI();
    }
}