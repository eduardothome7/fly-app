package com.example.estudiosis_nb.flyiv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.R;
import com.example.estudiosis_nb.flyiv.model.DictionaryChords;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.SongChord;

import java.util.List;

public class ChordGridAdapter extends BaseAdapter {
    private List<SongChord> chords;
    private Context context;

    public List<SongChord> getListRecords() {
        return chords;
    }
    private DictionaryChords dictionaryChords = new DictionaryChords();

    public void setListRecords(List<SongChord> listRecords) {
        this.chords= chords;
    }

    public ChordGridAdapter(List<SongChord> chords, Context context) {
        this.chords = chords;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return chords.size();
    }

    @Override
    public Object getItem(int position) {
        return chords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        SongChord songChord = chords.get(i);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.chord_item, null);

        TextView txtChordName = (TextView) view.findViewById(R.id.txtChord);
        txtChordName.setText(dictionaryChords.getChord(songChord.getPosition()).getName());

        TextView txtFrequency= (TextView) view.findViewById(R.id.txtFrequency);
        txtFrequency.setText("420hz");

        return view;
    }
}
