package toucan.app.map;

import toucan.app.datamodel.InterestPoint;
import android.location.Location;

public class ipLocation extends Location {

	private InterestPoint ip;

	public ipLocation(InterestPoint ip){
		super("derp");
		this.setLatitude(ip.getLat());
		this.setLongitude(ip.getLon());
		this.ip = ip;
	}
	
	public String getDescription(){
		return ip.getDescription();
	}
	
	public String getPhotoUrl(){
		return ip.getPhotoUrl();
	}

}
