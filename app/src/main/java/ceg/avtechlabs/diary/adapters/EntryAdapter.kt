package ceg.avtechlabs.diary.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView

import ceg.avtechlabs.diary.R
import ceg.avtechlabs.diary.models.DiaryEntry
import ceg.avtechlabs.diary.setQuiveraFont

/**
 * Created by adhithyan-3592 on 12/09/16.
 */

class EntryAdapter(private val entryList: List<DiaryEntry>) : RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {

    override fun getItemCount(): Int {
        return entryList.size
    }

    override fun onBindViewHolder(entryViewHolder: EntryViewHolder, i: Int) {
        val diaryEntry = entryList[i]
        entryViewHolder.dateTextView.text = diaryEntry.date

        if(diaryEntry.entry.length > 140) {
            entryViewHolder.entryTextView.text = diaryEntry.entry.substring(0, 138) + ".."
        } else
            entryViewHolder.entryTextView.text = diaryEntry.entry

        entryViewHolder.entryTextView.tag = diaryEntry.entry
        setAnimation(entryViewHolder.itemView, i)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EntryViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.diary_entry_item, viewGroup, false)

        return EntryViewHolder(itemView)
    }

    private fun setAnimation(view: View, position: Int) {
        val animation = AnimationUtils.loadAnimation(view.context, android.R.anim.slide_in_left)
        //val animation = AnimationUtils.loadAnimation(view.context, R.anim.card_anim)
        view.startAnimation(animation)
    }

    class EntryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var dateTextView: TextView
        var entryTextView: TextView

        init {

            dateTextView = v.findViewById(R.id.entry_card_item_date) as TextView
            entryTextView = v.findViewById(R.id.entry_card_item_entry) as TextView
            entryTextView.setQuiveraFont(v.context)

            v.setOnClickListener { Log.v("test", entryTextView.tag.toString()) }
            v.setOnCreateContextMenuListener { contextMenu, view, contextMenuInfo ->
                contextMenu.setHeaderTitle("Action")
                contextMenu.add("View entry")
                contextMenu.add("Edit entry")
            }
        }
    }

}
