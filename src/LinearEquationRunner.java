import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter coordinate 1: ");
        String coordinate1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coordinate2 = scan.nextLine();

        int x1 = Integer.parseInt(coordinate1.substring(1, coordinate1.indexOf(",")));
        int y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 2, coordinate1.indexOf(")")));
        int x2 = Integer.parseInt(coordinate2.substring(1, coordinate2.indexOf(",")));
        int y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",") + 2, coordinate2.indexOf(")")));

        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

        System.out.println();
        System.out.println("----- Line info -----");
        System.out.println(equation.lineInfo());
        System.out.println();

        if (x1 != x2) {
            System.out.print("Enter a value of x: ");
            double testX = scan.nextDouble();
            System.out.println("Coordinate for x: " + equation.coordinateForX(testX));
        }
    }
}
