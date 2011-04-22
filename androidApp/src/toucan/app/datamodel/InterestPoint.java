package toucan.app.datamodel;

import android.util.Log;

public class InterestPoint {
	private String photoUrl;
	private Double lat;
	
	private Double lon;
	private String description;
	
	
	public InterestPoint(String photoUrl, Double double1, Double double2,
			String description) {
		super();
		this.photoUrl = photoUrl;
		this.lat = double1;
		this.lon = double2;
		this.description = description;
		Log.d("", "Created Point at "+lat+", "+lon);
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
