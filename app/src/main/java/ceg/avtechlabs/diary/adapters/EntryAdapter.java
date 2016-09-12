package ceg.avtechlabs.diary.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ceg.avtechlabs.diary.R;
import ceg.avtechlabs.diary.models.DiaryEntry;

/**
 * Created by adhithyan-3592 on 12/09/16.
 */

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.EntryViewHolder> {
    private List<DiaryEntry> entryList;

    public EntryAdapter(List<DiaryEntry>  entryList) {
        this.entryList = entryList;
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }

    @Override
    public void onBindViewHolder(EntryViewHolder entryViewHolder, int i) {
        DiaryEntry diaryEntry = entryList.get(i);
        entryViewHolder.dateTextView.setText(diaryEntry.getDate());
        entryViewHolder.entryTextView.setText(diaryEntry.getEntry());
    }

    @Override
    public EntryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.diary_entry_item, viewGroup, false);

        return new EntryViewHolder(itemView);
    }

    public static class EntryViewHolder extends RecyclerView.ViewHolder {
        protected TextView dateTextView;
        protected TextView entryTextView;

        public EntryViewHolder(View v) {
            super(v);

            dateTextView = (TextView) v.findViewById(R.id.entry_card_item_date);
            entryTextView = (TextView) v.findViewById(R.id.entry_card_item_entry);
        }
    }

}
