package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinalJogoActivity extends AppCompatActivity {

    private Button btFechar;
    private ImageView idFundoResultado;

    private TextView idErros;
    private TextView idPontos;

    private MediaPlayer somFinal; //Toca som de final de jogo

    private int num;
    private int pontos;
    private int acertos;
    private int erros;

    private static final String PREF_NOME = "preferencias";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dadospref;

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

        idErros = findViewById(R.id.idErros);
        idPontos = findViewById(R.id.idPontos);
        idFundoResultado = findViewById(R.id.idFundoResultado);

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA PERGUNTA + PONTOS
        Bundle dados = getIntent().getExtras();
        num = dados.getInt("pergunta");
        pontos = dados.getInt("pontos");
        acertos = dados.getInt("acertos");
        erros = dados.getInt("erros");

        //SALVANDO DADOS NO SHARED PREFERENCES
        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);
        dadospref = sharedPreferences.edit();

        if(num == 10) {
            dadospref.putInt("pontosf1", pontos);
            dadospref.apply();

        }else if (num == 20) {
            dadospref.putInt("pontosf2", pontos);
            dadospref.apply();

        }else if (num == 30) {
            dadospref.putInt("pontosf3", pontos);
            dadospref.apply();

        }else if (num == 40) {
            dadospref.putInt("pontosf4", pontos);
            dadospref.apply();

        }else if (num == 50) {
            dadospref.putInt("pontosf5", pontos);
            dadospref.apply();

        }else if (num == 60) {
            dadospref.putInt("pontosf6", pontos);
            dadospref.apply();
        }

        idErros.setText(erros + " Erros" );
        idPontos.setText(pontos + " pontos");

        if (pontos <= 3) {
            idFundoResultado.setBackgroundResource(R.drawable.fundo_resultado1);
        }
        if (pontos >= 4 && pontos <= 6) {
            idFundoResultado.setBackgroundResource(R.drawable.fundo_resultado2);
        }
        if (pontos >= 7) {
            idFundoResultado.setBackgroundResource(R.drawable.fundo_resultado3);
        }

        //INICIA A MUSICA DE FINAL DE JOGO
        somFinal = MediaPlayer.create(getApplicationContext(), R.raw.som_final_jogo);
        if (!somFinal.isPlaying()) {
            somFinal.start();
        }

        //BOTÃO PARA FECHAR
        btFechar = findViewById(R.id.btFechar);
        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                somFinal.stop();//FINALIZA MUSICA FINAL DE JOGO
                finish();
            }
        });
    }
}

