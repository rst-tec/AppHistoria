package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FasesActivity extends AppCompatActivity {
    private Button btFase01;
    private Button btFase02;
    private Button btFase03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fases);

        btFase01 = findViewById(R.id.btFase01);
        btFase02 = findViewById(R.id.btFase02);
        btFase03 = findViewById(R.id.btFase03);

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
    }
}
