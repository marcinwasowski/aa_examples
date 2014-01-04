package pl.amsard.aa3examples.aa;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;

import android.app.Application;

@EApplication
public class AAExampleApplication extends Application {

	@Override
	public void onCreate(){
		super.onCreate();
		this.initializeTaskInBg();
	}
	
	@Background
	protected void initializeTaskInBg(){
		//Operacje
	}

}


