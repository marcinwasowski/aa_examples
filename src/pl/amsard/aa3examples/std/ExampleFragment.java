package pl.amsard.aa3examples.std;

import pl.amsard.aa3examples.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ExampleFragment extends Fragment {

	protected TextView txvNameFragment;

	protected String exampleArgument;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
	    Bundle args = this.getArguments();
	    if(args!=null){
        	this.exampleArgument = args.containsKey("exampleArgument") ? 
        			args.getString("exampleArgument") : null;
	    }
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        this.txvNameFragment = (TextView)view.findViewById(R.id.txvNameFragment);
        this.txvNameFragment.setText(this.getTag());
        
        
        return view;
    }
}
