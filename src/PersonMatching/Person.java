package PersonMatching;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    String name;
    String gender;
    Person father;
    Person mother;
    ArrayList<Person> sisters;
    ArrayList<Person> brothers;
    ArrayList<Person> sons;
    ArrayList<Person> daughters;
    public Person(String name,String gender,Person father,Person mother){
        this.name=name;
        this.gender=gender;
        this.father=father;
        this.mother=mother;
        this.sisters=new ArrayList<>();
        this.brothers=new ArrayList<>();
        this.sons=new ArrayList<>();
        this.daughters=new ArrayList<>();
    }

    public ArrayList<Person> getDaughters() {
        return daughters;
    }

    public ArrayList<Person> getSons() {
        return sons;
    }

    public ArrayList<Person> getBrothers() {
        return brothers;
    }
    public ArrayList<Person> getSisters() {
        return sisters;
    }

    public static void buildNewRelation(Person person, HashMap<String,Person> family){
         Person personfather=person.father;
         Person personmother=person.mother;


    }
}
