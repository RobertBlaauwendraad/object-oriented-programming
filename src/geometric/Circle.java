package geometric;

public class Circle implements Geometric{
	private  double x;
	private  double y;
	private final double r;

	public Circle(double x, double y, double r) {
	this.r = r;
	this.x = x;
	this.y = y;
	}

	@Override
	public double topBorder() {
	return y + r;
	}

	@Override
	public double rightBorder() {
		return x + r;
	}

	@Override
	public double leftBorder() {
		return x - r;
	}

	@Override
	public double bottomBorder() {
		return y - r;
	}

}
