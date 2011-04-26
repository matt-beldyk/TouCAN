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

	private final static String[] descrips = {
		"The first recorded European settlers in the area were gold prospectors who arrived in 1858, when Boulder was part of the Nebraska Territory (The former boundary between Nebraska and Kansas territories is the present Baseline Road in Boulder).",
		"On November 7, 1861 legislation was passed making way for the state university to be located in Boulder and on September 20, 1875 the first corner stone was for the first building (Old Main Building) on the C.U. campus. The university officially opened on September 5, 1877.",
		"Boulder has a rather dry climate typical of much of the state, and receives upwards of 300 sunny or mostly sunny days each year.[17] Under the Köppen climate classification, central parts of the city have a semi-arid climate (Köppen BSk).",
		"There are world class hiking trails throughout the city. The most popular areas to hike are in Chautauqua Park. Many of the trails start at the Western edge of the city, while others are a short drive away. The trails vary in difficulty: some are quite easy while there are some that are technically challenging.",
		"Shorter summit hikes include Flagstaff and Mount Sanitas to the North. Mountain biking single track to the South. North Boulder is the road biker's most popular start point. There is an abundance of rock climbing for all skill levels. The primary climbing areas are Eldorado Canyon (traditional protection), The Flat Irons (traditional protection) and Boulder Canyon (sport).",
		"BIFF is held each February by the Colorado Film Society, a nonprofit organization founded by local filmmakers Kathy and Robin Beeck. BIFF is dedicated to providing the urban, film–hip audiences of the Denver/Boulder metro area with an early look at the best new films in international cinema. There also are conversations with directors, producers, and actors; world–class food and parties; and an opportunity to rub elbows with filmmakers in a winter wonderland. ",
		"On Wednesday nights from June through mid-August, local bands perform on the Pearl Street Mall just south of the Courthouse. Bands on the Bricks, as the event is called, features a different band each week, with styles ranging from zydeco to oldies, and bluegrass to funk. Buskers are frequently in downtown Boulder especially on warm days and weekends.",
		"The lighted star on Flagstaff is a familiar symbol in Boulder. First turned on as a Christmas decoration in December 1947, the star survived several controversies to become what it is today—part of the area’s history and culture. In April 1948, the Boulder Chamber of Commerce converted the star into an Easter cross. Then, for two decades, the long string of lights alternated between the two symbols. ",
		"Every year during Memorial Day Weekend, a three-day festival takes place along Canyon Boulevard. Local vendors participate by setting up tents and selling their products, but the festival itself is free of charge. It features unique flavors of food and live music stages with performers young and old. In addition, there are activities for children, art shows, and a rubber duck race along Boulder Creek. Often, people who participated in the Bolder Boulder stop by after running. Sponsorships are run by Boulder Creek Events.",
		"Every Thursday, a group of cruiser bike riders meet to ride their cycles on various streets, alleys and bike paths in an outpouring of creativity and love for bicycles, shouting \"Happy Thursday!\" to onlookers.",
		"Under Boulder law, extermination of prairie dogs requires a permit."
	};


	private static Random rand = new Random();

	private static String getRandImgUrl(){
		return imgUrls[rand.nextInt(imgUrls.length)];
	}

	private static String getRandDesc(){
		return descrips[rand.nextInt(descrips.length)];
	}

	public static InterestPoint getRandomPoint(){
		String imgUrl = getRandImgUrl();
		String descrip = getRandDesc();
		InterestPoint ip = new InterestPoint(imgUrl, plusMinusRand(centerLat),
				plusMinusRand(centerLon), descrip);
		return ip;
	}

	static protected Double plusMinusRand(Double center){
		final Double randFactor = 0.1;
		return center + ( rand.nextGaussian() * randFactor);

	}
}
