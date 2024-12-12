class FictionBook extends Book {
    private String genre;

    public FictionBook(String title, String author, int year, String isbn, String genre) {
        super(title, author, year, isbn);
        this.genre = genre;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Genre: " + genre;
    }
}
