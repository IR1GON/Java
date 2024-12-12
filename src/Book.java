import java.util.ArrayList;

class Book {
    protected String title;
    protected String author;
    protected int year;
    protected String isbn;
    protected boolean isAvailable;

    public Book(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getInfo() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year + ", ISBN: " + isbn;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}