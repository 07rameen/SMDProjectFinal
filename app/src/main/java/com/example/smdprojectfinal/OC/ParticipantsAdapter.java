package com.example.smdprojectfinal.OC;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smdprojectfinal.R;

import java.util.ArrayList;

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ViewHolder>{
    ArrayList<ParticipantsData> studentList;
    Context context;

    public ParticipantsAdapter(ArrayList<ParticipantsData> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ParticipantsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipantsAdapter.ViewHolder holder, int position) {

        holder.name.setText(studentList.get(position).getName());
        holder.event.setText(studentList.get(position).getEvent());
        Log.d("TAG","Adapter mein hoon");
        holder.institute.setText(studentList.get(position).getInstitute());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,event,institute;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            event = itemView.findViewById(R.id.Event);
            institute=itemView.findViewById(R.id.Institute);
        }
    }
}
