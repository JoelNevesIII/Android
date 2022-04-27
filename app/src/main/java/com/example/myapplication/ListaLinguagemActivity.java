package com.example.myapplication;

import android.content.Context;
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
    EditText txtItem;
    EditText txtDescrição;
    Linguagem objeto;
    LinguagemAdapter adapter;
    LinguagemController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_linguagens);
        context = ListaLinguagemActivity.this;
        lista = findViewById(R.id.ListaPix);
        btnLista = findViewById(R.id.btnLista);
        txtItem = findViewById(R.id.txtLista);
        txtDescrição = findViewById(R.id.txtdescricao);

        objLista = new ArrayList<>();


        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String item = txtItem.getText().toString().trim().toUpperCase();
                String descricao = txtDescrição.getText().toString().trim();

                if (!item.equals("") && !descricao.equals("")) {
                    objeto = new Linguagem();
                    objeto.setNome(item);
                    objeto.setDescricao(descricao);

                    //objLista.add(objeto);
                    //adapter = new LinguagemAdapter(context, objLista);
                    //lista.setAdapter(adapter);

                    controller = new LinguagemController(context);
                    boolean retorno = controller.incluir(objeto);

                    if (retorno) {
                        atualizarLista();

                    }
                }
            }
        });
    }

            @Override
            protected void onResume() {
                super.onResume();
                atualizarLista();
            }

            private void atualizarLista(){
                txtItem.setText("");
                txtDescrição.setText("");
                txtItem.requestFocus();

                controller = new LinguagemController(context);
                objLista = controller.lista();
                adapter = new LinguagemAdapter(context, objLista);
                lista.setAdapter(adapter);
            }

}
