package com.example.estudiosis_nb.flyiv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.R;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.User;

import java.util.List;

public class UserListAdapter extends BaseAdapter {
    private List<User> listUsers;
    private Context context;

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUser(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public UserListAdapter(List<User> listUsers, Context context) {
        this.listUsers = listUsers;
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
        return listUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return listUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        User user = listUsers.get(i);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.user_list_item, null);

        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        txtName.setText(user.getName());

        TextView txtEmail = (TextView) view.findViewById(R.id.txtEmail);
        txtEmail.setText(user.getEmail());

        return view;
    }
}
