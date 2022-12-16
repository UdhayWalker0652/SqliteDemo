package com.sqlite.demodbapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private final List<DbModel> listdata;
    private final CallBack callBack;

    // RecyclerView recyclerView;
    public MyListAdapter(List<DbModel> listdata, CallBack callBack) {
        this.listdata = listdata;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DbModel myListData = listdata.get(position);
        holder.textView.setText(myListData.getTitle());
        holder.textUpdate.setOnClickListener(view -> {
            callBack.onClick(listdata.get(position), "update");
            Toast.makeText(view.getContext(), "clicked on item to update: " + myListData, Toast.LENGTH_LONG).show();
        });
        holder.textDel.setOnClickListener(view -> {
            callBack.onClick(listdata.get(position), "delete");
            Toast.makeText(view.getContext(), "clicked on item to delete: " + myListData, Toast.LENGTH_LONG).show();
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView, textDel, textUpdate;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView);
            this.textDel = itemView.findViewById(R.id.textDel);
            this.textUpdate = itemView.findViewById(R.id.textUpdate);
        }
    }

    interface CallBack {
        void onClick(DbModel dbModel, String type);
    }
}
