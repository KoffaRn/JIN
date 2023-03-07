public class Dragon extends Fiend {
    public Dragon(String name, int level, int health, int attack, int defense, int speed, int  moneyDrop, int xpWorth) {
        super(name, level, health, attack, defense, speed, moneyDrop, xpWorth);
    }
    int doubleBreath() {
        return attack(2);
    }
    int tripleBreath() {
        return attack(3);
    }
}
