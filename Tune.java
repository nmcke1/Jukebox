 package part01;

public class Tune implements ITune {

	/**
	 * @param id       – a unique Tune identifier
	 * @param nextId   – usable Tune identifier
	 * @param title    – title
	 * @param artist   – artist
	 * @param duration – (in seconds) of the Tune
	 * @param style    – genre
	 * 
	 */
	private int id;
	private static int nextId = 1;
	private String title;
	private String artist;
	private int duration;
	private int playCount;
	private Genre style;

	/**
	 * The constructor for the Tune objects
	 *
	 * @param title
	 * @param artist
	 * @param duration
	 * @param genre
	 */
	public Tune(String title, String artist, int duration, Genre genre) {

		this.id = nextId;
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.style = genre;

		nextId++;

	}

	/**
	 * Returns a formatted String including all details of a Tune in single line.
	 */
	public String toString() {

		String str = "";
		str += "Title: " + this.getTitle();
		str += ", Artist: " + this.getArtist();
		str += ", Duration: " + this.getDuration();
		str += ", Style: " + this.getStyle();
		str += ", ID: " + this.getId();
		return str;
	}

	/**
	 * This method should return a String in the following format: “Now Playing ...
	 * Four Seasons Winter, by Vivaldi”
	 */
	public String play() {
		this.playCount++;
		return "Now playing... " + this.getTitle() + ", by " + this.getArtist();

	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getArtist() {
		return this.artist;
	}

	public int getDuration() {
		return this.duration;
	}

	public int getPlayCount() {
		return this.playCount;
	}

	public String getStyle() {
		return this.style.toString();
	}

}
