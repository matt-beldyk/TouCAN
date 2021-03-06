package toucan.app.map;

import java.util.ArrayList;
import java.util.List;

import com.google.android.maps.MapActivity;

import toucan.app.R;
import toucan.app.TouCAN;
import toucan.app.Utils;
import toucan.app.datamodel.AbstractLayer;
import toucan.app.datamodel.InterestPoint;
import toucan.app.popup.PopupActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ipLocationListener implements android.location.LocationListener {

	private List<ipLocation> locs;
	private TouCAN launcher;
	private Resources resources;
	Utils utils;

	private final static float CLOSE_ENOUGH_DIST = 100; //in Meters

	public ipLocationListener(Resources rec){
		this.resources = rec;
		utils = new Utils(this.resources);
		locs = new ArrayList<ipLocation>();
	}

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

		Intent i = new Intent(launcher, PopupActivity.class);
		i.putExtra("photoUrl", l.getPhotoUrl());
		i.putExtra("desc", l.getDescription());
		launcher.startActivity(i);

		/*
		launcher.setContentView(R.layout.popup);
		TextView text = (TextView)launcher.findViewById(R.id.descrip);
		text.setText(l.getDescription());

		Drawable pic = utils.ImageOperations(l.getPhotoUrl());
		ImageView iv = (ImageView)launcher.findViewById(R.id.infoImage);
		iv.setImageDrawable(pic);

		OnClickListener bk2map = new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//launcher.getMapView().setVisibility(View.VISIBLE);
				//launcher.getPopupView().setVisibility(View.INVISIBLE);

				launcher.setContentView(launcher.getMapView());
			}

		};

		((Button)launcher.findViewById(R.id.back2mapButton)).setOnClickListener(bk2map);

		 */
	}

	public void setLauncher(TouCAN ma){
		this.launcher = ma;
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
