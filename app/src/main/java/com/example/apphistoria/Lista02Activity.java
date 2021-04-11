package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Lista02Activity extends AppCompatActivity {

    private Button btHist001;
    /*
    private Button btHist002;
    private Button btHist003;
    private Button btHist004;
    private Button btHist005;
    private Button btHist006;
    private Button btHist007;
    private Button btHist008;
    private Button btHist009;
    private Button btHist010;
    private Button btHist011;
    private Button btHist012;
    private Button btHist013;
    private Button btHist014;
     */

    private Button btAntigo;


    private ConstraintLayout constraintLayout;

    //VOLTAR COM BOTÃO VIRTUAL DO CELULAR - PARA A TELA INICIAL
    @Override
    public void onBackPressed () {
        super.onBackPressed();
        finish();

        //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista02);

        constraintLayout = findViewById(R.id.constrainLayout);

        //ADMOB
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        btAntigo = findViewById(R.id.btAntigo);
        btAntigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Lista01Activity.class);
                startActivity(intent);
            }
        });

        btHist001 = findViewById(R.id.btHist001);
        btHist001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 1); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        /*

        btHist002 = findViewById(R.id.btHist002);
        btHist002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 2); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist003 = findViewById(R.id.btHist003);
        btHist003.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 3); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist004 = findViewById(R.id.btHist004);
        btHist004.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 4); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist005 = findViewById(R.id.btHist005);
        btHist005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 5); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist006 = findViewById(R.id.btHist006);
        btHist006.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 6); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist007 = findViewById(R.id.btHist007);
        btHist007.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 7); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist008 = findViewById(R.id.btHist008);
        btHist008.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 8); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist009 = findViewById(R.id.btHist009);
        btHist009.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 9); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist010 = findViewById(R.id.btHist010);
        btHist010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 10); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist011 = findViewById(R.id.btHist011);
        btHist011.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 11); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist012 = findViewById(R.id.btHist012);
        btHist012.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 12); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist013 = findViewById(R.id.btHist013);
        btHist013.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 13); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist014 = findViewById(R.id.btHist014);
        btHist014.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                intent.putExtra("escolhanova", 14); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

         */
    }
}






