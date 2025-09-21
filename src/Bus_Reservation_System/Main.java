package Bus_Reservation_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        ReservationSystem system = new ReservationSystem();

        system.addBus(new Bus(1, "TNSTC Express", "Coimbatore", "Karaikudi", 50));
        system.addBus(new Bus(2, "TNSTC Super Fast", "Karaikudi", "Coimbatore", 50));

        system.addUser(new User(1, "Siva", "Aadhar"));
        system.addUser(new User(2, "Ganesh", "Passport"));

        while (true) {

            System.out.println("\n--- Bus Reservation System Menu ---");
            System.out.println("1. Add Bus");
            System.out.println("2. Add User");
            System.out.println("3. Display Buses");
            System.out.println("4. Display Users");
            System.out.println("5. Book Seat");
            System.out.println("6. Display Reservations");
            System.out.println("7. Cancel Reservation");
            System.out.println("8. Exit");
            System.out.print("Enter Your Choice : ");

            int ch = inp.nextInt();
            inp.nextLine(); // consume leftover newline after choice

            switch (ch) {
                case 1:
                    System.out.print("Enter Bus ID: ");
                    int busId = inp.nextInt();
                    inp.nextLine();
                    System.out.print("Enter Bus Name: ");
                    String busName = inp.nextLine();
                    System.out.print("Enter Source: ");
                    String source = inp.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = inp.nextLine();
                    System.out.print("Enter Bus Capacity: ");
                    int capacity = inp.nextInt();
                    inp.nextLine();

                    system.addBus(new Bus(busId, busName, source, destination, capacity));
                    System.out.println("Bus Added Successfully");
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = inp.nextInt();
                    inp.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = inp.nextLine();
                    System.out.print("Enter User Identity Proof: ");
                    String identityProof = inp.nextLine();

                    system.addUser(new User(userId, userName, identityProof));
                    System.out.println("User Added Successfully");
                    break;

                case 3:
                    system.displayBuses();
                    break;

                case 4 :
                    system.displayUsers();
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int uId = inp.nextInt();
                    System.out.print("Enter Bus ID: ");
                    int bId = inp.nextInt();
                    inp.nextLine();

                    User user = null;
                    Bus bus = null;

                    for (User u : system.getUsers()) {
                        if (u.getUserId() == uId) {
                            user = u;
                            break;
                        }
                    }

                    for (Bus b : system.getBuses()) {
                        if (b.getBusId() == bId) {
                            bus = b;
                            break;
                        }
                    }

                    if (user != null && bus != null) {
                        system.bookSeat(user, bus);
                    } else {
                        System.out.println("Invalid User ID or Bus ID");
                    }
                    break;

                case 6:
                    system.displayReservations();
                    break;

                case 7:
                    System.out.print("Enter Reservation ID: ");
                    int rId = inp.nextInt();
                    inp.nextLine(); // consume leftover newline
                    system.cancelSeat(rId);
                    break;

                case 8:
                    System.out.println("--- Thank You! Exiting system ---");
                    inp.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice! Select Correct Option");
            }
        }
    }
}

