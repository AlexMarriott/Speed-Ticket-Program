package dvla.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1> DatabaseWriter</h1>
 * The DatabaseWriter is the writing to database class for the Drivers and Vehicle class's. The class saves new driver entries, vehicle entries and driver and vehicleID's
 * The class takes parameters from the Driver and Vehicle classes to write a new driver or vehicle to the Drivers.txt or the vehicle.txt along with the IDs for both.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class DatabaseWriter {

    /**
     * Declares an driverID variable as a int primitive
     * The DriverId is used to Identity the driver and is used when writing to file .
     */
    private int driverID;

    /**
     * Declares an vehicleID variable as a int primitive .
     * The vehicleID is used to Identity the vehicle and is used when writing to file .
     */
    private int vehicleID;

    /**
     * Declares a BufferedWriter called vehicleFile which will be the Vehicle.txt .
     */
    private BufferedWriter vehicleFile;

    /**
     * Declares a BufferedWriter called driverFile which will be the Drivers.txt .
     */
    private BufferedWriter driverFile;

    /**
     * Declares two PrintWriters called pwDriverID and pwVehicleID which will be the DriverID.txt and Vehicle.txt .
     */
    private PrintWriter pwDriverID, pwVehicleID;

    /**
     * Declares two Files called driverIDFile and vehicleIDFile which will be the DriverID.txt and Vehicle.txt but for reading in counted lines
     * to work out which ID is to be used next.
     */
    private File driverIDFile, vehicleIDFile;

    /**
     * Declares two Files called checkDriverFile, checkVehicleFile
     * This are used to check that the river and vehicle file exist.
     */
    private File checkDriverFile, checkVehicleFile;

    /**
     * Declares a Scanner called readInData for reading in the information from the txt files.
     */
    private Scanner readInData;

    /**
     * Declares two booleans driverFileExists and vehicleFileExists called  for checking if the driver and  vehicle text files are empty and if they exist.
     */
    private boolean driverFileExists, vehicleFileExists;

    /**
     * Declares two booleans driverFileExists and vehicleFileExists called  for checking if the driver and  vehicle text files are empty and if they exist.
     */
    private PrintWriter accountLoginFile;

    /**
     * Declares a List named loginArray.
     * All the data in the text file is read into the loginArray and then used to compare with the users inputed login.
     */
    private List<String> loginArray;

    /**
     * saveDrivers takes the driverInfo array which is passed to it along with the driverID. These are then written to the Drivers.txt file.
     * The saveDrivers method get passed the driverInfo String Array from the Driver Object, calls the setNextDriverID and setDriverID methods
     * and writes the driverInfo to the Drivers.txt file.
     *
     * @param driverInfo all of the combined drivers information.
     * @throws IOException Drivers.txt will is created if it doesn't exist via this method.
     */
    public void saveDrivers(String[] driverInfo) throws IOException {
        driverFile = new BufferedWriter(new FileWriter("Drivers.txt", true));
        //Get the next driver ID and writes it to the file.
        setNextDriverID();
        setDriverID();
        driverFile.write(Integer.toString(driverID));

        //for loop to loop through the array and save the information to the txt.
        for (String aDriverInfo : driverInfo) {
            driverFile.write("\n" + aDriverInfo);
        }
        driverFile.write("\n");
        driverFile.flush();
        driverFile.close();
    }

    /**
     * saveVehicle takes the vehicleInfo array which is passed to it along with the VehicleID. These are then written to the Vehicle.txt file.
     * The saveVehicle method get passed the vehicleInfo String Array from the Vehicle Object, calls the setNextVehicleID and setVehicleID methods
     * and writes the vehicleInfo to the Vehicle.txt file.
     *
     * @param vehicleInfo all of the combined vehicles information.
     * @throws IOException Vehicle.txt will is created if it doesn't exist via this method.
     */
    public void saveVehicle(String[] vehicleInfo) throws IOException {
        vehicleFile = new BufferedWriter(new FileWriter("Vehicle.txt", true));
        //Get the next vehicle ID and writes it to the file.
        setNextVehicleID();
        setVehicleID();
        vehicleFile.write(Integer.toString(vehicleID));

        //for loop to loop through the array and save the information to the txt.
        for (String aVehicleInfo : vehicleInfo) {
            vehicleFile.write("\n" + aVehicleInfo);
        }
        vehicleFile.write("\n");

        vehicleFile.flush();
        vehicleFile.close();
    }

    /**
     * Gets the next vehicle ID by scanning in the data from the VehicleID.txt and counting each line to give us the next ID
     * The setNextVehicleID method scans in the VehicleID.txt, and starts a while loop to incremental through each line until there are no more lines in the file.
     * if the Vehicle Id is 0 then it is incremented by one.
     *
     * @throws FileNotFoundException VehicleID.txt will is created if it doesn't exist via this method.
     */
    private void setNextVehicleID() throws FileNotFoundException {
        vehicleIDFile = new File("VehicleID.txt");
        readInData = new Scanner(vehicleIDFile);
        if (vehicleID <= 0) {
            vehicleID++;
        }
        while (readInData.hasNextLine() && (readInData.nextLine() != null)) {
            vehicleID++;
        }
    }

    /**
     * setVehicleID creates the VehicleID.txt file if it doesn't already exist and writes the new vehicle ID to it.
     *
     * @throws IOException VehicleID.txt will is created if it doesn't exist via this method.
     */
    private void setVehicleID() throws IOException {
        pwVehicleID = new PrintWriter(new BufferedWriter(new FileWriter("VehicleID.txt", true)));
        pwVehicleID.println("ID " + vehicleID);
        pwVehicleID.flush();
        pwVehicleID.close();
    }

    /**
     * Gets the next Driver ID by scanning in the data from the DriversID.txt and counting each line to give us the next ID
     * The setNextDriverID method scans in the DriversID.txt, and starts a while loop to incremental through each line until there are no more lines in the file.
     * if the Driver Id is 0 then it is incremented by one.
     *
     * @throws FileNotFoundException DriversID.txt will is created if it doesn't exist via this method.
     */
    private void setNextDriverID() throws FileNotFoundException {
        driverIDFile = new File("DriversID.txt");
        readInData = new Scanner(driverIDFile);
        if (driverID <= 0) {
            driverID++;
        }
        while (readInData.hasNextLine() && (readInData.nextLine() != null)) {
            driverID++;
        }
    }

    /**
     * setDriverID creates the DriversID.txt file if it doesn't already exist and writes the new Drivers ID to it.
     */
    private void setDriverID() {
        try {
            pwDriverID = new PrintWriter(new BufferedWriter(new FileWriter("DriversID.txt", true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pwDriverID.println("ID " + driverID);
        pwDriverID.flush();
        pwDriverID.close();
    }

    /**
     * checkVehicleTxt is a method which reads in the data from the Vehicle.txt file and checks to see if its exists and has any data inside.
     *
     * @throws FileNotFoundException if file doesn't exist then a false value will be  returned via vehicleFileExists
     */
    public void checkVehicleTxt() throws FileNotFoundException {
        checkVehicleFile = new File("Vehicle.txt");
        readInData = new Scanner(checkVehicleFile);
        if (!checkVehicleFile.exists() || !readInData.hasNextLine()) {
            vehicleFileExists = false;
        } else if (checkVehicleFile.exists() && readInData.hasNextLine()) {
            vehicleFileExists = true;
        } else {
            System.out.println("Something has gone wrong with the dataStore, Please check the DatabaseWriter and the Texts file to see whats happened");
            vehicleFileExists = false;
        }
    }

    /**
     * getCheckVehicleTxt returns the vehicleFileExist.
     *
     * @return vehicleFileExists
     */
    public boolean getCheckVehicleTxt() {
        return vehicleFileExists;
    }


    /**
     * checkDriverTxt is a method which reads in the data from the Drivers.txt file and checks to see if its exists and has any data inside.
     *
     * @throws FileNotFoundException if file doesn't exist then a false value will be  returned via driverFileExists
     */
    public void checkDriverTxt() throws FileNotFoundException {
        checkDriverFile = new File("Drivers.txt");
        readInData = new Scanner(checkDriverFile);
        if (!checkDriverFile.exists() || !readInData.hasNextLine()) {
            driverFileExists = false;
        } else if (checkDriverFile.exists() && readInData.hasNextLine()) {
            driverFileExists = true;
        } else {
            System.out.println("Something has gone wrong with the dataStore, Please check the DatabaseWriter and the Texts file to see whats happened");
            driverFileExists = false;
        }
    }

    /**
     * getCheckDriverTxt returns the driverFileExists.
     *
     * @return driverFileExists
     */
    public boolean getCheckDriverTxt() {
        return driverFileExists;
    }

    /**
     * saveNewUser is a method which gets passed the newAccount details from AddAccountGUI and write the new login to the login.txt.
     *
     * @param newLogin new user account with password is passed through to be written
     * @throws IOException If the login.txt does not exist then it will be created.
     */
    public void saveNewUser(String newLogin) throws IOException {

        accountLoginFile = new PrintWriter(new BufferedWriter(new FileWriter("Login.txt", true)));
        accountLoginFile.println(newLogin);
        accountLoginFile.flush();
        accountLoginFile.close();

    }

    /**
     * getLoginData creates an array from reading in data from the Login.txt file.
     * This sets the loginArray and returns it so the UserLoginGUI can use it to compares the login details.
     *
     * @return loginArray
     * @throws FileNotFoundException The File will be created.
     */
    public List<String> getLoginData() throws FileNotFoundException {
        File file = new File("Login.txt");

        Scanner readIn = new Scanner(file);
        loginArray = new ArrayList<>();
        while (readIn.hasNextLine()) {
            loginArray.add(readIn.nextLine());
        }
        readIn.close();
        return loginArray;
    }

    /**
     * This method counts the rows and columns from the Jtable and writes each line back into the text file.
     * writeToVehicleFile has two for loops which iterate through the Jtable and write each cell from the Jtable back into the text file when changes are made in the table.
     * such as the removal of a Driver.
     * This method has to stay in the SearchDriverGUI to grab the
     *
     * @param driverTableRowCount    driverTableRowCount is the count for all the rows in the driver table
     * @param driverTableColumnCount driverTableColumnCount is the count for all the columns in the driver table
     * @param rowData                rowData is all the data from the driver table ready to be written to file
     */
    public void writeToFile(int driverTableRowCount, int driverTableColumnCount, String[][] rowData) {
        try {
            FileWriter writeToDataStore = new FileWriter("Drivers.txt");
            for (int i = 0; i < driverTableRowCount; i++) {
                for (int j = 0; j < driverTableColumnCount; j++) {
                    writeToDataStore.write(rowData[i][j].toUpperCase() + "\n");
                }
            }
            writeToDataStore.flush();
            writeToDataStore.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This method counts the rows and columns from the Jtable and writes each line back into the text file.
     * writeToVehicleFile has two for loops which iterate through the Jtable and write each cell from the Jtable back into the text file when changes are made in the table.
     * such as the removal of a Vehicle.
     *
     * @param vehicleTableRowCount    vehicleTableRowCount is the count for all the rows in the vehicle table
     * @param vehicleTableColumnCount vehicleTableColumnCount is the count for all the columns in the vehicle table
     * @param rowData                 rowData rowData is all the data from the vehicle table ready to be written to file
     */
    public void writeToVehicleFile(int vehicleTableRowCount, int vehicleTableColumnCount, String[][] rowData) {
        try {
            FileWriter writeToDataStore = new FileWriter("Vehicle.txt");
            for (int i = 0; i < vehicleTableRowCount; i++) {
                for (int j = 0; j < vehicleTableColumnCount; j++) {
                    writeToDataStore.write(rowData[i][j].toUpperCase() + "\n");
                }
            }
            writeToDataStore.flush();
            writeToDataStore.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
