package com.cesit.linkedlisttestapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by JAYAPRAKASH-FGTS on 20-02-2018.
 */

public class NodeRecyclerViewAdapter extends RecyclerView.Adapter<NodeRecyclerViewAdapter.ViewHolder> {

    private ArrayList<LinkedListNode> mData = new ArrayList<LinkedListNode>();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public NodeRecyclerViewAdapter(Context context, ArrayList<LinkedListNode> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LinkedListNode node = mData.get(position);
        holder.textViewNextHash.setText(String.valueOf(node.nextHash));
        holder.textViewNodeValue.setText(node.strAddedValue);
        holder.textViewPrevHash.setText(String.valueOf(node.previousHash));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }



    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewPrevHash;
        public TextView textViewNodeValue;
        public TextView textViewNextHash;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewPrevHash = itemView.findViewById(R.id.tvPrevHash);
            textViewNodeValue= itemView.findViewById(R.id.tvNodeName);
            textViewNextHash= itemView.findViewById(R.id.tvNextHash);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public LinkedListNode getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
