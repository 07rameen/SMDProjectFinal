package com.example.smdprojectfinal.OC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.smdprojectfinal.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ParticipantsMain extends AppCompatActivity {

    FirebaseDatabase Database;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<ParticipantsData> studentList;
    ParticipantsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrations);
        recyclerView = findViewById(R.id.recyclerviewmentor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        studentList = new ArrayList<ParticipantsData>();
        Database = FirebaseDatabase.getInstance("https://smdproject-b103f-default-rtdb.firebaseio.com/");
        reference = Database.getReference("Mentor").child("Participant");
        LoadDataFromFirebase();
       /* reference.child("FAST NUCES").child("FAST CFD").child("BSCS").setValue(1000);
        reference.child("FAST NUCES").child("FAST CFD").child("BSSE").setValue(200);*/

    }
    public void LoadDataFromFirebase() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clear();
                for ( DataSnapshot snapshot : dataSnapshot.getChildren() ) {
                    ParticipantsData student = new ParticipantsData();
                    student.setName(snapshot.child("Name").getValue().toString());
                    student.setEvent(snapshot.child("Event").getValue().toString());
                    student.setInstitute(snapshot.child("Institute").getValue().toString());
                    String events = snapshot.child("Event").getValue().toString();
                    Log.d("TAG",events);
                    if(events.equals("Code Debugger"))
                    {
                        studentList.add(student);
                    }

                }
                adapter = new ParticipantsAdapter(studentList, getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void clear() {
        if ( studentList != null ) {
            studentList.clear();
            if ( adapter!= null ) {
                adapter.notifyDataSetChanged();
            }
        }
        else {
            studentList = new ArrayList<>();
        }
    }


    public void goingback(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}