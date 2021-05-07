package com.example.apphistoria.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.apphistoria.Historia01Activity;
import com.example.apphistoria.R;

public class AntigoFragment extends Fragment {

    private Button btHist001;
    private Button btHist002;
    private Button btHist003;
    private Button btHist004;
    private Button btHist005;
    private Button btHist006;
    private Button btHist007;
    private Button btHist008;
    private Button btHist009;
    private Button btHist010;
    private Button btHist011;
    private Button btHist012;
    private Button btHist013;
    private Button btHist014;
    private Button btHist015;
    private Button btHist016;

    public AntigoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_antigo, container, false);

        btHist001 = view.findViewById(R.id.btHist001);
        btHist001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 1); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist002 = view.findViewById(R.id.btHist002);
        btHist002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 2); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist003 = view.findViewById(R.id.btHist003);
        btHist003.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 3); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist004 = view.findViewById(R.id.btHist004);
        btHist004.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 4); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist005 = view.findViewById(R.id.btHist005);
        btHist005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 5); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist006 = view.findViewById(R.id.btHist006);
        btHist006.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 6); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist007 = view.findViewById(R.id.btHist007);
        btHist007.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 7); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist008 = view.findViewById(R.id.btHist008);
        btHist008.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 8); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist009 = view.findViewById(R.id.btHist009);
        btHist009.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 9); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist010 = view.findViewById(R.id.btHist010);
        btHist010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 10); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist011 = view.findViewById(R.id.btHist011);
        btHist011.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 11); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist012 = view.findViewById(R.id.btHist012);
        btHist012.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 12); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist013 = view.findViewById(R.id.btHist013);
        btHist013.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 13); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist014 = view.findViewById(R.id.btHist014);
        btHist014.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 14); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist015 = view.findViewById(R.id.btHist015);
        btHist015.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 15); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist016 = view.findViewById(R.id.btHist016);
        btHist016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia01Activity.class);
                intent.putExtra("historia", 16); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        return view;
    }

}
