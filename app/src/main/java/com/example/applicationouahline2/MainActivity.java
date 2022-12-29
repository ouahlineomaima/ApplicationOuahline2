package com.example.applicationouahline2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonDemarrer = findViewById(R.id.sendEmail);
        boutonDemarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envoyerEmail();
            }
        });
    }

    protected void envoyerEmail(){
        Log.i("Send Email", "");
        String [] TO = {""};
        String [] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Sujet du mail");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Contenu du mail");

        try {
            startActivity(Intent.createChooser(emailIntent, "Envoyer mail... "));
            finish();
            Log.i("Envoi du mail terminé", "");
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(MainActivity.this, "Pas de client mail installé", Toast.LENGTH_SHORT).show();
        }
    }

}