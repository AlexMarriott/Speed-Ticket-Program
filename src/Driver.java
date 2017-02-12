import java.util.Scanner;

/**
 * Created by alex on 11/02/2017.
 */
public class Driver {
    SpeedingTicket driverWrite = new SpeedingTicket();
    private String fullName;
    private String firstName;
    private String lastName;
    private int Age;
    private String firstAddress;
    private String secondAddress;
    private String postCode;
    private String fullAddressAndPostcode;
    private String jobTitle;
    private double yearlyIncome;
    private String drivingLicence;
    private Scanner driverDetails = new Scanner(System.in);

    public void setFullName (SpeedingTicket driverData){
        System.out.println("Please enter the Drivers first name. ");
        this.firstName = driverDetails.nextLine();
        System.out.println("Please enter the Drivers last name. ");
        this.lastName = driverDetails.nextLine();
        this.fullName = this.firstName + this.firstName;
    }
    public void setDriversAge (SpeedingTicket driverData){
        System.out.println("Please enter the Drivers Age ");
        this.Age = driverDetails.nextInt();
    }
    public void setAddress (SpeedingTicket driverData){
        System.out.println("Please enter the Drivers first line of Address. ");
        this.firstAddress = driverDetails.nextLine();
        System.out.println("Please enter Drivers second line of Address. ");
        this.secondAddress = driverDetails.nextLine();
        System.out.println("Please enter Drivers postCode. ");
        this.postCode = driverDetails.nextLine();
        this.fullAddressAndPostcode = this.firstAddress + this.secondAddress + this.postCode;
    }
    public void setJobTitle (SpeedingTicket driverData){
        System.out.println("Please enter the Drivers job title. ");
        this.jobTitle = driverDetails.nextLine();
    }
    public void setyearlyIncome (SpeedingTicket driverData){
        System.out.println("Please enter the Drivers yearly income. ");
        this.yearlyIncome = driverDetails.nextDouble();

    }
    public void setDrivingLicence (SpeedingTicket driverData){
        System.out.println("Please enter the Drivers driving licence number. ");
        this.drivingLicence = driverDetails.nextLine();

        /*It consists of the first 5 letters of your surname, followed by your date of birth in coded form,
        the initials of your forename(s) and a few characters to distinguish you from anyone else with the
        same details as you.
        Example Stephen Martin Pearson, and you were born on 27th August 1971: PEARS 708271 SM9BN.
        Extra three characters at the end if the code is identically to someone else.
        */
    }

    }

