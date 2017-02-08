import java.util.Scanner;

public class Employee {
    private String firstName;
    private double salary;
    private String jobTitle;
    private String department;
    private String firstLineAddress;
    private String secondLineAddress;
    private String ssn;


    public Employee(){ }

    public Employee(String firstName, double salary){
        this.firstName=firstName;
        this.salary=salary;
    }

    public Employee(String firstName){
        this.firstName=firstName;
        this.salary=0;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName ){
        this.firstName=firstName;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setJobTitle(String jobTitle){
        this.jobTitle=jobTitle;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public void setFirstLineAddress(String firstLineAddress){
        this.firstLineAddress=firstLineAddress;
    }
    public void setSecondLineAddress(String secondLineAddress){
        this.secondLineAddress=secondLineAddress;
    }
    public void setSSN(String ssn){
        this.ssn=ssn;
    }
    public Scanner getUserInput(){
        Scanner userInput = new Scanner(System.in);
        return userInput;
    }

    public double getMonthlyPay(){
        return salary/12;
    }
}

