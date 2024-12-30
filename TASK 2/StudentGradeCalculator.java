import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of subjects:");
        int noOfSubjects = sc.nextInt();
        StudentGradeCalculator obj = new StudentGradeCalculator();
        obj.calculateGrade(noOfSubjects);
        sc.close();
    }
    //method to calculate grade
       public void calculateGrade(int noOfSubjects) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[noOfSubjects];
        int totalMarks = 0;
        for (int i = 0; i<noOfSubjects; i++) {
            System.out.print("Enter marks for subject "+(i+1)+"(out of 100):");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }
        //Calculating grade based on average marks
        double average = (double)totalMarks / noOfSubjects;
        //Explicit type casting to avoid loss of data while converting int to double
        char grade;
        //Evaluating grade based on average marks
        if (average>= 90) {
            grade ='A';
        } else if (average >= 80) {
            grade ='B';
        } else if (average >= 70) {
            grade ='C';
        } else if (average >= 60) {
            grade ='D';
        } else {
            grade ='F';
        }
        //Displaying the result
        System.out.println("==========================");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average :" + average + "%");
        System.out.println("Grade: " + grade);
        System.out.println("==========================");
        sc.close();
    }
}