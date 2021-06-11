package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import java.util.Locale;

public class PerguntasActivity extends AppCompatActivity {

    private Button btFechar;
    private TextView pergunta;
    private Button resposta1;
    private Button resposta2;
    private Button resposta3;
    private TextView idStatus;
    private TextView idNivel;

    private int num;    // RECEBE O NUMERO DA PERGUNTA
    private int chave;  // RECEBE UM CODIGO QUE IDENTIFICA A PERGUNTA QUANDO ABERTO PELA TELA DA HISTORIA

    private int pontos;
    private int acertos;
    private int erros;

    private MediaPlayer somResposta; //Toca som de respota Correta ou Errada

    private Button btLeitor;        //BOTÃO CHAMA LEITOR DE PERGUNTA
    private TextToSpeech leitor;    //LEITOR DE PERGUNTA

    //VOLTAR COM BOTÃO VIRTUAL DO CELULAR - PARA A TELA INICIAL
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);

        idStatus    = findViewById(R.id.idStatus);
        idNivel     = findViewById(R.id.idNivel);
        pergunta    = findViewById(R.id.idPergunta);
        resposta1   = findViewById(R.id.idResposta1);
        resposta2   = findViewById(R.id.idResposta2);
        resposta3   = findViewById(R.id.idResposta3);
        btLeitor    = findViewById(R.id.btLeitor);

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA PERGUNTA + PONTOS
        Bundle dados = getIntent().getExtras();
        num     = dados.getInt("pergunta");
        chave   = dados.getInt("chave");
        pontos  = dados.getInt("pontos");
        acertos = dados.getInt("acertos");
        erros   = dados.getInt("erros");

        //EXIBIR NUMERAÇÃO DA PERGUNTA
        idStatus.setText("Pergunta " + num + " de 10");
        idNivel.setText("Fase - 01  ");

        if (num >= 11) {
            idStatus.setText("Pergunta " + num + " de 20");
            idNivel.setText("Fase - 02  ");
        }

        if (num >= 21) {
            idStatus.setText("Pergunta " + num + " de 30");
            idNivel.setText("Fase - 03  ");
        }

        //BOTÃO PARA VOLTAR PARA A TELA INICIAL
        btFechar = findViewById(R.id.btFechar);
        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity(intent);
            }
        });

        //CHAVE 111 PERGUNTA ABRIU PELA TELA DE HISTORIA 01
        if (chave == 111){
            idStatus.setText(" ");
            idNivel.setText(" ");

            //BOTÃO PARA VOLTAR PARA A TELA INICIAL
            btFechar = findViewById(R.id.btFechar);
            btFechar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), Historia01Activity.class);
                    intent.putExtra("historia", num); //PASSANDO VALOR PARA O BUNDLE
                    startActivity(intent);
                }
            });
        }

        //CHAVE 222 PERGUNTA ABRIU PELA TELA DE HISTORIA 02
        if (chave == 222){
            idStatus.setText(" ");
            idNivel.setText(" ");

            //BOTÃO PARA VOLTAR PARA A TELA INICIAL
            btFechar = findViewById(R.id.btFechar);
            btFechar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), Historia02Activity.class);
                    intent.putExtra("historia", num); //PASSANDO VALOR PARA O BUNDLE
                    startActivity(intent);
                }
            });
        }

        //LEITOR DE DE PERGUNTA
        leitor = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    Locale locale = new Locale("pt", "br");
                    leitor.setLanguage(locale);
                }
            }
        });

//*************************************************************
//MONTA A TELA DE PERGUNTAS
//*************************************************************

        if (num == 1) {

            pergunta.setText("Em quantos dias Deus fez a criação do mundo?");

            resposta1.setText("7 dias");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("30 dias");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("10 dias");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Em quantos dias Deus fez a criação do mundo? " +
                                    "7 dias, 30 dias, ou 10 dias.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });

        }

        if (num == 2) {

            pergunta.setText("Qual foi o nome do primeiro homem e da primeira mulher criados por Deus?");

            resposta1.setText("João e Maria");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Sansão e Dalila");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Adão e Eva");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Qual foi o nome do primeiro homem e da primeira mulher criados por Deus?"+
                            "João e Maria, Sansão e Dalila, ou Adão e Eva.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 3) {

            pergunta.setText("Oque Deus mandou noé construir?");

            resposta1.setText("Uma casa");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Uma arca");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3.setText("Uma muralha");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor = findViewById(R.id.btLeitor);
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Oque Deus mandou noé construir?"+
                            "Uma casa, uma arca, ou uma muralha.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 4) {

            pergunta.setText("Qual era o nome do filho de Abraão e Sara");

            resposta1.setText("Pedro");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Isaque");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3.setText("Paulo");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Qual era o nome do filho de Abraão e Sara?"+
                            "Pedro, Isaque, ou  Paulo.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 5) {

            pergunta.setText("Qual animal Deus enviou para o sacrifício de Abraão e Isaque?");

            resposta1.setText("Carneiro");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Jacaré");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Elefante");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Qual animal Deus enviou para o sacrifício de Abraão e Isaque?"+
                            "Carneiro, Jacaré, ou  Elefante.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 6) {

            pergunta.setText("Como era a tunica que José ganhou de seu pai Jacó?");

            resposta1.setText("Toda verde");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Colorida");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3.setText("Verde e amarela");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Como era a tunica que José ganhou de seu pai Jacó?"+
                            "Toda verde, Colorida, ou  Verde e amarela.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 7) {

            pergunta.setText("Quem foi vendido como escravo por seus irmãos?");

            resposta1.setText("José");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("João");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Pedro");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Quem foi vendido como escravo por seus irmãos?"+
                            "José, João, ou  Pedro.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 8) {

            pergunta.setText("Qual bebê foi colocado em um cestinho e jogado em um rio?");

            resposta1.setText("Jesus");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Moisés");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3.setText("Jacó");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Qual bebê foi colocado em um cestinho e jogado em um rio?"+
                            "Jesus, Moisés, ou  Jacó.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 9) {

            pergunta.setText("Qual o nome do líder que libertou Israel das mãos de Faraó?");

            resposta1.setText("Moisés");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Arão");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("José");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Qual o nome do líder que libertou Israel das mãos de Faraó?"+
                            "Moisés, Arão, ou  José.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 10) {

            pergunta.setText("Como o povo de Israel conseguiu sair do Egito?");

            resposta1.setText("Deus abriu o mar vermelho");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("De barco");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Nadando");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Como o povo de Israel conseguiu sair do Egito?"+
                            "Deus abriu o mar vermelho, De barco, ou  Nadando.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 11) {

            pergunta.setText("Qual instrumento Josué usou para derrubar as muralhas de Jericó?");

            resposta1.setText("Bateria");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Trombeta");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3.setText("Flauta");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Qual instrumento Josué usou para derrubar as muralhas de Jericó? " +
                            "Bateria, Trombeta, ou Flauta.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 12) {

            pergunta.setText("Quem é considerado o homem mais forte da Bíblia?");

            resposta1.setText("Pedro");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Faraó");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Sansão");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Quem é considerado o homem mais forte da Bíblia?"+
                            "Pedro, Faraó, ou  Sansão.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 13) {

            pergunta.setText("Qual o nome da rainha escolhida por Deus para salvar os Judeus?");
            resposta1.setText("Elizabete");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Isabel");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Ester");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Qual o nome da rainha escolhida por Deus para salvar os Judeus? " +
                            "Elizabete, Isabel, ou Ester.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }



        if (num == 14) {

            pergunta.setText("Qual o nome do sacerdote de quem Samuel era ajudante?");

            resposta1.setText("Jonas");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Paulo");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Eli");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura = "Qual o nome do sacerdote de quem Samuel era ajudante? " +
                            "Jonas, Paulo, ou Eli.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 15) {

            pergunta.setText("Qual o nome do gigante que Davi derrubou?");

            resposta1.setText("Golias");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Barrabás");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Anaque");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Qual o nome do gigante que Davi derrubou? " +
                            "Golias, Barrabás, ou Anaque.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 16) {

            pergunta.setText("Quem foi jogado na cova com os leões?");

            resposta1.setText("Daniel");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("José");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Paulo");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Quem foi jogado na cova com os leões? " +
                            "Daniel, José, ou Paulo.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 17) {

            pergunta.setText("Quando Jesus nasceu, onde Ele foi colocado?");

            resposta1.setText("Manjedoura");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Cama");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Trono");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Quando Jesus nasceu, onde Ele foi colocado? " +
                            "manjedoura, cama, ou trono.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 18) {

            pergunta.setText("Quem batizou Jesus?");

            resposta1.setText("Pedro");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("João");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3.setText("Tiago");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Quem batizou Jesus? " +
                            "Pedro, João, ou Tiago.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 19) {

            pergunta.setText("Alguns homens levaram seu amigo para ser curado por Jesus, por que ele não podia?");

            resposta1.setText("Falar");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Enxergar");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Andar");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Alguns homens levaram seu amigo para ser curado por Jesus, por que ele não podia? " +
                            "Falar, Enxergar, ou Andar.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 20) {

            pergunta.setText("Qual era o nome do pai da menina que Jesus acordou?");

            resposta1.setText("Jairo");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Jeremias");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("João batista");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Qual era o nome do pai da menina que Jesus acordou? " +
                            "Jairo, Jeremias, ou João batista.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

//ADICIONAR AS PERGUNTAS CONFORME A HISTORIA

        if (num == 21) {
            pergunta.setText("O que o menino ofereceu para Jesus alimentar a multidão?");
            resposta1.setText("Frutas");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Pão e peixe");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });
            resposta3.setText("Arroz e feijão");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="O que o menino ofereceu para Jesus alimentar a multidão?" +
                            "Frutas, Pão e peixe, ou Arroz e feijão.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }
        if (num == 22) {
            pergunta.setText("Quando o filho mais novo voltou para casa, o que o seu pai lhe deu?");
            resposta1.setText("Brinquedos e presentes");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Uma bicicleta");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
            resposta3.setText("Roupas nova e um anel");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Quando o filho mais novo voltou para casa, o que o seu pai lhe deu?" +
                            "Brinquedos e presentes, Uma bicicleta, ou Roupas nova e um anel.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }
        if (num == 23) {
            pergunta.setText("Jesus disse para seus discípulos, lembrarem Dele ao comerem qual alimento?");
            resposta1.setText("Salada");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Pão");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });
            resposta3.setText("Carne");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            //BOTÃO PARA LEITURA DA PERGUNTA
            btLeitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btLeitor.setBackgroundResource(R.drawable.musica_on);
                    String textoLeitura ="Jesus disse para seus discípulos, lembrarem Dele ao comerem qual alimento?" +
                            "Salada, Pão, ou Carne.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }
        if (num == 24) {
            pergunta.setText("A crucificação");
            resposta1.setText("Resposta certa");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }
        if (num == 25) {
            pergunta.setText("A ressureição");
            resposta1.setText("Resposta certa");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }
        if (num == 26) {
            pergunta.setText("Nas nuvens");
            resposta1.setText("Resposta certa");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }
        if (num == 27) {
            pergunta.setText("Nem prata nem ouro");
            resposta1.setText("Resposta certa");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }
        if (num == 28) {
            pergunta.setText("Inimigo, agora amigo");
            resposta1.setText("Resposta certa");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }
        if (num == 29) {
            pergunta.setText("Viajando por Jesus");
            resposta1.setText("Resposta certa");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }
        if (num == 30) {
            pergunta.setText("Uma promessa eterna");
            resposta1.setText("Resposta certa");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }
    }

    public void onPause(){
        if(leitor !=null){
            leitor.stop();
            leitor.shutdown();
        }

        super.onPause();
    }

    private AlertDialog alerta;

    //ALERTA DE RESOSTA CORRETA
    private void respostaCorreta() {

        somResposta = MediaPlayer.create(getApplicationContext(), R.raw.som_acertou);
        if (!somResposta.isPlaying()) {
            somResposta.start();
        }
        acertos = acertos + 1;
        pontos = pontos + 1;

        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = li.inflate(R.layout.alerta, null);

        //definimos para o botão do layout um clickListener
        view.findViewById(R.id.btFechar).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //finish();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("");
        builder.setCancelable(false);
        builder.setView(view);
        alerta = builder.create();
        alerta.show();

        //FECHAR ALERTA
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // verificar se a caixa de diálogo está visível
                if (alerta.isShowing()) {
                    // fecha a caixa de diálogo
                    alerta.dismiss();
                }

                if (chave == 111 || chave == 222) {
                    //CHAVE 111 OU 222 PERGUNTA VEIO DA HISTORIA NÃO VAI PARA PROXIMA PERGUNTA
                }else {
                    proximaPergunta();//ABRIR PROXIMA PERGUNTA
                }
            }
        };

        alerta.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });

        handler.postDelayed(runnable, 800);
    }

    //ALERTA DE RESPOSTA ERRADA
    private void respostaErrada() {
        somResposta = MediaPlayer.create(getApplicationContext(), R.raw.som_errou);
        if (!somResposta.isPlaying()) {
            somResposta.start();
        }

        erros = erros +1;
        pontos = pontos - 1;

        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = li.inflate(R.layout.alerta02, null);

        //definimos para o botão do layout um clickListener
        view.findViewById(R.id.btFechar).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //finish();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("");
        builder.setCancelable(false);
        builder.setView(view);
        alerta = builder.create();
        alerta.show();

        //FECHAR ALERTA
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // verificar se a caixa de diálogo está visível
                if (alerta.isShowing()) {
                    // fecha a caixa de diálogo
                    alerta.dismiss();
                }
            }
        };

        alerta.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });

        handler.postDelayed(runnable, 800);
    }

    //ABRIR PROXIMA PERGUNTA
    private void proximaPergunta(){

        if (num == 10|| num == 20 || num == 30) {
            finalJogo();
            alerta.dismiss();
        }else {
            finish();
            Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
            Bundle parametros = new Bundle();

            parametros.putInt("pergunta", num + 1); //Passa o numero da proxima pergunta
            parametros.putInt("pontos", pontos);
            parametros.putInt("acertos", acertos);
            parametros.putInt("erros", erros);

            intent.putExtras(parametros);
            startActivity(intent);

            alerta.dismiss();
        }
    }

    //ABRIR TELA FINAL DO JOGO
    private void finalJogo(){
        finish();

        Intent intent = new Intent(getApplicationContext(), FinalJogoActivity.class);
        Bundle parametros = new Bundle();

        parametros.putInt("pergunta", num);
        parametros.putInt("pontos", pontos);
        parametros.putInt("acertos", acertos);
        parametros.putInt("erros", erros);

        intent.putExtras(parametros);
        startActivity(intent);

    }

}


