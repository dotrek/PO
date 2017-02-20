public class WrongNumberException extends FIFOException {

	private int number;

	public int getNumber() {
		return number;
	}

	public WrongNumberException(int numb) {
		number = numb;
	}

	public WrongNumberException(String msg, int numb) {
		super(msg);
		number = numb;
	}
}
