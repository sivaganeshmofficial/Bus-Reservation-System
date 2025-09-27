package Bus_Reservation_System;

import java.util.ArrayList;
import java.util.List;

public class Vendor {
    private int vendorId;
    private String password;
    private String travelsName;
    private List<Bus> buses;


    public Vendor(int vendorId,String password, String travelsName) {
        this.vendorId = vendorId;
        this.password = password;
        this.travelsName = travelsName;
        this.buses = new ArrayList<>();
    }

    public int getVendorId() {
        return vendorId;
    }

    public String getTravelsName() {
        return travelsName;
    }

    public boolean validatePassword(String inpPassword) {
        return this.password.equals(inpPassword);
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void displayBuses() {
        if(buses.isEmpty()) {
            System.out.println("No Bus Found For The Travels");
            return;
        }
        System.out.println("Bus Available for " + travelsName);
        for(Bus bus : buses) {
            System.out.println(bus);
        }
    }

    public void removeBus(int busId) {
        for (int i = 0; i < buses.size(); i++) {
            if(buses.get(i).getBusId() == busId) {
                buses.remove(i);
                System.out.println("Bus Removed Successfully");
                return;
            }
        }
        System.out.println("Bus Not Found");
    }

    public void viewReservations(int busId,ReservationSystem system) {
        for(Bus b : buses) {
            if(b.getBusId() == busId) {
                System.out.println("Reservation List Of Users " + b.getBusName() + " " + b.getBusId());
                system.displayUsers(busId);
                return;
            }
        }
        System.out.println("Bus Not Found For this Vendor");
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorId=" + vendorId +
                ", travelsName='" + travelsName + '\'' +
                ", buses =" + buses +
                ", busesCount=" + buses.size() +
                '}';
    }
}
