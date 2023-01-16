import java.util.Scanner;

//Dies ist ein Test Kommentaer für GitHub
public class FahrkartenautomatMethoden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner tastatur = new Scanner(System.in);
		begruessung();
		double zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
		double eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
		fahrkartenAusgeben();
		muenzRueckgabe(rückgeldAusgeben(eingezahlterGesamtbetrag, zuZahlenderBetrag));
		tastatur.close();
	}

	// Methoden:

	// Begrüßung - einfacher print

	public static void begruessung() {
		System.out.printf(
				"Wählen sie ihre Wunschfahrkarte für Berlin AB aus:\nKurzstrecke AB [2,00 EUR] (1)\nEinzelfahrschein AB [3,00 EUR] (2)\nTageskarte AB [8,80 EUR] (3)\n4-Fahrten-Karte AB [9,40 EUR] (4)\n");
	}

	// Fahrkartenerfassung und Berechnung

	public static double fahrkartenbestellungErfassen(Scanner tastatur) {
		int wunschFahrkarte;
		double ticketPreis = 0.0;
		do {
			wunschFahrkarte = tastatur.nextInt();
			if (wunschFahrkarte == 1 || wunschFahrkarte == 2 || wunschFahrkarte == 3 || wunschFahrkarte == 4) {
				switch (wunschFahrkarte) {
				case 1:
					ticketPreis = 2.00;
					break;
				case 2:
					ticketPreis = 3.00;
					break;
				case 3:
					ticketPreis = 8.80;
					break;
				case 4:
					ticketPreis = 9.40;
					break;
				}
			} else {
				System.out.print("Falsche Eingabe\n");
			}
		} while (wunschFahrkarte != 1 && wunschFahrkarte != 2 && wunschFahrkarte != 3 && wunschFahrkarte != 4);

		System.out.print("Anzahl der Tickets(1-10): ");
		int anzahlFahrkarten = tastatur.nextInt();

		if (anzahlFahrkarten < 1 || anzahlFahrkarten > 10) {
			anzahlFahrkarten = 1;
			System.out.print("Die Ticketanzahl beträgt nun 1, da sie eine falsche Anzahl eingegeben haben.\n");
		}
		double zuZahlenderBetrag = ticketPreis * anzahlFahrkarten;
		return zuZahlenderBetrag;

	}

	// Geldeinwurf

	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		double eingezahlterGesamtbetrag = 0.0;
		double nochZuZahlen = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f ", nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
			int eingeworfeneMuenze = tastatur.nextInt();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		return eingezahlterGesamtbetrag;
	}

	// Fahrkarten Ausgeben Animation

	public static void fahrkartenAusgeben() {
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");

	}

	// Rückgeld Ausgabe
	public static double rückgeldAusgeben(double eingezahlterGesamtbetrag, double zuZahlenderBetrag) {

		double rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;

		if (rueckgabebetrag > 0.0) {
			System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
		}
		return rueckgabebetrag;
	}

	// Münz rückgabe

	public static void muenzRueckgabe(double rueckgabebetrag) {
		if (rueckgabebetrag > 0.0) {
			System.out.println("wird in folgenden Münzen ausgezahlt:");
			while (rueckgabebetrag >= 20.0) { // 20-Euro-Schein
				System.out.println("20 Euro");
				rueckgabebetrag = rueckgabebetrag - 20.0;
			}
			while (rueckgabebetrag >= 10.0) { // 10-Euro-Schein
				System.out.println("10 Euro");
				rueckgabebetrag = rueckgabebetrag - 10.0;
			}
			while (rueckgabebetrag >= 5.0) { // 5-Euro-Schein
				System.out.println("5 Euro");
				rueckgabebetrag = rueckgabebetrag - 5.0;
			}
			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}
		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtan" + "tritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");
	}
}