package library;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name, memberId;
    private List<Book> borrowedBooks; // aggregation is a stronger association

    public Member(String name, String memberId) { // constructor
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

//    Getters and Setter for ensuring encapsulation
    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void borrowBook(Book book) { // Association(member borrows book)
        borrowedBooks.add(book);
    }

    public void printBorrowedBooks() {
        System.out.println("Member: " + name + " has borrowed the following book(s): ");
        for (Book b : borrowedBooks) {
            System.out.println("•) " + b.getTitle() + " - by " + b.getAuthor());
        }
    }
}
