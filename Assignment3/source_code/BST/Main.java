/* Shaheryar Syed
 * TA: Harnoor K.
 * UCID: 30052162
 * Question 1 - BST 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;


 public class Main {
 
    public static int g (int n) {

        Random number = new Random();

        int generatedNumber = number.nextInt(n+1);

        return generatedNumber;
    }

    public static int ge (int n) {

        Random number = new Random();

        int generatedNumber = number.nextInt(n+1);

        if ((generatedNumber & 1) == 0) {
            return generatedNumber;
        }
        else {
            return ge(n);
        }
    }


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /* Part 1 */
        BinarySearchTree T0 = new BinarySearchTree<>();
        ArrayList<InsertTracker> plot = new ArrayList<>();

        int uniqueInserts = 0;

        while (uniqueInserts < 100) {
            int uniqueNumber = g(300);
            if (!T0.contains(uniqueNumber)) {
                T0.add(uniqueNumber);
                uniqueInserts++;
            }
        }

        /* Part 2 */

        List<Integer> oddNumbers = T0.oddValues();
        for (int number : oddNumbers) {
            T0.remove(number);
        }

        /* Part 3 */
        uniqueInserts = 0;

        while (uniqueInserts < 75) {
            int ri = g(300);

            if (!T0.contains(ri)) {
                int height = T0.getHeight(T0);

                long start = System.nanoTime();
                T0.add(ri);
                long end = System.nanoTime();

                plot.add(new InsertTracker(height, end-start));
                uniqueInserts++;
                
            }

        }

        /* Part 4 */
        double[] time = new double[plot.size()];
        double[] height = new double[plot.size()];

        for (int i = 0; i < plot.size(); i++) {
            InsertTracker tracker = plot.get(i);
            time[i] = (double)tracker.getTime();
            height[i] = (double)tracker.getHeight();
        }

        XYChart chart = new XYChartBuilder()
        .width(800)
        .height(600)
        .title("BSTree Insertion Time vs. Tree Height")
        .xAxisTitle("Time (ns)")
        .yAxisTitle("Height")
        .build();

        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(true);
        chart.getStyler().setLegendVisible(false);
        chart.getStyler().setMarkerSize(6);

        XYSeries series = chart.addSeries("Insertion Data", time, height);
        series.setMarker(SeriesMarkers.CIRCLE);

        new SwingWrapper(chart).displayChart();

    }
 }