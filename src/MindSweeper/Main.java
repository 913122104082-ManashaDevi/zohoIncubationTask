package MindSweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = 0, cols = 0, bombs = 0;

        System.out.print("Choose difficulty (easy / medium / hard): ");
        String level = sc.nextLine().toLowerCase();

        switch (level) {
            case "easy":
                rows = 30; cols = 20;
                bombs = (int) (0.25 * rows * cols);
                break;
            case "medium":
                rows = 40; cols = 40;
                bombs = (int) (0.30 * rows * cols);
                break;
            case "hard":
                rows = 50; cols = 60;
                bombs = (int) (0.40 * rows * cols);
                break;
            default:
                System.out.println("Invalid level. Defaulting to easy.");
                rows = 30; cols = 20;
                bombs = (int) (0.25 * rows * cols);
        }

        Board board = new Board(rows, cols, bombs);
        GameManager gm = new GameManager(board);
        gm.play();
    }
}

