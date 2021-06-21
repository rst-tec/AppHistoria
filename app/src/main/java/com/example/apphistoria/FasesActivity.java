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
    //SharedPreferences.Editor dadospref;

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

    @Override
    protected void onResume() {
        super.onResume();

        //EXIBINDO DADOS DO SHARED PREFERENCES
        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);
        int pf1 = sharedPreferences.getInt("pontosf1",0);

        idFase1.setText(pf1 + " pontos");

        if(pf1 == 0){
            btFase01.setBackgroundResource(R.drawable.fundo_fases);
        }else if (pf1 <= 3) {
            btFase01.setBackgroundResource(R.drawable.fundo_resultado1);
        }else if (pf1 >= 4 && pf1 <= 6) {
            btFase01.setBackgroundResource(R.drawable.fundo_resultado2);
        }else if (pf1 >= 7) {
            btFase01.setBackgroundResource(R.drawable.fundo_resultado3);
        }

        int pf2 = sharedPreferences.getInt("pontosf2",0);

        idFase2.setText(pf2 + " pontos");

        if(pf2 == 0){
            btFase02.setBackgroundResource(R.drawable.fundo_fases);
        }else if (pf2 <= 3) {
            btFase02.setBackgroundResource(R.drawable.fundo_resultado1);
        }else if (pf2 >= 4 && pf2 <= 6) {
            btFase02.setBackgroundResource(R.drawable.fundo_resultado2);
        }else if (pf2 >= 7) {
            btFase02.setBackgroundResource(R.drawable.fundo_resultado3);
        }

        int pf3 = sharedPreferences.getInt("pontosf3",0);

        idFase3.setText(pf3 + " pontos");

        if(pf3 == 0){
            btFase03.setBackgroundResource(R.drawable.fundo_fases);
        }else if (pf3 <= 3) {
            btFase03.setBackgroundResource(R.drawable.fundo_resultado1);
        }else if (pf3 >= 4 && pf3 <= 6) {
            btFase03.setBackgroundResource(R.drawable.fundo_resultado2);
        }else if (pf3 >= 7) {
            btFase03.setBackgroundResource(R.drawable.fundo_resultado3);
        }

        int pf4 = sharedPreferences.getInt("pontosf4",0);

        idFase4.setText(pf4 + " pontos");

        if(pf4 == 0){
            btFase04.setBackgroundResource(R.drawable.fundo_fases);
        }else if (pf4 <= 3) {
            btFase04.setBackgroundResource(R.drawable.fundo_resultado1);
        }else if (pf4 >= 4 && pf4 <= 6) {
            btFase04.setBackgroundResource(R.drawable.fundo_resultado2);
        }else if (pf4 >= 7) {
            btFase04.setBackgroundResource(R.drawable.fundo_resultado3);
        }

        int pf5 = sharedPreferences.getInt("pontosf5",0);

        idFase5.setText(pf5 + " pontos");

        if(pf5 == 0){
            btFase05.setBackgroundResource(R.drawable.fundo_fases);
        }else if (pf5 <= 3) {
            btFase05.setBackgroundResource(R.drawable.fundo_resultado1);
        }else if (pf5 >= 4 && pf5 <= 6) {
            btFase05.setBackgroundResource(R.drawable.fundo_resultado2);
        }else if (pf5 >= 7) {
            btFase05.setBackgroundResource(R.drawable.fundo_resultado3);
        }

        int pf6 = sharedPreferences.getInt("pontosf6",0);

        idFase6.setText(pf6 + " pontos");

        if(pf6 == 0){
            btFase06.setBackgroundResource(R.drawable.fundo_fases);
        }else if (pf6 <= 3) {
            btFase06.setBackgroundResource(R.drawable.fundo_resultado1);
        }else if (pf6 >= 4 && pf6 <= 6) {
            btFase06.setBackgroundResource(R.drawable.fundo_resultado2);
        }else if (pf6 >= 7) {
            btFase06.setBackgroundResource(R.drawable.fundo_resultado3);
        }


    }
}


