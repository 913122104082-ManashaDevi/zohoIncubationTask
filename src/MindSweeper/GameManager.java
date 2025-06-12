package MindSweeper;

import java.util.Scanner;

public class GameManager {
    private Board board;
    private Scanner sc = new Scanner(System.in);

    public GameManager(Board board) {
        this.board = board;
    }

    public void play() {
        boolean isRunning = true;
        while (isRunning) {
            board.printBoard();
            System.out.print("Enter row and column to reveal (e.g., 3 5): ");
            int r = sc.nextInt();
            int c = sc.nextInt();

            boolean success = board.reveal(r, c);
            if (!success) {
                System.out.println("Boom You hit a bomb.");
                board.printBoard();
                System.out.println("Game Over!");
                return;
            }

//            if (board.allCellsRevealed()) {
//                board.printBoard();
//                System.out.println("🎉 Congratulations! You won the game!");
//                return;
//            }
        }
    }
}

