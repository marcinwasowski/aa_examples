package pl.amsard.aa3examples.std;

import pl.amsard.aa3examples.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ExampleFragmentActivity extends FragmentActivity {

	//Deklaracje ....
	protected ExampleFragment frgExample1;
	protected ExampleFragment frgTag3;
	
	protected ExampleFragment frgExample2;
	protected ExampleFragment frgTag4;

	protected String exampleExtra;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example_fragment);
		this.bindFragments();
		
		Bundle extras = this.getIntent().getExtras();
		this.exampleExtra = extras.containsKey("exampleExtra") ?
				extras.getString("exampleExtra") : "default_value";
				
	}
	
	
    private void bindFragments() {
    	
    	//....a następnie
    	frgExample1 = ((ExampleFragment) getSupportFragmentManager().findFragmentById(R.id.frgExample1));
    	frgTag3 = ((ExampleFragment) getSupportFragmentManager().findFragmentByTag("frgTag3"));
    	
    	
    	frgExample2 = ((ExampleFragment) getSupportFragmentManager().findFragmentById(R.id.frgExample2));
        frgTag4 = ((ExampleFragment) getSupportFragmentManager().findFragmentByTag("frgTag3"));
        
         
        
        
    }

}
