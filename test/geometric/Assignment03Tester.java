package geometric;

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment03Tester {
	private  static final int GEOMETRICS_CAPACITY = 10;
	private Geometric[] geometrics = new Geometric[GEOMETRICS_CAPACITY];
	private int lastModifiedGeometric = -1;
//	private ArrayList<Geometric> geometrics = new ArrayList<>(GEOMETRICS_CAPACITY);
	public Assignment03Tester() {
	}

	public void createCircle(double x, double y, double r) {
		geometrics[lastModifiedGeometric + 1] = new Circle(x, y, r);
		lastModifiedGeometric++;
	}

	public void createRectangle(double x, double y, double width, double height) {
		geometrics[lastModifiedGeometric + 1] = new Rectangle(x, y, width, height);
		lastModifiedGeometric++;
	}

	public double topBorder(int index) {
		return geometrics[index].topBorder();
	}

	public double rightBorder(int index) {
		return 0.0;
	}

	public double bottomBorder(int index) {
		return geometrics[index].bottomBorder();
	}

	public double leftBorder(int index) {
		return geometrics[index].leftBorder();
	}

	public double area(int index) {
		return geometrics[index].area();
	}

	public void move(int index, double dx, double dy) {
		geometrics[index].move(dx, dy);
	}

	public void sortByArea() {
	}

	public void sortByX() {
	}

	public void sortByY() {
	}
}
