package pl.amsard.aa3examples.aa;

import java.util.Date;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FromHtml;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.androidannotations.annotations.res.StringRes;
import org.androidannotations.annotations.sharedpreferences.Pref;

import pl.amsard.aa3examples.R;
import pl.amsard.aa3examples.aa.AAPrefs_;

import android.app.Activity;
import android.app.NotificationManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


@Fullscreen
@WindowFeature({Window.FEATURE_NO_TITLE})
@EActivity(R.layout.activity_simple)
public class AASimpleActivity extends Activity {

	@App
	protected AAExampleApplication app;
	
	
	@Bean
	protected AAMySingletonBean exampleSingletonBean;
	
	@Bean
	protected AAMyBean exampleBean;
	
	@SystemService
	protected NotificationManager nManager;
	
	@Pref
	protected AAPrefs_ prefs;
	
	@ViewById(R.id.txvName)
	@FromHtml(R.string.photo_title)
	protected TextView txvName;

	@ViewById(R.id.btnOthers)
	protected Button someButton;
	
	@ViewById
	protected ImageView ivPhoto;
	
	@StringRes(R.string.app_name)
	protected String applicationName;
	
	
	@Click(R.id.btnOthers)
	protected void btnOthersClick(View sender){
		//Logika przejścia do listy
		
		long time = prefs.time().getOr(new Date().getTime());
		this.prefs.edit().time().put(new Date().getTime()+3600).apply();
		this.prefs.clear();
		
		Log.e("Time", time+"");
	}
	
	@LongClick(R.id.ivPhoto)
	protected void ivPhotoLongClick(View sender){
		//Pobranie następnego zdjęcia
	}
	
}

