package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FasesActivity extends AppCompatActivity {
    private Button btFase01;
    private Button btFase02;
    private Button btFase03;
    private Button btFase04;
    private Button btFase05;
    private Button btFase06;

    private TextView idFase1;
    private TextView idFase2;
    private TextView idFase3;
    private TextView idFase4;
    private TextView idFase5;
    private TextView idFase6;

    private int fase;    // RECEBE O NUMERO DA PERGUNTA
    private int num;    // RECEBE O NUMERO DA PERGUNTA
    private int pontos;
    private int pontosF1;
    private int pontosF2;
    private int pontosF3;
    private int pontosF4;
    private int pontosF5;
    private int pontosF6;

    SharedPreferences preferencias;//GRAVANDO PONTUAÇÃO

    //VOLTAR COM BOTÃO VIRTUAL DO CELULAR
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fases);

        preferencias = PreferenceManager.getDefaultSharedPreferences(this);//GRAVANDO PONTUAÇÃO

        btFase01 = findViewById(R.id.btFase01);
        btFase02 = findViewById(R.id.btFase02);
        btFase03 = findViewById(R.id.btFase03);
        btFase04 = findViewById(R.id.btFase04);
        btFase05 = findViewById(R.id.btFase05);
        btFase06 = findViewById(R.id.btFase06);

        idFase1 = findViewById(R.id.idFase1);
        idFase2 = findViewById(R.id.idFase2);
        idFase3 = findViewById(R.id.idFase3);
        idFase4 = findViewById(R.id.idFase4);
        idFase5 = findViewById(R.id.idFase5);
        idFase6 = findViewById(R.id.idFase6);

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA PERGUNTA + PONTOS
        Bundle dados = getIntent().getExtras();
        fase     = dados.getInt("fase");
        num     = dados.getInt("pergunta");
        pontos  = dados.getInt("pontos");

        btFase01.setBackgroundResource(R.drawable.fundo_fases);
        btFase01.setText("Fase - 01");

        if (num == 10) {
            pontosF1 = pontos;
            fase1();
        }

        if (num == 20) {
            pontosF2 = pontos;
            fase1();
        }

        if (num == 30) {
            pontosF3 = pontos;
            fase1();
        }

        if (num == 40) {
            pontosF4 = pontos;
            fase1();
        }

        if (num == 50) {
            pontosF5 = pontos;
            fase1();
        }

        if (num == 60) {
            pontosF6 = pontos;
            fase1();
        }

        btFase01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 1); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btFase02.setBackgroundResource(R.drawable.fundo_fases);
        btFase02.setText("Fase - 02");
        btFase02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 11); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btFase03.setBackgroundResource(R.drawable.fundo_fases);
        btFase03.setText("Fase - 03");
        btFase03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 21); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });


        btFase04.setBackgroundResource(R.drawable.fundo_fases);
        btFase04.setText("Fase - 04");
        btFase04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 31); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btFase05.setBackgroundResource(R.drawable.fundo_fases);
        btFase05.setText("Fase - 05");

        btFase06.setBackgroundResource(R.drawable.fundo_fases);
        btFase06.setText("Fase - 06");


//*************************************************************
//GRAVAR ALTERAÇÕES DE CORES
//*************************************************************

        if (preferencias.getString("atualizaPontos",null) == null){
            SharedPreferences.Editor editorDePreferencias = preferencias.edit();
            editorDePreferencias.putString("atualizaPontos", "desativado");
            editorDePreferencias.apply();
        }

        if (preferencias.getString("atualizaPontos",null).equals("fase1")){
            fase1();
        }
    }

    private void fase1() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("atualizaPontos", "fase1");
        editorDePreferencias.apply();

        idFase1.setText(pontosF1 + " pontos");
        idFase2.setText(pontosF2 + " pontos");
        idFase3.setText(pontosF3 + " pontos");
        idFase4.setText(pontosF4 + " pontos");
        idFase5.setText(pontosF5 + " pontos");
        idFase6.setText(pontosF6 + " pontos");

    }
}


