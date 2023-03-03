
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
public class Labyrint {

    public static void main(String[] args) {

        char[][] maze = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', 'O', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

        int playerX = 1;
        int playerY = 1;
        int monster1X = 6;
        int monster1Y = 1;
        int monster2X = 5;
        int monster2Y = 3;
        int steps = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            // Print the maze
            for (int y = 0; y < maze.length; y++) {
                for (int x = 0; x < maze[y].length; x++) {
                    if (x == playerX && y == playerY) {
                        System.out.print('P');
                    }else if (x == monster1X && y == monster1Y) {
                        System.out.print('M');
                    }else if (x == monster2X && y == monster2Y) {
                        System.out.print('M');
                    }

                    else {
                        System.out.print(maze[y][x]);
                    }
                }
                System.out.println();
            }

            // Get the player's move
            System.out.print("Enter your move (N/S/E/W): ");
            String move = input.nextLine();
            move = move.toLowerCase(Locale.ROOT);


            // Update the player's position
            switch (move) {
                case "n" -> {
                    if (maze[playerY - 1][playerX] != '#') {
                        playerY--;
                        steps++;
                    }else {
                        System.out.println("You can't go through walls.");
                    }
                }
                case "s" -> {
                    if (maze[playerY + 1][playerX] != '#') {
                        playerY++;
                        steps++;
                    }else {
                        System.out.println("You can't go through walls.");
                    }
                }
                case "e" -> {
                    if (maze[playerY][playerX + 1] != '#') {
                        playerX++;
                        steps++;
                    }else {
                        System.out.println("You can't go through walls.");
                    }
                }
                case "w" -> {
                    if (maze[playerY][playerX - 1] != '#') {
                        playerX--;
                        steps++;
                    }else {
                        System.out.println("You can't go through walls.");
                    }
                }
            }

            // Update the monsters position
            Random rnMove = new Random();

            boolean monsterBool1 = true;
            while(monsterBool1 == true) {
                int monsterMove = rnMove.nextInt(4) +1;
                switch (monsterMove) {
                    case 1 -> {
                        if(maze[monster1Y - 1][monster1X] != '#') {
                            monster1Y--;
                            monsterBool1 = false;
                        }
                    }
                    case 2 -> {
                        if(maze[monster1Y +1][monster1X] != '#') {
                            monster1Y++;
                            monsterBool1 = false;
                        }
                    }
                    case 3 -> {
                        if(maze[monster1Y][monster1X - 1] != '#') {
                            monster1X--;
                            monsterBool1 = false;
                        }
                    }
                    case 4 -> {
                        if(maze[monster1Y][monster1X +1] != '#') {
                            monster1X++;
                            monsterBool1 = false;
                        }
                    }
                }
            }
            boolean monsterBool2 = true;
            while(monsterBool2) {
                int monsterMove = rnMove.nextInt(2) + 1;
                switch(monsterMove) {
                    case 1 -> {
                        if (playerX > monster2X && maze[monster2Y][monster2X + 1] != '#') {
                            monster2X++;
                            monsterBool2 = false;
                        }else if(playerX < monster2X && maze[monster2Y][monster2X -1] != '#') {
                            monster2X--;
                            monsterBool2 = false;
                        }else {monsterBool2 = false;}
                    }
                    case 2 -> {
                        if(playerY > monster2Y && maze[monster2Y +1][monster2X] != '#') {
                            monster2Y++;
                            monsterBool2 = false;
                        }else if(playerY < monster2Y && maze[monster2Y -1][monster2X] != '#') {
                            monster2Y--;
                            monsterBool2 = false;
                        }else {monsterBool2 = false;}
                    }
                }
            }

            // Check if the player has reached the end
            if (playerX == 8 && playerY == 5) {
                System.out.println("Congratulations, you've escaped the maze in +" + steps + ".");
                break;
            }else if(playerX == monster1X && playerY == monster1Y) {
                System.out.println("The monster ate you!");
                break;
            }else if(playerX == monster2X && playerY == monster2Y) {
                System.out.println("The monster ate you!");
                break;
            }
        }

        input.close();
    }

}