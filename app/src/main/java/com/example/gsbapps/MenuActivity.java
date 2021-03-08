
package com.example.gsbapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MenuActivity extends AppCompatActivity {
    Button consultation;
    TextView acceuil;
    Button fraisForfait;
    Button fraisHorsForfait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);
        String newString;

        consultation = findViewById(R.id.consultation);
        acceuil = findViewById(R.id.acceuil);
        fraisForfait = findViewById(R.id.fraisForfait);
        fraisHorsForfait = findViewById(R.id.fraisHorsFrais);

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

        fraisForfait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fraisForfaitIntent =  new Intent(MenuActivity.this, fraisforfaitActivity.class);
                startActivity(fraisForfaitIntent);
            }
        });

        fraisHorsForfait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fraisHorsForfaitIntent = new Intent(MenuActivity.this, FraisHorsForfaitActivity.class);
                startActivity(fraisHorsForfaitIntent);
            }
        });

        consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultationIntent = new Intent(MenuActivity.this, ConsultationActivity.class);
                startActivity(consultationIntent);
            }
        });

    }
}
