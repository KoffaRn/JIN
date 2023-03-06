import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());
        fruits.add(new Banana());
        for(Fruit fruit : fruits) {
            System.out.println(fruit.getName());
            if(fruit instanceof Apple) {
                fruit.removeCore();
            }
            else if(fruit instanceof  Banana) {
                fruit.removeSkin();
            }
        }
    }
}
