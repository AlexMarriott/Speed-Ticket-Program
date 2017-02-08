public class EmployeeTest {

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee("Anne", 33000);
        Employee emp3 = new Employee("Bob");
        String swag = "alex";
        System.out.println(emp1.getFirstName());
        System.out.println(emp2.getFirstName()+" "+
                emp2.getMonthlyPay());
        System.out.println(emp3.getFirstName()+" "+
                emp3.getMonthlyPay());

        emp3.setSalary(25100);

        System.out.println(emp1.getFirstName()+" "+
                emp1.getMonthlyPay());
        System.out.println(emp2.getFirstName()+" "+
                emp2.getMonthlyPay());
        System.out.println(emp3.getFirstName()+" "+
                emp3.getMonthlyPay());
    }
}

