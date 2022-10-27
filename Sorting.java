package part01;

public class Sorting {

	/**
	 * Should return a String array of sorted tunes 
	 * in descending order by title
	 * @param data
	 * @return data
	 */
	
	public static String[] titleSort(String data[]) {
		int swaps;
		do {
			try {
				swaps = 0;
				for (int index = 0; index < data.length - 1; index++) {
					if (data[index].compareToIgnoreCase(data[index + 1]) > 0) {
						String temp = data[index];
						data[index] = data[index + 1];
						data[index + 1] = temp;
						swaps++;
					}
				}
			} catch (NullPointerException e) {
				return data;
			}
		} while (swaps > 0);
		return data;
	}

/**
 * Should return a String array of sorted tunes 
 * in descending order by play count
 * 
 * @param data
 * @return data
 */
	public static Tune[] playSort(Tune data[]) {
		int swaps;

		do {
			swaps = 0;
			for (int i = 0; i < data.length - 1; i++) {
				if (data[i].getPlayCount() < data[i + 1].getPlayCount()) {
					Tune temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					swaps++;
				}
			}
		} while (swaps > 0);
		return data;
	}
}
