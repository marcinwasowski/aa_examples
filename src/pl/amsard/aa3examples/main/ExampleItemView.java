package pl.amsard.aa3examples.main;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import pl.amsard.aa3examples.R;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

@EViewGroup(R.layout.item_view_example)
public class ExampleItemView extends LinearLayout {

	@ViewById
	protected TextView txvTitleExampleIV;
	
	public ExampleItemView(Context context) {
		super(context);
		
	}
	
	public void bind(String title){
		this.txvTitleExampleIV.setText(title);
	}

}
