package ir.ac.kntu;

import ir.ac.kntu.Model.*;

import java.text.SimpleDateFormat;
import java.util.Random;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Menu {
    private AliBaba aliBaba;
    private Scanner scanner;
    java.sql.Date sqlDate;

    public Menu(AliBaba aliBaba) {
        this.aliBaba = aliBaba;
        scanner = new Scanner(System.in);
        sqlDate = new java.sql.Date(new java.util.Date().getTime());
    }

    public void printMenu() {
        System.out.println("-----------------------------Welcome To AliBaba!--------------------------");
        System.out.println("Who Are You?");
        System.out.println("1: Admin\n2: User\n3: Exit");
        switch (scanner.nextLine()) {
            case "1": printAdminMenu();
                break;
            case "2": printUserMenu();
                break;
            case "3": scanner.close();
                System.exit(0);
        }
    }

    public void printAdminMenu() {
        System.out.println("-----------------------------Welcome To AliBaba!/AdminMode--------------------------");
        System.out.println("What do you want to edit?\n1: Bus\n2: Flight\n3: Hotel\n4: Infos\n5: Back");
        printAdminControlMenu(scanner.nextLine());
    }

    public void printUserMenu() {
        System.out.println("-----------------------------Welcome To AliBaba!/UserMode--------------------------");
        System.out.println("What do you want to do?\n1: Bus\n2: Flight\n3: Hotel\n4: Infos\nBack");
        printUserControlMenu(scanner.nextLine());
    }

    public void printAdminControlMenu(String mode) {
        switch (mode) {
            case "1":
                System.out.println("-----------------------------Welcome To AliBaba!/AdminMode/Bus--------------------------");
                System.out.println("What do you want to do?\n1: Find all buses\n2: Find a bus by ID\n3: Find buses by IDs\n" +
                        "4: Delete a bus by ID\n5: Delete buses by Ids\n6: Add new Bus\n" +
                        "7: Find all tickets\n8: Find a ticket by ID\n9: Find tickets by IDs\n" +
                        "10: Find all reservations\n11: Find a reservation by ID\n12: Find reservations by IDs" +
                        "\n13: back");
                switch (scanner.nextLine()) {
                    case "1":
                        aliBaba.findAll("B");
                        break;
                    case "2":
                        System.out.println("Enter the ID:");
                        Integer in = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("B", in);
                        break;
                    case "3":
                        System.out.println("Enter length and IDs:");
                        int len = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids = new ArrayList<>();
                        for (int i = 0; i < len; i++) {
                            ids.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("B", ids);
                        break;
                    case "4":
                        System.out.println("Enter the ID:");
                        Integer in1 = Integer.valueOf(scanner.nextLine());
                        aliBaba.deleteByID("B", in1);
                        break;
                    case "5":
                        System.out.println("Enter length and IDs:");
                        int len1 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids1 = new ArrayList<>();
                        for (int i = 0; i < len1; i++) {
                            ids1.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.deleteByIDs("B", ids1);
                        break;
                    case "6":
                        System.out.println("Enter bus infos:   id/dep_city/dep_terminal/des_city/des_terminal/date/capacity");
                        aliBaba.save("B", new Bus(Integer.valueOf(scanner.nextLine()), scanner.nextLine(),
                                scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), Date.valueOf(scanner.nextLine()),
                                Integer.valueOf(scanner.nextLine())));
                        break;
                    case "7":
                        aliBaba.findAll("BT");
                        break;
                    case "8":
                        System.out.println("Enter the ID:");
                        Integer in2 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("BT", in2);
                        break;
                    case "9":
                        System.out.println("Enter length and IDs:");
                        int len2 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids2 = new ArrayList<>();
                        for (int i = 0; i < len2; i++) {
                            ids2.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("BT", ids2);
                        break;
                    case "10":
                        aliBaba.findAll("BR");
                        break;
                    case "11":
                        System.out.println("Enter the ID:");
                        Integer in3 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("BR", in3);
                        break;
                    case "12":
                        System.out.println("Enter length and IDs:");
                        int len3 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids3 = new ArrayList<>();
                        for (int i = 0; i < len3; i++) {
                            ids3.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("BR", ids3);
                        break;
                    case "13":
                        printAdminMenu();
                        break;
                }
                break;
            case "2":
                System.out.println("-----------------------------Welcome To AliBaba!/AdminMode/Flight--------------------------");
                System.out.println("What do you want to do?\n1: Find all flights\n2: Find all international flights\n" +
                        "3: Find all domestic flights\n4: Find a flight by ID\n5: Find flights by IDs\n" +
                        "6: Delete a flight by ID\n7: Delete flights by IDs\n8: Add new international flight\n" +
                        "9: Add new domestic flight\n10: Find all tickets\n11: Find a ticket by ID\n" +
                        "12: Find tickets by IDs\n13: Find all reservations\n14: Find a reservation by ID\n" +
                        "15: Find reservations by IDs\n16: back");
                switch (scanner.nextLine()) {
                    case "1":
                        aliBaba.findAll("F");
                        break;
                    case "2":
                        aliBaba.findAll("I");
                        break;
                    case "3":
                        aliBaba.findAll("D");
                        break;
                    case "4":
                        System.out.println("Enter the ID:");
                        Integer in = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("F", in);
                        break;
                    case "5":
                        System.out.println("Enter length and IDs:");
                        int len = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids = new ArrayList<>();
                        for (int i = 0; i < len; i++) {
                            ids.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("F", ids);
                        break;
                    case "6":
                        System.out.println("Enter the ID:");
                        Integer in1 = Integer.valueOf(scanner.nextLine());
                        aliBaba.deleteByID("F", in1);
                        break;
                    case "7":
                        System.out.println("Enter length and IDs:");
                        int len1 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids1 = new ArrayList<>();
                        for (int i = 0; i < len1; i++) {
                            ids1.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.deleteByIDs("F", ids1);
                        break;
                    case "8":
                        System.out.println("Enter international flight infos:   id/dep_city/dep_airport/des_city/" +
                                "des_airport/date/capacity");
                        aliBaba.save("I", new International(Integer.valueOf(scanner.nextLine()), scanner.nextLine(),
                                scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), Date.valueOf(scanner.nextLine()),
                                Integer.valueOf(scanner.nextLine())));
                        break;
                    case "9":
                        System.out.println("Enter domestic infos:   id/dep_city/dep_airport/des_city/des_airport" +
                                "/date/capacity");
                        aliBaba.save("D", new Domestic(Integer.valueOf(scanner.nextLine()), scanner.nextLine(),
                                scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), Date.valueOf(scanner.nextLine()),
                                Integer.valueOf(scanner.nextLine())));
                        break;
                    case "10":
                        aliBaba.findAll("FT");
                        break;
                    case "11":
                        System.out.println("Enter the ID:");
                        Integer in2 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("FT", in2);
                        break;
                    case "12":
                        System.out.println("Enter length and IDs:");
                        int len2 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids2 = new ArrayList<>();
                        for (int i = 0; i < len2; i++) {
                            ids2.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("FT", ids2);
                        break;
                    case "13":
                        aliBaba.findAll("FR");
                        break;
                    case "14":
                        System.out.println("Enter the ID:");
                        Integer in3 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("FR", in3);
                        break;
                    case "15":
                        System.out.println("Enter length and IDs:");
                        int len3 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids3 = new ArrayList<>();
                        for (int i = 0; i < len3; i++) {
                            ids3.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("FR", ids3);
                        break;
                    case "16":
                        printAdminMenu();
                        break;
                }
                break;
            case "3":
                System.out.println("-----------------------------Welcome To AliBaba!/AdminMode/Hotel--------------------------");
                System.out.println("What do you want to do?\n1: Find all hotels\n2: Find all rooms\n" +
                        "3: Find a hotel by ID\n4: Find hotels by IDs\n5: Find a room by ID\n" +
                        "6: Find rooms by IDs\n7: Delete a hotel by ID\n8: Delete hotels by Ids\n" +
                        "9: Delete a room by ID\n10: Delete rooms by IDs" +
                        "\n11: Add new hotel\n12: Add new room\n13: Find all tickets\n14: Find a ticket by ID\n" +
                        "15: Find tickets by IDs\n16: Find all reservations\n17: Find a reservation by ID" +
                        "\n18: Find reservations by IDs\n19: back");
                switch (scanner.nextLine()) {
                    case "1":
                        aliBaba.findAll("H");
                        break;
                    case "2":
                        aliBaba.findAll("R");
                        break;
                    case "3":
                        System.out.println("Enter the ID:");
                        Integer in = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("H", in);
                        break;
                    case "4":
                        System.out.println("Enter length and IDs:");
                        int len = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids = new ArrayList<>();
                        for (int i = 0; i < len; i++) {
                            ids.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("H", ids);
                        break;
                    case "5":
                        System.out.println("Enter the ID:");
                        Integer in1 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("R", in1);
                        break;
                    case "6":
                        System.out.println("Enter length and IDs:");
                        int len1 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids1 = new ArrayList<>();
                        for (int i = 0; i < len1; i++) {
                            ids1.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("R", ids1);
                        break;
                    case "7":
                        System.out.println("Enter the ID:");
                        Integer in2 = Integer.valueOf(scanner.nextLine());
                        aliBaba.deleteByID("H", in2);
                        break;
                    case "8":
                        System.out.println("Enter length and IDs:");
                        int len2 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids2 = new ArrayList<>();
                        for (int i = 0; i < len2; i++) {
                            ids2.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.deleteByIDs("H", ids2);
                        break;
                    case "9":
                        System.out.println("Enter the ID:");
                        Integer in3 = Integer.valueOf(scanner.nextLine());
                        aliBaba.deleteByID("R", in3);
                        break;
                    case "10":
                        System.out.println("Enter length and IDs:");
                        int len3 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids3 = new ArrayList<>();
                        for (int i = 0; i < len3; i++) {
                            ids3.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.deleteByIDs("R", ids3);
                        break;
                    case "11":
                        System.out.println("Enter hotel infos:   id/stars/popularity/address/name" +
                                "/facilities/HotelTypeNum");
                        aliBaba.save("H", new Hotel(Integer.valueOf(scanner.nextLine()), Integer.valueOf(scanner.nextLine()),
                                Integer.valueOf(scanner.nextLine()), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                                Integer.valueOf(scanner.nextLine())));
                        break;
                    case "12":
                        System.out.println("Enter room infos:   id/hotelID/dep_terminal/type/capacity");
                        aliBaba.save("R", new Room(Integer.valueOf(scanner.nextLine()), Integer.valueOf(scanner.nextLine()),
                                scanner.nextLine(), Integer.valueOf(scanner.nextLine())));
                        break;
                    case "13":
                        aliBaba.findAll("HT");
                        break;
                    case "14":
                        System.out.println("Enter the ID:");
                        Integer in4 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("HT", in4);
                        break;
                    case "15":
                        System.out.println("Enter length and IDs:");
                        int len4 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids4 = new ArrayList<>();
                        for (int i = 0; i < len4; i++) {
                            ids4.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("HT", ids4);
                        break;
                    case "16":
                        aliBaba.findAll("HR");
                        break;
                    case "17":
                        System.out.println("Enter the ID:");
                        Integer in5 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("HR", in5);
                        break;
                    case "18":
                        System.out.println("Enter length and IDs:");
                        int len5 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids5 = new ArrayList<>();
                        for (int i = 0; i < len5; i++) {
                            ids5.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("HR", ids5);
                        break;
                    case "19":
                        printAdminMenu();
                        break;
                }
                break;
            case "4":
                System.out.println("-----------------------------Welcome To AliBaba!/AdminMode/Infos--------------------------");
                System.out.println("What do you want to do?\n1: Find all transactions\n2: Find all users\n" +
                        "3: Find all user infos\n4: Find a transaction by ID\n5: Find a user by ID\n" +
                        "6: Find a user info by ID\n7: Find transactions by IDs\n8: Find users by IDs\n" +
                        "9: Find user infos by IDs\n10: Delete a transaction by ID" +
                        "\n11: Delete transactions by IDs\n12: Delete a user by ID\n13: Delete a users by IDs\n" +
                        "14: back");
                switch (scanner.nextLine()) {
                    case "1":
                        aliBaba.findAll("T");
                        break;
                    case "2":
                        aliBaba.findAll("U");
                        break;
                    case "3":
                        aliBaba.findAll("UI");
                        break;
                    case "4":
                        System.out.println("Enter the ID:");
                        Integer in = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("T", in);
                        break;
                    case "5":
                        System.out.println("Enter the ID:");
                        Integer in2 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("U", in2);
                        break;
                    case "6":
                        System.out.println("Enter the ID:");
                        Integer in3 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("UI", in3);
                        break;
                    case "7":
                        System.out.println("Enter length and IDs:");
                        int len = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids = new ArrayList<>();
                        for (int i = 0; i < len; i++) {
                            ids.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("T", ids);
                        break;
                    case "8":
                        System.out.println("Enter length and IDs:");
                        int len2 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids2 = new ArrayList<>();
                        for (int i = 0; i < len2; i++) {
                            ids2.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("U", ids2);
                        break;
                    case "9":
                        System.out.println("Enter length and IDs:");
                        int len3 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids3 = new ArrayList<>();
                        for (int i = 0; i < len3; i++) {
                            ids3.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.findByIDs("UI", ids3);
                        break;
                    case "10":
                        System.out.println("Enter the ID:");
                        Integer in1 = Integer.valueOf(scanner.nextLine());
                        aliBaba.deleteByID("T", in1);
                        break;
                    case "11":
                        System.out.println("Enter length and IDs:");
                        int len1 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids1 = new ArrayList<>();
                        for (int i = 0; i < len1; i++) {
                            ids1.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.deleteByIDs("T", ids1);
                        break;
                    case "12":
                        System.out.println("Enter the ID:");
                        Integer in4 = Integer.valueOf(scanner.nextLine());
                        aliBaba.deleteByID("U", in4);
                        break;
                    case "13":
                        System.out.println("Enter length and IDs:");
                        int len4 = Integer.valueOf(scanner.nextLine());
                        Collection<Integer> ids4 = new ArrayList<>();
                        for (int i = 0; i < len4; i++) {
                            ids4.add(Integer.valueOf(scanner.nextLine()));
                        }
                        aliBaba.deleteByIDs("U", ids4);
                        break;
                    case "14":
                        printAdminMenu();
                        break;
                }
                break;
            case "5":
                printMenu();
                break;
        }
        printAdminMenu();
    }

    public void printUserControlMenu(String mode) {
        String id="";
        String pass="";
        Integer uid=0;
        switch (mode) {
            case "1":
                System.out.println("-----------------------------Welcome To AliBaba!/UserMode/Bus--------------------------");
                System.out.println("What do you want to do?\n1: Find a bus by ID\n" +
                        "2: Find a ticket by ID\n3: Find a reservation by ID\n4: Find all tickets" +
                        "\n5: Reserve a bus ticket\n6: back");
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println("Enter the ID:");
                        Integer in = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("B", in);
                        break;
                    case "2":
                        System.out.println("Enter the ID:");
                        Integer in2 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("BT", in2);
                        break;
                    case "3":
                        System.out.println("Enter the ID:");
                        Integer in3= Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("BR", in3);
                        break;
                    case "5":
                        System.out.println("You must 1:login/2:register!");
                        switch (scanner.nextLine()) {
                            case "1":
                                System.out.println("Enter id & pass:");
                                id = scanner.nextLine();
                                pass = scanner.nextLine();
                                if (aliBaba.findByID("UI",Integer.valueOf(id))!=null &&
                                        aliBaba.user_infoDao().findPass(id).equals(pass)) {
                                    System.out.println("Login successful!");
                                } else {
                                    System.out.println("Login failed!");
                                    return;
                                }
                                break;
                            case "2":
                                System.out.println("Enter user infos: id/pass/email/phone/fullname/gender/birthdate");
                                id = scanner.nextLine();
                                pass = scanner.nextLine();
                                aliBaba.save("UI", new User_Info(id, scanner.nextLine(),
                                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                                        Date.valueOf(scanner.nextLine()), pass));
                                while (aliBaba.findByIDNoPrint("U", uid)!=null) {
                                    uid = new Random().nextInt(1000000);
                                }
                                aliBaba.save("U", new User(uid, 0, id,
                                        sqlDate));
                                break;
                        }
                        System.out.println("Enter the transaction infos: amount/cardNum/type");
                        Integer tid=0;
                        while (aliBaba.findByIDNoPrint("T", tid)!=null) {
                            tid = new Random().nextInt(1000000);
                        }
                        aliBaba.save("T", new Transaction(tid,
                                sqlDate, Integer.valueOf(scanner.nextLine()), scanner.nextLine(),
                                uid, scanner.nextLine()));
                        System.out.println("Enter the reservation infos: busTicketID");
                        Integer rid=0;
                        while (aliBaba.findByIDNoPrint("BR", rid)!=null) {
                            rid = new Random().nextInt(1000000);
                        }
                        aliBaba.save("BR", new Bus_Reservation(rid, Integer.valueOf(scanner.nextLine()),
                                uid, tid));
                        break;
                    case "4":
                        aliBaba.findAll("BT");
                        break;
                    case "6":
                        printUserMenu();
                        break;
                }
                break;
            case "2":
                System.out.println("-----------------------------Welcome To AliBaba!/UserMode/Flight--------------------------");
                System.out.println("What do you want to do?\n1: Find a flight by ID\n" +
                        "2: Find a ticket by ID\n3: Find a reservation by ID\n4: Find all tickets" +
                        "\n5: Reserve a flight ticket\n6: back");
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println("Enter the ID:");
                        Integer in = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("F", in);
                        break;
                    case "2":
                        System.out.println("Enter the ID:");
                        Integer in2 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("FT", in2);
                        break;
                    case "3":
                        System.out.println("Enter the ID:");
                        Integer in3= Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("FR", in3);
                        break;
                    case "5":
                        System.out.println("You must 1:login/2:register!");
                        switch (scanner.nextLine()) {
                            case "1":
                                System.out.println("Enter id & pass:");
                                id = scanner.nextLine();
                                pass = scanner.nextLine();
                                if (aliBaba.findByID("UI",Integer.valueOf(id))!=null &&
                                aliBaba.user_infoDao().findPass(id).equals(pass)) {
                                    System.out.println("Login successful!");
                                } else {
                                    System.out.println("Login failed!");
                                    return;
                                }
                                break;
                            case "2":
                                System.out.println("Enter user infos: id/pass/email/phone/fullname/gender/birthdate");
                                id = scanner.nextLine();
                                pass = scanner.nextLine();
                                aliBaba.save("UI", new User_Info(id, scanner.nextLine(),
                                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                                        Date.valueOf(scanner.nextLine()), pass));
                                while (aliBaba.findByIDNoPrint("U", uid)!=null) {
                                    uid = new Random().nextInt(1000000);
                                }
                                aliBaba.save("U", new User(uid, 0, id,
                                        sqlDate));
                                break;
                        }
                        System.out.println("Enter the transaction infos: amount/cardNum/type");
                        Integer tid=0;
                        while (aliBaba.findByIDNoPrint("T", tid)!=null) {
                            tid = new Random().nextInt(1000000);
                        }
                        aliBaba.save("T", new Transaction(tid,
                                sqlDate, Integer.valueOf(scanner.nextLine()), scanner.nextLine(), uid, scanner.nextLine()));
                        System.out.println("Enter the reservation infos: flightTicketID");
                        Integer rid=0;
                        while (aliBaba.findByIDNoPrint("FR", rid)!=null) {
                            rid = new Random().nextInt(1000000);
                        }
                        aliBaba.save("FR", new Bus_Reservation(rid, Integer.valueOf(scanner.nextLine()),
                                uid, tid));
                        break;
                    case "4":
                        aliBaba.findAll("FT");
                        break;
                    case "6":
                        printUserMenu();
                        break;
                }
                break;
            case "3":
                System.out.println("-----------------------------Welcome To AliBaba!/UserMode/Hotel--------------------------");
                System.out.println("What do you want to do?\n1: Find a hotel by ID\n" +
                        "2: Find a ticket by ID\n3: Find a reservation by ID\n4: Find all tickets" +
                        "\n5: Reserve a hotel ticket\n6: back");
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println("Enter the ID:");
                        Integer in = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("H", in);
                        break;
                    case "2":
                        System.out.println("Enter the ID:");
                        Integer in2 = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("HT", in2);
                        break;
                    case "3":
                        System.out.println("Enter the ID:");
                        Integer in3= Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("HR", in3);
                        break;
                    case "5":
                        System.out.println("You must 1:login/2:register!");
                        switch (scanner.nextLine()) {
                            case "1":
                                System.out.println("Enter id & pass:");
                                id = scanner.nextLine();
                                pass = scanner.nextLine();
                                if (aliBaba.findByID("UI",Integer.valueOf(id))!=null &&
                                        aliBaba.user_infoDao().findPass(id).equals(pass)) {
                                    System.out.println("Login successful!");
                                } else {
                                    System.out.println("Login failed!");
                                    return;
                                }
                                break;
                            case "2":
                                System.out.println("Enter user infos: id/pass/email/phone/fullname/gender/birthdate");
                                id = scanner.nextLine();
                                pass = scanner.nextLine();
                                aliBaba.save("UI", new User_Info(id, scanner.nextLine(),
                                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                                        Date.valueOf(scanner.nextLine()), pass));
                                while (aliBaba.findByIDNoPrint("U", uid)!=null) {
                                    uid = new Random().nextInt(1000000);
                                }
                                aliBaba.save("U", new User(uid, 0, id,
                                        sqlDate));
                                break;
                        }
                        System.out.println("Enter the transaction infos: amount/cardNum/type");
                        Integer tid=0;
                        while (aliBaba.findByIDNoPrint("T", tid)!=null) {
                            tid = new Random().nextInt(1000000);
                        }
                        aliBaba.save("T", new Transaction(tid,
                                sqlDate, Integer.valueOf(scanner.nextLine()), scanner.nextLine(), uid, scanner.nextLine()));
                        System.out.println("Enter the reservation infos: busTicketID");
                        Integer rid=0;
                        while (aliBaba.findByIDNoPrint("HR", rid)!=null) {
                            rid = new Random().nextInt(1000000);
                        }
                        aliBaba.save("HR", new Bus_Reservation(rid, Integer.valueOf(scanner.nextLine()),
                                uid, tid));
                        break;
                    case "4":
                        aliBaba.findAll("HT");
                        break;
                    case "6":
                        printUserMenu();
                        break;
                }
                break;
            case "4":
                System.out.println("-----------------------------Welcome To AliBaba!/UserMode/Infos--------------------------");
                System.out.println("What do you want to do?\n1: Find a transaction by ID\n" +
                        "2: Find a user by ID\n3: Find a user info by ID\n" +
                        "4: Edit user info\n5: back");
                System.out.println("You must 1:login/2:register!");
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println("Enter id & pass:");
                        id = scanner.nextLine();
                        pass = scanner.nextLine();
                        if (aliBaba.findByID("UI",Integer.valueOf(id))!=null &&
                                aliBaba.user_infoDao().findPass(id).equals(pass)) {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Login failed!");
                            return;
                        }
                        break;
                    case "2":
                        System.out.println("Enter user infos: id/pass/email/phone/fullname/gender/birthdate");
                        id = scanner.nextLine();
                        pass = scanner.nextLine();
                        aliBaba.save("UI", new User_Info(id, scanner.nextLine(),
                                scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                                Date.valueOf(scanner.nextLine()), pass));
                        while (aliBaba.findByIDNoPrint("U", uid)!=null) {
                            uid = new Random().nextInt(1000000);
                        }
                        aliBaba.save("U", new User(uid, 0, id,
                                sqlDate));
                        break;
                }
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println("Enter the ID:");
                        Integer in = Integer.valueOf(scanner.nextLine());
                        aliBaba.findByID("T", in);
                        break;
                    case "2":
                        aliBaba.findByID("U", uid);
                        break;
                    case "3":
                        aliBaba.findByID("UI", Integer.valueOf(id));
                        break;
                    case "4":
                        System.out.println("Enter new infos: pass/email/phone/fullname/gender/birthdate");
                        pass = scanner.nextLine();
                        aliBaba.save("UI", new User_Info(id, scanner.nextLine(), scanner.nextLine(),
                                scanner.nextLine(), scanner.nextLine(), Date.valueOf(scanner.nextLine()),
                                pass));
                    case "5":
                        printUserMenu();
                        break;
                }
            case "5":
                printMenu();
                break;
        }
        printUserMenu();
    }
}
