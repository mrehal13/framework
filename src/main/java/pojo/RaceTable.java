package pojo;

import java.util.List;

public class RaceTable {
	private String season;
	private String round;
	private List<Races> Races;
	
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getRound() {
		return round;
	}
	public void setRound(String round) {
		this.round = round;
	}
	public List<Races> getRaces() {
		return Races;
	}
	public void setRaces(List<Races> races) {
		this.Races = races;
	}
	public RaceTable(String season, String round, List<Races> races) {

		this.season = season;
		this.round = round;
		this.Races = races;
	}
	
	
}
