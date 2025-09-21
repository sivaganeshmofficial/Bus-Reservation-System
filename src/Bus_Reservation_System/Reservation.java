package Bus_Reservation_System;

public class Reservation {

    private final int reservationId;
    private User user;
    private Bus bus;
    private int seatNumber;

    public Reservation(int reservationId, User user, Bus bus, int seatNumber) {
        this.reservationId = reservationId;
        this.user = user;
        this.bus = bus;
        this.seatNumber = seatNumber;
    }

    public int getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return " Reservation { " +
                "reservationId = " + reservationId +
                ", user = " + user +
                ", bus = " + bus +
                ", seatNumber = " + seatNumber +
                " }";
    }
}

