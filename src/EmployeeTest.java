public class EmployeeTest {

    public static void main(String[] args) {
        OldTestEmployee emp1 = new OldTestEmployee();
        OldTestEmployee emp2 = new OldTestEmployee("Anne", 33000);
        OldTestEmployee emp3 = new OldTestEmployee("Bob");
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

