package library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String name, address;
    private List<Book> books; // aggregation
    private List<Librarian> librarians;// aggregation

    public Library(String name, String address) { // constructor
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
        this.librarians = new ArrayList<>();
    }

//    Getters and Setter for ensuring encapsulation
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addBook(Book book) { // association
        books.add(book);
    }

    public void addLibrarian(Librarian librarian) { // association
        librarians.add(librarian);
    }

    public void printDetails() {
        System.out.println(name + " at " + address + " has the following books: ");
        for (Book b : books) {
            System.out.println("•) " + b.getTitle() + " - by " + b.getAuthor());
        }
        System.out.println();
    }
}
