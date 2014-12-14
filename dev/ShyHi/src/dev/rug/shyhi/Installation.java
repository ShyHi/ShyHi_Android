package dev.rug.shyhi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

import dev.rug.shyhi.ConvoActivity.putJSONAsync;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

public class Installation {
    private static String sID = null;
    private static final String INSTALLATION = "INSTALLATION";
    static RestUtils restUtils = new RestUtils();

    public synchronized static String id(Context context) {
        if (sID == null) {  
            File installation = new File(context.getFilesDir(), INSTALLATION);
            try {
                if (!installation.exists()){
                    writeInstallationFile(installation);
                    sID = readInstallationFile(installation);
                    newUser(sID);
                }
                sID = readInstallationFile(installation);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sID;
    }
    private static void newUser(String uid){
        User user = new User("\""+sID+"\"","\"lat\"", "\"long\"");
        Log.i("new userJson",user.getUserForPost());
  		new postJSONAsync().execute(RestUtils.dev_server_str+sID,user.getUserForPost());
    }
    private static String readInstallationFile(File installation) throws IOException {
        RandomAccessFile f = new RandomAccessFile(installation, "r");
        byte[] bytes = new byte[(int) f.length()];
        f.readFully(bytes);
        f.close();
        return new String(bytes);
    }

    private static void writeInstallationFile(File installation) throws IOException {
        FileOutputStream out = new FileOutputStream(installation);
        String id = UUID.randomUUID().toString();
        out.write(id.getBytes());
        out.close();
    }
    public static String getUUID(){
    	return sID;
    }
    
    public static class postJSONAsync extends AsyncTask<Object, Void, Void> {
	    @Override
	    protected Void doInBackground(Object... params) {
	            String url = (String) params[0];
	            String postStr = (String) params[1];
	            try {
					Log.i("New User",restUtils.putJSON(url,postStr,2));
				} catch (Exception e) {
					Log.i("post error","1");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            return null;
	    }
	}
}