package ceg.avtechlabs.diary

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import ceg.avtechlabs.diary.db.Diary
import ceg.avtechlabs.diary.db.Query
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by adhithyan-3592 on 17/08/16.
 */

fun saveEntry(date: String, entry: String): Boolean {
    val diary = Diary(date, entry)
    diary.save()
    return true
}

fun updateEntry(prevDate: String, currentDate: String, entry: String): Boolean {
    Query().update(prevDate, currentDate, entry)
    return true
}

fun formatDate(date: Int, month: Int, year: Int): String {
    val sb = StringBuilder()

    sb.append(date)
    sb.append("-")
    sb.append(month + 1) // month is indexed from 0 in std library
    sb.append("-")
    sb.append(year)

    return sb.toString()
}

fun TextView.setQuiveraFont(context: Context) {
    val quivera = Typeface.createFromAsset(context.assets, "quivira.otf")
    this.typeface = quivera
}