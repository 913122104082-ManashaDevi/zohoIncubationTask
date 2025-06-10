package LangtonsAntProblem;

import java.util.Scanner;

public class LangtonsAntProblem {
   public static void main(String arg[]){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter no of rows for Grid :");
       int rows=sc.nextInt();
       System.out.println("Enter no of columns for Grid :");
       int cols=sc.nextInt();
       int[][] grid=new int[rows][cols];
       System.out.println("Grid is created with white blocks initially... ");
       System.out.println("Define initial ant postion....");
       int ant[]=new int[3];
       System.out.println("Enter row for Ant :");
       ant[0]=sc.nextInt();
       System.out.println("Enter col for Ant :");
       ant[1]=sc.nextInt();
       while(!isValidPos(ant,rows,cols)){
           System.out.println("Enter row for Ant");
           ant[0]=sc.nextInt();
           System.out.println("Enter col for Ant");
           ant[1]=sc.nextInt();
       }
       System.out.println("Enter Ant initial direction(1-left 2-right 3-top 4-bottom) :");
       ant[2]=sc.nextInt();
       System.out.println("Enter No of movements Ant should make :");
       int count=sc.nextInt();
       for(int i=0;i<count;i++){
          int newAnt[]=makeMovement(ant,grid);
          if(!isValidPos(newAnt,rows,cols))
              break;
          else
              ant=newAnt;
       }
       System.out.println("Ant Postion :" +" Row :"+ant[0]+" Column :"+ant[1]);
       printGrid(grid,rows,cols);

   }

    private static void printGrid(int[][] grid, int rows, int cols) {
        System.out.print("--".repeat(cols));
        for(int i=0;i<rows;i++)
        {  System.out.print(" | ");
            for(int j=0;j<cols;j++)
            {
                char element= grid[i][j]==0 ? 'W':'B';
                System.out.print(element+" ") ;
            }
            System.out.print(" |\n");
        }
        System.out.print("--".repeat(cols));
    }


    private static int[] makeMovement(int ant[],int[][]grid)
    {
        int color= grid[ant[0]][ant[1]];
        grid[ant[0]][ant[1]]=1-color;
        int[][] move = {  {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
        int[] whiteDirection={4,3,1,2};
        int[] blackDirection={3,4,2,1};

        int dir=ant[2]-1;
        if (color == 0)
            dir=whiteDirection[dir];
        else
            dir=blackDirection[dir];
        int row=ant[0]+move[dir-1][0];
        int col=ant[1]+move[dir-1][1];
        return new int[]{row,col,dir};
    }

    private static boolean isValidPos(int ant[], int rows, int cols)
    {
        return 0 <= ant[0] && ant[0] < rows && 0 <= ant[1] && ant[1]< cols;
    }


}
