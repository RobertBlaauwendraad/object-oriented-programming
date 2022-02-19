package geometric;

import java.util.Scanner;

public class GeometricUI {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    int number = scanner.nextInt();

    public GeometricUI() {
        startProgram();
        quit();
        showGeometrics();
        circle();
        rectangle();
        move();
        remove();
        sort();
    }

    private void startProgram() {
        System.out.println("Choose one of these commands (quit, show, circle, rectangle, move, remove, sort: ");
        switch (input) {
            case "quit":
                quit();
            case "show":
                showGeometrics();
            case "circle":
                circle();
            case "rectangle":
                rectangle();
            case "move":
                move();
            case "remove":
                remove();
            case "sort":
                sort();
        }
    }

    //break?
    private void quit() {

    }

    //show the whole array with the geometric objects
    private void showGeometrics() {

    }

    //put object in array
    private void circle() {
        System.out.println("Give the x coordinate of the centre: ");
        int x = number;
        System.out.println("Give the y coordinate of the centre: ");
        int y = number;
        System.out.println("Give the radius of the circle: ");
        int r = number;
    }

    //put object in arrau
    private void rectangle() {
        System.out.println("Give the width of the rectangle: ");
        int width = number;
        System.out.println("Give the height of the rectangle: ");
        int height = number;
        System.out.println("Give the x coordinate of the left corner of the rectangle: ");
        int x = number;
        System.out.println("Give the y coordinate of the left corner of the rectangle: ");
        int y = number;
    }

    //move object i in the array with dx and dy
    private void move() {
        System.out.println("How many steps you want to move the object horizontal? ");
        int dx = number;
        System.out.println("How many steps you want to move the object vertical? ");
        int dy = number;
    }

    //remove object i in the array (.remove?)
    private void remove() {

    }

    //(?)
    private void sort() {

    }
}
