package kartoteka.impl;

import java.util.LinkedList;

import kartoteka.Osoba;

public class Kartoteka {
	LinkedList<Osoba> lista = new LinkedList<Osoba>();

	public void dodaj(Osoba newOsoba) {
		lista.add(newOsoba);

	}

	public void usun(Osoba delete) {
		if (czyZawiera(delete))
			lista.remove(delete);
		else
			System.out.println("Brak takiej osoby");
	}

	public int rozmiar() {
		return lista.size();
	}

	public boolean czyZawiera(Osoba check) {

		for (Osoba o : lista) {
			if (o.getImie().equals(check.getImie())
					&& o.getNazwisko().equals(check.getNazwisko()))
				return true;
		}
		return false;

	}

	public Osoba pobierz(int index) {
		if (index >= lista.size())
			return lista.get(lista.size());
		else
			return lista.get(index);
	}

	public void finalize() {
		System.out.println("Uruchomiono garbage collector");
		System.gc();
	}
}