package part02;

import java.util.Scanner;

import part01.Genre;
import part01.MP3Player;
import part01.Menu;

public class JukeBoxManageApp {

	public static void main(String[] args) {

		int choice;
		do {
			choice = managementMenu.getUserChoice();
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
			addTune();
			break;
		case 2:
			setCost();
			break;
		case 3:
			storeData();
			break;
		default:
			System.out.println("Sorry option " + choice + " is invalid");
		}
	}

	/**
	 * Should prompt the user for inputs and use these to add a new tune object to
	 * Jukebox
	 */
	public static void addTune() {
		System.out.println("\nPlease enter song title");
		String title = input.nextLine();
		System.out.println("Please enter artist's name");
		String artist = input.nextLine();
		System.out.println("Please enter song's duration in seconds");
		int duration = input.nextInt();
		System.out.println("Please choose song's style");
		Genre genre = genreSelection();
		input.nextLine();
		jukebox.addTune(title, artist, duration, genre);
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
	 * Allows the owner to change the cost per play of the Jukebox
	 */
	public static void setCost() {
		System.out.println("Please input the cost per play: ");
		int cost = input.nextInt();
		input.nextLine();
		jukebox.setCostPerPlay(cost);
		System.out.println("Cost updated to:  " + cost + "p per song");

	}

	/**
	 * Stores the Tunes in the Jukebox into the .csv file
	 */
	public static void storeData() {
		FileManager data = new FileManager();
		if (jukebox.getTuneInfo() == null) {
			System.out.println("Sorry, there are no tunes to add");
		} else {
			data.SaveData(jukebox.getTuneInfo());
		}
	}

	// Instance of Jukebox
	private static Jukebox jukebox = new Jukebox();
	// String title for menu
	private static final String title = "Jukebox Management Menu";
	// Array of options for the menu
	private static final String[] options = { "Add Tune", "Set price per play", "Store Data", "Exit" };
	// Instance of menu for the application
	private static Menu managementMenu = new Menu(title, options);
	// Defines Scanner
	private static Scanner input = new Scanner(System.in);

}
