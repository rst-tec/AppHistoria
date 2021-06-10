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

import static android.view.Gravity.CENTER;

public class Historia02Activity extends AppCompatActivity {

    private ImageView foto;
    private TextView titulo;
    private TextView historia;
    private ConstraintLayout fundoHistoria;
    private Button btPergunta;

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

    private int num; //Numero da proxima historia

    SharedPreferences preferencias;//Preferencias de alterações de cores

    //VOLTAR COM BOTÃO VIRTUAL DO CELULAR - PARA A LISTA DE HISTORIAS
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        musicaFundo.stop();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia02);

        preferencias = PreferenceManager.getDefaultSharedPreferences(this);//Preferencias de alterações de cores

        //ADMOB
        MobileAds.initialize(this, "ca-app-pub-3774325968995797~8878180455");

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA HISTORIA
        Bundle dados = getIntent().getExtras();
        num = dados.getInt("historia");

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

        //INICIANDO ELEMENTOS
        foto = findViewById(R.id.idFoto);
        titulo = findViewById(R.id.idTitulo);
        historia = findViewById(R.id.idTexto);
        btPergunta = findViewById(R.id.btPergunta);

        //BOTÃO PARA ABRIR UMA PERGUNTA
        btPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                musicaFundo.stop();
                finish();

                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                Bundle parametros = new Bundle();

                parametros.putInt("pergunta", num); //Passa o numero da pergunta
                parametros.putInt("chave", 222);
                intent.putExtras(parametros);
                startActivity(intent);
            }
        });

        //BOTÃO PARA VOLTAR PARA A VOLTAR A LISTA DE HISTORIAS
        btInicio = findViewById(R.id.btInicio);
        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                musicaFundo.stop();
                finish();
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

        //BOTÃO PARA AVANÇAR PARA PROXIMA HISTORIA
        btProxima = findViewById(R.id.btProxima);
        btProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                musicaFundo.stop();

                //ALTERAR ESSE NUMERO PARA O NUMERO DA ULTIMA HISTORIA
                if (num == 30) {
                    finish();  //VOLTAR PARA A LISTA DE HISTORIAS
                }else {

                    finish();
                    Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                    Bundle parametros = new Bundle();

                    parametros.putInt("historia", num + 1); //Numero da proxima historia

                    intent.putExtras(parametros);
                    startActivity(intent);
                }
            }
        });

//*************************************************************
//ESCOLHEU HISTORIA 017 - O bebê Jesus
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 17) {

            foto.setImageResource(R.drawable.historia017);
            titulo.setText(R.string.TextoHistoria017);
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
        }

//*************************************************************
//ESCOLHEU HISTORIA 018 - O batismo
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 18) {

            foto.setImageResource(R.drawable.historia018);
            titulo.setText(R.string.TextoHistoria018);
            historia.setText("Antes de Deus enviar O Salvador, disse o profeta Malaquias, um mensageiro virá para preparar o caminho para Ele. Então, veio João antes de Jesus, pregando às margens do rio Jordão.\n\n" +
                    "Preparem o caminho do Senhor! João disse. Deus está enviando alguém muito especial para o Seu povo. Mudem seus caminhos. Arrependam-se das coisas más que vocês têm feito. Sejam batizados.\n\n" +
                    "E foi isso mesmo que as pessoas fizeram! Você é o prometido? eles perguntaram. Não, disse João. Eu não sou digno nem de carregar suas sandálias. Ele vai fazer coisas incríveis. Vocês vão ver!\n\n" +                    "Jesus veio até João para ser batizado. Quando João viu Jesus, ele disse: Eis o Cordeiro de Deus que tira o pecado do mundo!\n" +
                    "Eu quero que você me batize, disse Jesus. Não, respondeu João. Eu é que preciso ser batizado por Você! Confie em mim, disse Jesus. Esta é a coisa certa a fazer.\n\n" +
                    "Assim, João batizou Jesus. O Espírito de Deus desceu sobre Jesus como uma pomba. Este é o Meu Filho, Deus disse. Eu o amo. Ele me agrada muito!\n\n " +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia018);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia018);
                        btPlayer.setBackgroundResource(R.drawable.play);
                    }
                    if (musicaFundo.isPlaying()) {
                        musicaFundo.stop();
                        musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);
                        btMusica.setBackgroundResource(R.drawable.musica_off);
                    }
                }
            });
        }

//*************************************************************
//ESCOLHEU HISTORIA 019 - O furo no teto
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 19) {

            foto.setImageResource(R.drawable.historia019);
            titulo.setText(R.string.TextoHistoria019);
            historia.setText("Cheia! A casa estava cheia de gente! Jesus estava na casa ensinando e curando, e todos queriam vê-lo.\n\n" +
                    "Alguns homens tinham um amigo que não andava. Eles acreditavam que Jesus poderia curá-lo, então o carregaram até aquela casa em uma esteira.\n\n" +
                    "Eles não conseguiam entrar, pois a casa estava muito cheia. Então, eles subiram as escadas até o teto e começaram a abrir um furo!\n\n" +
                    "Todos na casa olharam para cima admirados! Os homens baixaram seu amigo pela abertura, até o meio da multidão, bem na frente de Jesus.\n\n" +
                    "Eles achavam que Jesus ia curar seu amigo. Ao invés disso, Jesus lhe disse, \"Seus pecados estão perdoados.\" Alguns líderes religiosos ficaram muito aborrecidos. \"Somente Deus pode perdoar os pecados,\" resmungaram eles.\n\n" +
                    "\"O que é mais fácil?\", perguntou Jesus. \"Perdoar os pecados ou fazer este homem andar? Para mostrar a vocês que eu tenho autoridade de Deus para perdoar os pecados, vou curá-lo também\".\n\n" +
                    "\"Levante-se, pegue sua esteira e vá para casa\", disse Jesus ao homem. E foi o que ele fez! Seus amigos e todas as outras pessoas ficaram muito alegres. Então a casa ficou cheia... cheia de louvor.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia019);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_app);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia019);
                        btPlayer.setBackgroundResource(R.drawable.play);
                    }
                    if (musicaFundo.isPlaying()) {
                        musicaFundo.stop();
                        musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_app);
                        btMusica.setBackgroundResource(R.drawable.musica_off);
                    }
                }
            });
        }

//*************************************************************
//ESCOLHEU HISTORIA 020 - Hora de levantar
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 20) {

            foto.setImageResource(R.drawable.historia020);
            titulo.setText(R.string.TextoHistoria020);
            historia.setText(R.string.TextoHistoria020);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 021 - O piquenique
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 21) {

            foto.setImageResource(R.drawable.historia021);
            titulo.setText(R.string.TextoHistoria021);
            historia.setText(R.string.TextoHistoria021);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 022 - De volta ao lar
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 22) {

            foto.setImageResource(R.drawable.historia022);
            titulo.setText(R.string.TextoHistoria022);
            historia.setText(R.string.TextoHistoria022);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 023 - Hora do jantar
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 23) {

            foto.setImageResource(R.drawable.historia023);
            titulo.setText(R.string.TextoHistoria023);
            historia.setText(R.string.TextoHistoria023);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 024 - A crucificação
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 24) {

            foto.setImageResource(R.drawable.historia024);
            titulo.setText(R.string.TextoHistoria024);
            historia.setText(R.string.TextoHistoria024);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 025 - A ressureição
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 25) {

            foto.setImageResource(R.drawable.historia025);
            titulo.setText(R.string.TextoHistoria025);
            historia.setText(R.string.TextoHistoria025);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 026 - Nas nuvens
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 26) {

            foto.setImageResource(R.drawable.historia026);
            titulo.setText(R.string.TextoHistoria026);
            historia.setText(R.string.TextoHistoria026);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 027 - Nem prata nem ouro
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 27) {

            foto.setImageResource(R.drawable.historia027);
            titulo.setText(R.string.TextoHistoria027);
            historia.setText(R.string.TextoHistoria027);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 028 - Inimigo, agora amigo
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 28) {

            foto.setImageResource(R.drawable.historia028);
            titulo.setText(R.string.TextoHistoria028);
            historia.setText(R.string.TextoHistoria028);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 029 - Viajando por Jesus
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 29) {

            foto.setImageResource(R.drawable.historia029);
            titulo.setText(R.string.TextoHistoria029);
            historia.setText(R.string.TextoHistoria029);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//ESCOLHEU HISTORIA 030 - Uma promessa eterna
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 30) {

            foto.setImageResource(R.drawable.historia030);
            titulo.setText(R.string.TextoHistoria030);
            historia.setText(R.string.TextoHistoria030);

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia001);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

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
        }

//*************************************************************
//GRAVAR ALTERAÇÕES DE CORES
//*************************************************************

        if (preferencias.getString("mudaCor",null) == null){
            SharedPreferences.Editor editorDePreferencias = preferencias.edit();
            editorDePreferencias.putString("mudaCor", "desativado");
            editorDePreferencias.putString("mudaTexto", "desativado");
            editorDePreferencias.apply();
        }

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
        titulo.setGravity(Gravity.LEFT|CENTER);
        titulo.setPadding(20,0,0,0);
        btAlinha.setBackgroundResource(R.drawable.esquerda);
        opc++;
    }

    private void textoCentro() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaTexto", "textoCentro");
        editorDePreferencias.apply();

        historia.setGravity(CENTER);
        titulo.setGravity(CENTER);
        btAlinha.setBackgroundResource(R.drawable.centro);
        opc++;
    }

    private void textoDireita() {
        SharedPreferences.Editor editorDePreferencias = preferencias.edit();
        editorDePreferencias.putString("mudaTexto", "textoDireita");
        editorDePreferencias.apply();

        historia.setGravity(Gravity.RIGHT);
        titulo.setGravity(Gravity.RIGHT|CENTER);
        titulo.setPadding(0,0,20,0);
        btAlinha.setBackgroundResource(R.drawable.direita);
        opc++;
    }

}//FINALIZA O PROGRAMA




