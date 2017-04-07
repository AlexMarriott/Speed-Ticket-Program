package dvla.logic;

import java.io.IOException;

/**
 * <h1> Vehicle</h1>
 * The Vehicle Objects lets AddDriver class to pass through the Vehicle information along with their speed and the road type.
 * All Vehicle information is passed to the Database Writer class to be written to the Vehicle.txt file.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class Vehicle {

    /**
     * Declares a String named vehicleModel.
     */
    private String vehicleModel;

    /**
     * Declares a String named vehicleMake.
     */
    private String vehicleMake;

    /**
     * Declares a String named vehicleNumPlate.
     */
    private String vehicleNumPlate;

    /**
     * Declares a String named vehicleYear.
     */
    private String vehicleYear;

    /**
     * Declares a String named carOwner.
     */
    private String carOwner;

    /**
     * Declares a String named drivingLicenceNum.
     */
    private String drivingLicenceNum;

    /**
     * Declares a String named firstAddressLine.
     */
    private String firstAddressLine;

    /**
     * Declares a String named secondAddressLine.
     */
    private String secondAddressLine;

    /**
     * Declares a String named postCode.
     */
    private String postCode;

    /**
     * Declares an Object of DatabaseWriter and  names it  writingDataToDatabase.
     */
    private DatabaseWriter writingDataToDatabase;

    /**
     * Declares a String[] named vehicleInfo. The VehicleInfo variable is passed through to DatabaseWriter.
     * though its being flagged up as not used, it really is. Suppressing the warning.
     */
    @SuppressWarnings("unused")
    private String[] vehicleInfo;


    /**
     * The DriverMethod allows basic information about the driver be passed to it, so its can set all the above variables with the most current drivers information.
     *
     * @param vehicleModel      The Model of the Car
     * @param vehicleMake       The Make of the Car
     * @param vehicleNumPlate   The Number Plate of the Car
     * @param vehicleYear       The Year the car was made
     * @param carOwner          The Owner of the Car
     * @param drivingLicenceNum Driving Licence Number of the Driver
     * @param firstAddressLine  First line of Address of the Driver
     * @param secondAddressLine Second line of Address for the Driver
     * @param postCode          Postcode of the Driver
     */
    public Vehicle(String vehicleModel, String vehicleMake, String vehicleNumPlate, String vehicleYear, String carOwner, String drivingLicenceNum, String firstAddressLine, String secondAddressLine, String postCode) {
        this.vehicleModel = vehicleModel;
        this.vehicleMake = vehicleMake;
        this.vehicleNumPlate = vehicleNumPlate;
        this.vehicleYear = vehicleYear;
        this.carOwner = carOwner;
        this.drivingLicenceNum = drivingLicenceNum;
        this.firstAddressLine = firstAddressLine;
        this.secondAddressLine = secondAddressLine;
        this.postCode = postCode;
    }

    /**
     * This method sets the VehicleInfo array with all the vehicles information and returns it ready to be passed through to Database writer.
     *
     * @return vehicleInfo
     */
    private String[] setVehicleInfo() {
        String[] vehicleInfo = {vehicleModel, vehicleMake,
                vehicleNumPlate, vehicleYear,
                carOwner, drivingLicenceNum,
                firstAddressLine, secondAddressLine, postCode};

        return vehicleInfo;
    }

    /**
     * This method initialises the writingDataToDatabase object and passes through the vehicleInfo array to the saveDrives method in DatabaseWriter.
     */
    public void getVehicleInfo() {
        writingDataToDatabase = new DatabaseWriter();
        try {
            writingDataToDatabase.saveVehicle(setVehicleInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
