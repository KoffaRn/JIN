public class Fruit {
    boolean hasCore;
    boolean hasSkin;
    String name;

    public Fruit() {
        hasCore = true;
        hasSkin = true;
    }

    String getName() {
        return name;
    }

    void removeCore() {
        hasCore = false;
        System.out.println("Tog bort kärnan.");
    }

    void removeSkin() {
        hasSkin = false;
        System.out.println("Tog bort skalet.");
    }
}

