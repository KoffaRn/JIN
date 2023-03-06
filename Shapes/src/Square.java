public class Square extends Shape {
    int s;
    public Square(int s) {
        super("Square");
        this.s = s;
    }

    @Override
    public double area() {
        return s * s;
    }

    @Override
    public double perimeter() {
        return 4 * s;
    }
}
