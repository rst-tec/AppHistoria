package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinalJogoActivity extends AppCompatActivity {

    private Button btFechar;
    private Button btJogarNovamente;
    private ImageView idFundoResultado;

    private TextView idAcertos;
    private TextView idErros;
    private TextView idPontos;

    private int num;

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

        idAcertos = findViewById(R.id.idAcertos);
        idErros = findViewById(R.id.idErros);
        idPontos = findViewById(R.id.idPontos);
        idFundoResultado = findViewById(R.id.idFundoResultado);

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA PERGUNTA + PONTOS
        Bundle dados = getIntent().getExtras();
        num = dados.getInt("pergunta");

        pontos  = dados.getInt("pontos");
        acertos = dados.getInt("acertos");
        erros   = dados.getInt("erros");

        idAcertos.setText("Acertou: " + acertos );
        idErros.setText("Errou: " + erros);
        idPontos.setText("Total: " + pontos + " Pontos" );

        if(pontos <=3) {
            idFundoResultado.setBackgroundResource(R.drawable.fundo_resultado1);
        }
        if(pontos >4 && pontos <=6) {
            idFundoResultado.setBackgroundResource(R.drawable.fundo_resultado2);
        }
        if(pontos >= 7){
            idFundoResultado.setBackgroundResource(R.drawable.fundo_resultado3);
        }

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

        //BOTÃO PARA JOGAR NOVAMENTE
        btJogarNovamente = findViewById(R.id.btJogarNovamente);
        btJogarNovamente.setBackgroundResource(R.drawable.jogar_novamente);

        if (num == 21) {
            btJogarNovamente.setBackgroundResource(R.drawable.bt_voltar);
        }
            btJogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PARA FINALIZAR O JOGO
                if (num == 21) {
                    telaInicial();
                }else {

                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    Bundle parametros = new Bundle();

                    parametros.putInt("pergunta", num); //Passa o numero da proxima pergunta
                    parametros.putInt("pontos", pontos);
                    parametros.putInt("acertos", acertos);
                    parametros.putInt("erros", erros);

                    intent.putExtras(parametros);
                    startActivity(intent);
                }
            }
        });
    }
    private void telaInicial(){
        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
