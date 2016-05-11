public class Circle extends Figure {

	float r;

	Circle() {
		super();
		r = (float) Math.random();
	}

	Circle(Point p, float rr) {
		super(p);
		r = rr;
	}

	float field() {
		return (float) Math.PI * (float) Math.pow(r, 2);
	}

	float obw() {
		return 2 * (float) Math.PI * r;
	}

	@Override
	void scale() {
		// TODO Auto-generated method stub
		r *= 2;
	}
}
