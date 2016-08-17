package ceg.avtechlabs.diary.db;

import android.content.DialogInterface;
import android.util.Log;

/**
 * Created by adhithyan-3592 on 17/08/16.
 */

public class Query {

    public void checkDb() {
        Diary d = Diary.findById(Diary.class, 1);
        Log.d("den", d.getDate());
        Log.d("den", d.getEntry());
    }
}
