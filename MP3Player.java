package part01;

import java.util.ArrayList;

public class MP3Player implements IPlayer {

	/**
	 * List of Tune objects managed by an MP3Player
	 */
	private ArrayList<Tune> soundData;

	public MP3Player() {
		this.soundData = new ArrayList<Tune>();
	}

	/**
	 * Should return an array of Strings where each String contains full details of
	 * a Tune, ordered by Title and covering all available Tune objects. The method
	 * should return null if no Tune object are available
	 */
	public String[] getTuneInfo() {
		if (soundData.size() > 0) {
			String[] info = new String[soundData.size()];
			int i = 0;
			for (Tune tune : soundData) {
				info[i++] = tune.toString();
			}
			return Sorting.titleSort(info);
		}
		return null;
	}

	/**
	 * Should return an array (as above) for Tune objects by a specific artist,
	 * specified by the String parameter. Again, the data should be ordered by
	 * Title. The method should return null if no Tune objects are available.
	 */
	public String[] getTuneInfo(String artist) {
		if (soundData.size() > 0) {
			String[] info = new String[soundData.size()];

			int i = 0;
			for (Tune tune : soundData) {
				if (artist.equals(tune.getArtist())) {

					info[i++] = tune.toString();
				}
			}
			if (info[0] == null) {
				return null;
			}
			return Sorting.titleSort(info);
		}
		return null;
	}

	/**
	 * Using the integer parameter (representing the ID of a Tune) should identify a
	 * Tune and ‘play’ it (call the play method for a tune). The method should
	 * return null if it does  not exist or the result of calling the play method for
	 * a Tune if it does exist.
	 */
	public String playTune(int tuneId) {
		for (Tune tune : soundData) {
			if ((tuneId) == tune.getId()) {
				return tune.play();
			}
		}
		return "Sorry, song not be found";
	}

	/*
	 * This method should create and add a new Tune object to the soundData
	 * ArrayList if it’s not already present. Two Tune objects are considered to be
	 * the same if they have the same title and artist.
	 */
	public boolean addTune(String title, String artist, int duration, Genre style) {
		boolean duplicate = false;
		boolean added = false;
		for (Tune tune : soundData) {
			if (title.equalsIgnoreCase(tune.getTitle()) && artist.equalsIgnoreCase(tune.getArtist())) {
				duplicate = true;
				added = false;
			}
		}
		if (duplicate == true) {
			System.out.println("Sorry, a tune with this name and artist already exists.");
			added = true;
		} else {
			Tune newTune = new Tune(title, artist, duration, style);
			soundData.add(newTune);
			System.out.println("Tune added successfully.");
		}
		return added;
	}

	/*
	 * Returns a single String containing the title, artist and number of plays for
	 * the top ten Tune objects within the system (ordered by number of plays,
	 * highest to lowest)
	 */
	public String getTopTen() {
		Tune[] unsorted = new Tune[soundData.size()];
		String str = "";

		if (soundData.size() > 0) {
			int i = 0;
			for (Tune tune : soundData) {
				unsorted[i++] = tune;
			}

			if (unsorted != null) {
				Tune[] sorted = Sorting.playSort(unsorted);

				if (sorted.length > 10) {
					for (int j = 0; j < 10; j++) {
						str += ("\nPlay Count: " + sorted[j].getPlayCount() + ", Title: " + sorted[j].getTitle()
								+ ", Artist: " + sorted[j].getArtist());
					}
				} else {
					for (int g = 0; g < sorted.length; g++) {
						str += ("\nPlay Count: " + sorted[g].getPlayCount() + ", Title: " + sorted[g].getTitle()
								+ ", Artist: " + sorted[g].getArtist());
					}
				}
			}
		}else {
			str = "No tunes available";
			return str;
		}
		return str;
	}
}
