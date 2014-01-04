package pl.amsard.aa3examples.std;

import pl.amsard.aa3examples.R;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThreadActivity extends Activity {

	private TextView txvProgress;
	
	private Button btnStart;
	
	private Button btnCancel;
	
	private OperationTask task;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thread);
		
		this.btnCancel = (Button)findViewById(R.id.btnCancel);
		
		this.btnStart = (Button)findViewById(R.id.btnStart);
		
		this.txvProgress = (TextView)findViewById(R.id.txvProgress);
		
		this.btnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(task!=null && task.getStatus() == AsyncTask.Status.RUNNING){
					task.cancel(true);
				}
				task = new OperationTask();
				task.execute(100L);
				
			}
		});
		
		this.btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(task!=null && task.getStatus() == Status.RUNNING){
					task.cancel(true);
				}
			}
		});
	}
	
	private void showFinish(String message){
		this.txvProgress.setText(message);
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}
	
	private void showProgress(String message){
		this.txvProgress.setText(message);
	}
	
	private class OperationTask extends AsyncTask<Long, Integer, Long>
	{
		@Override
		protected Long doInBackground(Long... params) {
			long time = 0;
			try{
				for(int i = 0; i < 100; i++){
					Thread.sleep(params[0]);
					time += params[0];
					publishProgress(i);
					if (isCancelled()) break;
				}
			}catch(InterruptedException e){
				return -1L;
			}
			return time;
			
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			showProgress(getString(R.string.progress, values[0]));
		}
		
		@Override
		protected void onPostExecute(Long result) {
			showFinish(getString(R.string.finished, (long)result));
		}
		
	}
	
}


