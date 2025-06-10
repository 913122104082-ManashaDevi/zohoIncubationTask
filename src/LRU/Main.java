package LRU;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        LRUCache lru=new LRUCache(3);
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter 1-put 2-get 3-stop");
        int option= sc.nextInt();
        while(option!=3){
            if(option==1)
            {
                System.out.println("Enter Charcter key to put:");
                char ch= sc.next().charAt(0);
                System.out.println("Enter String value to store:");
                String str= sc.next();
                lru.put(ch,str);
                lru.display();
            }
            else if(option==2){
                System.out.println("Enter Charcter key to retrive:");
                char ch= sc.next().charAt(0);
                String str=lru.get(ch);
                if(str!=null)
                    System.out.println(str+" ");
                else
                    System.out.println("no data");
            }

            System.out.println("\nEnter 1-put 2-get 3-stop");
            option= sc.nextInt();
        }
        lru.display();

    }
}
