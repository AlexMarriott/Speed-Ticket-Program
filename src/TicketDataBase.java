import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 12/02/2017.
 */
/*public class TicketDataBase {
    public void saveEmployee(Driver DriverData) throws IOException {
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("Employee.txt", true)));
        outfile.println("Drivers First name: " + DriverData.getFirstName());
        outfile.println("Employee Last name:  " + DriverData.getlastName());
        outfile.println("Employee First Line Of Address:  " + dataToEmployee.getfirstAddressLine());
        outfile.println("Employee Second Line Of Address:  " + dataToEmployee.getsecondAddressLine());
        outfile.println("Employees Salary:  " + dataToEmployee.getSalary());
        outfile.println("Employee SSN:  " + dataToEmployee.getSSN() + "\n[NEW EMPLOYEE] \n");

        outfile.flush();
        outfile.close();
    }
    public void readFile() throws FileNotFoundException {
        File empFile = new File("Employee.txt");
        Scanner fileScan = new Scanner(empFile);
        while (fileScan.hasNext()) {
            String readFile = fileScan.nextLine();
            System.out.println(readFile);
        }

    }
    public ArrayList setArray() throws FileNotFoundException {
        File empFile = new File("Employee.txt");
        Scanner fileScan = new Scanner(empFile);
        int i = 0;/
        while (fileScan.hasNext()) {
            empArray.add(fileScan.nextLine());
        }
        return empArray;
    }
    public ArrayList getArray() {
        return this.empArray;
    }
    public void arrayRead(){
        int i = 0;
        while(i < getArray().size()){
            System.out.println(getArray().get(i));
            i++;
        }

    }

}

*/