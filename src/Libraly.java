import java.util.ArrayList;
class Library {
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerReader(String name, int id) {
        readers.add(new Reader(name, id));
    }

    public boolean lendBook(String isbn, int readerId) {
        for (Book book : books) {
            if (book.isAvailable && book.isbn.equals(isbn)) {
                for (Reader reader : readers) {
                    if (reader.getId() == readerId) {
                        reader.borrowBook(book);
                        book.setAvailability(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean returnBook(String isbn, int readerId) {
        for (Reader reader : readers) {
            if (reader.getId() == readerId) {
                for (Book book : reader.getBorrowedBooks()) {
                    if (book.isbn.equals(isbn)) {
                        reader.returnBook(book);
                        book.setAvailability(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
    }

    public ArrayList<Book> searchByGenre(String genre) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof FictionBook && ((FictionBook) book).getInfo().contains("Genre: " + genre)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchBySubject(String subject) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof EducationalBook && ((EducationalBook) book).getInfo().contains("Subject: " + subject)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }
}
