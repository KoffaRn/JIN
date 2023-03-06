public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;

    }
    @Override
    public double area() {
        return Math.pow((Math.PI * radius), 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
