package com.example.applicationouahline2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view){
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rockstargames.com/gta-v"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        String CHANNEL_ID = "channel_1";

        mBuilder.setContentIntent(pendingIntent);

        mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        mBuilder.setContentTitle("My notification");
        mBuilder.setContentText("Hello World!");

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(001, mBuilder.build());
    }


}