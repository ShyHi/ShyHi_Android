package dev.rug.shyhi;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class ProgressPage extends ActionBarActivity {

	ImageView logo;
	TextView description;
	ProgressBar spinner; 			//Instantiated necessary variables
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_page);
		
		logo = (ImageView)findViewById(R.id.imageView1);
		description = (TextView)findViewById(R.id.textView1);
		spinner = (ProgressBar)findViewById(R.id.progressBar1);		//Connected variables to ids
		
			
	}

	  


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.progress_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void newConvo(){
		/*call server, 
		 	server should determine a user to chat with
			server should create and return the document
			app should create the new convo and send intent to start it
		*/
	}
}
