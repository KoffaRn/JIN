public class Main
{
    public static void main(String[] args)
    {
        int level=2;
        Goblin goblin = CreateGoblin(level);
        Troll troll = CreateTroll(level);
        Orc orc = CreateOrc(level);
        Dragon dragon = CreateDragon(level);
        Demon demon = CreateDemon(level);

        System.out.println("Goblin "+goblin.name+" level "+goblin.level);
        System.out.println("doubleBite: " + goblin.doubleBite());
        System.out.println("tripleBite: " + goblin.tripleBite());
        goblin.jump();
        System.out.println();

        System.out.println("Troll "+troll.name+" level "+troll.level);
        System.out.println("doubleSmash: " + troll.doubleSmash());
        System.out.println("tripleSmash: " + troll.tripleSmash());
        System.out.println();

        System.out.println("Orc "+orc.name+" level "+orc.level);
        System.out.println("doubleSmash: " + orc.doubleSmash());
        System.out.println("tripleSmash: " + orc.tripleSmash());
        System.out.println();

        System.out.println("Dragon "+dragon.name+" level "+dragon.level);
        System.out.println("doubleBreath: " + dragon.doubleBreath());
        System.out.println("tripleBreath: " + dragon.tripleBreath());
        System.out.println();

        System.out.println("Demon "+ demon.name+" level "+ demon.level);
        System.out.println("doubleBreath: " + demon.doubleBreath());
        System.out.println("tripleBreath: " + demon.tripleBreath());
    }

    public static Goblin CreateGoblin(int level)
    {
        int health = 10 * level;
        int attack = 2 * level;
        int defense = 2 + 2 * level;
        int speed =  15 + 3 * level;
        int moneyDrop = 10 * level;
        int xpWorth =  25 * level;

        return new Goblin("Goblin", level, health, attack, defense, speed, moneyDrop, xpWorth);
    }

    public static Troll CreateTroll(int level)
    {
        int health = 50 + 20 * level;
        int attack = 15 + 3 * level;
        int defense = 30 + 3 * level;
        int speed =  2 + 2 * level;
        int moneyDrop =100 + 20 * level;
        int xpWorth =  100 + 50 * level;

        return new Troll("Troll", level, health, attack, defense, speed, moneyDrop, xpWorth);
    }

    public static Orc CreateOrc(int level)
    {
        int health = 200 + 30 * level;
        int attack = 50 + 3 * level;
        int defense = 40 + 5 * level;
        int speed =  5 + 3 * level;
        int moneyDrop = 200 + 50 * level;
        int xpWorth =  200 + 100 * level;

        return new Orc("Orc", level, health, attack, defense, speed, moneyDrop, xpWorth);
    }

    public static Dragon CreateDragon(int level)
    {
        int health = 1500 + 100 * level;
        int attack = 100 + 10 * level;
        int defense = 100 + 10 * level;
        int speed =  10 + 5 * level;
        int moneyDrop = 500 + 100 * level;
        int xpWorth =  1500 + 200 * level;

        return new Dragon("Dragon", level, health, attack, defense, speed, moneyDrop, xpWorth);
    }

    public static Demon CreateDemon(int level)
    {
        int health = 100 + 100 * level;
        int attack = 210 + 10 * level;
        int defense = 100 + 10 * level;
        int speed =  10 + 5 * level;
        int moneyDrop = 500 + 100 * level;
        int xpWorth =  500 + 200 * level;

        return new Demon("Demon", level, health, attack, defense, speed, moneyDrop, xpWorth);
    }

}