import java.util.Scanner;

class Bill {

    double units;
    double energyCharge;
    double fixedCharge;
    double tax;
    double total;

    Bill(double units, double energyCharge, double fixedCharge, double tax) {
        this.units = units;
        this.energyCharge = energyCharge;
        this.fixedCharge = fixedCharge;
        this.tax = tax;
        total = energyCharge + fixedCharge + tax;
    }

    void showBill() {
        System.out.println("\n--- Electricity Bill ---");
        System.out.println("Units Used: " + units);
        System.out.println("Energy Charge: Rs. " + energyCharge);
        System.out.println("Fixed Charge: Rs. " + fixedCharge);
        System.out.println("Tax: Rs. " + tax);
        System.out.println("Total Bill: Rs. " + total);
    }
}

public class ElectricityBill {

    static double calculateEnergyCharge(double units) {

        if (units <= 100)
            return units * 2;

        if (units <= 200)
            return (100 * 2) + (units - 100) * 3;

        return (100 * 2) + (100 * 3) + (units - 200) * 5;
    }

    static Bill calculateBill(double units) {

        double energy = calculateEnergyCharge(units);
        double fixed = 50;
        double tax = energy * 0.05;

        return new Bill(units, energy, fixed, tax);
    }

    static void countDown(int n) {

        if (n == 0)
            return;

        System.out.print(n + " ");
        countDown(n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter units consumed: ");
        double units = sc.nextDouble();

        if (units < 0) {
            System.out.println("Units cannot be negative.");
        } else {

            Bill bill = calculateBill(units);
            bill.showBill();

            System.out.print("Recursion example: ");
            countDown(5);
        }

        sc.close();
    }
}