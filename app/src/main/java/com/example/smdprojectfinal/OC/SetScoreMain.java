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

public class SetScoreMain extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_score_main);

    }

    public void SettingScore(View view) {
        t1 = findViewById(R.id.WinnerName);
        t2=findViewById(R.id.WinnerScore);
        t3=findViewById(R.id.RunnerName);
        t4=findViewById(R.id.RunnerScore);

        String WinnerName = t1.getText().toString().trim();
        String WinnerScore = t2.getText().toString().trim();
        String RunnerName = t3.getText().toString().trim();
        String RunnerScore = t4.getText().toString().trim();

        ScoreData dataholder = new ScoreData(WinnerName,WinnerScore,RunnerName,RunnerScore);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node = db.getReference("Mentor").child("OCtesting");
        node.child("Scoring").child("Score").setValue(dataholder);
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");

        Toast.makeText(this, "Inserted Data", Toast.LENGTH_SHORT).show();



    }

    public void backk(View view) {
        Intent intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
    }
}