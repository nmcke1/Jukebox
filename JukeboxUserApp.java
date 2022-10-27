package part02;

import java.util.InputMismatchException;
import java.util.Scanner;

import part01.Genre;
import part01.Menu;
import part01.Tune;

public class JukeboxUserApp {

	public static void main(String[] args) {

		int choice;
		do {
			choice = jukeboxMenu.getUserChoice();
			if (choice != options.length) {
				userChoice(choice);
			}
		} while (choice != options.length);
		System.out.println("\nApplication Closing!");
		input.close();
	}

	/**
	 * Switch case to allow user to select a menu option
	 * 
	 * @param choice
	 */
	public static void userChoice(int choice) {
		switch (choice) {
		case 1:
			selectFullList();
			break;
		case 2:
			selectByArtist();
			break;
		case 3:
			addMoney();
			break;
		case 4:
			loadData();
			break;
		default:
			System.out.println("Sorry option " + choice + " is invalid");

		}
	}

	/**
	 * Should display a list of all available tunes in the MP3Player and allow the
	 * user to pick one to be played
	 */
	public static void selectFullList() {
		if (jukebox.getTuneInfo() != null) {
			for (String tune : jukebox.getTuneInfo()) {
				System.out.println(tune);
			}
			boolean validInput = true;
			System.out.println("\nPlease select the ID of the song you would like to play");

			do {
				validInput = false;
				if (input.hasNextInt()) {
					System.out.println(jukebox.playTune(input.nextInt()));
					input.nextLine();
					validInput = true;
					break;
				} else {
					System.out.println("Not a valid ID.\nPlease enter a valid ID: ");
					input.nextLine();
					validInput = false;
				}

			} while (validInput = true);

		} else {
			System.out.println("\nSorry, no songs avialble");
		}
	}

	/**
	 * Should display a list of all tunes by a certain artist and allow the user to
	 * select one to play
	 */
	public static void selectByArtist() {
		if (jukebox.getTuneInfo() != null) {
			System.out.println("\nPlease enter the name of the artist you are searching for");
			String artist = input.nextLine();
			if (jukebox.getTuneInfo(artist) != null) {
				for (String tune : jukebox.getTuneInfo(artist)) {
					if (tune != null) {
						System.out.println(tune.toString());
					}
				}
				boolean validInput = true;
				System.out.println("\nPlease select the ID of the song you would like to play");

				do {
					validInput = false;
					if (input.hasNextInt()) {
						System.out.println(jukebox.playTune(input.nextInt()));
						input.nextLine();
						validInput = true;
						break;
					} else {
						System.out.println("Not a valid ID.\nPlease enter a valid ID: ");
						input.nextLine();
						validInput = false;
					}
				} while (validInput = true);

			} else {
				System.out.println("\nCannot find artist");
			}

		} else {
			System.out.println("\nSorry no Tunes available");
		}
	}

	/**
	 * Allows the user to add a valid coin to the Jukebox to allow songs to be
	 * played
	 */
	public static void addMoney() {

		int coin = 0;
		while (jukebox.insertCoin(coin) != -1) {
			System.out.println("Please insert a valid coin.\nAccepted coins are are 10p, 20p, 50p, 1 "
					+ "pound and 2 pound coins \nValue of coin: ");
			if (input.hasNextInt() == false) {
				System.out.println("Not a valid coin");
				break;
			} else {
				coin = input.nextInt();
				input.nextLine();
			}
		}
	}

	/**
	 * Loads data from the .csv file into Tune objects in the Jukebox
	 */
	public static void loadData() {
		if (data.loadData() != null) {
			for (Tune tunes : data.loadData()) {
				String title = tunes.getTitle();
				String artist = tunes.getArtist();
				int duration = tunes.getDuration();
				String style = tunes.getStyle();
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
				jukebox.addTune(title, artist, duration, gen);
			}
			System.out.println("Data successfully loaded");
		} else {
			System.out.println("Sorry, no data to load");
		}
	}

	// Instance of Data Manager
	private static FileManager data = new FileManager();
	// Instance of Jukebox
	private static Jukebox jukebox = new Jukebox();
	// String title for menu
	private static final String title = "Jukebox Menu";
	// Array of options for the menu
	private static final String[] options = { "Select Tune from Full List", "Select Tune by artist", "Add Money",
			"Load Data", "Exit" };
	// Instance of menu for the application
	private static Menu jukeboxMenu = new Menu(title, options);
	// Instance of Scanner
	private static Scanner input = new Scanner(System.in);
}
