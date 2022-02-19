package geometric;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
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
                case "move" -> {
                    String indexString = scanner.next();
                    String dxString = scanner.next();
                    String dyString = scanner.next();
                    int index = Integer.parseInt(indexString);
                    double dx = Double.parseDouble(dxString);
                    double dy = Double.parseDouble(dyString);
                    move(index, dx, dy);
                }
                case "remove" -> {
                    String indexString = scanner.next();
                    int index = Integer.parseInt(indexString);
                    remove(index);
                }
                case "sort" -> {
                    String sortCriterion = scanner.nextLine();
                    // Removes all whitespaces and non-visible characters
                    sortCriterion = sortCriterion.replaceAll("\\s+","");
                    sort(sortCriterion);
                }
            }
        }
    }

    // Show characteristics of each geometric in array
    private void showGeometrics() {
        for (Geometric currentGeometric : currentGeometrics) {
            String geometricString = currentGeometric.toString(currentGeometrics.indexOf(currentGeometric));
            System.out.println(geometricString);
        }
    }

    // Add circle to array
    private void circle(double x, double y, double r) {
        Circle circle = new Circle(x, y, r);
        currentGeometrics.add(circle);
    }

    // Add rectangle to array
    private void rectangle(double x, double y, double width, double height) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        currentGeometrics.add(rectangle);
    }

    // Move geometric with given index in the array with dx and dy
    private void move(int index, double dx, double dy) {
        currentGeometrics.get(index).move(dx, dy);
    }

    // Remove geometric with given index from the array
    private void remove(int index) {
        currentGeometrics.remove(index);
    }

    // Sorts the array based on given criterion
    private void sort(String sortCriterion) {
        System.out.println(sortCriterion);
        if (sortCriterion.equals("x")) {
            currentGeometrics.sort(new GeometricComparatorByX());
        } else if (sortCriterion.equals("y")) {
            currentGeometrics.sort(new GeometricComparatorByY());
        } else {
            Collections.sort(currentGeometrics);
        }
    }
}
