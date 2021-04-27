package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
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
    private TextView idResultado;

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

        idResultado = findViewById(R.id.idResultado);

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA PERGUNTA + PONTOS
        Bundle dados = getIntent().getExtras();
        num = dados.getInt("pergunta");

        pontos = dados.getInt("pontos");
        acertos = dados.getInt("acertos");
        erros = dados.getInt("erros");

        idResultado.setText(pontos + "  Pontos" );

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

                if (num == 16) {
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

//*************************************************************
//PERGUNTA 001 - A Criação do Mundo
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 1) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("01 - Em quantos dias Deus fez a criação do mundo?");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("7 dias");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("30 dias");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("10 dias");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

        }

//*************************************************************
//PERGUNTA 002 - O Pecado de Adão e Eva
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 2) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("02 - Qual foi o nome do primeiro homem e da primeira mulher criados por Deus?");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("João e Maria");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Sansão e Dalila");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Adão e Eva");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });
        }

//*************************************************************
//PERGUNTA 003 - A Arca e o Diluvio
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 3) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("03 - A Arca e o Diluvio");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 004 - A grande promessa
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 4) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("04 - Qual era o nome do filho de Abraão e Sara");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 005 - A prova de Abraão e Isaque
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 5) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("05 - Qual animal Deus enviou para o sacrifio de Abraão e Isaque");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Jacaré");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Carneiro");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Elefante");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 006 - O sonhador José
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 6) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("06 - O sonhador José");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 007 - Os sonhos se realizam
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 7) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("07 - Os sonhos se realizam");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 008 - Moisés, um bebê especial
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 8) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("08 - Moisés, um bebê especial");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 009 - Castigos para faraó
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 9) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("09 - Castigos para faraó");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 010 - Deus abre um caminho
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 10) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("10 - Deus abre um caminho");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 011 - A queda do muro
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 11) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("11 - A queda do muro");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 012 - Um herói cabeludo
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 12) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("12 - Um herói cabeludo");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 013 - Rainha escolhida
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 13) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("13 - Rainha escolhida");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 014 - Deus chama Samuel
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 14) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("14 - Deus chama Samuel");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 015 - Davi e Golias
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 15) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("15 - Qual era o nome do gigante derrota por Davi?");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });
        }

//*************************************************************
//PERGUNTA 016 - Daniel e os leões
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 16) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("16 - Daniel e os leões");

            resposta1 = findViewById(R.id.idResposta1);
            resposta1.setText("Resposta correta");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.idResposta2);
            resposta2.setText("Resposta errada");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.idResposta3);
            resposta3.setText("Resposta errada");
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
        idResultado.setText(pontos + "  Pontos" );

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
    }

    //ALERTA DE RESOSTA ERRADA
    private void respostaErrada() {
        somResposta = MediaPlayer.create(getApplicationContext(), R.raw.som_errou);
        if (!somResposta.isPlaying()) {
            somResposta.start();
        }

        erros = erros +1;

        pontos = pontos - 1;
        idResultado.setText(pontos + "  Pontos" );

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
    }

    //ABRIR PROXIMA PERGUNTA
    private void proximaPergunta(){
        Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
        Bundle parametros = new Bundle();

        num = num +1; //Passando para proxima pergunta

        if (num <= 16) {

        parametros.putInt("pergunta", num);
        parametros.putInt("pontos", pontos);
        parametros.putInt("acertos", acertos);
        parametros.putInt("erros", erros);

        intent.putExtras(parametros);
        startActivity(intent);
        alerta.dismiss();
        }

        if (num == 17) {
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


