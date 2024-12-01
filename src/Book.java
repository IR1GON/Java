public class Book {
    String name;
    String author;
    int price;

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public static int discount(int price, int discountPercentage) {
        return price - (price * discountPercentage / 100);
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', author='" + author + "', price=" + price + "}";
    }
}
