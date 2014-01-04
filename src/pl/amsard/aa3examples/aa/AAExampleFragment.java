package pl.amsard.aa3examples.aa;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import pl.amsard.aa3examples.R;

import android.support.v4.app.Fragment;
import android.widget.TextView;

@EFragment(R.layout.fragment_example)
public class AAExampleFragment extends Fragment {
	
	@FragmentArg("exampleArgument")
	protected String exampleArgument;

	@ViewById(R.id.txvNameFragment)
	protected TextView txvNameFragment;
	
	@AfterViews
	protected void afterViews(){
		this.txvNameFragment.setText(this.getTag());
	}
	
	public void setText(String text){
		this.txvNameFragment.setText(text);	
	}
	

}
