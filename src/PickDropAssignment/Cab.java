package PickDropAssignment;

public class Cab {
    private int cabId;
    private int ratePerKm;
    private String cabType;
    public Cab(int cabId,int ratePerKm,String cabType){
       this.cabId=cabId;
       this.ratePerKm=ratePerKm;
       this.cabType=cabType;
    }

    public int getCabId() {
        return cabId;
    }

    public String getCabType() {
        return cabType;
    }

    public int getRatePerKm() {
        return ratePerKm;
    }
}
