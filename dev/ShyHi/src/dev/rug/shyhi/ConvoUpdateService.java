package dev.rug.shyhi;

import org.json.JSONObject;

import dev.rug.shyhi.ConvoActivity.ResponseReceiver;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class ConvoUpdateService extends IntentService {
	RestUtils restUtils = new RestUtils();
	String convoID;
	public static final String IN_EXTRA = "convoIdExtra";
	public static final String OUT_EXTRA = "bool_extra";
	public ConvoUpdateService(String name) {
		super(name);
	}
	public ConvoUpdateService() {
		super("ConvoUpdateService");
	}
	  @Override
	  protected void onHandleIntent(Intent intent) {
		  boolean updateBool = false;
		  convoID = intent.getStringExtra(IN_EXTRA);
		  try {
			  JSONObject j = new JSONObject(restUtils.getUpdateJSON(convoID,"",false));
			  if(!j.getString("results").equals("[]")) 
				  updateBool = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		  Intent broadcastIntent = new Intent();
		  broadcastIntent.setAction(ResponseReceiver.ACTION_RESP);
		  broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
		  broadcastIntent.putExtra(OUT_EXTRA, updateBool);
		  sendBroadcast(broadcastIntent);  
	  }
	
}
