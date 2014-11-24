package dev.rug.shyhi;

import android.app.Activity;

import java.util.ArrayList;

public class ListHelper {

    protected static ArrayList<MyObj> buildData() {
        ArrayList<MyObj> list = new ArrayList<MyObj>();

        MyObj obj = new MyObj("Gabriele", "This is the first message");
        list.add(obj);

        MyObj obj2 = new MyObj("Andrea", "This is the second message");
        list.add(obj2);

        MyObj obj3 = new MyObj("Gabriele", "This is the third message");
        list.add(obj3);

        return list;
    }

    // -----------------------------------------------------------------------------------------------------------


    public static ViewHolderAdapter buildViewHolderAdapter(Activity context,
                                                           int textViewResourceId) {

        ArrayList<MyObj> list = buildData();
        ViewHolderAdapter viewHolder = new ViewHolderAdapter(context, textViewResourceId);
        viewHolder.addAll(list);
        return viewHolder;
    }

    // -----------------------------------------------------------------------------------------------------------

}
