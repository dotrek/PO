package kartoteka;

public class Osoba {
	public String imie;
	public String nazwisko;

	public Osoba(String name, String surname) {
		imie = name;
		nazwisko = surname;
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}
}
