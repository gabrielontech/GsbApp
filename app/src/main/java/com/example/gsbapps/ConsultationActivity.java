package com.example.gsbapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConsultationActivity extends AppCompatActivity {
    Button validationBtn;
    Button annulerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);

        validationBtn =  findViewById(R.id.validationbtn);
        annulerBtn = findViewById(R.id.annulerbtn);

        validationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MoisFraisIntent = new Intent(ConsultationActivity.this, MoisFraisActivity.class);
                startActivity(MoisFraisIntent);
            }

        });

        annulerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConsultationIntent = new Intent(ConsultationActivity.this, MenuActivity.class);
                startActivity(ConsultationIntent);
            }
        });

    }
}