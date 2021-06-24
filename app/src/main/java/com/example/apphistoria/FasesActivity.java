package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FasesActivity extends AppCompatActivity {
    private Button btFase01;
    private Button btFase02;
    private Button btFase03;
    private Button btFase04;
    private Button btFase05;
    private Button btFase06;
    private Button btFechar;
    private Button btZerar;
    private int opc = 1;

    private TextView idFase1;
    private TextView idFase2;
    private TextView idFase3;
    private TextView idFase4;
    private TextView idFase5;
    private TextView idFase6;

    int pf1;
    int pf2;
    int pf3;
    int pf4;
    int pf5;
    int pf6;


    private static final String PREF_NOME = "preferencias";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dadospref;

    //VOLTAR COM BOTÃO VIRTUAL DO CELULAR
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fases);

        btFase01 = findViewById(R.id.btFase01);
        btFase02 = findViewById(R.id.btFase02);
        btFase03 = findViewById(R.id.btFase03);
        btFase04 = findViewById(R.id.btFase04);
        btFase05 = findViewById(R.id.btFase05);
        btFase06 = findViewById(R.id.btFase06);
        btZerar  = findViewById(R.id.btZerar);

        idFase1 = findViewById(R.id.idFase1);
        idFase2 = findViewById(R.id.idFase2);
        idFase3 = findViewById(R.id.idFase3);
        idFase4 = findViewById(R.id.idFase4);
        idFase5 = findViewById(R.id.idFase5);
        idFase6 = findViewById(R.id.idFase6);

        //BOTÃO PARA FECHAR
        btFechar = findViewById(R.id.btFechar);
        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //EXIBINDO DADOS DO SHARED PREFERENCES
        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        //BOTÃO PERGUNTAS FASE 01
        pf1 = sharedPreferences.getInt("pontosf1",0);
        idFase1.setText(pf1 + " pontos");

        if(pf1 == 0){
            btFase01.setBackgroundResource(R.drawable.fase_fundo_0_estrelas);
        }else if (pf1 > 0 && pf1 <= 3) {
            btFase01.setBackgroundResource(R.drawable.fase_fundo_1_estrelas);
        }else if (pf1 >= 4 && pf1 <= 6) {
            btFase01.setBackgroundResource(R.drawable.fase_fundo_2_estrelas);
        }else if (pf1 >= 7) {
            btFase01.setBackgroundResource(R.drawable.fase_fundo_3_estrelas);
        }

        btFase01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                intent.putExtra("pergunta", 1); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        //BOTÃO PERGUNTAS FASE 02
        pf2 = sharedPreferences.getInt("pontosf2",0);
        idFase2.setText(pf2 + " pontos");

        if(pf1 < 5) {
            btFase02.setBackgroundResource(R.drawable.fase_fundo_fechado);
        }else if(pf2 <= 0) {
            btFase02.setBackgroundResource(R.drawable.fase_fundo_0_estrelas);
        } else if (pf2 <= 3) {
            btFase02.setBackgroundResource(R.drawable.fase_fundo_1_estrelas);
        }else if (pf2 >= 4 && pf2 <= 6) {
            btFase02.setBackgroundResource(R.drawable.fase_fundo_2_estrelas);
        }else if (pf2 >= 7) {
            btFase02.setBackgroundResource(R.drawable.fase_fundo_3_estrelas);
        }

        btFase02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pf1 > 5){
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 11); //PASSANDO VALOR PARA O BUNDLE
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Pontuação não atiginda, na fase anterior", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //BOTÃO PERGUNTAS FASE 03
        pf3 = sharedPreferences.getInt("pontosf3",0);
        idFase3.setText(pf3 + " pontos");

        if(pf2 < 5) {
            btFase03.setBackgroundResource(R.drawable.fase_fundo_fechado);
        }else if(pf3 <= 0){
            btFase03.setBackgroundResource(R.drawable.fase_fundo_0_estrelas);
        } else if (pf3 <= 3) {
            btFase03.setBackgroundResource(R.drawable.fase_fundo_1_estrelas);
        }else if (pf3 >= 4 && pf3 <= 6) {
            btFase03.setBackgroundResource(R.drawable.fase_fundo_2_estrelas);
        }else if (pf3 >= 7) {
            btFase03.setBackgroundResource(R.drawable.fase_fundo_3_estrelas);
        }

        btFase03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pf2 > 5) {
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 21); //PASSANDO VALOR PARA O BUNDLE
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Pontuação não atiginda, na fase anterior", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //BOTÃO PERGUNTAS FASE 04
        pf4 = sharedPreferences.getInt("pontosf4",0);
        idFase4.setText(pf4 + " pontos");

        if(pf3 < 5) {
            btFase04.setBackgroundResource(R.drawable.fase_fundo_fechado);
        }else if(pf4 <= 0){
            btFase04.setBackgroundResource(R.drawable.fase_fundo_0_estrelas);
        } else if (pf4 <= 3) {
            btFase04.setBackgroundResource(R.drawable.fase_fundo_1_estrelas);
        }else if (pf4 >= 4 && pf4 <= 6) {
            btFase04.setBackgroundResource(R.drawable.fase_fundo_2_estrelas);
        }else if (pf4 >= 7) {
            btFase04.setBackgroundResource(R.drawable.fase_fundo_3_estrelas);
        }

        btFase04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pf3 > 5) {
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 31); //PASSANDO VALOR PARA O BUNDLE
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Pontuação não atiginda, na fase anterior", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //BOTÃO PERGUNTAS FASE 05
        pf5 = sharedPreferences.getInt("pontosf5",0);
        idFase5.setText(pf5 + " pontos");

        if(pf4 < 5) {
            btFase05.setBackgroundResource(R.drawable.fase_fundo_fechado);
        }else if(pf5 <= 0){
            btFase05.setBackgroundResource(R.drawable.fase_fundo_0_estrelas);
        } else if (pf5 <= 3) {
            btFase05.setBackgroundResource(R.drawable.fase_fundo_1_estrelas);
        }else if (pf5 >= 4 && pf5 <= 6) {
            btFase05.setBackgroundResource(R.drawable.fase_fundo_2_estrelas);
        }else if (pf5 >= 7) {
            btFase05.setBackgroundResource(R.drawable.fase_fundo_3_estrelas);
        }

        btFase05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pf4 > 5) {
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 41); //PASSANDO VALOR PARA O BUNDLE
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Pontuação não atiginda, na fase anterior", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //BOTÃO PERGUNTAS FASE 06
        pf6 = sharedPreferences.getInt("pontosf6",0);
        idFase6.setText(pf6 + " pontos");

        if(pf5 < 5) {
            btFase06.setBackgroundResource(R.drawable.fase_fundo_fechado);
        }else if(pf6 <= 0){
            btFase06.setBackgroundResource(R.drawable.fase_fundo_0_estrelas);
        } else if (pf6 <= 3) {
            btFase06.setBackgroundResource(R.drawable.fase_fundo_1_estrelas);
        }else if (pf6 >= 4 && pf6 <= 6) {
            btFase06.setBackgroundResource(R.drawable.fase_fundo_2_estrelas);
        }else if (pf6 >= 7) {
            btFase06.setBackgroundResource(R.drawable.fase_fundo_3_estrelas);
        }

        btFase06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pf5 > 5) {
                    Intent intent = new Intent(getApplicationContext(), PerguntasActivity.class);
                    intent.putExtra("pergunta", 51); //PASSANDO VALOR PARA O BUNDLE
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Pontuação não atiginda, na fase anterior", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //EXIBINDO PONTUAÇÃO TOTAL
        btZerar.setText("Pontuação Total: " + (pf1 + pf2 + pf3 + pf4 + pf5 + pf6));

        //LIMPAR DADOS DO SHARED PREFERENCES
        btZerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opc > 5) {
                    opc = 1;
                }

                if (opc == 5) {
                    dadospref = sharedPreferences.edit();
                    dadospref.clear();
                    dadospref.apply();
                    Toast.makeText(getApplicationContext(), "Pontuação zerada", Toast.LENGTH_SHORT).show();
                }
                opc++;
            }
        });
    }
}


