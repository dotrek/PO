import java.util.Scanner;

public class Stos {

	int[] stack;
	int w = -1;

	public void pop() {
		if (!empty()) {
			stack[w] = 0;
			w--;
		}
	}

	public void push(int pob) {
		w++;
		stack[w] = pob;
	}

	public int top() {
		return stack[w];
	}

	public boolean empty() {
		if (w <= 0)
			return true;
		return false;
	}

	public boolean full() {
		if (w == 10)
			return true;
		return false;
	}

	public void init() {
		stack = new int[11];
		w = 0;
	}

	public void destroy() {
		stack = null;
		System.gc();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stos s1 = new Stos();
		s1.init();
		Scanner scan = new Scanner(System.in);
		while (s1.full() == false) {
			System.out.println("Podaj liczbe, ktora chcesz wsadzić do stosu");
			s1.push(scan.nextInt());
		}
		scan.close();
		System.out.println("Wierzchołek stosu to: " + s1.top());
		Stos s2 = new Stos();
		s2.init();
		while (!s1.empty()) {
			s2.push(s1.top());
			s1.pop();
		}
		System.out.println("Zostały wpisane liczby: ");
		while (!s1.full()) {
			s1.push(s2.top());
			s2.pop();
			System.out.println(s1.top());

		}

	}
}
