import java.io.IOException;

/**
 * Created by Alex on 08/02/2017.
 */
public class AlexTestEmployeeFile {

    public static void main(String[] args) throws IOException {
        AlexEmployeeFile AEF = new AlexEmployeeFile();

        //This get the firstName of the employee
        AEF.setFirstName();
        System.out.println(AEF.getFirstName());

        //This get the lastName of the employee
        AEF.setlastName();
        System.out.println(AEF.getlastName());

        //This get the age of the employee
        AEF.setAge();
        System.out.println(AEF.getAge());

        //This get the firstAddressLine of the employee
        AEF.setfirstAddressLine();
        System.out.println(AEF.getfirstAddressLine());

        //This get the secondAddressLine of the employee
        AEF.setsecondAddressLine();
        System.out.println(AEF.getsecondAddressLine());

        //This get the jobTitle of the employee
        AEF.setjobTitle();
        System.out.println(AEF.getjobTitle());

        //This get the salary of the employee
        AEF.setSalary();
        System.out.println(AEF.getSalary());

        //This get the ssn of the employee
        AEF.setSSN();
        System.out.println(AEF.getSSN());
        AEF.createFile().close();
    }

}
