package ceg.avtechlabs.diary.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import ceg.avtechlabs.diary.R
import ceg.avtechlabs.diary.getToday
import ceg.avtechlabs.diary.saveEntry
import kotlinx.android.synthetic.main.activity_diary_entry.*

class DiaryEntryActivity : AppCompatActivity() {
    var hint: String? = null
    val today = getToday()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_entry)

        textview_date.text = today
        hint = applicationContext.getString(R.string.entry_hint)
        entry; //just to set on click listener for entry view
    }

    private val entry by lazy {
        edittext_entry.setOnClickListener({
            edittext_entry.hint = ""
            textview_diary_hint.text = hint
        })
        edittext_entry
    }

    fun save(v: View) {
        val save = saveEntry(today, entry.text.toString())
        if(save)
            Toast.makeText(this, "Diary entry added.", Toast.LENGTH_LONG).show()
    }
}
