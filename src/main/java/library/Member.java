package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name, memberId;
    private List<Book> borrowedBooks; // aggregation is a stronger association
    private List<Object[]> detailsOfBorrowedBooks; // was not asked but inculde explicitly for adding more functionalities
    private int fine; // was not asked but inculde explicitly for adding more functionalities

    public Member(String name, String memberId) { // constructor
        this.name = name;
        this.memberId = memberId;
        fine = 0;
        borrowedBooks = new ArrayList<>();
        detailsOfBorrowedBooks = new ArrayList<>();
    }

//    Getters and Setter for ensuring encapsulation
    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getFine() {
        return fine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setFine(int fine) { // for librarian, if any misbehavior or any thing bad occurs due to memeber
        this.fine = fine;
    }

    public void borrowBook(Book book, LocalDate borrowDate) { // Association(member borrows book)
        borrowedBooks.add(book);
        LocalDate dueDate = borrowDate.plusDays(15); // memeber can borrow for 15 days
        Object[] data = {book, borrowDate, dueDate};
        detailsOfBorrowedBooks.add(data);
    }

    public void returnBook(Book book, LocalDate returnDate) { // Association
        for (Object bookDetail : detailsOfBorrowedBooks) {
            Object[] data = (Object[]) bookDetail; // typecasting

            Book borrowedBook = (Book) data[0]; // typecasting
            LocalDate dueDate = (LocalDate) data[2]; // typecasting

            if (borrowedBook.equals(book)) {
                if (returnDate.isAfter(dueDate)) {
                    long daysOverdue = 0;
                    LocalDate tempDate = dueDate; // it is a temporary variable

                    while (!tempDate.isEqual(returnDate)) {
                        tempDate = tempDate.plusDays(1);
                        daysOverdue++;
                    } // calculating number of days between borrowed date and due date

                    fine = (int) daysOverdue * 100; // 100 PKR fined per day overdue
                    System.out.println("The book was returned after the due date.");
                    System.out.println("Days overdue: " + daysOverdue);
                    System.out.println("Fine charged (in PKR): " + fine);
                } else {
                    System.out.println("The book " + borrowedBook.getTitle() + " was returned on time. No fine charged.");
                }
                borrowedBooks.remove(book);
                detailsOfBorrowedBooks.remove(data);
                break;
            }
        }
    }

    public void printBorrowedBooks() {
        System.out.println("Member: " + name + " has borrowed the following book(s): ");
        for (Book b : borrowedBooks) {
            System.out.println("•) " + b.getTitle() + " - by " + b.getAuthor());
        }
    }
}