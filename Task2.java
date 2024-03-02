import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> subjectsList = new ArrayList<>();
    private static ArrayList<Double> subjectMarksList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the GRADE CALCULATOR!");
        System.out.println("Enter your name: ");
        String studentName = scanner.nextLine();
        System.out.println();

        // Loop until the user chooses to begin calculations
        while (!beginCalculations()) {
            addSubjectAndMark();
        }

        // Calculate total marks and average percentage
        double totalMarks = calculateTotalMarks();
        double averagePercent = totalMarks / subjectsList.size();

        // Determine final grade
        String grade = calculateGrade(averagePercent);

        // Display results
        displayResults(studentName, totalMarks, averagePercent, grade);
    }

    private static boolean beginCalculations() {
        System.out.println("(A)dd subject | (B)egin calculations ");
        String mainMenuSelection = scanner.nextLine();

        if (mainMenuSelection.equalsIgnoreCase("b")){
            if (subjectsList.isEmpty()) {
                System.out.println("No subjects added. Please add at least one subject.");
                return false;
            } else {
                System.out.println();
                return true;
            }
        }
        return false;
    }

    private static void addSubjectAndMark() {
        System.out.println("Enter subject: ");
        String subjectName = scanner.nextLine();
        subjectsList.add(subjectName);

        System.out.println("Enter subject mark: ");
        try {
            double subjectMark = scanner.nextDouble();
            scanner.nextLine();
            subjectMarksList.add(subjectMark);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        System.out.println();
    }

    private static double calculateTotalMarks() {
        double totalMarks = 0;
        for (double subjectMark : subjectMarksList) {
            totalMarks += subjectMark;
        }
        return totalMarks;
    }

    private static String calculateGrade(double averagePercent) {
        if (averagePercent >= 80){
            return "A (Pass)";
        }
        else if (averagePercent >= 60) {
            return "B (Pass)";
        }
        else if (averagePercent >= 40) {
            return "C (Pass)";
        }
        else {
            return "F (Fail)";
        }
    }

    private static void displayResults(String studentName, double totalMarks, double averagePercent, String grade) {
        System.out.println(studentName + ", here are your results:");
        System.out.println("Total marks of all subjects - " + totalMarks);
        System.out.println("Average Percent - " + averagePercent + "%");
        System.out.println("Final grade - " + grade);
    }
}
