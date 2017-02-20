import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int x;

		System.out.println("Enter the range: ");
		int a = scan.nextInt();

		myQueue queue = new myQueue(a);

		while (true) {
			queue.display();
			System.out.println(" 1 - Push back.\n 2 - Pop back.\n 3 - Exit.\n");

			x = scan.nextInt();
			switch (x) {
			case 1:
				System.out.println("number you want to push back to the queue:");
				a = scan.nextInt();
				try {
					queue.pushBack(a);
				} catch (FullQueueException fe) {
					System.out.println(fe.getMessage());
					fe.printStackTrace();
					return;
				} catch (WrongNumberException we) {
					System.out.println(we.getMessage() + " You have entered " + we.getNumber() + ".");
				} catch (RepeatException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					return;
				}
				break;
			case 2:
				try {
					queue.popBack();
				} catch (EmptyQueueException ee) {
					ee.printStackTrace();
					return;
				}
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Wrong choice");
				break;
			}
		}
	}
}
