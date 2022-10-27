package part02;

import java.util.ArrayList;

import part01.MP3Player;
import part01.Tune;

public class Jukebox extends MP3Player {

	// amount of money accumulated in the Jukebox (in pence)
	private int moneyAdded;
	// cost (in pence) of a single credit
	private int costPerPlay;

	private ArrayList<Tune> jukeboxData = new ArrayList<Tune>();

	public Jukebox() {
		this.costPerPlay = 10;
		this.moneyAdded = 0;
		FileManager file = new FileManager();
		jukeboxData = file.loadData();
	}

	public void setCostPerPlay(int cost) {
		this.costPerPlay = cost;
	}

	public int insertCoin(int coin) {
		if (coin != 10 && coin != 20 && coin != 50 && coin != 100 && coin != 200) {
			return coin;
		} else {
			System.out.println(coin + "p added");
			this.moneyAdded += coin;
			return -1;
		}
	}

	/*
	 * a Tune can be played if there is enough money within the machine (based on
	 * costPerPlay). Should return a String (or null) in line with the playTune
	 * method in MP3Player
	 */

	@Override
	public String playTune(int tuneId) {

		if (this.moneyAdded > this.costPerPlay) {
			for (Tune tune : jukeboxData) {
				if ((tuneId) == tune.getId()) {
					this.moneyAdded = this.moneyAdded - this.costPerPlay;
					return tune.play();
				} else {
					return "Sorry, song cannot be found";
				}
			}
		}
		return "Sorry, not enough money";
	}

}
