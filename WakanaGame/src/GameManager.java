import java.util.ArrayList;

public class GameManager {
    //Instance of player
    Player player;
    //List of enemies
    ArrayList<Enemy> enemyArrayList;
    public GameManager() {
        //New enemy list
        enemyArrayList = new ArrayList<>();
        //New random stats for the player and instantiate player object
        int playerHealth = (int) (Math.random() * 21) + 20;
        int playerEnergy = (int) (Math.random() * 3) + 4;
        int playerDamage = (int) (Math.random() * 3) + 1;
        int playerBlockChance = (int) (Math.random() * 51) + 30;
        int playerRiposteChance = (int) (Math.random() * 21) + 10;
        player = new Player(playerHealth, playerEnergy, playerDamage, playerBlockChance, playerRiposteChance);
        //Populate enemyList with random number of enemies (Warriors and Rangers)
        int noRangers = (int) (Math.random() * 3) + 2;
        int noWarriors = (int) (Math.random() * 3) + 2;
        for(int i = 0; i < noWarriors; i++) enemyArrayList.add(new Warrior());
        for(int i = 0; i < noRangers; i++) enemyArrayList.add(new Ranger());
        //Start new round
        newRound();
    }
    /**
    Starts a new round, prints enemies left and asks for player choice. Check if player won and when all is done recursive calls for new round.
     */
    void newRound() {
        System.out.println(player);
        System.out.println("Warriors left: " + warriorsLeft() + "\nRangers left: " + rangersLeft());
        System.out.println("What do you want to do?");
        playerTurn();
        enemyTurn();
        if(playerDied()) gameOver();
        playerWin();
        newRound();
    }

    /**
     * Enemy dies
     * @param enemy who died
     */
    void enemyDied(Enemy enemy) {
        enemy.die(this);
    }

    /**
     *
     * @return numbers of Warriors left alive
     */
    int warriorsLeft() {
        int enemies = 0;
        for(Enemy e : enemyArrayList) {
            if(e instanceof Warrior) enemies += 1;
        }
        return enemies;
    }

    /**
     *
     * @return number of rangers left alive
     */
    int rangersLeft() {
        int enemies = 0;
        for(Enemy e : enemyArrayList) {
            if(e instanceof Ranger) enemies += 1;
        }
        return enemies;
    }

    /**
     * Check if the player wins the game and playAgain if they have
     */
    private void playerWin() {
        if(enemyArrayList.size() < 1) {
            System.out.println("You won!");
            playAgain();
        }
    }

    /**
     * Player died, asks for play again
     */
    void gameOver() {
        System.out.println("You died!");
        playAgain();
    }

    /**
     *
     * Logic for the players turn each round
     */
    private void playerTurn() {
        if(player.energy <= 0 || player.energy == 1 && warriorsLeft() < 1) System.out.println("1. Attack * NOT ENOUGH ENERGY *");
        else System.out.println("1. Attack");
        System.out.println("2. Block");
        int choice = Helper.takeInput();
        switch(choice) {
            case 1 -> playerAttack();
            case 2 -> playerBlock();
        }
    }

    /**
     * Logic for the enemy turn each round
     */
    void enemyTurn() {
        for(Enemy e : enemyArrayList) {
            e.attack(player);
        }
    }

    /**
     * Logic for player choice attack. Prints info about attack. Player chooses enemy to attack, attacks and checks if enemy died
     */
    void playerAttack() {
        System.out.println("When attacking a Warrior you lose 1 energy. \nWhen attacking a Ranger you lose 2 energy.");
        for(int i = 0; i < enemyArrayList.size(); i++) {
            System.out.print((i + 1) + ". " + enemyArrayList.get(i));
            if(enemyArrayList.get(i) instanceof Ranger && player.energy < 2) System.out.print("*NOT ENOUGH ENERGY*\n");
            else System.out.println();
        }
        int choice = Helper.takeInput();
        player.attack(enemyArrayList.get(choice - 1));
        if(enemyArrayList.get(choice -1).isDead()) enemyDied(enemyArrayList.get(choice -1));
    }

    /**
     * Player starts blocking
     */
    void playerBlock() {
        player.startBlocking();
    }

    /**
     *
     * @return true if player died
     */
    boolean playerDied() {
        return player.health < 1;
    }

    /**
     * Prints play again menu and either exits or starts new GameManager object.
     */
    void playAgain() {
        System.out.println("Do you want to play again");
        System.out.println("1. Yes \n2. No");
        int choice = Helper.takeInput();
        if(choice == 1) new GameManager();
        else if(choice == 2) System.exit(0);
    }
}
