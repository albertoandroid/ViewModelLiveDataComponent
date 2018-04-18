package com.androiddesdecero.viewmodellivedata.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androiddesdecero.viewmodellivedata.R;
import com.androiddesdecero.viewmodellivedata.User;
import com.androiddesdecero.viewmodellivedata.viewmodel.LiveDataUserViewModel;

import java.util.List;

public class LiveDataActivity extends AppCompatActivity {

    private TextView tvLiveData;
    private Button btSalvar;
    private int numero = 0;
    private LiveDataUserViewModel liveDataUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        configView();
    }
    private void configView(){
        liveDataUserViewModel = ViewModelProviders.of(this).get(LiveDataUserViewModel.class);
        tvLiveData = findViewById(R.id.liveDataTv);
        btSalvar = findViewById(R.id.liveDataBtSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numero == 0){
                    User user = new User();
                    user.setNombre("Alberto");
                    user.setEdad("30");
                    liveDataUserViewModel.addUser(user);
                }
                if(numero == 1){
                    User user = new User();
                    user.setNombre("Maria");
                    user.setEdad("23");
                    liveDataUserViewModel.addUser(user);
                }
                if(numero == 2){
                    User user = new User();
                    user.setNombre("Manuel");
                    user.setEdad("40");
                    liveDataUserViewModel.addUser(user);
                }
                numero++;
            }
        });

        final Observer<List<User>> listObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> userList) {
                String texto = "";
                for(int i=0; i<userList.size(); i++){
                    texto += userList.get(i).getNombre() + " " + userList.get(i).getEdad() +"\n";
                }
                tvLiveData.setText(texto);
            }
        };

        liveDataUserViewModel.getUserList().observe(this, listObserver);
    }
}
