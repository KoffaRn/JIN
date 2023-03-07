public class Troll extends Fiend{

    public Troll(String name, int level, int health, int attack, int defense, int speed, int  moneyDrop, int xpWorth) {
        super(name, level, health, attack, defense, speed, moneyDrop, xpWorth);
    }
    int doubleSmash() {
        return attack(2);
    }
    int tripleSmash() {
        return attack(3);
    }
}
