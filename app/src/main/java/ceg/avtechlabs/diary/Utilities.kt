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

fun formatDate(date: Int, year: Int, month: Int): String {
    val sb = StringBuilder()

    sb.append(date)
    sb.append("-")
    sb.append(year)
    sb.append("-")
    sb.append(month)

    return sb.toString()
}