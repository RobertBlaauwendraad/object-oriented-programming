package geometric;

import java.util.ArrayList;
import java.util.Collections;

public class Assignment03Tester {
	private  static final int GEOMETRICS_CAPACITY = 10;
	private final ArrayList<Geometric> geometrics = new ArrayList<>(GEOMETRICS_CAPACITY);
	public Assignment03Tester() {
	}

	public void createCircle(double x, double y, double r) {
		geometrics.add(new Circle(x, y, r));
	}

	public void createRectangle(double x, double y, double width, double height) {
		geometrics.add(new Rectangle(x, y, width, height));
	}

	public double topBorder(int index) {
		return geometrics.get(index).topBorder();
	}

	public double rightBorder(int index) {
		return geometrics.get(index).rightBorder();

	}

	public double bottomBorder(int index) {
		return geometrics.get(index).bottomBorder();
	}

	public double leftBorder(int index) {
		return geometrics.get(index).leftBorder();
	}

	public double area(int index) {
		return geometrics.get(index).area();
	}

	public void move(int index, double dx, double dy) {
		geometrics.get(index).move(dx, dy);
	}

	public void sortByArea() {
		Collections.sort(geometrics);
	}

	public void sortByX() {
		geometrics.sort(new GeometricComparatorByX());
	}

	public void sortByY() {
		geometrics.sort(new GeometricComparatorByY());
	}
}
