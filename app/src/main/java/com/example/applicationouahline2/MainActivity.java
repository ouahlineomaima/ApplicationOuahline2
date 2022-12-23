package com.example.applicationouahline2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner_city = (Spinner) findViewById(R.id.spinner_city);
        String[] cities = {"City1", "City2", "City3", "City4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_city.setAdapter(adapter);
        spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), "Sélectionné : " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Réagir lorsque aucune valeur n'est sélectionnée
            }
        });

        Spinner spinner_hobbies = (Spinner) findViewById(R.id.spinner_hobbies);
        String[] hobbies = {"Hobby1", "Hobby2", "Hobby3", "Hobby4"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hobbies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_hobbies.setAdapter(adapter2);

        spinner_hobbies.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), "Sélectionné : " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Réagir lorsque aucune valeur n'est sélectionnée
            }
        });

    }

}