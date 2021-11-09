package com.panditprogrammer.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {
    private String[] stringArray;

    public TestAdapter(String[] stringArray) {
        this.stringArray = stringArray;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create layoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.miniitem,parent,false);
        return new TestViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return stringArray.length;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        String item = stringArray[position];
        holder.textView.setText(item);
    }

    public class TestViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.MiniTextViewId);
        }
    }
}
