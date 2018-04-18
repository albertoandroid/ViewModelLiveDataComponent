package com.androiddesdecero.viewmodellivedata.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androiddesdecero.viewmodellivedata.R;
import com.androiddesdecero.viewmodellivedata.Sumar;
import com.androiddesdecero.viewmodellivedata.viewmodel.SumarViewModel;

public class ViewModelSumarActivity extends AppCompatActivity {

    private TextView tvSumar, tvSumarViewModel;
    private Button btSumar;

    private int numero;
    private SumarViewModel sumarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_sumar);
        configView();
    }
    private void configView(){
        sumarViewModel = ViewModelProviders.of(this).get(SumarViewModel.class);

        tvSumar = findViewById(R.id.videModelSumarActivityTvSumar);
        tvSumarViewModel = findViewById(R.id.videModelSumarActivityTvSumarViewModel);

        tvSumar.setText(" "+ numero);
        tvSumarViewModel.setText(" "+ sumarViewModel.getResultado());


        btSumar = findViewById(R.id.viewModelSumarActivityBtSumar);
        btSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero = Sumar.sumar(numero);
                tvSumar.setText(" "+ numero);
                sumarViewModel.setResultado(Sumar.sumar(sumarViewModel.getResultado()));
                tvSumarViewModel.setText(" "+ sumarViewModel.getResultado());
            }
        });
    }
}
