import java.io.FileWriter;
import java.io.IOException;

public class EmployeePayroll {

    static String companyName = "ABC Technologies";
    final static double TAX_RATE = 0.10;

    static class SalaryDetails {
        double basic;
        double allowance;
        double deduction;

        SalaryDetails(double basic) {
            this.basic = basic;
            allowance = basic * 0.20;
            deduction = basic * TAX_RATE;
        }

        double netSalary() {
            return basic + allowance - deduction;
        }
    }

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Please provide: Name ID BasicSalary");
            return;
        }

        String name = args[0];
        String id = args[1];
        double basic = Double.parseDouble(args[2]);

        SalaryDetails salary = new SalaryDetails(basic);

        System.out.println("--- Employee Payroll ---");
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Basic Salary: Rs. " + basic);
        System.out.println("Allowance: Rs. " + salary.allowance);
        System.out.println("Deduction: Rs. " + salary.deduction);
        System.out.println("Net Salary: Rs. " + salary.netSalary());

        try {
            FileWriter file = new FileWriter("payroll.txt");

            file.write("Employee Payroll\n");
            file.write("Company: " + companyName + "\n");
            file.write("Name: " + name + "\n");
            file.write("Employee ID: " + id + "\n");
            file.write("Net Salary: Rs. " + salary.netSalary());

            file.close();

            System.out.println("Payroll saved in payroll.txt");

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}