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
        isBlocking = false;
        enemy.decreaseHealth(damage);
        if(energy < 1 || enemy instanceof Ranger && energy < 2) {
            System.out.printf("*YOU DO NOT HAVE ENOUGH ENERGY!*");
            return;
        }
        if(enemy instanceof Warrior) decreaseEnergy(1);
        else if (enemy instanceof Ranger) decreaseEnergy(2);
    }
    void startBlocking() {
        isBlocking = true;
        increaseEnergy(1);
    }
    void incomingAttack(Enemy enemy) {
        int hitChance = (int)(Math.random() * 100);
        if(!isBlocking || hitChance > blockChance) decreaseHealth(enemy.damage);
        if(enemy instanceof Warrior && riposteChance > hitChance) enemy.decreaseHealth(damage);
    }
    void decreaseHealth(int amount) {
        health -= amount;
    }
    void decreaseEnergy(int amount) {
        energy -= amount;
    }
    void increaseEnergy(int amount) {
        energy += amount;
    }
    void die(GameManager gm) {
        System.out.println("You have died!");
        gm.playerAttack();
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
