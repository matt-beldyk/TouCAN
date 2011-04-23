package toucan.app.map;

import toucan.app.R;
import toucan.app.datamodel.AbstractLayer;
import toucan.app.datamodel.EmptyLayer;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;


public class IPMapFoo extends MapActivity {

	private MapView mapV;
	private MapController controller;
	
	private AbstractLayer points;

	@Override
	protected boolean isRouteDisplayed() {
		return true;
	}
	
	public IPMapFoo(AbstractLayer layer){
		super();
		this.points = layer;
		
	}
	
	public IPMapFoo(){
		super();
		this.points = new EmptyLayer();
	}
	
	protected void initMap(){
		this.mapV = (MapView) findViewById(R.id.ip_map);
		controller = this.mapV.getController();
		mapV.setSatellite(true);
		mapV.setBuiltInZoomControls(true);

		//show things on the map
		Drawable monMark = getResources().getDrawable(R.drawable.icon);
		monMark.setBounds(0,0,monMark.getIntrinsicWidth(),monMark.getIntrinsicHeight());
	}
	
    private void initMyLocation() {
        final MyLocationOverlay overlay = new MyLocationOverlay(this, mapV);
        overlay.enableMyLocation(); 
        //overlay.enableCompass(); // does not work in emulator
        overlay.runOnFirstFix(new Runnable() {
           public void run() {
        	   Log.d("", "First Location Found ");
              // Zoom in to current location
              controller.setZoom(16);
              controller.animateTo(overlay.getMyLocation());
           }
        });
        mapV.getOverlays().add(overlay);
     }
	/** Called with the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_view);
		this.initMap();
		this.initMyLocation();
	}
}
