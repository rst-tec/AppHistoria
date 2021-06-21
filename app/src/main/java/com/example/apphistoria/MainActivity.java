package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apphistoria.fragment.AntigoFragment;
import com.example.apphistoria.fragment.NovoFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private Button botao1; //Abre a lista de historias 01
    private Button botao2; //Abre a lista de historias 02
    private Button botao3; //Abre o jogo de perguntas

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
                Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
                intent.putExtra("lista", 1); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        //Abre a lista de historias 02
        botao2 = findViewById(R.id.botao2);
        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
                intent.putExtra("lista", 2); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        //Abre o jogo de perguntas
        botao3 = findViewById(R.id.botao3);
        botao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FasesActivity.class);
                startActivity(intent);
            }
        });
    }
}

