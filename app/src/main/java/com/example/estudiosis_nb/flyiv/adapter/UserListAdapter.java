package com.example.estudiosis_nb.flyiv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.R;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.User;

import java.util.List;

public class UserListAdapter extends BaseAdapter {
    private List<User> listUsers;
    private Context context;
    private BtnClickListener mClickListener = null;

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUser(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public UserListAdapter(List<User> listUsers, Context context, BtnClickListener listener) {
        this.listUsers = listUsers;
        this.context = context;
        this.mClickListener = listener;
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

        TextView txtName = (TextView) view.findViewById(R.id.txtUserName);
        txtName.setText(user.getName());

        //TextView txtEmail = (TextView) view.findViewById(R.id.txtEmail);
        //txtEmail.setText(user.getEmail());

        Button btn = (Button) view.findViewById(R.id.btnShare);
        btn.setTag(i); //For passing the list item index

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(mClickListener != null)
                    mClickListener.onBtnClick((Integer) v.getTag());
            }
        });
        return view;
    }

    public interface BtnClickListener {
        public abstract void onBtnClick(int position);
    }
}
