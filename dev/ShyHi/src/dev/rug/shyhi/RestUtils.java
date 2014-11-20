package dev.rug.shyhi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;


//helper utility class for calling rest and getting json objects
public class RestUtils {
	

	public RestUtils(){};
	
	public Convo getConvoById(String convoID){
		Convo convo = null;
    	String convoStr = getJSON("http://104.236.22.60:5984/shyhi/_design/conversation/_view/get_convos?key=%22"+convoID+"%22");
		Gson gson = new Gson();
		Log.i("getConvoById",convoStr);
    	return convo;
	}
	
	public ArrayList<Convo> getAllConvos(String key){
    	String allConvosStr = getJSON("http://104.236.22.60:5984/shyhi/_design/conversation/_view/get_all_convos?key=%22"+key+"%22");
    	ArrayList<Convo> convoArr = null;
    	//turn the allConvosStr into a java object
    	return convoArr;
    }
	
	public void updateConvo(Convo convo){
		//send convo to couchdb and update
	}
	
	
	//helper method to get the JSON object
    public String getJSON(String address){
    	StringBuilder builder = new StringBuilder();
    	HttpClient client = new DefaultHttpClient();
    	HttpGet httpGet = new HttpGet(address);
    	try{
    		HttpResponse response = client.execute(httpGet);
    		StatusLine statusLine = response.getStatusLine();
    		int statusCode = statusLine.getStatusCode();
    		if(statusCode == 200){
    			HttpEntity entity = response.getEntity();
    			InputStream content = entity.getContent();
    			BufferedReader reader = new BufferedReader(new InputStreamReader(content));
    			String line;
    			while((line = reader.readLine()) != null){
    				builder.append(line);
    			}
    		} else {
    			Log.e(MainActivity.class.toString(),"Failed to get JSON object");
    		}
    	}catch(ClientProtocolException e){
    		e.printStackTrace();
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    	return builder.toString();
    }
    
    
    //add a function that takes in a conversation and then returns the conversation updated
    
  
}