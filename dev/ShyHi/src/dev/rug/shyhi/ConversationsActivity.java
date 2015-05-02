package dev.rug.shyhi;

import java.util.ArrayList;

import dev.rug.shyhi.ConvoActivity.ResponseReceiver;
import android.support.v7.app.ActionBarActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;



/*This activity will display the list view of all the users conversations
	it should handle retrieving all of the 
*/
public class ConversationsActivity extends ActionBarActivity {
	
	private ArrayList<Convo> convos;
	private CustomConvoAdapter adapter;
    private ConvosResponseReceiver receiver = new ConvosResponseReceiver();

	private String userID = Installation.getUUID();
	RestUtils restUtil = new RestUtils(); 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		if(intent.hasExtra("idExtra")){
			userID = intent.getStringExtra("idExtra");
		}
		setContentView(R.layout.activity_conversations);
		UpdaterService.SELF_NOTIFY = true;
		updateConvos();
		
		IntentFilter filter = new IntentFilter(ConvosResponseReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(receiver, filter);
        
	}
	public void updateConvos(){
		convos = restUtil.getAllConvos(userID);
		// pass context and data to the custom adapter
	    adapter = new CustomConvoAdapter(this, convos);
		ListView lv = (ListView)findViewById(R.id.shysList);	
	    //setListAdapter
		lv.setAdapter(null);
	    lv.setAdapter(adapter);
	    lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
			// selected item 
				Intent intent = new Intent(getApplicationContext(), ConvoActivity.class);
				String wQuotes = convos.get(position).getId();
				intent.putExtra("idExtra",wQuotes.subSequence(1, wQuotes.length()-1));
				startActivity(intent);
			}
		});
		String userID = Installation.getUUID();
		Intent intent = new Intent(this, UpdaterService.class);
		intent.putExtra(UpdaterService.IN_EXTRA, userID);
		startService(intent);
	}
	@Override
	protected void onResume(){
		super.onResume();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.conversations, menu);
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
	
	public class ConvosResponseReceiver extends BroadcastReceiver {
		   public static final String ACTION_RESP =    
		      "dev.rug.intent.action.MESSAGES_CHECKED";   
		   @Override
		    public void onReceive(Context context, Intent intent) {
			   if(intent.getBooleanExtra(UpdaterService.OUT_EXTRA, false)){
				   updateConvos();
			   }
			   		    }
		}
	
}
