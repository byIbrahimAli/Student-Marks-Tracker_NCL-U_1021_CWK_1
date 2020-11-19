/**
 * Student No: 150311564
 *
 * @author IbrahimAli Date: 5th November 2015
 */
public class StudentChart {

    public void draw(int[][] list) {
        //Draws x axis
        Bar xAxis = new Bar();
        xAxis.changeSize(200, 2);
        xAxis.makeVisible();
        xAxis.moveVertical(200);
        xAxis.moveHorizontal(-30);
        xAxis.changeColour(Colour.BLACK);
        //Draws y axis
        Bar yAxis = new Bar();
        yAxis.changeSize(2, 200);
        yAxis.makeVisible();
        yAxis.moveHorizontal(-30);
        yAxis.changeColour(Colour.BLACK);
        //Declaring bar for the modules
        Bar[] bar = new Bar[6];
        //Variables
        int horiz = -28;
        int[] modMarks = MarkCalculator.computeMarks(list);
        //Drawing bar/module
        for (int i = 0; i < 6; i++) {
            //Making new bar/module
            bar[i] = new Bar();
            bar[i].makeVisible();
            //Rectifying allignment issues
            int height = modMarks[i];
            final int width = 33;
            bar[i].changeSize(width, height);
            int vertic = 200 - modMarks[i];
            bar[i].moveVertical(vertic);
            bar[i].moveHorizontal(horiz);
            //if statement selecting colours dependant on module mark
            if (modMarks[i] >= 70) {
                bar[i].changeColour(Colour.MAGENTA);
            } else if (modMarks[i] >= 40) {
                bar[i].changeColour(Colour.GREEN);
            } else if (modMarks[i] >= 35) {
                bar[i].changeColour(Colour.YELLOW);
            } else {
                bar[i].changeColour(Colour.RED);
            }
            //Place @ end to prevent position issue
            horiz = horiz + width;
        }
    }

    //Constructor
    public StudentChart(int[][] list) {
        draw(list);
    }
    
    //Print Summary
    public void printSummary(String[] moduleName, int[][] list){
        int[] modMarks = MarkCalculator.computeMarks(list);
        
        //Print table
        for (int i=0; i<6; i++){
            System.out.format("%15.15s|%5d\n", moduleName[i], modMarks[i]);
        }
    }
}
