public class Square extends Figure {
	float length;

	Square() {
		super();
		length = (float) Math.random();
	}

	Square(Point p, float l) {
		super(p);
		length = l;
	}

	float field() {
		return (float) Math.pow(length, 2);
	}

	float obw() {
		return 4 * length;
	}

	@Override
	void scale() {
		length *= 2;
	}
}
