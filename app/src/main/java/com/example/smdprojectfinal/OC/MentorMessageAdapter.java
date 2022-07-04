package com.example.smdprojectfinal.OC;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smdprojectfinal.R;

import java.util.ArrayList;

public class MentorMessageAdapter extends RecyclerView.Adapter<MentorMessageAdapter.ViewHolder>{
    ArrayList<MentorMessageData> messageList;
    Context context;

    public MentorMessageAdapter(ArrayList<MentorMessageData> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @Override
    public MentorMessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mentormessagelist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MentorMessageAdapter.ViewHolder holder, int position) {
        holder.message.setText(messageList.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
       return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView message;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.messagee);
        }
    }
}
