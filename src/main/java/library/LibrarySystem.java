package library;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library("Cutchi Memon Library", "Cycle Market, Gari Khata , Karachi");
        
        Librarian librarian = new Librarian("Mohammad Hanif", "000");
        library.addLibrarian(librarian);
        
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
        
        library.printDetails(); // printing details of the books in the library
        
        Member mem = new Member("Sufyan Qazi", "007");
        mem.borrowBook(book1);
        mem.borrowBook(book4);
        
        mem.printBorrowedBooks();
    }
}