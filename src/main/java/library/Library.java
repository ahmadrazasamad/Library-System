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
    
    public void removeBook(Book book) { // association
        books.remove(book);
    } 

    public void hireLibrarian(Librarian librarian) { // association
        librarians.add(librarian);
    }
    
    public void fireLibrarian(Librarian librarian) { // association
        librarians.remove(librarian);
    }

    public void printDetails() {
        for (Book b : books) {
            System.out.println("•) " + b.getTitle() + " - by " + b.getAuthor());
        }
        System.out.println();
    }
}