package com.example.apphistoria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;
import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        versiculo();

        //getSupportActionBar().hide(); //REMOVER ACTIONBAR
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), Lista01Activity.class));
                finish();
            }
        },5000);
    }

    private void versiculo(){
        TextView texto = findViewById(R.id.idVersiculo);
        int V = new Random().nextInt(7);
        if(V == 0){
            texto.setText("Os filhos são um presente do SENHOR; eles são uma verdadeira bênção.\n\n" +
                    "SALMOS – 127:3");
        }else if (V == 1){
            texto.setText("Pais, não tratem os seus filhos de um jeito que faça com que eles fiquem irritados. Pelo contrário, vocês devem criá-los com a disciplina e os ensinamentos cristãos.\n\n" +
                    "EFÉSIOS – 6:4");
        }else if (V == 2){
            texto.setText("Eduque a criança no caminho em que deve andar, e até o fim da vida não se desviará dele.\n\n" +
                    "PROVÉRBIOS – 22:6");
        }else if (V == 3){
            texto.setText("É bom corrigir e disciplinar a criança. Quando todas as suas vontades são feitas, ela acaba fazendo seus pais passarem vergonha.\n\n" +
                    "PROVÉRBIOS – 29:15");
        }else if (V == 4){
            texto.setText("Quem não castiga o filho não o ama. Quem ama o filho castiga-o enquanto é tempo.\n\n" +
                    "PROVÉRBIOS – 13:24");
        }else if (V == 5){
            texto.setText("Meu filho, escute o que o seu pai ensina e preste atenção no que a sua mãe diz.\n\n" +
                    "PROVÉRBIOS – 1:8");
        }else if (V == 6){
            texto.setText("Escute o seu pai, pois você lhe deve a vida; e não despreze a sua mãe quando ela envelhecer.\n\n" +
                    "PROVÉRBIOS – 23:22");
        }else if (V == 7) {
            texto.setText("Filhos, o dever cristão de vocês é obedecer sempre ao seu pai e à sua mãe porque Deus gosta disso.\n\n" +
                    "COLOSSENSES – 3:20");
        }else if (V == 8){
            texto.setText("Pais, não irritem os seus filhos, para que eles não fiquem desanimados.\n\n" +
                    "COLOSSENSES – 3:21");
        }
    }
}
