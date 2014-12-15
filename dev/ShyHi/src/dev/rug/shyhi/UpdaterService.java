package dev.rug.shyhi;

import org.json.JSONArray;
import org.json.JSONObject;

import dev.rug.shyhi.ConversationsActivity.ConvosResponseReceiver;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Log;
import android.content.Context;
import android.app.AlarmManager;

public class UpdaterService extends IntentService {
	private String userID;	
	RestUtils restUtils = new RestUtils();
	public static final String IN_EXTRA = "userIdExtra";
	public static final String OUT_EXTRA = "bool_extra";
	public static final String NOTIFY_EXTRA = "notifyExtra";
	public static boolean SELF_NOTIFY = false;
	NotificationManager mNotifyMgr;

	public UpdaterService(String name) {
		super(name);
	}
	public UpdaterService(){
		super("UpdaterService");
	}
	@Override
	protected void onHandleIntent(Intent intent) {
		  boolean updateBool = false;
		  userID = intent.getStringExtra(IN_EXTRA);
		  try {
			  String k = restUtils.getUpdateJSON(userID,Installation.SEQ_ID,true);
			  JSONObject j = new JSONObject(k);			  
			  if(!j.getString("results").equals("[]")) {
				  Intent mIntent = new Intent(this,ConversationsActivity.class);
				  mIntent.putExtra("idExtra",userID);
				  if(!SELF_NOTIFY){
					  startNotification("",mIntent);
				  }
				  updateBool = true;
			  }
			  Installation.SEQ_ID = j.getString("last_seq");

		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  Intent broadcastIntent = new Intent();
		  broadcastIntent.setAction(ConvosResponseReceiver.ACTION_RESP);
		  broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
		  broadcastIntent.putExtra(OUT_EXTRA, updateBool);
		  sendBroadcast(broadcastIntent);
		  scheduleNextUpdate();
	  }
	public void startNotification(String s,Intent i){
		  // Because clicking the notification opens a new ("special") activity, there's
		  // no need to create an artificial back stack.
		  PendingIntent resultPendingIntent =
		      PendingIntent.getActivity(
		      this,0,i,PendingIntent.FLAG_UPDATE_CURRENT
		  );
		  NotificationCompat.Builder mBuilder =
				    new NotificationCompat.Builder(this)
				    .setSmallIcon(R.drawable.shyhi_logo)
				    .setContentTitle("New Shy Message!");
		  mBuilder.setContentIntent(resultPendingIntent);
		  
		  mBuilder.setAutoCancel(true);
		// Sets an ID for the notification
		  int mNotificationId = 001;
		  // Gets an instance of the NotificationManager service
		  mNotifyMgr = 
		          (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		  // Builds the notification and issues it.
		  mNotifyMgr.notify(mNotificationId, mBuilder.build());
	  }
	private void scheduleNextUpdate()
	  {
	    Intent intent = new Intent(this, this.getClass());
	    intent.putExtra(IN_EXTRA, userID);
	    PendingIntent pendingIntent =
	        PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	    long currentTimeMillis = System.currentTimeMillis();
	    long nextUpdateTimeMillis = currentTimeMillis + 5000; // DateUtils.MINUTE_IN_MILLIS;
	    Time nextUpdateTime = new Time();
	    nextUpdateTime.set(nextUpdateTimeMillis);
	    SELF_NOTIFY = false;
	    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
	    alarmManager.set(AlarmManager.RTC, nextUpdateTimeMillis, pendingIntent);
	    }
}
