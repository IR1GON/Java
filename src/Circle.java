class Circle {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateLength() {
        return 2 * Math.PI * radius;
    }
}