package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Controler.LinguagemController;
import com.example.myapplication.adapter.LinguagemAdapter;
import com.example.myapplication.model.Linguagem;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaLinguagemActivity extends AppCompatActivity {

    Context context;
    ListView lista;
    ArrayList<Linguagem> objLista;
    Button btnLista;
    Linguagem objeto;
    LinguagemAdapter adapter;
    LinguagemController controller;
    EditText txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_linguagens);
        context = ListaLinguagemActivity.this;
        txtNome = findViewById(R.id.txtLista);
        lista = findViewById(R.id.ListaPix);
        btnLista = findViewById(R.id.btnLista);

        objLista = new ArrayList<>();


    }

            @Override
            protected void onResume() {
                super.onResume();
                atualizarLista();
            }

            private void atualizarLista(){


                controller = new LinguagemController(context);
                objLista = controller.lista();
                adapter = new LinguagemAdapter(context, objLista);
                lista.setAdapter(adapter);
            }

}
