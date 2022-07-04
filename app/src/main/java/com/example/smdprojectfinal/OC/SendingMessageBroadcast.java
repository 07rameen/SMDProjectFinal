package com.example.smdprojectfinal.OC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.smdprojectfinal.R;

public class SendingMessageBroadcast extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_message_broadcast);
        textView = findViewById(R.id.sendText);
    }

    public void SendBroadcast(View view) {
        String msg = textView.getText().toString().trim();
        Intent intent = new Intent("com.example.sqlliteapplication");
        intent.putExtra("com.example.smdprojectfinal.OC","Received");
        sendBroadcast(intent);
    }
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String receivedText = intent.getStringExtra("com.example.smdprojectfinal.OC");
            textView.setText(receivedText);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("com.example.sqlliteapplication");
        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    public void backkk(View view) {
        Intent intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
    }
}