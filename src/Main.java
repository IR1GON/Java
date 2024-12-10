public class Main {
    public static void main(String[] args) {
        Dish soup = new Dish("Soup", 5, "Starter");
        Dish pizza = new Dish("Pizza", 10, "Main Course");
        Dish iceCream = new Dish("Ice Cream", 3, "Dessert");

        Restaurant.addDish(soup);
        Restaurant.addDish(pizza);
        Restaurant.addDish(iceCream);

        Restaurant.displayMenu();

        System.out.println("Total number of dishes in the menu: " + Restaurant.getTotalDishes());
    }
}
