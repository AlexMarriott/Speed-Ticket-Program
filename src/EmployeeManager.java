import java.io.IOException;

/**
 * Created by Alex on 08/02/2017.
 */
public class EmployeeManager {

    public static void main(String[] args) throws IOException {
        Employee employee = new Employee();
        DataStorage saveData = new DataStorage();

        //This get the firstName of the employee
        employee.setFirstName(saveData);
        //This get the lastName of the employee
        employee.setlastName(saveData);
        //This get the age of the employee
        employee.setAge(saveData);
        //This get the firstAddressLine of the employee
        employee.setfirstAddressLine(saveData);
        //This get the secondAddressLine of the employee
        employee.setsecondAddressLine(saveData);
        //This get the jobTitle of the employee
        employee.setjobTitle(saveData);
        //This get the salary of the employee
        employee.setSalary(saveData);
        //This get the ssn of the employee
        employee.setSSN(saveData);
        //Thes the Employees save information to an Employee.txt
        saveData.saveEmployee(employee);
        //Read the employee information from a text file and prints it to screen
        saveData.readFile();
        //Creates an arraylist array with all the employee inforamtion form the txt
        saveData.setArray();
        //Read from the Array set above.
        saveData.arrayRead();
        }

}
