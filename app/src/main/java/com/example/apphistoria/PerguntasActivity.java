package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PerguntasActivity extends AppCompatActivity {

    private Button btFechar;
    private Button btProxima;
    private ImageView foto;
    private TextView pergunta;
    private TextView resposta1;
    private TextView resposta2;
    private TextView resposta3;

    //VOLTAR COM BOTÃO VIRTUAL DO CELULAR - PARA A TELA INICIAL
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA HISTORIA
        Bundle dados = getIntent().getExtras();
        int num = dados.getInt("perguntas");

        //BOTÃO PARA VOLTAR PARA A VOLTAR A LISTA DE HISTORIAS
        btFechar = findViewById(R.id.btFechar);
        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


//*************************************************************
//PERGUNTA 001 - A Criação do Mundo
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 1) {

            foto = findViewById(R.id.capaHistoria);
            foto.setImageResource(R.drawable.historia001);

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("A Criação do Mundo");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);

                    intent.putExtra("perguntas", 2);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 002 - O Pecado de Adão e Eva
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 2) {

            foto = findViewById(R.id.capaHistoria);
            foto.setImageResource(R.drawable.historia002);

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("O Pecado de Adão e Eva");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);

                    intent.putExtra("perguntas", 3);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 003 - A Arca e o Diluvio
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 3) {

            foto = findViewById(R.id.capaHistoria);
            foto.setImageResource(R.drawable.historia003);

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("A Arca e o Diluvio");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("perguntas", 3);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }
    }
}
