package com.example.apphistoria.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.apphistoria.Historia02Activity;
import com.example.apphistoria.R;

public class NovoFragment extends Fragment {

    private Button btHist017;
    private Button btHist018;
    private Button btHist019;
    private Button btHist020;
    private Button btHist021;
    private Button btHist022;
    private Button btHist023;
    private Button btHist024;
    private Button btHist025;
    private Button btHist026;
    private Button btHist027;
    private Button btHist028;
    private Button btHist029;
    private Button btHist030;

    public NovoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo, container, false);

        btHist017 = view.findViewById(R.id.btHist017);
        btHist017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 17); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist018 = view.findViewById(R.id.btHist018);
        btHist018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 18); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist019 = view.findViewById(R.id.btHist019);
        btHist019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 19); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist020 = view.findViewById(R.id.btHist020);
        btHist020.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 20); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist021 = view.findViewById(R.id.btHist021);
        btHist021.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 21); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist022 = view.findViewById(R.id.btHist022);
        btHist022.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 22); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist023 = view.findViewById(R.id.btHist023);
        btHist023.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 23); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist024 = view.findViewById(R.id.btHist024);
        btHist024.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 24); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist025 = view.findViewById(R.id.btHist025);
        btHist025.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 25); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist026 = view.findViewById(R.id.btHist026);
        btHist026.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 26); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist027 = view.findViewById(R.id.btHist027);
        btHist027.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 27); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist028 = view.findViewById(R.id.btHist028);
        btHist028.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 28); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist029 = view.findViewById(R.id.btHist029);
        btHist029.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 29); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        btHist030 = view.findViewById(R.id.btHist030);
        btHist030.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Historia02Activity.class);
                intent.putExtra("historia", 30); //PASSANDO VALOR PARA O BUNDLE
                startActivity(intent);
            }
        });

        return view;
    }

}
