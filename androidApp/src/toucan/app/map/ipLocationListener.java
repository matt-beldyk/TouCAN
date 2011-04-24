package toucan.app.map;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;


public class ipLocationListener implements android.location.LocationListener {

	@Override
	public void onLocationChanged(Location location) {
		if(location != null){
			Log.d("", "Oh hai I noticed a location change: "+location.getLatitude()+", "+location.getLongitude());	
		}else{
			Log.d("", "Derp, my location was null");
		}
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
