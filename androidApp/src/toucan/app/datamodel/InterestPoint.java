package toucan.app.datamodel;

public class InterestPoint {
	private String photoUrl;
	private Float lat;
	
	private Float lon;
	private String description;
	
	
	public InterestPoint(String photoUrl, Float lat, Float lon,
			String description) {
		super();
		this.photoUrl = photoUrl;
		this.lat = lat;
		this.lon = lon;
		this.description = description;
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public Float getLon() {
		return lon;
	}
	public void setLon(Float lon) {
		this.lon = lon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
