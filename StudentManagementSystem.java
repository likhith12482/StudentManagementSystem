import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class to represent a Course with syllabus and exam details
class Course {
    private String name;
    private String syllabus;
    private String theoryExamDate;
    private String practicalExamDate;

    public Course(String name, String syllabus, String theoryExamDate, String practicalExamDate) {
        this.name = name;
        this.syllabus = syllabus;
        this.theoryExamDate = theoryExamDate;
        this.practicalExamDate = practicalExamDate;
    }

    public String getName() {
        return name;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public String getTheoryExamDate() {
        return theoryExamDate;
    }

    public String getPracticalExamDate() {
        return practicalExamDate;
    }

    @Override
    public String toString() {
        return "Course: " + name + "\nSyllabus: " + syllabus +
                "\nTheory Exam Date: " + theoryExamDate +
                "\nPractical Exam Date: " + practicalExamDate;
    }
}

// Class to manage courses and syllabi
class SyllabusManagementSystem {
    private List<Course> courses;

    public SyllabusManagementSystem() {
        courses = new ArrayList<>();
        // Predefined courses
        addCourse(new Course("Computer Science Fundamentals",
                "Introduction to programming, data structures, algorithms.",
                "2024-05-15", "2024-05-20"));
        addCourse(new Course("Mathematics for Computer Science",
                "Discrete mathematics, probability, linear algebra.",
                "2024-05-22", "2024-05-25"));
        addCourse(new Course("Database Management Systems",
                "SQL, normalization, transactions, database design.",
                "2024-05-30", "2024-06-01"));
    }

    // Add a course
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getName());
    }

    // Display course names only
    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }

    // Display theory exam dates
    public void viewTheoryExamDates() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("Theory Exam Dates:");
        for (Course course : courses) {
            System.out.println(course.getName() + ": " + course.getTheoryExamDate());
        }
    }

    // Display practical exam dates
    public void viewPracticalExamDates() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("Practical Exam Dates:");
        for (Course course : courses) {
            System.out.println(course.getName() + ": " + course.getPracticalExamDate());
        }
    }

    // Display syllabi
    public void viewSyllabi() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("Syllabi:");
        for (Course course : courses) {
            System.out.println(course.getName() + ": " + course.getSyllabus());
        }
    }
}

// Main class to run the application
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SyllabusManagementSystem sms = new SyllabusManagementSystem();

        while (true) {
            System.out.println("Syllabus Management System");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Exam Dates");
            System.out.println("   3.1 Practical Exam Dates");
            System.out.println("   3.2 Theory Exam Dates");
            System.out.println("4. View Syllabi");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter syllabus: ");
                    String syllabus = scanner.nextLine();
                    System.out.print("Enter theory exam date: ");
                    String theoryExamDate = scanner.nextLine();
                    System.out.print("Enter practical exam date: ");
                    String practicalExamDate = scanner.nextLine();
                    sms.addCourse(new Course(courseName, syllabus, theoryExamDate, practicalExamDate));
                    break;

                case 2:
                    sms.viewCourses();
                    break;

                case 3:
                    System.out.println("Exam Dates Menu:");
                    System.out.println("1. Practical Exam Dates");
                    System.out.println("2. Theory Exam Dates");
                    System.out.print("Choose an option: ");
                    int examChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (examChoice == 1) {
                        sms.viewPracticalExamDates();
                    } else if (examChoice == 2) {
                        sms.viewTheoryExamDates();
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;

                case 4:
                    sms.viewSyllabi();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
