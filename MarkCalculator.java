
/**
 * Student No: 150311564
 *
 * @author IbrahimAli Date: 5th November 2015
 */
public class MarkCalculator {

    public static int[] computeMarks(int[][] list) {
        double computeMarks;
        int[] modMarks = new int[6];

        // Computed Module Mark
        for (int i = 0; i < 6; i++) {
            computeMarks = ((list[i][1] * 50) + (list[i][0] * (100 - 50))) / 100.0;
            modMarks[i] = (int) (computeMarks + 0.5);

            if (!(list[i][0] >= 35 && list[i][1] >= 35)) {
                modMarks[i] = Math.min(35, modMarks[i]);

            }
        }
        return modMarks;
    }

    public static String computeResult(int[][] list) {
        int modulesPassed = 0;
        int[] modMarks = computeMarks(list);

        // Output passed modules to modulesPassed
        for (int i = 0; i < 6; i++) {
            if (modMarks[i] >= 40) {
                modulesPassed = modulesPassed + 1;
            }

            // If any module failed output failed and return
            if (modMarks[i] < 35) {
                System.out.println("\n The student has failed the stage");
                return "Fail";
            }
        }
        // If all modules passed output x else y
        if (modulesPassed == 6) {
            System.out.println("\n The student has passed the stage");
            return "Pass";
        }

        // Pass by compensation
        int stageAverage = 0;
        int failCount = 0;

        // Calculate stage average
        for (int i = 0; i < 6; i++) {
            stageAverage = stageAverage + modMarks[i];
        }
        stageAverage = stageAverage / 6; // Average stage result
        // Calculate no of compensatable fails
        for (int i = 0; i < 6; i++) {
            if (modMarks[i] >= 35 && modMarks[i] < 40) {
                failCount = failCount + 1;
            }
        }

        // If statement for Pass By Compensation
        if (stageAverage >= 40 && failCount <= 2) {
            System.out.println("\n The student has passed the stage by compensation");
            return "Pass by Compensation";
        } else {
            System.out.println("\n The student has failed the stage");
            return "Fail";
        }
    }
}
