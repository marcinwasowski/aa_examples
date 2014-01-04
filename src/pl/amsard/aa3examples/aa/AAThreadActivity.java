package pl.amsard.aa3examples.aa;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.api.BackgroundExecutor;

import pl.amsard.aa3examples.R;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

@EActivity(R.layout.activity_thread)
public class AAThreadActivity extends Activity {

	@ViewById(R.id.txvProgress)
	protected TextView txvProgress;
	
	@Click(R.id.btnStart)
	protected void btnStartClick(){
		doOperation(100);
	}
	
	@Click(R.id.btnCancel)
	protected void btnCancelClick(){
		BackgroundExecutor.cancelAll("operation", true);
	}
	
	@Background(id="operation")
	protected void doOperation(int timeStep){
		long time = 0;
		try{
			for(int i = 0; i < 100; i++){
				Thread.sleep(timeStep);
				time += timeStep;
				showProgress(getString(R.string.progress, i));
			}
		}catch(InterruptedException e){
			showFinish(getString(R.string.finished, -1L));
		}
		showFinish(getString(R.string.finished, time));
	}
	
	@UiThread
	protected void showProgress(String message){
		this.txvProgress.setText(message);
	}
	
	@UiThread
	protected void showFinish(String message){
		this.txvProgress.setText(message);
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}
	
}


