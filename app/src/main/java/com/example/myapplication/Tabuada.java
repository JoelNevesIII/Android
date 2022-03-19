package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tabuada extends AppCompatActivity {


    TextView lblTabuada;
    Button btnTabuada;
    EditText txtTabuada;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabuada);
        context = Tabuada.this;
        //Vinculação das variáveis com os campos do XML
        lblTabuada = findViewById(R.id.lblTabuada);
        txtTabuada = findViewById(R.id.txtTabuada);
        btnTabuada = findViewById(R.id.btnTabuada);

        //Início do evento do botão
        btnTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tabuada = 0;

                try {
                    tabuada = Integer.parseInt(txtTabuada.getText().toString());
                } catch (Exception ex) {
                    Log.e("CALCULADORA", ex.getMessage());
                    Ferramentas.mostrarAlerta(context, "EITAAAA", "Informe um número válido");
                }

                if(tabuada != 0) {
                    String impressao = "";

                    for (int i = 0; i <= 10; i++) {

                        int res = i * tabuada;
                        impressao += tabuada + "x" + i + "=" + res + "\n";
                    }
                    lblTabuada.setText(impressao);
                }

            }
        });
        //Fim do evento do botão

    }//fechamento do OnCreate
    }
