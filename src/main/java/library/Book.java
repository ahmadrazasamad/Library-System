package library;

public class Book {

    private String title, author, isbn, genre;

    public Book(String title, String author, String isbn, String genre) { // constructor
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
    }

//    Getters and Setter for ensuring encapsulation  
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}