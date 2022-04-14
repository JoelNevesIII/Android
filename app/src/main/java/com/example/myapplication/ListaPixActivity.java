package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import com.example.myapplication.adapter.LinguagemAdapter;
import com.example.myapplication.model.Linguagem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityListaPixBinding;

import java.util.ArrayList;

public class ListaPixActivity extends AppCompatActivity {

    Context context;
    ListView lista;
    ArrayList<Linguagem> objLista;
    Button btnLista;
    EditText txtItem;
    EditText txtDescrição;
    Linguagem objeto;
    LinguagemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pix);
        context = ListaPixActivity.this;
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

            if(!item.equals("")){
                objeto = new Linguagem();
                objeto.setId(1);
                objeto.setNome(item);
                objeto.setDescricao(descricao);

                objLista.add(objeto);
                adapter = new LinguagemAdapter(context, objLista);
                lista.setAdapter(adapter);

                txtItem.setText("");
                txtDescrição.setText("");
                txtItem.requestFocus();

            }

        }
    });

    }
}