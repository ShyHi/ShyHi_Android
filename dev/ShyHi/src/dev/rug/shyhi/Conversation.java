package dev.rug.shyhi;

import android.support.v7.app.ActionBarActivity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.view.LayoutInflater;


public class Conversation extends ListActivity{
	
	
	private EditText mNewMessage;
    private ImageButton mNewMessageSend;
    private ViewHolderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        mAdapter = ListHelper.buildViewHolderAdapter(this,
                R.layout.list_item);
        setListAdapter(mAdapter);



        mNewMessage = (EditText) findViewById(R.id.newmsg);
        mNewMessageSend = (ImageButton) findViewById(R.id.newmsgsend);
        if (mNewMessageSend!=null){
            mNewMessageSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addItem();
                }
            });
        }
    }



    private void addItem() {


        MyObj obj = new MyObj("Gabriele",mNewMessage.getText().toString());
        mAdapter.add(obj);

        mAdapter.notifyDataSetChanged();

    }
}
