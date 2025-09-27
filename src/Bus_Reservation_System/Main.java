package Bus_Reservation_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        ReservationSystem system = new ReservationSystem();

        // Sample vendors
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(new Vendor(1, "pass1", "TN Travels"));
        vendors.add(new Vendor(2, "pass2", "Express Travels"));

        // Sample users
        system.addUser(new User(1, "Siva", "Aadhar", "user1"));
        system.addUser(new User(2, "Ganesh", "Passport", "user2"));


        while (true) {
            System.out.println("\n--- Bus Reservation System ---");
            System.out.println("1. Vendor Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            int choice = inp.nextInt();
            inp.nextLine(); // consume newline

            switch (choice) {
                case 1: // Vendor login
                    System.out.print("Enter Vendor ID: ");
                    int vId = inp.nextInt();
                    inp.nextLine();
                    System.out.print("Enter Password: ");
                    String vPass = inp.nextLine();

                    Vendor currentVendor = null;
                    for (Vendor v : vendors) {
                        if (v.getVendorId() == vId && v.validatePassword(vPass)) {
                            currentVendor = v;
                            break;
                        }

                    }
                    if (currentVendor == null) {
                        System.out.println("Invalid Vendor Credentials!");
                        break;
                    }

                    // Vendor menu
                    while (true) {
                        System.out.println("\n--- Vendor Menu (" + currentVendor.getTravelsName() + ") ---");
                        System.out.println("1. Add Bus");
                        System.out.println("2. Display Buses");
                        System.out.println("3. View Reservations for a Bus");
                        System.out.println("4. Remove Bus");
                        System.out.println("5. Logout");
                        System.out.print("Enter Choice: ");
                        int vChoice = inp.nextInt();
                        inp.nextLine();

                        switch (vChoice) {
                            case 1: // Add bus
                                System.out.print("Enter Bus ID: ");
                                int busId = inp.nextInt();
                                inp.nextLine();
                                System.out.print("Enter Bus Name: ");
                                String busName = inp.nextLine();
                                System.out.print("Enter Source: ");
                                String source = inp.nextLine();
                                System.out.print("Enter Destination: ");
                                String destination = inp.nextLine();
                                System.out.print("Enter Capacity: ");
                                int capacity = inp.nextInt();
                                inp.nextLine();

                                System.out.print("Enter Boarding Points (comma separated): ");
                                String boardingStr = inp.nextLine();
                                List<String> boardingPoints = new ArrayList<>();
                                for (String s : boardingStr.split(",")) boardingPoints.add(s.trim());

                                System.out.print("Enter Dropping Points (comma separated): ");
                                String droppingStr = inp.nextLine();
                                List<String> droppingPoints = new ArrayList<>();
                                for (String s : droppingStr.split(",")) droppingPoints.add(s.trim());

                                Bus newBus = new Bus(busId, busName, source, destination, capacity, new ArrayList<>(boardingPoints), new ArrayList<>(droppingPoints));

                                currentVendor.addBus(newBus);
                                system.addBus(newBus);
                                System.out.println("Bus Added Successfully!");
                                break;

                            case 2:
                                currentVendor.displayBuses();
                                break;

                            case 3:
                                System.out.print("Enter Bus ID to view reservations: ");
                                int rBusId = inp.nextInt();
                                inp.nextLine();
                                currentVendor.viewReservations(rBusId, system);

                                break;

                            case 4:
                                System.out.print("Enter Bus ID to remove: ");
                                int remBusId = inp.nextInt();
                                inp.nextLine();
                                currentVendor.removeBus(remBusId);
                                break;

                            case 5:
                                System.out.println("Logging out Vendor...");
                                break;

                            default:
                                System.out.println("Invalid Choice!");
                        }
                        if (vChoice == 5) break;
                    }
                    break;

                case 2: // User login
                    System.out.print("Enter User ID: ");
                    int uId = inp.nextInt();
                    inp.nextLine();
                    System.out.print("Enter Password: ");
                    String uPass = inp.nextLine();

                    User currentUser = null;
                    for (User u : system.getUsers()) {
                        if (u.getUserId() == uId && u.validatePassword(uPass)) {
                            currentUser = u;
                            break;
                        }
                    }
                    if (currentUser == null) {
                        System.out.println("Invalid User Credentials!");
                        break;
                    }

                    // User menu
                    while (true) {
                        System.out.println("\n--- User Menu (" + currentUser.getUserName() + ") ---");
                        System.out.println("1. View Buses");
                        System.out.println("2. Book Seat");
                        System.out.println("3. View My Reservations");
                        System.out.println("4. Cancel Reservation");
                        System.out.println("5. Logout");
                        System.out.print("Enter Choice: ");
                        int uChoice = inp.nextInt();
                        inp.nextLine();

                        switch (uChoice) {
                            case 1:
                                system.displayBuses();
                                break;

                            case 2:
                                System.out.print("Enter Bus ID to book: ");
                                int bookBusId = inp.nextInt();
                                //inp.nextLine();
                                Bus bookBus = null;
                                for (Bus b : system.getBuses()) {
                                    if (b.getBusId() == bookBusId) {
                                        bookBus = b;
                                        break;
                                    }
                                }
                                if (bookBus != null) {
                                    System.out.println("Enter Boarding Point");
                                    String b = inp.next();
                                    System.out.println("Enter DroppingPoint");
                                    String d = inp.next();
                                    system.bookSeat(currentUser, bookBus,b,d);
                                } else {
                                    System.out.println("Bus not found!");
                                }
                                break;

                            case 3:
                                System.out.println("Your Reservations:");
                                for (Reservation r : system.getReservations()) {
                                    if (r.getUser().getUserId() == currentUser.getUserId()) {
                                        System.out.println(r);
                                    }
                                }
                                break;

                            case 4:
                                System.out.print("Enter Reservation ID to cancel: ");
                                int cancelId = inp.nextInt();
                                inp.nextLine();
                                for (Reservation r : system.getReservations()) {
                                    if (r.getReservationId() == cancelId && r.getUser().getUserId() == currentUser.getUserId()) {
                                        system.cancelSeat(cancelId);
                                        break;
                                    }
                                }
                                break;

                            case 5:
                                System.out.println("Logging out User...");
                                break;

                            default:
                                System.out.println("Invalid Choice!");
                        }
                        if (uChoice == 5) break;
                    }
                    break;

                case 3:
                    System.out.println("Exiting System. Thank You!");
                    inp.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
