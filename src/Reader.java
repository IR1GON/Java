import java.util.ArrayList;


class Reader {
    private String name;
    private int id;
    private ArrayList<Book> borrowedBooks;

    public Reader(String name, int id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}