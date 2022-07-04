package com.example.smdprojectfinal.OC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smdprojectfinal.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivityOC extends AppCompatActivity {

    TextView text,text2;
    FirebaseDatabase Database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_oc);
        text = (EditText)findViewById(R.id.Username);
        text2 = (EditText)findViewById(R.id.Password);

        Database = FirebaseDatabase.getInstance("https://smdproject-b103f-default-rtdb.firebaseio.com/");
        reference = Database.getReference("Mentor").child("OCtesting");


    }

    public void Login(View view) {

      reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for ( DataSnapshot snapshot : dataSnapshot.getChildren() ) {
                    Credentials student = new Credentials();
                    student.setUsername(snapshot.child("username").getValue().toString());
                    student.setPassword(snapshot.child("password").getValue().toString());
                    String testuser = student.getUsername();
                    String testpass = student.getPassword();
                   // Log.d("TAG","testuser "+ testuser);
                   // Log.d("TAG","testpass "+ testpass);

                    String user = text.getText().toString().trim();
                    String password = text2.getText().toString().trim();

                   // Log.d("TAG","apkauser " + user);
                  // Log.d("TAG","apkapass " + password);

                    if((user.equals(testuser)) && (password.equals(testpass)))
                    {
                        Toast.makeText(MainActivityOC.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(), Menu.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(MainActivityOC.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}