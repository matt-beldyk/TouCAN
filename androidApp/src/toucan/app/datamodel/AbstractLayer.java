package toucan.app.datamodel;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractLayer {
	Collection<InterestPoint> points;
	
	public AbstractLayer(){
		this.points = new ArrayList<InterestPoint>();
	}
	
	/**
	 * by Default we don't want to return a way to access our inner state
	 * @return
	 */
	 public Collection<InterestPoint> getInterestPoints() {
		 return new ArrayList<InterestPoint>(points);
	 }
	
	 public void setInterestPoints(Collection<InterestPoint> points){
		 this.points = points;
	 }
	
	 public void addInterestPoint(InterestPoint point){
		 this.points.add(point);
		 
	 }
}
