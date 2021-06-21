package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    private Button btFechar;

    private TextView idFase1;
    private TextView idFase2;
    private TextView idFase3;
    private TextView idFase4;
    private TextView idFase5;
    private TextView idFase6;

    private static final String PREF_NOME = "preferencias";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dadospref;

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

        //BOTÃO PARA FECHAR
        btFechar = findViewById(R.id.btFechar);
        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //EXIBINDO DADOS DO SHARED PREFERENCES
        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);
        idFase1.setText(sharedPreferences.getInt("pontosf1",0) + " pontos");
        idFase2.setText(sharedPreferences.getInt("pontosf2",0) + " pontos");
        idFase3.setText(sharedPreferences.getInt("pontosf3",0) + " pontos");
        idFase4.setText(sharedPreferences.getInt("pontosf4",0) + " pontos");
        idFase5.setText(sharedPreferences.getInt("pontosf5",0) + " pontos");
        idFase6.setText(sharedPreferences.getInt("pontosf6",0) + " pontos");

        //BOTÃO PERGUNTAS FASE 01
        btFase01.setBackgroundResource(R.drawable.fundo_fases);
        btFase01.setText("Fase - 01");
        btFase01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 1); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        //BOTÃO PERGUNTAS FASE 02
        btFase02.setBackgroundResource(R.drawable.fundo_fases);
        btFase02.setText("Fase - 02");
        btFase02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 11); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        //BOTÃO PERGUNTAS FASE 03
        btFase03.setBackgroundResource(R.drawable.fundo_fases);
        btFase03.setText("Fase - 03");
        btFase03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 21); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        //BOTÃO PERGUNTAS FASE 04
        btFase04.setBackgroundResource(R.drawable.fundo_fases);
        btFase04.setText("Fase - 04");
        btFase04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 31); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        //BOTÃO PERGUNTAS FASE 05
        btFase05.setBackgroundResource(R.drawable.fundo_fases);
        btFase05.setText("Fase - 05");
        btFase05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 31); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        //BOTÃO PERGUNTAS FASE 06
        btFase06.setBackgroundResource(R.drawable.fundo_fases);
        btFase06.setText("Fase - 06");
        btFase06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 31); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });
    }
}


