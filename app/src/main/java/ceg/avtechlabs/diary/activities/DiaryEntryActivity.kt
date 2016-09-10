package ceg.avtechlabs.diary.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import ceg.avtechlabs.diary.MainActivity
import ceg.avtechlabs.diary.R
import ceg.avtechlabs.diary.formatDate
import ceg.avtechlabs.diary.saveEntry
import kotlinx.android.synthetic.main.activity_diary_entry.*
import java.util.*

class DiaryEntryActivity : AppCompatActivity() {
    var hint: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_entry)

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
        if(validate()) {
            val saved = saveEntry(textview_date.text.toString(), entry.text.toString())
            //if entry is saved, go to main activity
            if(saved) {
                Toast.makeText(this, "Diary entry added.", Toast.LENGTH_LONG).show()
                goToMainActivity()
            }

        }

    }

    fun chooseDate(v: View) {
        showDatePicker()
    }

    fun dismiss(v: View) {
        goToMainActivity()
    }

    private fun showDatePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DATE)

        val datePicker = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {

            override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                textview_date.text = formatDate(dayOfMonth, monthOfYear, year)
            }

        }, year, month, day).show()

    }

    private fun validate(): Boolean {
        if(edittext_entry.text.toString().length == 0)  {
            edittext_entry.error = "Please fill this before saving."
            return false
        }
        return true
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
