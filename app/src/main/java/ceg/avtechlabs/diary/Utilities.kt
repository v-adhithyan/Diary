package ceg.avtechlabs.diary

import ceg.avtechlabs.diary.db.Diary

/**
 * Created by adhithyan-3592 on 17/08/16.
 */

fun saveEntry(date: String, entry: String) {
    val diary = Diary(date, entry)
    diary.save()
}