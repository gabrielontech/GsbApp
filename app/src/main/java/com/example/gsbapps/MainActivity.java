package com.example.gsbapps;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText userName, userPassword;
    Button userConnexion;
    private String user_name, user_pass;

    private String URL = "http://10.0.2.2/gsbapp/login.php";
     /*
         change the url value with your local IP address & the path of your php file
     */
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
                        Intent MenuActivityIntent = new Intent(MainActivity.this, MenuActivity.class);
                        MenuActivityIntent.putExtra("name", userName.getText().toString());
                        startActivity(MenuActivityIntent);

                    } else if (response.contains("2")){
                        Toast.makeText(getApplication(), " L'accés est interdit au comptable",Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(getApplication(), " Indentifiant et mot de passe inccorect",Toast.LENGTH_SHORT).show();
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

/**
 *
 * this php code and request are just for user only NOT COMPTABLE !!!
 * create database 'GSBapp' and give then 3 column , 1 :  name_user with values VARCHAR,
 * 2 : pass_user with values VARCHAR, 3 id with VALUES SMALLINT
 *
 * copy this php code
 *?php
 * $server = 'localhost';
 * $username = 'root';
 * $database = 'Gsbapp';
 * $password = '';
 *
 * $name = $_POST["username"];
 * $user_password = $_POST["password"];
 *
 * $mysqli = new mysqli($server, $username, $password, $database);
 *
 * $sql = "SELECT * FROM user WHERE name_user = '$name' AND pass_user = '$user_password' AND id = 1";
 * $result = mysqli_query($mysqli, $sql);
 *
 * if($data = mysqli_fetch_array($result)){
 *     echo '1';
 * }
 *
 * ?>
 */
