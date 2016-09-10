package ceg.avtechlabs.diary

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import ceg.avtechlabs.diary.activities.DiaryEntryActivity
import ceg.avtechlabs.diary.db.Diary
import ceg.avtechlabs.diary.db.Query
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton?
        fab!!.setOnClickListener {
            val intent = Intent(this, DiaryEntryActivity::class.java)
            startActivity(intent)
            finish()
        }

        populateEntriesInList()
    }

    fun populateEntriesInList() {
        val entries = Query().tenEntries
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, entries);
        listView.adapter = adapter
    }
}
