public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    /* Creates a LinearEquation object */
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    /* Calculates and returns the y-intercept of the line between (x1, y1) and
   (x2, y2), rounded to the nearest hundredth */
    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
   (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }
    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation() {
        String yInt;
        if (yIntercept() > 0) {
            yInt = "+ " + yIntercept();
        }
        else if (yIntercept() < 0) {
            yInt = "- " + Math.abs(yIntercept());
        }
        else {
            yInt = "";
        }
        int deltY = y2 - y1;
        int deltX = x2 - x1;
        if ((deltY) % (deltX) == 0) {
            if (deltY / deltX == 1) {
                return "y = x " + yInt;
            }
            else if (deltY / deltX == -1) {
                return "y = -x " + yInt;
            }
            else if (deltY / deltX == 0) {
                return "y = " + y1;
            }
            return "y = " + deltY / deltX + "x " + yInt;
        }
        else if (deltY < 0 && deltX < 0) {
            return "y = " + Math.abs(deltY) + "/" + Math.abs(deltX) + "x " + yInt;
        }
        else if (deltX < 0) {
            return "y = -" + deltY + "/" + Math.abs(deltX) + "x " + yInt;
        }
        else if (deltY / deltX == 1 && yIntercept() == 0) {
            return "y = " + deltY + "/" + deltX + "x";
        }
        return "y = " + deltY + "/" + deltX + "x " + yInt;
    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        double yValue = slope() * xValue + yIntercept();
        return "(" + xValue + ", " + yValue + ")";
    }

    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound) {
        return (double) Math.round(toRound * 100) / 100;
    }

    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo() {
        if (x1 == x2) {
            return "These points are on a vertical line: x = " + x1;
        }
        else {
            return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\nThe equation of the line between these points is: " + equation() + "\nThe slope of this line is: " + slope() + "\nThe y-intercept of the line is: " + yIntercept() + "\nThe distance between the two points is: " + distance();
        }
    }
}
