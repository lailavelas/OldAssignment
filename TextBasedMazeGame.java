import java.util.Scanner;

public class TextBasedMazeGame {
    private static int playerRow = 0; // Player's starting row
    private static int playerCol = 0; // Player's starting column
    private static final int MAZE_SIZE = 5; // Size of the maze (5x5 in this example)

    // Representing the maze (1: wall, 0: path, P: player)
    private static final char[][] maze = {
            {'0', '1', '0', '1', '0'},
            {'0', '0', '1', '0', '1'},
            {'1', '0', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '1', '1', '0', 'P'}
    };

    public static void main(String[] args) {
        playMazeGame();
    }

    private static void displayMaze() {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void movePlayer(char direction) {
        int newRow = playerRow;
        int newCol = playerCol;

        switch (direction) {
            case 'W':
            case 'w':
                newRow--;
                break;
            case 'S':
            case 's':
                newRow++;
                break;
            case 'A':
            case 'a':
                newCol--;
                break;
            case 'D':
            case 'd':
                newCol++;
                break;
            default:
                System.out.println("Invalid input!");
                return;
        }

        if (isValidMove(newRow, newCol)) {
            // Update player's position
            maze[playerRow][playerCol] = '0';
            playerRow = newRow;
            playerCol = newCol;
            maze[playerRow][playerCol] = 'P';
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < MAZE_SIZE &&
               col >= 0 && col < MAZE_SIZE &&
               maze[row][col] != '1';
    }

    private static void playMazeGame() {
        Scanner scanner = new Scanner(System.in);
        char direction;

        System.out.println("Welcome to the Text-Based Maze Game!");
        displayMaze();

        while (maze[playerRow][playerCol] != 'P') {
            System.out.print("Enter a direction (WASD): ");
            direction = scanner.next().toUpperCase().charAt(0);

            movePlayer(direction);
            displayMaze();
        }

        System.out.println("Congratulations! You have reached the end of the maze!");
        scanner.close();
    }
}
