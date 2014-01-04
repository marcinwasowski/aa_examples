package pl.amsard.aa3examples.main;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import pl.amsard.aa3examples.R;
import pl.amsard.aa3examples.aa.AAExampleFragmentActivity_;
import pl.amsard.aa3examples.aa.AASimpleActivity_;
import pl.amsard.aa3examples.aa.AAThreadActivity_;
import pl.amsard.aa3examples.std.ExampleFragmentActivity;
import pl.amsard.aa3examples.std.SimpleActivity;
import pl.amsard.aa3examples.std.ThreadActivity;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	
	@ViewById(R.id.lsvExamples)
	protected ListView lsvExamples;
	
	@Bean
	protected ExamplesAdapter examplesAdapter;
	
	@AfterViews
	protected void afterViews(){
		this.lsvExamples.setAdapter(this.examplesAdapter);
	}
	
	@ItemClick(R.id.lsvExamples)
	protected void lsvExamplesItemClick(int position){
		switch (position) {
		case 0:
			//SimpleActivity
			startActivity(new Intent(this, SimpleActivity.class));
			break;
		case 1:
			//AASimpleActivity
			startActivity(new Intent(this, AASimpleActivity_.class));
			break;
		case 2:
			//ExampleFragmentActivity
			startActivity(new Intent(this, ExampleFragmentActivity.class));
			break;
		case 3:
			//AAExampleFragmentActivity
			startActivity(new Intent(this, AAExampleFragmentActivity_.class));
			break;
		case 4:
			//ThreadActivity
			startActivity(new Intent(this, ThreadActivity.class));
			break;
		case 5:
			//AAExampleFragmentActivity
			startActivity(new Intent(this, AAThreadActivity_.class));
			break;
		default:
			break;
		}
	}
	

}
