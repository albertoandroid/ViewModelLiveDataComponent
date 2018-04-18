package com.androiddesdecero.viewmodellivedata.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androiddesdecero.viewmodellivedata.R;

public class MainActivity extends AppCompatActivity {

    private Button btViewModelSumarActivity, btViewModelUserActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configView();
    }

    private void configView(){
        btViewModelSumarActivity = findViewById(R.id.mainActivityBtViewModelSumar);
        btViewModelSumarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ViewModelSumarActivity.class));
            }
        });

        btViewModelUserActivity = findViewById(R.id.mainActivityBtViewModelUser);
        btViewModelUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ViewModelUserActivity.class));
            }
        });
    }
}
