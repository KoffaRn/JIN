public class Rectangle extends Shape {
    int w;
    int h;
    public Rectangle(int w, int h) {
        super("Rectangle");
        this.w = w;
        this.h = h;
    }

    @Override
    public double area() {
        return h * w;
    }

    @Override
    public double perimeter() {
        return 2 * (w + h);
    }
}
