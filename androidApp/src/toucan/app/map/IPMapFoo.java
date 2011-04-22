package toucan.app.map;

import toucan.app.R;
import android.graphics.drawable.Drawable;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


public class IPMapFoo extends MapActivity {

	private MapView map;
	private MapController controller;

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	public IPMapFoo(){
		super();
		map = (MapView) findViewById(R.id.map);
		controller = map.getController();
		map.setSatellite(true);
		map.setBuiltInZoomControls(true);

		//slap some monsters on the screen
		Drawable monMark = getResources().getDrawable(R.drawable.icon);
		monMark.setBounds(0,0,monMark.getIntrinsicWidth(),monMark.getIntrinsicHeight());
	}
}
