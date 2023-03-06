public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5, 10);
        shapes[2] = new Square(5);

        for (Shape shape : shapes) {
            System.out.println(shape.getName());
            System.out.println("Area: " + shape.area());
            System.out.println("Omkrets: " + shape.perimeter());
            System.out.println();
        }
    }
}