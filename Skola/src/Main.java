import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student pelle = new Student("Pelle", 3, 5);
        Parent stina = new Parent("Stina", 34, pelle);
        pelle.addParent(stina);
        Teacher koffa = new Teacher("Koffa", 35, 40_000);
        System.out.println(koffa);
        System.out.println(stina);
        System.out.println(pelle);


    }
}