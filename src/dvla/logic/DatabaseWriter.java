package dvla.logic;

import java.io.*;
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
     * Declares an driverID variable as a int primitive .
     */
    private int driverID;

    /**
     * Declares an vehicleID variable as a int primitive .
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
    PrintWriter pwDriverID, pwVehicleID;

    /**
     * Declares two Files called driverIDFile and vehicleIDFile which will be the DriverID.txt and Vehicle.txt but for reading in counted lines. .
     */
    File driverIDFile, vehicleIDFile;

    /**
     * Declares two Files called checkDriverFile, checkVehicleFile.
     */
    File checkDriverFile, checkVehicleFile;

    /**
     * Declares a Scanner called readInData for reading in the information from the txt files.
     */
    Scanner readInData;

    /**
     * Declares two booleans driverFileExists and vehicleFileExists called  for checking if the driver and  vehicle text files are empty and if they exist.
     */
    private boolean driverFileExists, vehicleFileExists;


    /**
     * saveDrivers takes the driverInfo array which is passed to it along with the driverID. These are then written to the Drivers.txt file.
     * The saveDrivers method get passed the driverInfo String Array from the Driver Object, calls the getNextDriverID and setDriverID methods
     * and writes the driverInfo to the Drivers.txt file.
     *
     * @param driverInfo all of the combined drivers information.
     */
    public void saveDrivers(String[] driverInfo) throws IOException {
        driverFile = new BufferedWriter(new FileWriter("Drivers.txt", true));
        //Get the next driver ID and writes it to the file.
        getNextDriverID();
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
     * The saveVehicle method get passed the vehicleInfo String Array from the Vehicle Object, calls the getNextVehicleID and setVehicleID methods
     * and writes the vehicleInfo to the Vehicle.txt file.
     *
     * @param vehicleInfo all of the combined vehicles information.
     */
    public void saveVehicle(String[] vehicleInfo) throws IOException {
        vehicleFile = new BufferedWriter(new FileWriter("Vehicle.txt", true));
        //Get the next vehicle ID and writes it to the file.
        getNextVehicleID();
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
     * The getNextVehicleID method scans in the VehicleID.txt, and starts a while loop to incremental through each line until there are no more lines in the file.
     * if the Vehicle Id is 0 then it is incremented by one.
     */
    private int getNextVehicleID() throws FileNotFoundException {
        vehicleIDFile = new File("VehicleID.txt");
        readInData = new Scanner(vehicleIDFile);
        if (vehicleID <= 0) {
            vehicleID++;
        }
        while (readInData.hasNextLine() && (readInData.nextLine() != null)) {
            vehicleID++;
        }
        return vehicleID;
    }

    /**
     * setVehicleID creates the VehicleID.txt file if it doesn't already exist and writes the new vehicle ID to it.
     */
    private void setVehicleID() throws IOException {
        pwVehicleID = new PrintWriter(new BufferedWriter(new FileWriter("VehicleID.txt", true)));
        pwVehicleID.println("ID " + vehicleID);
        pwVehicleID.flush();
        pwVehicleID.close();
    }

    /**
     * Gets the next Driver ID by scanning in the data from the DriversID.txt and counting each line to give us the next ID
     * The getNextDriverID method scans in the DriversID.txt, and starts a while loop to incremental through each line until there are no more lines in the file.
     * if the Driver Id is 0 then it is incremented by one.
     */
    private int getNextDriverID() throws FileNotFoundException {
        driverIDFile = new File("DriversID.txt");
        readInData = new Scanner(driverIDFile);
        if (driverID <= 0) {
            driverID++;
        }
        while (readInData.hasNextLine() && (readInData.nextLine() != null)) {
            driverID++;
        }
        return driverID;
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

    public boolean getCheckVehicleTxt() throws FileNotFoundException {
        return vehicleFileExists;
    }


    public boolean checkDriverTxt() throws FileNotFoundException {
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
        return driverFileExists;
    }

    public boolean getCheckDriverTxt() throws FileNotFoundException {
        return driverFileExists;
    }
}
