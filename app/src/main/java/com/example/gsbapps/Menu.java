package com.example.gsbapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Menu extends AppCompatActivity {
    TextView acceuil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_user);
        String newString;
        acceuil = findViewById(R.id.acceuil);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("name");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("name");
        }
        acceuil.setText("Bienvenue à " + newString);


    }
}
