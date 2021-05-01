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
    private Button btProxima;
    private TextView pergunta;
    private Button resposta1;
    private Button resposta2;
    private Button resposta3;
    private TextView idStatus;
    private TextView idNivel;

    private int num;

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
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);

        idStatus = findViewById(R.id.idStatus);
        idNivel = findViewById(R.id.idNivel);

        pergunta = findViewById(R.id.idPergunta);
        resposta1 = findViewById(R.id.idResposta1);
        resposta2 = findViewById(R.id.idResposta2);
        resposta3 = findViewById(R.id.idResposta3);
        btLeitor = findViewById(R.id.btLeitor);


        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA PERGUNTA + PONTOS
        Bundle dados = getIntent().getExtras();
        num = dados.getInt("pergunta");

        pontos = dados.getInt("pontos");
        acertos = dados.getInt("acertos");
        erros = dados.getInt("erros");

        //EXIBIR NUMERAÇÃO DA PERGUNTA
        idStatus.setText("Pergunta " + num + " de 10");
        idNivel.setText("Fase - 01  ");

        if (num >=11) {
            idStatus.setText("Pergunta " + num + " de 20");
            idNivel.setText("Fase - 02  ");
        }

        //BOTÃO PARA VOLTAR PARA A TELA INICIAL
        btFechar = findViewById(R.id.btFechar);
        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
        btProxima = findViewById(R.id.btProxima);
        btProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (num == 10|| num == 20) {
                    finalJogo();
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

                }
            }
        });

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

            pergunta.setText("Aonde Noé colocou os animais?");

            resposta1.setText("Numa casa");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Numa arca");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3.setText("Em uma muralha");
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
                    String textoLeitura = "Aonde Noé colocou os animais?"+
                            "Numa casa, Numa arca, ou Em uma muralha.";
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

        if (num == 7) {

            pergunta.setText("Qual o nome do gigante derrotado por Davi?");

            resposta1.setText("Barrabás");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Golias");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
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
                    String textoLeitura = "Qual o nome do gigante derrotado por Davi?"+
                            "Barrabás, Golias, ou  Anaque.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 8) {

            pergunta.setText("Quem é considerado o homem mais forte da Bíblia?");

            resposta1.setText("Sansão");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Pedro");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Faraó");
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
                    String textoLeitura = "Quem é considerado o homem mais forte da Bíblia?"+
                            "Sansão, Pedro, ou  Faraó.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 9) {

            pergunta.setText("Quando Sansão perdeu as suas forças?");

            resposta1.setText("Cortaram o seu cabelo");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Quando foi acorrentado");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Quando usou um chapéu");
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
                    String textoLeitura = "Quando Sansão perdeu as suas forças?"+
                            "Cortaram o seu cabelo, Quando foi acorrentado, ou  Quando usou um chapéu.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 10) {

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

        if (num == 11) {

            pergunta.setText("Qual o profeta que foi engolido por um grande peixe?");

            resposta1.setText("João");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Isaías");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Jonas");
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
                    String textoLeitura = "Qual o profeta que foi engolido por um grande peixe?"+
                            "João, Isaías, ou  Jonas.";
                    leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        if (num == 12) {

            pergunta.setText("Quantos animais foram colocados na arca de Noé?");

            resposta1.setText("Um casal de cada espécie");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Só animais machos");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Só os animais filhote");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

        if (num == 13) {

            pergunta.setText("Que instrumento Josué usou para derrubar as muralhas de Jericó?");

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
        }

        if (num == 14) {

            pergunta.setText("Depois do dilúvio, qual o sinal que Deus criou?");

            resposta1.setText("Uma tempestade");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Fez descer fogo do céu");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Um Arco-Íris");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });
        }

        if (num == 15) {

            pergunta.setText("Quem foi jogado na cova com os leões");

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
        }

        if (num == 16) {

            pergunta.setText("Qual animal tentou Eva no Jardim do Éden?");

            resposta1.setText("Leão");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Serpente");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3.setText("Lagarto");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

        if (num == 17) {

            pergunta.setText("Como chamava o jardim onde morou Adão e Eva?");

            resposta1.setText("Jardim do éden");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("Jardim Magnólia");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("Jardim Guanabara");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

        if (num == 18) {

            pergunta.setText("Como era o nome do esposo de Maria, mãe de Jesus? ");

            resposta1.setText("Tiago");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Simão");
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
                    respostaCorreta();
                }
            });
        }

        if (num == 19) {

            pergunta.setText("Quando Jesus nasceu, onde Ele foi colocado?");

            resposta1.setText("manjedoura");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2.setText("cama");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3.setText("trono");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

        if (num == 20) {

            pergunta.setText("Qual era o nome da mãe de Jesus?");

            resposta1.setText("Ana");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2.setText("Maria");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3.setText("Rebeca");
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
                //proximaPergunta();
                finish();
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
                proximaPergunta();//ABRIR PROXIMA PERGUNTA
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

    //ALERTA DE RESOSTA ERRADA
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
                alerta.dismiss();
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

        if (num == 10|| num == 20) {
            finalJogo();
            alerta.dismiss();
        }else {

            Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
            Bundle parametros = new Bundle();

            parametros.putInt("pergunta", num + 1); //Passa o numero da proxima pergunta
            parametros.putInt("pontos", pontos);
            parametros.putInt("acertos", acertos);
            parametros.putInt("erros", erros);

            intent.putExtras(parametros);
            startActivity(intent);

            chamaLeitor();

            alerta.dismiss();
        }
    }

    //ABRIR TELA FINAL DO JOGO
    private void finalJogo(){
        finish();

        Intent intent = new Intent(getApplicationContext(), FinalJogoActivity.class);
        Bundle parametros = new Bundle();

        parametros.putInt("pergunta", num +1); //Passa o numero da proxima pergunta
        parametros.putInt("pontos", pontos);
        parametros.putInt("acertos", acertos);
        parametros.putInt("erros", erros);

        intent.putExtras(parametros);
        startActivity(intent);

    }

    private void chamaLeitor(){

            String textoLeitura = "Em quantos dias Deus fez a criação do mundo? " +
                    "7 dias, 30 dias, ou 10 dias.";
            leitor.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
        /*

        if (num == 2) {

            btLeitor.setBackgroundResource(R.drawable.musica_on);
            String textoPergunta ="Qual foi o nome do primeiro homem e da primeira mulher criados por Deus?"+
                    "João e Maria, Sansão e Dalila, ou Adão e Eva.";
            leitor.speak(textoPergunta, TextToSpeech.QUEUE_FLUSH, null);
        }

        if (num == 3) {

            btLeitor.setBackgroundResource(R.drawable.musica_on);
            String textoPergunta = "Aonde Noé colocou os animais?"+
                    "Numa casa, Numa arca, ou Em uma muralha.";
            leitor.speak(textoPergunta, TextToSpeech.QUEUE_FLUSH, null);
        }

         */

    }
}


