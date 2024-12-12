public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new FictionBook("The Hobbit", "J.R.R. Tolkien", 1937, "1111", "Fantasy"));
        library.addBook(new FictionBook("1984", "George Orwell", 1949, "2222", "Dystopian"));
        library.addBook(new EducationalBook("Mathematics 101", "John Doe", 2000, "3333", "Mathematics", "University"));
        library.addBook(new EducationalBook("History of Ukraine", "Ivan Franko", 1995, "4444", "History", "School"));

        library.registerReader("Alice", 1);
        library.registerReader("Bob", 2);

        library.lendBook("1111", 1);
        library.lendBook("3333", 2);

        library.returnBook("1111", 1);

        System.out.println("\nBooks in the library:");
        library.displayBooks();
    }
}
