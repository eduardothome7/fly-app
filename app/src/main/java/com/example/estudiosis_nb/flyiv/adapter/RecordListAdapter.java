package com.example.estudiosis_nb.flyiv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.R;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.Song;

import java.util.List;

public class RecordListAdapter extends BaseAdapter {
    private List<Record> listRecords;
    private Context context;

    public List<Record> getListRecords() {
        return listRecords;
    }

    public void setListRecords(List<Record> listRecords) {
        this.listRecords= listRecords;
    }

    public RecordListAdapter(List<Record> listRecords, Context context) {
        this.listRecords = listRecords;
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
        return listRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return listRecords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Record record = listRecords.get(i);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.record_item, null);

        TextView txtDuration = (TextView) view.findViewById(R.id.txtDuration);
        txtDuration.setText(record.getMinutes());

        return view;
    }
}
