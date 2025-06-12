package PickDropAssignment;

import java.util.ArrayList;

public class CabDriver {
    private String name;

    public String getName() {
        return name;
    }

    private int driverId;
    public CabDriver(int driverId,String name){
      this.name=name;
      this.driverId=driverId;
    }

    public int getDriverId() {
        return driverId;
    }
}
