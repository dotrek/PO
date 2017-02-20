import java.util.LinkedList;

public class myQueue {
	private int curr;
	private final int range;

	private final LinkedList<Integer> myQ = new LinkedList<Integer>();

	public myQueue(int number) {
		range = number;
		curr = 0;
	}

	public void pushBack(int n) throws FullQueueException, WrongNumberException, RepeatException {
		if (curr >= range)
			throw new FullQueueException("There is not enough space in the queue.");
		for (Integer integer : myQ) {
			if (n == integer) {
				throw new RepeatException("There is same variable in queue");
			}
		}
		if (n > range)
			throw new WrongNumberException("Wrong number.", n);
		myQ.add(n);
		curr++;
	}

	public void popBack() throws EmptyQueueException {
		if (myQ.isEmpty())
			throw new EmptyQueueException("Lack of elements in the queue.");
		myQ.remove();
		curr--;
	}

	public void display() {
		for (int i = 0; i < myQ.size(); i++)
			System.out.print(myQ.get(i) + " ");
		System.out.println();
	}

}
