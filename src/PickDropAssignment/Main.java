package PickDropAssignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
        public static void main(String arg[]) {

            HashMap<String, ArrayList<PickDrop>> driverWagesMap = new HashMap<>();
            HashMap<String, ArrayList<PickDrop>> cabWagesMap = new HashMap<>();
            HashMap<String, ArrayList<PickDrop>> employeeWagesMap = new HashMap<>();

            Employee emp1 = new Employee("manasha", 1, 10);
            Employee emp2 = new Employee("ritika", 2, 15);
            Employee emp3 = new Employee("abi", 3, 10);

            Cab cab1 = new Cab(1001, 20, "A");
            Cab cab2 = new Cab(1002, 30, "B");
            Cab cab3 = new Cab(1003, 20, "A");

            CabDriver cd1 = new CabDriver(1, "xxx");
            CabDriver cd2 = new CabDriver(2, "yyy");

//            HashMap<String, Employee> Employees = new HashMap<>();
//            HashMap<Integer, Cab> Cabs = new HashMap<>();
//            HashMap<String, CabDriver> Drivers = new HashMap<>();
//            Employees.put("manasha", emp1);
//            Employees.put("ritika", emp2);
//            Employees.put("abi", emp3);
//            Cabs.put(1001, cab1);
//            Cabs.put(1002, cab2);
//            Cabs.put(1003, cab3);
//            Drivers.put("xxx", cd1);
//            Drivers.put("yyy", cd2);

            LocalDate date1 = LocalDate.of(2025, 10, 12);
            LocalDate date2 = LocalDate.of(2025, 11, 12);
            PickDrop pick1 = new PickDrop(1, emp1, cd1, cab2, date1);
            PickDrop pick2 = new PickDrop(2, emp1, cd2, cab1, date1);
            PickDrop pick3 = new PickDrop(3, emp2, cd2, cab3, date2);
            PickDrop pick4 = new PickDrop(4, emp3, cd1, cab1, date2);

            PickDrop[] allPicks = {pick1, pick2, pick3, pick4};

            for (PickDrop pd : allPicks) {
                driverWagesMap.putIfAbsent(pd.getCabDriver().getName(), new ArrayList<>());
                driverWagesMap.get(pd.getCabDriver().getName()).add(pd);
                cabWagesMap.putIfAbsent(pd.getCab().getCabType(), new ArrayList<>());
                cabWagesMap.get(pd.getCab().getCabType()).add(pd);
                employeeWagesMap.putIfAbsent(pd.getEmployee().getEmployeeName(), new ArrayList<>());
                employeeWagesMap.get(pd.getEmployee().getEmployeeName()).add(pd);
            }

            System.out.println("Driver Wages :");
            for (String driver : driverWagesMap.keySet()) {
                float totalcost=(float)0;
                int trips=driverWagesMap.get(driver).size();
                for(PickDrop pd :driverWagesMap.get(driver)){
                    totalcost+=pd.getDriverexpense();
                }
                System.out.println(" Name: "+driver+" trips: "+ trips+" Cost: "+totalcost);
            }

            System.out.println("\n\n\nCab Wages :");
            for (String cabType : cabWagesMap.keySet())
            {
            float totalcost=(float)0;
            int trips=cabWagesMap.get(cabType).size();
            for(PickDrop pd :cabWagesMap.get(cabType)){
                totalcost+=pd.getCabWages();
            }
             System.out.println(cabType + ": " + " trips :"+ trips+" Cost: "+totalcost);
             }

            System.out.println("\n\n\nEmployee Wages :");
            for (String empName : employeeWagesMap.keySet()) {
                float totalcost=(float)0;
                int trips=employeeWagesMap.get(empName).size();
                for(PickDrop pd :employeeWagesMap.get(empName)){
                    totalcost+=pd.getCabWages();
                }
                System.out.println(" Name: "+empName+" trips: "+ trips+" Cost: "+totalcost);
            }



            Scanner sc=new Scanner(System.in);
            System.out.println("\n\n\nEnter month");
            int month=sc.nextInt();
            System.out.println("Enter year");
            int year=sc.nextInt();

            System.out.println("\nDriver Wages (Month Filtered):");
            for (String driver : driverWagesMap.keySet()) {
                float totalCost = 0;
                int trips = 0;
                for (PickDrop pd : driverWagesMap.get(driver)) {
                    if (pd.getDate().getMonthValue() == month && pd.getDate().getYear() == year) {
                        totalCost += pd.getDriverexpense();
                        trips++;
                    }
                }
                if (trips > 0)
                    System.out.println(" Name: " + driver + " trips: " + trips + " Cost: " + totalCost);
            }

            System.out.println("\nCab Wages  (Month Filtered):");
            for (String cabType : cabWagesMap.keySet()) {
                float totalCost = 0;
                int trips = 0;
                for (PickDrop pd : cabWagesMap.get(cabType)) {
                    if (pd.getDate().getMonthValue() == month && pd.getDate().getYear() == year) {
                        totalCost += pd.getCabWages();
                        trips++;
                    }
                }
                if (trips > 0)
                    System.out.println("Cab Type: " + cabType + " trips: " + trips + " Cost: " + totalCost);
            }

            System.out.println("\nEmployee Wages (Month Filtered):");
            for (String empName : employeeWagesMap.keySet()) {
                float totalCost = 0;
                int trips = 0;
                for (PickDrop pd : employeeWagesMap.get(empName)) {
                    if (pd.getDate().getMonthValue() == month && pd.getDate().getYear() == year) {
                        totalCost += pd.getCabWages();
                        trips++;
                    }
                }
                if (trips > 0)
                    System.out.println(" Name: " + empName + " trips: " + trips + " Cost: " + totalCost);
            }


        }
    }


