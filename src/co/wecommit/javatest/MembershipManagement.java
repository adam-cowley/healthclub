package co.wecommit.javatest;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

    final private Scanner scanner = new Scanner(System.in);

    int getIntInput() {
        int choice = 0;

        while (choice == 0) {
            try {
                choice = scanner.nextInt();

                if (choice == 0) {
                    throw new InputMismatchException();
                }

                scanner.nextLine();
            }
            catch(InputMismatchException e){
                scanner.nextLine();

                System.out.println(e.getMessage());
                System.out.println("INVALID INPUT.  Please try again:");
            }
        }

        return choice;

    }

    void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        System.out.println("Welcome to HealthClub");
        System.out.println("===============================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("");
        System.out.println("Please select an option (or Enter -1 to quit):");

        return getIntInput();
    }

    public Member addMember(LinkedList<Member> members) {
        String name;
        int club;
        double fees;
        int memberID;
        Member member;
        Calculator<Integer> calculator;

        // Get Name
        System.out.println("Please enter the Member's name");
        name = scanner.nextLine();

        // Get Club Access
        System.out.println("Please enter the Member's club access");
        printClubOptions();

        club = getIntInput();

        while (club < 1 || club > 4) {
            System.out.println("Club ID is invalid.  Please enter a valid club ID");

            printClubOptions();
            club = getIntInput();
        }

        // Calculate Member ID
        memberID = members.size() > 0 ? members.getLast().getMemberID() + 1 : 1;

        // Instantiate
        if (club != 4) {
            calculator = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };

            fees = calculator.calculateFees(club);

            member = new SingleClubMember('S', memberID, name, fees, club);
        }
        else {
            calculator = (n) -> n == 4 ? 1200 : -1;

            fees = calculator.calculateFees(club);

            member = new MultiClubMember('M', memberID, name, fees, club);
        }

        members.add(member);

        System.out.println("\nMember "+ member.getName() +" added");

        return member;
    }

    public void removeMember(LinkedList<Member> members) {
        System.out.println("\nPlease enter a Member ID to remove");

        int memberID = getIntInput();

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberID() == memberID) {
                members.remove(i);

                System.out.println("\nMember removed from list");

                return;
            }
        }

        System.out.println("\nMCouldn't find member with ID " + memberID);
    }

    public void printMemberInfo(LinkedList<Member> members) {
        System.out.println("\nWhich member would you like to display?");

        int memberID = getIntInput();

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberID() == memberID) {

                System.out.println("\nMember "+ memberID);
                System.out.println(members.get(i).toString());

                return;
            }
        }

        System.out.println("\nMCouldn't find member with ID " + memberID);

    }
}
