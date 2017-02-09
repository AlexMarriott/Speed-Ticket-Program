import java.io.IOException;

/**
 * Created by Alex on 08/02/2017.
 */
public class EmployeeManager {

    public static void main(String[] args) throws IOException {
        EmployeeHandler empManToEmpHan = new EmployeeHandler();
        DataStorage empManToData = new DataStorage();

        //This get the firstName of the employee
        empManToEmpHan.setFirstName();
        //This get the lastName of the employee
        empManToEmpHan.setlastName();
        //This get the age of the employee
        empManToEmpHan.setAge();
        //This get the firstAddressLine of the employee
        empManToEmpHan.setfirstAddressLine();
        //This get the secondAddressLine of the employee
        empManToEmpHan.setsecondAddressLine();
        //This get the jobTitle of the employee
        empManToEmpHan.setjobTitle();
        //This get the salary of the employee
        empManToEmpHan.setSalary();
        //This get the ssn of the employee
        empManToEmpHan.setSSN();
        empManToData.saveEmployee();

       // management.readArray();
    }

}
