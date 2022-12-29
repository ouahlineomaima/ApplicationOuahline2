package com.example.applicationouahline2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    EditText messageTexte;
    String phoneNo;
    String message;
    Button bouttonEnvoi;
    EditText numeroTelephone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTexte = (EditText) findViewById(R.id.editText);
        bouttonEnvoi = (Button) findViewById(R.id.button);
        numeroTelephone = (EditText) findViewById(R.id.editText2);

        bouttonEnvoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envoyerSMS();
            }
        });
    }

    protected void envoyerSMS(){
        phoneNo = numeroTelephone.getText().toString();
        message = messageTexte.getText().toString();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)){
                Log.i(null,"dkhalna1");

            }
            else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        try{
            SmsManager gestionnaireSMS = SmsManager.getDefault();
            gestionnaireSMS.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS envoyé", Toast.LENGTH_LONG).show();
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "SMS non envoyé", Toast.LENGTH_LONG).show();
            return;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i(null,"dkhalna2");
                    SmsManager gestionnaireSMS = SmsManager.getDefault();
                    gestionnaireSMS.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS envoyé", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "SMS non envoyé", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }

}