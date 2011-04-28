package toucan.app.inet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import toucan.app.datamodel.InterestPoint;

public class XmlLayerParser {



	public static List<InterestPoint> parse(InputStream iStream) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List<InterestPoint> points = new ArrayList<InterestPoint>();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document dom = builder.parse(iStream);
			Element root = dom.getDocumentElement();

			NodeList items = root.getElementsByTagName("interest-point");
			for(int i =0; i<items.getLength(); i++){
				String words = "";
				String photoUrl = "";
				Double lat = 0.0;
				Double lon = 0.0;

				Node item = items.item(i);
				NodeList infos = item.getChildNodes();
				for(int j = 0; j<infos.getLength(); j++){
					Node info = infos.item(j);
					String name = info.getNodeName();
					if(name.equalsIgnoreCase("words")){
						words = info.getFirstChild().getNodeValue();
					}else if (name.equalsIgnoreCase("lat")){
						lat = new Double( info.getFirstChild().getNodeValue());
					}else if (name.equalsIgnoreCase("lon")){
						lon = new Double (photoUrl = info.getFirstChild().getNodeValue());
					}
				}
				InterestPoint ip = new InterestPoint(photoUrl, lat, lon, words);
				points.add(ip);
			}


		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return points;


	}


}
