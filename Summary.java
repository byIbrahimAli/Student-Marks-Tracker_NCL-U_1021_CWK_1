/**
 * Student No: 150311564
 *
 * @author IbrahimAli Date: 5th November 2015
 */
import java.util.Scanner;

public class Summary {

    public static void main(String[] args) {
        studentSummary();

    }

    public static void studentSummary() {
        // Suppresses in warning
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        String [] moduleName = new String [6];
        int[][] list = new int[6][2];

        // User entry for modules and marks
        for (int i = 0; i < 6; i++) {
            System.out.println("Enter module name and number");
            moduleName[i] = in.nextLine(); // Module name
            System.out.println("Enter exam mark");
            list[i][0] = in.nextInt(); // Exam mark
            System.out.println("Enter coursework mark");
            list[i][1] = in.nextInt(); // Coursework mark
            
            //Validation
            if (list[i][0]>100 || list[i][0]<0){
                System.out.println("Do not exceed 100 marks or go below 0 marks");
                System.exit(0);
            }
            if (list[i][1]>100 || list[i][1]<0){
                System.out.println("Do not exceed 100 marks or go below 0 marks");
                System.exit(0);
            }

            // Prevents for loop bug
            in.nextLine();
        }
        //Calls constructor
        StudentChart StuChart = new StudentChart(list);
        StuChart.printSummary(moduleName, list);
    }

}
