import java.util.Scanner;

public class Volumen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VolumenBerechnung();
		VolumenBerechnung();
	}

	public static int VolumenBerechnung() {
		Scanner tastatur = new Scanner(System.in);

		System.out.print("Bitte geben sie die Höhe in cm ein: ");
		int hoehe = tastatur.nextInt();

		System.out.print("Bitte geben sie die Tiefe in cm ein: ");
		int laenge = tastatur.nextInt();

		System.out.print("Bitte geben sie die Breite in cm ein: ");
		int breite = tastatur.nextInt();

		int ErgebnisVolumen = laenge * breite * hoehe;

		System.out.print("Das Volumen des Würfels ist: " + ErgebnisVolumen);

		return ErgebnisVolumen;

	}
}
