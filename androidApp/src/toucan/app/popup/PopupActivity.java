package toucan.app.popup;

import toucan.app.R;
import toucan.app.Utils;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PopupActivity extends Activity {
	
	private static Utils utils;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup);
		Bundle extras = getIntent().getExtras();
		
		
		Utils utils = this.getUtils();
		Drawable pic = utils.ImageOperations(extras.getString("photoUrl"));
		
		ImageView iv = (ImageView)findViewById(R.id.infoImage);
		iv.setImageDrawable(pic);
		
		TextView text = (TextView)findViewById(R.id.descrip);
		text.setText(extras.getString("desc"));
		
		
	}
	
	private synchronized Utils getUtils(){
		if(utils == null){
			utils = new Utils(getResources());
		}
		return utils;
	}

}
