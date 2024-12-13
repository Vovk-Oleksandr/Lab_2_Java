// клас University
public class University {
    private String name;

    // конструктор для ініціалізації назви університету
    public University(String name) {
        this.name = name;
    }

    // метод для управління подіями
    public void manageEvents() {
        // анонімний клас для обробки подій
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void handleEvent(String event) {
                System.out.println("Handling event: " + event + " at " + name);
            }
        };

        eventHandler.handleEvent("Conference");
        eventHandler.handleEvent("Seminar");
    }

    // внутрішній клас Department
    public class Department {
        private String departmentName;
        private String[] professors;

        public Department(String departmentName, String[] professors) {
            this.departmentName = departmentName;
            this.professors = professors;
        }

        public void showInfo() {
            System.out.println("Department: " + departmentName);
            System.out.println("Professors:");
            for (String professor : professors) {
                System.out.println("- " + professor);
            }
        }
    }

    // статичний вкладений клас Helper
    public static class Helper {
        public static double calculateAverageGrade(int[] grades) {
            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return grades.length > 0 ? (double) sum / grades.length : 0;
        }
    }

    // інтерфейс для анонімного класу
    interface EventHandler {
        void handleEvent(String event);
    }

    // основний метод програми
    public static void main(String[] args) {
        University university = new University("Tech University");

        // створення кафедри
        Department csDepartment = university.new Department("Computer Science", new String[]{"Dr. Smith", "Dr. Brown", "Dr. Johnson"});
        csDepartment.showInfo();

        // використання утилітного методу
        int[] studentGrades = {85, 90, 78, 92, 88};
        double average = University.Helper.calculateAverageGrade(studentGrades);
        System.out.println("Average grade: " + average);

        // управління подіями
        university.manageEvents();
    }
}
