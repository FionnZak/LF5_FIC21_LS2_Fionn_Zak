import java.util.HashMap;
import java.util.Map;

public class Zahlen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] zahlen = { 3, 4, 2, 3, 5, 1, 2, 7, 2, 1, 2, 4 };

		// Erstellt eine HashMap mit einem Int Key und einer Int Value
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < zahlen.length; i++) {
			if (countMap.containsKey(zahlen[i])) {
				countMap.put(zahlen[i], countMap.get(zahlen[i]) + 1);
			} else {
				countMap.put(zahlen[i], 1);
			}
		}

		int mostCommonNum = zahlen[0];
		int mostCommonCount = 1;

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > mostCommonCount) {
				mostCommonNum = entry.getKey();
				mostCommonCount = entry.getValue();
			}
		}

		System.out.println(
				"Die am meisten vorkommende Nummer ist " + mostCommonNum + " mit " + mostCommonCount + " einträgen.");

	}

}
