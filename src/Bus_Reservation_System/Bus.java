package Bus_Reservation_System;

public class Bus {

    private final int busId;
    private String busName;
    private String source;
    private String destination;
    private final int capacity;

    public Bus(int busId, String busName, String source, String destination, int capacity) {
        this.busId = busId;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
    }

    public int getBusId() {
        return busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bus { " +
                "busId = " + busId +
                ", busName = '" + busName + '\'' +
                ", source = '" + source + '\'' +
                ", destination = '" + destination + '\'' +
                ", capacity = " + capacity +
                " }";
    }
}

