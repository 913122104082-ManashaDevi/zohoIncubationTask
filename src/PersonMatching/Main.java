package PersonMatching;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter inputs.......\n");
        System.out.println("Enter 1 to add new person 0 to stop\n");
        HashMap<String,Person> family=new HashMap<>();
        int option=0;
        System.out.println("option :");
        option=sc.nextInt();
        while(option==1){
            System.out.println("Enter name :");
            String name=sc.next();
            System.out.println("Enter gender(male,female) :");
            String gender=sc.next();
            System.out.println("Enter father name :");
            String fathername=sc.next();
            System.out.println("Enter mother name :");
            String mothername=sc.next();

            Person father;
            Person mother;
            if(!family.containsKey(fathername))
            {
                 father= new Person(fathername,"male",null,null);

                 family.put(fathername,father);
            }else
            {
                 father=family.get(fathername);
            }

            if(!family.containsKey(mothername))
            {
                mother= new Person(mothername,"female",null,null);
                family.put(mothername,mother);
            }else
            {
                mother=family.get(mothername);
            }

            Person current= new Person(name,gender,father,mother);
            Person.buildNewRelation(current,family);



            System.out.println("option :");
            option=sc.nextInt();
        }


        }
    }

