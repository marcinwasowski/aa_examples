package pl.amsard.aa3examples.std;

import java.util.Date;

import pl.amsard.aa3examples.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleActivity extends Activity {

	private TextView txvName;	
	
	//Deklaracje
	private ImageView ivPhoto;
	private Button btnOthers;
	
	//Deklaracja ...
	private NotificationManager nManager;
	
	//Deklaracja ...
	private String applicationName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_simple);
		
		this.txvName = (TextView)findViewById(R.id.txvName);
		
		//A później w onCreate
		this.ivPhoto = (ImageView)findViewById(R.id.ivPhoto);
		this.btnOthers = (Button)findViewById(R.id.btnOthers);
		
		this.btnOthers.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View sender) {
				//Logika przejścia do listy
			}
		});
		
		this.ivPhoto.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View arg0) {
				//Pobranie następnego zdjęcia
				return false;
			}
		});
		
		Spanned photoTitleSpanned = Html.fromHtml(getString(R.string.photo_title)); 
		this.txvName.setText(photoTitleSpanned);
		
		// ... i pobranie
		this.nManager = (NotificationManager)
				this.getSystemService(Context.NOTIFICATION_SERVICE);
		
		
		
		this.nManager.cancelAll();
		
		// .... i pobranie
		this.applicationName = getResources().getString(R.string.app_name);
		
		Log.e(applicationName, applicationName);
		
		SharedPreferences prefs = this.getSharedPreferences(
				"pl.amsard.aa3examples", Context.MODE_PRIVATE);
		prefs.edit().putLong("timeKey", new Date().getTime()+3600).commit();
		long time = prefs.getLong("timeKey", new Date().getTime());
		
		Log.e("Time", time+"");
	}

}
