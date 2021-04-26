package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FinalJogoActivity extends AppCompatActivity {

    private Button btFechar;

    private TextView txAcertou;
    private TextView txErrou;
    private TextView txResultado;

    private int pontos;

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

        txAcertou = findViewById(R.id.txAcertou);
        txErrou = findViewById(R.id.txErrou);
        txResultado = findViewById(R.id.txResultado);

        txAcertou.setText("txAcertou");
        txErrou.setText("txErrou");

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA PERGUNTA + PONTOS
        Bundle dados = getIntent().getExtras();

        pontos = dados.getInt("pontos");

        txResultado.setText(pontos + "  Pontos" );

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
