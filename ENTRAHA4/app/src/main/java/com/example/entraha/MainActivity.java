package com.example.entraha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {//implements on click listeners

    //creating variables
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private TextView register;
    private Button Login;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        register = (TextView) findViewById(R.id.tvregister);
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 5");

        register.setOnClickListener(this);
        Login.setOnClickListener(this);


    }



    private void signup() {

        Intent regIntent = new Intent(MainActivity.this,Register.class);
        startActivity(regIntent);

    }



    private void admin() {   // methods to be called

        Intent admIntent = new Intent(MainActivity.this,Adminpage.class);
        startActivity(admIntent);

    }


    public void validate(String userName,String userPassword) {

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });




        if ((userName == "Admin") && (userPassword == "1234"))//if the strings match it will let the user into our app
        {
            Intent intent = new Intent(MainActivity.this, Adminpage.class);
            //The current activity is main activity and it will go to the admin page
            startActivity(intent); //to start the required activity

        }


            else
            {
                counter--;

                Info.setText("No of attempts remaining: "+String.valueOf(counter));

                if(counter==0)
                {
                    Login.setEnabled(false);//disables the log in button if attepts are 5
                }
            }

        }

    @Override
    public void onClick(View v) {
        if (v == register) {            //calling the on click listenermethods
            signup();
        }
        if (v == Login) {
            admin();
        }

    }}








