package part02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import part01.Genre;
import part01.Tune;

public class FileManager {

	public FileManager() {

	}

	private final String directory = "JukeboxData.csv";

	/**
	 * Loads data from the .csv file into an ArrayList
	 * 
	 * @return ArrayList<Tune>
	 */
	public ArrayList<Tune> loadData() {
		ArrayList<Tune> Tunes = new ArrayList<Tune>();
		try {
			File jukeboxFile = new File(directory);
			Scanner input = new Scanner(jukeboxFile);
			while (input.hasNextLine())
				do {
					String line = input.nextLine();
					String data[] = line.split(",");
					// System.out.println(line);
					String title = data[0].substring(7, data[0].length());
					String artist = data[1].trim().substring(8, data[1].length() - 1);
					String duration = data[2].trim().substring(10, data[2].length() - 1);
					String style = data[3].trim().substring(7, data[3].length() - 1);
					String id = data[4].trim().substring(4, data[4].length() - 1);
					int ID = Integer.parseInt(id);
					int dur = Integer.parseInt(duration);

					Genre gen;
					switch (style) {
					case "Rock and Roll":
						gen = Genre.ROCK;
						break;
					case "Easy Listening Pop":
						gen = Genre.POP;
						break;
					case "Techno Dance":
						gen = Genre.DANCE;
						break;
					case "Smooth Jazz":
						gen = Genre.JAZZ;
						break;
					case "Classical":
						gen = Genre.CLASSICAL;
						break;
					default:
						gen = Genre.OTHER;
						break;
					}
					Tune t = new Tune(title, artist, dur, gen);
					t.setId(ID);
					Tunes.add(t);

				} while (input.hasNextLine());
			input.close();
			System.out.println("Data successfully loaded");
			return Tunes;
		} catch (IOException e) {
			System.out.println("Unable to load data");
		}
		return null;

	}

	/**
	 * Saves the tunes in the Jukebox into the .csv file
	 * 
	 * @param tunes
	 */
	public void SaveData(String[] tunes) {
		try {
			FileWriter fw = new FileWriter(directory, true);
			PrintWriter pw = new PrintWriter(fw);
			for (String tune : tunes) {
				pw.println(tune);
			}
			fw.close();
			pw.close();
			System.out.println("Data successfully saved");
		} catch (IOException e) {
			System.out.println("Cannot save Jukebox Data");
		}
	}
}
