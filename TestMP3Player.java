package part03;

import part01.Genre;
import part01.MP3Player;

public class TestMP3Player {

	static String title1 = "Bohemian Rhapsody";
	static String artist1 = "Queen";
	static int duration1 = 355;
	static Genre style1 = Genre.ROCK;

	static String title2 = "Killer Queen";
	static String artist2 = "Queen";
	static int duration2 = 180;
	static Genre style2 = Genre.ROCK;

	static String title3 = "Eleanor Rigby";
	static String artist3 = "The Beatles";
	static int duration3 = 180;
	static Genre style3 = Genre.ROCK;

	public static void main(String[] args) {

		test1();
		test2();
		test3();
		test4();
		test5();

	}

	public static void test1() {
		MP3Player mp3 = new MP3Player();

		// Test ID: TC1
		// Testing the getTuneInfo method with no tunes for the Tune class
		System.out.println("\n------ Test Case TC1: Testing the 'getTuneInfo' Method with no songs avialble ------");
		System.out.println("Input Data: None");
		System.out.println("Output: " + mp3.getTuneInfo());
		System.out.println("------    Test Case TC1: End of Test Method    ------");

		// Test ID: TC2
		// Testing the getTuneInfo method with one tune for the Tune class
		System.out.println("\n------ Test Case TC2: Testing the 'getTuneInfo' Method with one songs avialble ------");
		System.out.println("Input Data: Title: " + title1 + ", Artist; " + artist1 + ", Duration: " + duration1
				+ ", Style: " + style1);
		mp3.addTune(title1, artist1, duration1, style1);
		System.out.print("Output: ");
		for (String tune : mp3.getTuneInfo()) {
			System.out.print(tune);
		}
		System.out.println("\n------    Test Case TC2: End of Test Method    ------");

		// Test ID: TC3
		// Testing the getTuneInfo method with one tune for the Tune class
		System.out.println("\n------ Test Case TC3: Testing the 'getTuneInfo' Method with two songs avialble ------");
		System.out.println("Input Data: \nTitle: " + title1 + ", Artist; " + artist1 + ", Duration: " + duration1
				+ ", Style: " + style1 + "\nTitle: " + title2 + ", Artist; " + artist2 + ", Duration: " + duration2
				+ ", Style: " + style1);
		mp3.addTune(title2, artist2, duration2, style2);
		System.out.println("Output: ");
		for (String tune : mp3.getTuneInfo()) {
			System.out.println(tune);
		}
		System.out.println("\n------    Test Case TC3: End of Test Method    ------");
	}

	public static void test2() {
		MP3Player Mp3 = new MP3Player();

		// Test ID: TC4
		// Testing the getTuneInfo method with no tunes for the Tune class
		System.out.println("\n------ Test Case TC4: Testing the 'getTuneInfo' Method with no songs avialble ------");
		System.out.println("Input Data: None");
		System.out.println("Output: " + Mp3.getTuneInfo(title1));
		System.out.println("------    Test Case TC4: End of Test Method    ------");

		// Test ID: TC5
		// Testing the getTuneInfo method with one tune for the Tune class

		System.out.println(
				"\n------ Test Case TC5: Testing the 'getTuneInfo(String)' Method with one song avialble ------");
		System.out.println("Input Data: Title: " + title1 + ", Artist; " + artist1 + ", Duration: " + duration1
				+ ", Style: " + style1);
		Mp3.addTune(title1, artist1, duration1, style1);
		System.out.println("Searching for songs by 'Queen'");
		System.out.print("Output: ");
		for (String tune : Mp3.getTuneInfo(artist1)) {
			if (tune != null) {
				System.out.println(tune);
			}
		}

		System.out.println("\n------    Test Case TC5: End of Test Method    ------");

		// Test ID: TC6
		// Testing the getTuneInfo method with one tune for the Tune class
		System.out.println(
				"\n------ Test Case TC6: Testing the 'getTuneInfo(String)' Method with two songs of differing artists avialble ------");
		System.out.println("Input Data: \nTitle: " + title1 + ", Artist; " + artist1 + ", Duration: " + duration1
				+ ", Style: " + style1 + "\nTitle: " + title3 + ", Artist; " + artist3 + ", Duration: " + duration3
				+ ", Style: " + style3);
		Mp3.addTune(title3, artist3, duration3, style3);
		System.out.println("Searching for songs by 'The Beatles'");
		System.out.println("Output: ");
		for (String tune : Mp3.getTuneInfo(artist3)) {
			if (tune != null) {
				System.out.println(tune);
			}
		}
		System.out.println("\n------    Test Case TC6: End of Test Method    ------");
	}

	public static void test3() {

		// Test ID: TC7
		// Testing the addTune method for MP3Player

		MP3Player mp = new MP3Player();

		System.out.println("\n------ Test Case TC7: Testing the 'addTune' method correctly adds tunes ------");
		System.out.println("Input Data: \nTitle: " + title1 + ", Artist; " + artist1 + ", Duration: " + duration1
				+ ", Style: " + style1);
		System.out.print("Output: ");
		mp.addTune(title1, artist1, duration1, style1);

		System.out.println("\n------    Test Case TC7: End of Test Method    ------");

		// Test ID: TC8
		// Testing the addTune method for MP3Player

		System.out.println("\n------ Test Case TC8: Testing the 'addTune' method with duplicate songs ------");
		System.out.println("Input Data: Title: " + title1 + ", Artist; " + artist1 + ", Duration: " + duration1
				+ ", Style: " + style1);
		mp.addTune(title1, artist1, duration1, style1);

		System.out.println("\n------    Test Case TC8: End of Test Method    ------");
	}

	public static void test4() {
		MP3Player MP3 = new MP3Player();

		// Test ID: TC9
		// Testing the playTune method for MP3Player
		System.out.println("\n------ Test Case TC9: Testing the 'playTune' method with no available songs ------");
		System.out.println("Input Data: None");
		System.out.println("Output: " + MP3.playTune(1));
		System.out.println("\n------    Test Case TC9: End of Test Method    ------");

		// Test ID: TC10
		// Testing the playTune method for MP3Player
		System.out.println("\n------ Test Case TC10: Testing the 'playTune' method with existing songs ------");
		System.out.println("Input Data: Title: " + title2 + ", Artist; " + artist2 + ", Duration: " + duration2
				+ ", Style: " + style2);
		MP3.addTune(title2, artist2, duration2, style2);
		System.out.println("Output: " + MP3.playTune(6));
		System.out.println("\n------    Test Case TC10: End of Test Method    ------");
	}

	public static void test5() {
		MP3Player mp3 = new MP3Player();

		// Test ID: TC11
		// Testing the getTopTen method for MP3Player

		System.out.println("\n------ Test Case TC12: Testing the 'getTopTen' method with no tunes ------");
		System.out.println("Input Data: None");
		System.out.print("Output of getTopTen: " + mp3.getTopTen());
		System.out.println("\n------    Test Case TC11: End of Test Method    ------");

		// Test ID: TC12
		// Testing the getTopTen method for MP3Player

		System.out.println(
				"\n------ Test Case TC12: Testing the 'getTopTen' method displays tunes by playcount order ------");
		System.out.println("Input Data: \nTitle: " + title1 + ", Artist; " + artist1 + ", Duration: " + duration1
				+ ", Style: " + style1 + "\nTitle: " + title2 + ", Artist; " + artist2 + ", Duration: " + duration2
				+ ", Style: " + style2);
		mp3.addTune(title1, artist1, duration1, style1);
		mp3.addTune(title2, artist2, duration2, style2);

		System.out.println("Play a song: " + mp3.playTune(7));
		System.out.print("Output of getTopTen: " + mp3.getTopTen());
		System.out.println("\n------    Test Case TC12: End of Test Method    ------");
	}
}
