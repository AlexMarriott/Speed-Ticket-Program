package dvla.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alex on 23/02/2017.
 */
public class SearchDriverGUI {
    private JLabel lblDriverID, lblStatus;
    private JTextField txtDriverID, txtStatus;
    private JButton btnSearch, btnRemove, btnTopFiveOccurrences, btnTopFiveFines, btnExit;
    private JPanel pnlSearchDriver;
    private JFrame frmSearchDriver;
    private JTable driverTable;
    private JScrollPane driverScrollPane;
    private ArrayList driverData;
    private ArrayList<String> arrList;
    private int tableRowAmount;
    private String[] columnNames;
    private String[][] rowData;

    TableRowSorter<TableModel> sorter = new TableRowSorter<>();

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
        setScrollPane(driverTable);
        frmAddSearchDriver();
    }

    public void frmAddSearchDriver() {
        frmSearchDriver = new JFrame();
        frmSearchDriver.setTitle("View Driver");
        frmSearchDriver.setSize(1010, 400);
        frmSearchDriver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmSearchDriver.setVisible(false);
        frmSearchDriver.setLocationRelativeTo(null);
        frmSearchDriver.setResizable(false);
        frmSearchDriver.add(pnlSearchDriver);
        frmSearchDriver.setVisible(true);
    }

    public void pnlAddSearchDrive() {
        pnlSearchDriver = new JPanel();
        pnlSearchDriver.setLayout(null);
    }

    public void addDriverViewFields() {

        lblDriverID = new JLabel("Driver ID");
        lblDriverID.setBounds(10, 250, 100, 20);
        pnlSearchDriver.add(lblDriverID);

        lblStatus = new JLabel("Cell Location");
        lblStatus.setBounds(10, 295, 100, 20);
        pnlSearchDriver.add(lblStatus);


        txtDriverID = new JTextField(null);
        txtDriverID.setBounds(100, 250, 100, 20);
        pnlSearchDriver.add(txtDriverID);

        txtStatus = new JTextField(null);
        txtStatus.setBounds(100, 295, 300, 25);
        pnlSearchDriver.add(txtStatus);
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

        btnTopFiveOccurrences = new JButton("Show Top Five Offenders By Occurrences");
        btnTopFiveOccurrences.setBounds(340, 335, 240, 30);
        btnTopFiveOccurrences.addActionListener(new TopFiveOccurrenceHandler());
        pnlSearchDriver.add(btnTopFiveOccurrences);

        btnTopFiveFines = new JButton("Show Top Five Offenders By Fines");
        btnTopFiveFines.setBounds(600, 335, 200, 30);
        btnTopFiveFines.addActionListener(new TopFiveFinesHandler());
        pnlSearchDriver.add(btnTopFiveFines);

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

   /*public void saveDriverData()
    {
        ArrayList<ArrayList<String>> arrSave = new ArrayList<ArrayList<>>();
        for(int i = 0; i < driverTable.getRowCount(); i++)
        {
            arrSave.add(driverTable.getValueAt(i, 0).toString());
        }
        System.out.println(Arrays.asList(arrSave));
    }*/

    public void createDriverTable() {
        try {
            String[] columnNames = {"Driver ID", "First Name", "Last Name", "Date of Birth", "Driving Licence", "First Address", "Second Address", "Post Code", "Speed of Zone MPH", "Driver Speed MPH", "Difference MPH", "Fine Amount £"};
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
                if (column == 0 | column == 8 | column == 9 | column == 10 | column == 11) {
                    String stringToInt = arrList.get(i);
                    rowData[row][column] = String.valueOf(Integer.parseInt(stringToInt));
                    System.out.println("postion " + arrList.get(i) + "is an Int");
                    column++;
                } else {
                    rowData[row][column] = arrList.get(i);
                    column++;
                }
            }

            //https://docs.oracle.com/javase/tutorial/uiswing/components/table.html#sorting
            driverTable = new JTable(rowData, columnNames);
            driverTable.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(driverTable.getModel());
            driverTable.setRowSorter(sorter);

            driverTable.getSelectionModel().addListSelectionListener(
                    new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            int viewRow = driverTable.getSelectedRow();
                            int viewCol = driverTable.getSelectedColumn();
                            if (viewRow < 0 && viewCol < 0) {
                                txtStatus.setText("");
                            } else {
                                //Check to see if this can be used for anything else, if not remove it.
                                int modelRow = driverTable.convertRowIndexToModel(viewRow);
                                txtStatus.setText(
                                        String.format("Selected Row in view: %d. " + "Selected Column in view: %d.", viewRow, viewCol));
                            }
                        }
                    }
            );
            driverTable.putClientProperty("terminateEditOnFocusLost", true);
            //saveDriverData();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frmSearchDriver, "Something went wrong, Please check the datastore");
        }
    }

    public void setScrollPane(Component driverTable) {
        driverScrollPane = new JScrollPane(driverTable);
        driverScrollPane.setBounds(0, 0, 1005, 200);
        pnlSearchDriver.add(driverScrollPane);
    }

    class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            driverTable.setRowSelectionInterval(Integer.parseInt(txtDriverID.getText()) - 1,
                    Integer.parseInt(txtDriverID.getText()) - 1);
            driverScrollPane.getVerticalScrollBar().setValue(Integer.parseInt(txtDriverID.getText()) * 16);
            //Throw execption if the ID does not exist.

        }
    }

    class DriverRemoveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmSearchDriver.setVisible(false);
        }
    }


    class TopFiveOccurrenceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            ArrayList list = new ArrayList();
            list.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
            sorter.setSortKeys(list);
            sorter.sort();
        }
    }

    class TopFiveFinesHandler implements ActionListener {
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




