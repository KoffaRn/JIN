public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Cat cat = new Cat();
        dog.makeNoise();
    }
}

abstract class Animal {
    String noise;
    public Animal() {

    }
    void makeNoise() {
        System.out.println(noise);
    }
}

class Cat extends Animal {
    public Cat() {
        noise = "meow";
    }

}

class Dog extends Animal {
    public Dog() {
        noise = "woff";
    }
}