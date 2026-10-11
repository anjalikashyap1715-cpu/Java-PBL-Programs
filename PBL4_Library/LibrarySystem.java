import java.util.Scanner;

class Book {

    private String title;
    private String author;
    private boolean issued;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        issued = false;
    }

    void showBook() {
        System.out.println(title + " - " + author +
                " - " + (issued ? "Issued" : "Available"));
    }

    boolean search(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase()) ||
               author.toLowerCase().contains(keyword.toLowerCase());
    }

    void issue() {
        if (!issued) {
            issued = true;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    void returnBook() {
        if (issued) {
            issued = false;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued.");
        }
    }
}

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Book[] books = {
            new Book("Java Programming", "Herbert Schildt"),
            new Book("Python Basics", "John Smith"),
            new Book("Data Structures", "Mark Allen"),
            new Book("Computer Networks", "Andrew Tanenbaum"),
            new Book("Operating System", "Galvin")
        };

        System.out.println("--- Library Books ---");

        for (Book b : books)
            b.showBook();

        System.out.print("\nEnter title or author to search: ");
        String keyword = sc.nextLine();

        boolean found = false;

        for (Book b : books) {
            if (b.search(keyword)) {
                b.showBook();
                found = true;
            }
        }

        if (!found)
            System.out.println("Book not found.");

        System.out.print("\nEnter book title to issue: ");
        String title = sc.nextLine();

        for (Book b : books) {
            if (b.search(title)) {
                b.issue();
                found = true;
                break;
            }
        }

        System.out.print("\nEnter book title to return: ");
        title = sc.nextLine();

        for (Book b : books) {
            if (b.search(title)) {
                b.returnBook();
                break;
            }
        }

        System.out.println("\n--- Updated Library ---");

        for (Book b : books)
            b.showBook();

        sc.close();
    }
}