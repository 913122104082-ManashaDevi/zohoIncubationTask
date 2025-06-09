package PersonMatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static  void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int option;
        System.out.println("Enter inputs.......\n");
        System.out.println("Enter 1 to add new person 0 to stop\n");

        HashMap<String,Person> family=new HashMap<>();

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

            buildRelation(name, gender,fathername,mothername,family);
            System.out.println("option :");
            option=sc.nextInt();
        }

        System.out.println("Enter Person name who want match......\n");
        String matcherName=sc.next();

        ArrayList<Person> matchings= Person.findMatching(family.get(matcherName));
        System.out.println(" Moraponnu or Morapaiyan......\n\n");
        for(Person match: matchings)
            System.out.println(match.name);

        }

        private static void buildRelation(String name,String gender,String fathername,String mothername,HashMap<String,Person> family){
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
            Person current;
            if(!family.containsKey(name)) {
                current = new Person(name, gender , father, mother);

            }else
            {
                current=family.get(name);
                current.father=father;
                current.mother=mother;
            }

            current.brothers.addAll(father.sons);
            current.sisters.addAll(father.daughters);
            if (gender.equals("male"))
            {

                for(Person bro: father.sons)
                {
                    bro.brothers.add(current);
                }
                for(Person sis: father.daughters)
                {
                    sis.brothers.add(current);
                }
                father.sons.add(current);
                mother.sons.add(current);
            }else {
                for(Person bro: father.sons)
                {
                    bro.sisters.add(current);
                }
                for(Person sis: father.daughters)
                {
                    sis.sisters.add(current);
                }
                father.daughters.add(current);
                mother.daughters.add(current);
            }

            family.put(name,current);

        }

    }

