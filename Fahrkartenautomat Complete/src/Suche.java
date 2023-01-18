public class Suche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] zahlenArray = { 33, 5, 3, 5, 9, 7, 11, 23, 23, 3 };
		int wert = 3;
		boolean ergebnis = false;

		for (int i = 0; i < zahlenArray.length; i++) {
			ergebnis = zahlenArray[i] == wert;
		}
		if (ergebnis == true) {
			System.out.print("Wert gefunden!");
		} else {
			System.out.print("Wert nicht gefunden!");
		}
	}
}