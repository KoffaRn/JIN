public class Warrior extends Enemy {
    public Warrior() { health = (int) (Math.random() * 5) + 4;
        super.setHealth(health);
        damage = (int) (Math.random() * 2) + 2;
        super.setDamage(damage);
    }
    void attack() {

    }
    void checkIfDead() {

    }
    void die() {

    }
    @Override
    public String toString() {
        return "Warrior (" + health + ")";
    }
}
