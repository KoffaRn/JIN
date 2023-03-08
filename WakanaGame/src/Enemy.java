public class Enemy {
    int health;
    int damage;
    public Enemy() {

    }
    void decreaseHealth(int amount) {
        health -= amount;
    }
    void setHealth(int amount) {
        health = amount;
    }
    void setDamage(int amount) {
        damage = amount;
    }
    boolean isDead() {
        if (health < 1) return true;
        else return false;
    }

}
