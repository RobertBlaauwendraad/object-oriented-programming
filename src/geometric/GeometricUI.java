package geometric;

import java.util.ArrayList;
import java.util.Scanner;

public class GeometricUI {
    private  static final int GEOMETRICS_CAPACITY = 10;
    private final ArrayList<Geometric> currentGeometrics = new ArrayList<>(GEOMETRICS_CAPACITY);

    public GeometricUI() {
        startProgram();
    }

    private void startProgram() {
        Scanner scanner = new Scanner(System.in);
        boolean hasBeenQuit = false;
        while(!hasBeenQuit) {
            System.out.println("Choose one the following commands: quit, show, circle, rectangle, move, remove, sort: ");
            String enteredCommand = scanner.next();
            switch (enteredCommand) {
                case "quit" -> hasBeenQuit = true;
                case "show" -> showGeometrics();
                case "circle" -> {
                    String xCircleString = scanner.next();
                    String yCircleString = scanner.next();
                    String rCircleString = scanner.next();
                    double xCircle = Double.parseDouble(xCircleString);
                    double yCircle = Double.parseDouble(yCircleString);
                    double rCircle = Double.parseDouble(rCircleString);
                    circle(xCircle, yCircle, rCircle);
                }
                case "rectangle" -> {
                    String xRectangleString = scanner.next();
                    String yRectangleString = scanner.next();
                    String wRectangleString = scanner.next();
                    String hRectangleString = scanner.next();
                    double xRectangle = Double.parseDouble(xRectangleString);
                    double yRectangle = Double.parseDouble(yRectangleString);
                    double wRectangle = Double.parseDouble(wRectangleString);
                    double hRectangle = Double.parseDouble(hRectangleString);
                    rectangle(xRectangle, yRectangle, wRectangle, hRectangle);
                }
                case "move" -> move();
                case "remove" -> remove();
                case "sort" -> sort();
            }
        }
    }

    //show the whole array with the geometric objects
    private void showGeometrics() {
        for (Geometric currentGeometric : currentGeometrics) {
            String geometricString = currentGeometric.toString(currentGeometrics.indexOf(currentGeometric));
            System.out.println(geometricString);
        }
    }

    //put object in array
    private void circle(double x, double y, double r) {
        Circle circle = new Circle(x, y, r);
        currentGeometrics.add(circle);
    }

    //put object in array
    private void rectangle(double x, double y, double width, double height) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        currentGeometrics.add(rectangle);
    }

    //move object i in the array with dx and dy
    private void move() {
    }

    //remove object i in the array (.remove?)
    private void remove() {

    }

    //(?)
    private void sort() {

    }
}
