package Bus_Reservation_System;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {

    private List<Bus> buses;
    private List<User> users;
    private List<Reservation> reservations;
    private int reservationCounter = 1;

    public ReservationSystem() {
        this.buses = new ArrayList<>();
        this.users = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayBuses() {
        for(Bus bus : buses) {
            System.out.println(bus);
        }
    }

    public void displayUsers() {
        for(User user : users) {
            System.out.println(user);
        }
    }

    public int getAvailableSeats(Bus bus) {
        int bookedSeats = 0;
        for (Reservation r : reservations) {
            if(r.getBus().getBusId() == bus.getBusId()) {
                bookedSeats++;
            }
        }
        return bus.getCapacity() - bookedSeats;
    }

    public void bookSeat(User user, Bus bus) {
        int availableSeats = getAvailableSeats(bus);
        if(availableSeats > 0) {
            int seatNumber = bus.getCapacity() - availableSeats + 1;
            Reservation reservation = new Reservation(reservationCounter++,user,bus,seatNumber);
            reservations.add(reservation);
            System.out.println("Reservation Confirmed " + reservation);
        }else{
            System.out.println("No Seats Available On The Bus " + bus.getBusName());
        }
    }

    public void displayReservations() {
        if(reservations.isEmpty()) {
            System.out.println("No Reservation Available");
        }
        else{
            for(Reservation r : reservations ) {
                System.out.println(r);
            }
        }
    }

    public void cancelSeat(int reservationId) {
        boolean found = false;
        if(reservations.isEmpty()) {
            System.out.println("No Reservation Available");
            return;
        }
        else {
            for (int i = 0; i < reservations.size();i++) {
                if(reservations.get(i).getReservationId() == reservationId) {
                    reservations.remove(i);
                    System.out.println("Reservation Cancelled Successfully ");
                    found = true;
                    break;
                }
            }
        }
        if(!found) {
            System.out.println("Reservation Id Not Found ");
        }
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public List<User> getUsers() {
        return users;
    }
}

