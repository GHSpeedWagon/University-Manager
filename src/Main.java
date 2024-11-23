import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = new University("Tech University");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1 - Add Department");
            System.out.println("2 - Add Professor to Department");
            System.out.println("3 - View Departments");
            System.out.println("4 - Manage Events");
            System.out.println("5 - Calculate Average Score");
            System.out.println("6 - Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter department name: ");
                    String deptName = scanner.nextLine();
                    university.addDepartment(deptName);
                    System.out.println("Department added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter department name: ");
                    String deptName = scanner.nextLine();
                    System.out.print("Enter professor name: ");
                    String profName = scanner.nextLine();
                    university.addProfessorToDepartment(deptName, profName);
                }
                case 3 -> university.viewDepartments();
                case 4 -> university.manageEvents();
                case 5 -> {
                    System.out.print("Enter scores (comma-separated): ");
                    String[] scores = scanner.nextLine().split(",");
                    List<Integer> scoreList = new ArrayList<>();
                    for (String score : scores) {
                        scoreList.add(Integer.parseInt(score.trim()));
                    }
                    double average = University.Helper.calculateAverage(scoreList);
                    System.out.println("Average Score: " + average);
                }
                case 6 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Goodbye!");
    }
}