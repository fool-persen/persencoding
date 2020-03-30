package com.persen.beijing.SpringConfig;

/**
 * Created by lijy on 2017/10/24.
 */
public class Counter {

	public  Counter() {
	}

	public  Counter(double multiplier, String song) {
		this.multiplier = multiplier;
		this.song = song;
	}

	private double multiplier;

	private String song;

	public double getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}


	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

}
