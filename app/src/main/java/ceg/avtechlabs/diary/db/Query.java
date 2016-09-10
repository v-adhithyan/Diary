package ceg.avtechlabs.diary.db;

import android.content.DialogInterface;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adhithyan-3592 on 17/08/16.
 */

public class Query {

    public void checkDb() {
        Diary d = Diary.findById(Diary.class, 1);
        Log.d("den", d.getDate());
        Log.d("den", d.getEntry());
    }

    public List<String> getTenEntries() {
        List<Diary> diary = Diary.findWithQuery(Diary.class, "Select * from Diary limit 10");
        List<String> entries = new LinkedList<String>();

        for(Diary d: diary) {
            entries.add(d.getEntry());
        }

        // if no entries are in db, then notify user
        if(entries.size() == 0)
            entries.add("No Diary entries found.");

        return entries;
    }
}
