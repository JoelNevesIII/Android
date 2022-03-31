package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Context context;
    Button btnTabuada;
    Button btnCalculadora;
    Button btnApp;
    Button btnSair;
    Button btnPix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context = Menu.this;
        btnTabuada = findViewById(R.id.btnTabuada);
        btnCalculadora =findViewById(R.id.btnCalculadora);
        btnApp = findViewById(R.id.btnApp);
        btnSair = findViewById(R.id.btnSair);
        btnPix = findViewById(R.id.btnPix);
        SharedPreferences preferences = getSharedPreferences("Login", context.MODE_PRIVATE);


        btnTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Acessar uma nova activity
                Intent intent = new Intent(context, Tabuada.class);
                startActivity(intent);

            }
        });
        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Acessar uma nova activity
                Intent intent = new Intent(context, Calculadora.class);
                startActivity(intent);

            }
        });

        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Acessar uma nova activity
                Intent intent = new Intent(context, App.class);
                startActivity(intent);

            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Usuario", "");
                editor.apply();
                startActivity(intent);
                finish();

            }
        });
        btnPix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListaPixActivity.class);
                startActivity(intent);
            }
        });

    }
}



