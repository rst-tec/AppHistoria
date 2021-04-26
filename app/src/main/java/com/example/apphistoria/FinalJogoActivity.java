package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalJogoActivity extends AppCompatActivity {

    private Button btFechar;

    private TextView txAcertou;
    private TextView txErrou;
    private TextView txResultado;

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

        txAcertou = findViewById(R.id.idResposta1);
        txErrou = findViewById(R.id.idResposta2);
        txResultado = findViewById(R.id.idResposta3);

        //BUNDLE  RECEBENDO PONTUAÇÃO
        Bundle dados = getIntent().getExtras();

        pontos  = dados.getInt("pontos");
        acertos = dados.getInt("acertos");
        erros   = dados.getInt("erros");

        txAcertou.setText("Você acertou: " + acertos + " Perguntas");
        txErrou.setText("Você errou: " + erros + " Perguntas");
        txResultado.setText("Você fez: " + pontos + "  Pontos" );

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
    }
}
