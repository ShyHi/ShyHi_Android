package dev.rug.shyhi;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ConvoActivity extends ActionBarActivity {

	private Installation installation = new Installation();
	private String restUrl = RestUtils.get_convo_view_str;
	RestUtils restUtil = new RestUtils();
	private Convo convo;
	private String userID = installation.getUUID();
	private ArrayList<Message> messages;
	private convoAdapter adapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversation);
		//get convo id, which will be passed as an intent extra
		Intent intent = getIntent();
		String intentID = intent.getStringExtra("idExtra");
		convo = restUtil.getConvoById(intentID);
		if(convo.hasMessages())
			messages = convo.getMessages();
		else
			messages = new ArrayList<Message>();
		// pass context and data to the custom adapter
	    adapter = new convoAdapter(this, messages);
		ListView lv = (ListView)findViewById(R.id.msgsLv);	
	    //setListAdapter
	    lv.setAdapter(adapter);
	}

	@Override
	protected void onResume(){
		super.onResume();
		
		adapter.notifyDataSetChanged();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.convo, menu);
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
	
	public void putMessage(String msg){
		String otherUser;
		if(convo.getUser1().equals("\""+userID+"\"")){
			otherUser = convo.getUser2();
		}
		else{
			otherUser = convo.getUser1();
		}
		Message msgObj = new Message(otherUser,"\""+userID+"\"","\"timestamp\"",msg);
		convo.addMessage(msgObj);
		String convoStr = convo.toStringForPut();
		try {
			String idStr = convo.getId().substring(1,convo.getId().length()-1);
			String putUrl = getString(R.string.dev_server)+idStr;
			new putJSONAsync().execute(putUrl,convoStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(messages.isEmpty()){
			messages = convo.getMessages();
			adapter = null;
			adapter = new convoAdapter(this, messages);
			ListView lv = (ListView)findViewById(R.id.msgsLv);	
		    //setListAdapter
		    lv.setAdapter(adapter);
		}
	}
	
	public void sendMessage(View v){
		EditText messageET = (EditText) findViewById(R.id.newmsg);
		if(!messageET.getText().toString().equals("")){
			String newMsg = "\""+messageET.getText().toString()+"\"";
			putMessage(newMsg);
			adapter.notifyDataSetChanged();
			messageET.setText("");
		}
	}
	public class putJSONAsync extends AsyncTask<Object, Void, Void> {
	    @Override
	    protected Void doInBackground(Object... params) {
	            String url = (String) params[0];
	            String putStr = (String) params[1];
	            try {
					convo.setRev(restUtil.putJSON(url,putStr,1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            return null;
	    }
	}
}
