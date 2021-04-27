package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalJogoActivity extends AppCompatActivity {

    private Button btFechar;
    private Button btJogarNovamente;

    private TextView idAcertos;
    private TextView idErros;
    private TextView idPontos;

    private int pontos;
    private int acertos;
    private int erros;

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
        setContentView(R.layout.activity_final_jogo);

        idAcertos   = findViewById(R.id.idAcertos);
        idErros     = findViewById(R.id.idErros);
        idPontos    = findViewById(R.id.idPontos);

        //BUNDLE  RECEBENDO PONTUAÇÃO
        Bundle dados = getIntent().getExtras();

        pontos  = dados.getInt("pontos");
        acertos = dados.getInt("acertos");
        erros   = dados.getInt("erros");

        idAcertos.setText("Você acertou: " + acertos + " Perguntas");
        idErros.setText("Você errou: " + erros + " Perguntas");
        idPontos.setText("Você fez: " + pontos + "  Pontos" );

        //BOTÃO PARA VOLTAR PARA A TELA INICIAL
        btFechar = findViewById(R.id.btFechar);
        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btJogarNovamente = findViewById(R.id.btJogarNovamente);
        btJogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 1); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });
    }
}
