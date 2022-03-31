package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
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
    ArrayList<String> objLista;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pix);
        context = ListaPixActivity.this;
        objLista = new ArrayList<>();
        lista = findViewById(R.id.ListaPix);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    objLista.add("Novo item");
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, objLista);
                    lista.setAdapter(adapter);
                }catch (Exception e){

                }
            }
        });
    }
}