package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Historia02Activity extends AppCompatActivity {

    private ImageView foto;
    private TextView titulo;
    private TextView historia;
    private ConstraintLayout fundoHistoria;

    private Button btInicio;    //Voltar para tela Inicial          - OK
    private Button btMusica;    //Iniciar Musica de fundo           - OK
    private Button btPlayer;    //Iniciar leitura da hitoria        - OK
    private Button btReiniciar; //Reiniciar leitura da hitoria      - OK
    private Button btProxima;   //Avançar para a proxima historia   - OK

    private MediaPlayer musicaFundo; //Toca musica de fundo
    private MediaPlayer mediaPlayer; //Toca leitura da historia

    private Button btColor;     //Botão para alterar as cores
    private Button btAlinha;    //Alinhamento de texto
    private int opc = 1;        //Opção do alinhamento e ou cores

    SharedPreferences preferencias;//Preferencias de alterações de cores

    //VOLTAR COM BOTÃO VIRTUAL DO CELULAR - PARA A LISTA DE HISTORIAS
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        musicaFundo.stop();
        finish();

        Intent intent = new Intent(getApplicationContext(), Lista02Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia02);

        preferencias = PreferenceManager.getDefaultSharedPreferences(this);//Preferencias de alterações de cores

        //ADMOB
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA HISTORIA
        Bundle dados = getIntent().getExtras();
        int num = dados.getInt("escolhanova");

        //BOTÃO PARA ALTERAR AS CORES
        fundoHistoria = findViewById(R.id.idLayout);
        btColor = findViewById(R.id.btColor);

        btColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opc > 5) {
                    opc = 1;
                }

                if (opc == 1) {
                    fundoCinza();
                } else if (opc == 2) {
                    fundoRosa();
                } else if (opc == 3) {
                    fundoVerde();
                } else if (opc == 4) {
                    fundoAzul();
                } else if (opc == 5) {
                    fundoPreto();
                }
            }
        });

        //BOTÃO PARA ALINHAMENTO DO TEXTO
        btAlinha = findViewById(R.id.btAlinha);
        btAlinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opc > 3) {
                    opc = 1;
                }

                if (opc == 1) {
                    textoEsquerda();
                } else if (opc == 2) {
                    textoCentro();
                } else if (opc == 3) {
                    textoDireita();
                }
            }
        });

//*************************************************************
//ESCOLHEU HISTORIA 001 - O BEBE JESUS
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 1) {

            foto = findViewById(R.id.idFoto);
            foto.setImageResource(R.drawable.historia017);

            titulo = findViewById(R.id.idTitulo);
            titulo.setText("O bebê Jesus");

            historia = findViewById(R.id.idTexto);
            historia.setText("O anjo Gabriel disse a Maria, \"Você terá um filho!\" \"Como?\" perguntou Maria. \"Eu não sou casada.\" \"O Espírito Santo de Deus virá sobre você. O bebê será Filho de Deus\". Maria acreditou nele.\n\n" +
                    "Maria era noiva de José, mas ele não acreditou na história dela. Então, o anjo o visitou também. \"Maria não está mentindo. O bebê dela será o Filho de Deus. Seu nome será Jesus\".\n\n" +
                    "Assim, José casou-se com Maria. Muitos meses se passaram. Então, eles viajaram para Belém, a cidade natal de José, por ordem do governo. Depois daquela longa viagem, chegou a hora do bebê nascer.\n\n" +
                    "Mas todas as pousadas de Belém estavam cheias. Por isso, o Filho de Deus nasceu numa estrebaria, envolto em panos e deitado numa cama de palha. Deram a ele o nome de \"Jesus\".\n\n" +
                    "Naquela noite, um anjo apareceu a alguns pastores nas montanhas perto de Belém. \"Boas notícias!\" disse o anjo. \"Nasceu o Salvador. Ele está em Belém, deitado numa manjedoura.\"\n\n" +
                    "De repente, mais anjos apareceram; eram tantos que encheram o céu. \"Glória a Deus nas alturas!\" eles cantavam, \"E paz para todos os que lhe querem bem.\"\n\n" +
                    "Quando os anjos se foram, os pastores correram para Belém. Eles encontraram o bebê, o seu Salvador, deitado sobre a palha; exatamente como o anjo havia dito.\n\n" +
                    "Depois de verem Jesus, os pastores atravessaram a cidade. Eles estavam muito animados! Contaram a todo mundo o que havia acontecido e louvaram a Deus por tudo o que Ele fez!\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia017);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

            //BOTÃO PARA VOLTAR PARA A TELA INICIAL
            btInicio = findViewById(R.id.btInicio);
            btInicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia017);
                    musicaFundo.stop();
                    musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);
                    finish();
                    Intent intent = new Intent(getApplicationContext(), Lista02Activity.class);
                    startActivity(intent);

                }
            });

            //BOTÃO PARA INICIAR MUSICA DE FUNDO
            btMusica = findViewById(R.id.btMusica);
            btMusica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!musicaFundo.isPlaying()) {
                        musicaFundo.start();
                        btMusica.setBackgroundResource(R.drawable.musica_on);
                    } else {
                        musicaFundo.pause();
                        btMusica.setBackgroundResource(R.drawable.musica_off);
                    }
                }
            });

            //BOTÃO PARA INICIAR A LEITURA DA HISTORIA
            btPlayer = findViewById(R.id.btPlayer);
            btPlayer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                        btPlayer.setBackgroundResource(R.drawable.pause);
                    } else {
                        mediaPlayer.pause();
                        btPlayer.setBackgroundResource(R.drawable.play);
                    }
                }
            });

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia017);
                        btPlayer.setBackgroundResource(R.drawable.play);
                    }
                    if (musicaFundo.isPlaying()) {
                        musicaFundo.stop();
                        musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);
                        btMusica.setBackgroundResource(R.drawable.musica_off);
                    }
                }
            });

            //BOTÃO PARA AVANÇAR PARA PROXIMA HISTORIA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia017);
                    musicaFundo.stop();
                    musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);
                    finish();

                    Intent intent = new Intent(getApplicationContext(), Lista02Activity.class);

                    //intent.putExtra("escolhanova", 2);//Passa o numero da proxima historia
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//ESCOLHEU HISTORIA 002 - BONS AMIGOS
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 2) {

            foto = findViewById(R.id.idFoto);
            foto.setImageResource(R.drawable.historia018);

            titulo = findViewById(R.id.idTitulo);
            titulo.setText("Bons amigos");

            historia = findViewById(R.id.idTexto);
            historia.setText("Bons amigos");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

            //BOTÃO PARA VOLTAR PARA A TELA INICIAL
            btInicio = findViewById(R.id.btInicio);
            btInicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
                    musicaFundo.stop();
                    musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);
                    finish();
                    Intent intent = new Intent(getApplicationContext(), Lista02Activity.class);
                    startActivity(intent);

                }
            });

            //BOTÃO PARA INICIAR MUSICA DE FUNDO
            btMusica = findViewById(R.id.btMusica);
            btMusica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!musicaFundo.isPlaying()) {
                        musicaFundo.start();
                        btMusica.setBackgroundResource(R.drawable.musica_on);
                    } else {
                        musicaFundo.pause();
                        btMusica.setBackgroundResource(R.drawable.musica_off);
                    }
                }
            });

            //BOTÃO PARA INICIAR A LEITURA DA HISTORIA
            btPlayer = findViewById(R.id.btPlayer);
            btPlayer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                        btPlayer.setBackgroundResource(R.drawable.pause);
                    } else {
                        mediaPlayer.pause();
                        btPlayer.setBackgroundResource(R.drawable.play);
                    }
                }
            });

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
                        btPlayer.setBackgroundResource(R.drawable.play);
                    }
                    if (musicaFundo.isPlaying()) {
                        musicaFundo.stop();
                        musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);
                        btMusica.setBackgroundResource(R.drawable.musica_off);
                    }
                }
            });

            //BOTÃO PARA AVANÇAR PARA PROXIMA HISTORIA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
                    musicaFundo.stop();
                    musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);
                    finish();

                    Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);

                    intent.putExtra("escolhanova", 3);//Passa o numero da proxima historia
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//GRAVAR ALTERAÇÕES DE CORES
//*************************************************************

        if (preferencias.getString("mudaCor",null).equals("fundoCinza")){
            fundoCinza();

        }else if (preferencias.getString("mudaCor",null).equals("fundoRosa")){
            fundoRosa();

        }else if (preferencias.getString("mudaCor",null).equals("fundoAzul")){
            fundoAzul();

        }else if (preferencias.getString("mudaCor",null).equals("fundoVerde")){
            fundoVerde();

        }else if (preferencias.getString("mudaCor",null).equals("fundoPreto")) {
            fundoPreto();
        }

        if (preferencias.getString("mudaTexto",null).equals("textoEsquerda")){
            textoEsquerda();

        }else if (preferencias.getString("mudaTexto",null).equals("textoCentro")){
            textoCentro();

        }else if (preferencias.getString("mudaTexto",null).equals("textoDireita")){
            textoDireita();
        }
    }
    private void fundoCinza() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaCor", "fundoCinza");
        editorDePreferencias.apply();

        fundoHistoria.setBackgroundResource(R.color.color_cinza);
        historia.setTextColor(getResources().getColor(R.color.color_branco));
        titulo.setTextColor(getResources().getColor(R.color.color_branco));
        opc++;
    }

    private void fundoRosa() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaCor", "fundoRosa");
        editorDePreferencias.apply();

        fundoHistoria.setBackgroundResource(R.color.color_rosa);
        historia.setTextColor(getResources().getColor(R.color.color_cinza));
        titulo.setTextColor(getResources().getColor(R.color.color_cinza));
        opc++;
    }

    private void fundoAzul() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaCor", "fundoAzul");
        editorDePreferencias.apply();

        fundoHistoria.setBackgroundResource(R.color.color_azul);
        historia.setTextColor(getResources().getColor(R.color.color_preto));
        titulo.setTextColor(getResources().getColor(R.color.color_preto));
        opc++;
    }

    private void fundoVerde() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaCor", "fundoVerde");
        editorDePreferencias.apply();

        fundoHistoria.setBackgroundResource(R.color.color_verde);
        historia.setTextColor(getResources().getColor(R.color.color_preto));
        titulo.setTextColor(getResources().getColor(R.color.color_preto));
        opc++;
    }

    private void fundoPreto() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaCor", "fundoPreto");
        editorDePreferencias.apply();

        fundoHistoria.setBackgroundResource(R.color.color_preto);
        historia.setTextColor(getResources().getColor(R.color.color_branco));
        titulo.setTextColor(getResources().getColor(R.color.color_branco));
        opc++;
    }

    private void textoEsquerda() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaTexto", "textoEsquerda");
        editorDePreferencias.apply();

        historia.setGravity(Gravity.LEFT);
        titulo.setGravity(Gravity.LEFT);
        btAlinha.setBackgroundResource(R.drawable.esquerda);
        opc++;
    }

    private void textoCentro() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaTexto", "textoCentro");
        editorDePreferencias.apply();

        historia.setGravity(Gravity.CENTER);
        titulo.setGravity(Gravity.CENTER);
        btAlinha.setBackgroundResource(R.drawable.centro);
        opc++;
    }

    private void textoDireita() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaTexto", "textoDireita");
        editorDePreferencias.apply();

        historia.setGravity(Gravity.RIGHT);
        titulo.setGravity(Gravity.RIGHT);
        btAlinha.setBackgroundResource(R.drawable.direita);
        opc++;
    }

}//FINALIZA O PROGRAMA




