
import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    int total() {
        int sum = 0;
        for (int m : marks)
            sum += m;
        return sum;
    }

    double percentage() {
        return total() / 5.0;
    }

    int highest() {
        int h = marks[0];
        for (int m : marks)
            if (m > h) h = m;
        return h;
    }

    int lowest() {
        int l = marks[0];
        for (int m : marks)
            if (m < l) l = m;
        return l;
    }

    String grade() {
        double p = percentage();

        if (p >= 90) return "A+";
        if (p >= 80) return "A";
        if (p >= 70) return "B";
        if (p >= 60) return "C";
        if (p >= 50) return "D";
        return "F";
    }

    boolean pass() {
        for (int m : marks)
            if (m < 40) return false;
        return true;
    }

    void display() {
        System.out.println("\n--- Student Performance Report ---");
        System.out.println("Name: " + name);

        for (int i = 0; i < marks.length; i++)
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);

        System.out.println("Total: " + total());
        System.out.println("Percentage: " + percentage() + "%");
        System.out.println("Highest: " + highest());
        System.out.println("Lowest: " + lowest());
        System.out.println("Grade: " + grade());
        System.out.println("Result: " + (pass() ? "PASS" : "FAIL"));
    }
}

public class StudentPerformance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        int[] marks = new int[5];

        for (int i = 0; i < 5; i++) {
            do {
                System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();

                if (marks[i] < 0 || marks[i] > 100)
                    System.out.println("Enter marks between 0 and 100.");

            } while (marks[i] < 0 || marks[i] > 100);
        }

        Student s = new Student(name, marks);
        s.display();

        sc.close();
    }
}
