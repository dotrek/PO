import java.util.Scanner;

import kartoteka.Osoba;
import kartoteka.impl.Kartoteka;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Kartoteka k = new Kartoteka();
		while (true) {
			System.out
					.println(" 1.Dodaj"
							+ " 2.Usun"
							+ " 3.Rozmiar"
							+ " 4.Znajdz osobe po jej numerze 5. Sprawdz czy jest taka osoba 6. Uruchomienie garbage collectora 7.Wyjscie");
			int x = scan.nextInt();
			switch (x) {
			case 1:
				System.out.println("Podaj imie oraz nazwisko");

				String name = scan.next();
				String surname = scan.next();
				Osoba nowa = new Osoba(name, surname);
				k.dodaj(nowa);
				break;
			case 2:
				System.out
						.println("Podaj imie oraz nazwisko osoby którą chcesz usunac z kartoteki");
				String n = scan.next();
				String s = scan.next();
				Osoba dousuniecia = new Osoba(n, s);
				k.usun(dousuniecia);
				break;
			case 3:
				System.out.println(k.rozmiar());
				break;
			case 4:
				System.out.println("Podaj numer szukanej osoby");
				int num = scan.nextInt();
				System.out.println(k.pobierz(num).imie + " "
						+ k.pobierz(num).nazwisko);
				break;
			case 5:
				System.out.println("Podaj imie i nazwisko szukanej osoby");
				String im = scan.next();
				String naz = scan.next();
				Osoba check = new Osoba(im, naz);
				if (k.czyZawiera(check) == true)
					System.out.println("Ta osoba istnieje w kartotece");
				else
					System.out.println("Brak takiej osoby w kartotece");
				break;
			case 6:
				k.finalize();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Nie oszukuj ;]");
			}
		}
	}
}
