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
    public Person(String name,String gender,Person father,Person mother){
        this.name=name;
        this.gender=gender;
        this.father=father;
        this.mother=mother;
        this.sons=new ArrayList<>();
        this.daughters=new ArrayList<>();
    }
}
