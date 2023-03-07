public class Goblin extends Fiend{
    public boolean takeNoDmg;
    public Goblin(String name, int level, int health, int attack, int defense, int speed, int  moneyDrop, int xpWorth) {
        super(name, level, health, attack, defense, speed, moneyDrop,xpWorth);
        this.takeNoDmg = false;
    }
    int doubleBite() {
        return attack(2);
    }
    int tripleBite() {
        return attack(3);
    }
    void jump() {
        System.out.print(name + " jumped away, cannot be hurt next round.");
        takeNoDmg = true;
    }
    @Override
    int takeDamage(int damage) {
        if(!takeNoDmg) return damage - defense;
        else {
            takeNoDmg = false;
            return 0;
        }
    }

}
