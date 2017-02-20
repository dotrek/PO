import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		myList l = new myList();
		l.add(5);
		l.add(2);
		l.add(7);
		l.add(4);
		l.add(3);
		l.add(5);
		l.overview();

		Iterator it = l.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
