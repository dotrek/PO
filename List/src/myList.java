import java.util.LinkedList;

public class myList {
	private final LinkedList<Integer> linkedList;

	myList() {
		linkedList = new LinkedList<Integer>();
	}

	public void add(int newNr) {
		for (int i = 0; i < linkedList.size(); i++) {
			if (linkedList.get(i) >= newNr) {
				linkedList.add(i, newNr);
				return;
			}
		}
		linkedList.add(newNr);
	}

	public void add(int number, int index) {
		linkedList.add(index, number);
	}

	public void overview() {
		myListIterator iterator = this.new Iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public java.util.Iterator iterator() {
		return linkedList.iterator();
	}

	public void addFirst(Integer e) {
		throw new UnsupportedOperationException();
	}

	public void addLast(Integer e) {
		throw new UnsupportedOperationException();
	}

	interface myListIterator extends java.util.Iterator<Integer> {
	}

	private class Iterator implements myListIterator {

		private int index = 0;

		@Override
		public boolean hasNext() {
			return (index <= linkedList.size() - 1);
		}

		@Override
		public void remove() {
			linkedList.remove(index);
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			Integer n = linkedList.get(index);
			index += 2;
			return n;
		}
	}

}
