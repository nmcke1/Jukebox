package part01;

public enum Genre {

	ROCK("Rock and Roll"), POP("Easy Listening Pop"), DANCE("Techno Dance"),
	JAZZ("Smooth Jazz"), CLASSICAL("Classical"), OTHER("Unknown Genre");

	private String description;

	private Genre(String desc) {
		description = desc;		
	}

	public String toString() {
		return description;
	}
}
