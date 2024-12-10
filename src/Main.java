public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Tesla Model S", 2022, "Tesla");
        Car car2 = new Car("Ford Mustang", 2023, "Ford");
        Car car3 = new Car("Toyota Corolla", 2021, "Toyota");

        car1.displayInfo();
        car2.displayInfo();
        car3.displayInfo();

        System.out.println("Total cars produced: " + Car.getTotalCarsProduced());
    }
}
