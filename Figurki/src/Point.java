public class Point {
	float x, y;

	Point() {
		x = (float) Math.random();
		y = (float) Math.random();
	}

	void move(float x, float y) {
		this.x += x;
		this.y += y;
	}
}
