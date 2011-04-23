package toucan.app;

import toucan.app.datamodel.AbstractLayer;
import toucan.app.datamodel.RandomLayer;
import toucan.app.datamodel.Rest2LayerAdaptor;
import toucan.app.map.IPMapFoo;

import com.google.android.maps.MapActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TouCAN extends MapActivity {

	AbstractLayer iPoints;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.server_picker);
		setUpListeners();

	}

	public void setUpListeners(){


		//  Listener to create the random test points
		OnClickListener randClickListener = new OnClickListener(){
			public void onClick(View v) {

				Log.i("", "Random Points button clicked");
				// 20 Points around Boulder, CO
				iPoints = new RandomLayer(20, 40.001, 105.6);
				setContentView(R.layout.map_view);

			}};

			((Button)findViewById(R.id.rand_points_button)).setOnClickListener(randClickListener);


			// Listener to create the info from the server
			OnClickListener restClickListener = new OnClickListener(){
				public void onClick(View v) {
					Log.i("", "Rest Points Button clicked");
					String servAddr = ((EditText)findViewById(R.id.serv_addr_text)).getText().toString();
					String servPort = ((EditText)findViewById(R.id.serv_port_text)).getText().toString();
					
					iPoints = new Rest2LayerAdaptor(servAddr, new Integer(servPort));
					
					
					Intent myIntent = new Intent(v.getContext(), IPMapFoo.class);
	                startActivityForResult(myIntent, 0);

				//	setContentView(R.layout.map_view);
				}

			};

			((Button)findViewById(R.id.load_points_button)).setOnClickListener(restClickListener);



	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}
}