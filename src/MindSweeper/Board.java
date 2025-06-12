package MindSweeper;

import java.util.Random;

class Cell {
    boolean isBomb;
    boolean isRevealed;
    int adjacentBombs;

    public Cell() {
        this.isBomb = false;
        this.isRevealed = false;
        this.adjacentBombs = 0;
    }

    public char getDisplayChar() {
        if (!isRevealed) return '-';
        if (isBomb) return '*';
        return adjacentBombs == 0 ? ' ' : (char) ('0' + adjacentBombs);
    }
}

public class Board {
    private int rows, cols, bombs;
    private Cell[][] grid;

    public Board(int rows, int cols, int bombCount) {
        this.rows = rows;
        this.cols = cols;
        this.bombs = bombCount;
        this.grid = new Cell[rows][cols];

        initializeBoard();
        placeBombs();
        calculateAdjacents();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = new Cell();
    }

    private void placeBombs() {
        Random rand = new Random();
        int placed = 0;
        while (placed < bombs) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (!grid[r][c].isBomb) {
                grid[r][c].isBomb = true;
                placed++;
            }
        }
    }

    private void calculateAdjacents() {
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].isBomb) continue;
                int count = 0;
                for (int d = 0; d < 8; d++) {
                    int ni = i + dx[d], nj = j + dy[d];
                    if (isInBounds(ni, nj) && grid[ni][nj].isBomb) {
                        count++;
                    }
                }
                grid[i][j].adjacentBombs = count;
            }
        }
    }

    private boolean isInBounds(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public boolean reveal(int r, int c) {
        if (!isInBounds(r, c) || grid[r][c].isRevealed) return true;

        grid[r][c].isRevealed = true;

        if (grid[r][c].isBomb) {
            return false;
        }

        if (grid[r][c].adjacentBombs == 0) {
            int[] dx = {-1,-1,-1,0,0,1,1,1};
            int[] dy = {-1,0,1,-1,1,-1,0,1};
            for (int d = 0; d < 8; d++) {
                reveal(r + dx[d], c + dy[d]);
            }
        }

        return true;
    }

    public void printBoard() {
        System.out.print("   ");
        for (int j = 0; j < cols; j++) System.out.print(j % 10 + " ");
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i % 10 + "  ");
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j].getDisplayChar() + " ");
            }
            System.out.println();
        }
    }

    public boolean allSafeCellsRevealed() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (!grid[i][j].isRevealed && !grid[i][j].isBomb)
                    return false;
        return true;
    }
}
