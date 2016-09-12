package ceg.avtechlabs.diary.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import ceg.avtechlabs.diary.R
import ceg.avtechlabs.diary.models.DiaryEntry

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
        entryViewHolder.entryTextView.text = diaryEntry.entry
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EntryViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.diary_entry_item, viewGroup, false)

        return EntryViewHolder(itemView)
    }

    class EntryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var dateTextView: TextView
        var entryTextView: TextView

        init {

            dateTextView = v.findViewById(R.id.entry_card_item_date) as TextView
            entryTextView = v.findViewById(R.id.entry_card_item_entry) as TextView
        }
    }

}
