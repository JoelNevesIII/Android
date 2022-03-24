package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class App extends AppCompatActivity {

    Context context;
    Button btnTost;
    Button btnSnak;
    LinearLayout linearMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        btnSnak = findViewById(R.id.btnbuttonSnak);
        btnTost = findViewById(R.id.btnbuttonTost);
        linearMain = findViewById(R.id.linearMain);
        btnTost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Toast Aqui!!!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });

        btnSnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = getApplicationContext();
                Snackbar.make(linearMain, "Snak Aqui!!", Snackbar.LENGTH_LONG).show();


            }
        });

    }

}