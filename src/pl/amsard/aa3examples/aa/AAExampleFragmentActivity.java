package pl.amsard.aa3examples.aa;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.FragmentByTag;

import pl.amsard.aa3examples.R;

import android.support.v4.app.FragmentActivity;


@EActivity(R.layout.activity_aa_example_fragment)
public class AAExampleFragmentActivity extends FragmentActivity {

	@FragmentById(R.id.frgExample1)
	protected AAExampleFragment frgExample1;
	@FragmentByTag("frgTag3")
	protected AAExampleFragment frgTag4;
	
	
	@FragmentById
	protected AAExampleFragment frgExample2;

	@FragmentByTag
	protected AAExampleFragment frgTag3;
	
	@Extra
	protected String exampleExtra = "default_value";
	
	@AfterViews
	protected void afterViews(){
		
	}
	

}