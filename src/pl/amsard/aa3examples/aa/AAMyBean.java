package pl.amsard.aa3examples.aa;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;


import android.app.Activity;
import android.content.Context;

@EBean
public class AAMyBean {

	@RootContext
	protected Context context;
	
	@RootContext
	protected Activity anyActivityContext;
	
	@RootContext
	protected AASimpleActivity exactActvityContext;
	
}
