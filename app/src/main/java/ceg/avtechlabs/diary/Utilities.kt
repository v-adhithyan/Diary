package ceg.avtechlabs.diary

import ceg.avtechlabs.diary.db.Diary
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

fun getToday(): String {
    val sb = StringBuilder()
    val cal = Calendar.getInstance()

    sb.append(cal.get(Calendar.DATE))
    sb.append("-")
    sb.append(cal.get(Calendar.MONTH) + 1)
    sb.append("-")
    sb.append(cal.get(Calendar.YEAR))

    return sb.toString()
}