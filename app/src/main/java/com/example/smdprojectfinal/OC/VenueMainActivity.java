package com.example.smdprojectfinal.OC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smdprojectfinal.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.util.Random;

public class VenueMainActivity extends AppCompatActivity {

    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_main);
    }

    public void SettingVenue(View view) {
        t1 = (EditText)findViewById(R.id.Place);
        t2 = (EditText)findViewById(R.id.Time);
        String place = t1.getText().toString().trim();
        String timee = t2.getText().toString().trim();

        Toast.makeText(this, "Place is : " + place + " and Time is : " + timee, Toast.LENGTH_SHORT).show();




        VenueData dataholder = new VenueData(place,timee);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        //pooray database ko object ki tarha behave karwai ga
        //ager student kay andar karna toh give reference for it
        DatabaseReference node = db.getReference("Mentor").child("OCtesting");
        //by default khali per root hojaiga
        node.child("Venue").setValue(dataholder);
        t1.setText("");
        t2.setText("");

        Toast.makeText(this, "Inserted Data", Toast.LENGTH_SHORT).show();



    }

    public void go(View view) {
        Intent intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
    }
}