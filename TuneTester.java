package part01;

import java.util.Scanner;

public class TuneTester {

	public static void main(String[] args) {

		int choice;
		do {
			choice = tuneMenu.getUserChoice();
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
	private static void userChoice(int choice) {
		switch (choice) {
		case 1:
			selectFullList();
			break;
		case 2:
			selectByArtist();
			break;
		case 3:
			addTune();
			break;
		case 4:
			displayTop10();
			break;
		default:
			System.out.println("Sorry option " + choice + " is invalid");
		}
	}

	/**
	 * Should display the top 10 most played tunes ordered by play count
	 */
	private static void displayTop10() {
		System.out.println(mp3.getTopTen());
	}

	/**
	 * Should prompt the user for inputs and use these to add a new tune object to
	 * MP3Player
	 */
	private static void addTune() {

		System.out.println("\nPlease enter song title");
		String title = input.nextLine();
		System.out.println("Please enter artist's name");
		String artist = input.nextLine();
		System.out.println("Please enter song's duration in seconds");
		int duration = input.nextInt();
		System.out.println("Please choose song's style");
		Genre genre = genreSelection();
		input.nextLine();
		mp3.addTune(title, artist, duration, genre);

	}

	/**
	 * Returns a Genre object based on the users selection
	 * 
	 * @return Genre
	 */
	private static Genre genreSelection() {
		int choice = 0;
		boolean validInput = true;
		do {
			validInput = false;
			System.out.println("Style:\n1. Rock \n2. Pop \n3. Dance \n4. Jazz \n5. Classical \n6. Other ");
			if (input.hasNextInt()) {
				validInput = true;
				choice = input.nextInt();
				input.nextLine();
				
				break;
			}else {
				System.out.println("Not a valid choice");
				validInput = false;
				input.nextLine();
				break;
			}
		} while (validInput = true);
		switch (choice) {
		case 1:
			return Genre.ROCK;
		case 2:
			return Genre.POP;
		case 3:
			return Genre.DANCE;
		case 4:
			return Genre.JAZZ;
		case 5:
			return Genre.CLASSICAL;
		case 6:
			return Genre.OTHER;
		default:
			return Genre.OTHER;
		}
	}

	/**
	 * Should display a list of all tunes by a certain artist and allow the user to
	 * select one to play
	 */
	private static void selectByArtist() {
		if (mp3.getTuneInfo() != null) {
			System.out.println("\nPlease enter the name of the artist you are searching for");
			String artist = input.nextLine();
			if (mp3.getTuneInfo(artist) != null) {
				for (String tune : mp3.getTuneInfo(artist)) {
					if (tune != null) {
						System.out.println(tune.toString());
					}
				}
				boolean validInput = true;
				System.out.println("\nPlease select the ID of the song you would like to play");
				do {
					validInput = false;
					if (input.hasNextInt()) {
						System.out.println(mp3.playTune(input.nextInt()));
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
				System.out.println("\nArtist not found");
			}
		} else {
			System.out.println("\nSorry no Tunes available");
		}
	}

	/**
	 * Should display a list of all available tunes in the MP3Player and allow the
	 * user to pick one to be played
	 */
	private static void selectFullList() {
		if (mp3.getTuneInfo() != null) {
			for (String tune : mp3.getTuneInfo()) {
				System.out.println(tune);
			}

			boolean validInput = true;
			System.out.println("\nPlease select the ID of the song you would like to play");

			do {
				validInput = false;
				if (input.hasNextInt()) {
					System.out.println(mp3.playTune(input.nextInt()));
					input.nextLine();
					validInput = true;
					break;
				} else {
					System.out.println("Not a valid ID.\nPlease enter a valid ID:  ");
					input.nextLine();
					validInput = false;
				}

			} while (validInput = true);

		} else {
			System.out.println("\nSorry, no songs avialble");
		}

	}

	// String array of menu options
	private static final String[] options = { "Select Tune from Full List", "Select Tune by Artist", "Add New Tune",
			"Display Top 10", "Exit" };
	// String of menu title
	private static final String title = "MP3 Player Menu";

	// Define menu using title and options
	private static Menu tuneMenu = new Menu(title, options);

	// Creates an instance of Scanner
	private static Scanner input = new Scanner(System.in);

	// Creates an instance of MP3Player to be used
	private static MP3Player mp3 = new MP3Player();

}
