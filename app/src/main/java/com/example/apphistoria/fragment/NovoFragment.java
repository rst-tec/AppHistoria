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


    public NovoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo, container, false);

        btHist001 = view.findViewById(R.id.btHist001);
        btHist001.setOnClickListener(new View.OnClickListener() {
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
