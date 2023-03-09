public class Enemy {
    int health;
    int damage;
    public Enemy() {

    }

    /**
     *
     * @param amount to decrease enemy health
     */
    void decreaseHealth(int amount) {
        health -= amount;
    }

    /**
     *
     * @param amount to set health to
     */
    void setHealth(int amount) {
        health = amount;
    }

    /**
     *
     * @param amount to set damage to
     */
    void setDamage(int amount) {
        damage = amount;
    }

    /**
     *
     * @return true if enemy is dead
     */
    boolean isDead() {
        return health < 1;
    }

    /**
     *
     * @param player to attack
     */
    void attack(Player player) {
        player.incomingAttack(this);
    }

    /**
     *
     * @param gm to remove this enemy from enemyArrayList.
     */
    void die(GameManager gm) {
        gm.enemyArrayList.remove(this);
    }

}
