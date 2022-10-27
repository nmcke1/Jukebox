package part03;

import part01.Genre;
import part01.Tune;

public class TestTune {

	static String title1 = "Bohemian Rhapsody";
	static String artist1 = "Queen";
	static int duration1 = 355;
	static Genre style1 = Genre.ROCK;

	static String title2 = "Killer Queen";
	static String artist2 = "Queen";
	static int duration2 = 355;
	static Genre style2 = Genre.ROCK;

	static Tune tune = new Tune(title1, artist1, duration1, style1);

	public static void main(String[] args) {

		test1();
		test2();
		test3();
		test4();
	}

	public static void test1() {
		// Test ID: TC1
		// Testing the toString method for the Tune class
		System.out.println("\n------ Test Case TC1: Testing the 'toString' Method ------");
		System.out.println("Input Data: Title: " + title1 + ", Artist; " + artist1 + ", Duration: " + duration1
				+ ", Style: " + style1);
		System.out.println("Output from calling 'toString' method: \n" + tune.toString());
		System.out.println("------    Test Case TC1: End of Test Method    ------");
	}

	public static void test2() {
		// Test ID: TC2
		// Testing the get methods for the Tune class
		System.out.println("\n\n------ Test Case TC2: Testing the 'get' Methods ------");
		System.out.println("Input Data: Title: " + title2 + ", Artist; " + artist2 + ", Duration: " + duration2
				+ ", Style: " + style1);
		System.out.println("\nOutput of 'get' Methods:\ngetTitle: " + tune.getTitle() + "\ngetArtist: "
				+ tune.getArtist() + "\ngetDuration: " + tune.getDuration() + "\ngetGenre: " + tune.getStyle()
				+ "\ngetID: " + tune.getId() + "\ngetPlayCount: " + tune.getPlayCount());
		System.out.println("------    Test Case TC2: End of Test Method    ------");
	}

	public static void test3() {
		// Test ID: TC3
		// Testing the play method for the Tune class
		System.out.println("\n------ Test Case TC3: Testing the 'play' Method ------");
		System.out.println("Input Data: Title: " + title1 + ", Artist; " + artist1);
		System.out.println("Output from calling 'play' method \n" + tune.play());
		System.out.println("------ 	   Test Case TC3: End of Test Method    ------");
	}

	public static void test4() {
		// Test ID: TC4
		// Testing the play method for the Tune class
		System.out.println("\n------ Test Case TC4: Testing the 'play' Method updates the play count ------");
		System.out.println("Input Data: Title: " + title1 + ", Artist; " + artist1);
		System.out.println("Play count before calling 'play' method: " + tune.getPlayCount());
		System.out.println("Output from calling 'play' method: " + tune.play());
		System.out.println("Play count after calling 'play' method: " + tune.getPlayCount());
		System.out.println("------ 	   Test Case TC4: End of Test Method    ------");
	}
}
