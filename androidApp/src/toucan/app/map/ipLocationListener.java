package toucan.app.map;

import java.util.ArrayList;
import java.util.List;

import toucan.app.datamodel.AbstractLayer;
import toucan.app.datamodel.InterestPoint;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;


public class ipLocationListener implements android.location.LocationListener {

	private List<ipLocation> locs;

	private final static float CLOSE_ENOUGH_DIST = 100; //in Meters

	public void setLocs(AbstractLayer layer){
		locs = new ArrayList<ipLocation>();
		for(InterestPoint p: layer.getInterestPoints()){
			locs.add(new ipLocation(p));
		}
	}

	@Override
	public void onLocationChanged(Location location) {
		if(location != null){
			Log.d("", "Oh hai I noticed a location change: "+location.getLatitude()+", "+location.getLongitude());	
			for(ipLocation l: locs){
				Float dist = location.distanceTo(l);
				Log.d("", "distance to "+l.getLatitude()+", "+l.getLongitude()+ " is "+ dist+" Meters");
				if(dist < CLOSE_ENOUGH_DIST){
					locationIsCloseEnough(l);
				}
			}

		}else{
			Log.d("", "Derp, my location was null");
		}
	}

	public void locationIsCloseEnough(ipLocation l){
		Log.d("", "YAY, I found a location that's pretty close: "+l.getLatitude()+", "+ l.getLongitude());

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
