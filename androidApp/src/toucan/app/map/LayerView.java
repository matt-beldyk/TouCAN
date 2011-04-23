package toucan.app.map;

import java.util.ArrayList;
import java.util.List;

import toucan.app.datamodel.AbstractLayer;
import toucan.app.datamodel.EmptyLayer;
import toucan.app.datamodel.InterestPoint;

import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class LayerView extends ItemizedOverlay {
	private List<OverlayItem> interestOverlays = new ArrayList<OverlayItem>();
	private AbstractLayer points ;

	public LayerView(Drawable defaultMarker) {
		super(defaultMarker);
		setPoints(new EmptyLayer());
	}


	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setPoints(AbstractLayer points) {
		this.points = points;
		for(InterestPoint p: this.points.getInterestPoints()){
			GeoPoint tmp = new GeoPoint(latLon2int(p.getLat()), latLon2int(p.getLon()));
			interestOverlays.add(new OverlayItem(tmp, "Interest Point", p.getDescription()));
		}
	}

	protected int latLon2int(Double ll){
		return (int)(ll*1000000);
	}

	public AbstractLayer getPoints() {
		return points;
	}

}
