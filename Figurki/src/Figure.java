public abstract class Figure extends Point {
	protected Point center;

	Figure() {
		center = new Point();
	}

	Figure(Point p) {
		center = p;
	}

	abstract float field();

	abstract float obw();

	abstract void scale();

	void move(float x, float y) {
		center.move(x, y);
	}
}
