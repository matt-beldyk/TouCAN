package toucan.app.map;

import java.util.List;

import toucan.app.R;
import toucan.app.datamodel.AbstractLayer;
import toucan.app.datamodel.EmptyLayer;
import toucan.app.datamodel.InterestPoint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;


public class IPMapFoo{

	private MapView mapV;
	private MapController controller;

	private AbstractLayer points;


	private MapActivity launcher;

	public IPMapFoo(AbstractLayer layer){
		super();
		this.points = layer;

	}

	public IPMapFoo(){
		super();
		this.points = new EmptyLayer();
	}

	public void setPoints(AbstractLayer points){
		this.points = points;
	}
	public void setLauncher(MapActivity ma){
		this.launcher = ma;
	}

	public void setMapView(MapView mv){
		this.mapV = mv;
	}

	public void initPoints(){
		Drawable mark = this.launcher.getResources().getDrawable(R.drawable.lmb);
		mark.setBounds(0,0,mark.getIntrinsicWidth(),mark.getIntrinsicHeight());
		
		
		PointsOverlay lv = new PointsOverlay(mark);
		lv.setPoints(points);
		List<Overlay> overlays = this.mapV.getOverlays();
		overlays.add(lv);


	}

	protected void initMap(){
		controller = this.mapV.getController();
		mapV.setSatellite(true);
		mapV.setBuiltInZoomControls(true);

		//show things on the map
	//	Drawable monMark = this.launcher.getResources().getDrawable(R.drawable.icon);
	//	monMark.setBounds(0,0,monMark.getIntrinsicWidth(),monMark.getIntrinsicHeight());
	}

	private void initMyLocation() {
		final MyLocationOverlay overlay = new MyLocationOverlay(this.launcher, mapV);
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

	
	
	public void init() {
		//	super.onCreate(savedInstanceState);
		//	setContentView(R.layout.map_view);
		this.initMap();
		this.initMyLocation();
		this.initPoints();
	}

}
