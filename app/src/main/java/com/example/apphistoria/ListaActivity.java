package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apphistoria.fragment.AntigoFragment;
import com.example.apphistoria.fragment.NovoFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ListaActivity extends AppCompatActivity {

    private Button btAntigo;
    private Button btNovo;
    private Button btLinhaCor1;
    private Button btLinhaCor2;

    private AntigoFragment antigoFragment;
    private NovoFragment novoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //ADMOB
        MobileAds.initialize(this, "ca-app-pub-3774325968995797~8878180455");

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        btAntigo = findViewById(R.id.btAntigo);
        btNovo = findViewById(R.id.btNovo);
        btLinhaCor1 = findViewById(R.id.btLinhaCor1);
        btLinhaCor2 = findViewById(R.id.btLinhaCor2);

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA HISTORIA
        Bundle dados = getIntent().getExtras();
        int num = dados.getInt("lista");

        if (num == 1) {
            antigoFragment = new AntigoFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameConteudo, antigoFragment);
            transaction.commit();
            btLinhaCor2.setBackgroundResource(R.drawable.linhacor2);
            btLinhaCor1.setBackgroundResource(R.drawable.linhacor1);
        }

        if (num == 2) {
            novoFragment = new NovoFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameConteudo, novoFragment);
            transaction.commit();
            btLinhaCor1.setBackgroundResource(R.drawable.linhacor2);
            btLinhaCor2.setBackgroundResource(R.drawable.linhacor1);
        }

        btAntigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                antigoFragment = new AntigoFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, antigoFragment);
                transaction.commit();
                btLinhaCor2.setBackgroundResource(R.drawable.linhacor2);
                btLinhaCor1.setBackgroundResource(R.drawable.linhacor1);

            }
        });

        btNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novoFragment = new NovoFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, novoFragment);
                transaction.commit();
                btLinhaCor1.setBackgroundResource(R.drawable.linhacor2);
                btLinhaCor2.setBackgroundResource(R.drawable.linhacor1);
            }
        });



    }
}
