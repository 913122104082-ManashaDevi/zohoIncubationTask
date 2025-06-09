package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    static int board[] = new int[9];
    static  Scanner sc=new Scanner(System.in);
    static boolean hasWinner = false;
    public static void main(String args[]) {
        int i= 0;
        int putValue = 1;

        Scanner sc=new Scanner(System.in);
        while (i<=8 && hasWinner == false) {
            getInput(putValue,i);
            putValue*=-1;
            i++;
        }
        if (!hasWinner)
            System.out.println("  Game Draw !!!!");

    }
    public static void getInput(int putValue,int i){
        boardPrint();
        System.out.println("Enter position : ");
        int pos=sc.nextInt();
        while(!put(pos)){
            System.out.println("Enter valid position : ");
            pos=sc.nextInt();
        }
        board[pos-1]=putValue;
        if (i>4 && winner(putValue)) {
            char ch = putValue == 1 ? 'X' : 'O';
            System.out.println("!!!  " + ch + " is Winner !!!!!");
            hasWinner=true;
        }
    }

    public static boolean put(int place) {
        place--;
        if (place >= 0 && place <= 8 && board[place] == 0) {
            return true;
        }
        return false;
    }

    public static void boardPrint() {
        System.out.println("-----  -----  -----");
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                char ch = board[i * 3 + j] == 1 ? 'X' : 'O';
                if (board[i * 3 + j] == 0)
                    System.out.print( "| " +(i * 3 +1+j)+ " |  ");
                else
                    System.out.print("| " + ch + " |  ");
            }
            System.out.println("\n-----  -----  -----");
        }

    }

    public static boolean winner(int value) {
        if (board[0] == value && board[1] == value && board[2] == value)
            return true;
        else if (board[3] == value && board[4] == value && board[5] == value)
            return true;
        else if (board[6] == value && board[7] == value && board[8] == value)
            return true;
        else if (board[0] == value && board[3] == value && board[6] == value)
            return true;
        else if (board[1] == value && board[4] == value && board[7] == value)
            return true;
        else if (board[2] == value && board[5] == value && board[8] == value)
            return true;
        else if (board[0] == value && board[4] == value && board[8] == value)
            return true;
        else if (board[2] == value && board[4] == value && board[6] == value)
            return true;
        return false;
    }

}
