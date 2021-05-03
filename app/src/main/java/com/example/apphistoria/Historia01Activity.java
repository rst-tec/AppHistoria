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

public class Historia01Activity extends AppCompatActivity {

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
    public void onBackPressed () {
        super.onBackPressed();
        mediaPlayer.stop();
        musicaFundo.stop();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia01);

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
                if (opc > 5) {opc = 1;}

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
                if (opc > 3) {opc = 1;}

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

                parametros.putInt("pergunta", num); //Passa o numero da proxima pergunta
                parametros.putInt("chave", 999);
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

                if (num == 16) {
                    finish();  //VOLTAR PARA A LISTA DE HISTORIAS
                }else {

                    finish();
                    Intent intent = new Intent(getApplicationContext(), Historia01Activity.class);
                    Bundle parametros = new Bundle();
                    parametros.putInt("historia", num + 1); //Numero da proxima historia
                    intent.putExtras(parametros);
                    startActivity(intent);
                }
            }
        });

//*************************************************************
//ESCOLHEU HISTORIA 001 - A Criação do Mundo
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 1) {

            foto.setImageResource(R.drawable.historia001);
            titulo.setText("A Criação do Mundo");
            historia.setText("No início, quando Deus criou o universo, a Terra não tinha forma. Ela era vazia e escura.\n" +
                    "Então, Deus disse: Que haja luz. E a luz apareceu. Deus separou a escuridão e a luz, Ele chamou a escuridão de noite, e a luz de dia.\n\n" +
                    "No segundo dia Deus disse: Que haja céu e ar para respirar e um lindo céu apareceu. No mesmo dia, Deus disse: Que as águas se ajuntem aos mares e deixem a terra seca aparecer.\n" +
                    "E assim foi, e o mar e a terra eram bons em todos os sentidos.\n\n" +
                    "Depois que Deus criou o universo, a noite e o dia, os mares, o céu e a terra seca, Ele queria criar vida. Assim, no terceiro dia, Deus disse: Que haja plantas de todas as espécies, aquelas que dão grãos e as que dão frutos.\n" +
                    "Então, a Terra produziu plantas, e as plantas produziram sementes, para crescerem mais plantas. A noite passou e o dia veio. O terceiro dia também terminou.\n\n" +
                    "Então, no quarto dia, Deus fez o sol para brilhar de dia e a lua e as estrelas de noite. Tudo era bom em todos os sentidos. A noite passou e a manhã veio. O quarto dia também terminou.\n\n" +
                    "No quinto dia, Deus disse: Que as águas se encham de Ser vivos e o ar se encha com pássaro. E então Deus fez as criaturas do mar e pássaros de todas as espécies e o quinto dia terminou.\n\n" +
                    "No dia seguinte, Deus disse: Que haja todos os tipos de animais. E o mundo inteiro estava agora vivo com as criaturas de Deus. Ele os abençoou para terem bebés. Finalmente, Deus fez o Homem a Sua própria imagem, do pó da Terra. O sexto dia terminou. Ele disse alegremente: Está tudo muito bom!\n\n" +
                    "Deus levou apenas seis dias para fazer tudo. Ele descansou no sétimo dia e o abençoou como um dia de descanso.\n\n" +
                    "FIM.\n");

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
//ESCOLHEU HISTORIA 002 - O Pecado de Adão e Eva
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 2) {

            foto.setImageResource(R.drawable.historia002);
            titulo.setText("O Pecado de Adão e Eva");
            historia.setText("Deus soprou Seu próprio folego no Homem, e ele teve vida.\n" +
                    "Deus o chamou de Adão. Então, Deus fez um jardim adorável chamado Éden. Ele era cheio de arvores que davam frutos e tinha um rio no meio do jardim!\n\n" +
                    "Os animais circulavam sem qualquer medo. A \"Árvore da Vida\" e a \"Árvore do Conhecimento do Bem e do Mal\" estavam lá no jardim também.\n\n" +
                    "Deus disse para Adão: Cuide deste lugar e não terá nenhuma necessidade. Porém, não coma a fruta da \"Árvore do Conhecimento do Rem e do Mal\".\n" +
                    "Aquela árvore dá o conhecimento do que é bom e do que é ruim, se você fizer isso, você morrerá. Adão cuidou do jardim e também deu nome para todos os animais!\n\n" +
                    "Adão falava com Deus todos os dias e tudo estava bom. Deus criou todos os animais, tanto machos quanto fêmeas, mas Adão não tinha nenhuma companheira.\n\n" +
                    "Então, Deus disse: Não é bom para Adão ficar sozinho, vou fazer uma companheira para ele. Então, Deus colocou Adão em um sono profundo.\n" +
                    "Ele removeu uma costela do peito de Adão e o fechou! Deus fez a Mulher com essa costela. Deus deu a Adão está adorável companheira para viver com ele.\n" +
                    "Adão a amou. Ele a chamou de Eva, que significa \"Mãe de toda a vida\".\n\n" +
                    "Havia uma serpente esperta entre os outros animais do Jardim. Um dia, ela chegou para Eva e disse: Se você comer do fruto proibido você será igual a Deus e conhecerá o bem e o mal!\n\n" +
                    "Eva desobedeceu às instruções de Deus, comeu a fruta e também a deu para Adão! Imediatamente eles entenderam que eles não estavam vestidos, e se vestiram com folhas de figueira.\n\n" +
                    "Mais tarde, Deus chamou por Adão e Eva, mas eles se esconderam com medo. Deus perguntou se eles tinham comido a fruta. Eles confessaram.\n" +
                    "Então, Adão culpou Eva e Eva culpou a serpente! Deus os expulsou do Éden.\n\n" +
                    "Agora Adão teria que trabalhar duro para cultivar alimentos. Eva sofreria dor para ter filhos. A serpente rastejaria no chão.\n\n" +
                    "Deus deu roupas feitas de peles de animais para Adão e Eva e os enviou pra fora do Jardim.\n" +
                    "Deus, então, colocou um anjo com uma espada para guardar a entrada do Jardim.  Ele protegia o caminho até a \"Árvore da Vida\".\n" +
                    "Aqueles que comessem seu fruto viveriam para sempre.\n\n" +
                    "FIM.\n");

            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia002);
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
//ESCOLHEU HISTORIA 003 - A Arca e o Diluvio
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 3) {

            foto.setImageResource(R.drawable.historia003);
            titulo.setText("A Arca e o Diluvio");
            historia.setText("Com o passar do tempo, as pessoas começaram a desagradar a Deus mais e mais. Deus estava muito triste de ver Seu mundo tão estragado.\n" +
                    "Ele teve pena de ter criado o homem. Ele decidiu destruir toda a Sua criação!\n\n" +
                    "No entanto, entre todos aqueles que eram maus, existia um homem bom chamado Noé. Deus queria salvar Noé e sua família.\n" +
                    "Então, Ele apareceu para Noé. Eu vou destruir o mundo. disse Deus para Noé, construa um enorme navio ou arca de boa madeira.\n" +
                    "Faça com três andares e coloque uma porta no lado. Noé concordou fazer de acordo com as palavras do Senhor.\n\n" +
                    "Deus havia dado a Noé instruções exatas de como construir uma arca. Então, Noé começou a fazer a arca junto com seus três filhos.\n" +
                    "Porém, todas as pessoas zombaram de Noé por fazer um navio que estava tão longe da água, mas Noé continuou construindo a arca.\n\n" +
                    "Deus falou novamente: Noé, leve para a arca sua esposa, seus três filhos e as esposas de seus filhos.\n" +
                    "Leve dois animais de cada espécie para a arca. Faça isso para que todas as espécies sobrevivam e tenham filhos jovens na Terra novamente.\n\n" +
                    "Noé seguiu as instruções de Deus. Quando todos estavam a bordo, a porta da arca foi fechada.\n" +
                    "Uma semana mais tarde, começou a chover. Como Deus tinha prometido, a chuva tornou-se cada vez mais difícil e continuou a chover por quarenta dias.\n\n" +
                    "Como o nível da água subiu, a arca começou a flutuar. Neste grande dilúvio, que cobriu todo o mundo, toda vida na Terra foi destruída.\n" +
                    "Somente Noé, sua família e todos os outros na arca foram salvos. Uma ou duas vezes quando Noé escolheu olhar pela janela da arca, ele não viu nada lá fora, senão chuva e água.\n\n" +
                    "Finalmente, Deus enviou ventos para soprar a água. A água começou baixar lentamente e a chuva também parou. Então, os picos mais altos começaram a aparecer acima da água.\n" +
                    "Logo, em poucos dias, a arca repousou sobre o Monte Ararate.\n\n" +
                    "Quarenta dias mais tarde, Noé abriu uma janela. Ele disse: Vou enviar uma pomba para descobrir se há terra seca em algum lugar.\n" +
                    "Então, Noé enviou uma pomba. Ela não conseguiu encontrar terra em lugar algum e voou de volta para a arca.\n\n" +
                    "Após uma semana, Noé enviou outra pomba novamente. Desta vez, ela retornou com uma folha de oliveira em seu bico. A folha mostrava que as águas tinham baixado.\n" +
                    "Depois de outros sete dias, ele enviou a pomba novamente. Ela não retornou.\n\n" +
                    "Algumas semanas mais tarde, Deus disse para Noé: É hora de você deixar a arca.\n" +
                    "E foi isso que Noé fez. Então, Noé construiu um altar e adorou a Deus em gratidão. Deus ficou satisfeito e prometeu a Noé: Eu nunca enviarei um dilúvio novamente para destruir a Terra.\n" +
                    "Eu faço essa promessa a você e aos seus descendentes. Eu coloco esse arco-íris no céu como um lembrete da minha promessa.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia003);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_app);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia003);
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
//ESCOLHEU HISTORIA 004 - A grande promessa
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 4) {

            foto.setImageResource(R.drawable.historia004);
            titulo.setText("A grande promessa");
            historia.setText("Muito depois de Noé, viveu Abraão, seu descendente. Ao contrário de outros, Abraão acreditava em Deus.\n\n" +
                    "Portanto um dia, Abraão ouviu a voz de Deus que dizia: Saia e Vá para a terra que eu mostrarei para você. Abraão obedeceu a Deus, ele pegou seu pai Terá, sua esposa Sara e Ló, seu sobrinho, seu gado e servos e chegou a Canaã. \n\n" +
                    "Novamente Deus falou a Abraão e prometeu dar à sua descendência a terra de Canaã. Deus contou a ele que ele teria gerações depois dele tão inúmeras quanto as estrelas do céu e o pó da Terra. \n\n" +
                    "Abraão, porém, se perguntou como isso aconteceria, já que ele não tinha filhos, mas ele acreditava em Deus e ele sabia que Sua vontade seria feita.\n\n" +
                    "Deus abençoou Abraão com riquezas, gado, prata e ouro. Abraão seguiu Deus, fielmente. Ele viajou para o sul até Betel, lá o sobrinho de Abraão, que viajou com ele, também tinha se tornado rico. \n\n" +
                    "Entretanto, seus servos frequentemente discutiam por causa de pastagens e água para seus rebanhos, visto que a área que eles tinham não era grande o suficiente, para evitar brigas, Abraão aconselhou Ló a escolher uma parte da terra e depois separar. \n\n" +
                    "Ló escolheu as planícies da Jordânia, perto das cidades de Sodoma e Gomorra. Ele até montou sua tenda em direção a Sodoma. \n\n" +
                    "Enquanto isso, Abraão permaneceu na terra de Canaã. Uma vez mais, Deus disse a Abraão: Olhe para o norte, sul, leste e oeste. Eu darei toda essa terra a você e aos seus descendentes, que serão incontáveis.\n\n" +
                    "Certo dia, ao meio-dia, Abraão viu três estrangeiros na porta de sua tenda. Abraão, imediatamente, pediu um pouco de carne, com bolos quentes frescos. Mais tarde, os três estrangeiros comeram com Abraão. \n\n" +
                    "Então, os estrangeiros disseram que Sara teria um bebê. Sara e Abraão já estavam bastante velhos. Ouvindo isso, Sara que estava do lado de dentro da tenda, deu uma risadinha. Ouvindo seu riso, o estrangeiro perguntou: Por que Sara riu? Existe alguma coisa que seja impossível para Deus? \n\n" +
                    "Assim que os estrangeiros partiram, Abraão lembrou que é exatamente o que Deus também tinha falado a ele. Então, ele soube que Deus cumpriria a promessa.\n\n" +
                    "Então, Deus cumpriu sua promessa e abençoou Abraão e Sara com um filho homem. Naquele tempo, Abraão tinha 100 anos e Sara 90. \n\n" +
                    "Abraão chamou seu filho de Isaque, que significa \"Riso\"! Então, Sara disse alegremente: Deus me fez rir, de modo que todos os que ouçam irão rir comigo! Quão felizes estavam Abraão e Sara!\n\n" +
                    "Deus honrou a fé de Abraão. Com o passar do tempo, Isaque cresceu no cuidado amoroso de seus pais.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia004);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_app);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia004);
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
//ESCOLHEU HISTORIA 005 - A prova de Abraão e Isaque
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 5) {

            foto.setImageResource(R.drawable.historia005);
            titulo.setText("A prova de Abraão e Isaque");
            historia.setText("Um dia Deus disse para Abraão: Sacrifique seu único filho Isaque para Mim, em uma montanha que eu vou te mostrar.\n\n" +
                    "Abraão ficou com o coração partido. Ele também ficou surpreso, uma vez que Deus tinha prometido a ele muitos descendentes, mas ele decidiu obedecer a Deus.\n\n" +
                    "Então no dia seguinte, Abraão e Isaque subiram até montanha com fogo, faca e madeira. Isaque entendeu tudo mas manteve-se quieto. \n\n" +
                    "Uma vez no topo da montanha, Isaque perguntou - Onde está o sacrifício Pai? Deus proverá, respondeu Abraão.\n\n" +
                    "Abraão construiu um altar, amarrou Isaque e o deitou sobre a madeira. Isaque também entendeu, mas permaneceu quieto.\n\n" +
                    "No momento seguinte um anjo de Deus disse: Pare, não faça isso com seu filho. Eu posso ver que você realmente adora e confia em Deus. \n\n" +
                    "Então Abraão avistou um carneiro nos arbustos e o ofereceu como sacrifício.\n\n" +
                    "Ele se alegrou e louvou a Deus. \n\n" +
                    "Abraão sabia agora que Deus, verdadeiramente, manteria sua promessa.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia005);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia005);
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
//ESCOLHEU HISTORIA 006 - O sonhador José
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 6) {

            foto.setImageResource(R.drawable.historia006);
            titulo.setText("O sonhador José");
            historia.setText("Jacó tinha doze Filhos, ele amava todos os seus filhos, mas era José quem mais amava, o primogênito de sua amada Raquel.\n\n" +
                    "Um dia, Jacó deu de presente para José uma bela túnica toda colorida. Seus irmãos mais velhos, vendo a túnica, ficaram com ciúmes de José. E depois daquele dia sua benignidade para com José diminuiu.\n\n" +
                    "José tinha um dom, ele sonhava e os interpretava muito sabiamente para sua pouca idade. Um dia, ele foi com seus irmãos levar seus rebanhos para as pastagens. Lá, José contou aos irmãos sobre um sonho que ele havia tido.\n\n" +
                    "Ele tinha sonhado que todos eles estavam amarrando feixes de grãos no campo. De repente, apenas o feixe de José ficou em pé no centro e os feixes de todos os irmãos ficaram em pé ao redor do feixe dele e se curvaram!\n\n" +
                    "Seus irmãos entenderam o sonho, e gritaram: — O que? Nós nos curvaremos diante de você? Depois daquele dia, os irmãos de José o odiaram ainda mais.\n\n" +
                    "Em outra ocasião, José disse para seu pai e seus irmãos: — Em meu sonho eu vi o sol, a lua e onze estrelas curvando-se para mim.\n\n" +
                    "Ouvindo isso, Jacó ficou irritado. Ele disse: — Você acha que sua mãe, eu, e todos os seus onze irmãos iremos nos curvar para você? Você acha que se tornará mais importante que o restante da família?\n\n" +
                    "Depois, quando estava sozinho, Jacó pensou sobre o sonho de José. Ele se perguntou se José era especial aos olhos de Deus.\n\n" +
                    "Embora ninguém entendesse os sonhos de José, essa era a maneira de Deus dizer que José iria ser uma pessoa muito importante quando crescesse.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia006);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia006);
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
//ESCOLHEU HISTORIA 007 - Os sonhos se realizam
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 7) {

            foto.setImageResource(R.drawable.historia007);
            titulo.setText("Os sonhos se realizam");
            historia.setText("No Egito, os homens que compraram José, voltaram a vende-lo para Potifar, e José trabalhou para ele até se tornar administrador de toda a casa. Porém uma mentira contada pela esposa de Potifar, fez com que José fosse preso.\n\n" +
                    "Na prisão, José teve contato com o padeiro e o copeiro do faraó, que também estavam presos. Esses homens tiveram sonhos, e José os interpretou.\n\n" +
                    "Depois de algum tempo o rei do Egito teve dois sonhos bem estranhos, mas nenhum sábio conseguiu interpretá-los.\n\n" +
                    "O chefe dos copeiros, entretanto lembrou-se, do dom de José e contou ao faraó, que mandou chamar o jovem imediatamente.\n\n" +
                    "Ao chegar, José explicou os sonhos, ao faraó.\n\n" +
                    "As sete vacas e as sete espigas boas significam que haverá sete anos de fartura no Egito.\n\n" +
                    "Mas em seguida haverá sete anos de muita seca, o que é representado pelas vacas magras e as espigas secas. Por isso, guardem todo o alimento que conseguirem nos anos de prosperidade.\n\n" +
                    "Ao ver tanta sabedoria de Deus naquele jovem, o faraó o nomeou como governador do Egito, para que pudesse salvar o povo da fome que estava por vir.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia007);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia007);
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
//ESCOLHEU HISTORIA 008 - Moisés, um bebê especial
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 8) {

            foto.setImageResource(R.drawable.historia008);
            titulo.setText("Moisés, um bebê especial");
            historia.setText("Com a ordem de matar todos os bebês do sexo masculino dada pelo faraó, uma mãe israelita conseguiu esconder seu bebê em casa.\n\n" +
                    "Após três meses, ela já não podia mais esconder o bebê, então, com medo de que o matassem, colocou-o em um cesto e o deixou à beira do Rio Nilo. \n\n" +
                    "A irmã do menino ficou observando tudo de longe. Lá, a princesa, filha do faraó, encontrou a criança e decidiu adotá-la. A irmã do bebê aproximou-se e se ofereceu para cuidar do menino até que ele estivesse grande. A princesa aceitou a oferta e deu ao menino o nome de Moisés. Então, o bebê acabou sendo cuidado por sua própria mãe.\n\n" +
                    "Moisés cresceu e foi educado como um príncipe. Certo dia, quando foi visitar os escravos do Egito, Moisés percebeu como eles eram maltratados. Ao ver um soldado egípcio batendo em um israelita, o jovem ficou muito bravo e matou aquele soldado. Por causa disso, Moisés teve de fugir para Midiã.\n\n" +
                    "Depois de muitos anos em Midiã, Moisés foi para o Monte Sinai e viu um espinheiro que pegava fogo, porém não se queimava. Ele ficou curioso e, quando se aproximou, Deus falou com ele e pediu-lhe que voltasse para o Egito e libertasse seu povo. Deus ajudaria e protegeria Moisés em sua jornada.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia008);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia008);
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
//ESCOLHEU HISTORIA 009 - Castigos para faraó
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 9) {

            foto.setImageResource(R.drawable.historia009);
            titulo.setText("Castigos para faraó");
            historia.setText("Moisés obedeceu a Deus e partiu para o Egito com seu irmão Arão. Juntos, eles pediram ao faraó que libertasse os israelitas, pois aquilo era um desejo do Senhor.\n\n" +
                    "Mas o faraó era teimoso e não acreditou em Moisés, mesmo quando o bastão do israelita se transformou em cobra. Deus, então, lançou dez pragas sobre o povo egípcio. \n\n" +
                    "Quando o faraó estava no Rio Nilo, Arão estendeu seu bastão sobre as águas e elas transformaram-se em sangue. \n\n" +
                    "Essa foi a primeira praga e, mesmo assim, o faraó não libertou o povo de Israel, fazendo com que os egípcios sofressem mais nove pragas. Na segunda praga, rãs surgiram em todo o Egito, e na terceira praga, o pó da Terra se transformou em piolhos.\n\n" +
                    "Moscas surgiram em toda parte, como a quarta praga, e os animais dos egípcios morreram, por causa da quinta praga. \n\n" +
                    "A sexta praga marcou o aparecimento de tumores nas pessoas e nos animais, e uma forte chuva de pedra foi o sinal da sétima praga.\n\n" +
                    "Na oitava praga, milhares de gafanhotos surgiram por todos os lugares, e depois uma tenebrosa escuridão tomou conta do país, devido à nona praga.\n\n" +
                    "Por fim, a última praga foi a mais terrível. Com a teimosia do faraó em não libertar os israelitas, todos os filhos primogênitos dos egípcios morreram.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia009);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_app);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia009);
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
//ESCOLHEU HISTORIA 010 - Deus abre um caminho
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 10) {

            foto.setImageResource(R.drawable.historia010);
            titulo.setText("Deus abre um caminho");
            historia.setText("Depois que o filho do faraó morreu durante a décima praga, ele deixou os israelitas partirem. Eles estavam perto do Mar Vermelho quando o faraó mudou de ideia e foi persegui-los.\n\n" +
                    "Quando os israelitas viram o exército do faraó, ficaram apavorados. Mas Deus disse a Moisés que levantasse seu cajado na direção do Mar Vermelho. Deus mandou um vento forte e dividiu o mar!\n\n" +
                    "Um caminho seco apareceu e os israelitas atravessaram o Mar Vermelho! Havia uma parede de água de cada lado. Eles chegaram em segurança na outra margem.\n\n" +
                    "O Faraó e seu exército os seguiram para dentro do mar. Deus disse a Moisés para erguer sua mão, então o mar se fechou. O faraó e seu exército se afogaram.\n\n" +
                    "Deus conduziu seu povo por um deserto. Ele os alimentou e lhes deu água. Eles acamparam no Monte Sinai, onde Deus disse a Moisés para encontrá-lo no topo da montanha.\n\n" +
                    "Cercado por fogo e fumaça, Moisés subiu ao topo e Deus desceu para encontrá-lo.\n\n" +
                    "Então, Deus deu a Moisés os Dez Mandamentos em duas placas de pedra: Não adore a ouros deuses. Não faça ídolos. Trate Meu nome com respeito. Trate o dia de sábado como um dia especial.\n\n" +
                    "Respeite seus pais. Não mate. Seja leal a seu marido ou esposa. Não roube. Não minta. Não inveje os outros ou o que eles possuem. Agora o povo saberia como obedecer a Deus.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia010);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia010);
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
//ESCOLHEU HISTORIA 011 - A queda do muro
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 11) {

            foto.setImageResource(R.drawable.historia011);
            titulo.setText("A queda do muro");
            historia.setText("Moisés enviou doze espias para a Terra Prometida. Dez disseram, \"Nunca vamos derrotar aquele povo\". Mas Josué e Calebe disseram, \"Com a ajuda de Deus, vamos conseguir!\" \n\n" +
                    "Amedrontado, o povo acreditou nos dez espias. Deus disse, \"Somente seus filhos, com Josué e Calebe, entrarão na Terra Prometida\". Então, depois de quarenta anos no deserto, chegou a hora!\n\n" +
                    "Josué enviou dois espias para Jericó. Eles encontraram uma mulher chamada Raabe, que os escondeu e os ajudou a escapar pelo muro da cidade. Eles prometeram poupar a vida dela e de sua família.\n\n" +
                    "Os israelitas atravessaram o rio Jordão. Os sacerdotes foram na frente carregando a Arca da Aliança. Quando seus pés tocaram na água o rio parou! Todos atravessaram em terra seca.\n\n" +
                    "Jericó era a próxima parada. O Anjo de Deus disse a Josué, \"Marchem rodeando Jericó uma vez por dia, durante seis dias. No sétimo dia, rodeiem sete vezes. Toquem trombetas! Gritem! O muro vai cair\".\n\n" +
                    "Josué confiava em Deus. Ele fez o que o Senhor disse e o muro caiu! Eles invadiram a cidade e Raabe foi poupada. Então o povo de Deus começou a conquistar a Terra Prometida.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia011);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia011);
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
//ESCOLHEU HISTORIA 012 - Um herói cabeludo
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 12) {

            foto.setImageResource(R.drawable.historia012);
            titulo.setText("Um herói cabeludo");
            historia.setText("Tempos depois da libertação liderada por Gideão, os israelitas começaram a fazer novamente coisas que não agradavam a Deus. Por isso, os filisteus escravizaram o povo de Israel durante 40 anos.\n\n" +
                    "Deus, por sua infinita bondade, enviou seu anjo à esposa de Manoá, e disse que ela daria à luz um menino especial, que libertaria seu povo. Ele se chamaria Sansão, e nunca poderia ter os cabelos cortados. \n\n" +
                    "Sansão nasceu, e recebeu de Deus muita força.  O segredo de tanta força estava e seus cabelos, mas ninguém sabia disso. \n\n" +
                    "Como era muito forte, Sansão lutou várias vezes contra os filisteus, e por isso eles queriam derrota-lo.\n\n" +
                    "Um dia Sansão conheceu uma mulher chamada Dalila e se apaixonou por ela. Ao saber disso, os governantes dos filisteus planejavam descobrir de onde vinha a enorme força do jovem.\n\n" +
                    "Eles ofereceram dinheiro a Dalila para que ela descobrisse o segredo de Sansão. A jovem mulher aceitou e perguntou a Sansão várias vezes de onde vinha seu poder, até que um dia ele contou seu segredo.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia012);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_app);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia012);
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
//ESCOLHEU HISTORIA 013 - Rainha escolhida
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 13) {

            foto.setImageResource(R.drawable.historia013);
            titulo.setText("Rainha escolhida");
            historia.setText("Ester era a Rainha da Persia. Nem mesmo seu marido, o Rei Xerxes, sabia de seu segredo. Ester era judia. O primo de Ester, Mordecai, trabalhava no palácio e ficava de olho nela.\n\n" +
                    "O conselheiro de Xerxes, Hamã, recebeu uma grande promoção. Ele estava muito orgulhoso. Todos menos Mordecai se inclinavam diante dele. Hamã se sentiu insultado e jurou que mataria ele e todos os judeus!\n\n" +
                    "Hamã mentiu para Xerxes dizendo que os judeus eram perigosos e deviam morrer. Ele concordou e marcou um dia para mata-los. Mordecai ficou horrorizado e mandou uma mensagem para a Rainha Ester.\n\n" +
                    "\"Mude a opinião do rei\", disse ele. \"Se eu me apresentar a ele sem ser convidada, ele pode mandar me matar\", Ester respondeu. \"Talvez você tenha se tornado rainha para um tempo como este\", disse Mordecai.\n\n" +
                    "Ester corajosamente concordou em tentar e foi até a sala do trono. O Rei Xerxes, deslumbrado com sua beleza, a convidou para entrar. \"Podemos jantar com Hamã?\", ela perguntou.\n\n" +
                    "Hamã estava construindo uma enorme forca em seu quintal, ele planejava enforcar Mordecai nela. Então chegou o convite do rei e Hamã foi ao palácio para jantar.\n\n" +
                    "\"Um homem quer me matar e matar meu povo, os judeus\", Ester disse a Xerxes. \"Quem faria tal coisa?\" ele perguntou. \"O maldoso Hamã!\" Exclamou Ester. \"Hamã? Guardas! Leve o daqui.\"\n\n" +
                    "Assim, Hamã foi enforcado na forca que havia construído. Por causa de Ester, os judeus foram salvos, eles comemoraram com uma grande festa, que celebram até hoje.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia013);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia013);
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
//ESCOLHEU HISTORIA 014 - Deus chama Samuel
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 14) {

            foto.setImageResource(R.drawable.historia014);
            titulo.setText("Deus chama Samuel");
            historia.setText("Ana estava triste porque não tinha filhos. Ela orou e Deus deu a ela um filho, Samuel. Ela ficou muito agradecida e entregou Samuel a Deus para servi-Lo.\n\n" +
                    "Ana deixou seu filhinho no tabernáculo com Eli, o sacerdote. Samuel ajudava o velho e cego Eli. Ele até dormia no tabernáculo, enquanto Eli dormia em um quarto próximo.\n\n" +
                    "Uma noite, Samuel ouviu uma voz chamando seu nome. Ele levantou e correu até Eli. \"Aqui estou\", ele disse. \"Eu não te chamei\", resmungou Eli. \"Volte para cama\".\n\n" +
                    "Samuel voltou para cama. Ele ouviu seu nome de novo e, outra vez, correu para Eli. \"Aqui estou\", disse ele. \"Eu não te chamei\", Eli suspirou, com sono. \"Volta para cama\".\n\n" +
                    "Depois que Samuel ouviu a voz pela terceira vez, Eli entendeu que era a voz do Senhor. \"Se Ele chamar de novo,\" disse Eli, \"diga, Fala Senhor, o teu servo está ouvindo.\" E Samuel obedeceu.\n\n" +
                    "\"Samuel,\" chamou Deus, \"você será meu profeta e entregará Minhas palavras fielmente ao Meu povo?\" \"Sim Senhor,\" disse Samuel. E assim ele fez, até ficar bem velhinho.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia014);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia014);
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
//ESCOLHEU HISTORIA 015 - Davi e Golias
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 15) {

            foto.setImageResource(R.drawable.historia015);
            titulo.setText("Davi e Golias");
            historia.setText("O tempo passou. Mais uma vez, os Filisteus travaram uma guerra contra o povo de Deus. O exército do Rei Saul e os Filisteus tinham acampado em ambos os lados de uma colina. No entanto, os soldados de Israel estavam com medo porque, diariamente, um gigante do exército dos Filisteus desafiava os Israelitas. \n\n" +
                    "Por quarenta dias, o gigante chamado Golias gritava: — Israelitas, mandem o melhor homem de vocês para lutar comigo. Se ele vencer, os Filisteus serão seus servos, mas se eu vencer, então vocês serão nossos escravos.\n\n" +
                    "Nenhum soldado Israelita respondeu ao desafio dele. Então, um dia, Davi, que tinha trazido comida para seus irmãos mais velhos, soldados no exército do Rei Saul, ouviu o desafio do gigante. — Se ninguém for, eu vou lutar com ele. — disse Davi.\n\n" +
                    "Não importava o que seus irmãos dissessem, Davi estava determinado a lutar com Golias. Ele foi levado ao Rei Saul.\n\n" +
                    "Quando Saul soube de tudo isso, disse: Filho, você é um mero garoto. Como você pode derrotar um guerreiro treinado? Então, Davi disse: — O Senhor me salvou quando um leão atacou minha ovelha. O Senhor me protegeu, então ele me protegerá agora. \n\n" +
                    "Em seguida, Davi foi até o riacho, coletou algumas pedras e foi até o campo de batalha. Lá, ele desafiou Golias a lutar com ele.\n\n" +
                    "Assim que Golias veio em sua direção, Davi ergueu seu estilingue, colocou uma pedra e arremessou. Ela atingiu Golias na testa. O gigante caiu inconsciente. Imediatamente, Davi pegou a espada de Golias. Então, gritando triunfante, os Israelitas perseguiram os Filisteus fugitivos e venceram a batalha contra eles.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia015);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_001);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia015);
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
//ESCOLHEU HISTORIA 016 - Daniel e os leões
//*************************************************************
//MONTA A TELA DA HISTORIA

        if (num == 16) {

            foto.setImageResource(R.drawable.historia016);
            titulo.setText("Daniel e os leões");
            historia.setText("O Rei da Babilônia, conquistou Israel e levou os mais jovens e mais fortes como cativos. Ele ordenou para escolherem dentre os Israelitas os rapazes que fossem inteligentes e de boa aparência. Queria esses rapazes para serem treinados em certas habilidades. Entre os rapazes escolhidos estavam Daniel, Sadraque, Mesaque e Abednego. \n\n" +
                    "Estes escolhidos receberiam comida da mesa do Rei, mas Daniel pediu para não forçá-los a comer comida do Rei. Daniel disse: Faça um teste por dez dias. Iremos comer somente vegetais e água, e estaremos mais saudáveis do que os outros. \n\n" +
                    "O superintendente fez exatamente aquilo e dez dias depois foi como Daniel havia dito. Mais tarde, esses rapazes foram enviados para servir ao Rei.\n\n" +
                    "Daniel era um homem justo, honesto e excelente administrador, que amava a Deus mais do que todas as coisas. O rei Dario gostava muito de Daniel e admirava o seu trabalho.\n\n" +
                    "Porém, outros administradores não gostavam de Daniel e sentiam inveja dele. Eles queriam acusá-lo de algum crime, mas não encontravam nada que pudessem usar contra Daniel. Sabendo como Daniel era temente a Deus, resolveram usar isso para prejudicá-lo. Esses homens, então, fizeram Dario assinar um decreto no qual ninguém poderia pedir nada a Deus, pois o rei era mais importante. Quem desobedecesse ao decreto seria jogado na cova dos leões.\n\n" +
                    "O rei concordou com aquela lei e, alguns dias depois, os inimigos de Daniel encontraram-no orando a Deus e o denunciaram para o rei.\n\n" +
                    "Apesar de gostar muito de Daniel, o rei Dario teve de ordenar que jogassem o homem na cova junto com os leões. No dia seguinte, o rei queria saber se Daniel estava bem e, para a surpresa de todos, ele não havia sofrido nenhum ferimento. Deus havia enviado seu anjo para proteger Daniel contra os leões. Todos ficaram maravilhados, e Daniel foi tirado de lá.\n\n" +
                    "FIM.\n");

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia016);
            musicaFundo = MediaPlayer.create(getApplicationContext(), R.raw.musica_002);

            //BOTÃO PARA REINICIAR A LEITURA
            btReiniciar = findViewById(R.id.btReiniciar);
            btReiniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.historia016);
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