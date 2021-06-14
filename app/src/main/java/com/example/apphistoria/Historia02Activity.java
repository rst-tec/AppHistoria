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
            historia.setText("A casa estava cheia de gente! Jesus estava na casa ensinando e curando, e todos queriam vê-lo.\n\n" +
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
            historia.setText("Jairo, um líder em sua comunidade, se ajoelhou aos pés de Jesus. \"Minha filhinha está morrendo,\" exclamou ele. \"Se você colocar Suas mãos sobre ela, sei que ela viverá.\"\n\n" +
                    "Jesus e Jairo estavam cercados por uma grande multidão. Alguns empregados de Jairo os encontraram ali. \"Sua filha já está morta,\" disseram eles. \"Não tenha medo,\" disse Jesus. \"Creia, e sua filha será curada.\"\n\n" +
                    "Ao chegarem na casa de Jairo, encontraram pessoas chorando pela menina. \"Por que estão chorando?\" Jesus perguntou. \"A menina não está morta, mas apenas dormindo.\" As pessoas riram Dele.\n\n" +
                    "Jesus e três de Seus discípulos, Pedro, Tiago e João, entraram na casa com Jairo e sua esposa. A menina estava deitada, exatamente como todos haviam dito.\n\n" +
                    "Jesus pegou na mão dela. Então Ele falou, \"Levante-se, menina.\" E ela se levantou! Ela até andou pelo quarto!\n\n" +
                    "Jairo e sua esposa ficaram maravilhados! Jesus pediu a eles que não contassem a ninguém o que Ele havia feito. \"Agora,\" disse Jesus, \"Acho que esta garotinha precisa comer alguma coisa!\"\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia020);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia020);
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
            historia.setText("Jesus tinha acabado de ensinar. Todo mundo estava com fome. \"Mande que saiam para comprar comida\", disseram Seus discípulos. Mas Jesus queria demonstrar que eles podiam confiar em Deus.\n\n" +
                    "\"Por que vocês mesmos não os alimentam?\", Jesus perguntou. \"Seria preciso o salário de um ano todo para comprar pão para tanta gente!\", disseram seus discípulos. \"Quanta comida vocês têm?\", perguntou Jesus.\n\n" +
                    "\"Há um menino aqui\", disse André, \"que tem cinco pães e dois peixinhos\". Jesus sorriu. \"Perfeito. Diga ao povo para sentar na grama\".\n\n" +
                    "Então, as pessoas se sentaram na encosta da colina. Jesus orou e agradeceu a Deus pelos pães e peixes. Em seguida, partiu-os em pedaços para os discípulos distribuírem.\n\n" +
                    "Os discípulos de Jesus deram pão e peixe para toda aquela multidão. Havia cinco mil homens e também muitas mulheres e crianças. Todos comeram tanto quanto quiseram!\n\n" +
                    "Depois disso, os discípulos recolheram o que sobrou. Eram doze cestos cheios, vindos de apenas cinco pães e dois peixes! Todos aprenderam que podiam confiar em Deus para cuidar deles.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia021);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia021);
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
//ESCOLHEU HISTORIA 022 - De volta ao lar
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 22) {

            foto.setImageResource(R.drawable.historia022);
            titulo.setText(R.string.TextoHistoria022);
            historia.setText("\"Por que Jesus passa tempo com pessoas que fazem coisas ruins?\" Os líderes religiosos se perguntavam. Então Jesus contou uma história sobre o amor de Deus. Aconteceu assim...\n\n" +
                    "... um homem tinha dois filhos. O filho mais novo pediu a parte da herança que receberia quando o pai morresse. De coração partido, o pai deu a ele a metade de seus bens.\n\n" +
                    "O filho mudou-se para um país distante. Ele gastou todo o dinheiro, e teve que trabalhar alimentando porcos. Ele passava tanta fome que desejava comer a comida dos porcos.\n\n" +
                    "\"Os Servos do meu pai vivem melhor do que isso\", pensou ele. \"Vou voltar para casa e confessar que pequei contra ele e Deus. Talvez ele me aceite como um de seus servos. \"\n\n" +
                    "O filho voltou para casa. Ele ainda estava longe quando seu pai o avistou, correu até ele e o abraçou. \"Eu não sou digno de ser seu filho\", disse o rapaz ao seu pai.\n\n" +
                    "\"Tragam roupas novas para meu filho!\" O pai disse aos empregados. \"Coloquem um anel em seu dedo. Preparem o bezerro mais gordo. Meu filho estava perdido, mas foi encontrado!\"\n\n" +
                    "O filho mais velho ficou com raiva quando soube da festa. \"Não é justo\", ele reclamou. \"Sou fiel trabalhando aqui e não ganho nada. Ele desperdiça o dinheiro e ainda ganha uma festa! \"\n\n" +
                    "\"Tudo o que é meu é seu\", respondeu o pai. \"Seu irmão estava morto, mas agora está vivo! Ele estava perdido, mas foi achado! O que mais podemos fazer, além de comemorar? \"\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia022);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_app);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia022);
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
//ESCOLHEU HISTORIA 023 - Hora do jantar
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 23) {

            foto.setImageResource(R.drawable.historia023);
            titulo.setText(R.string.TextoHistoria023);
            historia.setText("Jesus curou pessoas doentes e alimentou pessoas famintas. Ele amava os rejeitados e ensinava a todos sobre o Reino de Deus. Mas alguns líderes religiosos não gostavam do que Jesus dizia e tinham inveja Dele.\n\n" +
                    "Eles odiavam tanto a Jesus, que decidiram que Ele deveria morrer. Eles deram trinta moedas de prata para que Judas, um dos discípulos de Jesus, o traísse e entregasse.\n\n" +
                    "Jesus e Seus discípulos celebravam a festa da Páscoa. Enquanto comiam, Jesus disse com tristeza, \"Um de vocês vai Me trair.\" Surpresos, cada um deles respondeu, \"Eu não, Senhor!\"\n\n" +
                    "\"É verdade,\" disse Jesus. \"Um de vocês, alguém que está comendo aqui vai Me trair.\" \"Eu não, Senhor,\" disse Judas. \"Você sabe que é,\" Jesus respondeu. \"Vá! Faça isso depressa!\". Então Judas saiu.\n\n" +
                    "Jesus tomou o pão e agradeceu a Deus. Ele o partiu, deu para Seus discípulos, e disse, \"Lembrem-se de Mim ao comerem. Este é o Meu corpo, entregue por vocês.\"\n\n" +
                    "Então Jesus tomou um copo e agradeceu a Deus por ele. \"Bebam todos\" disse Ele. \"Este é o Meu sangue, derramado para que seus pecados sejam perdoados.\"\n\n" +
                    "Quando terminaram de comer e beber, Jesus e Seus discípulos cantaram um hino. Depois foram ao Jardim do Getsêmani para orar.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia023);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia023);
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
            historia.setText("Alguns líderes religiosos disseram ao governador Pilatos que Jesus era perigoso pois queria ser rei. Pilatos perguntou a Jesus: \"Isso é verdade?\", e Jesus respondeu: \"Eu sou rei, mas não deste mundo\".\n\n" +
                    "\"Jesus é inocente\", disse Pilatos, \"Não há motivo para matá-lo. Eu o soltarei\". Mas a multidão começou a gritar: \"Mate-o!\"\n\n" +
                    "Então, Pilatos mandou seus soldados baterem em Jesus. Eles enfiaram uma coroa de espinhos em sua cabeça e o fizeram carregar uma cruz de madeira morro acima.\n\n" +
                    "No alto do monte os soldados romanos pregaram os pés e as mãos de Jesus na cruz. Eles fincaram a cruz no chão. Jesus foi crucificado entre dois criminosos.\n\n" +
                    "Ao meio dia, o céu escureceu. Os amigos de Jesus choravam. Alguns líderes religiosos riam e zombavam dizendo, \"Você salvou outras pessoas. Por que não salva a si mesmo?\". \"Pai, perdoa-lhes\", disse Jesus.\n\n" +
                    "Quando Jesus estava para morrer, ele fechou os olhos e disse, \"Está concluído.\" Ele havia completado a obra que veio realizar, por causa do seu grande amor.\n\n" +
                    "Um dos discípulos de Jesus, chamado José, colocou o corpo de Jesus num túmulo novo e rolou uma grande pedra na entrada. Um longo e triste dia havia chegado ao fim.\n\n " +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia024);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia024);
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
//ESCOLHEU HISTORIA 025 - A ressureição
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 25) {

            foto.setImageResource(R.drawable.historia025);
            titulo.setText(R.string.TextoHistoria025);
            historia.setText("Domingo pela manhã, algumas mulheres foram ao túmulo para perfumar o corpo de Jesus. Elas sabiam que o túmulo estava fechado com uma grande pedra e estavam pensando como tirá-la.\n\n" +
                    "Quando elas chegaram, a pedra já tinha sido tirada, o corpo de Jesus tinha desaparecido, e havia anjos no túmulo! \"Jesus está vivo! Ele ressuscitou!\" disseram os anjos. \"Vão contar aos discípulos Dele\".\n\n" +
                    "As mulheres contaram aos discípulos. Pedro e João correram para o túmulo de Jesus, para ver se era isso mesmo. Só encontraram os panos com que Jesus fora enterrado e voltaram para casa confusos.\n\n" +
                    "Mais tarde, os discípulos reuniram-se numa sala. Eles conversavam sobre o que estava acontecendo quando, de repente, Jesus apareceu. Eles ficaram apavorados. Pensaram que era um fantasma.\n\n" +
                    "\"Não fiquem preocupados\", disse Jesus. \"Vejam minhas mãos e pés. Sou eu mesmo! Toquem em mim! Vocês não poderiam tocar se eu fosse um fantasma. Fantasmas não comem, mas eu estou com muita fome\".\n\n" +
                    "Então Jesus comeu um pedaço de peixe, e depois começou a ensiná-los. \"As escrituras são claras\", disse ele. O Messias deveria sofrer e morrer, e depois, ressuscitar dos mortos\".\n\n" +
                    "\"Agora anunciem ao mundo o que vocês viram. Que todos saibam que os seus pecados podem ser perdoados, se eles se voltarem para Deus! Isto é possível por causa do que eu fiz\".\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia025);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_app);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia025);
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
//ESCOLHEU HISTORIA 026 - Nas nuvens
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 26) {

            foto.setImageResource(R.drawable.historia026);
            titulo.setText(R.string.TextoHistoria026);
            historia.setText("Chegou a hora de Jesus voltar para o céu. Antes, Ele levou seus discípulos para uma montanha na Galiléia. \"Eis o que eu quero que vocês façam...\", disse Ele.\n\n" +
                    "\"Esperem em Jerusalém até receberem o Espírito Santo que prometi. Em seguida, falem de mim para todos. Vão de Jerusalém para a Judéia, para Samaria e depois para o resto do mundo!\"\n\n" +
                    "\"Façam muitos discípulos; Batizando-os em nome do Pai, do Filho e do Espírito Santo. Ensinem a eles tudo o que vocês aprenderam comigo. Sempre estarei com vocês\".\n\n" +
                    "Depois de algum tempo ensinando essas coisas, Jesus voltou para o céu. Ele foi subindo, até desaparecer numa nuvem. Seus discípulos ficaram observando. Ficaram ali, olhando para o céu.\n\n" +
                    "Dois homens, vestidos de branco, apareceram. \"Jesus foi para o céu\", explicaram. \"Ele voltará da mesma forma que foi!\" Assim, os discípulos obedeceram a Jesus e foram para Jerusalém.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia026);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia026);
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
            historia.setText("Dois homens, vestidos de branco, apareceram. \"Jesus foi para o céu\", explicaram. \"Ele voltará da mesma forma que foi!\" Assim, os discípulos obedeceram a Jesus e foram para Jerusalém.\n\n" +
                    "Pedro e João foram ao templo. Havia um homem ali, na Porta Formosa, que nunca havia andado antes. Ele mendigava, pedindo dinheiro às pessoas.\n\n" +
                    "\"Vocês me dão um trocado?\", ele pediu a Pedro e João. Os dois discípulos olharam para o homem. Eles não tinham dinheiro, mas tinham algo muito melhor para oferecer a ele.\n\n" +
                    "\"Olhe para nós!\" disse Pedro. O homem achou que lhe dariam dinheiro. \"Não tenho prata nem ouro\", disse Pedro, \"mas tenho outra coisa que lhe darei com alegria.\"\n\n" +
                    "\"Em nome de Jesus Cristo de Nazaré\", disse Pedro, \"ande!\" Pedro segurou a mão do homem e seus pés e tornozelos se firmaram. O homem se levantou e começou a andar!\n\n" +
                    "Ele acompanhou Pedro e João ao templo. Em pouco tempo, ele não estava apenas caminhando; ele pulava e louvava a Deus!\n\n" +
                    "As pessoas o haviam visto na Porta. Elas sabiam que ele era paralítico de nascença. No entanto, ali estava ele, andando, pulando e agradecendo a Deus! Todos ficaram impressionados!\n\n" +
                    "Pedro contou ao povo sobre aquele cujo poder havia curado o homem. Ele falou de Jesus. Quando ele terminou de falar, muitos decidiram seguir a Jesus também!\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia027);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia027);
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
//ESCOLHEU HISTORIA 028 - Inimigo, agora amigo
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 28) {

            foto.setImageResource(R.drawable.historia028);
            titulo.setText(R.string.TextoHistoria028);
            historia.setText("Saulo era um homem religioso; um fariseu. Ele achava que qualquer um que acreditasse em Jesus estava espalhando uma mentira e deveria ser colocado na prisão, e até mesmo condenado à morte.\n\n" +
                    "Saulo ia para Damasco para prender os seguidores de Jesus. De repente, uma luz brilhante o cercou. Ele caiu no chão. Uma voz lhe disse: \"Saulo, por que você é tão cruel comigo?\"\n\n" +
                    "\"Quem és Tu, Senhor?\", Perguntou Saulo. A voz respondeu: \"Eu sou Jesus, a quem você está perseguindo. Vá para Damasco. Lá você será instruído sobre o que deve fazer.\"\n\n" +
                    "Saulo levantou-se. Ele estava cego. Então, seus amigos o levaram para uma casa em Damasco. Saulo esperou lá por três dias. Ele não comeu e nem bebeu.\n\n" +
                    "Enquanto isso, Jesus apareceu numa visão a Ananias, um de seus seguidores em Damasco. Jesus disse-lhe para ir visitar Saulo e orar para que ele pudesse enxergar novamente.\n\n" +
                    "\"Mas Saulo está prendendo Seus seguidores\", disse Ananias, tremendo. \"Eu sei\", disse Jesus, \"mas eu escolhi Saulo para falar de mim no mundo inteiro\".\n\n" +
                    "Ananias foi orar por Saulo. \"Jesus me enviou\", disse ele, \"para que você possa enxergar e ser cheio do Espírito Santo\". Saulo pôde ver de novo! Em seguida, ele foi batizado.\n\n" +
                    "Jesus transformou Saulo. Ele deixou de ser o homem que perseguia os cristãos. Saulo se tornou um líder na Igreja e falava a todos sobre Jesus. Até seu nome foi mudado, de Saulo para Paulo.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia028);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_app);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia028);
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




