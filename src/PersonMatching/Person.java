package PersonMatching;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    String name;
    String gender;
    Person father;
    Person mother;
    ArrayList<Person> sons;
    ArrayList<Person> daughters;
    ArrayList<Person> sisters;
    ArrayList<Person> brothers;
    public Person(String name,String gender,Person father,Person mother){
        this.name=name;
        this.gender=gender;
        this.father=father;
        this.mother=mother;
        this.sons=new ArrayList<>();
        this.daughters=new ArrayList<>();
        this.sisters=new ArrayList<>();
        this.brothers=new ArrayList<>();
    }


    public static ArrayList<Person> findMatching(Person matcher){
        ArrayList<Person> matchings=new ArrayList<>();
        ArrayList<Person> aunties=matcher.father.sisters;
        ArrayList<Person> uncles= matcher.mother.brothers;
        if(matcher.gender.equals("male"))
        {
            for(Person aunt: aunties)
                matchings.addAll(aunt.daughters);
            for(Person uncle: uncles)
                matchings.addAll(uncle.daughters);
        }else
        {
            for(Person aunt: aunties)
                matchings.addAll(aunt.sons);
            for(Person uncle: uncles)
                matchings.addAll(uncle.sons);
        }
        return  matchings;
    }
}
