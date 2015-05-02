package dev.rug.shyhi.test;

import java.util.ArrayList;

import dev.rug.shyhi.Message;
import dev.rug.shyhi.R;
import dev.rug.shyhi.convoAdapter;
import android.test.AndroidTestCase;
import android.view.View;
import android.widget.TextView;

public class ConvoActivityTest extends AndroidTestCase {
    	    private convoAdapter mAdapter;

    	    private Message msg1;
    	    private Message msg2;

    	    public ConvoActivityTest() {
    	        super();
    	    }

    	    protected void setUp() throws Exception {
    	        super.setUp();
    	        ArrayList<Message> data = new ArrayList<Message>();

    	        msg1 = new Message("Test1", "Test2", "Message Content","Time");
    	        msg2 = new Message("Test2", "Test1", "Message 2 Content","Time");
    	        data.add(msg1);
    	        data.add(msg2);
    	        mAdapter = new convoAdapter(getContext(), data);
    	    }


    	    public void testGetToId() {
    	        assertEquals("Test1", msg1.getToID(),
    	                ((Message) mAdapter.getItem(0)).getToID());
    	    }
    	    public void testGetFromId() {
    	        assertEquals("Test2", msg1.getFromID(),
    	                ((Message) mAdapter.getItem(0)).getFromID());
    	    }

    	    public void testGetMessage1() {
    	        assertEquals("Message 1 Test", msg1.getMessageNoQuotes(),
    	                ((Message) mAdapter.getItem(0)).getMessageNoQuotes());
    	    }
      	    public void testGetMessage2() {
    	        assertEquals("Message 2 Test", msg2.getMessageNoQuotes(),
    	                ((Message) mAdapter.getItem(1)).getMessageNoQuotes());
    	    }

    	    public void testGetCount() {
    	        assertEquals("Messages amount incorrect.", 2, mAdapter.getCount());
    	    }

    	    public void testGetView() {
    	        View view = mAdapter.getView(0, null, null);

    	        TextView messageView = (TextView) view
    	                .findViewById(R.id.recentMsg);

    	        assertNotNull("View is null. ", view);
    	        assertNotNull("Message TextView is null. ", messageView);

    	        assertEquals("Message is incorrect", msg1.getMessageNoQuotes(), messageView.getText());

    	    }
    	}
    
