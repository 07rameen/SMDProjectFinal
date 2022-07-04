package com.example.smdprojectfinal.OC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smdprojectfinal.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MentorMessageMainActivity extends AppCompatActivity {

    FirebaseDatabase Database;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<MentorMessageData> mentormsglist;
    MentorMessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_message_main);
        recyclerView = findViewById(R.id.Recylervieww);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        mentormsglist = new ArrayList<MentorMessageData>();
        Database = FirebaseDatabase.getInstance("https://smdproject-b103f-default-rtdb.firebaseio.com/");
        reference = Database.getReference("Mentor").child("Message");
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
                    MentorMessageData student = new MentorMessageData();
                    student.setMessage(snapshot.child("msg").getValue().toString());
                    mentormsglist.add(student);
                }
                adapter = new MentorMessageAdapter(mentormsglist, getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void clear() {
        if ( mentormsglist != null ) {
            mentormsglist.clear();
            if ( adapter!= null ) {
                adapter.notifyDataSetChanged();
            }
        }
        else {
            mentormsglist = new ArrayList<>();
        }
    }

    public void gonee(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}
