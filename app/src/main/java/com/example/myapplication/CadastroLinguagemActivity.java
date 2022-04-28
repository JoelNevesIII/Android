package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.myapplication.Controler.LinguagemController;
import com.example.myapplication.Tools.Globais;
import com.example.myapplication.model.Linguagem;

public class CadastroLinguagemActivity extends AppCompatActivity {

    int idLinguagem;
    LinguagemController controller;
    Context context;
    Linguagem objeto;
    EditText txtNome;
    EditText txtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linguagens);

        txtNome = findViewById(R.id.txtLista);
        txtDescricao = findViewById(R.id.txtdescricao);
        context = CadastroLinguagemActivity.this;

        //Verificar se veio algum EXTRA da tela anterior
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idLinguagem = extras.getInt("id", 0);
            //buscar através desta chave
            controller = new LinguagemController(context);
            objeto = controller.buscar(idLinguagem);
            if (objeto != null) {
                txtNome.setText(objeto.getNome());
                txtDescricao.setText(objeto.getDescricao());
            }

        } else {
            idLinguagem = 0;
        }
    }

    //Funcao para inflar o menu na tela
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cad, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){

            case R.id.action_ok:

                //SALVAR
                salvar();

            case R.id.action_cancel:

                finish();

        }

        return super.onOptionsItemSelected(item);
    }

    private void salvar(){
        try{

            String nome = txtNome.getText().toString().trim();
            String descricao = txtDescricao.getText().toString().trim();

            if(!nome.equals("") && !descricao.equals("")) {

                if(nome.length() > 30){
                    Globais.exibirMensagem(context,
                            "O nome é muito grande, credo.");
                    return;
                }

                objeto = new Linguagem();
                objeto.setNome(nome);
                objeto.setDescricao(descricao);

                controller = new LinguagemController(context);

                boolean retorno = false;
                if(idLinguagem == 0){
                    retorno = controller.incluir(objeto);
                }else{
                    objeto.setId(idLinguagem);
                    retorno = controller.alterar(objeto);
                }

                if(retorno) {
                    Globais.exibirMensagem(context, "Sucesso");
                    finish();
                }

            }

        }catch (Exception ex){
            Globais.exibirMensagem(context, ex.getMessage());
            Log.e("ERRO", ex.getMessage());
        }
    }
}