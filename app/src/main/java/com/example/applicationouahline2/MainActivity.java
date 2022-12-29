package com.example.applicationouahline2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText destinationField;
    EditText contentField;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destinationField = findViewById(R.id.destination);
        contentField = findViewById(R.id.contenu);
        sendButton = findViewById(R.id.sendEmail);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envoyerEmail();
            }
        });
    }

    protected void envoyerEmail(){
        Log.i("Send Email", "");
        String destination = destinationField.getText().toString();
        String content = contentField.getText().toString();
        Log.i(destination, "");
        Log.i(content, "");
        String [] TO = {destination};
        String [] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_TEXT, content);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Sujet du mail");

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