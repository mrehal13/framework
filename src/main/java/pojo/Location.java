package pojo;

public class Location {

	private String lat;
	private String long1;
	private String locality;
	private String country;
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLong1() {
		return long1;
	}
	public void setLong1(String long1) {
		this.long1 = long1;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Location(String lat, String long1, String locality, String country) {
		this.lat = lat;
		this.long1 = long1;
		this.locality = locality;
		this.country = country;
	}
	
	
	
}
