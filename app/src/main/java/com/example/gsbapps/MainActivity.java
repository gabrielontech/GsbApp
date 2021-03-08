package com.example.gsbapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText userName, userPassword;
    Button userConnexion;
    private String user_name, user_pass;
    private String URL = "http://192.168.64.2/LoginRegister/validate.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          user_name = user_pass = " ";
          userName = findViewById(R.id.userName);
          userPassword = findViewById(R.id.userPassword);
          userConnexion = findViewById(R.id.connexion);

          userConnexion.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  login();
              }
          });
    }

    public void login(){
        user_name = userName.getText().toString().trim();
        user_pass = userPassword.getText().toString().trim();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.contains("1")) {
                        Intent MenuActivityIntent = new Intent(MainActivity.this, Menu.class);
                        MenuActivityIntent.putExtra("name", userName.getText().toString());
                        startActivity(MenuActivityIntent);
                    } else{
                        Toast.makeText(getApplicationContext(), "Mot de passe ou identifiant invalide", Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<>();
                    params.put("username", user_name);
                    params.put("password", user_pass);
                    return params;
                }
            };

            Volley.newRequestQueue(this).add(stringRequest);

    }

}
