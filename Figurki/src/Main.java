import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Figure> list = new ArrayList<Figure>();
		float sumobw = 0;
		float sumf = 0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0)
				list.add(new Circle());
			else
				list.add(new Square());
		}
		System.out.println("Wartosci pól wynoszą: ");
		for (Figure x : list) {
			System.out.println(x.field());
			sumf += x.field();
			sumobw += x.obw();
		}

		System.out.println("Suma wszystkich pól wynosi: " + sumf);
		System.out.println("Suma wszystkich obwódów wynosi " + sumobw);
		sumf = 0f;
		for (Figure x : list) {
			x.move(4, 2);
			sumf += x.field();
		}
		System.out.println("Suma pól po przesunięciu wynosi: " + sumf);
		sumf = 0f;
		for (Figure figure : list) {
			figure.scale();
			sumf += figure.field();
		}
		System.out.println("Suma pól po przeskalowaniu wynosi: " + sumf);
	}
}
