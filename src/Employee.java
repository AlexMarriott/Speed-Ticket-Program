import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Alex on 08/02/2017.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private int Age;
    private String firstAddressLine;
    private String secondAddressLine;
    private String jobTitle;
    private double Salary;
    private String SSN;

    public Employee(){};


    public void setFirstName (DataStorage employeeToData){
        System.out.println("Please enter the employees first name. ");
        this.firstName = employeeToData.userInput().nextLine();
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setAge (DataStorage employeeToData) {
        System.out.println("Please enter the employees Age. ");
        this.Age = employeeToData.userInput().nextInt();
    }
    public int getAge() {
        return this.Age;
    }
    public void setlastName (DataStorage employeeToData){
        System.out.println("Please enter the employees Last name. ");
        this.lastName = employeeToData.userInput().nextLine();
    }
    public String getlastName(){
        return this.lastName;
    }

    public void setfirstAddressLine (DataStorage employeeToData){
        System.out.println("Please enter the employees First Line of Address. ");
        this.firstAddressLine = employeeToData.userInput().nextLine();
    }
    public String getfirstAddressLine() {
        return this.firstAddressLine;
    }

    public void setsecondAddressLine(DataStorage employeeToData){
        System.out.println("Please enter the employees Second Line of Address. ");
        this.secondAddressLine = employeeToData.userInput().nextLine();
    }
    public String getsecondAddressLine() {
        return this.secondAddressLine;
    }

    public void setjobTitle(DataStorage employeeToData){
        System.out.println("Please enter the employees JobTitle. ");
        this.jobTitle = employeeToData.userInput().nextLine();
    }
    public String getjobTitle() {
        return this.jobTitle;
    }

    public void setSalary(DataStorage employeeToData){
        System.out.println("Please enter the employees Salary. ");
        this.Salary = employeeToData.userInput().nextDouble();
    }
    public double getSalary() {
        return this.Salary;
    }

    public void setSSN(DataStorage employeeToData){
        System.out.println("Please enter the employees SSN. ");
        this.SSN = employeeToData.userInput().nextLine();
    }
    public String getSSN() {
        return this.SSN;
    }


}
