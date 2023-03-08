public class Player {
    int health;
    int damage;
    int energy;
    int blockChance;
    int riposteChance;
    boolean isBlocking;
    public Player(int health, int energy, int damage, int blockChance, int riposteChance) {
        this.health = health;
        this.energy = energy;
        this.damage = damage;
        this.blockChance = blockChance;
        this.riposteChance = riposteChance;
        this.isBlocking = false;
    }

    void attack(Enemy enemy) {

    }
    void startBlocking() {

    }
    void incomingAttack(Enemy enemy) {
        int hitChance = (int)(Math.random() * 100);
        if(!isBlocking || hitChance > blockChance) health -= enemy.damage;
        if(enemy instanceof Warrior && riposteChance > hitChance) enemy.decreaseHealth(damage);
    }
    void block(boolean rangedAttack) {

    }
    void decreaseHealth(int amount) {

    }
    void decreaseEnergy(int amount) {

    }
    void increaseEnergy(int amount) {

    }
    void die() {

    }
    @Override
    public String toString() {
        return "----------------------------\n" +
                "Player \n" +
                "Health: " + health +
                "\nDamage: " + damage +
                "\nEnergy: " + energy +
                "\nBlock chance: " + blockChance + "%" +
                "\nRiposte chance: " + riposteChance + "%" +
                "\n----------------------------";
    }
}
