package PickDropAssignment;

import java.time.LocalDate;
import java.util.Date;

public class PickDrop {
    private int id;
    private Employee employee;
    private CabDriver cabDriver;
    private Cab cab;
    private LocalDate date;
    private int distance;
    private float cabwages;
    public PickDrop(int id,Employee employee,CabDriver cabDriver,Cab cab,LocalDate date){
        this.id=id;
        this.employee=employee;
        this.cabDriver=cabDriver;
        this.cab=cab;
        this.date=date;
        this.distance=this.getTravelDistance();
        this.cabwages=this.getCabWages();
    }
    public int getTravelDistance(){
        return this.employee.getDistance();
    }
    public float getCabWages(){
        float wages= (float)(this.employee.getDistance()) *(this.cab.getRatePerKm());
        return wages;
    }
    public float getDriverexpense(){
        float expense= (float)(this.employee.getDistance() *20);
        return expense;
    }
    public LocalDate getDate() {
        return date;
    }
    public int getDriverId() {
        return this.cabDriver.getDriverId();
    }
    public String getCabType(){
        return this.cab.getCabType();
    }

    public Cab getCab() {
        return cab;
    }
    public CabDriver getCabDriver() {
        return cabDriver;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getDistance() {
        return distance;
    }

    public float getCabwages() {
        return cabwages;
    }
}
