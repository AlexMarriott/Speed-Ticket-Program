package dvla.logic;

import java.io.IOException;

/**
 * Created by alex on 02/04/2017.
 */
public class Vehicle {

    private String vehicleModel;
    private String vehicleMake;
    private String vehicleNumPlate;
    private String vehicleYear;
    private String carOwner;
    private String drivingLicenceNum;
    private String firstAddressLine;
    private String secondAddressLine;
    private String postCode;
    private DatabaseWriter writingDataToDatabase;
    private String[] vehicleInfo;


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

    public String[] setVehicleInfo() {
        String[] vehicleInfo = {vehicleModel, vehicleMake,
                vehicleNumPlate, vehicleYear,
                carOwner, drivingLicenceNum,
                firstAddressLine, secondAddressLine, postCode};

        return vehicleInfo;
    }

    public void getVehicleInfo() {
        writingDataToDatabase = new DatabaseWriter();
        try {
            writingDataToDatabase.saveVehicle(setVehicleInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
