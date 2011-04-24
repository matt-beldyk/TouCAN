package toucan.app.datamodel;

import java.util.ArrayList;

public class RandomLayer extends AbstractLayer {

	public RandomLayer(Integer count) {
		super();
		this.points = new ArrayList<InterestPoint>();
		for(Integer i = 0; i< count; ++i){
		//	this.points.add(new RandomInterestPoint(centerLat, centerLon));
			this.points.add(RandomPointFactory.getRandomPoint());
		}
	}

}
