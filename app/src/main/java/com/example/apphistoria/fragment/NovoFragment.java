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

        return view;
    }

}
