package ceg.avtechlabs.diary.db;

import android.content.DialogInterface;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import ceg.avtechlabs.diary.models.DiaryEntry;

/**
 * Created by adhithyan-3592 on 17/08/16.
 */

public class Query {

    public void checkDb() {
        Diary d = Diary.findById(Diary.class, 1);
        Log.d("den", d.getDate());
        Log.d("den", d.getEntry());
    }

    public List<DiaryEntry> getTenEntries() {
        List<Diary> diary = Diary.findWithQuery(Diary.class, "Select * from Diary limit 10");
        List<DiaryEntry> entries = new LinkedList<DiaryEntry>();

        for(Diary d: diary) {
            DiaryEntry de = new DiaryEntry(d.getDate(), d.getEntry());
            entries.add(de);
        }

        // if no entries are in db, then notify user
        if(entries.size() == 0)
            entries.add(new DiaryEntry("Oops", "No Diary entries found."));

        return entries;
    }
}
