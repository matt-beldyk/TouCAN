package toucan.app.datamodel;

import java.util.Random;

public class RandomPointFactory {
	
	private final static double centerLat = 40.01;
	private final static double centerLon = -105.28;
	
	private final static String[] imgUrls = {
		"http://upload.wikimedia.org/wikipedia/commons/thumb/9/99/BoulderCityscape.jpg/240px-BoulderCityscape.jpg",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/8/80/Flatirons_Winter_Sunrise_edit_2.jpg/400px-Flatirons_Winter_Sunrise_edit_2.jpg",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Bouldercolorado.jpg/250px-Bouldercolorado.jpg",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Boulder_Theater_Night.jpg/220px-Boulder_Theater_Night.jpg",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Boulder_Pano_from_Fairview_HS_cropped.jpg/250px-Boulder_Pano_from_Fairview_HS_cropped.jpg",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/1/19/CU_Engineering_Dorms.jpg/220px-CU_Engineering_Dorms.jpg",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Naropa_University_campus.JPG/220px-Naropa_University_campus.JPG",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/b/be/The_Hill_in_Boulder_Colorado_Shot_2.JPG/220px-The_Hill_in_Boulder_Colorado_Shot_2.JPG",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Prairie-dog1.jpg/220px-Prairie-dog1.jpg",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/BoulderBearPeak.jpg/240px-BoulderBearPeak.jpg",
		"http://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Boulder.jpg/220px-Boulder.jpg",
		"http://upload.wikimedia.org/wikipedia/en/thumb/f/f5/MorkMindyHouse.jpg/170px-MorkMindyHouse.jpg"
	};
	private static Random rand = new Random();

	private static String getRandImgUrl(){
		return imgUrls[rand.nextInt(imgUrls.length)];
	}
	
	
	public static InterestPoint getRandomPoint(){
		String imgUrl = getRandImgUrl();
		InterestPoint ip = new InterestPoint(imgUrl, plusMinusRand(centerLat), plusMinusRand(centerLon), "derp");
		return ip;
	}

	static protected Double plusMinusRand(Double center){
		final Double randFactor = 0.1;
		return center + ( rand.nextGaussian() * randFactor);

	}
}
