package pojo;



public class Circuit {
	private String circuitId;

	private String url;
	private String circuitName;
	private Location Location;

	public String getCircuitId() {
		return circuitId;
	}
	public void setCircuitId(String circuitId) {
		this.circuitId = circuitId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCircuitName() {
		return circuitName;
	}
	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}
	public Location getLocation() {
		return Location;
	}
	public void setLocation(Location location) {
		Location = location;
	}
	public Circuit(String circuitId, String url, String circuitName, Location location) {
		this.circuitId = circuitId;
		this.url = url;
		this.circuitName = circuitName;
		Location = location;
	}


}
