package ke.co.sendy.casestudy.models;

/**
 * This class is a blueprint for the Location model
 *
 * @author Sammy Ukavi
 */
public class Location {
	
	private double latitude;
	
	private double longitude;
	private String name;
	
	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Location(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * Get the latitude of the location
	 *
	 * @return latitude of the location
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Set the latitude of the location
	 *
	 * @param latitude latitude of the location
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Get the longitude of the location
	 *
	 * @return longitude of the location
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Set the longitude of the location
	 *
	 * @param longitude longitude of the location
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * Get the name of a location
	 *
	 * @return name of the location
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of a location
	 *
	 * @param name name of the location
	 */
	public void setName(String name) {
		this.name = name;
	}
}
