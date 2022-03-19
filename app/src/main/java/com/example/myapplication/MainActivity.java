package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUsuario, txtSenha;
    Context context;
    String USER = "teste";
    String PASS = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUsuario.getText().toString().equals(USER) &&
                        txtSenha.getText().toString().equals(PASS)) {

                    //Acessar uma nova activity
                    Intent intent = new Intent(context, Menu.class);
                    startActivity(intent);
                    finish(); //fecha a tela em questão
                }
            }
        });
    }
}