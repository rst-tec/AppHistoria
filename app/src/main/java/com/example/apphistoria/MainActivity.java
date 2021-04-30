package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private Button botao1; //Abre a lista de historias 01
    private Button botao2; //Abre a lista de historias 02
    private Button botao3; //Abre o jogo de perguntas
    private Button botao4;

    //VOLTAR COM BOTÃO VIRTUAL DO CELULAR
    @Override
    public void onBackPressed () {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ADMOB
        MobileAds.initialize(this, "ca-app-pub-3774325968995797~8878180455");

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //Abre a lista de historias 01
        botao1 = findViewById(R.id.botao1);
        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Lista01Activity.class);
                startActivity(intent);
            }
        });

        //Abre a lista de historias 02
        botao2 = findViewById(R.id.botao2);
        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Lista02Activity.class);
                startActivity(intent);
            }
        });

        //Abre o jogo de perguntas
        botao3 = findViewById(R.id.botao3);
        botao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 1); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        botao4 = findViewById(R.id.botao4);
        botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Em construção",Toast.LENGTH_LONG).show();
            }
        });
    }
}

