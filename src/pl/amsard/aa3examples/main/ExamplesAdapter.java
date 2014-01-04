package pl.amsard.aa3examples.main;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.res.StringArrayRes;

import pl.amsard.aa3examples.main.ExampleItemView_;
import pl.amsard.aa3examples.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

@EBean
public class ExamplesAdapter extends BaseAdapter {

	@StringArrayRes(R.array.main_buttons_labels)
	protected String[] mainButtonsLabels;
	
	@RootContext
    protected Context context;
	
	@Override
	public int getCount() {
		return this.mainButtonsLabels.length;
	}

	@Override
	public String getItem(int position) {
		return this.mainButtonsLabels[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ExampleItemView item = (convertView == null) ? 
				ExampleItemView_.build(context) : (ExampleItemView)convertView;
		item.bind(this.mainButtonsLabels[position]);
		return item;
	}

}
