package student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    	System.out.println("Please enter the group size:");
        String groupSizeString = scanner.nextLine();
        int groupSize = Integer.parseInt(groupSizeString);
        Group group = new Group(groupSize);
        for (int i = 0; i < groupSize; i++) {
            System.out.println("Please enter a student:");
            String studentNumberString = scanner.next();
            int studentNumber = Integer.parseInt(studentNumberString);
            String firstName = scanner.next();
            String lastName = scanner.next();
            group.addStudent(studentNumber, firstName, lastName);
        }
         System.out.println("The group now contains:");
         String groupContents = group.groupContents();
         System.out.println(groupContents);
    }
}