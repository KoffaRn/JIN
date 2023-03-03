public class Main {
    public static void main(String[] args) {
        Car car = new Car(false, true, false);
        Workshop workshop = new Workshop();
        workshop.carStatus(car);
        workshop.fixAll(car);
        workshop.carStatus(car);
    }
}