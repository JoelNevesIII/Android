package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Context context;
    Button btnTabuada;
    Button btnCalculadora;
    Button btnApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context = Menu.this;
        btnTabuada = findViewById(R.id.btnTabuada);
        btnCalculadora =findViewById(R.id.btnCalculadora);
        btnApp = findViewById(R.id.btnApp);


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
    }
}



