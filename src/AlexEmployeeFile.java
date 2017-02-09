import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alex on 08/02/2017.
 */
public class AlexEmployeeFile {
    private String firstName;
    private String lastName;
    private int Age;
    private String firstAddressLine;
    private String secondAddressLine;
    private String jobTitle;
    private double Salary;
    private String SSN;
    private ArrayList emp_array = new ArrayList();

    public AlexEmployeeFile(){};
    //Method Scanner


    public void setFirstName (){
        System.out.println("Please enter the employees first name. ");
        this.firstName = userInput().nextLine();
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setAge () {
        System.out.println("Please enter the employees Age. ");
        this.Age = userInput().nextInt();
    }
    public int getAge() {
        return this.Age;
    }

    public void setlastName (){
        System.out.println("Please enter the employees Last name. ");
        this.lastName = userInput().nextLine();
    }
    public String getlastName(){
        return this.lastName;
    }

    public void setfirstAddressLine (){
        System.out.println("Please enter the employees First Line of Address. ");
        this.firstAddressLine = userInput().nextLine();
    }
    public String getfirstAddressLine() {
        return this.firstAddressLine;
    }

    public void setsecondAddressLine(){
        System.out.println("Please enter the employees Second Line of Address. ");
        this.secondAddressLine = userInput().nextLine();
    }
    public String getsecondAddressLine() {
        return this.secondAddressLine;
    }

    public void setjobTitle(){
        System.out.println("Please enter the employees JobTitle. ");
        this.jobTitle = userInput().nextLine();
    }
    public String getjobTitle() {
        return this.jobTitle;
    }

    public void setSalary(){
        System.out.println("Please enter the employees Salary. ");
        this.Salary = userInput().nextDouble();
    }
    public double getSalary() {
        return this.Salary;
    }

    public void setSSN(){
        System.out.println("Please enter the employees SSN. ");
        this.SSN = userInput().nextLine();
    }
    public String getSSN() {
        return this.SSN;
    }
}
