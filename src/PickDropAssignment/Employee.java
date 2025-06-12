package PickDropAssignment;

import java.util.ArrayList;

public class Employee {
    private String employeeName ;
    private int designationLevel;
    private int distance;
    public Employee(String name,int designationLevel,int distance)
    {
        this.employeeName=name;
        this.designationLevel=designationLevel;
        this.distance=distance;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getDistance() {
        return distance;
    }
}
