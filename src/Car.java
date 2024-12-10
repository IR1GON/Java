public class Car {
    private String model;
    private int year;
    private String manufacturer;
    private static int totalCarsProduced = 0;

    public Car(String model, int year, String manufacturer) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        totalCarsProduced++;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year + ", Manufacturer: " + manufacturer);
    }

    public static int getTotalCarsProduced() {
        return totalCarsProduced;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
