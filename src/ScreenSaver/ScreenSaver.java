package ScreenSaver;

import java.util.Scanner;

public class ScreenSaver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter grid width: ");
        int width = scanner.nextInt();

        System.out.print("Enter grid height: ");
        int height = scanner.nextInt();

        System.out.print("Enter word: ");
        String word = scanner.next();

        System.out.print("Enter number of moves: ");
        int times = scanner.nextInt();

        scanner.close();

        int[] pos=simulateScreenSaver(width, height, word, times);

    }

    public static int[] simulateScreenSaver(int width, int height, String word, int times)
    {

        int x=0;
        int y=0;
        int dx = 1;
        int dy = 1;
        for(int i=0;i<times;i++)
        {
            x += dx;
            y += dy;
            if (x <= 0 || x + word.length() >= width)
                dx = -dx;
            if (y <= 0 || y >= height - 1)
                dy = -dy;
        }
        return new int[]{x,y};
    }

    }

