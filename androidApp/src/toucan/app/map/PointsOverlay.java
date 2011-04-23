package toucan.app.map;

import java.util.ArrayList;
import java.util.List;

import toucan.app.datamodel.AbstractLayer;
import toucan.app.datamodel.EmptyLayer;
import toucan.app.datamodel.InterestPoint;

import android.graphics.drawable.Drawable;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class PointsOverlay extends ItemizedOverlay<OverlayItem> {
	private List<OverlayItem> interestOverlays = new ArrayList<OverlayItem>();
	private List<InterestPoint> iPoints;
	private AbstractLayer points ;

	public PointsOverlay(Drawable defaultMarker) {
		super(defaultMarker);
		points = new EmptyLayer();
		iPoints = new ArrayList<InterestPoint>();
	}


	@Override
	protected OverlayItem createItem(int i) {

		return interestOverlays.get(i);
	}


	@Override
	public int size() {
		return interestOverlays.size();
	}


	public void setPoints(AbstractLayer points) {
		Log.d("LayerView", "setPoints called");
		
		iPoints.addAll(points.getInterestPoints());
		for(InterestPoint p: iPoints){
			Log.d("LayerView", "creating GeoPoint lat:"+p.getLat()+" lon:"+p.getLon());
			GeoPoint gp = new GeoPoint(
					latLon2int(p.getLat()),
					latLon2int(p.getLon())
					);

			interestOverlays.add(new OverlayItem(gp,"Interest Point", p.getDescription()));
			populate();
		}
		//populate();
	}

	protected int latLon2int(Double ll){
		return (int)(ll*1E6);
	}

	public AbstractLayer getPoints() {
		return points;
	}

}
