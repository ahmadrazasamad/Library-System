package library;

import java.time.LocalDate;
import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        Library library = new Library("Cutchi Memon Library", "Cycle Market, Gari Khata , Karachi");

        Librarian librarian = new Librarian("Mohammad Hanif", "000");
        library.hireLibrarian(librarian);

        Book book1 = new Book("Hello World", "Anonymous", "978-0000000000", "Computer Science");
        Book book2 = new Book("1984", "George Orwell", "978-0451524935", "Dystopian Fiction");
        Book book3 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0590353427", "Fantasy");
        Book book4 = new Book("Console.log vs Cout", "Ahmad Raza", "978-0000000007", "Computer Science");
        Book book5 = new Book("The Great Gatsby", " F. Scott Fitzgerald", "978-0743273565", "Literary Fiction");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        Scanner read = new Scanner(System.in);

        System.out.println("Hi, this is librarian " + librarian.getName() + ", please first register yourself in the library system for enjoying the fruitful benefits of the library by entereing the follwiong information:\n•) Name\n•) Student Id"); // taking details from the student for registration
        System.out.print("Enter name: ");
        String name = read.nextLine();
        System.out.print("Enter student id: ");
        String id = read.nextLine();

        Member mem = new Member(name, id); // registering

        System.out.println("Welcome to the library, our library has the following books: ");
        library.printDetails(); // printing details of the books in the library

        char option;
        do {
            System.out.print("You can borrow any of the upper given books for a maximum of 15 days, select the option 1,2,3,4 or 5 for borrowing a book: ");
            int choice = read.nextInt();
            read.nextLine();
            
            if (mem.getFine() == 0) {
                LocalDate borrowDate;
                switch (choice) {
                    case 1:
                        borrowDate = LocalDate.now();
                        mem.borrowBook(book1, borrowDate);
                        mem.printBorrowedBooks();
                        break;
                    case 2:
                        borrowDate = LocalDate.now();
                        mem.borrowBook(book2, borrowDate);
                        mem.printBorrowedBooks();
                        break;
                    case 3:
                        borrowDate = LocalDate.now();
                        mem.borrowBook(book3, borrowDate);
                        mem.printBorrowedBooks();
                        break;
                    case 4:
                        borrowDate = LocalDate.now();
                        mem.borrowBook(book4, borrowDate);
                        mem.printBorrowedBooks();
                        break;
                    case 5:
                        borrowDate = LocalDate.now();
                        mem.borrowBook(book5, borrowDate);
                        mem.printBorrowedBooks();
                        break;
                    default:
                        System.out.println("Wrong choice entered, please enter a number between 1-5");
                }
                System.out.print("Do you want to borrow any other book, press 'Y' that indicates yes and any other key that will indicate no: ");
                option = read.nextLine().toLowerCase().charAt(0);
            } else {
                System.out.println("First clear your fine fee then you will be able to borrow a book");
                return;
            }
        } while (option == 'y');

        LocalDate now;
        mem.returnBook(book2, LocalDate.now());
    }
}