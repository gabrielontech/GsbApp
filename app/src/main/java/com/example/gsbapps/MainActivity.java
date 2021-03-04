package com.example.gsbapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText userPassword;
    Button userConnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          userName = findViewById(R.id.userName);
          userPassword = findViewById(R.id.userPassword);
          userConnexion = findViewById(R.id.connexion);

        userConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AcessHTTP accesDonnees = new AcessHTTP(){
                    @Override
                    protected void onPostExecute(Long result) {
                        try {
                            JSONArray tJson = new JSONArray(this.ret);
                            if (tJson.length()!=0) {
                                int i = 0;
                                String v1 =
                                        tJson.getJSONObject(i).getString("v1");
                            }
                        }catch (JSONException e){
                            Log.d("log","pb decodage JSON "+e.toString());
                        }
                    }
                };

                accesDonnees.addParam("name", userName.getText().toString());
                accesDonnees.addParam("motDePasse", userPassword.getText().toString());

                accesDonnees.execute("http://192.168.0.50/gsb/verification.php");

                Intent MenuActivityIntent = new Intent(MainActivity.this, Menu.class);
                MenuActivityIntent.putExtra("name", userName.getText().toString());
                startActivity(MenuActivityIntent);
            }
        });

    }
}
