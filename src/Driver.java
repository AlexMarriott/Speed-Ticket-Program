import java.util.Scanner;

/**
 * Created by alex on 11/02/2017.
 */
public class Driver {
    IssueTicket driverWrite = new IssueTicket();
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
//
    public void setFullName (IssueTicket driverData){
        this.firstName = driverDetails.nextLine();
        this.lastName = driverDetails.nextLine();
        this.fullName = this.firstName + this.firstName;
    }
    public void setDriversAge (IssueTicket driverData){
        this.Age = driverDetails.nextInt();
    }
    public void setAddress (IssueTicket driverData){
        this.firstAddress = driverDetails.nextLine();
        this.secondAddress = driverDetails.nextLine();
        this.postCode = driverDetails.nextLine();
        this.fullAddressAndPostcode = this.firstAddress + this.secondAddress + this.postCode;
    }
    public void setJobTitle (IssueTicket driverData){
        this.jobTitle = driverDetails.nextLine();
    }
    public void setyearlyIncome (IssueTicket driverData){
        this.yearlyIncome = driverDetails.nextDouble();

    }
    public void setDrivingLicence (IssueTicket driverData){
        this.drivingLicence = driverDetails.nextLine();

        /*It consists of the first 5 letters of your surname, followed by your date of birth in coded form,
        the initials of your forename(s) and a few characters to distinguish you from anyone else with the
        same details as you.
        Example Stephen Martin Pearson, and you were born on 27th August 1971: PEARS 708271 SM9BN.
        Extra three characters at the end if the code is identically to someone else.
        */
    }

    }

