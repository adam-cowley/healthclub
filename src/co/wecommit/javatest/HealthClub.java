package co.wecommit.javatest;

import java.util.LinkedList;

public class HealthClub {

    public static void main(String[] args) {
        String filename = "members.txt";
        MembershipManagement manager = new MembershipManagement();
        FileHandler filehandler = new FileHandler();

        LinkedList<Member> members = filehandler.readFile(filename);

        int choice = manager.getChoice();

        while (choice != -1) {
            switch (choice) {
                case 1:
                    Member member = manager.addMember(members);
                    filehandler.appendFile(filename, member);
                    break;
                case 2:
                    manager.removeMember(members);
                    filehandler.overwriteFile(filename, members);
                    break;
                case 3:
                    manager.printMemberInfo(members);
                    break;
                default:
                    System.out.println("You have selected an invalid option.");
                    break;
            }

            choice = manager.getChoice();
        }

    }
}
