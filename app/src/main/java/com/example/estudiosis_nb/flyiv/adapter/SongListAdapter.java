package com.example.estudiosis_nb.flyiv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.R;
import com.example.estudiosis_nb.flyiv.model.Song;

import java.util.List;

public class SongListAdapter extends BaseAdapter {
    private List<Song> listSongs;
    private Context context;

    public List<Song> getListSongs() {
        return listSongs;
    }

    public void setListSongs(List<Song> listSongs) {
        this.listSongs = listSongs;
    }

    public SongListAdapter(List<Song> listSongs, Context context) {
        this.listSongs = listSongs;
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
        return listSongs.size();
    }

    @Override
    public Object getItem(int position) {
        return listSongs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Song song = listSongs.get(i);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.song_item, null);

        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtTitle.setText(song.getTitle());

        TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);
        txtDescription.setText(song.getTitle());

        TextView txtChords= (TextView) view.findViewById(R.id.txtChords);
        txtChords.setText(song.getChords());

        return view;
    }
}
