package toucan.app.datamodel;

import java.util.Random;

public class RandomInterestPoint extends InterestPoint {

	static private Random rand = new Random();

	public RandomInterestPoint(Double centerLat, Double centerLon){
		super("http://FIXME", plusMinusRand(centerLat), plusMinusRand(centerLon), "derp");
	}



	static protected Double plusMinusRand(Double center){
		final Double randFactor = 0.001;
		return center + ( rand.nextGaussian() * randFactor);

	}
}
