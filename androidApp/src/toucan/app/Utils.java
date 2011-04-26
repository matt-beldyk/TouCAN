package toucan.app;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Utils {
	private Resources resources;
	
	public Utils(Resources resc){
		this.resources = resc;
	}
	
	
	 public Drawable ImageOperations(String url) {
		try {
			URL imageUrl = new URL(url);
			InputStream is = (InputStream) imageUrl.getContent();
			Drawable d = Drawable.createFromStream(is, "src");
			return d;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return resources.getDrawable(R.drawable.error); 
		} catch (IOException e) {
			e.printStackTrace();
			return resources.getDrawable(R.drawable.error);
		}
	}
}
