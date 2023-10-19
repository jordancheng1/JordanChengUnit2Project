import java.util.Scanner;

public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            System.out.println("These points are on a vertical line: x = " + x1);
        }
        else {

        }
    }

    public double distance() {
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return distance;
    }

    public double yIntercept() {

    }

    public double slope() {
        double slope = (x2 - x1) / (y2 - y1);
        return slope;
    }


}
