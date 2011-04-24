package toucan.app.map;

import toucan.app.datamodel.InterestPoint;
import android.location.Location;

public class ipLocation extends Location {


	public ipLocation(InterestPoint ip){
		super("derp");
		this.setLatitude(ip.getLat());
		this.setLongitude(ip.getLon());
	}

}
