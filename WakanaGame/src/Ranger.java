public class Ranger extends Enemy {
    public Ranger() {
        health = (int) (Math.random() * 4) + 3;
        super.setHealth(health);
        damage = (int) (Math.random() * 3) + 1;
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
        return "Ranger (" + health + ")";
    }
}
