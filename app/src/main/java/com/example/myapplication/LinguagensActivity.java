package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.myapplication.Controler.LinguagemController;
import com.example.myapplication.model.Linguagem;

public class LinguagensActivity extends AppCompatActivity {

    Context context;
    EditText txtNome;
    EditText txtDescricao;
    Linguagem objeto;
    LinguagemController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linguagens);
        txtNome = findViewById(R.id.txtLista);
        txtDescricao = findViewById(R.id.txtdescricao);

    }

}
