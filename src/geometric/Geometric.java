package geometric;

public interface Geometric extends Comparable<Geometric> {
	double topBorder();
	double rightBorder();
	double bottomBorder();
	double leftBorder();
	double area();
	void move(double dx, double dy);
	@Override
	default int compareTo(Geometric objectToBeComparedWith){
		return Double.compare(this.area(), objectToBeComparedWith.area());
	}
}
