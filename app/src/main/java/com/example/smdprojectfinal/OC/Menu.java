package com.example.smdprojectfinal.OC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smdprojectfinal.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void MentorMessage(View view) {

        Intent intent = new Intent(getApplicationContext(), MentorMessageMainActivity.class);
        startActivity(intent);
    }

    public void DiplayingParticipants(View view) {
        //try fetching sorted events
      //mentor walay mein already participants display karnay ka recycler view adapter bana huwa hai use that
        //main activity : Registrations
        //class : RegistrationsDaira
        //adapter : Firebase Adapter
        Intent intent = new Intent(getApplicationContext(),ParticipantsMain.class);
        startActivity(intent);
    }

    public void setVenue(View view) {
        Intent intent = new Intent(getApplicationContext(), VenueMainActivity.class);
        startActivity(intent);

    }

    public void SendMessage(View view) {
        Intent intent = new Intent(getApplicationContext(), SendingMessageBroadcast.class);
        startActivity(intent);
    }

    public void scoring(View view) {
        Intent intent = new Intent(getApplicationContext(), SetScoreMain.class);
        startActivity(intent);
    }
}