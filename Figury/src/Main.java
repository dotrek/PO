import java.awt.Color;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Picture obraz = new Picture();
		int x;
		Point p1 = new Point(0, 0), p2 = new Point(1, 1);
		Line l1 = new Line(p1, p2), l2 = new Line(p1, p2);
		l1.przesun(5, 5);
		System.out.println(l1);
		System.out.println(l2);
		while (true) {
			System.out.println("Wybieraj:");
			System.out.println("1: Tworzenie trójkąta");
			System.out.println("2: Tworzenie czworoboku");
			System.out.println("3: Wyświetlanie stworzonych figur");
			System.out.println("4: Przykładowe użycie zadania 7");
			System.out.println("5: Wyjscie");
			x = scan.nextInt();
			switch (x) {
			case 1:
				Triangle tr = new Triangle();
				obraz.add(tr);
				break;
			case 2:
				Square sq = new Square();
				obraz.add(sq);
				break;
			case 3:
				System.out.println(obraz.toString());
				break;
			case 4:
				System.out.println(new Quadrat(Color.BLUE, new Point(), 10));
				System.out.println(new Quad(Color.GREEN, new Point(),
						new Point()));
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Bad try ;]");
			}
		}
	}

}
