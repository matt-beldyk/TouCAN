package toucan.app;

import toucan.app.datamodel.AbstractLayer;
import toucan.app.datamodel.RandomLayer;
import toucan.app.datamodel.Rest2LayerAdaptor;
import toucan.app.map.IPMapFoo;
import toucan.app.map.ipLocationListener;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TouCAN extends MapActivity {

	private AbstractLayer iPoints;
	private IPMapFoo ipMapFoo;
	private MapView mv;
	private ipLocationListener locListener;
	
	public TouCAN(){
		super();
		ipMapFoo = new IPMapFoo();
		ipMapFoo.setLauncher(this);
	}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.server_picker);
		setUpListeners();
		Log.d("", "in TouCAN.onCreate");


	}
	
	protected void launchNavigationView(View currentContext){
	//	Intent myIntent = new Intent(currentContext.getContext(), IPMapFoo.class);
      //  startActivityForResult(myIntent, 0);
		
		//This needs to be before the call to findViewById
		//  Basically Activity keeps track of the current layout
		// and only looks for views and such within that layout
		//  I suppose it avoids namespace collisions
		// and the various views aren't in the global namespace
		setContentView(R.layout.map_view);

		mv = (MapView)findViewById(R.id.ip_map);
		Log.d("", "mv:"+mv+"  R.id.ip_map:"+R.id.ip_map);
		ipMapFoo.setMapView(mv);
		ipMapFoo.setLauncher(this);
		ipMapFoo.setPoints(this.iPoints);
		ipMapFoo.init();
		locListener.setLocs(iPoints);

		
	}

	public void setUpListeners(){


		//  Listener to create the random test points
		OnClickListener randClickListener = new OnClickListener(){
			public void onClick(View v) {

				Log.i("", "Random Points button clicked");
				// 20 Points around Boulder, CO
				iPoints = new RandomLayer(40, 40.01, -105.28);
				launchNavigationView(v);

			}};

			((Button)findViewById(R.id.rand_points_button)).setOnClickListener(randClickListener);


			// Listener to create the info from the server
			OnClickListener restClickListener = new OnClickListener(){
				public void onClick(View v) {
					Log.i("", "Rest Points Button clicked");
					String servAddr = ((EditText)findViewById(R.id.serv_addr_text)).getText().toString();
					String servPort = ((EditText)findViewById(R.id.serv_port_text)).getText().toString();
					
					iPoints = new Rest2LayerAdaptor(servAddr, new Integer(servPort));
					
					launchNavigationView(v);

				}

			};

			((Button)findViewById(R.id.load_points_button)).setOnClickListener(restClickListener);

			
			// Listener to to popup the info window
			OnClickListener popupClickListener = new OnClickListener(){
				public void onClick(View v) {
					Log.i("", "Popup button pressed");
					setContentView(R.layout.popup);

				
				}
			};
			
			((Button)findViewById(R.id.info_button)).setOnClickListener(popupClickListener);
	        LocationManager locMgr = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

			locListener = new ipLocationListener(this.getResources());
			locListener.setLauncher(this);
	        locMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1, locListener);


	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}
}