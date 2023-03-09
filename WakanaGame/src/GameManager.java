import java.util.ArrayList;

public class GameManager {
    Player player;
    ArrayList<Enemy> enemyArrayList;
    public GameManager() {
        enemyArrayList = new ArrayList<>();
        int playerHealth = (int) (Math.random() * 21) + 20;
        int playerEnergy = (int) (Math.random() * 3) + 4;
        int playerDamage = (int) (Math.random() * 3) + 1;
        int playerBlockChance = (int) (Math.random() * 51) + 30;
        int playerRiposteChance = (int) (Math.random() * 21) + 10;
        player = new Player(playerHealth, playerEnergy, playerDamage, playerBlockChance, playerRiposteChance);
        int noRangers = (int) (Math.random() * 3) + 2;
        int noWarriors = (int) (Math.random() * 3) + 2;
        for(int i = 0; i < noWarriors; i++) enemyArrayList.add(new Warrior());
        for(int i = 0; i < noRangers; i++) enemyArrayList.add(new Ranger());
        newRound();
    }

    void enemyDied(Enemy enemy) {
        enemyArrayList.remove(enemy);
    }
    void newRound() {
        System.out.println(player);
        System.out.println("Warriors left: " + warriorsLeft() + "\nRangers left: " + rangersLeft());
        System.out.println("What do you want to do?");
        playerTurn(warriorsLeft());
        enemyTurn();
        if(playerDied()) gameOver();
        playerWin();
        newRound();
    }
    int warriorsLeft() {
        int enemies = 0;
        for(Enemy e : enemyArrayList) {
            if(e instanceof Warrior) enemies += 1;
        }
        return enemies;
    }
    int rangersLeft() {
        int enemies = 0;
        for(Enemy e : enemyArrayList) {
            if(e instanceof Ranger) enemies += 1;
        }
        return enemies;
    }

    private void playerWin() {
        if(enemyArrayList.size() < 1) {
            System.out.println("You won!");
            playAgain();
        }
    }

    void gameOver() {
        System.out.println("You died!");
        playAgain();
    }
    private void playerTurn(int warriors) {
        if(player.energy <= 0 || player.energy == 1 && warriors < 1) System.out.println("1. Attack * NOT ENOUGH ENERGY *");
        else System.out.println("1. Attack");
        System.out.println("2. Block");
        int choice = Helper.takeInput();
        switch(choice) {
            case 1 -> playerAttack();
            case 2 -> playerBlock();
        }
    }

    void enemyTurn() {
        for(Enemy e : enemyArrayList) {
            player.incomingAttack(e);
        }
    }
    void playerAttack() {
        System.out.println("When attacking a Warrior you lose 1 energy. \nWhen attacking a Ranger you lose 2 energy.");
        for(int i = 0; i < enemyArrayList.size(); i++) {
            System.out.print((i + 1) + ". " + enemyArrayList.get(i));
            if(enemyArrayList.get(i) instanceof Ranger && player.energy < 2) System.out.print("*NOT ENOUGH ENERGY*\n");
            else System.out.println();
        }
        int choice = Helper.takeInput();
        player.attack(enemyArrayList.get(choice - 1));
        if(enemyArrayList.get(choice -1).isDead()) enemyArrayList.remove(choice - 1);
    }
    void playerBlock() {
        player.startBlocking();
    }
    boolean playerDied() {
        return player.health < 1;
    }
    void playAgain() {
        System.out.println("Do you want to play again");
        System.out.println("1. Yes \n2. No");
        int choice = Helper.takeInput();
        if(choice == 1) new GameManager();
        else if(choice == 2) System.exit(0);
    }
}
