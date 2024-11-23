import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class University {
    private final String name;
    private final List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addProfessorToDepartment(String departmentName, String professorName) {
        Department department = departments.stream()
                .filter(d -> d.getName().equals(departmentName))
                .findFirst()
                .orElse(null);

        if (department != null) {
            department.addProfessor(professorName);
            System.out.println("Professor added successfully!");
        } else {
            System.out.println("Department not found.");
        }
    }

    public void viewDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }

        for (Department department : departments) {
            System.out.println("Department: " + department.getName());
            System.out.println("Professors: " + String.join(", ", department.getProfessors()));
        }
    }

    public void manageEvents() {
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void handleEvent(String eventName) {
                System.out.println("Organizing event: " + eventName);
            }
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        eventHandler.handleEvent(eventName);
    }

    class Department {
        private final String name;
        private final List<String> professors;

        public Department(String name) {
            this.name = name;
            this.professors = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<String> getProfessors() {
            return professors;
        }

        public void addProfessor(String professor) {
            professors.add(professor);
        }
    }

    interface EventHandler {
        void handleEvent(String eventName);
    }

    static class Helper {
        public static double calculateAverage(List<Integer> scores) {
            return scores.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
        }
    }
}