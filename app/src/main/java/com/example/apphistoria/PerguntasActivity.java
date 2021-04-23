package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class PerguntasActivity extends AppCompatActivity {

    private Button btFechar;
    private Button btProxima;
    private TextView pergunta;
    private Button resposta1;
    private Button resposta2;
    private Button resposta3;

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

        //BUNDLE  RECEBENDO VALOR DE ESCOLHA DA PERGUNTA
        Bundle dados = getIntent().getExtras();
        int num = dados.getInt("pergunta");

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

//*************************************************************
//PERGUNTA 001 - A Criação do Mundo
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 1) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Em quantos dias Deus fez a criação do mundo?");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("7 dias");
            resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    respostaCorreta();
                }
            });

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("365 dias");
            resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //respostaErrada();
                }
            });

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("10 dias");
            resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //respostaErrada();
                }
            });

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 2);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 002 - O Pecado de Adão e Eva
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 2) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("O Pecado de Adão e Eva");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 3);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 003 - A Arca e o Diluvio
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 3) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("A Arca e o Diluvio");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 4);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 004 - A grande promessa
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 4) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("A grande promessa");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 5);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 005 - A prova de Abraão e Isaque
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 5) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("A prova de Abraão e Isaque");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 6);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 006 - O sonhador José
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 6) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("O sonhador José");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 7);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 007 - Os sonhos se realizam
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 7) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Os sonhos se realizam");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 8);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 008 - Moisés, um bebê especial
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 8) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Moisés, um bebê especial");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 9);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 009 - Castigos para faraó
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 9) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Castigos para faraó");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 10);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 010 - Deus abre um caminho
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 10) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Deus abre um caminho");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 11);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 011 - A queda do muro
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 11) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("A queda do muro");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 12);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 012 - Um herói cabeludo
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 12) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Um herói cabeludo");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 13);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 013 - Rainha escolhida
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 13) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Rainha escolhida");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 14);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 014 - Deus chama Samuel
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 14) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Deus chama Samuel");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 15);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 015 - Davi e Golias
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 15) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Davi e Golias");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");

            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 16);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }

//*************************************************************
//PERGUNTA 016 - Daniel e os leões
//*************************************************************
//MONTA A TELA DE PERGUNTAS

        if (num == 16) {

            pergunta = findViewById(R.id.idPergunta);
            pergunta.setText("Daniel e os leões");

            resposta1 = findViewById(R.id.resposta1);
            resposta1.setText("Resposta 1");

            resposta2 = findViewById(R.id.resposta2);
            resposta2.setText("Resposta 2");

            resposta3 = findViewById(R.id.resposta3);
            resposta3.setText("Resposta 3");


            //BOTÃO PARA AVANÇAR PARA PROXIMA PERGUNTA
            btProxima = findViewById(R.id.btProxima);
            btProxima.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //intent.putExtra("pergunta", 16);//Passa o numero da proxima pergunta
                    startActivity(intent);
                }
            });
        }
    }

    private AlertDialog alerta;

    private void respostaCorreta() {
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = li.inflate(R.layout.alerta, null);
        //definimos para o botão do layout um clickListener
        view.findViewById(R.id.btFechar).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                alerta.dismiss();
            }
        });

        view.findViewById(R.id.btProxima).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 2);//Passa o numero da proxima pergunta
                startActivity(intent);
                alerta.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("");
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }
}

