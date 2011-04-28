package toucan.app.datamodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import toucan.app.inet.XmlLayerParser;

import android.util.Log;


public class Rest2LayerAdaptor extends toucan.app.datamodel.AbstractLayer {

	private String server;
	private Integer port;
	private String xml;
	private URL url;

	/**
	 * TODO fill in logic to pull in the results from the Rails server
	 * as a layer.  Maybe have a function w/ that logic or put it in the 
	 * constructor.
	 */


	public Rest2LayerAdaptor(String server, Integer port){
		this.server = server;
		this.port = port;
		try {
			this.url = new URL("http://"+this.server+":"+this.port+"/interest_point/list.xml");
			this.points = parseXml();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private HttpURLConnection getConnection(){
		HttpURLConnection con = null;

		try{
			con = (HttpURLConnection) url.openConnection();
			con.setReadTimeout(10000);
			con.setConnectTimeout(15000);
			con.setRequestMethod("GET");
			con.setDoInput(true);

			con.connect();
		}catch( IOException e){
			Log.e("", "oh noes, I has an error "+e);
		}
		return con;
	}

	protected List<InterestPoint> parseXml(){
		HttpURLConnection con = getConnection();

		try {
			return XmlLayerParser.parse(con.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ArrayList<InterestPoint>();
	}
	protected void grabXml(){
		HttpURLConnection con = getConnection();

		try{

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			StringBuilder ticker = new StringBuilder();

			String tmp;
			while((tmp = reader.readLine()) != null){
				ticker.append(tmp+"\n");
			}
			this.xml = ticker.toString();
			Log.i("", this.xml);


		}catch( IOException e){
			Log.e("", "oh noes, I has an error "+e);
		}finally{
			con.disconnect();
		}

	}



}
