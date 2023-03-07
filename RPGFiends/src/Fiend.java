public class Fiend {
    String name;
    int level;
    int health;
    int attack;
    int defense;
    int speed;
    int moneyDrop;
    int xpWorth;
    public Fiend(String name, int level, int health, int attack, int defense, int speed, int  moneyDrop, int xpWorth) {
            this.name = name;
            this.level = level;
            this.health = health;
            this.attack = attack;
            this.defense = defense;
            this.speed = speed;
            this.moneyDrop = moneyDrop;
            this.xpWorth = xpWorth;
    }
    int attack(int attackType) {
        return attack * attackType;
    }
    int takeDamage(int damage) {
        return Math.max(0, damage - defense);
    }
    boolean isDead() {
        return health <= 0;
    }
}