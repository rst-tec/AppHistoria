package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

public class PerguntasActivity extends AppCompatActivity {

    private Button btFechar;
    private Button btProxima;
    private TextView pergunta;
    private Button resposta1;
    private Button resposta2;
    private Button resposta3;
    private TextView idStatus;

    private int num;

    private int pontos;
    private int acertos;
    private int erros;

    private MediaPlayer somResposta; //Toca som de respota Correta ou Errada

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

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA PERGUNTA + PONTOS
        Bundle dados = getIntent().getExtras();
        num = dados.getInt("pergunta");

        pontos = dados.getInt("pontos");
        acertos = dados.getInt("acertos");
        erros = dados.getInt("erros");

        //EXIBIR NUMERAÇÃO DA PERGUNTA
        idStatus.setText("Pergunta " + num + " de 10");

        if (num >=11) {
            idStatus.setText("Pergunta " + num + " de 20");
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

                    parametros.putInt("pergunta", num + 1); ////Passa o numero da proxima pergunta
                    parametros.putInt("pontos", pontos);
                    parametros.putInt("acertos", acertos);
                    parametros.putInt("erros", erros);

                    intent.putExtras(parametros);
                    startActivity(intent);
                }
            }
        });

        pergunta = findViewById(R.id.idPergunta);
        resposta1 = findViewById(R.id.idResposta1);
        resposta2 = findViewById(R.id.idResposta2);
        resposta3 = findViewById(R.id.idResposta3);

//*************************************************************
//MONTA A TELA DE PERGUNTAS
//*************************************************************

        if (num == 1) {

            pergunta.setText("1 - Em quantos dias Deus fez a criação do mundo?");

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
        }

        if (num == 2) {

            pergunta.setText("2 - Qual foi o nome do primeiro homem e da primeira mulher criados por Deus?");

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
        }

        if (num == 3) {

            pergunta.setText("3 - Aonde Noé colocou os animais?");

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
        }

        if (num == 4) {

            pergunta.setText("4 - Qual era o nome do filho de Abraão e Sara");

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
        }

        if (num == 5) {

            pergunta.setText("5 - Qual animal Deus enviou para o sacrifio de Abraão e Isaque");

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
        }

        if (num == 6) {

            pergunta.setText("6 - Quem foi vendido como escravo por seus irmãos?");

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
        }

        if (num == 7) {

            pergunta.setText("7 - Qual o nome do gigante derrotado por Davi?");

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
        }

        if (num == 8) {

            pergunta.setText("8 - Quem é considerado o homem mais forte da Bíblia?");

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
        }

        if (num == 9) {

            pergunta.setText("9 - Quando Sansão perdeu as suas forças?");

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
        }

        if (num == 10) {

            pergunta.setText("10 - Qual bebê foi colocado em um cestinho e jogado em um rio?");

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
        }

        if (num == 11) {

            pergunta.setText("11 - Qual o profeta que foi engolido por um grande peixe?");

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
        }

        if (num == 12) {

            pergunta.setText("12 - Quantos animais foram colocados na arca de Noé?");

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

            pergunta.setText("13 - Que instrumento Josué usou para derrubar as muralhas de Jericó?");

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

            pergunta.setText("14 - Depois do dilúvio, qual o sinal que Deus criou?");

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

            pergunta.setText("15 - Quem foi jogado na cova com os leões");

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

            pergunta.setText("16 - Qual animal tentou Eva no Jardim do Éden?");

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

            pergunta.setText("17 - Qual animal tentou Eva no Jardim do Éden?");

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

        if (num == 18) {

            pergunta.setText("18  - Qual animal tentou Eva no Jardim do Éden?");

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

        if (num == 19) {

            pergunta.setText("19 - Qual animal tentou Eva no Jardim do Éden?");

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

        if (num == 20) {

            pergunta.setText("20 - Qual animal tentou Eva no Jardim do Éden?");

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
        //idResultado.setText(pontos + "  Pontos" );

        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = li.inflate(R.layout.alerta, null);

        //definimos para o botão do layout um clickListener
        view.findViewById(R.id.btFechar).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                proximaPergunta();
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

        handler.postDelayed(runnable, 1000);
    }

    //ALERTA DE RESOSTA ERRADA
    private void respostaErrada() {
        somResposta = MediaPlayer.create(getApplicationContext(), R.raw.som_errou);
        if (!somResposta.isPlaying()) {
            somResposta.start();
        }

        erros = erros +1;

        pontos = pontos - 1;
        //idResultado.setText(pontos + "  Pontos" );

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

        handler.postDelayed(runnable, 1000);
    }

    //ABRIR PROXIMA PERGUNTA
    private void proximaPergunta(){
        Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
        Bundle parametros = new Bundle();

        num = num +1; //Passando para proxima pergunta

        parametros.putInt("pergunta", num);
        parametros.putInt("pontos", pontos);
        parametros.putInt("acertos", acertos);
        parametros.putInt("erros", erros);

        intent.putExtras(parametros);
        startActivity(intent);
        alerta.dismiss();

        if (num == 11 || num == 21) {
            finalJogo();
            alerta.dismiss();
        }
    }

    //ABRIR TELA FINAL DO JOGO
    private void finalJogo(){
        finish();

        Intent intent = new Intent(getApplicationContext(), FinalJogoActivity.class);
        Bundle parametros = new Bundle();

        parametros.putInt("pontos", pontos);
        parametros.putInt("acertos", acertos);
        parametros.putInt("erros", erros);

        intent.putExtras(parametros);
        startActivity(intent);

        somResposta = MediaPlayer.create(getApplicationContext(), R.raw.som_final_jogo);
        if (!somResposta.isPlaying()) {
            somResposta.start();
        }
    }
}


