import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alex on 08/02/2017.
 */
public class EmployeeHandler {
    DataStorage empHanToData = new DataStorage();
    private String firstName;
    private String lastName;
    private int Age;
    private String firstAddressLine;
    private String secondAddressLine;
    private String jobTitle;
    private double Salary;
    private String SSN;
    private ArrayList emp_array = new ArrayList();

    public EmployeeHandler(){};
    //Method Scanner


    public void setFirstName (){
        System.out.println("Please enter the employees first name. ");
        this.firstName = empHanToData.userInput().nextLine();
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setAge () {
        System.out.println("Please enter the employees Age. ");
        this.Age = empHanToData.userInput().nextInt();
    }
    public int getAge() {
        return this.Age;
    }

    public void setlastName (){
        System.out.println("Please enter the employees Last name. ");
        this.lastName = empHanToData.userInput().nextLine();
    }
    public String getlastName(){
        return this.lastName;
    }

    public void setfirstAddressLine (){
        System.out.println("Please enter the employees First Line of Address. ");
        this.firstAddressLine = empHanToData.userInput().nextLine();
    }
    public String getfirstAddressLine() {
        return this.firstAddressLine;
    }

    public void setsecondAddressLine(){
        System.out.println("Please enter the employees Second Line of Address. ");
        this.secondAddressLine = empHanToData.userInput().nextLine();
    }
    public String getsecondAddressLine() {
        return this.secondAddressLine;
    }

    public void setjobTitle(){
        System.out.println("Please enter the employees JobTitle. ");
        this.jobTitle = empHanToData.userInput().nextLine();
    }
    public String getjobTitle() {
        return this.jobTitle;
    }

    public void setSalary(){
        System.out.println("Please enter the employees Salary. ");
        this.Salary = empHanToData.userInput().nextDouble();
    }
    public double getSalary() {
        return this.Salary;
    }

    public void setSSN(){
        System.out.println("Please enter the employees SSN. ");
        this.SSN = empHanToData.userInput().nextLine();
    }
    public String getSSN() {
        return this.SSN;
    }
}
