package dev.rug.shyhi.test;

import java.util.ArrayList;

import dev.rug.shyhi.ConversationsActivity;
import dev.rug.shyhi.Convo;
import dev.rug.shyhi.CustomConvoAdapter;
import dev.rug.shyhi.Message;
import dev.rug.shyhi.R;
import dev.rug.shyhi.convoAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityUnitTestCase;
import android.test.AndroidTestCase;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ConversationsActivityTest extends ActivityUnitTestCase<ConversationsActivity> {
	 private CustomConvoAdapter mAdapter;

	    private Convo convo;
	    private Convo convo2;
	    private Message msg1;
	    private Message msg2;
	    private Message msg3;
	    private Message msg4;

	    public ConversationsActivityTest() {
	        super(ConversationsActivity.class);
	    }

	    protected void setUp() throws Exception {
	        super.setUp();
	        ArrayList<Message> msgs1 = new ArrayList<Message>();
	        ArrayList<Message> msgs2 = new ArrayList<Message>();
	        ArrayList<Convo> convos = new ArrayList<Convo>();
	        
	        msg1 = new Message("Test1", "Test2", "Message Content","Time");
	        msg2 = new Message("Test2", "Test1", "Message 2 Content","Time");
	        msg3 = new Message("Test3", "Test4", "Message 3 Content","Time");
	        msg4 = new Message("Test4", "Test3", "Message 4 Content","Time");
	        msgs1.add(msg1);
	        msgs1.add(msg2);
	        msgs2.add(msg3);
	        msgs2.add(msg4);
	        convo = new Convo("testConvo" , "testUser1", "testUser2", msgs1);
	        convo2 = new Convo("testConvo2" , "testUser1", "testUser2", msgs2);
	        mAdapter = new CustomConvoAdapter(convos);
	    }


	    public void testGetConvo1() {
	        assertEquals("Test1", convo.getId(),
	                ((Convo) mAdapter.getItem(0)).getId());
	    }
	    public void testGetConvo2() {
	        assertEquals("Test2", convo2.getId(),
	                ((Convo) mAdapter.getItem(1)).getId());
	    }
	    public void testGetCount() {
	        assertEquals("Messages amount incorrect.", 2, mAdapter.getCount());
	    }
	    
	    public void testGetView() {
	        View view = mAdapter.getView(0, null, null);

	        TextView shyView = (TextView) view
	                .findViewById(R.id.textView3);

	        assertNotNull("View is null. ", view);
	        assertNotNull("Message TextView is null. ", shyView);

	        assertEquals("Convo 1 recent message is incorrect", convo.getMostRecentMessage(), shyView.getText());
	        assertEquals("Convo 2 recent message is incorrect", convo2.getMostRecentMessage(), shyView.getText());

	    }
	}